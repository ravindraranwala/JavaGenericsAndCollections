package org.oreilly.books.chapter8.bin.comp.generified;

class SimpleName implements Name {
	private String base;

	public SimpleName(String base) {
		this.base = base;
	}

	public int compareTo(Name o) {
		return base.compareTo(((SimpleName) o).base);
	}
}
