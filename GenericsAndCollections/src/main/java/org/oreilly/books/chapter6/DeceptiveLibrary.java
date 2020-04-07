package org.oreilly.books.chapter6;

import java.util.Arrays;
import java.util.List;

public class DeceptiveLibrary {

	DeceptiveLibrary() {
		throw new AssertionError("Non-instantiable");
	}

	public static List<Integer>[] intLists(int size) {
		List<Integer>[] intLists = (List<Integer>[]) new List[size]; // unchecked cast
		for (int i = 0; i < size; i++)
			intLists[i] = Arrays.asList(i + 1);
		return intLists;
	}
}
