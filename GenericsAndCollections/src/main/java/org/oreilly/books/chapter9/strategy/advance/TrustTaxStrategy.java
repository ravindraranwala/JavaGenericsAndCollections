package org.oreilly.books.chapter9.strategy.advance;

public class TrustTaxStrategy extends DefaultTaxStrategy<Trust> {
	@Override
	public long computeTax(Trust trust) {
		return trust.isNonprofit() ? 0 : super.computeTax(trust);
	}
}
