package org.oreilly.books.chapter15;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

public class ListIteratorMethods {
	public static void main(String[] args) {
		final List<String> data = new ArrayList<>();
		data.add("Carlos");
		data.add("Alice");
		data.add("Bob");
		data.add("Zebra");
		data.add("Fred");
		
		for(ListIterator<String> it = data.listIterator(); it.hasNext(); ) {
//			final String curr = it.next();
//			System.out.println(curr);
//			it.remove();
			it.set("new");
		}

	}

}
