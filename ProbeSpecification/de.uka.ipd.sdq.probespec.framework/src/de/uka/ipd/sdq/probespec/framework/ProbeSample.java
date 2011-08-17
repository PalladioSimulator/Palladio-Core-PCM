package de.uka.ipd.sdq.probespec.framework;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

/**
 * Represents a sample which is taken for a probe.
 * <p>
 * Use this class to store any type of probe sample. Therefore the class
 * parameters V and Q have to be specified which represents the sample type.
 * 
 * @param <V>
 *            denotes the class of the taken sample (Integer, Long, ...)
 * @param <Q>
 *            denotes the measured {@link Quantity}
 * @author pmerkle
 * 
 */
public class ProbeSample<V, Q extends Quantity> {

	/** the measured value and its quantity. */
	private Measure<V, Q> measure;

	private String probeID;

	private ProbeType probeType;

	/**
	 * Class constructor specifying the measured value, the id and type of the
	 * probe.
	 * 
	 * @param measure
	 *            the measured value in conjunction with its {@link Quantity}
	 * @param probeID
	 *            the id of the probe
	 * @param probeType
	 *            the type of the probe
	 * @see Measure
	 * @see ProbeType
	 */
	public ProbeSample(final Measure<V, Q> measure, final String probeID,
			final ProbeType probeType) {
		super();
		this.measure = measure;
		this.probeID = probeID;
		this.probeType = probeType;
	}

	/**
	 * Returns the encapsulated measured value in conjunction with its measured
	 * {@link Quantity}.
	 * 
	 * @return the measured value and its quantity
	 * @see Measure
	 */
	public Measure<V, Q> getMeasure() {
		return measure;
	}

	/**
	 * Returns the id of the measured probe according to the underlying model.
	 * 
	 * @return the probe id
	 */
	public String getProbeID() {
		return probeID;
	}

	/**
	 * Returns the type of the measured probe according to the underlying model.
	 * 
	 * @return the probe type
	 * @see ProbeType
	 */
	public ProbeType getProbeType() {
		return probeType;
	}

}
