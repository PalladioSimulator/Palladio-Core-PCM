package org.somox.analyzerrules;

import java.util.Map;

import org.somox.metrics.MetricID;

public interface IAnalyzerRule {

	/**
	 * Computes the overall value of all metrics.
	 * Both metrics values (argA and argB) must refer to the same model elements. 
	 * @param argAB metrics result for A, B 
	 * @param argBA metrics result for B, A
	 * @return Overall value for multiple metrics, taking for example
	 * interdependencies into account.
	 */
	public double computeOverallMetricValue(Map<MetricID,Double> argAB, Map<MetricID,Double> argBA);
	
}
