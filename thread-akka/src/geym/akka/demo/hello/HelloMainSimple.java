package geym.akka.demo.hello;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.ConfigFactory;

public class HelloMainSimple {
	public static void main(String[] args) {
		ActorSystem system = ActorSystem.create("Hello",ConfigFactory.load("samplehello.conf"));
		ActorRef a = system.actorOf(Props.create(HelloWorld.class),"helloWorld");
		System.out.println("HelloWorld Actor Path:" + a.path());
	}
}
