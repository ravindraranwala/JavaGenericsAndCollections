package org.oreilly.books.chapter13;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeSet;

public class ConstructorOverloadProblem {
	public static void main(String[] args) {
		// construct and populate a verb$NavigableSet$ whose iterator returns its
		// elements in the reverse of natural order:
		NavigableSet<String> base = new TreeSet<String>(Collections.reverseOrder());
		Collections.addAll(base, "b", "a", "c");
		// call the two different constructors for verb$TreeSet$, supplying the
		// set just constructed, but with different static types:
		NavigableSet<String> sortedSet1 = new TreeSet<String>((Set<String>) base);
		NavigableSet<String> sortedSet2 = new TreeSet<String>(base);
		// and the two sets have different iteration orders:
		List<String> forward = new ArrayList<String>();
		forward.addAll(sortedSet1);
		List<String> backward = new ArrayList<String>();
		backward.addAll(sortedSet2);
		assert !forward.equals(backward);
		Collections.reverse(forward);
		assert forward.equals(backward);
	}
}