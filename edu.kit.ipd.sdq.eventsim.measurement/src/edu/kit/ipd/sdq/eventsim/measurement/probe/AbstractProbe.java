package edu.kit.ipd.sdq.eventsim.measurement.probe;

import java.util.ArrayList;
import java.util.List;

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

	protected MeasurementCache<E, T> cache;

	protected List<MeasurementListener<E, T>> measurementListener;

	protected MeasuringPoint<E> measuringPoint;

	protected C configuration;

	public AbstractProbe(MeasuringPoint<E> p, C configuration) {
		this.measuringPoint = p;
		this.configuration = configuration;
		this.cache = new MeasurementCache<>();
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

}
