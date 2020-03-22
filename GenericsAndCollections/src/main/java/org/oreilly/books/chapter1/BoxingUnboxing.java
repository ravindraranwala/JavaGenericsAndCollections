package org.oreilly.books.chapter1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BoxingUnboxing {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		ints.add(1);
		int n = ints.get(0);

		// The above is equivalent to this.
		List<Integer> ints2 = new ArrayList<Integer>();
		ints2.add(Integer.valueOf(1));
		int n2 = ints2.get(0).intValue();

		List<Integer> bigs = Arrays.asList(100, 200, 300);
		assert sumInteger(bigs) == sum(bigs);
		assert sumInteger(bigs) != sumInteger(bigs); // not recommended
		
		List<Integer> smalls = Arrays.asList(1,2,3);
		assert sumInteger(smalls) == sum(smalls);
		assert sumInteger(smalls) == sumInteger(smalls); // not recommended
	}

	public static int sum(List<Integer> ints) {
		int s = 0;
		// notice the auto-unboxing.
		for (int n : ints)
			s += n;

		return s;
	}

	// very slow implementation, Don't do this !
	// Performs lot of needless work and this version is 60% slower than original
	// unboxes the values, add them and then box them back again. Prohibitively
	// expensive task.
	public static Integer sumInteger(List<Integer> ints) {
		Integer s = 0;
		for (Integer n : ints) {
			s += n;
		}
		return s;
	}

}
