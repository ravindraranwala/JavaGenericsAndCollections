package org.oreilly.books.chapter6;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class Wrong {

	public static void main(String[] args) {
		List<String> strings = Arrays.asList("one", "two");
		String[] a = toArray(strings); // class cast error
	}

	public static <T> T[] toArray(Collection<T> c) {
		T[] a = (T[]) new Object[c.size()]; // unchecked cast
		int i = 0;
		for (T x : c)
			a[i++] = x;
		return a;
	}
}
