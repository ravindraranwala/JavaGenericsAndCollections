package org.oreilly.books.chapter8;

import java.util.List;

public interface OrderProcessor {
	public void processOrders(List<? extends Order> orders);
}
