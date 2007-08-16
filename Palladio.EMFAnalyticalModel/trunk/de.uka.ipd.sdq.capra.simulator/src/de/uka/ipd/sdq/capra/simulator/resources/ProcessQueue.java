package de.uka.ipd.sdq.capra.simulator.resources;

import java.util.ArrayDeque;
import java.util.Deque;

public class ProcessQueue<T> {

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
}
