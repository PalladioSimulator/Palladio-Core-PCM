package de.uka.ipd.sdq.sensorframework.adapter;

public interface IAdapterFactory {
	boolean canAdapt(Object adaptee, Class targetClass);
	IAdapter getAdapter(Object adaptee); 
}
