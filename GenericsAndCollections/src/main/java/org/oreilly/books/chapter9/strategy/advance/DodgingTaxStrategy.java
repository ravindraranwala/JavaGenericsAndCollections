package org.oreilly.books.chapter9.strategy.advance;

public class DodgingTaxStrategy<P extends TaxPayer<P>> implements TaxStrategy<P> {
	@Override
	public long computeTax(P p) {
		return 0;
	}
}
