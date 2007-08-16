package de.uka.ipd.sdq.scheduler.resources.queueing;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

public class ProcessQueue<T> implements Iterable<T> {

	private Deque<T> queue;
	
	
	public ProcessQueue(){
		queue = new ArrayDeque<T>();
	}

	public void addLast(T process) {
		queue.addLast(process);
	}

	public T peek() {
		return queue.peek();
	}

	public T poll() {
		return queue.poll();
	}

	public void addFirst(T process) {
		queue.addFirst(process);
	}

	/**
	 */
	public int getNumberOfProcesses() {
		return queue.size();
	}

	public boolean remove(T process) {
		return queue.remove(process);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	@Override
	public Iterator<T> iterator() {
		return queue.iterator();
	}
}
