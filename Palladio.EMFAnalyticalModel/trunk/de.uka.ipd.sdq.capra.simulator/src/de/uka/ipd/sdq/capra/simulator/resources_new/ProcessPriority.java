package de.uka.ipd.sdq.capra.simulator.resources_new;


public class ProcessPriority extends AbstractDecoratedProcess {

	/**
	 * @uml.property  name="static_priority"
	 */
	private int static_priority;

	/** 
	 * Getter of the property <tt>priority</tt>
	 * @return  Returns the priority.
	 * @uml.property  name="static_priority"
	 */
	public int getStatic_priority() {
		return static_priority;
	}

	/** 
	 * Setter of the property <tt>priority</tt>
	 * @param priority  The priority to set.
	 * @uml.property  name="static_priority"
	 */
	public void setStatic_priority(int static_priority) {
		this.static_priority = static_priority;
	}

	/**
	 * @uml.property  name="dynamic_priority"
	 */
	private int dynamic_priority;

	/**
	 * Getter of the property <tt>dynamic_priority</tt>
	 * @return  Returns the dynamic_priority.
	 * @uml.property  name="dynamic_priority"
	 */
	public int getDynamic_priority() {
		return dynamic_priority;
	}

	/**
	 * Setter of the property <tt>dynamic_priority</tt>
	 * @param dynamic_priority  The dynamic_priority to set.
	 * @uml.property  name="dynamic_priority"
	 */
	public void setDynamic_priority(int dynamic_priority) {
		this.dynamic_priority = dynamic_priority;
	}

}
