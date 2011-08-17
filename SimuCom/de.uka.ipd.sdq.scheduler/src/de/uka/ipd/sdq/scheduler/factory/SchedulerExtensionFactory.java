package de.uka.ipd.sdq.scheduler.factory;

import de.uka.ipd.sdq.scheduler.IActiveResource;

public interface SchedulerExtensionFactory {
	
	public IActiveResource getExtensionScheduler(String resourceName, String resourceId);

}
