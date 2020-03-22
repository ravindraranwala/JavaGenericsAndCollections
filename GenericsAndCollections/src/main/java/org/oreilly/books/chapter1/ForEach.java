package org.oreilly.books.chapter1;

import java.util.Iterator;
import java.util.List;

public class ForEach {

	public static void main(String[] args) {

	}

	// The for-each covers only the common case.
	public static int sumArray(int[] a) {
		int s = 0;
		for (int n : a) {
			s += n;
		}
		return s;
	}

	// Can't use for-each to remove elements while iterating over an iterable.
	public static void removeNegative(List<Double> v) {
		for (Iterator<Double> it = v.iterator(); it.hasNext();) {
			if (it.next() < 0)
				it.remove();
		}
	}

	// Can't use for-each to iterate over two iterables in lock-step
	public static double dot(List<Double> u, List<Double> v) {
		if (u.size() != v.size())
			throw new IllegalArgumentException("different sizes");
		double d = 0;
		Iterator<Double> uIt = u.iterator();
		Iterator<Double> vIt = v.iterator();
		while (uIt.hasNext()) {
			assert uIt.hasNext() && vIt.hasNext();
			d += uIt.next() * vIt.next();
		}
		assert !uIt.hasNext() && !vIt.hasNext();
		return d;
	}
}
