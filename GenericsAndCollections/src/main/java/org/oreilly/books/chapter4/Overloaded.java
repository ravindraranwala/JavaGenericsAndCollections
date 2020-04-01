package org.oreilly.books.chapter4;

import java.util.List;

public class Overloaded {
	// compile-time error, cannot overload two methods with same erasure
	public static int sum(List<Integer> ints) {
		int sum = 0;
		for (int i : ints)
			sum += i;
		return sum;
	}

	// Same Erasure, so not allowed.
//	public static String sum(List<String> strings) {
//		StringBuffer sum = new StringBuffer();
//		for (String s : strings)
//			sum.append(s);
//		return sum.toString();
//	}
}
