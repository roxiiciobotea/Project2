package filter;

import components.Bidder;
import event.InterestedInOffer;
import serviceComponents.Event;
import serviceComponents.Filter;

public class InterestedBuyerFilter implements Filter {
	private Bidder offerSource;

	public InterestedBuyerFilter(Bidder offerSource) {
		this.offerSource = offerSource;
	}

	@Override
	public boolean apply(Event e) {
		if (e instanceof InterestedInOffer) {
			InterestedInOffer event = (InterestedInOffer) e;
			if (event.getOfferSource() != this.offerSource)
				return false;
			return true;
		}
		return false;
	}

}
