package de.uka.ipd.sdq.scheduler.factory;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;

public interface SchedulerExtensionFactory {
	
	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId);

}
