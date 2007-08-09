package de.uka.ipd.sdq.capra.simulator.resources.scheduling.old;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IJobManager;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveJob;

public class FCFSJobManager implements IJobManager {
	
	private Deque<PreemptiveJob> jobQueue;
	
	public FCFSJobManager(){
		jobQueue = new ArrayDeque<PreemptiveJob>();
	}

	@Override
	public void addJob(PreemptiveJob j) {
		jobQueue.addLast(j);

	}

	@Override
	public void notifyCompletion(PreemptiveJob j) {
		assert(jobQueue.peekFirst() == j);
		jobQueue.pollFirst();
	}

	@Override
	public int getNumberOfJobs() {
		return jobQueue.size();
	}

	@Override
	public Iterator<PreemptiveJob> iterator() {
		return jobQueue.iterator();
	}

}
