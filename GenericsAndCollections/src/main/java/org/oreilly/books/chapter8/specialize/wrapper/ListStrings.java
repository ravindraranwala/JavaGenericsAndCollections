package org.oreilly.books.chapter8.specialize.wrapper;

import java.util.AbstractList;
import java.util.AbstractSequentialList;
import java.util.List;
import java.util.ListIterator;
import java.util.RandomAccess;

public class ListStrings {
	public static ListString wrap(final List<String> list) {
		class Random extends AbstractList<String> implements ListString, RandomAccess {
			@Override
			public int size() {
				return list.size();
			}

			@Override
			public String get(int i) {
				return list.get(i);
			}

			@Override
			public String set(int i, String s) {
				return list.set(i, s);
			}

			@Override
			public String remove(int i) {
				return list.remove(i);
			}

			@Override
			public void add(int i, String s) {
				list.add(i, s);
			}

			@Override
			public ListString subList(int fromIndex, int toIndex) {
				// recursively applying wrap to the delegated call.
				return ListStrings.wrap(list.subList(fromIndex, toIndex));
			}
		}

		class Sequential extends AbstractSequentialList<String> implements ListString {
			@Override
			public int size() {
				return list.size();
			}

			@Override
			public ListIterator<String> listIterator(int index) {
				final ListIterator<String> it = list.listIterator(index);
				return new ListIterator<String>() {
					public void add(String s) {
						it.add(s);
					}

					public boolean hasNext() {
						return it.hasNext();
					}

					public boolean hasPrevious() {
						return it.hasPrevious();
					}

					public String next() {
						return it.next();
					}

					public int nextIndex() {
						return it.nextIndex();
					}

					public String previous() {
						return it.previous();
					}

					public int previousIndex() {
						return it.previousIndex();
					}

					public void remove() {
						it.remove();
					}

					public void set(String s) {
						it.set(s);
					}
				};
			}
		}
		return list instanceof RandomAccess ? new Random() : new Sequential();
	}
}
