package org.oreilly.books.chapter9.strategy.error;

interface TaxStrategy<P extends TaxPayer<P>> {
	public long computeTax(P p);
}
