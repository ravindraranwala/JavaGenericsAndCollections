package org.oreilly.books.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public final class PECS {

	public static void main(String[] args) {
		// Use of extends wildcard.
		List<Integer> ints = Arrays.asList(1, 2, 3);
		assert sum(ints) == 6.0;
		List<Double> doubles = Arrays.asList(2.78, 3.14);
		assert sum(doubles) == 5.92;
		List<Number> nums = Arrays.<Number>asList(1, 2, 2.78, 3.14);
		assert sum(nums) == 8.92;

		// Use of super wildcard.
		List<Integer> ints2 = new ArrayList<Integer>();
		count(ints2, 5);
		assert ints2.toString().equals("[0, 1, 2, 3, 4]");

		// The last two calls would not be legal if super was not used.
		List<Number> nums2 = new ArrayList<Number>();
		count(nums2, 5);
		nums2.add(5.0);
		assert nums2.toString().equals("[0, 1, 2, 3, 4, 5.0]");
		List<Object> objs = new ArrayList<Object>();
		count(objs, 5);
		objs.add("five");
		assert objs.toString().equals("[0, 1, 2, 3, 4, five]");

		List<Number> nums3 = new ArrayList<Number>();
		double sum = sumCount(nums3, 5);
		assert sum == 10;

		List<Integer> ints3 = new ArrayList<Integer>();
		ints3.add(1);
		ints3.add(2);
		List<? extends Number> nums4 = ints;
		double dbl = sum(nums4); // ok
		// nums4.add(3.14); // compile-time error

		List<Object> objs1 = new ArrayList<Object>();
		objs1.add(1);
		objs1.add("two");
		List<? super Integer> ints4 = objs1;
		ints4.add(3); // ok
		// double dbl2 = sum(ints4); // compile-time error

		List<Integer> ints5 = new ArrayList<Integer>();
		ints5.add(1);
		ints5.add(2);
		List<? extends Number> nums5 = ints5;
		nums5.add(null); // ok
		assert nums5.toString().equals("[1, 2, null]");
		
		List<Object> objs2 = Arrays.<Object>asList(1,"two");
		List<? super Integer> ints6 = objs2;
		String str = "";
		for (Object obj : ints6) str += obj.toString();
		assert str.equals("1two");
	}

	public static double sum(Collection<? extends Number> nums) {
		double s = 0.0;
		for (Number num : nums)
			s += num.doubleValue();
		return s;
	}

	public static void count(Collection<? super Integer> ints, int n) {
		for (int i = 0; i < n; i++)
			ints.add(i);
	}

	public static double sumCount(Collection<Number> nums, int n) {
		count(nums, n);
		return sum(nums);
	}
}
