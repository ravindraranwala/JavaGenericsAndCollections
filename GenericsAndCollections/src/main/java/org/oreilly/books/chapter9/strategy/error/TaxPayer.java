package org.oreilly.books.chapter9.strategy.error;

//not well-typed!
abstract class TaxPayer<P extends TaxPayer<P>> {
	private TaxStrategy<P> strategy;

	public long computeTax() {
		// compile-time error
		// return strategy.computeTax(this);
		return 1;
	}
}
