package org.oreilly.books.chapter9.strategy.basic;

interface TaxStrategy<P extends TaxPayer> {
	public long computeTax(P p);
}
