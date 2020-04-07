package org.oreilly.books.chapter6;

import java.util.Arrays;
import java.util.List;

public class IndecentExposure {

	public static void main(String[] args) {
		Integer[] ints = new Integer[] { 1 };
		Number[] nums = ints;
		// nums[0] = 1.01; // array store exception
		int n = ints[0];

		List<Integer>[] intLists = (List<Integer>[]) new List[] { Arrays.asList(1) }; // unchecked cast
		List<? extends Number>[] numLists = intLists;
		numLists[0] = Arrays.asList(1.01);
		int n2 = intLists[0].get(0); // class cast exception
	}

}
