package edu.kit.ipd.sdq.eventsim.measurement;

/**
 * An emitter for {@link Measurement}s.
 * 
 * @author Philipp Merkle
 *
 * @param <E>
 * @param <T>
 */
public interface MeasurementProducer<E, T> {

	public void forEachMeasurement(MeasurementListener<E, T> l);
	
}
