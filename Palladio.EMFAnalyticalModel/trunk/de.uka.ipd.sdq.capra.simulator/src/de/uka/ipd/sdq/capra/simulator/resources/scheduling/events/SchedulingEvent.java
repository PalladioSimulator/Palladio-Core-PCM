package de.uka.ipd.sdq.capra.simulator.resources.scheduling.events;

import de.uka.ipd.sdq.capra.simulator.resources.SimActiveResource;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IScheduledJob;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveJob;
import umontreal.iro.lecuyer.simevents.Event;

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

	public IScheduledJob getJob() {
		return job;
	}

	public void setJob(IScheduledJob job) {
		this.job = job;
	}
}
