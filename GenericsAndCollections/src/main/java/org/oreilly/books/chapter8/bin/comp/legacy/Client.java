package org.oreilly.books.chapter8.bin.comp.legacy;

class Client {
	public static void main(String[] args) {
		Name m = new ExtendedName("a", "b");
		Name n = new ExtendedName("a", "c");
		assert m.compareTo(n) < 0;
	}
}
