package de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl;

import java.util.ArrayDeque;
import java.util.Deque;

import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IScheduledJob;

public class JobQueue {

	int maxPriority;
	
	Deque<IScheduledJob>[] queue;
	
	int numJobs = 0;
	
	public JobQueue(int maxPriority){
		this.maxPriority = maxPriority;
		queue = new Deque[maxPriority];
		for (int i = 0; i < queue.length; i++) {
			queue[i] = new ArrayDeque<IScheduledJob>();
		}
	}
	
	public IScheduledJob dequeue() {
		return getQueueWithHighestPriority().pollFirst();
	}

	public void enqueue(IScheduledJob job) {
		getQueueFor(job).addLast(job);
	}

	public void enqueueFirst(IScheduledJob job) {
		getQueueFor(job).addFirst(job);
	}

	public void notifyPriorityChange(IScheduledJob job, int from, int to){
		if (queue[from].remove(job)){
			queue[to].add(job);
		}
	}

	public void removeJob(IScheduledJob job) {
		numJobs--;
		getQueueFor(job).remove(job);
	}

	public IScheduledJob peek() {
		return getQueueWithHighestPriority().peek();
	}

	public int getNumJobs() {
		return numJobs;
	}

	public void setNumJobs(int numJobs) {
		this.numJobs = numJobs;
	}

	private Deque<IScheduledJob> getQueueFor(IScheduledJob job) {
		return queue[job.getProcess().getPriority()];
	}

	private Deque<IScheduledJob> getQueueWithHighestPriority() {
		int i;
		for (i = maxPriority - 1; i >= 0; i--) {
			if (!queue[i].isEmpty()) {
				return queue[i];
			}
		}
		return queue[0];
	}

	public boolean isEmpty() {
		for (int i = maxPriority - 1; i >= 0; i--) {
			if (!queue[i].isEmpty()) {
				return false;
			}
		}
		return true;
	}

	public void setActive() {
		for (Deque<IScheduledJob> jobQueue : queue) {
			for (IScheduledJob job : jobQueue) {
				job.getProcess().setActive(true);
			}
		}
	}
}
