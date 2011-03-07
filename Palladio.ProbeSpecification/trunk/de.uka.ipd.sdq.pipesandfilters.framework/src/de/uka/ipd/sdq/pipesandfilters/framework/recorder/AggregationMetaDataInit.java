package de.uka.ipd.sdq.pipesandfilters.framework.recorder;

/**
 * This class holds meta data that an aggregation recorder should use to provide
 * it's write strategy with initializing meta information.
 * 
 * @author Baum
 * 
 */
public class AggregationMetaDataInit {

	private int aggregatedMetricIndex;
	private boolean isValid;
	private String aggregationFunctionName;
	private String aggregationFunctionDescription;

	/**
	 * The constructor of AggregatiomMetaDataInit
	 * 
	 * @param aggregatedMetricIndex
	 *            The index of the metric that the aggregation is performed on
	 *            in the measurement metric vector.
	 * 
	 */
	public AggregationMetaDataInit(int aggregatedMetricIndex) {
		this.aggregatedMetricIndex = aggregatedMetricIndex;
	}

	/**
	 * Returns the index of the aggregated metric in the measurement metric
	 * vector.
	 * 
	 * @return The index of the aggregated metric in the measurement metric.
	 */
	public int getAggregatedMetricIndex() {
		return aggregatedMetricIndex;
	}

	/**
	 * Returns whether the aggregation is valid, i.e. consistent with raw
	 * measurements.
	 * 
	 * @return A boolean value indicating whether the aggregation is valid.
	 */
	public boolean isValid() {
		return isValid;
	}

	/**
	 * Sets whether the aggregation is valid, i.e. consistent with raw
	 * measurements.
	 * 
	 * @param isValid
	 *            A boolean value indicating whether the aggregation is valid.
	 */
	public void setValid(boolean isValid) {
		this.isValid = isValid;
	}

	/**
	 * Returns the name of the aggregation function.
	 * 
	 * @return The name of the aggregation function.
	 */
	public String getAggregationFunctionName() {
		return aggregationFunctionName;
	}

	/**
	 * Sets the name of the aggregation function.
	 * 
	 * @param aggregationFunctionName
	 *            The name of the aggregation function.
	 */
	public void setAggregationFunctionName(String aggregationFunctionName) {
		this.aggregationFunctionName = aggregationFunctionName;
	}

	/**
	 * Returns the description of the aggregation function.
	 * 
	 * @param aggregationFunctionName
	 *            The description of the aggregation function.
	 */
	public String getAggregationFunctionDescription() {
		return aggregationFunctionDescription;
	}

	/**
	 * Sets the description of the aggregation function.
	 * 
	 * @param aggregationFunctionDescription
	 *            The description of the aggregation function.
	 */
	public void setAggregationFunctionDescription(
			String aggregationFunctionDescription) {
		this.aggregationFunctionDescription = aggregationFunctionDescription;
	}
}
