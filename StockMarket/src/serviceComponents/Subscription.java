package serviceComponents;

public class Subscription {
	private Consumer consumer;
	private String eventType;
	private Filter filter;

	public Subscription(Consumer consumer, String eventType, Filter filter) {
		this.consumer = consumer;
		this.eventType = eventType;
		this.filter = filter;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public String getEventType() {
		return eventType;
	}

	public Filter getFilter() {
		return filter;
	}
	
}
