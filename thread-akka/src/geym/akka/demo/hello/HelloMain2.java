package geym.akka.demo.hello;

import java.io.FileReader;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.actor.Terminated;
import akka.actor.UntypedActor;
import akka.event.Logging;
import akka.event.LoggingAdapter;

import com.typesafe.config.ConfigFactory;

public class HelloMain2 {

  public static void main(String[] args) {
	ActorSystem system = ActorSystem.create("Hello", ConfigFactory.load("samplehello.conf"));
    ActorRef hello = system.actorOf(Props.create(HelloWorld.class), "helloWorld");
    System.out.println("HelloWorld Actor Path:"+hello.path());
    ActorRef t=system.actorOf(Props.create(Terminator.class, hello), "terminator");
    System.out.println("Terminator Actor Path:"+t.path());
  }

  public static class Terminator extends UntypedActor {

    private final LoggingAdapter log = Logging.getLogger(getContext().system(), this);
    private final ActorRef ref;

    public Terminator(ActorRef ref) {
      this.ref = ref;
      getContext().watch(ref);
    }

    @Override
    public void onReceive(Object msg) {
      if (msg instanceof Terminated) {
        System.out.println(ref.path()+" is has terminated,shutting down system");
        getContext().system().shutdown();
      } else {
        unhandled(msg);
      }
    }
  }
}
