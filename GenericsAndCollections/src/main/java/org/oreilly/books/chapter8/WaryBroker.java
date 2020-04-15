package org.oreilly.books.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaryBroker {
	public void connect(OrderSupplier supplier, OrderProcessor processor) {
		List<AuthenticatedOrder> orders = new ArrayList<AuthenticatedOrder>();
		supplier.addOrders(Collections.checkedList(orders, AuthenticatedOrder.class));
		processor.processOrders(orders);
	}
}
