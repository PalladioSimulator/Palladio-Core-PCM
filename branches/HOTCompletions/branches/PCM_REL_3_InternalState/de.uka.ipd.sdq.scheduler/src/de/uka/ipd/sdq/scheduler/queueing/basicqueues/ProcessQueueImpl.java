package de.uka.ipd.sdq.scheduler.queueing.basicqueues;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Simulator;

import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;
import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.queueing.IProcessQueue;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class ProcessQueueImpl implements IProcessQueue {

	private ArrayDeque<IActiveProcess> queue;
	private Hashtable<IActiveProcess, Double> waiting_time_table = new Hashtable<IActiveProcess, Double>();
	private Simulator simulator;
	
	public ProcessQueueImpl(){
		this.simulator = SchedulingFactory.getUsedSimulator();
		queue = new ArrayDeque<IActiveProcess>();
	}

	public void addLast(IActiveProcess process) {
		waiting_time_table.put(process, simulator.time());
		queue.addLast(process);
	}

	public void addFirst(IActiveProcess process) {
		waiting_time_table.put(process, simulator.time());
		queue.addFirst(process);
	}
	
	public void add(IActiveProcess process, boolean inFront){
		if (inFront) 
			addFirst(process);
		else
			addLast(process);
	}

	public IActiveProcess peek() {
		return queue.peek();
	}

	public IActiveProcess poll() {
		IActiveProcess process = queue.poll();
		waiting_time_table.remove(process);
		return process;
	}

	public int size() {
		return queue.size();
	}

	public boolean remove(IActiveProcess process) {
		waiting_time_table.remove(process);
		return queue.remove(process);
	}

	public boolean isEmpty() {
		return queue.isEmpty();
	}

	public Iterable<IActiveProcess> ascending(){
		return new Iterable<IActiveProcess>(){
			public Iterator<IActiveProcess> iterator() {
				return queue.iterator();
			}
		};
	}
	
	public Iterable<IActiveProcess> descending(){
		return new Iterable<IActiveProcess>(){
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

	public IProcessQueue getBestRunnableQueue(IResourceInstance instance) {
		if (containsRunnableFor(instance))
			return this;
		return null;
	}

	public IActiveProcess getNextRunnableProcess(IResourceInstance instance) {
		for (IActiveProcess process : ascending()) {
			if (process.checkAffinity(instance))
				return process;
		}
		return null;
	}

	public IActiveProcess getNextRunnableProcess() {
		return peek();
	}

	public void identifyMovableProcesses(
			IResourceInstance targetInstance, boolean prio_increasing,
			boolean queue_ascending, int processes_needed, List<IActiveProcess> process_list) {
		Iterable<IActiveProcess> queue_direction = queue_ascending ? ascending() : descending();
		for (IActiveProcess process : queue_direction) {
			if (process.isMovable(targetInstance)) {
				process_list.add(process);
				if (process_list.size() >= processes_needed)
					break;
			}
		}
	}

	public IProcessQueue createNewInstance() {
		return new ProcessQueueImpl();
	}

	
	public boolean processStarving(double threshold) {
		double now = simulator.time();
		for (IActiveProcess process : ascending()){
			double waiting_time = now - waiting_time_table.get(process);
			if (waiting_time > threshold)
				return true;
		}
		return false;
	}
	
	public void setWaitingTime(IActiveProcess process, double waiting) {
		waiting_time_table.put(process, waiting);
	}
	
	public double getWaitingTime(IActiveProcess process) {
		return waiting_time_table.get(process);
	}

	public List<IActiveProcess> getStarvingProcesses(double starvationLimit) {
		double now = simulator.time();
		List<IActiveProcess> result = new ArrayList<IActiveProcess>();
		for (IActiveProcess process : ascending()){
			double waiting_time = now - waiting_time_table.get(process);
			if (waiting_time > starvationLimit){
				result.add(process);
			}
		}
		return result;
	}
}
