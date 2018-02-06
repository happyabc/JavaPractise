package geym.akka.demo.lifecycle;

import akka.actor.ActorRef;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.actor.Props;

import com.typesafe.config.ConfigFactory;

public class LifecycleSample {

    /**
     * 默认ArithmeticException 会导致Actor重启，实例更新
     * @param system
     */
  public static void defaultStrategy(ActorSystem system){
      ActorRef a = system.actorOf(Props.create(RestartActor.class), "RestartActor");
      a.tell(RestartActor.Msg.RESTART, ActorRef.noSender());
      a.tell(RestartActor.Msg.RESTART, ActorRef.noSender());
  }
  
  public static void customStrategy(ActorSystem system){
      ActorRef a = system.actorOf(Props.create(Supervisor.class), "Supervisor");
      a.tell(Props.create(RestartActor.class), ActorRef.noSender());
      
      ActorSelection  sel=system.actorSelection("akka://lifecycle/user/Supervisor/restartActor");
      
      for(int i=0;i<100;i++){
          sel.tell(RestartActor.Msg.RESTART, ActorRef.noSender());
//          try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {}
      }
  }
  
  public static void main(String[] args) {
	ActorSystem system = ActorSystem.create("lifecycle", ConfigFactory.load("lifecycle.conf"));
//	defaultStrategy(system);
	customStrategy(system);
  }

}
