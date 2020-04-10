package org.oreilly.books.chapter6;

import java.util.Arrays;
import java.util.List;

public class VarargError {

	public static void main(String[] args) {
		List<Integer> a = Arrays.asList(1, 2, 3);
		List<Integer> b = Arrays.asList(4, 5, 6);
		List<List<Integer>> x = Arrays.asList(a, b); // generic array creation

		// Recommended idiom.
		List<List<Integer>> source = new ArrayList<>();
		source.add(a);
		source.add(b);

		List<Integer> a1 = Arrays.asList(new Integer[] { 1, 2, 3 });
		List<Integer> b1 = Arrays.asList(new Integer[] { 4, 5, 6 });
		// List<List<Integer>> x1 = Arrays.asList(new List<Integer>[] { a1, b1 }); // generic array creation
	}

	public static <E> List<E> singleton(E elt) {
		return Arrays.asList(elt); // generic array creation
	}
}
