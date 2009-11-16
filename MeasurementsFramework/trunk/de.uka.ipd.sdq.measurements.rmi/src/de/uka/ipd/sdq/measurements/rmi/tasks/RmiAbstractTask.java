package de.uka.ipd.sdq.measurements.rmi.tasks;

import java.io.Serializable;
import java.util.List;

public abstract class RmiAbstractTask implements Serializable {
	
	private int id = 0;
	private String name = "";
	private boolean sensor = false;
	private List<RmiResult> result = null;
	
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
	
	public void setResult(List<RmiResult> result) {
		this.result = result;
	}
	
	public List<RmiResult> getResult() {
		if (sensor == false) {
			return null;
		}
		return result;
	}

	private static final long serialVersionUID = 197567359806648167L;

}
