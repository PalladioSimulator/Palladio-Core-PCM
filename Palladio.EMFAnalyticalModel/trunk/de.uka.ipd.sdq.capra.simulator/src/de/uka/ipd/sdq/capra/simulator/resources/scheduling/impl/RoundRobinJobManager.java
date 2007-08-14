package de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl;

import java.util.ArrayDeque;
import java.util.Deque;

import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IPreemptiveJobManager;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IScheduledJob;

/**
 * @author     jens.happe
 */
public class RoundRobinJobManager implements IPreemptiveJobManager {
	
	private Deque<IScheduledJob> jobQueue;
	
	private PreemptiveProcess lastProcess = null;
	
	private double timeslice;
	
	public RoundRobinJobManager(double timeslice){
		jobQueue = new ArrayDeque<IScheduledJob>();
		this.timeslice = timeslice;
	}

	@Override
	public int getNumberOfJobs() {
		return jobQueue.size();
	}

	public IScheduledJob dequeue() {
		return jobQueue.pollFirst();
	}

	public void enqueue(IScheduledJob job) {
		jobQueue.addLast(job);
	}

	@Override
	public void addJob(IScheduledJob job) {
		if (job.getProcess() == lastProcess && !lastProcess.timeSliceFinished()){
			jobQueue.addFirst(job);
		} else {
			resetTimeSlice(job);
			jobQueue.addLast(job);
		}
	}

	@Override
	public void removeFinishedJob(IScheduledJob job) {
		lastProcess = job.timeSliceFinished() ? null : job.getProcess();
		jobQueue.remove(job);
	}

	@Override
	public IScheduledJob getCurrentJob() {
		return jobQueue.peek();
	}

	@Override
	public void requestNewTimeSlice(IScheduledJob job) {
		assert (job == jobQueue.peekFirst());
		jobQueue.pollFirst();
		resetTimeSlice(job);
		jobQueue.addLast(job);
	}
	
	private void resetTimeSlice(IScheduledJob job) {
		job.getProcess().setRemainingTimeSlice(timeslice);
	}

	@Override
	public void balanceQueues() {
		// nothing to do.
	}

}
