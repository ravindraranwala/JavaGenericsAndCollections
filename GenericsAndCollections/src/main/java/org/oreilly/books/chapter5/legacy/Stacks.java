package org.oreilly.books.chapter5.legacy;

public class Stacks {

	private Stacks() {
		throw new AssertionError("Non instantiable");
	}

	public static Stack reverse(Stack in) {
		Stack out = new ArrayStack();
		while (!in.empty()) {
			Object elt = in.pop();
			out.push(elt);
		}
		return out;
	}
}
