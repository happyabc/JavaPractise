
package geym.akka.demo.dead;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyWorker extends UntypedActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    public static enum Msg {
        WORKING, DONE,CLOSE;
    }
    @Override
    public void preStart(){
    	System.out.println("MyWorker is starting");
    }
    @Override
    public void postStop(){
    	System.out.println("MyWorker is stopping");
    }
    @Override
    public void onReceive(Object msg) {
        if (msg == Msg.WORKING) {
        	System.out.println("I am working");
        }
        if (msg == Msg.DONE) {
        	System.out.println("Stop working");
        }if (msg == Msg.CLOSE) {
        	System.out.println("I will shutdown");
            getSender().tell(Msg.CLOSE, getSelf());
            getContext().stop(getSelf());
        } else
            unhandled(msg);
    }
}
