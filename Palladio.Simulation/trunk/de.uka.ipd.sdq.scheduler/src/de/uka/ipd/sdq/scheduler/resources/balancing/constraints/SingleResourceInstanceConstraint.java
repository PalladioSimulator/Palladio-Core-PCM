package de.uka.ipd.sdq.scheduler.resources.balancing.constraints;

import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;
import de.uka.ipd.sdq.scheduler.resources.balancing.IResourceInstanceConstraint;

public class SingleResourceInstanceConstraint implements
		IResourceInstanceConstraint {

	private SimResourceInstance instance;

	public SingleResourceInstanceConstraint(SimResourceInstance instance) {
		super();
		this.instance = instance;
	}

	@Override
	public boolean check(SimResourceInstance instance) {
		return this.instance.equals(instance);
	}

	public SimResourceInstance getResourceInstance() {
		return instance;
	}
}
