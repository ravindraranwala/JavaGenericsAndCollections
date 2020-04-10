package org.oreilly.books.chapter6;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.RandomAccess;

public class ArrayList<E> extends AbstractList<E> implements RandomAccess {
	private E[] arr;
	private int size = 0;

	public ArrayList(int cap) {
		if (cap < 0)
			throw new IllegalArgumentException("Illegal Capacity: " + cap);
		arr = (E[]) new Object[cap]; // unchecked
	}

	public ArrayList() {
		this(10);
	}

	public ArrayList(Collection<? extends E> c) {
		this(c.size());
		addAll(c);
	}

	public void ensureCapacity(int mincap) {
		int oldcap = arr.length;
		if (mincap > oldcap) {
			int newcap = Math.max(mincap, (oldcap * 3) / 2 + 1);
			E[] oldarr = arr;
			arr = (E[]) new Object[newcap]; // unchecked cast
			System.arraycopy(oldarr, 0, arr, 0, size);
		}
	}

	private void checkBounds(int i, int size) {
		if (i < 0 || i >= size)
			throw new IndexOutOfBoundsException("Index: " + i + ", Size: " + size);
	}

	@Override
	public E get(int index) {
		checkBounds(index, size);
		return arr[index];
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public E set(int index, E element) {
		checkBounds(index, size);
		E old = arr[index];
		arr[index] = element;
		return old;
	}

	@Override
	public void add(int index, E element) {
		checkBounds(index, size + 1);
		ensureCapacity(size + 1);
		System.arraycopy(arr, index, arr, index + 1, size - index);
		arr[index] = element;
		size++;
	}

	@Override
	public E remove(int index) {
		checkBounds(index, size);
		E old = arr[index];
		arr[index] = null;
		size--;
		System.arraycopy(arr, index + 1, arr, index, size - index);
		return old;
	}

	@Override
	public Object[] toArray() {
		return toArray(new Object[0]);
	}

	@Override
	public <T> T[] toArray(T[] a) {
		if (a.length < size) {
			a = GenericArray.newInstance(a, size);
		}
		System.arraycopy(arr, 0, a, 0, size);
		if (size < a.length)
			a[size] = null;
		return a;
	}

	public static void main(String[] args) {
		List<String> l = new ArrayList<String>(Arrays.asList("this", "is", "a", "test"));
		assert l.toString().equals("[this, is, a, test]");
		l.add(2, "only");
		assert l.toString().equals("[this, is, only, a, test]");
		l.add(0, "is");
		assert l.toString().equals("[is, this, is, only, a, test]");
		String s = l.remove(2);
		assert s.equals("is");
		assert l.toString().equals("[is, this, only, a, test]");
		l.set(2, "just");
		assert l.toString().equals("[is, this, just, a, test]");
		String[] a = l.toArray(new String[0]);
		assert Arrays.toString(a).equals("[is, this, just, a, test]");
		String[] b = { "x", "x", "x", "x", "x", "x", "x", "x" };
		l.toArray(b);
		assert Arrays.toString(b).equals("[is, this, just, a, test, null, x, x]");
		System.out.println(l);
	}

}
