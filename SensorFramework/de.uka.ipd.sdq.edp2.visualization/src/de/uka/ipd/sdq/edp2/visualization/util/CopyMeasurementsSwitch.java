package de.uka.ipd.sdq.edp2.visualization.util;

import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.edp2.NominalMeasurementsDao;
import de.uka.ipd.sdq.edp2.OrdinalMeasurementsDao;
import de.uka.ipd.sdq.edp2.impl.Measurement;
import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifier;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ObservedIdentifierBasedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.RawMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch;

/**
 * Class for copying single values of data contained in {@link RawMeasurements}.
 * Works for data described by:
 * <ul>
 * <li>{@link NumericalBaseMetricDescription}</li>
 * <li>{@link TextualBaseMetricDescription}</li>
 * </ul>
 * @author Dominik Ernst
 *
 */
public class CopyMeasurementsSwitch extends ExperimentDataSwitch<Boolean> {

	/**
	 * Logger for this class
	 */
	private final static Logger logger = Logger
			.getLogger(CopyMeasurementsSwitch.class.getSimpleName());
	
	/**
	 * The {@link RawMeasurements} containing the original data, which are to be copied.
	 */
	private RawMeasurements rawMeasurementsToCopy;
	/**
	 * The index of the item in the data series to be copied.
	 */
	private int index;
	/**
	 * The dimension, i.e. the index of the data series to be copied.
	 */
	private int dimension;
	/**
	 * The {@link Measurement} to which the value is copied.
	 */
	private Measurement measurement;

	public CopyMeasurementsSwitch(RawMeasurements rawMeasurementsToCopy,
			int index, int dimension, Measurement measurement) {
		this.rawMeasurementsToCopy = rawMeasurementsToCopy;
		this.index = index;
		this.dimension = dimension;
		this.measurement = measurement;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch#caseNumericalBaseMetricDescription(de.uka.ipd.sdq.edp2.models.ExperimentData.NumericalBaseMetricDescription)
	 */
	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Boolean caseNumericalBaseMetricDescription(
			NumericalBaseMetricDescription object) {
		OrdinalMeasurementsDao<?,? extends Quantity> dao = MeasurementsUtility
				.getOrdinalMeasurementsDao(rawMeasurementsToCopy
						.getDataSeries().get(dimension));
		List<?> measures = dao.getMeasurements();
		Measure measure = (Measure) measures.get(index);
		measurement.setMeasuredValue(dimension, measure);
		return true;
	}

	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch#caseTextualBaseMetricDescription(de.uka.ipd.sdq.edp2.models.ExperimentData.TextualBaseMetricDescription)
	 */
	public Boolean caseTextualBaseMetricDescription(
			TextualBaseMetricDescription object) {
		NominalMeasurementsDao dao = MeasurementsUtility
				.getNominalMeasurementsDao(rawMeasurementsToCopy
						.getDataSeries().get(dimension));
		ObservedIdentifierBasedMeasurements mms = dao
				.getObservedIdentifierBasedMeasurements();
		List<ObservedIdentifier> obsId = mms.getObservedIdentifiers();
		measurement.setMeasuredValue(dimension, obsId.get(index)
				.getIdentifier());
		return true;
	}
	
	/*
	 * (non-Javadoc)
	 * @see de.uka.ipd.sdq.edp2.models.ExperimentData.util.ExperimentDataSwitch#caseBaseMetricDescription(de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription)
	 */
	public Boolean caseBaseMetricDescription(BaseMetricDescription object) {
		logger.log(
				Level.SEVERE,
				"Unsupported Base Metric: the selected measurements could not be opened, because it is neither described by a TextualBaseMetricDescription nor a NumericalBaseMetricDescription.");
		throw new RuntimeException("Unsupported Base Metric.");
	}

}
