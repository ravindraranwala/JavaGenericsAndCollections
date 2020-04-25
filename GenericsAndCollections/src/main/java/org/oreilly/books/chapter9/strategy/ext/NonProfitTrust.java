package org.oreilly.books.chapter9.strategy.ext;

import org.oreilly.books.chapter9.strategy.advance.TaxStrategy;

final class NonProfitTrust extends Trust<NonProfitTrust> {
	public NonProfitTrust(long income, TaxStrategy<NonProfitTrust> strategy) {
		super(income, strategy);
	}

	@Override
	protected NonProfitTrust getThis() {
		return this;
	}
}
