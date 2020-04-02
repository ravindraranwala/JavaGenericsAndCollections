package org.oreilly.books.chapter5.generic;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack<E> implements Stack<E> {
	private List<E> list;

	public ArrayStack() {
		list = new ArrayList<E>();
	}

	@Override
	public boolean empty() {
		return list.size() == 0;
	}

	@Override
	public void push(E elt) {
		list.add(elt);
	}

	@Override
	public E pop() {
		E elt = list.remove(list.size() - 1);
		return elt;
	}

	public String toString() {
		return "stack" + list.toString();
	}

}
