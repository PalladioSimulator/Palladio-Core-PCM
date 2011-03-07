package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

import java.util.LinkedList;
import java.util.Vector;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

import de.uka.ipd.sdq.pipesandfilters.framework.MetaDataInit;
import de.uka.ipd.sdq.pipesandfilters.framework.PipeData;

/**
 * This recorder calculates the sliding mean, i.e. the average value of a
 * specified number of last result tuple element whenever a new pipe data
 * element is received.
 * 
 * @author Baum
 * 
 */
public class SlidingMeanRecorder extends AggregationRecorder {
	private LinkedList<PipeData> dataQueue = new LinkedList<PipeData>();
	private int dataQueueSize = 0;

	/**
	 * The constructor of SlidingMeanRecorder.
	 * 
	 * @param writeStrategy
	 *            The write strategy of the recorder.
	 * @param dataQueueSize
	 *            The window size of the sliding mean value, i.e. the number of
	 *            last incoming result tuples the mean is computed on.
	 */
	public SlidingMeanRecorder(IAggregationWriteStrategy writeStrategy,
			int dataQueueSize) {
		super(writeStrategy);
		this.dataQueueSize = dataQueueSize;
	}

	/**
	 * This method initializes the aggregation write strategy, providing it with
	 * all information that is necessary.
	 * 
	 * @param metaData
	 *            The meta data for the incoming result tuples.
	 */
	protected void initialize(MetaDataInit metaData) {

		writeStrategy.initialize(metaData);

		int aggregatedMetricIndex = metaData.getMeasuredMetrics().size() - 1;

		// Create initializing meta data for the aggregation to initialize the
		// aggregation write strategy.
		AggregationMetaDataInit aggregationMetaData = new AggregationMetaDataInit(
				aggregatedMetricIndex);
		aggregationMetaData.setAggregationFunctionName("Sliding Mean");
		aggregationMetaData
				.setAggregationFunctionDescription("Computes the average value of the last element of the result tuple at every processData step.");
		aggregationMetaData.setValid(false);

		((IAggregationWriteStrategy) writeStrategy)
				.initializeAggregatedMeasurements(aggregationMetaData);
	}

	/**
	 * This method calculates the sliding mean for each incoming data element
	 * with the specified window size.
	 * 
	 * @param data
	 *            The data to be processed.
	 */
	protected void processData(PipeData data) {
		// add element to data queue
		dataQueue.addLast(data);
		if (dataQueue.size() > dataQueueSize) {
			dataQueue.remove();
		}

		// Aggregation is always performed on the last result tuple element
		Measure<?, ? extends Quantity> measure = data.getTupleElement(data
				.getTupleSize() - 1);

		// Return value
		Measure<?, ? extends Quantity> resultMeasure = Measure.valueOf(0,
				measure.getUnit());

		if (measure.getValue() instanceof Long) {
			double value = 0;
			for (PipeData p : dataQueue) {
				value += (Long) p.getTupleElement(data.getTupleSize() - 1)
						.getValue();
			}
			resultMeasure = Measure.valueOf(value / dataQueue.size(), measure
					.getUnit());
		} else if (measure.getValue() instanceof Integer) {
			double value = 0;
			for (PipeData p : dataQueue) {
				value += (Integer) p.getTupleElement(data.getTupleSize() - 1)
						.getValue();
			}
			resultMeasure = Measure.valueOf(value / dataQueue.size(), measure
					.getUnit());
		} else if (measure.getValue() instanceof Double) {
			double value = 0;
			for (PipeData p : dataQueue) {
				value += (Double) p.getTupleElement(data.getTupleSize() - 1)
						.getValue();
			}
			resultMeasure = Measure.valueOf(value / dataQueue.size(), measure
					.getUnit());
		} else if (measure.getValue() instanceof Float) {
			double value = 0;
			for (PipeData p : dataQueue) {
				value += (Float) p.getTupleElement(data.getTupleSize() - 1)
						.getValue();
			}
			resultMeasure = Measure.valueOf(value / dataQueue.size(), measure
					.getUnit());
		}

		Vector<Measure<?, ? extends Quantity>> aggregatedTuple = new Vector<Measure<?, ? extends Quantity>>();
		aggregatedTuple.add(resultMeasure);
		PipeData aggregatedData = new PipeData(aggregatedTuple);

		writeStrategy.writeData(aggregatedData);
	}

	/**
	 * This method tells the write Strategy's flush method.
	 */
	protected void flush() {
		writeStrategy.flush();
	}
}
