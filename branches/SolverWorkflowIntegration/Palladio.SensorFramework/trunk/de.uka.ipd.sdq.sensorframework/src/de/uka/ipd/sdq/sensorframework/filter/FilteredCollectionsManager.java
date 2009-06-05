package de.uka.ipd.sdq.sensorframework.filter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Properties;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;
import de.uka.ipd.sdq.sensorframework.entities.SensorAndMeasurements;

/**
 * The class creates the filtered collection from measurements collection.
 * 
 * @author Roman Andrej
 */
public class FilteredCollectionsManager {

	private ArrayList<IFilteredCollectionFactory> factories = new ArrayList<IFilteredCollectionFactory>();
	
	IFilteredCollectionFactory factory;

	/** Filters count value. */
	private static int count = 0;

	/** Get the filtered measurements as new SensorAndMeasurements instance. */
	public Object getFilteredMeasurements(SensorAndMeasurements sam) {
		return new SensorAndMeasurements(sam.getSensor(),
				filteringTheMeasurements(sam.getMeasurements()));
	}

	/** Set the filter sequence. */
	private Collection<Measurement> filteringTheMeasurements(
			Collection<Measurement> measuremts) {

		// Exit constraint.
		if (factories.isEmpty() || count == factories.size()) {
			// set counter of 0
			resetCount();
			return measuremts;
		}
		factory = factories.get(count++);

		AbstractMeasurementsCollection filteredCollection;

		if (factory.canFilter(measuremts,
				getProperty(factory.getProperties()))) {
			filteredCollection = factory.getFilteredCollection(measuremts,
					getProperty(factory.getProperties()));
		} else {
			// set the minimal value for filtering attribute
			filteredCollection = factory.getFilteredCollection(measuremts,
					factory.convertToType("0"));
		}

		// call it self with another filtered collection
		return filteringTheMeasurements(filteredCollection);
	}

	/** Get the value of first property. */
	private Number getProperty(Properties properties) {
		// get the attribute description
		String desc = properties.propertyNames().nextElement().toString();
		// get attribute
		return (Number) properties.get(desc);
	}
	
	public void addFactory(IFilteredCollectionFactory factory) {
		factories.add(factory);
	}
	
	public void removeFactory(IFilteredCollectionFactory factory){
		factories.remove(factory);
	}

	/**
	 * @return the factories
	 */
	public ArrayList<IFilteredCollectionFactory> getFactories() {
		return factories;
	}

	/**
	 * @param factories the factories to set
	 */
	public void setFactories(ArrayList<IFilteredCollectionFactory> factories) {
		this.factories = factories;
	}

	/** The method is used for control of the filtered collection sequence. */
	public void resetCount() {
		count = 0;
	}
}
