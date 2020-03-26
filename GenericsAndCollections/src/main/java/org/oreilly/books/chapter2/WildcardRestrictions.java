package org.oreilly.books.chapter2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class WildcardRestrictions {

	public static void main(String[] args) {
		// 1. Instance creation expressions.
		
		// List<?> list = new ArrayList<?>(); // compile-time error
		// Map<String, ? extends Number> map = new HashMap<String, ? extends Number>();
		// // compile-time error

		List<Number> nums = new ArrayList<Number>();
		List<? super Number> sink = nums;
		List<? extends Number> source = nums;
		for (int i = 0; i < 10; i++)
			sink.add(i);
		double sum = 0;
		for (Number num : source)
			sum += num.doubleValue();

		List<List<?>> lists = new ArrayList<List<?>>();
		lists.add(Arrays.asList(1, 2, 3));
		lists.add(Arrays.asList("four", "five"));
		assert lists.toString().equals("[[1, 2, 3], [four, five]]");
		
		// Generic method calls.
		List<?> list = Lists.factory();
		List<?> list2 = Lists.<Object>factory();
		
		// List<?> list3 = Lists.<?>factory();   // compile-time error
		
		List<List<?>> list4 = Lists.<List<?>>factory(); // ok
	}

}
