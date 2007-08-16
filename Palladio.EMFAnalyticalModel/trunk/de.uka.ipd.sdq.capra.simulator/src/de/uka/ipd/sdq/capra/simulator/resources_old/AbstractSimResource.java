package de.uka.ipd.sdq.capra.simulator.resources_old;

/**
 * @author  jens.happe
 */
public abstract class AbstractSimResource {
	public static final int INFINITE = -1;
	
	/**
	 * @uml.property  name="name"
	 */
	protected String name;
	/**
	 * @uml.property  name="capacity"
	 */
	protected int capacity;
	
	public AbstractSimResource(String name, int capacity){
		this.capacity = capacity;
		this.name = name;
	}
	
	/**
	 * @return
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * @return
	 * @uml.property  name="capacity"
	 */
	public int getCapacity(){
		return capacity;
	}
}
