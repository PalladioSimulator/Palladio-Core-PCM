package de.uka.ipd.sdq.scheduler.loaddistribution.selectors.instance;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.scheduler.processes.IActiveProcess;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.active.SimActiveResource;


public class IdleSelector extends AbstractInstanceSelector {

	RoundRobinSelector ideal_instance_selector;
	
	public IdleSelector(SimActiveResource resource) {
		super(resource);
		ideal_instance_selector = new RoundRobinSelector(resource);
	}

	public IResourceInstance selectInstanceFor(IActiveProcess process, IResourceInstance current) {
		return current;
//		List<IResourceInstance> idleInstances = getIdleInstances();
//		process.removeNonAffineInstances(idleInstances);
//		
//		if (!process.hasIdealInstance())
//			selectIdealInstance(process);
//		
//		if(!idleInstances.isEmpty()){
//			if(idleInstances.contains(process.getIdealInstance())){
//				return process.getIdealInstance();
//			}
//			if(process.hasLastInstance() && idleInstances.contains(process.getLastInstance())){
//				return process.getLastInstance();
//			}
//			return idleInstances.get(0);
//		}
//		return process.getIdealInstance();
	}

//	private void selectIdealInstance(IActiveProcess process) {
//		ideal_instance_selector.selectInstanceFor(process);
//	}
	
	public List<IResourceInstance> getIdleInstances() {
		List<IResourceInstance> idleInstances = new ArrayList<IResourceInstance>();
		for (IResourceInstance instance : resource.getInstanceList()) {
			if (resource.isIdle(instance))
				idleInstances.add(instance);
		}
		return idleInstances;
	}

}
