package event;

import java.util.Date;

import serviceComponents.Producer;

public class ModifiedOffer extends AbstractOffer {
	private Date dateModified;

	public ModifiedOffer(Producer source, AbstractOffer offer, Date dateModified, double newPrice) {
		super("MODIFIED_OFFER", source);
		this.dateAppeared = offer.getDateAppeared();
		this.price = newPrice;
		this.dateModified = dateModified;
	}

	public Date getDateModified() {
		return dateModified;
	}
}
