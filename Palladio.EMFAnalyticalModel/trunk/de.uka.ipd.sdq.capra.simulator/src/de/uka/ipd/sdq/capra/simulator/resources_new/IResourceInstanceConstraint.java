package de.uka.ipd.sdq.capra.simulator.resources_new;

public interface IResourceInstanceConstraint {

	/**
	 * Checks whether this process can run on the specified resource instance.
	 */
	public abstract boolean check(SimResourceInstance instance);

}
