package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

/**
 * Provides methods for writing aggregated measurements to any kind of storage.
 * 
 * @author pmerkle
 * @author Baum
 */
public interface IAggregationWriteStrategy extends IWriteStrategy {

	/**
	 * Initializes the aggregated measurements of an aggregation.
	 * 
	 * @param metaData
	 *            The initializing meta data.
	 */
	public void initializeAggregatedMeasurements(
			AggregationMetaDataInit metaData);

	/**
	 * Sets the meta data for fixed width aggregations.
	 * 
	 * @param aggregatedMeasurementsIndex
	 *            The index of the aggregated measurements.
	 * @param metaData
	 *            The meta data object.
	 */
	public void setFixedWidthAggregatedMeasurementsMetaData(
			int aggregatedMeasurementsIndex,
			FixedWidthAggregationMetaData metaData);
}
