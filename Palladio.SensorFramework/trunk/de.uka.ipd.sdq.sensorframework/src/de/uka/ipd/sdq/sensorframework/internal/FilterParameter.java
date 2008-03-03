package de.uka.ipd.sdq.sensorframework.filter;

public class FilterParameter<T> {

	private String description;;
	private T value;
	
	public FilterParameter(T value, String description) {
		this.value = value;
		this.description = description;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public T getValue() {
		return value;
	}

	public void setValue(T value) {
		this.value = value;
	}
}
