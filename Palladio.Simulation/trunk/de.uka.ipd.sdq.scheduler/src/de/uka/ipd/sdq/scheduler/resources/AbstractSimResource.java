package de.uka.ipd.sdq.scheduler.resources;

import de.uka.ipd.sdq.scheduler.ResourceFactory;


public abstract class AbstractSimResource {

	protected int capacity;
	private String name = "";
	private String id = "";
	protected ResourceFactory factory = new ResourceFactory();

	public AbstractSimResource(int capacity, String name, String id) {
		super();
		this.capacity = capacity;
		this.name = name;
		this.id = id;
	}

	public int getCapacity() {
		return capacity;
	}

	public String getName() {
		return name;
	}

	public String getId() {
		return id;
	}
}
