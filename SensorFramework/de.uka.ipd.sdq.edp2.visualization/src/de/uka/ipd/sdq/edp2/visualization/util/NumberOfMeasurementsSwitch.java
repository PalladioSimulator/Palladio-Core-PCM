package de.uka.ipd.sdq.edp2.visualization.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;

/**
 * Switch to retrieve the number of measurements contained in a
 * {@link RawMeasurements}-instance. It assumes that there exists at least one
 * {@link DataSeries} in the {@link RawMeasurements}.
 * 
 * @author Dominik Ernst
 * 
 */
public class NumberOfMeasurementsSwitch extends ExperimentDataSwitch<Integer> {

	/**
	 * Logger for this class.
	 */
	private final static Logger logger = Logger
			.getLogger(NumberOfMeasurementsSwitch.class.getSimpleName());

	private RawMeasurements rawMeasurements;

	public NumberOfMeasurementsSwitch(RawMeasurements rawMeasurements) {
		this.rawMeasurements = rawMeasurements;
	}

	@SuppressWarnings({ "unchecked" })
	public Integer caseNumericalBaseMetricDescription(
			NumericalBaseMetricDescription object) {
		OrdinalMeasurementsDao<?,? extends Quantity> dao = MeasurementsUtility
				.getOrdinalMeasurementsDao(rawMeasurements.getDataSeries().get(
						0));
		List<?> measures = dao.getMeasurements();
		return measures.size();
	}

	public Integer caseTextualBaseMetricDescription(
			TextualBaseMetricDescription object) {
		NominalMeasurementsDao dao = MeasurementsUtility
				.getNominalMeasurementsDao(rawMeasurements.getDataSeries().get(
						0));
		ObservedIdentifierBasedMeasurements mms = dao
				.getObservedIdentifierBasedMeasurements();
		List<ObservedIdentifier> obsId = mms.getObservedIdentifiers();
		return obsId.size();
	}

	public Integer caseBaseMetricDescription(BaseMetricDescription object) {
		logger.log(
				Level.SEVERE,
				"Unsupported Base Metric: the selected measurements could not be opened, because it is neither described by a TextualBaseMetricDescription nor a NumericalBaseMetricDescription.");
		throw new RuntimeException("Unsupported Base Metric.");
	}
}
