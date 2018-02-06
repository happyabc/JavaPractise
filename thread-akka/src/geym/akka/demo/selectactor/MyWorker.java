
package geym.akka.demo.selectactor;

import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MyWorker extends UntypedActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private int baseValue=0;
    public static enum Msg {
        WORKING, DONE, CLOSE;
    }
    public MyWorker(int baseValue){
        this.baseValue=baseValue;
    }
    @Override
    public void onReceive(Object msg) {
        if (msg instanceof Integer) {
            int i=(Integer)msg;
            getSender().tell(i*i*baseValue, getSelf());
        } else if (msg == Msg.CLOSE) {
            log.info("I will shutdown");
            getSender().tell(Msg.CLOSE, getSelf());
            getContext().stop(getSelf());
        } else
            unhandled(msg);
    }

}
