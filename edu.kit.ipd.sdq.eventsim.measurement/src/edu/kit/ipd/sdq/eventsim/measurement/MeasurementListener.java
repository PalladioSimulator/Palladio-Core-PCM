package edu.kit.ipd.sdq.eventsim.measurement;

/**
 * A listener that is notified whenever a new {@link Measurement} has been produced.
 * 
 * @author Philipp Merkle
 *
 * @param <E>
 * @param <T>
 */
public interface MeasurementListener<E, T> {

	void notify(Measurement<E, T> m);

}
