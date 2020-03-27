package org.oreilly.books.chapter3;

public class Comparison {

	public static void main(String[] args) {
		Integer int0 = 0;
		Integer int1 = 1;
		assert int0.compareTo(int1) < 0;

		String str0 = "zero";
		String str1 = "one";
		assert str0.compareTo(str1) > 0;
		
		Integer i = 0;
		String s = "one";
		// assert i.compareTo(s) < 0; // compile-time error
		
		Number m = Integer.valueOf(2);
		Number n = Double.valueOf(3.14);
		// assert m.compareTo(n) < 0; // compile-time error
	}

}
