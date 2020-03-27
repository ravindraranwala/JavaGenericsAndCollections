package org.oreilly.books.chapter3;

import java.util.Arrays;
import java.util.List;

public final class FruitPermit {

	public static void main(String[] args) {
		List<Apple> apples = Arrays.asList(new Apple(1), new Apple(10));
		List<Orange> oranges = Arrays.asList(new Orange(1), new Orange(10));
		List<Fruit> fruits = Arrays.<Fruit>asList(new Apple(1), new Orange(10));
		assert Maximum.max4(apples).equals(new Apple(10));
		assert Maximum.max4(oranges).equals(new Orange(10));
		assert Maximum.max4(fruits).equals(new Orange(10)); // ok
		System.out.println(Maximum.max4(apples));
		System.out.println(Maximum.max4(oranges));
		System.out.println(Maximum.max4(fruits));
		Apple weeApple = new Apple(1);
		Apple bigApple = new Apple(2);
		apples = Arrays.asList(weeApple, bigApple);
		System.out.println(weeApple.compareTo(bigApple));
		System.out.println(Maximum.max4(apples) == bigApple);
	}

	static class Fruit implements Comparable<Fruit> {
		final String name;
		final int size;

		public Fruit(String name, int size) {
			this.name = name;
			this.size = size;
		}

		public int compareTo(Fruit that) {
			return this.size < that.size ? -1 : this.size == that.size ? 0 : 1;
		}

		public String toString() {
			return this.name + "(" + size + ")";
		}

		@Override
		public boolean equals(Object o) {
			return (o instanceof Fruit && name.equals(((Fruit) o).name) && size == ((Fruit) o).size);
		}

		@Override
		public int hashCode() {
			int result = name.hashCode();
			result = 31 * result + Integer.hashCode(size);
			return result;
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
