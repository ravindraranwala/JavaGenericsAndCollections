package org.oreilly.books.chapter4;

public final class Cell2<T> {
	private final T value;
	//private static List<T> values = new ArrayList<T>(); // illegal

	public Cell2(T value) {
		this.value = value;
		//values.add(value);
	}

	public T getValue() {
		return value;
	}

	// illegal
//	public static List<T> getValues() {
//		return values;
//	}
}
