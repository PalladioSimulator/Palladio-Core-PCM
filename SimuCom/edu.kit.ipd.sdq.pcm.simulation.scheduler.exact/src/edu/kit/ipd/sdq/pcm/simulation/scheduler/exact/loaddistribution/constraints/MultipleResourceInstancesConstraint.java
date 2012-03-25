package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.constraints;

import java.util.Collection;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IResourceInstanceConstraint;

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
