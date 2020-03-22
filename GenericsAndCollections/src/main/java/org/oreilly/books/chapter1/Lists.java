package org.oreilly.books.chapter1;

import java.util.ArrayList;
import java.util.List;

public class Lists {

	public static void main(String[] args) {
		List<Integer> ints = Lists.toList(new Integer[] { 1, 2, 3 });
		List<String> words = Lists.toList(new String[] { "hello", "world" });
		System.out.println(ints);

		List<Integer> ints2 = Lists.toList2(1, 2, 3);
		List<String> words2 = Lists.toList2("hello", "world");
		System.out.println(words2);
		
		List<Integer> ints3 = new ArrayList<Integer>();
		Lists.addAll(ints3, 1, 2);
		Lists.addAll(ints3, new Integer[] { 3, 4 });
		assert ints3.toString().equals("[1, 2, 3, 4]");
		
//		List<Integer> ints3 = Lists.<Integer>toList();
//		List<Object> objs = Lists.<Object>toList(1, "two");
	}

	public static <T> List<T> toList(T[] arr) {
		List<T> list = new ArrayList<T>();
		for (T elt : arr)
			list.add(elt);
		return list;
	}

	public static <T> List<T> toList2(T... arr) {
		List<T> list = new ArrayList<T>();
		for (T elt : arr)
			list.add(elt);
		return list;
	}

	public static <T> void addAll(List<T> list, T... arr) {
		for (T elt : arr)
			list.add(elt);
	}
}
