package de.uka.ipd.sdq.simucomframework.resources;

import desmoj.core.simulator.Entity;
import desmoj.core.simulator.Event;
import desmoj.core.simulator.Model;
import desmoj.core.simulator.SimTime;

public class JobDoneEvent extends Event {

	public JobDoneEvent(Model owner, String name, boolean showInTrace) {
		super(owner, name, showInTrace);
	}

	@Override
	public void eventRoutine(Entity who) {
		AbstractScheduledResource resource = (AbstractScheduledResource) who;
		resource.processPassedTime();
		JobAndDemandStruct job = resource.removeFinishedJob();
		job.getJobParent().activate(SimTime.NOW);
	 	if (resource.hasMoreJobs()) {
			Event ev = new JobDoneEvent(getModel(), "JobDone", true);
			ev.schedule(resource, new SimTime(resource.getTimeWhenNextJobIsDone()));
			resource.setIdle(false);
		} else {
			resource.setIdle(true);
		}
	}

}
