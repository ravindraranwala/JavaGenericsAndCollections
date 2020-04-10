package org.oreilly.books.chapter6;

public class GenericArray {

	private GenericArray() {
		throw new AssertionError("Non-instantiable");
	}

	public static <T> T[] newInstance(Class<T> c, int size) {
		return (T[]) java.lang.reflect.Array.newInstance(c, size); // unchecked
	}

	public static <T> Class<T> getComponentType(T[] a) {
		return (Class<T>) a.getClass().getComponentType(); // unchecked
	}

	public static <T> T[] newInstance(T[] arr, int size) {
		return newInstance(getComponentType(arr), size);
	}
}
