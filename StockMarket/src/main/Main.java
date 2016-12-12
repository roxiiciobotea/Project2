package main;

import java.sql.Date;
import java.util.Arrays;

import components.*;
import filter.*;
import service.Dispatcher;
import serviceComponents.Filter;

public class Main {
	public static void main(String[] args) {
		Dispatcher d = Dispatcher.instance();

		Bidder ibm = new Bidder("IBM");
		Bidder apple = new Bidder("Apple");
		Bidder microsoft = new Bidder("Microsoft");

		Buyer jhonSmith = new Buyer("Jhon Smith");
		Buyer mikeWaters = new Buyer("Mike Waters");
		Buyer charlesTick = new Buyer("Charles Tick");
		Buyer samHamilton = new Buyer("Sam Hamilton");

		// subscribes to new offers from microsoft with the price between 50-100
		d.subscribe(jhonSmith, "NEW_OFFER",
				Arrays.asList(new OfferSourceFilter(microsoft), new PriceRangeFilter(50, 100)));
		// subscribes to all modified offers from microsoft
		d.subscribe(jhonSmith, "MODIFIED_OFFER", Arrays.asList(new OfferSourceFilter(microsoft)));

		// subscribes to all new offers appeared after 2016-12-1
		d.subscribe(mikeWaters, "NEW_OFFER", Arrays.asList(new MinimumAppearedDateFilter(Date.valueOf("2016-12-1"))));

		// subscribes to all new offers from apple
		d.subscribe(charlesTick, "NEW_OFFER", Arrays.asList(new OfferSourceFilter(apple)));
		// subscribes to all modified offers which were modified after
		// 2016-12-10 and with the price between 50-80
		d.subscribe(charlesTick, "MODIFIED_OFFER",
				Arrays.asList(new MinimumModifiedDateFilter(Date.valueOf("2016-12-10")), new PriceRangeFilter(50, 80)));

		// subscribes to all new offers with the price between 80-120
		d.subscribe(samHamilton, "NEW_OFFER", Arrays.asList(new PriceRangeFilter(80, 120)));
		// subscribes to all modified offers with the price between 75-100
		d.subscribe(samHamilton, "MODIFIED_OFFER", Arrays.asList(new PriceRangeFilter(75, 100)));

		//subscribes to all buyers interested by his offer with a minimum offer of 60
		d.subscribe(ibm, "INTERESTED_BUYER",
				Arrays.asList(new InterestedBuyerFilter(ibm), new MinimumOfferedValueFilter(60)));
		//subscribes to all buyers interested by his offer with a minimum offer of 150
		d.subscribe(apple, "INTERESTED_BUYER",
				Arrays.asList(new InterestedBuyerFilter(apple), new MinimumOfferedValueFilter(150)));
		//subscribes to all buyers interested by his offer
		d.subscribe(microsoft, "INTERESTED_BUYER", Arrays.asList(new InterestedBuyerFilter(microsoft)));

		// notifies Mike Waters
		ibm.issueOffer(Date.valueOf("2016-12-10"), 200);
		// notifies Jhon Smith & Sam Hamilton
		microsoft.issueOffer(Date.valueOf("2016-12-01"), 80);
		// notifies Mike Waters & Sam Hamilton
		microsoft.issueOffer(Date.valueOf("2016-12-02"), 110);
		// notifies Jhon Smith & Sam Hamilton
		microsoft.modifyOffer(Date.valueOf("2016-12-03"), 95);
		// notifies Mike Waters & Charles Tick
		apple.issueOffer(Date.valueOf("2016-12-04"), 180);
		// notfies Jhon Smith, Charles Tick & Sam Hamilton
		microsoft.modifyOffer(Date.valueOf("2016-12-11"), 75);
		// doesn't inform anyone
		apple.modifyOffer(Date.valueOf("2016-12-06"), 70);

		jhonSmith.interestedInOffer(microsoft, Date.valueOf("2016-12-12"), 60);
		mikeWaters.interestedInOffer(apple, Date.valueOf("2016-12-11"), 90); //not notified bc of filter
		charlesTick.interestedInOffer(apple, Date.valueOf("2016-12-12"), 125);
		samHamilton.interestedInOffer(ibm, Date.valueOf("2016-12-10"), 180);
	}
}
