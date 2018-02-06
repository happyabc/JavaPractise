
package geym.akka.demo.transaction2;

import scala.concurrent.stm.Ref;
import scala.concurrent.stm.japi.STM;
import akka.actor.UntypedActor;
import akka.transactor.Coordinated;

public class CompanyActor extends UntypedActor {
    public static Ref.View<Integer> count = STM.newRef(100);
    
    @Override
    public void preStart() {
        
    }

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof Coordinated) {
            final Coordinated c=(Coordinated)msg;
            try{
                c.atomic(new Runnable() {                
                    @Override
                    public void run() {
                        STM.increment(count, 1);
                    }
                });
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if ("GetCount".equals(msg)) {
            getSender().tell(count.get(), getSelf());
        }else{
            unhandled(msg);
        }
    }
}
