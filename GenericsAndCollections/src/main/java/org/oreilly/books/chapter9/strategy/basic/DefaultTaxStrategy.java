package org.oreilly.books.chapter9.strategy.basic;

class DefaultTaxStrategy<P extends TaxPayer> implements TaxStrategy<P> {
	private static final double RATE = 0.40;

	@Override
	public long computeTax(P payer) {
		return Math.round(payer.getIncome() * RATE);
	}
}
