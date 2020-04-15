package org.oreilly.books.chapter8;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class WaryClient {
	public static void main(String[] args) {
		processItems();
	}

    public static void processItems() {
        List<Integer> list = new ArrayList<Integer>();
        List<Integer> view = Collections.checkedList(list, Integer.class);
        LegacyLibrary.addItems(view);  // class cast exception
        List<Integer> list2 = LegacyLibrary.getItems(); // unchecked
        for (int i : list2) {}  // class cast exception
        // sometime later ...
        int s = 0;
        for (int i : list) s += i;
        for (int i : list2) s += i;
    }
}
