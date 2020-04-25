package org.oreilly.books.chapter9.strategy.advance;

public class Test {
	public static void main(String[] args) {
	    Person person, dodger;
	    person = new Person(10000000, new DefaultTaxStrategy<Person>());
	    dodger = new Person(10000000, new DodgingTaxStrategy<Person>());
	    assert person.computeTax() == 4000000;
	    assert dodger.computeTax() == 0;

	    Trust forProfit, nonProfit;
	    forProfit = new Trust(10000000, false, new TrustTaxStrategy());
	    nonProfit = new Trust(10000000, true, new TrustTaxStrategy());
	    assert forProfit.computeTax() == 4000000;
	    assert nonProfit.computeTax() == 0;
	}
}
