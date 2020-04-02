package org.oreilly.books.chapter5.legacy;

import java.util.ArrayList;
import java.util.List;

public class ArrayStack implements Stack {
	private List list;

	public ArrayStack() {
		list = new ArrayList();
	}

	@Override
	public boolean empty() {
		return list.size() == 0;
	}

	@Override
	public void push(Object elt) {
		list.add(elt);
	}

	@Override
	public Object pop() {
		Object elt = list.remove(list.size() - 1);
		return elt;
	}

	public String toString() {
		return "stack" + list.toString();
	}
}
