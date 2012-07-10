package de.uka.ipd.sdq.scheduler.factory;

import java.util.Hashtable;
import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IConfigurationElement;
import org.eclipse.core.runtime.IExtension;
import org.eclipse.core.runtime.IExtensionPoint;
import org.eclipse.core.runtime.IExtensionRegistry;
import org.eclipse.core.runtime.Platform;

import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.SchedulerModel;
import de.uka.ipd.sdq.scheduler.resources.active.SimDelayResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimFCFSResource;
import de.uka.ipd.sdq.scheduler.resources.active.SimProcessorSharingResource;
import de.uka.ipd.sdq.scheduler.resources.active.special.SimProcessorSharingResourceLinuxO1;
import de.uka.ipd.sdq.scheduler.resources.active.special.SimProcessorSharingResourceWindows;

/**
 * Creates instances of active and passive resources with different scheduling
 * strategies.
 * 
 * @author jens
 * 
 */
public class SchedulingFactory implements ISchedulingFactory {
    
	private Map<String, IActiveResource> active_resource_map = new Hashtable<String, IActiveResource>();
	private Map<String, IPassiveResource> passive_resource_map = new Hashtable<String, IPassiveResource>();
	//private Map<String, IScheduler> scheduler_map = new Hashtable<String, IScheduler>();
	//private Map<String, ActiveProcess> process_map = new Hashtable<String, ActiveProcess>();

	private SchedulerModel model;
	
	public SchedulingFactory(SchedulerModel model) {
	    this.model = model;
	}
	
	
	public IActiveResource createResourceFromExtension(String extensionId, String resourceId, int numberOfCores)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		if (resource == null) {
			SchedulerExtensionFactory factory = getSchedulerExtensionFactory(extensionId);
			assert factory != null;
			resource = factory.getExtensionScheduler(model, extensionId, resourceId, numberOfCores);
			active_resource_map.put(resourceId, resource);
		}
		return resource;
	}
	
	
	public IActiveResource createSimFCFSResource(String resourceName, String resourceId)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimFCFSResource(model, resourceName, resourceId, 1);
		active_resource_map.put(resourceId, resource);
		return resource;
	}
	
	public IActiveResource createSimDelayResource(String resourceName, String resourceId)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimDelayResource(model, resourceName, resourceId);
		active_resource_map.put(resourceId, resource);
		return resource;
	}
	
	/*public IActiveResource createSimGinpexDiskResource(String resourceName, String resourceId, HDDParameterConfig hddParameterConfig)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimGinpexDiskResource(resourceName, resourceId, hddParameterConfig);
		active_resource_map.put(resourceId, resource);
		return resource;
	}*/
	
	public IActiveResource createSimProcessorSharingResource(String resourceName, String resourceId, int numberOfCores)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimProcessorSharingResource(model, resourceName, resourceId, numberOfCores);
		active_resource_map.put(resourceId, resource);
		return resource;
	}
	
	public IActiveResource createSimProcessorSharingResourceWindows(String resourceName, String resourceId, int numberOfCores)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimProcessorSharingResourceWindows(model, resourceName, resourceId, numberOfCores);
		active_resource_map.put(resourceId, resource);
		return resource;
	}
	
	public IActiveResource createSimProcessorSharingResourceLinuxO1(String resourceName, String resourceId, int numberOfCores)
	{
		IActiveResource resource = (IActiveResource) active_resource_map.get(resourceId);
		resource = new SimProcessorSharingResourceLinuxO1(model, resourceName, resourceId, numberOfCores);
		active_resource_map.put(resourceId, resource);
		return resource;
	}

    /*public IPassiveResource createPassiveResource(PassiveResourceConfiguration configuration) {
		IPassiveResource resource = passive_resource_map.get(configuration
				.getId());
		if (resource == null) {
			IPriorityBoost priority_boost = createStaticPriorityBoost(configuration
					.getStaticPriorityBoostConfiguration());
            SimActiveResource managing_resource = (SimActiveResource) createActiveResource(configuration
                    .getManagingResource());

			switch (configuration.getType()) {
			case FAIR:
				resource = new SimFairPassiveResource(model, configuration
						.getCapacity(), configuration.getName(), configuration
						.getId(), priority_boost, managing_resource);
				break;

			case UNFAIR:
				resource = new SimUnfairPassiveResource(model, configuration
						.getCapacity(), configuration.getName(), configuration
						.getId(), priority_boost, managing_resource,
						configuration.getAcquisitionDemand(),true);
				break;

			default:
				break;
			}

			passive_resource_map.put(configuration.getId(), resource);
		}
		return resource;
	}*/

	public void resetFactory() {
		this.active_resource_map.clear();
		//this.manager_map.clear();
		this.passive_resource_map.clear();
		//this.process_map.clear();
		//this.resource_instance_map.clear();
		//this.scheduler_map.clear();
	}
	
	private static final String SchedulerExtensionPointId = "de.uka.ipd.sdq.scheduler";
	private static final String SchedulerExtensionPointAttribute_Class = "class";
	
	private static IExtension[] getRegisteredSchedulerExtensions() {
		IExtensionRegistry registry = Platform.getExtensionRegistry();
		IExtensionPoint extensionPoint = registry.getExtensionPoint(SchedulerExtensionPointId);
		if (extensionPoint == null) {
			// No extension point found!
			return null;
		}
		IExtension[] extensions = extensionPoint.getExtensions();
		return extensions;
	}
	
	private static SchedulerExtensionFactory getSchedulerExtensionFactory(String extensionId) {
		IExtension[] registeredExtensions = getRegisteredSchedulerExtensions();
		assert (registeredExtensions != null) : "No scheduler extensions available!";
		for (int i = 0; i < registeredExtensions.length; i++) {
			IExtension registeredExtension = registeredExtensions[i];
			IConfigurationElement[] elements = registeredExtension.getConfigurationElements();
			if (registeredExtension.getUniqueIdentifier().equals(extensionId)) {
				for (int j = 0; j < elements.length; j++) {
					IConfigurationElement element = elements[j];
					Object o = null;
					try {
						o = element.createExecutableExtension(SchedulerExtensionPointAttribute_Class);
					} catch (CoreException e) {
					}
					if ((o!= null) && (o instanceof SchedulerExtensionFactory)) {
						return (SchedulerExtensionFactory)o;
					}
				}
			}	
		}
		assert false : "No scheduler extension for ID " + extensionId + " available!";
		return null;
	}
	
}
