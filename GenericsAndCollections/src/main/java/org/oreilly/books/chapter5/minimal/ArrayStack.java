package org.oreilly.books.chapter5.minimal;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<E> implements Stack<E> {
	private List list;

	public ArrayStack() {
		list = new ArrayList();
	}

	@Override
	public boolean empty() {
		return list.size() == 0;
	}

	@Override
	public void push(E elt) {
		list.add(elt); // unchecked call
	}

	@Override
	public E pop() {
		Object elt = list.get(list.size() - 1);
		list.remove(list.size() - 1);
		return (E) elt; // unchecked cast
	}

	public String toString() {
		return "stack" + list.toString();
	}
}
