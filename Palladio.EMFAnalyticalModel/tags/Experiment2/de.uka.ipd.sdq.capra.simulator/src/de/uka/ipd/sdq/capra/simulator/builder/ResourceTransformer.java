package de.uka.ipd.sdq.capra.simulator.builder;

import de.uka.ipd.sdq.capra.extension.PassiveResource;
import de.uka.ipd.sdq.capra.resources.DelayResource;
import de.uka.ipd.sdq.capra.resources.ProcessingResource;
import de.uka.ipd.sdq.capra.resources.Resource;
import de.uka.ipd.sdq.capra.schedulers.Assignment;
import de.uka.ipd.sdq.capra.schedulers.SchedulersPackage;
import de.uka.ipd.sdq.capra.schedulers.SelectionPolicy;

public class ResourceTransformer {
	ResourceManager resourceManager;
	ResourceVisitor visitor;
	
	public ResourceTransformer(ResourceManager resourceManager) {
		super();
		this.resourceManager = resourceManager;
		visitor = new ResourceVisitor(this);
	}

	public void transformPassiveResource(PassiveResource passiveResource){
		String name = passiveResource.getName();
		int capacity = passiveResource.getCapacity();
		resourceManager.addPassiveResource(name, capacity);
	}
	
	public void transformProcessingResource(ProcessingResource processingResource){
		String name = processingResource.getName();
		int capacity = processingResource.getCapacity();
		if (capacity > 1){
			System.out.println("Capacity "+ capacity + " for resource " + name + " is being ignored.");
		}
		resourceManager.addRoundRobinResource(name,15.0);
//		SelectionPolicy policy = processingResource.getScheduler().getSelectionpolicy();
//		Assignment assignment = processingResource.getScheduler().getAssignment();
//		if ((assignment.eClass().getClassifierID() == SchedulersPackage.PREEMPTIVE)){
//			resourceManager.addProcessorSharingResource(name);
//		} else 	if ((policy.eClass().getClassifierID() == SchedulersPackage.WAITING_TIME)
//				&& (assignment.eClass().getClassifierID() == SchedulersPackage.NON_PREEMPTIVE)){
//			resourceManager.addFCFSProcessingResource(name);
//		}
	}
	
	public void transformDelayResource(DelayResource delayResource){
		String name = delayResource.getName();
		resourceManager.addDelayResource(name);
	}
	
	public void transformResource(Resource resource){
		visitor.visit(resource);
	}
}
