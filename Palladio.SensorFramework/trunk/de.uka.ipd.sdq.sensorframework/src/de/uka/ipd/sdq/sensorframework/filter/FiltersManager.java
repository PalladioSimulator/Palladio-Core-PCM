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
	/** Filters count value. */
	private static int count = 0;
	
	public Object getFilteredMeasurements(SensorAndMeasurements sam) {
		return new SensorAndMeasurements(sam.getSensor(),
				filteringTheMeasurements(sam.getMeasurements()));
	}

	private Collection<Measurement> filteringTheMeasurements(
			Collection<Measurement> measuremts) {

		// Exit constraint.
		if (filters.isEmpty() || count == filters.size()){
			resetCount();
			return measuremts;
		}

		// get the filter from list
		AbstractMeasurementsFilter filter = filters.get(count++);
		// set the measurements
		filter.setOriginalMeasurements(measuremts);

		return filteringTheMeasurements(filter);
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
	}
}
