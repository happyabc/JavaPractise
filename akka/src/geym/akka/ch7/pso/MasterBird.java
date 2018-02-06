
package geym.akka.ch7.pso;

import geym.akka.ch7.pso.msg.GBestMsg;
import geym.akka.ch7.pso.msg.PBestMsg;
import akka.actor.ActorSelection;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class MasterBird extends UntypedActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private PsoValue gBest=null;
    
    @Override
    public void onReceive(Object msg) {
        if (msg instanceof PBestMsg) {
        	PsoValue pBest = ((PBestMsg) msg).getValue();
        	if(gBest==null || gBest.value < pBest.value){
        		//更新全局最优，通知所有粒子
        		System.out.println(msg+"\n");
        		gBest=pBest;
        		ActorSelection selection = getContext().actorSelection("/user/bird_*");
        		selection.tell(new GBestMsg(gBest), getSelf());
        	}
        }
        else{
            unhandled(msg);
        }
    }
}
