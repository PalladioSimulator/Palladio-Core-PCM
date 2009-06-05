package de.uka.ipd.sdq.simucomframework.resources;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * First-come, first-serve scheduling strategy. The first job is executed fully
 * before the next job gets the resource, and so on...
 * @author Steffen Becker
 *
 */
public class FCFSStrategy implements ISchedulingStrategy {
	protected Queue<JobAndDemandStruct> runQueue = null;

	public FCFSStrategy(SimuComModel myModel){
		runQueue = new ConcurrentLinkedQueue<JobAndDemandStruct>();
	}

	public void processPassedTime(double timePassed) {
		if (runQueue.size() > 0){
			JobAndDemandStruct jobAndDemand = runQueue.peek();
			jobAndDemand.reduceDemand(timePassed);
		}
	}

	public void addJob(JobAndDemandStruct demand) {
		runQueue.offer(demand);
	}

	public double getTimeWhenNextJobIsDone() {
		return runQueue.peek().getDemand();
	}

	public JobAndDemandStruct removeFinishedJob() {
		JobAndDemandStruct job = runQueue.peek();
		if (Math.abs(job.getDemand()) > Math.pow(10, -3))
			throw new RuntimeException("Job finished, but demand > 0");
		runQueue.remove(job);
		return job;
	}

	public boolean hasMoreJobs() {
		return runQueue.size() > 0;
	}

	public int getTotalJobCount() {
		return runQueue.size();
	}

	public List<JobAndDemandStruct> removeRemainingJobs() {
		List<JobAndDemandStruct> remainingJobs = new ArrayList<JobAndDemandStruct>(this.runQueue);
		this.runQueue.clear();
		return remainingJobs;
	}
	
}
