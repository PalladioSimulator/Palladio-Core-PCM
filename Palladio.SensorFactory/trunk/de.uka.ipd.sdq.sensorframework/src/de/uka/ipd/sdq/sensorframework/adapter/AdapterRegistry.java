package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;

import de.uka.ipd.sdq.sensorfactory.entities.SensorAndMeasurements;

public class AdapterRegistry {

	private static AdapterRegistry singletonInstance = new AdapterRegistry();
	private static ArrayList<IAdapterFactory> factories = new ArrayList<IAdapterFactory>();
	
	private AdapterRegistry() {}
	
	public static AdapterRegistry singleton() {
		return singletonInstance;
	}
	
	public void addAdapterFactory(IAdapterFactory adapterFactory){
		factories.add(adapterFactory);
	}
	
	public IAdapter getAdapter(Object adaptee, Class targetClass){
		for(IAdapterFactory factory : factories){
			if (factory.canAdapt(adaptee,targetClass))
			{
				return factory.getAdapter(adaptee);
			}
		}
		return null;
	}

	public boolean canAdapt(Object adaptee, Class targetClass) {
		for(IAdapterFactory factory : factories){
			if (factory.canAdapt(adaptee,targetClass))
			{
				return true;
			}
		}
		return false;
	}
}
