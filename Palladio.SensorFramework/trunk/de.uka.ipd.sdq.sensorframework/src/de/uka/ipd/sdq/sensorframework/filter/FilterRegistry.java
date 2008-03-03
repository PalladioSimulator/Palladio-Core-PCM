package de.uka.ipd.sdq.sensorframework.filter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FilterRegistry {

	private static FilterRegistry singletonInstance = new FilterRegistry();
	private static HashMap<String, AbstractMeasurementsFilter> filters = new HashMap<String, AbstractMeasurementsFilter>();

	private FilterRegistry() {
	}

	public static FilterRegistry singleton() {
		return singletonInstance;
	}

	public void addFilter(String displayName,
			AbstractMeasurementsFilter filter) {
		filters.put(displayName, filter);
	}

	public AbstractMeasurementsFilter getFilterByName(
			String displayName) {
		return filters.get(displayName);
	}
	
	public List<AbstractMeasurementsFilter> getAllAvailableFilters() {
		ArrayList<AbstractMeasurementsFilter> result = new ArrayList<AbstractMeasurementsFilter>();
		for (AbstractMeasurementsFilter filter : filters.values()) {
			result.add(filter);
		}
		return result;
	}
}
