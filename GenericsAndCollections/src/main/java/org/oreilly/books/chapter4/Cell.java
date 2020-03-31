package org.oreilly.books.chapter4;

public final class Cell<T> {
	private final int id;
	private final T value;
	private static int count = 0;

	private static synchronized int nextId() {
		return count++;
	}

	public Cell(T value) {
		this.value = value;
		id = nextId();
	}

	public T getValue() {
		return value;
	}

	public int getId() {
		return id;
	}

	public static synchronized int getCount() {
		return count;
	}

	public static void main(String[] args) {
		Cell<String> a = new Cell<String>("one");
		Cell<Integer> b = new Cell<Integer>(2);
		assert a.getId() == 0 && b.getId() == 1 && Cell.getCount() == 2;
		
		Cell.getCount(); 		// ok
		// Cell<Integer>.getCount(); // compile-time error
		// Cell<?>.getCount();   // compile-time error
	}

}
