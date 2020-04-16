package org.oreilly.books.chapter8.bin.comp.legacy;

class SimpleName implements Name {
	private String base;

	public SimpleName(String base) {
		this.base = base;
	}

	@Override
	public int compareTo(Object o) {
		return base.compareTo(((SimpleName) o).base);
	}
}
