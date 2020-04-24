package org.oreilly.books.chapter9.strategy.basic;

class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {
	@Override
	public long computeTax(Trust trust) {
		return trust.isNonProfit() ? 0 : super.computeTax(trust);
	}
}
