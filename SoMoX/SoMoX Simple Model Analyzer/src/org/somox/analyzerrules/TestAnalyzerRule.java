package org.somox.analyzerrules;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Map;
import java.util.Properties;

import org.somox.metrics.Abstractness;
import org.somox.metrics.Coupling;
import org.somox.metrics.DMS;
import org.somox.metrics.InterfaceViolation;
import org.somox.metrics.MetricID;
import org.somox.metrics.NameResemblance;
import org.somox.metrics.PackageMapping;
import org.somox.metrics.SliceLayerArchitectureQuality;
import org.somox.metrics.SubsystemComponent;

/**
 * Requires the following metrics: Abstractness, Coupling, and NameResemblance
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
	
	/**
	 * Computes the overall metric score based on Landrys weighting functions
	 * 
	 * @param argAB The ID for every metric and its calculated score for the components A B
	 * @param argBA The ID for every metric and its calculated score for the components B A
	 * @return the overall score of the metric
	 */
	public double computeOverallMetricValueLandry(Map<MetricID, Double> argAB,
			Map<MetricID, Double> argBA) {
		
		double nameResemblance = argAB.get(new NameResemblance().getMID());
		double subsystemComponent = argAB.get(new SubsystemComponent().getMID());
		double packageMapping = argAB.get(new PackageMapping().getMID());
		double dms = argAB.get(new DMS().getMID());
		double slaq = argAB.get(new SliceLayerArchitectureQuality().getMID());
		
		double couplingAB = argAB.get(new Coupling().getMID());
		double couplingBA = argBA.get(new Coupling().getMID());
		double coupling = Math.max(couplingAB, couplingBA);
		
		double interfaceViolationAB = argAB.get(new InterfaceViolation().getMID());
		double interfaceViolationBA = argBA.get(new InterfaceViolation().getMID());
		double interfaceViolation = Math.max(interfaceViolationAB, interfaceViolationBA);
		
		int w1=0, w2=0, w3=0, w4=60, w5=7;
		
		//determine weight of nameResemblance
		if (coupling < 0.2) {
			w1 = 0;
		} else if (coupling < 0.7) {
			w1 = 10;
		} else {
			if (nameResemblance < 0.5) {
				w1 = 15;
			} else if (nameResemblance < 0.7) {
				w1 = 25;
			} else if (nameResemblance < 0.9) {
				w1 = 40;
			} else {
				w1 = 90;
			}
		}
		
		//determine weight of interfaceViolation
		if (coupling >=0.5 && interfaceViolation > 0.0) {
			w2 = 60;
		} else {
			w2 = 0;
		}
		
		//determine weight of subsystemComponent
		if (slaq >= 0.5) {
			w3 = 25;
		} else {
			w3 = 0;
		}
		
		//determine weight of subsystemComponent
		if (slaq >= 0.5) {
			w3 = 25;
		} else {
			w3 = 0;
		}
		
		//compute overall metric score
		double sum = nameResemblance + interfaceViolation + subsystemComponent
		             + packageMapping + dms;
		double score = nameResemblance*(double)w1 + interfaceViolation*(double)w2 
		               + subsystemComponent*(double)w3 + packageMapping*(double)w4 - dms*(double)w5;
		
		score = score/sum;
		
		return score;
	}
	
}
