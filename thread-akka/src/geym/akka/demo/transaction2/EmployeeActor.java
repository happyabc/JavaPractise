
package geym.akka.demo.transaction2;

import scala.concurrent.Future;
import scala.concurrent.stm.Ref;
import scala.concurrent.stm.japi.STM;
import akka.actor.UntypedActor;
import akka.agent.Agent;
import akka.dispatch.Mapper;
import akka.transactor.Coordinated;

public class EmployeeActor extends UntypedActor {

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
                        STM.increment(CompanyActor.count, 1);
                    }
                });
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if ("GetCount".equals(msg)) {
            getSender().tell(CompanyActor.count.get(), getSelf());
        }else{
            unhandled(msg);
        }
    }
}
