package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.factory;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.factory.SchedulerExtensionFactory;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.ExactSchedulingFactory;


public class Windows7SchedulerFactory implements SchedulerExtensionFactory {

	public IActiveResource getExtensionScheduler(SchedulerModel model, String resourceName, String resourceId, int numberOfCores) {
		ExactSchedulingFactory factory = new ExactSchedulingFactory(model);
		return factory.getResource(model, "Windows 2003", numberOfCores, "Utilisation of " + resourceName + " " + resourceId);
	}
}
