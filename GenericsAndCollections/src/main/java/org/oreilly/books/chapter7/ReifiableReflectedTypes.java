package org.oreilly.books.chapter7;

import java.util.ArrayList;
import java.util.List;

public class ReifiableReflectedTypes {

	public static void main(String[] args) {
		List<Integer> ints = new ArrayList<Integer>();
		List<String> strs = new ArrayList<String>();
		assert ints.getClass() == strs.getClass();
		assert ints.getClass() == ArrayList.class;

		List<Integer> ints2 = new ArrayList<Integer>();
		Class<? extends List> k = ints2.getClass();
		assert k == ArrayList.class;

		Class<Integer> intClazz = int.class;
		Integer val = int.class.cast(1);

		Class<int[]> intArrClazz = int[].class;
	}

}
