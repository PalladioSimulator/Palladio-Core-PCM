/**
 * 
 */
package de.uka.ipd.sdq.simucomframework.resources;
 
import de.uka.ipd.sdq.simucomframework.exceptions.SchedulerReturnedNegativeTimeException;
import de.uka.ipd.sdq.simucomframework.resources.SimulatedActiveResource.JobAndDemandStruct;
import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

/**
 * @author Snowball
 *
 */
public class JobArrivalEvent extends Event {

	private JobAndDemandStruct demand;
	
	public final static double EPSILON = Math.pow(10,-9);

	public JobArrivalEvent(Model owner, JobAndDemandStruct jobAndDemandStruct, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
		this.demand = jobAndDemandStruct;
	}

	/* (non-Javadoc)
	 * @see desmoj.core.simulator.Event#eventRoutine(desmoj.core.simulator.Entity)
	 */
	@Override
	public void eventRoutine(Entity who) {
		JobAndDemandStruct job = (JobAndDemandStruct)who;
		SimulatedActiveResource resource = job.getResource();
		resource.processPassedTime();
		resource.addJob(demand);
		double nextEventTime = resource.getTimeWhenNextJobIsDone();
		if (nextEventTime < 0) {
			if (Math.abs(nextEventTime)<EPSILON){
				nextEventTime = 0.0;
			} else 
				new SchedulerReturnedNegativeTimeException();
		}
		SimTime nextEvent = new SimTime(nextEventTime);
		if(resource.isScheduled())
			resource.reSchedule(nextEvent);
		else {
			Event ev = new JobDoneEvent(getModel(), "JobDone", true);
			ev.schedule(resource, nextEvent);
		}
		resource.setIdle(false);
	}
}
