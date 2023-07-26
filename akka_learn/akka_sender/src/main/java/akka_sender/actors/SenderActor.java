package akka_sender.actors;

import java.util.concurrent.TimeUnit;

import akka.actor.AbstractActor;
import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import akka.pattern.Patterns;
import akka.util.Timeout;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class SenderActor extends AbstractActor {

	private final ActorSelection receiverActor;
	private final int waitTime;

	public SenderActor() {
		ActorSystem system = getContext().getSystem();
		this.receiverActor = system.actorSelection("akka.tcp://ReceiverSystem@localhost:2553/user/receiver");
		this.waitTime = 5;
	}

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(String.class, message -> {

			System.out.println("Sender actor : " + message);
			Timeout timeout = new Timeout(Duration.create(waitTime, TimeUnit.SECONDS));
			Future<Object> future = (Future<Object>) Patterns.ask(receiverActor, message, timeout);
			String result = (String) Await.result(future, timeout.duration());
			System.out.println("Received response: " + result);
		}).build();
	}

}
