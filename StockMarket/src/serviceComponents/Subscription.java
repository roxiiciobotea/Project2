package serviceComponents;

import java.util.List;

public class Subscription {
	private Consumer consumer;
	private String eventType;
	private List<Filter> filters;

	public Subscription(Consumer consumer, String eventType, List<Filter> filters) {
		this.consumer = consumer;
		this.eventType = eventType;
		this.filters = filters;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public String getEventType() {
		return eventType;
	}

	public List<Filter> getFilters() {
		return filters;
	}
	
}
