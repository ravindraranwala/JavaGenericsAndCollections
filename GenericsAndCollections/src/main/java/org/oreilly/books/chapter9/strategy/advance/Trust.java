package org.oreilly.books.chapter9.strategy.advance;

public class Trust extends TaxPayer<Trust> {
	private boolean nonprofit;

	public Trust(long income, boolean nonprofit, TaxStrategy<Trust> strategy) {
		super(income, strategy);
		this.nonprofit = nonprofit;
	}

	@Override
	protected Trust getThis() {
		return this;
	}

	public boolean isNonprofit() {
		return nonprofit;
	}
}
