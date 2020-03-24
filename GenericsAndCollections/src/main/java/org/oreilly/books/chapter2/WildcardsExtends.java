package org.oreilly.books.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardsExtends {

	public static void main(String[] args) {
		// with extends
		List<Number> nums = new ArrayList<Number>();
		List<Integer> ints = Arrays.asList(1, 2);
		List<Double> dbls = Arrays.asList(2.78, 3.14);
		nums.addAll(ints);
		nums.addAll(dbls);
		assert nums.toString().equals("[1, 2, 2.78, 3.14]");

		List<Integer> ints2 = new ArrayList<Integer>();
		ints2.add(1);
		ints2.add(2);
		List<? extends Number> nums2 = ints2;
		// nums2.add(3.14); // compile-time error
		// assert ints2.toString().equals("[1, 2, 3.14]"); // uh oh
	}

}
