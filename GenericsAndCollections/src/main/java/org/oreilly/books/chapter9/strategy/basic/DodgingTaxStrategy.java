package org.oreilly.books.chapter9.strategy.basic;

class DodgingTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {
	@Override
	public long computeTax(P payer) {
		return 0;
	}
}
