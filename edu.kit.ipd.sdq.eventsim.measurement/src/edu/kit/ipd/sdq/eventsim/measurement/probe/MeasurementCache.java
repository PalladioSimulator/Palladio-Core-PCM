package edu.kit.ipd.sdq.eventsim.measurement.probe;

import java.util.HashMap;
import java.util.Map;
import java.util.WeakHashMap;

import org.apache.log4j.Logger;

import edu.kit.ipd.sdq.eventsim.measurement.Measurement;
import edu.kit.ipd.sdq.eventsim.measurement.MeasuringPoint;

/**
 * Caches {@link Measurement}s, at most one entry--the most recent one--per (trigger, {@link MeasuringPoint})-pair.
 * <p>
 * Entries whose trigger have been garbage-collected, will be automatically evicted from the cache. For this to work,
 * {@link Measurement}s MAY NOT strongly reference their respective trigger.
 * 
 * @author Philipp Merkle
 *
 * @param <E>
 * @param <T>
 */
public class MeasurementCache<E, T> {

	private static final Logger log = Logger.getLogger(MeasurementCache.class);

	/**
	 * Caches measurements for (trigger, measuring point)-pairs. After a trigger has been garbage-collected, the
	 * corresponding entry will be removed automatically, thanks to weakly-referenced keys in the outer map.
	 * <p>
	 * Values/measurements in the inner map MUST NOT strongly reference the trigger used as key in the outer map.
	 * Otherwise, entries cannot be evicted from the cache.
	 */
	private WeakHashMap<T, Map<MeasuringPoint<E>, Measurement<E, T>>> measurements;

	public MeasurementCache() {
		this.measurements = new WeakHashMap<>();
	}

	public void put(Measurement<E, T> m) {
		T trigger = m.getWho();
		if (!measurements.containsKey(trigger)) {
			measurements.put(trigger, new HashMap<>());
		}
		measurements.get(trigger).put(m.getWhere(), m);
		
		// System.out.println(String.format("Measurement cache for %s contains %s elements", m.getWhere(),
		// measurements.size()));
		// System.gc();

		if (log.isDebugEnabled())
			log.debug("Cached measurement: " + m);
//			log.debug(String.format("Measurement cache for %s contains %s elements", m.getWhere(), measurements.size()));
	}

	/**
	 * 
	 * @param trigger
	 *            the trigger
	 * @param mp
	 *            the measuring point
	 * @return the requested measurement, or {@code null}, if no such measurement can be found because it has been
	 *         evicted from the cache already, or because no such measurement has been added before.
	 */
	public Measurement<E, T> getLastMeasurement(T trigger, MeasuringPoint<E> mp) {
		Measurement<E, T> m = measurements.get(trigger).get(mp);
		if(m == null) {
//			log.warn(String.format("Requested last measurement for trigger %s, but corresponding measurements have "
//					+ "been evicted already or never have been added to the measurement cache.", trigger));
			return null;
		}
		return m;
	}

}
