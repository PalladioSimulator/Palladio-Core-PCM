package de.uka.ipd.sdq.capra.simulator.builder;

import java.util.Hashtable;

import de.uka.ipd.sdq.capra.simulator.resources.AbstractSimResource;
import de.uka.ipd.sdq.capra.simulator.resources.SimActiveResource;
import de.uka.ipd.sdq.capra.simulator.resources.SimPassiveResource;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.DelayStrategy;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.FCFSStrategy;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.ISchedulingStrategy;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.ProcessorSharingStrategy;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.RoundRobinStrategy;

/**
 * Manages a set of resource. It follows the builder pattern.
 * @author jens
 *
 */
public class ResourceManager {
	
	private Hashtable<String,AbstractSimResource> simResources = new Hashtable<String, AbstractSimResource>();
	
	public void addResource(AbstractSimResource resource){
		simResources.put(resource.getName(), resource);
	}
	
	public AbstractSimResource getResource(String name){
		return simResources.get(name);
	}
	
	public SimActiveResource getActiveResource(String name){
		return (SimActiveResource) getResource(name);
	}
	
	public SimPassiveResource getPassiveResource(String name){
		return (SimPassiveResource) getResource(name);
		
	}	
	
	public void addPassiveResource(String name, int capacity){
		SimPassiveResource resource = new SimPassiveResource(name, capacity);
		addResource(resource);
	}
	
	public void addActiveResource(String name, ISchedulingStrategy strategy) {
		SimActiveResource resource = new SimActiveResource(strategy,name);
		addResource(resource);
	}

	public void addDelayResource(String name){
		addActiveResource(name,new DelayStrategy());
	}
	
	public void addFCFSProcessingResource(String name){
		addActiveResource(name,new FCFSStrategy());
	}
	
	public void addProcessorSharingResource(String name){
		addActiveResource(name,new ProcessorSharingStrategy());
	}	

	public void addRoundRobinResource(String name, double timeSlice) {
		addActiveResource(name, new RoundRobinStrategy(timeSlice));
	}
	
	public void init(){
		for (AbstractSimResource r : simResources.values()) {
			r.init();
		}
	}
}
