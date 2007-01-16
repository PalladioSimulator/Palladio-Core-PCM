package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;

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
	
	public Object getAdapter(Object adaptee, Class targetClass){
		for(IAdapterFactory factory : factories){
			if (factory.canAdapt(adaptee.getClass(),targetClass))
			{
				return factory.getAdapter(adaptee, targetClass);
			}
		}
		return null;
	}
}
