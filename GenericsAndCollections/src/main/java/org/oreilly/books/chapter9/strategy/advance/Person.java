package org.oreilly.books.chapter9.strategy.advance;

public class Person extends TaxPayer<Person> {
	public Person(long income, TaxStrategy<Person> strategy) {
		super(income, strategy);
	}

	@Override
	protected Person getThis() {
		return this;
	}
}
