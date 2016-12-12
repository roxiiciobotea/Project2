package filter;

import java.util.Date;

import event.AbstractOffer;
import serviceComponents.Event;
import serviceComponents.Filter;

public class MinimumAppearedDateFilter implements Filter {
	private Date minimumDate;

	public MinimumAppearedDateFilter(Date minimumDate) {
		this.minimumDate = minimumDate;
	}

	@Override
	public boolean apply(Event e) {
		if (e instanceof AbstractOffer) {
			AbstractOffer offer = (AbstractOffer) e;

			if (offer.getDateAppeared().compareTo(this.minimumDate) <= 0)
				return false;
			return true;
		}
		return false;
	}
}
