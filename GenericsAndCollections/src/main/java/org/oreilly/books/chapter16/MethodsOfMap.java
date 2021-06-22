package org.oreilly.books.chapter16;

import static org.oreilly.books.chapter12.StaticTestData.databaseCode;
import static org.oreilly.books.chapter12.StaticTestData.interfaceCode;
import static org.oreilly.books.chapter12.StaticTestData.mikePhone;

import java.util.ArrayDeque;
import java.util.Collection;
import java.util.Collections;
import java.util.EnumMap;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;

import org.oreilly.books.chapter12.Task;
import org.oreilly.books.chapter13.Priority;

public class MethodsOfMap {

	private MethodsOfMap() {
		throw new AssertionError();
	}

	public static void main(String[] args) {
		final Map<Priority, Queue<Task>> taskMap = new EnumMap<>(Priority.class);
		for (Priority p : Priority.values()) {
			taskMap.put(p, new ArrayDeque<>());
		}
		// populate the lists, for example:
		taskMap.get(Priority.MEDIUM).add(mikePhone);
		taskMap.get(Priority.HIGH).add(databaseCode);
		final Queue<Task> highPriorityTaskList = taskMap.get(Priority.HIGH);

		// Handling billable tasks.
		final Map<Task, Client> billingMap = new HashMap<>();
		final Client acme = new Client("Acme Corp.");
		billingMap.put(interfaceCode, acme);

		Client client = billingMap.get(interfaceCode);
		if (client != null)
			client.bill(interfaceCode);

		/*
		 * Once finished all the work we were contracted to do by our client Acme Corp.
		 * the map entries that associate tasks with Acme can be removed.
		 */
		final Collection<Client> clients = billingMap.values();
		for (Iterator<Client> it = clients.iterator(); it.hasNext();)
			if (it.next().equals(acme))
				it.remove();

		// A neater alternative to the above approach would be:
		clients.removeAll(Collections.singleton(acme));
	}

}
