package org.oreilly.books.chapter11;

// Example 11-2. A non-thread-safe stack implementation
public class ArrayStack implements Stack {
	private static final int MAX_ELEMENTS = 10;
	private int[] stack;
	private int index;

	public ArrayStack() {
		stack = new int[MAX_ELEMENTS];
		index = -1;
	}

	@Override
	public void push(int elt) {
		if (index != stack.length - 1) {
			index++; // 1
			stack[index] = elt; // 2
		} else {
			throw new IllegalStateException("stack overflow");
		}
	}

	@Override
	public int pop() {
		if (index != -1) {
			return stack[index--];
		} else {
			throw new IllegalStateException("stack underflow");
		}
	}

	@Override
	public boolean isEmpty() {
		return index == -1;
	}

}
