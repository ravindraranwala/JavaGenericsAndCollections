package org.oreilly.books.chapter2;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class WildcardsSuper {

	public static void main(String[] args) {
		List<Object> objs = Arrays.<Object>asList(2, 3.14, "four");
		List<Integer> ints = Arrays.asList(5, 6);
		Collections.copy(objs, ints);
		assert objs.toString().equals("[5, 6, four]");
		
		Collections.copy(objs, ints);
		Collections.<Object>copy(objs, ints);
		Collections.<Number>copy(objs, ints);
		Collections.<Integer>copy(objs, ints);
	}

	public static <T> void copy(List<? super T> dst, List<? extends T> src) {
		for (int i = 0; i < src.size(); i++) {
			dst.set(i, src.get(i));
		}
	}
}
