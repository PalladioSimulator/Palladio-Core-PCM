package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.factory;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulerExtensionFactory;
import de.uka.ipd.sdq.scheduler.resources.active.SimProcessorSharingResource;


public class Linux26CFSSchedulerFactory implements SchedulerExtensionFactory {
	
	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId, int numberOfCores) {
		return new SimProcessorSharingResource(model, resourceName, resourceId, numberOfCores);
		//return new Linux26CFSResource(model, resourceName, resourceId);
	}

}
