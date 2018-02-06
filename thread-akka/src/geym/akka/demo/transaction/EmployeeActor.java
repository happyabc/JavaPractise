
package geym.akka.demo.transaction;

import scala.concurrent.Future;
import scala.concurrent.stm.Ref;
import scala.concurrent.stm.japi.STM;
import akka.actor.UntypedActor;
import akka.agent.Agent;
import akka.dispatch.Mapper;
import akka.transactor.Coordinated;

public class EmployeeActor extends UntypedActor {
    private Ref.View<Integer> count = STM.newRef(50);

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof Coordinated) {
            final Coordinated c = (Coordinated) msg;
            final int downCount = (Integer) c.getMessage();
            try {
                c.atomic(new Runnable() {
                    @Override
                    public void run() {
                        STM.increment(count, downCount);
                    }
                });
            } catch (Exception e) {
            }
        } else if ("GetCount".equals(msg)) {
            getSender().tell(count.get(), getSelf());
        } else {
            unhandled(msg);
        }
    }
}
