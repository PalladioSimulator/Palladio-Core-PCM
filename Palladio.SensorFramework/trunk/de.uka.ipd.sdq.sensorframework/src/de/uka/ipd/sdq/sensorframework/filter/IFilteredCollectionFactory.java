package de.uka.ipd.sdq.sensorframework.filter;

import java.util.Collection;
import java.util.Properties;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

/**
 * Factory interface for creating the filtered collection 
 * 
 * @author Roman Andrej
 */
public interface IFilteredCollectionFactory {

	/**
	 * Check whether this filter factory can filtering the given collection.
	 * 
	 * @param filtrate
	 *            The collection to filtering
	 * @param attribute
	 *            The object of the required input attribute
	 * @return true if this factory can create filtered collection of the required type,
	 *         false otherwise
	 */
	boolean canFiltered(Collection<Measurement> filtrate, Number attribute);

	/**
	 * Factory method. Creates a new filter with default paramete
	 * 
	 * @param filtrate
	 *            The data source to filtering
	 * @return A data adapter which adapts the given data source
	 */
	AbstractMeasurementsCollection getFilteredCollection(Collection<Measurement> filtrate);
	
	/**
	 * Factory method. Creates a new filter of this factory's type
	 * 
	 * @param filtrate
	 *            The data source to filtering
	 * @return A data adapter which adapts the given data source
	 */
	AbstractMeasurementsCollection getFilteredCollection(Collection<Measurement> filtrate, Number parameter);
	
	/**
	 * @return A unique id for this filter factory
	 */
	String getFilterFactoryID();
	

	/**
	 * Get the properties used to configure the filter
	 * 
	 * @return This filters properties
	 */
	Properties getProperties();

	/**
	 * Set the properties of this filter. Properties can be used to control the
	 * filters's parameter.
	 * 
	 * @param newProperties
	 *            The new properties to be used in this adapter
	 * @return 
	 */
	void setProperties(Properties newProperties);
	
	Number convertToType(String type);

}
