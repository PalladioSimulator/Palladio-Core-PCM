package de.uka.ipd.sdq.pipesandfilters.framework.recorder.edp2;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import javax.measure.Measure;
import javax.measure.unit.SI;

import de.uka.ipd.sdq.edp2.impl.MeasurementsUtility;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregatedMeasurements;
import de.uka.ipd.sdq.edp2.models.ExperimentData.AggregationFunctionDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.BaseMetricDescription;
import de.uka.ipd.sdq.edp2.models.ExperimentData.DataSeries;
import de.uka.ipd.sdq.edp2.models.ExperimentData.ExperimentDataFactory;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedIntervals;
import de.uka.ipd.sdq.edp2.models.ExperimentData.FixedWidthAggregatedMeasurements;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.AggregationMetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.FixedWidthAggregationMetaData;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.IAggregationWriteStrategy;

/**
 * This class provides methods necessary to write aggregated measurements to the
 * EDP2.
 * 
 * @author Baum
 * 
 */
public class Edp2AggregationWriteStrategy extends Edp2WriteStrategy implements
		IAggregationWriteStrategy {
	/**
	 * In this method an EDP2 experiment run is prepared by initializing all
	 * necessary EDP2 members.
	 */
	protected void prepareExperimentRun() {
		experimentRun.getMeasurement().add(measurement);
		experimentSetting.getExperimentRuns().add(experimentRun);

		measurementRange = MeasurementsUtility.addMeasurementRange(measurement);
	}

	/**
	 * Initializes the aggregated measurements of the write strategy.
	 * 
	 * @param metaData
	 *            The initializing meta data.
	 */
	public void initializeAggregatedMeasurements(
			AggregationMetaDataInit metaData) {

		FixedWidthAggregatedMeasurements aggregatedMeasurements = ExperimentDataFactory.eINSTANCE
				.createFixedWidthAggregatedMeasurements();

		// Set metric
		aggregatedMeasurements.setMetric(metric);

		// Set aggregated metric
		aggregatedMeasurements.setAggregationOn((BaseMetricDescription) metric
				.getSubsumedMetrics().get(metaData.getAggregatedMetricIndex()));

		// Set aggregation function description
		AggregationFunctionDescription desc = ExperimentDataFactory.eINSTANCE
				.createAggregationFunctionDescription();
		desc.setName(metaData.getAggregationFunctionName());
		desc
				.setTextualDescription(metaData
						.getAggregationFunctionDescription());
		aggregatedMeasurements.setFunction(desc);

		measurementRange.getAggregatedMeasurements()
				.add(aggregatedMeasurements);
		//TODO: add aggregated measurements properly. 
		/*MeasurementsUtility.addDataSeries(aggregatedMeasurements,
				aggregatedMeasurements.getFunction());*/
		throw new UnsupportedOperationException("Aggregated Measurements " +
				"are not yet supported by EDP2. Fix the "
				+this.getClass().getName()+"'s initializeAggregatedMeasurements()" +
				" method when EDP2 has been adjusted.");
	}

	/**
	 * Sets the fixed width aggregated measurements meta data for the
	 * AggregatedMeasurements object at the specified index
	 * (AggregatedMeasurements are ordered ascending in time they were
	 * initialized at).
	 * 
	 * @param aggregatedMeasurementsIndex
	 *            Index of the AggregateMeasurements object.
	 * @param metaData
	 *            The fixed width aggregated measurements meta data.
	 */
	public void setFixedWidthAggregatedMeasurementsMetaData(
			int aggregatedMeasurementsIndex,
			FixedWidthAggregationMetaData metaData) {

		FixedIntervals intervals = ExperimentDataFactory.eINSTANCE
				.createFixedIntervals();
		intervals.setLowerBound(metaData.getLowerBound());
		intervals.setWidth(metaData.getWidth());
		intervals.setNumberOfIntervals(metaData.getNumberOfIntervals());

		((FixedWidthAggregatedMeasurements) measurementRange
				.getAggregatedMeasurements().get(aggregatedMeasurementsIndex))
				.setIntervals(intervals);
	}

	/**
	 * This method will end the current experiment and close the data output
	 * stream.
	 */
	public void flush() {

		long startTime = experimentRun.getStartTime().getTime();
		long endTime = new Date().getTime();
		experimentRun.setDuration(Measure.valueOf(endTime - startTime,
				SI.SECOND));
		measurementRange.setStartTime(Measure.valueOf(startTime, SI.SECOND));
		measurementRange.setEndTime(Measure.valueOf(endTime, SI.SECOND));

		for (AggregatedMeasurements measurements : measurementRange
				.getAggregatedMeasurements()) {
			FixedWidthAggregatedMeasurements fixedMeas = ((FixedWidthAggregatedMeasurements) measurements);

/*	Now superfluous?
 * 			for (DataSeries ds : fixedMeas.getDataSeries()) {
				try {
					if (StorageFactory.INSTANCE.getDaoRegistry().getEdp2Dao(
							ds.getValuesUuid()).isOpen())
						StorageFactory.INSTANCE.getDaoRegistry().getEdp2Dao(
								ds.getValuesUuid()).close();
				} catch (DataNotAccessibleException e) {
					e.printStackTrace();
				}
			}*/
		}
	}
}
