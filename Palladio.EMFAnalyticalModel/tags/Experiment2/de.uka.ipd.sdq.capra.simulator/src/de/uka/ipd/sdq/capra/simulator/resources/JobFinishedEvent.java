package de.uka.ipd.sdq.capra.simulator.resources;

import umontreal.iro.lecuyer.simevents.Event;

public class JobFinishedEvent extends Event {
	
	private Job job;
	private SimActiveResource resource;

	public JobFinishedEvent(Job job, SimActiveResource resource) {
		super();
		this.job = job;
		this.resource = resource;
	}

	public JobFinishedEvent(SimActiveResource resource) {
		super();
		this.job = null;
		this.resource = resource;
	}

	@Override
	public void actions() {
		resource.jobFinishedCallback(job);
	}

	public Job getJob() {
		return job;
	}

	public void setJob(Job job) {
		this.job = job;
	}

}
