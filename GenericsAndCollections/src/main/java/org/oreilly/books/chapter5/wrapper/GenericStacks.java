package org.oreilly.books.chapter5.wrapper;

import org.oreilly.books.chapter5.legacy.Stack;
import org.oreilly.books.chapter5.legacy.Stacks;

public class GenericStacks {
	private GenericStacks() {
		throw new AssertionError();
	}

	public static <T> GenericStack<T> reverse(GenericStack<T> in) {
		Stack rawIn = in.unwrap();
		Stack rawOut = Stacks.reverse(rawIn);
		return new GenericStackWrapper<T>(rawOut);
	}
}
