package de.uka.ipd.sdq.sensorframework.filter;

import java.util.Collection;
import java.util.Properties;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

/**
 * Factory interface for creating the filtered collection - cf. java.util.Collection. 
 * 
 * @author Roman Andrej
 */
public interface IFilteredCollectionFactory {

	/**
	 * Check whether this filter factory can filter the given collection.
	 * 
	 * @param filtrate
	 *            The collection to filter
	 * @param attribute
	 *            The object of the required input attribute
	 * @return true if this factory can create filtered collection of the required type,
	 *         false otherwise
	 */
	boolean canFilter(Collection<Measurement> filtrate, Number attribute);

	/**
	 * Factory method. Creates a new filter with default parameter
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
	
	/**TODO add documentation here
	 * @param type
	 * @return
	 */
	Number convertToType(String type);

}
