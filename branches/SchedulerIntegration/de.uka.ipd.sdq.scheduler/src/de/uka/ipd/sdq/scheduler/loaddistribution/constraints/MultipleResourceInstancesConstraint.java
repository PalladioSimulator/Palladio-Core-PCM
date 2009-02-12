package de.uka.ipd.sdq.scheduler.loaddistribution.constraints;

import java.util.Collection;

import de.uka.ipd.sdq.scheduler.loaddistribution.IResourceInstanceConstraint;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class MultipleResourceInstancesConstraint implements
		IResourceInstanceConstraint {

	private Collection<IResourceInstance> instance_list;

	public MultipleResourceInstancesConstraint(
			Collection<IResourceInstance> instance_list) {
		this.instance_list = instance_list;
	}

	public Collection<IResourceInstance> getInstances() {
		return instance_list;
	}

	public boolean check(IResourceInstance instance) {
		return instance_list.contains(instance);
	}
}
