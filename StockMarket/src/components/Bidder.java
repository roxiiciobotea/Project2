package components;

import java.util.Date;

import event.AbstractOffer;
import event.ModifiedOffer;
import event.NewOffer;
import service.Dispatcher;
import serviceComponents.Consumer;
import serviceComponents.Event;
import serviceComponents.Producer;

public class Bidder implements Producer, Consumer {
	private String name; // bidder name
	private AbstractOffer crtOffer; // current offer

	public Bidder(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	/** Bidder is informed about an event */
	public void inform(Event e, Producer p) {
		System.out.println(this + ": I was informed about " + e + " from " + p);
	}

	/** Bidder issues a new offer */
	public void issueOffer(Date dateCreated, double price) {
		this.crtOffer = new NewOffer(this, dateCreated, price);
		Dispatcher.instance().publish(crtOffer, this);
	}

	/** Bidder modifies an offer */
	public void modifyOffer(Date dateModified, double newPrice) {
		crtOffer = new ModifiedOffer(this, crtOffer, dateModified, newPrice);
		Dispatcher.instance().publish(crtOffer, this);
	}

	public String toString() {
		return "bidder " + this.name;
	}
}
