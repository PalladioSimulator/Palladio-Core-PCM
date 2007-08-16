package de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.impl;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.CapraSim;
import de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.impl.JobQueue;
import de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.impl.PreemptiveProcess;
import de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.IPreemptiveJobManager;
import de.uka.ipd.sdq.capra.simulator.resources_old.scheduling.IScheduledJob;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

/**
 * @author     jens.happe
 */
public class DoubleQueuePriorityJobManager implements IPreemptiveJobManager {

	private static final int MAX_PRIORITY = 2;

	JobQueue activeJobQueue;
	JobQueue passiveJobQueue;
	
	double timeslice;
	
	private PreemptiveProcess lastProcess = null;

	public DoubleQueuePriorityJobManager(double timeslice) {
		activeJobQueue = new JobQueue(MAX_PRIORITY);
		passiveJobQueue = new JobQueue(MAX_PRIORITY);
		this.timeslice = timeslice;
	}

	public int getNumberOfJobs() {
		return activeJobQueue.getNumJobs() + passiveJobQueue.getNumJobs();
	}

	public IScheduledJob dequeue() {
		return activeJobQueue.dequeue();
	}

	public void enqueue(IScheduledJob job) {
		if (job.isActive()){
			activeJobQueue.enqueue(job);
		} else {
			passiveJobQueue.enqueue(job);
		}
	}

	public void addJob(IScheduledJob job) {
		CapraSim.logger.info(Sim.time() + "\t  " + job.getProcess().getName()+ "(" + job.getProcess().getPriority() + ") demands #" + MathTools.round(job.getRemainingDemand(),0.001));

		if (job.isActive()){
			if (job.getProcess() == lastProcess){
				activeJobQueue.enqueueFirst(job);
			} else {
				activeJobQueue.enqueue(job);
			}
		} else {
			passiveJobQueue.enqueue(job);
		}
	}
	
	private void resetTimeSlice(IScheduledJob job) {
		job.getProcess().setRemainingTimeSlice(timeslice);
		job.getProcess().setActive(false);
	}

	public void notifyPriorityChange(IScheduledJob job, int from, int to){
		activeJobQueue.notifyPriorityChange(job, from, to);
		passiveJobQueue.notifyPriorityChange(job, from, to);
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
//		TODO: 
		job.getProcess().decreasePriority();
		passiveJobQueue.enqueue(job);
	}

	@Override
	public void balanceQueues() {
		if (activeJobQueue.isEmpty()){
			JobQueue temp = activeJobQueue;
			activeJobQueue = passiveJobQueue;
			passiveJobQueue = temp;
			activeJobQueue.setActive();
		}
	}
}
