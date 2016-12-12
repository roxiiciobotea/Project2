package filter;

import event.AbstractOffer;
import serviceComponents.Event;
import serviceComponents.Filter;

public class PriceRangeFilter implements Filter {
	private double minPrice;
	private double maxPrice;

	public PriceRangeFilter(double min, double max) {
		this.minPrice = min;
		this.maxPrice = max;
	}

	@Override
	public boolean apply(Event e) {
		if (e instanceof AbstractOffer){
			AbstractOffer offer = (AbstractOffer) e;
			
			if (offer.getPrice() < minPrice || offer.getPrice() > maxPrice)
				return false;
			return true;
		}
		return false;
	}

	// private boolean apply(AbstractOffer e) {
	// if (e.getPrice() < minPrice || e.getPrice() > maxPrice)
	// return false;
	// return true;
	// }

}
