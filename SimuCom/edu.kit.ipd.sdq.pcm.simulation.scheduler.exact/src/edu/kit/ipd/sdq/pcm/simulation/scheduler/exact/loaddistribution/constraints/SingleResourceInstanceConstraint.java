package edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.constraints;

import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.IResourceInstance;
import edu.kit.ipd.sdq.pcm.simulation.scheduler.exact.loaddistribution.IResourceInstanceConstraint;

public class SingleResourceInstanceConstraint implements
		IResourceInstanceConstraint {

	private IResourceInstance instance;

	public SingleResourceInstanceConstraint(IResourceInstance instance) {
		super();
		this.instance = instance;
	}

	public boolean check(IResourceInstance instance) {
		return this.instance.equals(instance);
	}

	public IResourceInstance getResourceInstance() {
		return instance;
	}
}
