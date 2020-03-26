package org.oreilly.books.chapter2;

import java.util.ArrayList;
import java.util.List;

public class WildcardCapture {

	public static void main(String[] args) {

	}

	public static <T> void reverse(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tmp.get(list.size() - i - 1));
		}
	}

	public static void reverse2(List<?> list) {
		List<Object> tmp = new ArrayList<Object>(list);
		for (int i = 0; i < list.size(); i++) {
			// list.set(i, tmp.get(list.size() - i - 1)); // compile-time error
		}
	}

	public static void reverse3(List<?> list) {
		rev(list);
	}

	private static <T> void rev(List<T> list) {
		List<T> tmp = new ArrayList<T>(list);
		for (int i = 0; i < list.size(); i++) {
			list.set(i, tmp.get(list.size() - i - 1));
		}
	}
}
