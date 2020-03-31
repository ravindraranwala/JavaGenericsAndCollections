package org.oreilly.books.chapter3;

import java.lang.reflect.Method;

public final class Bridges {

	public static void main(String[] args) {
		for (Method m : Integer.class.getMethods())
			if (m.getName().equals("compareTo"))
				System.out.println(m.toGenericString());

		Point p = new Point(1, 2);
		Point q = p.clone(); // casts not needed.

		for (Method m : Point.class.getMethods())
			if (m.getName().equals("clone"))
				System.out.println(m.toGenericString());
	}
}
