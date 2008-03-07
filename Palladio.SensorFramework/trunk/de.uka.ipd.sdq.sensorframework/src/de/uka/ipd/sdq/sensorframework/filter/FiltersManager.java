package de.uka.ipd.sdq.sensorframework.filter;

import java.util.ArrayList;
import java.util.Collection;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;
import de.uka.ipd.sdq.sensorframework.filter.AbstractMeasurementsFilter;

/**
 * @author Roman Andrej
 */
public class FiltersManager {
	
	/** List with active filters. */
	private ArrayList<AbstractMeasurementsFilter> filters = 
					new ArrayList<AbstractMeasurementsFilter>();
	
	/** Define just now active filter. */
	private static AbstractMeasurementsFilter activeFilter;
	
	/** Filters count value. */
	private static int count = 0;
	
	public Object getFilteredMeasurements(SensorAndMeasurements sam) {
		return new SensorAndMeasurements(sam.getSensor(),
				filteringTheMeasurements(sam.getMeasurements()));
	}

	private Collection<Measurement> filteringTheMeasurements(
			Collection<Measurement> measuremts) {

		// Exit constraint.
		if (filters.isEmpty() || count == filters.size()) {
			resetCount();
			return measuremts;
		}

		activeFilter = filters.get(count++);
		// set the measurements
		activeFilter.setOriginalMeasurements(measuremts);

		return filteringTheMeasurements(activeFilter);
	}

	public void addFilter(AbstractMeasurementsFilter filter) {
		filters.add(filter);
	}

	public ArrayList<AbstractMeasurementsFilter> getAllFilters() {
		return filters;
	}

	public void removeFilter(AbstractMeasurementsFilter filter) {
		filters.remove(filter);
	}

	public static void resetCount() {
		count = 0;
		if (activeFilter != null)
			activeFilter.resetFilteredItems();
	}
}
