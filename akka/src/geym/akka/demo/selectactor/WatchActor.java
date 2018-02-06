
package geym.akka.demo.selectactor;

import akka.actor.ActorRef;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

public class WatchActor extends UntypedActor {
    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private final ActorRef ref;

    public WatchActor(ActorRef ref) {
      this.ref = ref;
      getContext().watch(ref);
    }

    @Override
    public void onReceive(Object msg) {
      if (msg instanceof Terminated) {
        log.info("{} has terminated, shutting down system", ref.path());
        getContext().system().shutdown();
      } else {
        unhandled(msg);
      }
    }
}
