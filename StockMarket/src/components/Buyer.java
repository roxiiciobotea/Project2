package components;

import service.Dispatcher;
import serviceComponents.Consumer;
import serviceComponents.Event;
import serviceComponents.Producer;

public class Buyer implements Consumer, Producer {
	private String name; // Buyer name
	private double offeredAmount; // the amount the Buyer is offering for an
									// Offer

	public Buyer(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public double getOfferedAmount() {
		return offeredAmount;
	}

	public void setOfferedAmount(double offeredAmount) {
		this.offeredAmount = offeredAmount;
	}

	/** Buyer is informed about an event */
	public void inform(Event e, Producer p) {
		// handle event
	}

	/** Buyer is intrested in an offer */
	public void interestedInOffer(Offer o) {
		Dispatcher.instance().publish(new Event("INTERESTED_BUYER"), this);
	}

}
