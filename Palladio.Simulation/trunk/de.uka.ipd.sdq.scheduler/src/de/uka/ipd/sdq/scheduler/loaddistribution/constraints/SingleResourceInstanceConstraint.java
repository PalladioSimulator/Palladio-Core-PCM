package de.uka.ipd.sdq.scheduler.loaddistribution.constraints;

import de.uka.ipd.sdq.scheduler.IResourceInstance;
import de.uka.ipd.sdq.scheduler.loaddistribution.IResourceInstanceConstraint;

public class SingleResourceInstanceConstraint implements
		IResourceInstanceConstraint {

	private IResourceInstance instance;

	public SingleResourceInstanceConstraint(IResourceInstance instance) {
		super();
		this.instance = instance;
	}

	@Override
	public boolean check(IResourceInstance instance) {
		return this.instance.equals(instance);
	}

	public IResourceInstance getResourceInstance() {
		return instance;
	}
}
