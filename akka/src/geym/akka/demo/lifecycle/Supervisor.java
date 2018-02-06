
package geym.akka.demo.lifecycle;

import java.util.concurrent.TimeUnit;

import scala.concurrent.duration.Duration;
import akka.actor.OneForOneStrategy;
import akka.actor.Props;
import akka.actor.SupervisorStrategy;
import akka.actor.SupervisorStrategy.Directive;
import akka.actor.UntypedActor;
import akka.japi.Function;

public class Supervisor extends UntypedActor {
    /**
     * When the supervisor strategy is not defined for an actor the following exceptions are handled by default:
        - ActorInitializationException will stop the failing child actor
        - ActorKilledException will stop the failing child actor
        - Exception will restart the failing child actor
        - Other types of Throwable will be escalated to parent actor
     */
    private static SupervisorStrategy strategy = new OneForOneStrategy(3, Duration.create(1, TimeUnit.MINUTES),
            new Function<Throwable, Directive>() {
                @Override
                public Directive apply(Throwable t) {
                    if (t instanceof ArithmeticException) {
                        System.out.println("meet ArithmeticException,just resume");
                        return SupervisorStrategy.resume();
                    } else if (t instanceof NullPointerException) {
                    	System.out.println("meet NullPointerException,restart");
                        return SupervisorStrategy.restart();
                    } else if (t instanceof IllegalArgumentException) {
                        return SupervisorStrategy.stop();
                    } else {
                        return SupervisorStrategy.escalate();
                    }
                }
            });

    @Override
    public SupervisorStrategy supervisorStrategy() {
        return strategy;
    }

    public void onReceive(Object o) {
        if (o instanceof Props) {
            getContext().actorOf((Props) o,"restartActor");
        } else {
            unhandled(o);
        }
    }
}
