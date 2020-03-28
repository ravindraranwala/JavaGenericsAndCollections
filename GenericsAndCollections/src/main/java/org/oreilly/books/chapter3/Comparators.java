package org.oreilly.books.chapter3;

import java.util.Arrays;
import java.util.Collection;
import java.util.Comparator;
import java.util.List;

public class Comparators {
	private Comparators() {
		throw new AssertionError("Non instantiable !");
	}

	public static void main(String[] args) {
		Comparator<String> sizeOrder = new Comparator<String>() {
			public int compare(String s1, String s2) {
				return s1.length() < s2.length() ? -1 : s1.length() > s2.length() ? 1 : s1.compareTo(s2);
			}
		};
		Collection<String> strings = Arrays.asList("from", "aaa", "to", "zzz");
		assert max(strings).equals("zzz");
		assert min(strings).equals("aaa");
		assert max(strings, sizeOrder).equals("from");
		assert min(strings, sizeOrder).equals("to");
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

	public static <T extends Comparable<? super T>> T max(Collection<? extends T> coll) {
		return max(coll, Comparators.<T>naturalOrder());
	}

	public static <T extends Comparable<? super T>> Comparator<T> naturalOrder() {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return o1.compareTo(o2);
			}
		};
	}

	public static <T> Comparator<T> reverseOrder(final Comparator<T> cmp) {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return cmp.compare(o2, o1);
			}
		};
	}

	public static <T extends Comparable<? super T>> Comparator<T> reverseOrder() {
		return new Comparator<T>() {
			public int compare(T o1, T o2) {
				return o2.compareTo(o1);
			}
		};
	}

	public static <T> T min(Collection<? extends T> coll, Comparator<? super T> cmp) {
		return max(coll, reverseOrder(cmp));
	}

	public static <T extends Comparable<? super T>> T min(Collection<? extends T> coll) {
		return max(coll, Comparators.<T>reverseOrder());
	}

	public static <E> Comparator<List<E>> listComparator(final Comparator<? super E> comp) {
		return new Comparator<List<E>>() {
			public int compare(List<E> list1, List<E> list2) {
				int n1 = list1.size();
				int n2 = list2.size();
				for (int i = 0; i < Math.min(n1, n2); i++) {
					int k = comp.compare(list1.get(i), list2.get(i));
					if (k != 0)
						return k;
				}
				return (n1 < n2) ? -1 : (n1 == n2) ? 0 : 1;
			}
		};
	}
}
