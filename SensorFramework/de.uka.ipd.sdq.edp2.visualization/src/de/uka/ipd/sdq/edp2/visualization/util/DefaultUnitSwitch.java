package de.uka.ipd.sdq.edp2.visualization.util;

import java.util.logging.Level;
import java.util.logging.Logger;

import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.MetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;

public class DefaultUnitSwitch extends ExperimentDataSwitch<String> {
	
	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(DefaultUnitSwitch.class.getSimpleName());
	
	private MetricDescription metric;

	public DefaultUnitSwitch(MetricDescription metric) {
		this.metric = metric;
	}
	
	public String caseNumericalBaseMetricDescription(
			NumericalBaseMetricDescription object) {
		return ((NumericalBaseMetricDescription)metric).getDefaultUnit().toString();
	}

	public String caseTextualBaseMetricDescription(
			TextualBaseMetricDescription object) {
		return ((TextualBaseMetricDescription)metric).getIdentifiers().get(0).toString();
	}

	public String caseBaseMetricDescription(BaseMetricDescription object) {
		logger.log(
				Level.SEVERE,
				"Unsupported Base Metric: the selected measurements could not be opened, because it is neither described by a TextualBaseMetricDescription nor a NumericalBaseMetricDescription.");
		throw new RuntimeException("Unsupported Base Metric.");
	}
}
