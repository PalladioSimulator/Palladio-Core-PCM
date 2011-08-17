package de.uka.ipd.sdq.scheduler.resources;

import de.uka.ipd.sdq.scheduler.factory.SchedulingFactory;


public abstract class AbstractSimResource {

	protected int capacity;
	private String name = "";
	private String id = "";
	protected SchedulingFactory factory = new SchedulingFactory();
	

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
		return name + "_" + id;
	}

	public String getId() {
		return id;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (obj != null && obj instanceof AbstractSimResource) {
			AbstractSimResource res = (AbstractSimResource) obj;
			return this.id.equals(res.getId());
		}
		return false;
	}
	
	@Override
	public String toString() {
		return name + id;
	}
	
	@Override
	public int hashCode() {
		return id.hashCode();
	}
}
