package de.uka.ipd.sdq.measurements.rmi.tasks;

import java.io.Serializable;

public abstract class RmiAbstractTask implements Serializable {
	
	private int id = 0;
	private String name = "";
	private boolean sensor = false;
	
	protected RmiAbstractTask(int id) {
		this.id = id;
	}
		
	public int getId() {
		return id;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setSensor(boolean sensor) {
		this.sensor = sensor;
	}
	
	public boolean getSensor() {
		return sensor;
	}

	private static final long serialVersionUID = 197567359806648167L;

}
