package filter;

import event.InterestedInOffer;
import serviceComponents.Event;
import serviceComponents.Filter;

public class MinimumOfferedValueFilter implements Filter {
	private double minimumOfferedValue;

	public MinimumOfferedValueFilter(double value) {
		this.minimumOfferedValue = value;
	}

	@Override
	public boolean apply(Event e) {
		if(e instanceof InterestedInOffer)
			return apply((InterestedInOffer)e);
		return false;
	}

	private boolean apply(InterestedInOffer e) {
		if (e.getOfferedAmount() < this.minimumOfferedValue)
			return false;
		return true;
	}

}
