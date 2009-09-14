/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
 
/**
 * Event triggered when a new job arrives at a simulated resource and
 * demands processing its resource demand
 * @author Snowball
 *
 */
public class JobArrivalEvent extends SimEvent {

	private JobAndDemandStruct demand;

	public JobArrivalEvent(SimuComModel owner, JobAndDemandStruct jobAndDemandStruct, String name) {
		super(owner, name);
		this.demand = jobAndDemandStruct;
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.Event#eventRoutine(desmoj.core.simulator.Entity)
	 */
	@Override
	public void eventRoutine(IEntityDelegate who) {
		JobAndDemandStruct job = (JobAndDemandStruct)who;
		AbstractScheduledResource resource = job.getResource();
		resource.processPassedTime();
		resource.addJob(demand);
		double nextEventTime = resource.getTimeWhenNextJobIsDone();
		if(nextEventTime < 0){
			throw new RuntimeException("Next scheduled event time < 0");
		}
		ISimEventDelegate ev = resource.getJobDoneEvent();
		ev.removeEvent();
		ev.schedule(resource,nextEventTime);
		resource.setIdle(false);
	}
}
