
package geym.akka.demo.transaction2;

import static akka.pattern.Patterns.ask;
import geym.akka.demo.transaction2.CompanyActor;

import java.util.concurrent.TimeUnit;

import scala.concurrent.Await;
import akka.actor.ActorRef;
import akka.actor.ActorSystem;
import akka.actor.Props;
import akka.transactor.Coordinated;
import akka.util.Timeout;

import com.typesafe.config.ConfigFactory;

public class STMDemo {
    public final static ActorRef[] company=new ActorRef[10];
    static final Timeout timeout = new Timeout(10, TimeUnit.SECONDS);
    
    static class TellThread implements Runnable{
        int index;
        public TellThread(int i){
            this.index=i;
        }
        public void run(){
            for(int i=0;i<100000;i++){
                company[index].tell(new Coordinated(i, timeout), ActorRef.noSender());
            }
        }
    }
    public static void main(String[] args) throws Exception {
        final ActorSystem system = ActorSystem.create("transactionDemo", ConfigFactory.load("samplehello.conf"));
        for(int i=0;i<company.length;i++){
            company[i]=system.actorOf(Props.create(CompanyActor.class), "company_"+i);
        }
        Thread[] t=new Thread[10];
        for(int i=0;i<company.length;i++){
           t[i]=new Thread(new TellThread(i));
           t[i].start();
        }
        for(int i=0;i<company.length;i++){
            t[i].join();
        }
        
        
        Thread.sleep(5000);
        Integer companyCount = (Integer) Await.result(
                ask(company[0], "GetCount", timeout), timeout.duration());
        System.out.println(companyCount);
    }
}
