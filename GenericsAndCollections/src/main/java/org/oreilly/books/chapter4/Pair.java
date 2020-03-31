package org.oreilly.books.chapter4;

import java.util.Arrays;
import java.util.List;

public final class Pair<T, U> {
	private final T first;
	private final U second;

	public Pair(T first, U second) {
		this.first = first;
		this.second = second;
	}

	public T getFirst() {
		return first;
	}

	public U getSecond() {
		return second;
	}

	public static void main(String[] args) {
		Pair<String, Integer> pair = new Pair<String, Integer>("one", 2);
		assert pair.getFirst().equals("one") && pair.getSecond() == 2;
		
		Pair<String, Integer> pair2 = new Pair("one",2);
		
		List<Integer> ints = Arrays.asList(1,2,3);
		List<String> strings = Arrays.asList("one","two");
		assert ints.getClass() == strings.getClass();
		System.out.println(ints.getClass());
	}

}
