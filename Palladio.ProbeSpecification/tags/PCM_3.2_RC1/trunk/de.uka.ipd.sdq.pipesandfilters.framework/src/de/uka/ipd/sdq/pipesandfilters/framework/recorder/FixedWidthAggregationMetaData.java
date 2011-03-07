package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

import javax.measure.Measure;
import javax.measure.quantity.Quantity;

/**
 * This class holds meta information for fixed width aggregations.
 * 
 * @author Baum
 * 
 */
public class FixedWidthAggregationMetaData {
	private Measure<?, ? extends Quantity> lowerBound;
	private Measure<?, ? extends Quantity> width;
	private long numberOfIntervals;

	/**
	 * The constructor of FixedWidthAggregationMetaData
	 * 
	 * @param lowerBound
	 *            The lower bound of the aggregation.
	 * @param width
	 *            The width of an interval.
	 * @param numberOfIntervals
	 *            The number of intervals.
	 */
	public FixedWidthAggregationMetaData(
			Measure<?, ? extends Quantity> lowerBound,
			Measure<?, ? extends Quantity> width, long numberOfIntervals) {
		this.lowerBound = lowerBound;
		this.width = width;
		this.numberOfIntervals = numberOfIntervals;
	}

	/**
	 * Returns the lower bound of the aggregation.
	 * 
	 * @return The lower bound of the aggregation.
	 */
	public Measure<?, ? extends Quantity> getLowerBound() {
		return lowerBound;
	}

	/**
	 * Returns the width of an aggregation interval.
	 * 
	 * @return The width of an aggregation interval.
	 */
	public Measure<?, ? extends Quantity> getWidth() {
		return width;
	}

	/**
	 * Returns the number of intervals.
	 * 
	 * @return The number of intervals.
	 */
	public long getNumberOfIntervals() {
		return numberOfIntervals;
	}
}
