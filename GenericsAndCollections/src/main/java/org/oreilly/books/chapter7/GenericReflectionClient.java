package org.oreilly.books.chapter7;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.InvocationTargetException;
import java.util.Collection;

public class GenericReflectionClient {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException {
		Integer[] ints = new Integer[] { 1, 2 };
		Number[] nums = ints;
		Number[] newNums = GenericReflection.newArray(nums, 2);
		assert newNums.getClass() == Integer[].class;

		// No such compile time checking is performed. you get the exception at runtime,
		// even though it is a checked exception. This forces you to catch a generic
		// exception and handle it where as the other allows you to catch
		// InvocationTargetException and handle it by accessing the cause nicely.
		// Dummy.class.newInstance();

		System.out.println(String.class.getComponentType());

		// compile time checking is performed.
		// new Dummy();
	}

	public static <T, C extends Collection<T>> C copy(C coll) {
		try {
			C copy = GenericReflection.newInstance(coll);
			copy.addAll(coll);
			return copy;
		} catch (InstantiationException | IllegalAccessException | InvocationTargetException
				| NoSuchMethodException e) {
			throw new IllegalArgumentException(e);
		}
	}

	public static <T> T[] toArray(Collection<T> c, T[] a) {
		if (a.length < c.size())
			a = GenericReflection.newArray(a, c.size());
		int i = 0;
		for (T x : c)
			a[i++] = x;
		if (i < a.length)
			a[i] = null;
		return a;
	}

	static class Dummy {
		public Dummy() throws IOException, FileNotFoundException {
			throw new FileNotFoundException("No such file exists");
		}
	}
}
