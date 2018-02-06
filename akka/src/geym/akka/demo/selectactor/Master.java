
package geym.akka.demo.selectactor;

import geym.akka.demo.selectactor.MyWorker.Msg;

import java.util.concurrent.atomic.AtomicInteger;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class Master extends UntypedActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private AtomicInteger closeCount=new AtomicInteger(0);
    @Override
    public void preStart(){
        for(ActorRef ar:SelectMain.workers){
            getContext().watch(ar);
        }
        ActorSelection selection = getContext().actorSelection("/user/worker_*");
        selection.tell(5, getSelf());
    }
    
    @Override
    public void onReceive(Object msg) {
        if (msg instanceof Integer) {
           System.out.println(getSender()+":"+msg);
           getSender().tell(Msg.CLOSE, getSelf());
        } else if (msg instanceof Terminated) {
            if(closeCount.incrementAndGet() == SelectMain.WORDER_COUNT){
                log.info("master will shutdown");
                getContext().stop(getSelf());
                getContext().system().shutdown();
            }
        } else
            unhandled(msg);
    }

}
