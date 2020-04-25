package org.oreilly.books.chapter9.strategy.error;

/*
 * Indeed, within each specific tax payer class, such as Person or Trust,
 * it is the case that this does have type P; for example, Person extends TaxPayer<Person>,
 * so P is the same as Person within this class. So, in fact, this will have the same type as P,
 * but the type system does not know that!
 */
public class Person extends TaxPayer<Person> {
	private TaxStrategy<Person> strategy;

	public long computeTax() {
		return strategy.computeTax(this);
	}
}
