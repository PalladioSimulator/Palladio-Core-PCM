/**
 * 
 */
package de.uka.ipd.sdq.edp2.impl;

import javax.measure.Measure;

import de.uka.ipd.sdq.edp2.internal.BaseMetricFromMetricSwitch;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NominalMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.Scale;

/**Utility class to handle MetricDescription(s).
 * 
 * @author groenda
 */
public class MetricDescriptionUtility {

	/**Returns all base metric descriptions in the order they are specified in a metric description.
	 * @param description The description which is processed.
	 * @return Ordered array of base metrics.
	 */
	static BaseMetricDescription[] toBaseMetricDescriptions(MetricDescription description) {
		return new BaseMetricFromMetricSwitch().doSwitch(description);
	}
	
	/**Checks if a provided object is valid according to the specified metric.
	 * @param description The description to use for the validation.
	 * @param value The value to check.
	 * @return <code>true</code> if the object has a valid type, <code>false</code> otherwise.
	 */
	@SuppressWarnings("unchecked")
	static boolean isValidValue(BaseMetricDescription description, Object value) {
		if (description.getScale() == Scale.NOMINAL) {
			if (value instanceof NominalMeasurements) {
				return true;
			} else {
				return false;
			}
		} else { // Scale.{Ordinal|Interval|Ratio}
			if (value instanceof Measure) {
				return true;
			} else {
				return false;
			}
		}
	}
}
