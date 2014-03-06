/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;

/**A single measurement for a measure (definition).
 * @author groenda
 *
 */
public class Measurement {
	/** Flag allowing to control if data stored in an instance of this class is checked 
	 * to obey the corresponding specification in the metric definition. */
	private boolean validateData;

	/** A single measurement with a value for each element specified in the metric definition. */
	private Object[] measuredValue;
	
	/** The definition of the metric which is used to gather the measured values. */
	private MetricDescription metric;
	
	/** The base metric definitions of the provided metric. This depends on metric. */
	BaseMetricDescription[] descriptions;
	
	public Measurement(MetricDescription metric) {
		validateData = true;
		prepareForMetric(metric);
	}

	/**Prepares the measuredValue object for storing values of the set metric.
	 */
	private void prepareForMetric(MetricDescription metric) {
		this.metric = metric;
		descriptions = MetricDescriptionUtility.toBaseMetricDescriptions(metric);
		measuredValue = new Object[descriptions.length];
	}

	/**Set the value of the specified index.
	 * @param measuredValueIndex Index of the measurement.
	 * @param value The value to set.
	 */
	public void setMeasuredValue(int measuredValueIndex, Object value) {
		assert(measuredValue != null);
		if (measuredValueIndex < 0) {
			throw new IndexOutOfBoundsException("Index must be greater or equal to 0. It was " + measuredValueIndex);
		}
		if (measuredValueIndex >= measuredValue.length) {
			throw new IndexOutOfBoundsException("Index must be less than the number of measurements length in the metric specification. Length is " + measuredValue.length + " requested index was " + measuredValueIndex);
		}
		if (value == null) {
			throw new IllegalArgumentException("Provided value must not be null.");
		}
		if (validateData) {
			if (!MetricDescriptionUtility.isValidValue(descriptions[measuredValueIndex], value)) {
				throw new IllegalArgumentException("Type of provided value was not valid. BaseMetricDescription is " + descriptions[measuredValueIndex] + ", value was " + value);
			}
		}
		measuredValue[measuredValueIndex] = value;
	}
	
	/**Returns the value of the specified index.
	 * @param index Index for which the value is requested.
	 * @return Measured value.
	 */
	public Object getMeasuredValue(int index) {
		assert(measuredValue != null);
		return measuredValue[index];
	}

	/**Returns if data is validated at the point it is stored for an index.
	 * @return the validateData
	 */
	public boolean isDataValidatedIfStored() {
		return validateData;
	}

	/**Sets it data is validated if the value for an index is set.
	 * @param validateData the validateData to set
	 */
	public void setValidateData(boolean validateData) {
		this.validateData = validateData;
	}

	/**Returns the metric associated with the measure value stored in this instance.
	 * @return the metric
	 */
	public MetricDescription getMetric() {
		return metric;
	}
	
}
