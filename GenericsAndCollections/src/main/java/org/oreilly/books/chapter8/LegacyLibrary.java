package org.oreilly.books.chapter8;

import java.util.ArrayList;
import java.util.List;

public class LegacyLibrary {
	private LegacyLibrary() {
		throw new AssertionError();
	}

	public static void addItems(List list) {
		list.add(Integer.valueOf(1));
		list.add("two");
	}

	public static List getItems() {
		List list = new ArrayList();
		list.add(Integer.valueOf(3));
		list.add("four");
		return list;
	}
}
