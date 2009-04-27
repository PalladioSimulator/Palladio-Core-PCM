package org.somox.analyzerrules;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

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
	
	private static final String CONFIG_SIMPLE_ANALYZER_PROPERTIES_FILE = "config/SimpleAnalyzer.properties";
	private Properties properties;

	public double computeOverallMetricValue(Map<MetricID, Double> argAB,
			Map<MetricID, Double> argBA) {
		loadProperties();
		
		double abstractness = argAB.get(new Abstractness().getMID());
		double abstractnessWeight = Double.parseDouble(properties.getProperty("org.somox.abstractness.weight"));
		
		double coupling = argAB.get(new Coupling().getMID());
		double couplingWeight = Double.parseDouble(properties.getProperty("org.somox.coupling.weight"));
		
		double nameResemblance = argAB.get(new NameResemblance().getMID());
		double nameResemblanceWeight = Double.parseDouble(properties.getProperty("org.somox.nameResemblance.weight"));		
		
		if(abstractness > coupling) {
			if(abstractness < nameResemblance) {
				return abstractness * abstractnessWeight * nameResemblance + nameResemblanceWeight;
			}
			return 0.9 * couplingWeight;
		} else {
			return 0.2;
		}
	}

	private void loadProperties() {
	    this.properties = new Properties();
	
	    try {
	        properties.load(new FileInputStream(CONFIG_SIMPLE_ANALYZER_PROPERTIES_FILE));
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}
	
}
