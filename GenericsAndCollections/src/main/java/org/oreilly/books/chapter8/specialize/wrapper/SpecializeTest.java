package org.oreilly.books.chapter8.specialize.wrapper;

import java.util.Arrays;
import java.util.List;

public class SpecializeTest {

	public static void main(String[] args) {
		List<? extends List<?>> lists = Arrays.asList(ListStrings.wrap(Arrays.asList("one", "two")),
				Arrays.asList(3, 4), Arrays.asList("five", "six"), ListStrings.wrap(Arrays.asList("seven", "eight")));
		ListString[] array = new ListString[2];
		int i = 0;
		for (List<?> list : lists)
			if (list instanceof ListString)
				array[i++] = (ListString) list;
		assert Arrays.toString(array).equals("[[one, two], [seven, eight]]");
		
		List raw = Arrays.asList(1);
		ListString listString = ListStrings.wrap(raw);
		String first = listString.get(0);   // class cast error !
		System.out.println(first);
	}

}
