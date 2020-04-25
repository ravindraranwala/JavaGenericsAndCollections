package org.oreilly.books.chapter9.strategy.advance;

public interface TaxStrategy<P extends TaxPayer<P>> {
	public long computeTax(P p);
}
