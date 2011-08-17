package de.uka.ipd.sdq.pipesandfilters.framework;

import javax.measure.unit.Unit;

/**
 * This class holds information about the results that come from one single
 * ProbeSet.
 * 
 * @author Baum
 * 
 */
public class MeasurementMetric {

	/**
	 * Capture Type value of a measured object
	 */
	private CaptureType captureType;
	/**
	 * Specifies whether the measured values are monotonic
	 */
	private boolean isMonotonic;
	/**
	 * Specifies whether the measured values are strong monotonic
	 */
	private boolean isStrongMonotonic;
	/**
	 * The measurement unit
	 */
	private Unit<?> unit;
	/**
	 * The name of the measured object
	 */
	private String name;
	/**
	 * A textual description of what is measured
	 */
	private String description;
	/**
	 * The scale of the measured object
	 */
	private Scale scale;

	/**
	 * The constructor of MeasurementMetric, in which all necessary class
	 * members are set.
	 * 
	 * @param captureType The capture type of the metric.
	 * @param unit The unit of the metric.
	 * @param scale The measurement level of the metric.
	 */
	public MeasurementMetric(CaptureType captureType, Unit<?> unit, Scale scale) {
		this.captureType = captureType;
		this.unit = unit;
		this.scale = scale;
	}

	/**
	 * Returns the capture type.
	 * 
	 * @return The capture type.
	 */
	public CaptureType getCaptureType() {
		return captureType;
	}

	/**
	 * Returns whether the measured values are monotonic.
	 * 
	 * @return True, if the measured values are monotonic, else false.
	 */
	public boolean isMonotonic() {
		return isMonotonic;
	}

	/**
	 * Sets whether the measured values are monotonic.
	 * 
	 * @param isMonotonic
	 *            True, if the measured values are monotonic, else false.
	 */
	public void setMonotonic(boolean isMonotonic) {
		this.isMonotonic = isMonotonic;
	}

	/**
	 * Returns whether the measured values are strong monotonic.
	 * 
	 * @return True, if the measured values are monotonic, else false.
	 */
	public boolean isStrongMonotonic() {
		return isStrongMonotonic;
	}

	/**
	 * Sets whether the measured values are strong monotonic.
	 * 
	 * @param isStrongMonotonic
	 *            True, if the measured values are monotonic, else false.
	 */
	public void setStrongMonotonic(boolean isStrongMonotonic) {
		this.isStrongMonotonic = isStrongMonotonic;
	}

	/**
	 * Returns the unit of the measured object.
	 * 
	 * @return The Unit of the measured object.
	 */
	public Unit<?> getUnit() {
		return unit;
	}

	/**
	 * Returns the name of the measured object.
	 * 
	 * @return The name of the measured object.
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name of the measured object.
	 * 
	 * @param name
	 *            The name of the measured object.
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Returns a textual description of the measured object.
	 * 
	 * @return A textual description of the measured object.
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * Sets the textual description of the measured object.
	 * 
	 * @param description
	 *            The textual description.
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * Returns the measurement level of the measured object.
	 * 
	 * @return The measurement level of the measured object.
	 */
	public Scale getScale() {
		return scale;
	}
}
