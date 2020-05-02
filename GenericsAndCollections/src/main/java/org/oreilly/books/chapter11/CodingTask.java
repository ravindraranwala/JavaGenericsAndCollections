package org.oreilly.books.chapter11;

public final class CodingTask extends Task {
	private final String spec;

	public CodingTask(String spec) {
		this.spec = spec;
	}

	public String getSpec() {
		return spec;
	}

	@Override
	public String toString() {
		return "code " + spec;
	}
}
