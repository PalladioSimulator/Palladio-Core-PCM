package de.uka.ipd.sdq.capra.simulator.resources.scheduling;

import java.util.ArrayDeque;
import java.util.Queue;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.resources.Job;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class FCFSStrategy implements ISchedulingStrategy {

	Queue<Job> jobQ = new ArrayDeque<Job>();
	double lastVisitTime = 0;

	@Override
	public void addJob(Job j) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		jobQ.add(j);
	}

	@Override
	public Job getNextJobToBeFinished() {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		Job job = jobQ.peek();
		job.setRemainingTime(job.getRemainingDemand());
		return job;
	}
 
	@Override
	public void jobFinishedCallback(Job j) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		assert(j.getRemainingDemand() < MathTools.EPSILON_ERROR);
		assert(j == jobQ.peek());
		jobQ.poll();
	}

	public void progressInTime() {
		double currentTime = Sim.time();
		double passedTime = currentTime - lastVisitTime;
		lastVisitTime = currentTime;
		Job j = jobQ.peek();
		if (j != null) {
			j.subtractFromDemand(passedTime);
		}
	}
}
