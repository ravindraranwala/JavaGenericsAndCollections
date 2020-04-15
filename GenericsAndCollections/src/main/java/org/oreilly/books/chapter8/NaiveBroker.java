package org.oreilly.books.chapter8;

import java.util.ArrayList;
import java.util.List;

public class NaiveBroker {
	public void connect(OrderSupplier supplier, OrderProcessor processor) {
		List<AuthenticatedOrder> orders = new ArrayList<AuthenticatedOrder>();
		supplier.addOrders(orders);
		processor.processOrders(orders);
	}
}
