package de.uka.ipd.sdq.sensorframework.adapter;

import java.util.Properties;

/**
 * Interface for DataAdapter in the SensorFramework. DataAdapter can read data 
 * from a data source and convert them to data structures usable by 
 * visualisations. Adapters are created by their respective AdapterFactory. 
 * @author Steffen Becker
 *
 */
public interface IAdapter {
	
	/**
	 * Return the computed visualisation data structure, e.g., a time series, a histogram, etc.
	 * @return The adapted object
	 */
	Object getAdaptedObject();
	
	/**
	 * Get the properties used to configure the adapter
	 * @return This adapters properties
	 */
	Properties getProperties();
	
	/** Set the properties of this adapter. Properties can be used to control the adapter's output, e.g., setting the histogram
	 * width of a histogram
	 * @param newProperties The new properties to be used in this adapter
	 */
	void setProperties(Properties newProperties);

}
