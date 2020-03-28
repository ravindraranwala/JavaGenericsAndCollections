package org.oreilly.books.chapter3;

import java.util.Arrays;
import java.util.List;

public final class FruitPermit1 {

	public static void main(String[] args) {
		Apple a1 = new Apple(1);
		Apple a2 = new Apple(2);
		Orange o3 = new Orange(3);
		Orange o4 = new Orange(4);
		List<Apple> apples = Arrays.asList(a1, a2);
		assert Comparisons.max4(apples).equals(a2);
		List<Orange> oranges = Arrays.asList(o3, o4);
		assert Comparisons.max4(oranges).equals(o4);

		List<Fruit> mixed = Arrays.<Fruit>asList(a1, o3);
		assert Comparisons.max4(mixed).equals(o3); // ok
	}

	static abstract class Fruit implements Comparable<Fruit> {
		protected final String name;
		protected final int size;

		protected Fruit(String name, int size) {
			this.name = name;
			this.size = size;
		}

		@Override
		public boolean equals(Object o) {
			if (o instanceof Fruit) {
				Fruit that = (Fruit) o;
				return this.name.equals(that.name) && this.size == that.size;
			}
			return false;
		}

		@Override
		public int hashCode() {
			return name.hashCode() * 29 + Integer.hashCode(size);
		}

		public int compareTo(Fruit that) {
			return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
		}
	}

	static class Apple extends Fruit {
		public Apple(int size) {
			super("Apple", size);
		}
	}

	static class Orange extends Fruit {
		public Orange(int size) {
			super("Orange", size);
		}
	}
}
