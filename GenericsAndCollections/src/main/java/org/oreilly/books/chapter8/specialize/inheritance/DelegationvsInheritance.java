package org.oreilly.books.chapter8.specialize.inheritance;

import java.util.ArrayList;
import java.util.List;

import org.oreilly.books.chapter8.specialize.wrapper.ListString;
import org.oreilly.books.chapter8.specialize.wrapper.ListStrings;

public class DelegationvsInheritance {

	public static void main(String[] args) {
		List<String> original = new ArrayList<String>();
		ListString delegated = ListStrings.wrap(original);
		ListString inherited = new ArrayListString(original);
		delegated.add("one");
		inherited.add("two");
		try {
			((List) delegated).add(3); // unchecked, class cast error
		} catch (ClassCastException e) {
		}
		((List) inherited).add(4); // unchecked, no class cast error!
		assert original.toString().equals("[one]");
		assert delegated.toString().equals("[one]");
		assert inherited.toString().equals("[two, 4]");
	}

}
