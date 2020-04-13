package org.oreilly.books.chapter7;

import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class GenericsForReflection {

	public static void main(String[] args) {
		Class ki = Integer.class;
		Number n = Integer.valueOf(42);
		Class kn = n.getClass();
		assert ki == kn;

		Class<Integer> ki2 = Integer.class;
		Number n2 = Integer.valueOf(42);
		Class<? extends Number> kn2 = n2.getClass();
		assert ki2 == kn2;

		Integer intVal = Integer.class.cast(1);
		System.out.println(intVal);

		Class<? super Integer> superClazz = Integer.class.getSuperclass();
		System.out.println(superClazz);

		Class<? extends Number> subClazz = Integer.class.asSubclass(Number.class);
		System.out.println(subClazz);

		Retention retention = Override.class.getAnnotation(Retention.class);
		System.out.println(retention);

		boolean annotationPresent = Override.class.isAnnotationPresent(Retention.class);
		System.out.println(annotationPresent);

		List<Integer> checkedList = Collections.checkedList(Arrays.asList(1, 2), Integer.class);
	}

}
