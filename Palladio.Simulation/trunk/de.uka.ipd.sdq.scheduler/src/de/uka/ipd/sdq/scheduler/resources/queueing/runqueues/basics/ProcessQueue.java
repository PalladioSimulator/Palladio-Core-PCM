package de.uka.ipd.sdq.scheduler.resources.queueing.runqueues.basics;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import de.uka.ipd.sdq.scheduler.processes.ActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;

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

	@SuppressWarnings("unchecked")
	public boolean containsRunnableFor(SimResourceInstance instance) {
		Iterator iterator = this.queue.iterator();
		while(iterator.hasNext()){
			ActiveProcess process = (ActiveProcess)iterator.next();
			if(process.checkAffinity(instance))
				return true;
		}
		return false;
	}

}
