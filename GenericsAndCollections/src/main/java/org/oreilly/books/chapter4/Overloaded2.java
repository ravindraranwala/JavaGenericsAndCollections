package org.oreilly.books.chapter4;

import java.util.List;

public class Overloaded2 {
	// compile-time error, cannot overload two methods with same erasure
	public static boolean allZero(List<Integer> ints) {
		for (int i : ints)
			if (i != 0)
				return false;
		return true;
	}

//	public static boolean allZero(List<String> strings) {
//		for (String s : strings)
//			if (s.length() != 0)
//				return false;
//		return true;
//	}
}
