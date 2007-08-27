package de.uka.ipd.sdq.scheduler.resources.balancing.constraints;

import java.util.Collection;

import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IResourceInstanceConstraint;


public class MultipleResourceInstancesConstraint implements IResourceInstanceConstraint {

	private Collection<SimResourceInstance> instanceList;

	public MultipleResourceInstancesConstraint(
			Collection<SimResourceInstance> instanceList) {
		this.instanceList = instanceList;
	}
	
	public Collection<SimResourceInstance> getInstances(){
		return instanceList;
	}

	@Override
	public boolean check(SimResourceInstance instance) {
		return instanceList.contains(instance);
	}
}
