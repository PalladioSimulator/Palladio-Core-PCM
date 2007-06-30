package de.uka.ipd.sdq.simucomframework.resources;

import desmoj.core.simulator.Entity;
import desmoj.core.simulator.SimProcess;

class JobAndDemandStruct extends Entity {
	private double demand;
	private SimProcess jobParent;
	private AbstractScheduledResource resource;
	private double originalDemand;
	private double creationTime;
	
	public double getDemand() {
		return demand;
	}

	public SimProcess getJobParent() {
		return jobParent;
	}

	public JobAndDemandStruct(SimProcess jobParent, double demand, AbstractScheduledResource abstractScheduledResource, double creationTime){
		super(abstractScheduledResource.getModel(),"JobAndDemand",true);
		this.creationTime = creationTime;
		this.demand = demand;
		this.originalDemand = demand;
		this.jobParent = jobParent;
		this.resource = abstractScheduledResource;
	}

	public void reduceDemand(double timePassed) {
		demand -= timePassed;
	}

	public AbstractScheduledResource getResource() {
		return resource;
	}
	
	public double getOriginalDemand(){
		return this.originalDemand;
	}
	
	public double getPassedTime(double now) {
		return now - creationTime;
	}

	public double getWaitTime(double now) {
		return now - creationTime - originalDemand;
	}
}

