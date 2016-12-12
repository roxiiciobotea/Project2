package filter;

import event.AbstractOffer;
import serviceComponents.Event;
import serviceComponents.Filter;
import serviceComponents.Producer;

public class OfferSourceFilter implements Filter {
	private Producer source;

	public OfferSourceFilter(Producer source) {
		this.source = source;
	}

	@Override
	public boolean apply(Event e) {
		if (e instanceof AbstractOffer) {
			AbstractOffer offer = (AbstractOffer) e;

			if (offer.getSource() != this.source)
				return false;
			return true;
		}
		return false;
	}
}
