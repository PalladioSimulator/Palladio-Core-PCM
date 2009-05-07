package de.uka.ipd.sdq.sensorframework.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * The class manages all available filtered collections.
 * 
 * @author Roman Andrej
 * 
 */
public class FilteredCollectionRegistry {

	/** Define the FilteredCollectionRegistry instance. */
	private static FilteredCollectionRegistry singletonInstance = new FilteredCollectionRegistry();
	
	/** Define the map with filtered collections (filter name, collection). */
	private static HashMap<String, IFilteredCollectionFactory> factories = new HashMap<String, IFilteredCollectionFactory>();

	/** Singleton pattern. */
	private FilteredCollectionRegistry() {
	}

	public static FilteredCollectionRegistry singleton() {
		return singletonInstance;
	}

	public void addFilteredCollectionFactory(String filterName,
			IFilteredCollectionFactory filter) {
		factories.put(filterName, filter);
	}

	public IFilteredCollectionFactory getFilteredCollectionFactoryByID(
			String factoryID) {
		return factories.get(factoryID);
	}

	/**TODO add documentation
	 * @return
	 */
	public List<IFilteredCollectionFactory> getAllAvailableCollectionFactories() {
		ArrayList<IFilteredCollectionFactory> result = new ArrayList<IFilteredCollectionFactory>();
		for (IFilteredCollectionFactory filter : factories.values()) {
			result.add(filter);
		}
		return result;
	}
}
