package org.oreilly.books.chapter8;

import java.util.ArrayList;
import java.util.List;

public class NaiveClient {
	public static void main(String[] args) {
		processItems();
	}

    public static void processItems() {
        List<Integer> list = new ArrayList<Integer>();
        LegacyLibrary.addItems(list);  
        List<Integer> list2 = LegacyLibrary.getItems(); // unchecked
        // some time later ...
        int s = 0;
        for (int i : list) s += i; // class cast exception
        for (int i : list2) s += i; // class cast exception
    }
}
