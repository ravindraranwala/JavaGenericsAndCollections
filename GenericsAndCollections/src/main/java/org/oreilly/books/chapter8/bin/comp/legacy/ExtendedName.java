package org.oreilly.books.chapter8.bin.comp.legacy;

class ExtendedName extends SimpleName {
	private String ext;

	public ExtendedName(String base, String ext) {
		super(base);
		this.ext = ext;
	}

	public int compareTo(Object o) {
		int c = super.compareTo(o);
		if (c == 0 && o instanceof ExtendedName)
			return ext.compareTo(((ExtendedName) o).ext);
		else
			return c;
	}
}
