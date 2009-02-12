package de.uka.ipd.sdq.scheduler.loaddistribution.constraints;

import de.uka.ipd.sdq.scheduler.loaddistribution.IResourceInstanceConstraint;
import de.uka.ipd.sdq.scheduler.resources.IResourceInstance;

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
