package org.oreilly.books.chapter9.strategy.ext;

import org.oreilly.books.chapter9.strategy.advance.TaxPayer;
import org.oreilly.books.chapter9.strategy.advance.TaxStrategy;

abstract class Trust<T extends Trust<T>> extends TaxPayer<T> {
	public Trust(long income, TaxStrategy<T> strategy) {
		super(income, strategy);
	}
}
