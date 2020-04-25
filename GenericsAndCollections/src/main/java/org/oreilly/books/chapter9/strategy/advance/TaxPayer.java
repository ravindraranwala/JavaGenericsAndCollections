package org.oreilly.books.chapter9.strategy.advance;

//now correctly typed
public abstract class TaxPayer<P extends TaxPayer<P>> {
	public long income; // in cents
	private TaxStrategy<P> strategy;

	public TaxPayer(long income, TaxStrategy<P> strategy) {
		this.income = income;
		this.strategy = strategy;
	}

	protected abstract P getThis();

	public long getIncome() {
		return income;
	}

	public long computeTax() {
		return strategy.computeTax(getThis());
	}
}
