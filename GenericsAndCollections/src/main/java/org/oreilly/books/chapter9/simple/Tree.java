package org.oreilly.books.chapter9.simple;

public abstract class Tree<E> {
	abstract public String toString();

	abstract public double sum();

	public static <E> Tree<E> leaf(final E e) {
		return new Tree<E>() {
			public String toString() {
				return e.toString();
			}

			public double sum() {
				return ((Number) e).doubleValue();
			}
		};
	}

	public static <E> Tree<E> branch(final Tree<E> l, final Tree<E> r) {
		return new Tree<E>() {
			public String toString() {
				return "(" + l.toString() + "^" + r.toString() + ")";
			}

			public double sum() {
				return l.sum() + r.sum();
			}
		};
	}
}
