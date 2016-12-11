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
		if (e instanceof AbstractOffer)
			return apply((AbstractOffer) e);
		return false;
	}

	private boolean apply(AbstractOffer e) {
		if (e.getDateAppeared().compareTo(this.minimumDate) <= 0) {
			return false;
		}
		return true;
	}
}
