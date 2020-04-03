package org.oreilly.books.chapter5.wrapper;

import org.oreilly.books.chapter5.legacy.ArrayStack;

public class Client {

	public static void main(String[] args) {
		GenericStack<Integer> stack = new GenericStackWrapper<Integer>(new ArrayStack());
		for (int i = 0; i < 4; i++)
			stack.push(i);
		assert stack.toString().equals("stack[0, 1, 2, 3]");
		int top = stack.pop();
		assert top == 3 && stack.toString().equals("stack[0, 1, 2]");
		GenericStack<Integer> reverse = GenericStacks.reverse(stack);
		assert stack.empty();
		assert reverse.toString().equals("stack[2, 1, 0]");
	}

}
