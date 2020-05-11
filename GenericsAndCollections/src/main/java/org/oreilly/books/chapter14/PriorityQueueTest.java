package org.oreilly.books.chapter14;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;
import static org.oreilly.books.chapter12.StaticTestData.*;

import org.oreilly.books.chapter13.Priority;
import org.oreilly.books.chapter13.PriorityTask;

public class PriorityQueueTest {

	public static void main(String[] args) {
		final int INITIAL_CAPACITY = 10;
		Comparator<PriorityTask> priorityComp = new Comparator<PriorityTask>() {
			public int compare(PriorityTask o1, PriorityTask o2) {
				return o1.getPriority().compareTo(o2.getPriority());
			}
		};
		Queue<PriorityTask> priorityQueue = new PriorityQueue<PriorityTask>(INITIAL_CAPACITY, priorityComp);
		priorityQueue.add(new PriorityTask(mikePhone, Priority.MEDIUM));
		priorityQueue.add(new PriorityTask(paulPhone, Priority.HIGH));

		PriorityTask nextTask = priorityQueue.poll();
		assert nextTask.toString().equals("phone Paul: HIGH");
	}

}
