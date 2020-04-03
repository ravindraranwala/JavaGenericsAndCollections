package org.oreilly.books.chapter5.minimal;

public class Stacks {
	private Stacks() {
		throw new AssertionError("Non-instantiable");
	}

	public static <E> Stack<E> reverse(Stack<E> in) {
		Stack out = new ArrayStack();
		while (!in.empty()) {
			Object elt = in.pop();
			out.push(elt); // unchecked call
		}
		return out; // unchecked conversion
	}
}
