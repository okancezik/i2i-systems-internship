package akka_receiver.actors;

import akka.actor.AbstractActor;

public class ReceiverActor extends AbstractActor {

	@Override
	public Receive createReceive() {
		return receiveBuilder().match(String.class, message -> {

			System.out.println("Received message : " + message);
			
            getSender().tell("Hi sender from receiver actor.", getSelf());
		}).build();
	}

}
