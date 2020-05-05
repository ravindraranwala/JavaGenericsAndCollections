package org.oreilly.books.chapter12;

import static org.oreilly.books.chapter11.StaticTestData.databaseCode;
import static org.oreilly.books.chapter11.StaticTestData.interfaceCode;
import static org.oreilly.books.chapter11.StaticTestData.logicCode;
import static org.oreilly.books.chapter11.StaticTestData.mikePhone;
import static org.oreilly.books.chapter11.StaticTestData.mondayTasks;
import static org.oreilly.books.chapter11.StaticTestData.paulPhone;
import static org.oreilly.books.chapter11.StaticTestData.tuesdayTasks;

import java.util.NavigableSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

import org.oreilly.books.chapter11.EmptyTask;
import org.oreilly.books.chapter11.Task;

public class SortedSetTest {
	public static void main(String[] args) {
		Set<Task> naturallyOrderedTasks = new TreeSet<Task>(mondayTasks);
		naturallyOrderedTasks.addAll(tuesdayTasks);
		assert naturallyOrderedTasks.toString().equals("[code db, code gui, code logic, phone Mike, phone Paul]");
		
		NavigableSet<PriorityTask> priorityTasks = new TreeSet<PriorityTask>();
		priorityTasks.add(new PriorityTask(mikePhone, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(paulPhone, Priority.HIGH));
		priorityTasks.add(new PriorityTask(databaseCode, Priority.MEDIUM));
		priorityTasks.add(new PriorityTask(interfaceCode, Priority.LOW));
		assert (priorityTasks.toString())
				.equals("[phone Paul: HIGH, code db: MEDIUM, phone Mike: MEDIUM, code gui: LOW]");
		
		PriorityTask firstLowPriorityTask = new PriorityTask(new EmptyTask(), Priority.LOW);
		SortedSet<PriorityTask> highAndMediumPriorityTasks = priorityTasks.headSet(firstLowPriorityTask);
		assert highAndMediumPriorityTasks.toString().equals("[phone Paul: HIGH, code db: MEDIUM, phone Mike: MEDIUM]");
		
		PriorityTask firstMediumPriorityTask = new PriorityTask(new EmptyTask(), Priority.MEDIUM);
		SortedSet<PriorityTask> mediumPriorityTasks = priorityTasks.subSet(firstMediumPriorityTask,
				firstLowPriorityTask);
		assert mediumPriorityTasks.toString().equals("[code db: MEDIUM, phone Mike: MEDIUM]");
		
		PriorityTask logicCodeMedium = new PriorityTask(logicCode, Priority.MEDIUM);
		priorityTasks.add(logicCodeMedium);
		assert mediumPriorityTasks.toString().equals("[code db: MEDIUM, code logic: MEDIUM, phone Mike: MEDIUM]");
		
		mediumPriorityTasks.remove(logicCodeMedium);
		assert priorityTasks.toString()
				.equals("[phone Paul: HIGH, code db: MEDIUM, phone Mike: MEDIUM, code gui: LOW]");
		
		PriorityTask nextTask = priorityTasks.pollFirst();
		assert nextTask.toString().equals("phone Paul: HIGH");
		
		PriorityTask mikePhoneMedium = new PriorityTask(mikePhone, Priority.MEDIUM);
		NavigableSet<PriorityTask> closedInterval = priorityTasks.subSet(firstMediumPriorityTask, true, mikePhoneMedium, true);
		assert (closedInterval.toString()).equals("[code db: MEDIUM, phone Mike: MEDIUM]");
	}
}
