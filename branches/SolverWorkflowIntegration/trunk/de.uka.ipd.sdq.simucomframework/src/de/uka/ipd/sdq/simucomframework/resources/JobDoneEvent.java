package de.uka.ipd.sdq.simucomframework.resources;

import de.uka.ipd.sdq.simucomframework.abstractSimEngine.IEntityDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.ISimEventDelegate;
import de.uka.ipd.sdq.simucomframework.abstractSimEngine.SimEvent;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;

/**
 * Event triggered by the simulation when a job is finished in one of the resources
 * scheduling algorithms
 * @author Snowball
 *
 */
public class JobDoneEvent extends SimEvent {

	public JobDoneEvent(SimuComModel owner, String name) {
		super(owner, name);
	}

	@Override
	public void eventRoutine(IEntityDelegate who) {
		AbstractScheduledResource resource = (AbstractScheduledResource) who;
		resource.processPassedTime();
		JobAndDemandStruct job = resource.removeFinishedJob();
		job.getJobParent().scheduleAt(0);
	 	if (resource.hasMoreJobs()) {
			ISimEventDelegate ev = resource.getJobDoneEvent();
			ev.schedule(resource, resource.getTimeWhenNextJobIsDone());
			resource.setIdle(false);
		} else {
			resource.setIdle(true);
		}
	}

}
