package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * This registry can store adapter factories 
 * (cf. interface {@link IAdapterFactory}), 
 * but cannot remove them. It can be queried, but not reset.
 * @author Steffen Becker
 *
 */
public class AdapterRegistry {

	private static AdapterRegistry singletonInstance = new AdapterRegistry();//why not final?
	
	private static HashMap<String,IAdapterFactory> factories = new HashMap<String,IAdapterFactory>();
	
	public static AdapterRegistry singleton() {
		return singletonInstance;
	}
	
	private AdapterRegistry() {}
	
	public void addAdapterFactory(IAdapterFactory adapterFactory){
		factories.put(adapterFactory.getAdapterFactoryID(),adapterFactory);
	}

	public boolean canAdapt(Object adaptee, Class<?> targetClass) {
		//inefficient: iterate over factories and if one is found, abort immediately, returning true
		return getAllAvailableFactories(adaptee, targetClass).size() > 0;
	}
	
	/**
	 * Returns the first adapter suitable for passed parameters
	 * @param objToAdapt
	 * @param class1
	 * @return
	 */
	public IAdapter getAdapter(Object objToAdapt, Class<?> class1) {
		return getAllAvailableFactories(objToAdapt, class1).get(0).getAdapter(objToAdapt);
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

	public IAdapterFactory getFactoryByID(String factoryID){
		return factories.get(factoryID);
	}

}
