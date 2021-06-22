package org.oreilly.books.chapter16;

import org.oreilly.books.chapter12.Task;

class Client {
	private final String name;

	Client(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	@Override
	public int hashCode() {
		return name.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == this)
			return true;
		if (!(obj instanceof Client))
			return false;
		Client c = (Client) obj;
		return name.equals(c.name);
	}

	public void bill(Task t) {
		System.out.println("Perform billing...");
	}
}
