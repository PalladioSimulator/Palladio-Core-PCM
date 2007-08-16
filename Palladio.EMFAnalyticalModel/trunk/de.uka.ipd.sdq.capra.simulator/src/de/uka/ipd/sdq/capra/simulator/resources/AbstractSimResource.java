package de.uka.ipd.sdq.capra.simulator.resources;


public abstract class AbstractSimResource {

	/**
	 * @uml.property  name="capacity"
	 */
	private int capacity;

	/** 
	 * Getter of the property <tt>numReplicas</tt>
	 * @return  Returns the numReplicas.
	 * @uml.property  name="capacity"
	 */
	public int getCapacity() {
		return capacity;
	}

	/** 
	 * Setter of the property <tt>numReplicas</tt>
	 * @param numReplicas  The numReplicas to set.
	 * @uml.property  name="capacity"
	 */
	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	/**
	 * @uml.property  name="name"
	 */
	private String name = "";

	/**
	 * Getter of the property <tt>name</tt>
	 * @return  Returns the name.
	 * @uml.property  name="name"
	 */
	public String getName() {
		return name;
	}

	/**
	 * Setter of the property <tt>name</tt>
	 * @param name  The name to set.
	 * @uml.property  name="name"
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * @uml.property  name="id"
	 */
	private String id = "";

	/**
	 * Getter of the property <tt>id</tt>
	 * @return  Returns the id.
	 * @uml.property  name="id"
	 */
	public String getId() {
		return id;
	}

	/**
	 * Setter of the property <tt>id</tt>
	 * @param id  The id to set.
	 * @uml.property  name="id"
	 */
	public void setId(String id) {
		this.id = id;
	}

}
