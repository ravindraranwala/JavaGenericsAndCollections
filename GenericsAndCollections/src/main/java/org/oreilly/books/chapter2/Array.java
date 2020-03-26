package org.oreilly.books.chapter2;

import java.util.Arrays;
import java.util.List;

public final class Array {

	public static void main(String[] args) {
		Integer[] ints = new Integer[] { 1, 2, 3 };
		Number[] nums = ints;
		nums[2] = 3.14; // array store exception
		assert Arrays.toString(ints).equals("[1, 2, 3.14]"); // uh oh!

		List<Integer> ints2 = Arrays.asList(1, 2, 3);
		// List<Number> nums2 = ints2; // compile-time error
		// nums2.set(2, 3.14);
		// assert ints2.toString().equals("[1, 2, 3.14]"); // uh oh!

		List<Integer> ints3 = Arrays.asList(1, 2, 3);
		List<? extends Number> nums3 = ints3;
		// nums3.set(2, 3.14); // compile-time error
		// assert ints.toString().equals("[1, 2, 3.14]"); // uh oh!
	}

	// Before generics, covariant arrays were useful
	public static void sortArr(Object[] a) {

	}

	public static void fillArr(Object[] a, Object val) {

	}

	// But now with generics it is obsolete.
	public static <T> void sort(T[] a) {

	}

	public static <T> void fill(T[] a, T val) {

	}
}
