package org.oreilly.books.chapter8.bin.comp.generified;

//8.4 Maintain Binary Compatibility

interface Name extends Comparable<Name> {
	public int compareTo(Name o);
}
