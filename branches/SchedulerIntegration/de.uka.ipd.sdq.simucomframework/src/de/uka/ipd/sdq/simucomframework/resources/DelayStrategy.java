package de.uka.ipd.sdq.simucomframework.resources;

import java.util.ArrayList;
import java.util.List;

/**
 * Scheduler strategy for resources which exist in unlimited amounts. It
 * simply delays execution without causing wait times
 * @author Steffen Becker
 *
 */
public class DelayStrategy implements ISchedulingStrategy {

	private ArrayList<JobAndDemandStruct> jobs = new ArrayList<JobAndDemandStruct>();
	
	public void addJob(JobAndDemandStruct demand) {
		jobs.add(demand);
	}

	public double getTimeWhenNextJobIsDone() {
		double minTime = Double.MAX_VALUE;
		for (JobAndDemandStruct jds : jobs)
			if (jds.getDemand() < minTime)
				minTime = jds.getDemand();
		return minTime;
	}

	public int getTotalJobCount() {
		return jobs.size();
	}

	public boolean hasMoreJobs() {
		return jobs.size() > 0;
	}

	public void processPassedTime(double timePassed) {
		for (JobAndDemandStruct jds : jobs)
			jds.reduceDemand(timePassed);
	}

	public JobAndDemandStruct removeFinishedJob() {
		JobAndDemandStruct currentMin = jobs.get(0);
		
		for(JobAndDemandStruct job : jobs){
			if (job.getDemand() < currentMin.getDemand())
				currentMin = job;
		}
		if (Math.abs(currentMin.getDemand()) > Math.pow(10, -3))
			throw new RuntimeException("Job finished, but demand > 0");
		jobs.remove(currentMin);
		return currentMin;
	}

	public List<JobAndDemandStruct> removeRemainingJobs() {
		List<JobAndDemandStruct> remainingJobs = new ArrayList<JobAndDemandStruct>(this.jobs);
		this.jobs.clear();
		return remainingJobs;
	}

}
