package edu.kit.ipd.sdq.eventsim.measurement.probe;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementListener;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;
import edu.kit.ipd.sdq.eventsim.measurement.ProbeConfiguration;

/**
 * 
 * @author Philipp Merkle
 *
 * @param <E>
 *            the type of the probed element
 * @param <T>
 *            the type of the triggering element
 */
public abstract class AbstractProbe<E, T, C extends ProbeConfiguration> implements IProbe<E, T> {

	private static final Logger log = Logger.getLogger(AbstractProbe.class);

	protected MeasurementCache<E, T> cache;

	protected List<MeasurementListener<E, T>> measurementListener;

	protected MeasuringPoint<E> measuringPoint;

	protected C configuration;

	private boolean cacheEnabled;

	public AbstractProbe(MeasuringPoint<E> p, C configuration) {
		this.measuringPoint = p;
		this.configuration = configuration;
		this.cache = new DisabledCache();
		this.measurementListener = new ArrayList<>();
	}

	@Override
	public Measurement<E, T> getLastMeasurementOf(T who) {
		return cache.getLastMeasurement(who, measuringPoint);
	}

	@Override
	public void forEachMeasurement(MeasurementListener<E, T> l) {
		measurementListener.add(l);
	}

	@Override
	public MeasuringPoint<E> getMeasuringPoint() {
		return measuringPoint;
	}

	/**
	 * Enables caching of measurements for this probe. If caching is already enabled, this method has no effect.
	 */
	public void enableCaching() {
		if (!cacheEnabled) {
			cache = new MeasurementCache<>();
			cacheEnabled = true;
		}
	}

	/**
	 * Disables caching of measurements for this probe and removes cached measurements, if any. If caching is already
	 * disabled, this method has no effect.
	 */
	public void disableCaching() {
		if (cacheEnabled) {
			cache = new DisabledCache();
			cacheEnabled = false;
		}
	}

	private class DisabledCache extends MeasurementCache<E, T> {

		@Override
		public void put(Measurement<E, T> m) {
			// do nothing
		}

		@Override
		public Measurement<E, T> getLastMeasurement(T trigger, MeasuringPoint<E> mp) {
			log.warn(String.format("Tried to retrieve a measurement for probe %s, but caching of measurements is "
					+ "disabled for this probe.", AbstractProbe.this));
			return null;
		}

	}

}
