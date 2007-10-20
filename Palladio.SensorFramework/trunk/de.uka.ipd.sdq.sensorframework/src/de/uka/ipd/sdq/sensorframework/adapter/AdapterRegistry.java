package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class AdapterRegistry {

	private static AdapterRegistry singletonInstance = new AdapterRegistry();
	private static HashMap<String,IAdapterFactory> factories = new HashMap<String,IAdapterFactory>();
	
	private AdapterRegistry() {}
	
	public static AdapterRegistry singleton() {
		return singletonInstance;
	}
	
	public void addAdapterFactory(IAdapterFactory adapterFactory){
		factories.put(adapterFactory.getAdapterFactoryID(),adapterFactory);
	}

	public IAdapterFactory getFactoryByID(String factoryID){
		return factories.get(factoryID);
	}
	
	public boolean canAdapt(Object adaptee, Class<?> targetClass) {
		return getAllAvailableFactories(adaptee, targetClass).size() > 0;
	}

	public List<IAdapterFactory> getAllAvailableFactories(Object adaptee, Class<?> targetClass) {
		ArrayList<IAdapterFactory> result = new ArrayList<IAdapterFactory>();
		for(IAdapterFactory factory : factories.values()){
			if (factory.canAdapt(adaptee,targetClass))
			{
				result.add(factory);
			}
		}
		return result;
	}

	public IAdapter getAdapter(Object o, Class<?> class1) {
		return getAllAvailableFactories(o, class1).get(0).getAdapter(o);
	}

	public List<IAdapterFactory> getAllAvailableFactories(Class<?> targetClass) {
		ArrayList<IAdapterFactory> result = new ArrayList<IAdapterFactory>();
		for(IAdapterFactory factory : factories.values()){
			if (factory.createsAdaptersFor(targetClass))
			{
				result.add(factory);
			}
		}
		return result;
	}

}
