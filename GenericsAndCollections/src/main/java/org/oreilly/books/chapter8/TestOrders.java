package org.oreilly.books.chapter8;

import java.util.List;

public class TestOrders {

	public static void main(String[] args) {
		NaiveBroker naiveBroker = new NaiveBroker();
		// Does not catch errors
		final DeviousSupplier deviousSupplier = new DeviousSupplier();
		final SimpleOrderProcessor simpleProcessor = new SimpleOrderProcessor();
		naiveBroker.connect(deviousSupplier, simpleProcessor);
		// Catches errors at runtime using checked collection of a reifiable type.
		new WaryBroker().connect(deviousSupplier, simpleProcessor);
	}

	static class SimpleOrderProcessor implements OrderProcessor {

		@Override
		public void processOrders(List<? extends Order> orders) {
			System.out.println("Processing Order ...");

		}

	}
}
