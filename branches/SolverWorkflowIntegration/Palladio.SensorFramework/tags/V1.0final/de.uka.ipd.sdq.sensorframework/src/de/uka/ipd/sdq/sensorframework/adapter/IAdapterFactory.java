package de.uka.ipd.sdq.sensorframework.adapter;


/**
 * Factory interface for factories creating data adapter
 * @author Steffen Becker
 *
 */
public interface IAdapterFactory {
	
	/**
	 * Check whether this adapter factory can adapt the given object to the given class
	 * @param adaptee The object to adapt
	 * @param targetClass The class of the required adapter output
	 * @return true if this factory can create adapters of the required type, false otherwise
	 */
	boolean canAdapt(Object adaptee, Class<?> targetClass);
	
	/**
	 * Factory method. Creates a new adapter of this factory's type
	 * @param adaptee The data source to adapt
	 * @return A data adapter which adapts the given data source
	 */
	DataAdapter getAdapter(Object adaptee); 
	

	/**
	 * Get a descriptive label of the metric computed by adapters created by this factory, e.g., ResponseTime or Throughput
	 * @return A label describing the calculated metric
	 */
	String getMetricLabel();	
	
	/**
	 * @return A unique id for this adapter factory
	 */
	String getAdapterFactoryID();

	boolean createsAdaptersFor(Class<?> targetClass);
}
