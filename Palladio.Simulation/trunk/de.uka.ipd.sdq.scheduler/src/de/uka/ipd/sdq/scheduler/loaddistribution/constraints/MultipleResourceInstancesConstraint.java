package de.uka.ipd.sdq.scheduler.loaddistribution.constraints;

import java.util.Collection;

import de.uka.ipd.sdq.scheduler.loaddistribution.IResourceInstanceConstraint;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

public class MultipleResourceInstancesConstraint implements
		IResourceInstanceConstraint {

	private Collection<IResourceInstance> instanceList;

	public MultipleResourceInstancesConstraint(
			Collection<IResourceInstance> instanceList) {
		this.instanceList = instanceList;
	}

	public Collection<IResourceInstance> getInstances() {
		return instanceList;
	}

	@Override
	public boolean check(IResourceInstance instance) {
		return instanceList.contains(instance);
	}
}
