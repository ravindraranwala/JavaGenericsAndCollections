package org.oreilly.books.chapter11;

public class SynchronizedArrayStack implements Stack {
	private final Stack stack;

	public SynchronizedArrayStack(Stack stack) {
		this.stack = stack;
	}

	@Override
	public synchronized void push(int elt) {
		stack.push(elt);
	}

	@Override
	public synchronized int pop() {
		return stack.pop();
	}

	@Override
	public synchronized boolean isEmpty() {
		return stack.isEmpty();
	}

	public static void main(String[] args) {
		Stack stack = new SynchronizedArrayStack(new ArrayStack());

		// don't do this in a multi-threaded environment
		if (!stack.isEmpty()) {
			stack.pop(); // can throw IllegalStateExceptionindexException{IllegalStateException}
		}
		synchronized (stack) {
			if (!stack.isEmpty()) {
				stack.pop();
			}
		}
	}
}
