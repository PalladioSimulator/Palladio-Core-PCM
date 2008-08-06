package de.uka.ipd.sdq.sensorframework.filter;

import java.util.Collection;
import java.util.Properties;

import de.uka.ipd.sdq.sensorframework.entities.Measurement;

public class WarmupFilteredFactory implements IFilteredCollectionFactory {

	/** The properties settings for this filtered collection */
	protected Properties filterProperties = new Properties();

	/** The property "warm up". */
	public static final String WARMUP = "Warm Up";
	/** Default warm up to use. */
	public static final long DEFAULT_WARMUP = 2500L;

	/**
	 * Initializes a new WarmupFilteredFactory without properties.
	 */
	public WarmupFilteredFactory() {
		filterProperties.put(WARMUP, DEFAULT_WARMUP);
	}

	/** {@inheritDoc}
	 */
	public AbstractMeasurementsCollection getFilteredCollection(
			Collection<Measurement> filtrate) {
		return new WarmupFilteredCollection(filtrate, DEFAULT_WARMUP);
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
	public boolean canFilter(Collection<Measurement> filtrate,
			Number attribute) {
		return attribute.longValue() < filtrate.size();
	}

	/**
	 * {@inheritDoc}
	 */
	public AbstractMeasurementsCollection getFilteredCollection(
			Collection<Measurement> filtrate, Number parameter) {
		filterProperties.put(WARMUP, parameter.longValue());
		return new WarmupFilteredCollection(filtrate, parameter.longValue());
	}

	/**
	 * {@inheritDoc}
	 */
	public String getFilterFactoryID() {
		return "Warm Up Filter";
	}

	/** {@inheritDoc}
	 */
	public Long convertToType(String type) {
		return Long.parseLong(type);
	}
}
