package event;

import java.util.Date;

import serviceComponents.Producer;

public class NewOffer extends AbstractOffer {

	public NewOffer(Producer source, Date dateAppeared, double price) {
		super("NEW_OFFER", source);
		this.dateAppeared = dateAppeared;
		this.price = price;
	}
}
