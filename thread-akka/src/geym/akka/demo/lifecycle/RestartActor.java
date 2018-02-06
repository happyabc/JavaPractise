
package geym.akka.demo.lifecycle;

import scala.Option;
import akka.actor.UntypedActor;

/**
 * The method preStart() of an actor is only called once directly during the initialization of the first instance,
that is, at creation of its ActorRef. In the case of restarts, preStart() is called from postRestart(),
therefore if not overridden, preStart() is called on every incarnation. However, overriding postRestart()
one can disable this behavior, and ensure that there is only one call to preStart().
 * @author Geym
 *
 */
public class RestartActor extends UntypedActor {
    public enum Msg {
        DONE, RESTART
    }

    @Override
    public void preStart() {
        System.out.println("preStart hashcode:" + this.hashCode());
    }

    @Override
    public void postStop() {
        System.out.println("postStop hashcode:" + this.hashCode());
    }

    @Override
    public void postRestart(Throwable reason) throws Exception {
        super.postRestart(reason);
        System.out.println("postRestart hashcode:" + this.hashCode());
    }
    
    @Override
    public void preRestart(Throwable reason,Option opt) throws Exception {
        System.out.println("preRestart hashcode:" + this.hashCode());
    }
    
    @Override
    public void onReceive(Object msg) {
        if (msg == Msg.DONE) {
            getContext().stop(getSelf());
        } else if (msg == Msg.RESTART) {
        	System.out.println(((Object)null).toString());
            //抛出异常 默认会被restart
            double a = 0 / 0;
        }
        unhandled(msg);
    }
}
