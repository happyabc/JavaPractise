package geym.akka.demo.worker;

import akka.actor.*;
import akka.cluster.Cluster;
import akka.contrib.pattern.ClusterClient;
import akka.contrib.pattern.ClusterSingletonManager;
import com.typesafe.config.Config;
import com.typesafe.config.ConfigFactory;
import scala.concurrent.duration.Duration;
import scala.concurrent.duration.FiniteDuration;

import java.util.HashSet;
import java.util.Set;

public class Main {
	/**
	 * 
	 * @param args 指定要开启的功能
	 * @throws InterruptedException
	 */
	public static void main(String[] args) throws InterruptedException {
		
		if(args.length==0){
			Address joinAddress = startBackend(null, "backend");
			// startBackend(joinAddress, "backend");
			startWorker(joinAddress);
			startFrontend(joinAddress);
		}else{
			if(args[0].equals("backend")){
				startBackend(null, "backend");
			}else if(args[0].equals("worker")){
				Address joinAddr=Address.apply("akka.tcp", systemName,"192.168.1.123",54123);
				startWorker(joinAddr);
			}else if(args[0].equals("frontend")){
				Address joinAddr=Address.apply("akka.tcp", systemName,"192.168.1.123",54123);
				startFrontend(joinAddr);
			}
		}
	}

	private static String systemName = "Workers";
	private static FiniteDuration workTimeout = Duration.create(10, "seconds");

	public static Address startBackend(Address joinAddress, String role) {
		Config conf = ConfigFactory.parseString(
				"akka.cluster.roles=[" + role + "]").withFallback(
				ConfigFactory.load("sampleworker.conf"));
		ActorSystem system = ActorSystem.create(systemName, conf);
		Address realJoinAddress = (joinAddress == null) ? Cluster.get(system)
				.selfAddress() : joinAddress;
		Cluster.get(system).join(realJoinAddress);

		ActorRef me = system.actorOf(ClusterSingletonManager.defaultProps(
				Master.props(workTimeout), "active", PoisonPill.getInstance(),
				role), "master");
		return realJoinAddress;
	}

	public static void startWorker(Address contactAddress) {
		Config conf = ConfigFactory
				.parseString("akka{remote.netty.tcp.port = 54124}").withFallback(
						ConfigFactory.load("sampleworker.conf"));
		ActorSystem system = ActorSystem.create(systemName, conf);
		Set<ActorSelection> initialContacts = new HashSet<ActorSelection>();
		initialContacts.add(system.actorSelection(contactAddress
				+ "/user/receptionist"));
		ActorRef clusterClient = system.actorOf(
				ClusterClient.defaultProps(initialContacts), "clusterClient");
		system.actorOf(
				Worker.props(clusterClient, Props.create(WorkExecutor.class)),
				"worker");
	}

	public static void startFrontend(Address joinAddress) {
		Config conf = ConfigFactory
				.parseString("akka{remote.netty.tcp.port = 54125}").withFallback(
						ConfigFactory.load("sampleworker.conf"));
		ActorSystem system = ActorSystem.create(systemName, conf);
		Cluster.get(system).join(joinAddress);
		ActorRef frontend = system.actorOf(Props.create(Frontend.class),
				"frontend");
		System.out.println(frontend);
		ActorRef e = system.actorOf(Props.create(WorkProducer.class, frontend),
				"producer");
		System.out.println(e);
		system.actorOf(Props.create(WorkResultConsumer.class), "consumer");
	}
}
