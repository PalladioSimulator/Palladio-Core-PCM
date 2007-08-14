package de.uka.ipd.sdq.capra.simulator.resources.scheduling.events;

import de.uka.ipd.sdq.capra.simulator.resources.SimActiveResource;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IScheduledJob;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveJob;
import umontreal.iro.lecuyer.simevents.Event;

/**
 * @author     jens.happe
 */
public class SchedulingEvent extends Event {
	
	private IScheduledJob job;
	private SimActiveResource resource;

	public SchedulingEvent(PreemptiveJob job, SimActiveResource resource) {
		super();
		this.job = job;
		this.resource = resource;
	}

	public SchedulingEvent(SimActiveResource resource) {
		super();
		this.job = null;
		this.resource = resource;
	}

	@Override
	public void actions() {
		resource.schedulingCallback(job);
	}

	/**
	 * @return
	 * @uml.property  name="job"
	 */
	public IScheduledJob getJob() {
		return job;
	}

	/**
	 * @param job
	 * @uml.property  name="job"
	 */
	public void setJob(IScheduledJob job) {
		this.job = job;
	}
}
