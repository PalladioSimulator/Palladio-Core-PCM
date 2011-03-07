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

	/** A single measurement with a value for each dimension specified in the metric definition. */
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

	/**Set the value of the specified dimension.
	 * @param dimension Dimension of the metric.
	 * @param value The value to set.
	 */
	public void setMeasuredValue(int dimension, Object value) {
		assert(measuredValue != null);
		if (dimension < 0) {
			throw new IndexOutOfBoundsException("Dimension must be greater or equal to 0. It was " + dimension);
		}
		if (dimension >= measuredValue.length) {
			throw new IndexOutOfBoundsException("Dimension must be less than the number of dimensions in the specification. Number of existing dimensions is " + measuredValue.length + " requested dimension was " + dimension);
		}
		if (value == null) {
			throw new IllegalArgumentException("Provided value must not be null.");
		}
		if (validateData) {
			if (!MetricDescriptionUtility.isValidValue(descriptions[dimension], value)) {
				throw new IllegalArgumentException("Type of provided value was not valid. BaseMetricDescription is " + descriptions[dimension] + ", value was " + value);
			}
		}
		measuredValue[dimension] = value;
	}
	
	/**Returns the value of the specified dimension.
	 * @param dimension Dimension for which the value is requested.
	 * @return Measured value.
	 */
	public Object getMeasuredValue(int dimension) {
		assert(measuredValue != null);
		return measuredValue[dimension];
	}

	/**Returns if data is validated at the point it is stored for a dimension.
	 * @return the validateData
	 */
	public boolean isDataValidatedIfStored() {
		return validateData;
	}

	/**Sets it data is validated if the valued for a dimension is set.
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
