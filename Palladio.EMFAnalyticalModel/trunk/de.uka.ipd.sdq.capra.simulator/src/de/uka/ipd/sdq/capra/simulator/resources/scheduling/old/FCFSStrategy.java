package de.uka.ipd.sdq.capra.simulator.resources.scheduling.old;

import java.util.ArrayDeque;
import java.util.Hashtable;
import java.util.Queue;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveJob;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class FCFSStrategy implements ISchedulingStrategy {

	private Queue<PreemptiveJob> jobQ = new ArrayDeque<PreemptiveJob>();
	private double lastVisitTime = 0;
	protected Hashtable<SimCapraProcess, ScheduledProcess> processTable = new Hashtable<SimCapraProcess, ScheduledProcess>();


	@Override
	public void addJob(PreemptiveJob j) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		jobQ.add(j);
	}

	@Override
	public PreemptiveJob getNextJobToBeFinishedWithAssertion() {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		PreemptiveJob job = jobQ.peek();
		job.setTimeToFinish(job.getRemainingDemand());
		return job;
	}
 
	@Override
	public void jobFinishedCallback(PreemptiveJob j) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		assert(j.getRemainingDemand() < MathTools.EPSILON_ERROR);
		assert(j == jobQ.peek());
		jobQ.poll();
	}

	public void progressInTime() {
		double currentTime = Sim.time();
		double passedTime = currentTime - lastVisitTime;
		lastVisitTime = currentTime;
		PreemptiveJob j = jobQ.peek();
		if (j != null) {
			j.subtractFromDemand(passedTime);
		}
	}
	@Override
	public ScheduledProcess getScheduledProcess(SimCapraProcess capraProcess) {
		ScheduledProcess result = processTable.get(capraProcess);
		if (result == null){
			result = new ScheduledProcess(capraProcess,this);
			processTable.put(capraProcess, result);
		}
		return result;
	}

	@Override
	public double getTimeSliceFor(ScheduledProcess scheduledProcess) {
		return 0;
	}
}
