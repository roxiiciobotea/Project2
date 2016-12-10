package components;

import event.EventType;
import eventComponents.Consumer;
import eventComponents.Event;
import eventComponents.Producer;

public class Buyer implements Consumer, Producer {
	private String name;
	private double offeredAmount;

	public Buyer(String name) {
		this.name = name;
	}
	
	public Event inform(Event e) {
		return e;
	}

	public Event interestedInOffer(Offer o) {
		return new Event(EventType.INTERESTED_BUYER.toString());
	}

	public double getOfferedAmount() {
		return offeredAmount;
	}

	public void setOfferedAmount(double offeredAmount) {
		this.offeredAmount = offeredAmount;
	}

	public String getName() {
		return name;
	}

}
