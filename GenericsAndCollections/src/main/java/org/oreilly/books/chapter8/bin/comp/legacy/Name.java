package org.oreilly.books.chapter8.bin.comp.legacy;

//8.4 Maintain Binary Compatibility
interface Name extends Comparable {
	public int compareTo(Object o);
}
