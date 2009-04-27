package org.somox.analyzerrules;

import java.util.Map;

import org.somox.metrics.Abstractness;
import org.somox.metrics.Coupling;
import org.somox.metrics.MetricID;
import org.somox.metrics.NameResemblance;

/**
 * Requires the following metrics: Abstrectnees, Coupling, and NameResemblance
 * @author kelsaka
 *
 */
public class TestAnalyzerRule implements IAnalyzerRule {

	@Override
	public double computeOverallMetricValue(Map<MetricID, Double> argAB,
			Map<MetricID, Double> argBA) {
		
		double abstractness = argAB.get(new Abstractness().getMID());
		double coupling = argAB.get(new Coupling().getMID());
		double nameResemblance = argAB.get(new NameResemblance().getMID());
		
		if(abstractness > coupling) {
			if(abstractness < nameResemblance) {
				return abstractness * nameResemblance;
			}
			return 0.9;
		} else {
			return 0.2;
		}
	}
	

	
}
