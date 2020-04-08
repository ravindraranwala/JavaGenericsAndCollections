package org.oreilly.books.chapter6;

public class Annoying {
	private Annoying() {
		throw new AssertionError("Non instantiable");
	}

//	public static <T> T[] toArray(Collection<T> c) {
//		T[] a = new T[c.size()]; // compile-time error
//		int i = 0;
//		for (T x : c)
//			a[i++] = x;
//		return a;
//	}

//	public static List<Integer>[] twoLists() {
//		List<Integer> a = Arrays.asList(1, 2, 3);
//		List<Integer> b = Arrays.asList(4, 5, 6);
//		return new List<Integer>[] { a, b }; // compile-time error
//	}
}
