package geym.akka.demo.selectactor;

import java.util.ArrayList;
import java.util.List;

import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.ConfigFactory;

public class SelectMain {
  public static final int WORDER_COUNT=1000;
  public static List<ActorRef> workers=new ArrayList<ActorRef>(WORDER_COUNT);
  public static void main(String[] args) {
	ActorSystem system = ActorSystem.create("SelectSystem", ConfigFactory.load("samplehello.conf"));
	for(int i=0;i<WORDER_COUNT;i++){
	    workers.add(system.actorOf(Props.create(MyWorker.class,i), "worker_"+i));
	}
	ActorRef m= system.actorOf(Props.create(Master.class), "master");
	
  }
}
