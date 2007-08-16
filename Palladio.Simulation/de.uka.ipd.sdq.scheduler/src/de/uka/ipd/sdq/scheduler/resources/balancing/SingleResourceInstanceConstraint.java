package de.uka.ipd.sdq.scheduler.resources.balancing;

import de.uka.ipd.sdq.scheduler.resources.SimResourceInstance;


public class SingleResourceInstanceConstraint implements IResourceInstanceConstraint {

	@Override
	public boolean check(SimResourceInstance instance) {
		return idealResourceInstance.equals(instance);
	}

	/**
	 * @uml.property   name="idealResourceInstance"
	 * @uml.associationEnd   inverse="idealResourceInstanceConstraint:de.uka.ipd.sdq.capra.simulator.resources.SimResourceInstance"
	 */
	private SimResourceInstance idealResourceInstance;

	/**
	 * Getter of the property <tt>idealResourceInstance</tt>
	 * @return  Returns the idealResourceInstance.
	 * @uml.property  name="idealResourceInstance"
	 */
	public SimResourceInstance getIdealResourceInstance() {
		return idealResourceInstance;
	}

	/**
	 * Setter of the property <tt>idealResourceInstance</tt>
	 * @param idealResourceInstance  The idealResourceInstance to set.
	 * @uml.property  name="idealResourceInstance"
	 */
	public void setIdealResourceInstance(
			SimResourceInstance idealResourceInstance) {
				this.idealResourceInstance = idealResourceInstance;
			}

}
