package org.oreilly.books.chapter3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;

public final class Comparisons {
	private Comparisons() {
		throw new AssertionError("Non instantiable !");
	}

	public static void main(String[] args) {
		List<Integer> ints = Arrays.asList(0, 1, 2);
		assert max(ints) == 2;

		List<String> strs = Arrays.asList("zero", "one", "two");
		assert max(strs).equals("zero");

		List<Number> nums = Arrays.asList(0, 1, 2, 3.14);
		// assert max(nums) == 3.14; // compile-time error
	}

	public static <T extends Comparable<T>> T max(Collection<T> coll) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (candidate.compareTo(elt) < 0)
				candidate = elt;
		}
		return candidate;
	}

	public static <T extends Comparable<T>> T max2(Collection<T> coll) {
		Iterator<T> it = coll.iterator();
		T candidate = it.next();
		while (it.hasNext()) {
			T elt = it.next();
			if (candidate.compareTo(elt) < 0)
				candidate = elt;
		}
		return candidate;
	}

	// Improved signature.
	public static <T extends Comparable<? super T>> T max4(Collection<? extends T> coll) {
		Iterator<? extends T> it = coll.iterator();
		T candidate = it.next();
		while (it.hasNext()) {
			T elt = it.next();
			if (candidate.compareTo(elt) < 0)
				candidate = elt;
		}
		return candidate;
	}

	public static <T> T max(Collection<? extends T> coll, Comparator<? super T> cmp) {
		T candidate = coll.iterator().next();
		for (T elt : coll) {
			if (cmp.compare(candidate, elt) < 0) {
				candidate = elt;
			}
		}
		return candidate;
	}
}
