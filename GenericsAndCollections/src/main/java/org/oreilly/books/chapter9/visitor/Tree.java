package org.oreilly.books.chapter9.visitor;

public abstract class Tree<E> {
	public static interface Visitor<E, R> {
		public R leaf(E elt);

		public R branch(R left, R right);
	}

	public abstract <R> R visit(Visitor<E, R> v);

	public static <T> Tree<T> leaf(final T e) {
		return new Tree<T>() {
			public <R> R visit(Visitor<T, R> v) {
				return v.leaf(e);
			}
		};
	}

	public static <T> Tree<T> branch(final Tree<T> l, final Tree<T> r) {
		// This is our composite element.
		return new Tree<T>() {
			public <R> R visit(Visitor<T, R> v) {
				return v.branch(l.visit(v), r.visit(v));
			}
		};
	}
}
