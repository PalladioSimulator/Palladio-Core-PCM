package de.uka.ipd.sdq.capra.simulator.resources.scheduling;

import java.util.ArrayList;
import java.util.List;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.resources.Job;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public abstract class AbstractSchedulingStrategy implements ISchedulingStrategy {

	protected List<Job> jobList = new ArrayList<Job>();
	protected double lastVisitTime = 0;

	public AbstractSchedulingStrategy() {
		super();
	}

	@Override
	public void addJob(Job j) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		jobList.add(j);
	}

	@Override
	public Job getNextJobToBeFinished() {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		Job currentJob = null;
		double currentDemand = Double.MAX_VALUE;
		for (Job j : jobList) {
			if (j.getRemainingDemand() < currentDemand) {
				currentDemand = j.getRemainingDemand();
				currentJob = j;
			}
		}
		if (currentJob != null) {
			double remainingTime = currentJob.getRemainingDemand() * jobList.size();
			currentJob.setRemainingTime(remainingTime);
		}
		return currentJob;
	}

	@Override
	public void jobFinishedCallback(Job j) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		assert(j.getRemainingDemand() < MathTools.EPSILON_ERROR);
		jobList.remove(j);
	}

}