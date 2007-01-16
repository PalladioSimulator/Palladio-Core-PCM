package de.uka.ipd.sdq.sensorframework.adapter;

public interface IAdapterFactory {
	boolean canAdapt(Class fromClass, Class targetClass);
	Object getAdapter(Object adaptee, Class targetClass); 
}
