package org.oreilly.books.chapter3;

import java.util.Arrays;
import java.util.List;

public final class FruitProhibit {

	public static void main(String[] args) {
		List<Apple> apples = Arrays.<Apple>asList(new Apple(1), new Apple(10));
		List<Orange> oranges = Arrays.<Orange>asList(new Orange(1), new Orange(10));
		List<Fruit> fruits = Arrays.<Fruit>asList(new Apple(1), new Orange(10));
		assert Maximum.max(apples).equals(new Apple(10));
		assert Maximum.max(oranges).equals(new Orange(10));
		// assert Maximum.max(fruits).equals(new Orange(10)); // compile-time error
		System.out.println(Maximum.max(apples));
		System.out.println(Maximum.max(oranges));
	}

	static class Fruit {
		protected final String name;
		protected final int size;

		public Fruit(String name, int size) {
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
			int result = name.hashCode();
			result = 31 * result + Integer.hashCode(size);
			return result;
		}

		public String toString() {
			return this.name + "(" + size + ")";
		}
	}

	static class Orange extends Fruit implements Comparable<Orange> {
		public Orange(int size) {
			super("Orange", size);
		}

		public int compareTo(Orange that) {
			return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
		}
	}

	static class Apple extends Fruit implements Comparable<Apple> {
		public Apple(int size) {
			super("Apple", size);
		}

		public int compareTo(Apple that) {
			return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
		}
	}
}
