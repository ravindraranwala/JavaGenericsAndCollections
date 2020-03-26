package org.oreilly.books.chapter2;

import java.util.Arrays;
import java.util.List;

public final class WildcardsVsTypeParams {

	public static void main(String[] args) {
		Object obj = "one";
		List<Object> objs = Arrays.<Object>asList("one", 2, 3.14, 4);
		List<Integer> ints = Arrays.asList(2, 4);
		assert objs.contains(obj);
		assert objs.containsAll(ints);
		assert !ints.contains(obj);
		assert !ints.containsAll(objs);

		Object obj2 = 1;
		List<Object> objs2 = Arrays.<Object>asList(1, 3);
		List<Integer> ints2 = Arrays.asList(1, 2, 3, 4);
		assert ints2.contains(obj2);
		assert ints2.containsAll(objs2);
	}

}
