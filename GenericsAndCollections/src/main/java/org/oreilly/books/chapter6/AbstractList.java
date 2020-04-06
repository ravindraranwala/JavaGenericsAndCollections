package org.oreilly.books.chapter6;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public abstract class AbstractList<E> extends AbstractCollection<E> implements List<E> {

	@Override
	public boolean equals(Object o) {
		if (o instanceof List<?>) {
			Iterator<E> it1 = iterator();
			Iterator<?> it2 = ((List<?>) o).iterator();
			while (it1.hasNext() && it2.hasNext()) {
				E e1 = it1.next();
				Object e2 = it2.next();
				if (!(e1 == null ? e2 == null : e1.equals(e2)))
					return false;
			}
			return !it1.hasNext() && !it2.hasNext();
		} else
			return false;
	}

	public static <T> List<T> asList(Collection<T> c) {
		if (c instanceof List<?>) {
			return (List<T>) c; // This nonreifiable cast is permitted.
		} else
			throw new IllegalArgumentException("Argument not a list");
	}
}
