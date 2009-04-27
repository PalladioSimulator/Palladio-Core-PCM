package org.somox.analyzerrules;

import java.util.Map;

import org.somox.metrics.Abstractness;
import org.somox.metrics.Coupling;
import org.somox.metrics.MetricID;
import org.somox.metrics.NameResemblance;

public class TestAnalyzerRule implements IAnalyzerRule {

	@Override
	public double computeOverallMetricValue(Map<MetricID, Double> argAB,
			Map<MetricID, Double> argBA) {
		
		if(argAB.get(new Abstractness().getMID()) > argAB.get(new Coupling().getMID())) {
			if(argAB.get(new Abstractness().getMID()) < argAB.get(new NameResemblance().getMID())) {
				return argAB.get(new Abstractness().getMID()) * argAB.get(new NameResemblance().getMID());
			}
			return 0.9;
		} else {
			return 0.2;
		}
	}
	

	
}
