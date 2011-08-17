/**
 * 
 */
package de.uka.ipd.sdq.edp2.internal;

import java.util.Vector;

import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricSetDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;

/**
 * Switch to resolve all base metrics in the order they are specified in a
 * metric description.
 * 
 * @author groenda
 */
public class BaseMetricFromMetricSwitch extends
		ExperimentDataSwitch<BaseMetricDescription[]> {

	@Override
	public BaseMetricDescription[] caseBaseMetricDescription(
			BaseMetricDescription object) {
		BaseMetricDescription[] descriptions = new BaseMetricDescription[1];
		descriptions[0] = object;
		return descriptions;
	}

	@Override
	public BaseMetricDescription[] caseMetricSetDescription(
			MetricSetDescription object) {
		Vector<BaseMetricDescription> descriptions = new Vector<BaseMetricDescription>();
		for (MetricDescription description : object.getSubsumedMetrics()) {
			BaseMetricDescription[] baseDescriptions = new BaseMetricFromMetricSwitch()
					.doSwitch(description);
			for (BaseMetricDescription baseDescription : baseDescriptions) {
				descriptions.add(baseDescription);
			}
		}
		return descriptions.toArray(new BaseMetricDescription[0]);
	}
}
