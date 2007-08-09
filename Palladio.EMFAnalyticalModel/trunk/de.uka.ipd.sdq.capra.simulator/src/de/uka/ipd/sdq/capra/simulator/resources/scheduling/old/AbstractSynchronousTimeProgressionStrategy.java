package de.uka.ipd.sdq.capra.simulator.resources.scheduling.old;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IJobManager;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.AbstractSchedulingStrategy;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveJob;


public abstract class AbstractSynchronousTimeProgressionStrategy extends AbstractSchedulingStrategy {

	protected List<PreemptiveJob> jobList = new ArrayList<PreemptiveJob>();
	
	public AbstractSynchronousTimeProgressionStrategy(IJobManager jobManager) {
		super(jobManager);
	}
	
	@Override
	protected PreemptiveJob getNextJobToBeFinished() {
		PreemptiveJob currentJob = null;
		double currentDemand = Double.MAX_VALUE;
		for (PreemptiveJob j : jobManager) {
			if (j.getRemainingDemand() < currentDemand) {
				currentDemand = j.getRemainingDemand();
				currentJob = j;
			}
		}
		if (currentJob != null) {
			double remainingTime = currentJob.getRemainingDemand() * jobManager.getNumberOfJobs();
			currentJob.setTimeToFinish(remainingTime);
		}
		return currentJob;
	}

	protected abstract double computeProcessedDemand(double passedTime);
	
	@Override
	protected void progressTimeBy(double passedTime) {
		double processedDemand = computeProcessedDemand(passedTime);
		for (PreemptiveJob j : jobManager){
			j.subtractFromDemand(processedDemand);
		}
	}

	@Override
	public double getTimeSliceFor(ScheduledProcess scheduledProcess) {
		return 0;
	}
}