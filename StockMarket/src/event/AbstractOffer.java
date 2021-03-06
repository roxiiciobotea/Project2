package event;

import java.util.Date;

import serviceComponents.Event;
import serviceComponents.Producer;

public abstract class AbstractOffer extends Event {
	protected Date dateAppeared;
	protected double price;
	protected Producer source;

	public AbstractOffer(String type, Producer source) {
		super(type);
		this.source = source;
	}

	public Date getDateAppeared() {
		return this.dateAppeared;
	}

	public double getPrice() {
		return this.price;
	}

	public Producer getSource() {
		return this.source;
	}
}
