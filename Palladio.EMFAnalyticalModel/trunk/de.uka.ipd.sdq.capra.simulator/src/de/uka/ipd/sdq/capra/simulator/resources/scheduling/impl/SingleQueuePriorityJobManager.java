package de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.CapraSim;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IPreemptiveJobManager;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IScheduledJob;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author     jens.happe
 */
public class SingleQueuePriorityJobManager implements IPreemptiveJobManager {

	private static final int MAX_PRIORITY = 2;

	JobQueue activeJobQueue;

	double timeslice;

	private PreemptiveProcess lastProcess = null;

	public SingleQueuePriorityJobManager(double timeslice) {
		activeJobQueue = new JobQueue(MAX_PRIORITY);
		this.timeslice = timeslice;
	}

	public int getNumberOfJobs() {
		return activeJobQueue.getNumJobs();
	}

	public IScheduledJob dequeue() {
		return activeJobQueue.dequeue();
	}

	public void enqueue(IScheduledJob job) {
		activeJobQueue.enqueue(job);
	}

	public void addJob(IScheduledJob job) {
		CapraSim.logger.info(Sim.time() + "\t  " + job.getProcess().getName()
				+ "(" + job.getProcess().getPriority() + ") demands #"
				+ MathTools.round(job.getRemainingDemand(), 0.001));

		if (job.getProcess() == lastProcess) {
			activeJobQueue.enqueueFirst(job);
		} else {
			activeJobQueue.enqueue(job);
		}
	}

	private void resetTimeSlice(IScheduledJob job) {
		job.getProcess().setRemainingTimeSlice(timeslice);
		job.getProcess().setActive(false);
	}

	public void notifyPriorityChange(IScheduledJob job, int from, int to) {
		activeJobQueue.notifyPriorityChange(job, from, to);
	}

	public void removeFinishedJob(IScheduledJob job) {
		lastProcess = job.timeSliceFinished() ? null : job.getProcess();
		activeJobQueue.removeJob(job);
	}

	@Override
	public IScheduledJob getCurrentJob() {
		return activeJobQueue.peek();
	}

	@Override
	public void requestNewTimeSlice(IScheduledJob job) {
		assert (job == activeJobQueue.peek());
		activeJobQueue.dequeue();
		resetTimeSlice(job);
		// TODO: where to decrease priorities?
		job.getProcess().decreasePriority();
		activeJobQueue.enqueue(job);
	}

	@Override
	public void balanceQueues() {
		activeJobQueue.setActive();
	}
}
