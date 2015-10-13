package edu.kit.ipd.sdq.eventsim.measurement.probe;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementListener;
import edu.kit.ipd.sdq.eventsim.measurement.MeasurementProducer;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;

/**
 * 
 * A probe that is attached to a {@link MeasuringPoint} and continuously produces {@link Measurement} whenever the
 * observed {@link MeasuringPoint}'s state changes.
 * 
 * @author Philipp Merkle
 *
 * @param <E>
 *            type of the probed element
 * @param <T>
 *            type of the triggering element
 */
public interface IProbe<E, T> extends MeasurementProducer<E, T> {

	/**
	 * Returns the latest measurement caused by the given trigger.
	 * 
	 * @param who
	 *            the trigger
	 * @return the most recent measurement caused by the given trigger, or {@code null}, if there is no such
	 *         measurement.
	 */
	Measurement<E, T> getLastMeasurementOf(T who);

	/**
	 * @return the measuring point this probe is attached to.
	 */
	MeasuringPoint<E> getMeasuringPoint();

	/**
	 * Constructs and returns a probe without any actual behaviour. Can be used as a replacement for {@code null}.
	 * 
	 * @return the constructed {@code null} probe.
	 */
	public static <E, T> IProbe<E, T> nullProbe(E element, String property, Object... contexts) {
		return new IProbe<E, T>() {
			@Override
			public void forEachMeasurement(MeasurementListener<E, T> l) {
			}

			@Override
			public Measurement<E, T> getLastMeasurementOf(T who) {
				return null;
			}

			@Override
			public MeasuringPoint<E> getMeasuringPoint() {
				return new MeasuringPoint<E>(element, property, contexts);
			}

			@Override
			public void enableCaching() {
			}

			@Override
			public void disableCaching() {
			}
		};
	}
	
	public void enableCaching();
	
	public void disableCaching();	

}
