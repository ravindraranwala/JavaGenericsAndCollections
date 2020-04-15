package org.oreilly.books.chapter8;

import java.util.List;

public interface OrderSupplier {
	public void addOrders(List<AuthenticatedOrder> orders);
}
