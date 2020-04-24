package org.oreilly.books.chapter9.strategy.basic;

abstract class TaxPayer {
	public long income; // in cents
	public TaxPayer(long income) { this.income = income; }
	public long getIncome() { return income; }
}
