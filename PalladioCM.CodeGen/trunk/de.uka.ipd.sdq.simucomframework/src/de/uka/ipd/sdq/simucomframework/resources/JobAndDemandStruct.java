package de.uka.ipd.sdq.simucomframework.resources;

import desmoj.core.simulator.Entity;
import desmoj.core.simulator.SimProcess;

class JobAndDemandStruct extends Entity {
	private double demand;
	private SimProcess jobParent;
	private AbstractScheduledResource resource;
	
	public double getDemand() {
		return demand;
	}

	public SimProcess getJobParent() {
		return jobParent;
	}

	public JobAndDemandStruct(SimProcess jobParent, double demand, AbstractScheduledResource abstractScheduledResource){
		super(abstractScheduledResource.getModel(),"JobAndDemand",true);
		this.demand = demand;
		this.jobParent = jobParent;
		this.resource = abstractScheduledResource;
	}

	public void reduceDemand(double timePassed) {
		demand -= timePassed;
	}

	public AbstractScheduledResource getResource() {
		return resource;
	}
}

