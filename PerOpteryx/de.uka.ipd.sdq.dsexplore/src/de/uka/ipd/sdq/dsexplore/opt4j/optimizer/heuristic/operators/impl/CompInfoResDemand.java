package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;
import org.apache.log4j.Logger;
import de.uka.ipd.sdq.pcm.allocation.AllocationContext;
import de.uka.ipd.sdq.pcm.repository.BasicComponent;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceContainer;

public class CompInfoResDemand {
	
	protected static Logger logger = Logger.getLogger(CompInfoResDemand.class.getName());
	
	//basic component
	BasicComponent bc;

	//allocation context of the component
	AllocationContext ac;
	
	//resource container on which the component is deployed
	ResourceContainer rc;
	
	//amount of CPU demand
	double computation;
	
	//amount of HDD demand
	double storage;
	
	//initial values
	public CompInfoResDemand(){
		this.bc = null;
		this.ac = null;
		this.rc = null;
		this.computation = 0.0;
		this.storage = 0.0;
	}
	
	public CompInfoResDemand(BasicComponent bc, AllocationContext ac, ResourceContainer rc, double c, double s){
		this.bc = bc;
		this.ac = ac;
		this.rc = rc;
		this.computation = c;
		this.storage = s;
	}
	
	public CompInfoResDemand(CompInfoResDemand c){
		this.bc = c.bc;
		this.ac = c.ac;
		this.rc = c.rc;
		this.computation = c.computation;
		this.storage = c.storage;
	}
	
	//print elements of CompInfoResDemand type
	public void print(){
			logger.info("BC " + this.bc.getEntityName() + "," +
					    " RC " + this.rc.getEntityName() + "," +
					    " CpuDemand " + this.computation + "," +
					    " HddDemand " + this.storage);
	}

}
