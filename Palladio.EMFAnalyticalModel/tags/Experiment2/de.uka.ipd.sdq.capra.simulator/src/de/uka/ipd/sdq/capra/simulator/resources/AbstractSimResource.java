package de.uka.ipd.sdq.capra.simulator.resources;

public abstract class AbstractSimResource {
	public static final int INFINITE = -1;
	
	protected String name;
	protected int capacity;
	
	public AbstractSimResource(String name, int capacity){
		this.capacity = capacity;
		this.name = name;
	}
	
	public abstract void init();
	
	public String getName() {
		return name;
	}
	
	public int getCapacity(){
		return capacity;
	}
}
