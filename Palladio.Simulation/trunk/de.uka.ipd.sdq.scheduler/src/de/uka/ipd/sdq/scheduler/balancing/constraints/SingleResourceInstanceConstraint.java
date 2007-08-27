package de.uka.ipd.sdq.scheduler.balancing.constraints;

import de.uka.ipd.sdq.scheduler.balancing.IResourceInstanceConstraint;
import de.uka.ipd.sdq.scheduler.resources.active.SimResourceInstance;

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
