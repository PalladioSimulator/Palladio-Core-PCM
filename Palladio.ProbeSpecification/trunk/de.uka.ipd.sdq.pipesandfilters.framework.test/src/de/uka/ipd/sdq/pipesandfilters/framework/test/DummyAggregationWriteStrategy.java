package de.uka.ipd.sdq.pipesandfilters.framework.test;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.AggregationMetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.FixedWidthAggregationMetaData;
import de.uka.ipd.sdq.pipesandfilters.framework.recorder.IAggregationWriteStrategy;

/**
 * This dummy class is supposed to be used in test cases in order to test raw
 * recorders to avoid data storage every time the test case is performed.
 * 
 * @author Baum
 */
public class DummyAggregationWriteStrategy implements IAggregationWriteStrategy {

	private MetaDataInit lastArrivedMetaDataInit;
	private PipeData lastArrivedPipeData;
	private AggregationMetaDataInit lastArrivedAggregationMetaDataInit;
	private FixedWidthAggregationMetaData lastArrivedFixedWidthAggregationMetaData;

	@Override
	public void initializeAggregatedMeasurements(
			AggregationMetaDataInit metaData) {
	}

	@Override
	public void setFixedWidthAggregatedMeasurementsMetaData(
			int aggregatedMeasurementsIndex,
			FixedWidthAggregationMetaData metaData) {
	}

	@Override
	public void flush() {
	}

	@Override
	public void initialize(MetaDataInit metaData) {
		lastArrivedMetaDataInit = metaData;
	}

	@Override
	public void writeData(PipeData data) {
		lastArrivedPipeData = data;
	}

	/**
	 * Returns the last MetaDataInit object that has arrived. Supposed to be
	 * used for test cases only.
	 * 
	 * @return The last MetaDataInit object that has arrived.
	 */
	public MetaDataInit getLastArrivedMetaDataInit() {
		return lastArrivedMetaDataInit;
	}

	/**
	 * Returns the last PipeData object that has arrived. Supposed to be used
	 * for test cases only.
	 * 
	 * @return The last PipeData object that has arrived.
	 */
	public PipeData getLastArrivedPipeData() {
		return lastArrivedPipeData;
	}
	
	/**
	 * Returns the last AggregationMetaDataInit object that has arrived. Supposed to be
	 * used for test cases only.
	 * 
	 * @return The last AggregationMetaDataInit object that has arrived.
	 */
	public AggregationMetaDataInit getLastArrivedAggregationMetaDataInit() {
		return lastArrivedAggregationMetaDataInit;
	}

	/**
	 * Returns the last FixedWidthAggregationMetaData object that has arrived. Supposed to be
	 * used for test cases only.
	 * 
	 * @return The last FixedWidthAggregationMetaData object that has arrived.
	 */
	public FixedWidthAggregationMetaData getLastArrivedFixedWidthAggregationMetaData() {
		return lastArrivedFixedWidthAggregationMetaData;
	}

}
