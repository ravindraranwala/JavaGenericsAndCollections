package org.oreilly.books.chapter8;

import java.util.List;

public class DeviousSupplier implements OrderSupplier {

	@Override
	public void addOrders(List<AuthenticatedOrder> orders) {
		List raw = orders;
		Order order = new Order(); // not authenticated
		raw.add(order); // unchecked call
	}
}
