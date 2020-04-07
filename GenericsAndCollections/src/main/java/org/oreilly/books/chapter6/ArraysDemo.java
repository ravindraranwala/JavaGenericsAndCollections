package org.oreilly.books.chapter6;

public class ArraysDemo {

	private ArraysDemo() {
		throw new AssertionError("Non instantiable");
	}

	public static void main(String[] args) {
		Integer[] ints = new Integer[] { 1, 2, 3 };
		Number[] nums = ints;
		nums[2] = 3.14; // array store exception
	}
}
