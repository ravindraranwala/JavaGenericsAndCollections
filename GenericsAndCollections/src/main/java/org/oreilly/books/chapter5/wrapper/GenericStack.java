package org.oreilly.books.chapter5.wrapper;

import org.oreilly.books.chapter5.legacy.Stack;

public interface GenericStack<E> {
	public Stack unwrap();

	public boolean empty();

	public void push(E elt);

	public E pop();
}
