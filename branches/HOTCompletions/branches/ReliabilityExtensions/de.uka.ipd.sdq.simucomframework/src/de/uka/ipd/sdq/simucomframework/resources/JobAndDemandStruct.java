package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.Entity;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimProcessDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimProcess;

/**
 * Data structure used in scheduler events to store a job, its inital demand,
 * its remaining demand and the resource it is executed on
 * @author Steffen Becker
 *
 */
class JobAndDemandStruct extends Entity {
	private double demand;
	private SimProcess jobParent;
	private AbstractScheduledResource resource;
	private double originalDemand;
	private double creationTime;
	
	public JobAndDemandStruct(SimProcess jobParent, double demand, AbstractScheduledResource abstractScheduledResource, double creationTime){
		super(abstractScheduledResource.getModel(),"JobAndDemand");
		this.creationTime = creationTime;
		this.demand = demand;
		this.originalDemand = demand;
		this.jobParent = jobParent;
		this.resource = abstractScheduledResource;
	}

	/**
	 * Called by the framework to inform this resource that the given amount
	 * of its total demand has been processed. 
	 * @param timePassed The demand already processed for this entity
	 */
	public void reduceDemand(double timePassed) {
		demand -= timePassed;
	}

	/**
	 * @return The resource which processes this structs demand
	 */
	public AbstractScheduledResource getResource() {
		return resource;
	}
	
	/**
	 * @return The total demand issued initially
	 */
	public double getOriginalDemand(){
		return this.originalDemand;
	}
	
	/**
	 * Returns the time passed between the creation of this object and
	 * the time given
	 * @param now The time to which to difference should be determined
	 * @return Difference between the creation time of this object and
	 * the time given
	 */
	public double getPassedTime(double now) {
		return now - creationTime;
	}

	/**
	 * Calculate the total waiting time in the scheduler until now. Called when
	 * the job is done
	 * @param now The current wall time
	 * @return The waiting time spent in the schedulers wait queue
	 */
	public double getWaitTime(double now) {
		return now - creationTime - originalDemand;
	}

	/**
	 * @return The remaining demand of this job
	 */
	public double getDemand() {
		return demand;
	}

	/**
	 * @return The thread waiting for its demand to be processed
	 */
	public ISimProcessDelegate getJobParent() {
		return jobParent;
	}	
}

