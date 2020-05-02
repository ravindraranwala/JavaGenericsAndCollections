package org.oreilly.books.chapter11;

public final class PhoneTask extends Task {
	private final String name;
	private final String number;

	public PhoneTask(String name, String number) {
		this.name = name;
		this.number = number;
	}

	public String getName() {
		return name;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return "phone " + name;
	}

}
