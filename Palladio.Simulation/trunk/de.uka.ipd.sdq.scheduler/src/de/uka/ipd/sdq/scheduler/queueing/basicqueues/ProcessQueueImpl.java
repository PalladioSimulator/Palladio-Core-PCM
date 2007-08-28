package de.uka.ipd.sdq.scheduler.queueing.basicqueues;

import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class ProcessQueueImpl implements IProcessQueue {

	private ArrayDeque<IActiveProcess> queue;
	
	public ProcessQueueImpl(){
		queue = new ArrayDeque<IActiveProcess>();
	}

	public void addLast(IActiveProcess process) {
		queue.addLast(process);
	}

	public void addFirst(IActiveProcess process) {
		queue.addFirst(process);
	}
	
	public void add(IActiveProcess process, boolean inFront){
		if (inFront) 
			queue.addFirst(process);
		else
			queue.addLast(process);
	}

	public IActiveProcess peek() {
		return queue.peek();
	}

	public IActiveProcess poll() {
		return queue.poll();
	}

	public int size() {
		return queue.size();
	}

	public boolean remove(IActiveProcess process) {
		return queue.remove(process);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Iterable<IActiveProcess> ascending(){
		return new Iterable<IActiveProcess>(){
			@Override
			public Iterator<IActiveProcess> iterator() {
				return queue.iterator();
			}
		};
	}
	
	public Iterable<IActiveProcess> descending(){
		return new Iterable<IActiveProcess>(){
			@Override
			public Iterator<IActiveProcess> iterator() {
				return queue.descendingIterator();
			}
		};
	}

	@SuppressWarnings("unchecked")
	private boolean containsRunnableFor(IResourceInstance instance) {
		Iterator iterator = this.queue.iterator();
		while(iterator.hasNext()){
			IActiveProcess process = (IActiveProcess)iterator.next();
			if(process.checkAffinity(instance))
				return true;
		}
		return false;
	}

	public boolean contains(IActiveProcess process) {
		return queue.contains(process);
	}

	@Override
	public IProcessQueue getBestRunnableQueue(IResourceInstance instance) {
		if (containsRunnableFor(instance))
			return this;
		return null;
	}

	@Override
	public IActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		for (IActiveProcess process : ascending()) {
			if (process.checkAffinity(instance))
				return process;
		}
		return null;
	}

	@Override
	public IActiveProcess getNextRunnableProcess() {
		return peek();
	}

	@Override
	public void identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing,
			boolean queue_ascending, int processes_needed, List<IActiveProcess> process_list) {
		Iterable<IActiveProcess> queue_direction = queue_ascending ? ascending() : descending();
		for (IActiveProcess process : queue_direction) {
			if (process.checkAffinity(targetInstance)) {
				process_list.add(process);
				if (process_list.size() >= processes_needed)
					break;
			}
		}
	}

	@Override
	public IProcessQueue createNewInstance() {
		return new ProcessQueueImpl();
	}

}
