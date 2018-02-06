package geym.akka.demo.hello;

import akka.actor.Props;
import akka.actor.UntypedActor;
import akka.actor.ActorRef;

public class HelloWorld extends UntypedActor {
	ActorRef greeter;

	@Override
	public void preStart() {
		greeter = getContext().actorOf(Props.create(Greeter.class), "greeter");
		System.out.println("Greeter Actor Path:" + greeter.path());
		greeter.tell(Greeter.Msg.GREET, getSelf());
	}

	@Override
	public void onReceive(Object msg) {
		if (msg == Greeter.Msg.DONE) {
			greeter.tell(Greeter.Msg.GREET, getSelf());
			getContext().stop(getSelf());
		} else
			unhandled(msg);
	}
}
