package org.oreilly.books.chapter2;

import java.util.ArrayList;
import java.util.List;

public class Lists {
	public static <T> List<T> factory() {
		return new ArrayList<T>();
	}
}
