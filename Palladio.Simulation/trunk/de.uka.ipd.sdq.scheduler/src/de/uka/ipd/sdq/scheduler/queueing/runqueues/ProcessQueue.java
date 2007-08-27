package de.uka.ipd.sdq.scheduler.queueing.runqueues;

import java.util.ArrayDeque;
import java.util.Iterator;

import de.uka.ipd.sdq.scheduler.IRunningProcess;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class ProcessQueue<T> {

	private ArrayDeque<T> queue;
	
	
	public ProcessQueue(){
		queue = new ArrayDeque<T>();
	}

	public void addLast(T process) {
		queue.addLast(process);
	}

	public void addFirst(T process) {
		queue.addFirst(process);
	}
	
	public void add(T process, boolean inFront){
		if (inFront) 
			queue.addFirst(process);
		else
			queue.addLast(process);
	}

	public T peek() {
		return queue.peek();
	}

	public T poll() {
		return queue.poll();
	}

	/**
	 */
	public int size() {
		return queue.size();
	}

	public boolean remove(T process) {
		return queue.remove(process);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Iterable<T> ascending(){
		return new Iterable<T>(){
			@Override
			public Iterator<T> iterator() {
				return queue.iterator();
			}
		};
	}
	
	public Iterable<T> descending(){
		return new Iterable<T>(){
			@Override
			public Iterator<T> iterator() {
				return queue.descendingIterator();
			}
		};
	}

	@SuppressWarnings("unchecked")
	public boolean containsRunnableFor(IResourceInstance instance) {
		Iterator iterator = this.queue.iterator();
		while(iterator.hasNext()){
			IActiveProcess process = (IActiveProcess)iterator.next();
			if(process.checkAffinity(instance))
				return true;
		}
		return false;
	}

	public boolean contains(IRunningProcess process) {
		return queue.contains(process);
	}

}
