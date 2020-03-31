package org.oreilly.books.chapter4;

import java.util.ArrayList;
import java.util.List;

public final class Cell3<T> {

	public static void main(String[] args) {
		Cell3<String> a = new Cell3<String>("one");
		Cell3<Integer> b = new Cell3<Integer>(2);
		assert Cell3.getValues().toString().equals("[one, 2]");
	}

	private final T value;
	private static List<Object> values = new ArrayList<Object>(); // ok

	public Cell3(T value) {
		this.value = value;
		values.add(value);
	}

	public T getValue() {
		return value;
	}

	public static List<Object> getValues() {
		return values;
	} // ok
}
