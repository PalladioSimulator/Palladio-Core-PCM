package de.uka.ipd.sdq.sensorframework.filter;

import java.util.Collection;
import java.util.Properties;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

public class OutlierFilteredFactory implements IFilteredCollectionFactory {
	
	/** The properties settings for this filtered collection */
	protected Properties filterProperties = new Properties();

	/** The property "outlier". */
	private static final String OUTLIER = "Outlier removal";
	
	/** Default outlier fraction to use in filtering. */
	private static final double DEFAULT_OUTLIER = 0.1;
	
	/**
	 * Initializes a new OutlierFilteredFactory without properties.
	 */
	public OutlierFilteredFactory(){
		filterProperties.put(OUTLIER, DEFAULT_OUTLIER);
	}

	/** {@inheritDoc}
	 */
	public AbstractMeasurementsCollection getFilteredCollection(
			Collection<Measurement> filtrate) {
		return new OutlierFilteredCollection(filtrate, DEFAULT_OUTLIER);
	}

	/** {@inheritDoc}
	 */
	public Properties getProperties() {
		return filterProperties;
	}

	/** {@inheritDoc}
	 */
	public void setProperties(Properties newProperties) {
		filterProperties = newProperties;
	}

	/**
	 * {@inheritDoc}
	 */
	public boolean canFilter(Collection<Measurement> filtrate, Number attribute) {
		return attribute.doubleValue() < 1.0;
	}

	/**
	 * {@inheritDoc}
	 */
	public AbstractMeasurementsCollection getFilteredCollection(
			Collection<Measurement> filtrate, Number parameter) {
			filterProperties.put(OUTLIER, parameter.doubleValue());//TODO no checks are made here
			return new OutlierFilteredCollection(filtrate, parameter
					.doubleValue());
	}

	/**
	 * {@inheritDoc}
	 */
	public String getFilterFactoryID() {
		return "Outlier Filter";
	}

	/** {@inheritDoc}
	 */
	public Double convertToType(String type) {
		return Double.parseDouble(type);
	}
}
