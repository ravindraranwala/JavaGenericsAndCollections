package org.oreilly.books.chapter5.wrapper;

import org.oreilly.books.chapter5.legacy.Stack;

public class GenericStackWrapper<E> implements GenericStack<E> {
	private Stack stack;

	public GenericStackWrapper(Stack stack) {
		this.stack = stack;
	}

	@Override
	public Stack unwrap() {
		return stack;
	}

	@Override
	public boolean empty() {
		return stack.empty();
	}

	@Override
	public void push(E elt) {
		// stack is a raw type, so no unchecked warnings here.
		stack.push(elt);
	}

	@Override
	public E pop() {
		return (E) stack.pop(); // unchecked cast
	}

	public String toString() {
		return stack.toString();
	}
}
