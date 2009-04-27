package org.somox.metrics;

public class MetricID {

	private int id;
	
	public MetricID(int id) {
		this.id = id;
	}
	
	public MetricID() {
	}
	
	public int getID() {
		return id;
	}
	
	public void setID(int id) {
		this.id = id;
	}
	
	public boolean equals(Object obj) {
		if(obj instanceof MetricID && ((MetricID)obj).getID() == this.id) {
			return true;
		} else {
			return false;
		}
		
	}
}
