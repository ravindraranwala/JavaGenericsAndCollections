package org.oreilly.books.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class Substitution {

	public static void main(String[] args) {
		List<Number> nums = new ArrayList<>();
		nums.add(2);
		nums.add(3.14);
		assert nums.toString().equals("[2, 3.14]");

		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		ints.add(2);
		// List<Number> nums2 = ints; // compile-time error
		// nums2.add(3.14);
		// assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!

		Integer[] intArr = new Integer[] { 1, 2 };
		Number[] numArr = intArr;
		// Can you spot the bug: throws an ArrayStoreException here.
		numArr[1] = 3.14;
		System.out.println(Arrays.toString(numArr));
	}

}
