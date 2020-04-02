package org.oreilly.books.chapter5.generic;

public interface Stack<E> {
	public boolean empty();

	public void push(E elt);

	public E pop();
}
