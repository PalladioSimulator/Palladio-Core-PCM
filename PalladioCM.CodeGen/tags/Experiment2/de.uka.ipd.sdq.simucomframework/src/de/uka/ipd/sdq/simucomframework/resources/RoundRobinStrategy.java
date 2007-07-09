package de.uka.ipd.sdq.simucomframework.resources;

import java.util.ArrayList;

public class RoundRobinStrategy implements ISchedulingStrategy {

	protected ArrayList<JobAndDemandStruct> runQueue = new ArrayList<JobAndDemandStruct>();
	
	public void addJob(JobAndDemandStruct demand) {
		runQueue.add(demand);
	}

	public double getTimeWhenNextJobIsDone() {
		double currentMin = runQueue.get(0).getDemand();
		
		for(JobAndDemandStruct job : runQueue){
			if (job.getDemand() < currentMin)
				currentMin = job.getDemand();
		}
		return currentMin * runQueue.size();
	}

	public boolean hasMoreJobs() {
		return runQueue.size() > 0;
	}

	public void processPassedTime(double timePassed) {
		int count = runQueue.size();
		for(JobAndDemandStruct job : runQueue){
			job.reduceDemand(timePassed/count);
		}
	}

	public JobAndDemandStruct removeFinshedJob() {
		JobAndDemandStruct currentMin = runQueue.get(0);
		
		for(JobAndDemandStruct job : runQueue){
			if (job.getDemand() < currentMin.getDemand())
				currentMin = job;
		}
		if (Math.abs(currentMin.getDemand()) > Math.pow(10, -3))
			throw new RuntimeException("Job finished, but demand > 0");
		runQueue.remove(currentMin);
		return currentMin;
	}

	public int getTotalJobCount() {
		return runQueue.size();
	}

}
