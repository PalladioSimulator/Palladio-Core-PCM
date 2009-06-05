package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import desmoj.core.simulator.Queue;

public class FCFSStrategy implements ISchedulingStrategy {
	protected Queue runQueue = null;

	public FCFSStrategy(SimuComModel myModel){
		runQueue = new Queue(myModel, "RunQueue", true, true);
	}

	public void processPassedTime(double timePassed) {
		if (runQueue.length() > 0){
			JobAndDemandStruct jobAndDemand = (JobAndDemandStruct) runQueue.first();
			jobAndDemand.reduceDemand(timePassed);
		}
	}

	public void addJob(JobAndDemandStruct demand) {
		runQueue.insert(demand);
	}

	public double getTimeWhenNextJobIsDone() {
		return ((JobAndDemandStruct)runQueue.first()).getDemand();
	}

	public JobAndDemandStruct removeFinshedJob() {
		JobAndDemandStruct job = (JobAndDemandStruct) runQueue.first();
		if (Math.abs(job.getDemand()) > Math.pow(10, -3))
			throw new RuntimeException("Job finished, but demand > 0");
		runQueue.remove(job);
		return job;
	}

	public boolean hasMoreJobs() {
		return runQueue.length() > 0;
	}

	public int getTotalJobCount() {
		return runQueue.length();
	}

}
