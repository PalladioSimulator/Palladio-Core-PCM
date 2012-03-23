package de.uka.ipd.sdq.edp2.visualization.properties;

public abstract class AbstractProperty<T> implements IProperty<T> {

	T value;
	String key;
	String description;
	String displayName;
	
	@Override
	public String getPropertyKey() {
		return key;
	}
	@Override
	public void setPropertyKey(String key) {
		this.key = key;
	}
	@Override
	public String getDisplayName() {
		return displayName;
	}
	@Override
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
	@Override
	public String getDescription() {
		return description;
	}
	@Override
	public void setDescription(String description) {
		this.description = description;
	}
	@Override
	public T getPropertyValue() {
		return value;
	}
	@Override
	public boolean setPropertyValue(T value) {
		this.value = value;
		return true;
	}
	
}
