package org.oreilly.books.chapter6;

public class IntegerExceptionTest {

	public static void main(String[] args) {
		try {
			throw new IntegerException(42);
		} catch (IntegerException e) {
			assert e.getValue() == 42;
		}
	}

	static class IntegerException extends Exception {
		private final int value;

		IntegerException(int value) {
			this.value = value;
		}

		public int getValue() {
			return value;
		}
	}
}
