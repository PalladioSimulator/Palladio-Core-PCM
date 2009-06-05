package de.uka.ipd.sdq.capra.simulator.builder;

import java.util.Collection;
import java.util.Hashtable;
import java.util.Map;

import org.eclipse.emf.common.util.EList;

import scheduler.configuration.ActiveResourceConfiguration;
import scheduler.configuration.PassiveResourceConfiguration;
import de.uka.ipd.sdq.capra.extension.PassiveResource;
import de.uka.ipd.sdq.capra.resources.ActiveResource;
import de.uka.ipd.sdq.capra.resources.ProcessingResource;
import de.uka.ipd.sdq.capra.resources.Resource;
import de.uka.ipd.sdq.scheduler.IActiveResource;
import de.uka.ipd.sdq.scheduler.IPassiveResource;
import de.uka.ipd.sdq.scheduler.ISchedulingFactory;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;
import de.uka.ipd.sdq.scheduler.strategy.impl.PreemptiveScheduler;

/**
 * Manages a set of resource. It follows the builder pattern.
 * 
 * @author jens
 * 
 */
public class ResourceManager {
	
	private ISchedulingFactory schedulingFactory = null;
	private Map<String, PassiveResourceConfiguration> passive_resource_config_map = new Hashtable<String, PassiveResourceConfiguration>();
	private Map<String, ActiveResourceConfiguration> active_resource_config_map = new Hashtable<String, ActiveResourceConfiguration>();
	private Map<String, IPassiveResource> passive_resource_map = new Hashtable<String, IPassiveResource>();
	private Map<String, IActiveResource> active_resource_map = new Hashtable<String, IActiveResource>();

	
	public ResourceManager(ISchedulingFactory schedulingFactory){
		this.schedulingFactory = schedulingFactory;
	}
	
	public void start(){
		for (IActiveResource resource : active_resource_map.values()) {
			resource.start();
		}
	}
	
	public void stop() {
		for (IActiveResource resource : active_resource_map.values()) {
			resource.stop();
		}
	}
	
	
	public void loadActiveResourceConfigurations(
			EList<ActiveResourceConfiguration> activeResourceConfigurationList) {
		for (ActiveResourceConfiguration activeResourceConfiguration : activeResourceConfigurationList) {
			addActiveResourceConfiguration(activeResourceConfiguration);
		}
	}

	public void loadPassiveResourceConfigurations(
			EList<PassiveResourceConfiguration> passiveResourceConfigurationList) {
		for (PassiveResourceConfiguration passiveResourceConfiguration : passiveResourceConfigurationList) {
			addPassiveResourceConfiguration(passiveResourceConfiguration);
		}
	}

	public void loadResources(EList<Resource> resources) {
		loadActiveResources(resources);
		loadPassiveResources(resources);
	}

	private void loadPassiveResources(EList<Resource> resources) {
		for (Resource resource : resources) {
			if (resource instanceof PassiveResource) {
				PassiveResource passiveResource = (PassiveResource) resource;
				PassiveResourceConfiguration config = getConfigFor(passiveResource);
				IPassiveResource simResource = createPassiveResource(config);
				addPassiveResource(simResource);
			}
		}
	}

	private void loadActiveResources(EList<Resource> resources) {
		for (Resource resource : resources) {
			if (resource instanceof ActiveResource) {
				ActiveResource activeResource = (ActiveResource) resource;
				ActiveResourceConfiguration config = getConfigFor(activeResource);
				IActiveResource simResource = createActiveResource(config);
				addActiveResource(simResource);
			}
		}
	}

	private IPassiveResource createPassiveResource(PassiveResourceConfiguration config) {
		return schedulingFactory.createPassiveResource(config);
	}

	private IActiveResource createActiveResource(ActiveResourceConfiguration config) {
		return schedulingFactory.createActiveResource(config);
	}

	private void addActiveResourceConfiguration(
			ActiveResourceConfiguration activeResourceConfiguration) {
		active_resource_config_map.put(activeResourceConfiguration.getName(), activeResourceConfiguration);
	}

	private void addPassiveResourceConfiguration(
			PassiveResourceConfiguration passiveResourceConfiguration) {
		passive_resource_config_map.put(passiveResourceConfiguration.getName(), passiveResourceConfiguration);
	}

	private PassiveResourceConfiguration getConfigFor(
			PassiveResource passiveResource) {
		return passive_resource_config_map.get( passiveResource.getName() );
	}

	private ActiveResourceConfiguration getConfigFor(
			ActiveResource activeResource) {
		return active_resource_config_map.get( activeResource.getName() );
	}

	private void addPassiveResource(IPassiveResource passiveResource) {
		passive_resource_map.put(passiveResource.getName(), passiveResource);
	}

	private void addActiveResource(IActiveResource activeResource) {
		active_resource_map.put(activeResource.getName(), activeResource);
	}

	public Collection<IActiveResource> getActiveResources() {
		return active_resource_map.values();
	}

	public IActiveResource getActiveResource(ProcessingResource resource) {
		return active_resource_map.get(resource.getName());
	}

	public IPassiveResource getPassiveResource(PassiveResource resource) {
		return passive_resource_map.get(resource.getName());
	}

	public Collection<ActiveResourceConfiguration> getActiveResourceConfigurations() {
		return this.active_resource_config_map.values();
	}

	public IActiveResource getResourceFor(
			ActiveResourceConfiguration resource_config) {
		return this.active_resource_map.get(resource_config.getName());
	}

	public SimActiveResource getMainResource() {
		for(IActiveResource ar : this.active_resource_map.values()){
			if (ar instanceof SimActiveResource) {
				SimActiveResource sar = (SimActiveResource) ar;
				if (sar.getScheduler() instanceof PreemptiveScheduler) {
					return sar;
				}
			}
		}
		return null;
	}

}
