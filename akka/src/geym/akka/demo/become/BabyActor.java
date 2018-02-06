
package geym.akka.demo.become;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;
import akka.japi.Procedure;

public class BabyActor extends UntypedActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    public static enum Msg {
        SLEEP, PLAY, CLOSE;
    }

    Procedure<Object> angry = new Procedure<Object>() {
        @Override
        public void apply(Object message) {
        	System.out.println("angryApply:"+message);
            if (message == Msg.SLEEP) {
                getSender().tell("I am already angry", getSelf());
                System.out.println("I am already angry");
            } else if (message == Msg.PLAY) {
                System.out.println("I like playing");
                getContext().become(happy);
            }
        }
    };

    Procedure<Object> happy = new Procedure<Object>() {
        @Override
        public void apply(Object message) {
        	System.out.println("happyApply:"+message);
            if (message == Msg.PLAY) {
                getSender().tell("I am already happy :-)", getSelf());
                System.out.println("I am already happy :-)");
            } else if (message == Msg.SLEEP) {
                System.out.println("I don't want to sleep");
                getContext().become(angry);
            }
        }
    };

    @Override
    public void onReceive(Object msg) {
        System.out.println("onReceive:"+msg);
        if (msg == Msg.SLEEP) {
            getContext().become(angry);
        } else if (msg == Msg.PLAY) {
            getContext().become(happy);
        } else {
            unhandled(msg);
        }
    }
}
