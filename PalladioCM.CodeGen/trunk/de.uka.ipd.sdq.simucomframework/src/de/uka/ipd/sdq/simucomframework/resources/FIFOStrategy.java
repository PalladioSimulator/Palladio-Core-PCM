package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedActiveResource.JobAndDemandStruct;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.Queue;
import desmoj.core.simulator.SimTime;

public class FIFOStrategy implements ISchedulingStrategy {
	protected Queue runQueue = null;

	public FIFOStrategy(SimuComModel myModel, String typeID){
		runQueue = new Queue(myModel, "RunQueue "+typeID, true, true);
	}

	@Override
	public void processPassedTime(double timePassed) {
		if (runQueue.length() > 0){
			JobAndDemandStruct jobAndDemand = (JobAndDemandStruct) runQueue.first();
			jobAndDemand.reduceDemand(timePassed);
		}
	}

	@Override
	public void addJob(JobAndDemandStruct demand) {
		runQueue.insert(demand);
	}

	@Override
	public double getTimeWhenNextJobIsDone() {
		return ((JobAndDemandStruct)runQueue.first()).getDemand();
	}

	@Override
	public JobAndDemandStruct removeFinshedJob() {
		JobAndDemandStruct job = (JobAndDemandStruct) runQueue.first();
		if (Math.abs(job.getDemand()) > Math.pow(10, -3))
			throw new RuntimeException("Job finished, but demand > 0");
		runQueue.remove(job);
		return job;
	}

	@Override
	public boolean hasMoreJobs() {
		return runQueue.length() > 0;
	}

	@Override
	public int getTotalJobCount() {
		return runQueue.length();
	}

}
