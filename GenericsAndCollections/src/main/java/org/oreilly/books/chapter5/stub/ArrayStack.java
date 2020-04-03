package org.oreilly.books.chapter5.stub;

public class ArrayStack<E> implements Stack<E> {

	@Override
	public boolean empty() {
		throw new StubException();
	}

	@Override
	public void push(E elt) {
		throw new StubException();
	}

	@Override
	public E pop() {
		throw new StubException();
	}

	public String toString() {
		throw new StubException();
	}
}
