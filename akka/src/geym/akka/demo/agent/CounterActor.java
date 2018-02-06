
package geym.akka.demo.agent;

import scala.concurrent.Future;
import akka.actor.UntypedActor;
import akka.agent.Agent;
import akka.dispatch.Mapper;

public class CounterActor extends UntypedActor {
    Mapper addMapper = new Mapper<Integer, Integer>() {
        @Override
        public Integer apply(Integer i) {
            return i+1;
        }
    };

    @Override
    public void onReceive(Object msg) {
        if (msg instanceof Integer) {
            for (int i = 0; i < 10000; i++) {
                //只是入队，并不会执行完成才返回，
                //即使Actor终止，未完成的任务还会继续
//                ((Agent) msg).send(addMapper);
                
                //所以我希望能够知道future何时结束
                Future<Integer> f = AgentDemo.counterAgent.alter(addMapper);
                AgentDemo.futures.add(f);
            }
            getContext().stop(getSelf());
        } else
            unhandled(msg);
    }
}
