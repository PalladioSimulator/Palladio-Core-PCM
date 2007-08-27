package de.uka.ipd.sdq.scheduler.loaddistribution;

import de.uka.ipd.sdq.scheduler.IResourceInstance;

public interface IResourceInstanceConstraint {

	/**
	 * Checks whether this process can run on the specified resource instance.
	 */
	public abstract boolean check(IResourceInstance instance);

}
