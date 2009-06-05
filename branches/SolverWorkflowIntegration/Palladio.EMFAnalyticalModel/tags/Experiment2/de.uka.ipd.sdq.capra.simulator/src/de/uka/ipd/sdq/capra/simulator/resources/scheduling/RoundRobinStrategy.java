package de.uka.ipd.sdq.capra.simulator.resources.scheduling;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;

import umontreal.iro.lecuyer.simevents.Sim;
import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.resources.Job;
import de.uka.ipd.sdq.probfunction.math.util.MathTools;

public class RoundRobinStrategy implements ISchedulingStrategy {

	private double timeSlice;
	
	Deque<Job> jobQueue = new ArrayDeque<Job>();

	protected double lastVisitTime = 0;

	protected double remainingTime = 0;
	
	protected SimCapraProcess lastProcessed = null;
	protected double remainingTimeSlice = 0;
	
	
	
	
	public RoundRobinStrategy(double timeSlice) {
		super();
		this.timeSlice = timeSlice;
	}

	@Override
	public void addJob(Job j) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		if (j.getProcess().equals(lastProcessed)){
			jobQueue.addFirst(j);
			remainingTime = remainingTimeSlice;
		} else {
			jobQueue.add(j);					
		}
	}

	@Override
	public Job getNextJobToBeFinished() {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		Job selected = null;
		int selectedNumTimeSlices = Integer.MAX_VALUE;
		
		int pos = 0;
		int i = 0;
		
		for(Iterator<Job> jobIterator = jobQueue.iterator(); jobIterator.hasNext();){
			Job current = jobIterator.next();
			int currentNumTimeSlices = (int)(current.getRemainingDemand() / timeSlice);
			if (currentNumTimeSlices < selectedNumTimeSlices){
				selectedNumTimeSlices = currentNumTimeSlices;
				selected = current;
				pos = i;
				i++;
				if (currentNumTimeSlices == 0) break;
			}
		}
		if (selected != null){
			double rest = (selected.getRemainingDemand() % timeSlice);
			double waitingForAll = selectedNumTimeSlices * jobQueue.size() * timeSlice ;
			double waitingForRemaining = pos * timeSlice;
			double timeToFinish =  waitingForAll + waitingForRemaining + rest;
			selected.setRemainingTime(timeToFinish);
			return selected;
		} 
		return null;
	}

	@Override
	public void jobFinishedCallback(Job j) {
		assert(MathTools.equalsDouble(Sim.time(), lastVisitTime));
		assert(j.getRemainingDemand() < remainingTime + MathTools.EPSILON_ERROR);
		remainingTime = Math.max(remainingTime - j.getRemainingDemand(),0);
		jobQueue.remove(j);
	}

	@Override
	public void progressInTime() {

		double currentTime = Sim.time();
		double passedTime = currentTime - lastVisitTime;
		lastVisitTime = currentTime;
		
		// stop if no time has passed.
		if (MathTools.equalsDouble(passedTime, 0))
			return;
		
		passedTime += remainingTime;
		remainingTime = passedTime % timeSlice;

		int numTimeSlices = (int)(passedTime / timeSlice); 

		if (jobQueue.size() > 0){
			passTimeForAllJobs(numTimeSlices);
			passTimeForRemainder(numTimeSlices);
		}
	}

	private void passTimeForRemainder(int numTimeSlices) {
		int remainingTimeSlices = numTimeSlices % jobQueue.size();
		for (int i=0; i<remainingTimeSlices; i++){
			Job job = jobQueue.poll();
			job.subtractFromDemand(timeSlice);
			jobQueue.add(job);
		}
	}

	private void passTimeForAllJobs(int numTimeSlices) {
		int timeSlicesPassedForAll = numTimeSlices / jobQueue.size();
		double timePassedForAll = timeSlice * timeSlicesPassedForAll;
		
		if (timeSlicesPassedForAll > 0){
			for (Job job : jobQueue) {
				job.subtractFromDemand(timePassedForAll);
			}
		}
	}
}
