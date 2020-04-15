package org.oreilly.books.chapter8.specialize.inheritance;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.oreilly.books.chapter8.specialize.wrapper.ListString;

public class ArrayListString extends ArrayList<String> implements ListString {
	public ArrayListString() {
		super();
	}

	public ArrayListString(Collection<? extends String> c) {
		super(c);
		// this.addAll(c);
	}

	public ArrayListString(int capacity) {
		super(capacity);
	}

//	public boolean addAll(Collection<? extends String> c) {
//		for (String s : c) {
//		} // check that c contains only strings
//		return super.addAll(c);
//	}

//	public boolean add(String element) {
//		return super.add(element);
//	}

//	public void add(int index, String element) {
//		super.add(index, element);
//	}

//	public String set(int index, String element) {
//		return super.set(index, element);
//	}

	public static void main(String[] args) {
		List<? extends List<?>> lists = Arrays.asList(new ArrayListString(Arrays.asList("one", "two")),
				Arrays.asList(3, 4), Arrays.asList("five", "six"),
				new ArrayListString(Arrays.asList("seven", "eight")));
		ListString[] array = new ListString[2];
		int i = 0;
		for (List<?> list : lists)
			if (list instanceof ListString)
				array[i++] = (ListString) list;
		assert Arrays.toString(array).equals("[[one, two], [seven, eight]]");
	}
}
