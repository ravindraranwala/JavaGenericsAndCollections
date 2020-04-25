package org.oreilly.books.chapter9.strategy.ext;

import org.oreilly.books.chapter9.strategy.advance.TaxStrategy;

final class ForProfitTrust extends Trust<ForProfitTrust> {
	public ForProfitTrust(long income, TaxStrategy<ForProfitTrust> strategy) {
		super(income, strategy);
	}

	@Override
	protected ForProfitTrust getThis() {
		return this;
	}
}
