package de.uka.ipd.sdq.capra.simulator.builder;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.List;

import de.uka.ipd.sdq.capra.simulator.expressions.SimCapraProcess;
import de.uka.ipd.sdq.capra.simulator.expressions.SimReplicatedProcess;
import de.uka.ipd.sdq.capra.simulator.resources.AbstractSimResource;
import de.uka.ipd.sdq.capra.simulator.resources.SimActiveResource;
import de.uka.ipd.sdq.capra.simulator.resources.SimPassiveResource;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.IPreemptiveSchedulingStrategy;
import de.uka.ipd.sdq.capra.simulator.resources.scheduling.impl.PreemptiveStrategy;

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
	
	public void addActiveResource(String name, IPreemptiveSchedulingStrategy strategy) {
		SimActiveResource resource = new SimActiveResource(strategy,name);
		addResource(resource);
	}

	public void addDelayResource(String name){
		//TODO: addActiveResource(name,new DelayStrategy());
	}
	
	public void addFCFSProcessingResource(String name){
		//TODO: addActiveResource(name,new FCFSStrategy());
	}
	
	public void addProcessorSharingResource(String name){
		//TODO: addActiveResource(name,new ProcessorSharingStrategy());
	}	

	public void addRoundRobinResource(String name, double timeSlice) {
		PreemptiveStrategy strategy = new PreemptiveStrategy(timeSlice);
		SimActiveResource resource = new SimActiveResource(strategy,name);
		strategy.setActiveResource(resource);
		addResource(resource);
	}
	
	public void init(){
		List<SimActiveResource> activeResourceList = new ArrayList<SimActiveResource>();
		List<SimPassiveResource> passiveResourceList = new ArrayList<SimPassiveResource>();
		for (AbstractSimResource r : simResources.values()) {
			if (r instanceof SimActiveResource) {
				SimActiveResource activeResource = (SimActiveResource) r;
				activeResourceList.add(activeResource);
			} else if (r instanceof SimPassiveResource) {
				SimPassiveResource passiveResource = (SimPassiveResource) r;
				passiveResourceList.add(passiveResource);
			}
		}
		for (SimPassiveResource simPassiveResource : passiveResourceList) {
			for (SimActiveResource simActiveResource : activeResourceList) {
				simPassiveResource.addFavouredResource(simActiveResource);
			}
		}
	}

	public void register(CapraProcessManager processes) {
		for (AbstractSimResource r : simResources.values()) {
			if (r instanceof SimActiveResource) {
				SimActiveResource activeResource = (SimActiveResource) r;
				registerProcesses(activeResource,processes);
			}
		}
	}

	private void registerProcesses(SimActiveResource activeResource,
			CapraProcessManager processes) {
		for (SimReplicatedProcess repProcess : processes.getProcesses()) {
			for (SimCapraProcess process : repProcess.getProcesses()) {
				activeResource.getRegistry().registerProcess(process);
			} 
		}
	}
}
