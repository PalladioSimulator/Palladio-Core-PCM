package de.uka.ipd.sdq.dsexplore.opt4j.optimizer.heuristic.operators.impl;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.allocation.AllocationContext;

public class ServiceInfo {
	
	protected static Logger logger = Logger.getLogger(ServiceInfo.class.getName());

	//name of the service
	String serviceName;
	
	//name of the component providing the service
	String compName;
	
	//allocation context of the component providing the service
	AllocationContext compAllocContext;
	
	//User Requirement - response time of the service
	double userReq;
	
	//LQN solution - response time of the service
	double respT;
	
	//frequency of the service
	double frequency;
	
	//initial values
	public ServiceInfo(){
		this.serviceName = "";
		this.compName = "";
		//this.compAllocContext = null;
		this.userReq = 0.0;
		this.respT = 0.0;
		this.frequency = 0.0;
	}
	
	public ServiceInfo(String sName, String cName, double u, double r, double f){
		this.serviceName = sName;
		this.compName = cName;
		//this.compAllocContext = compAllocContext;
		this.userReq = u;
		this.respT = r;
		this.frequency = f;
	}
	
	//print elements of ServiceInfo type
	public void print(){
			logger.info("SEFF " + this.serviceName + ","+
					    " by " + this.compName + ","+
					    //" instance " + this.compAllocContext.getEntityName() + ","+
					    " RT(user requirement) " + this.userReq + ","+
					    " RT(lqn solution) " + this.respT + ","+
					    " frequency " + this.frequency);
		}

}
