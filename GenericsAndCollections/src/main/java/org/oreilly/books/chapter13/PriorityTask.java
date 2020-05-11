package org.oreilly.books.chapter13;

import org.oreilly.books.chapter12.Task;

public class PriorityTask implements Comparable<PriorityTask> {
	private final Task task;
	private final Priority priority;

	public PriorityTask(Task task, Priority priority) {
		this.task = task;
		this.priority = priority;
	}

	public Task getTask() {
		return task;
	}

	public Priority getPriority() {
		return priority;
	}

	@Override
	public int compareTo(PriorityTask pt) {
		int c = priority.compareTo(pt.priority);
		return c != 0 ? c : task.compareTo(pt.task);
	}

	@Override
	public boolean equals(Object o) {
		if (o instanceof PriorityTask) {
			PriorityTask pt = (PriorityTask) o;
			return task.equals(pt.task) && priority.equals(pt.priority);
		} else
			return false;
	}

	@Override
	public int hashCode() {
		return task.hashCode();
	}

	@Override
	public String toString() {
		return task + ": " + priority;
	}
}
