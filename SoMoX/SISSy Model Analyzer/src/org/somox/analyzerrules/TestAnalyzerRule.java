package org.somox.analyzerrules;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Map;
import java.util.Properties;

import org.eclipse.core.runtime.FileLocator;
import org.eclipse.core.runtime.Path;
import org.eclipse.core.runtime.Platform;
import org.osgi.framework.Bundle;
import org.somox.metrics.Coupling;
import org.somox.metrics.DMS;
import org.somox.metrics.InterfaceViolation;
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
	
	
	public TestAnalyzerRule() {
		loadProperties();
	}
	
	/**
	 * Computes the overall metric score based on Landrys weighting functions
	 * 
	 * @param argAB The ID for every metric and its calculated score for the components A B
	 * @param argBA The ID for every metric and its calculated score for the components B A
	 * @return the overall score of the metric
	 */
	public double computeOverallMetricValue(Map<Integer, Double> argAB,
			Map<Integer, Double> argBA) {
		
		double nameResemblance = argAB.get((new NameResemblance()).getMID().getID());
		double subsystemComponent = argAB.get(new SubsystemComponent().getMID().getID());
		double packageMapping = argAB.get(new PackageMapping().getMID().getID());
		double dms = argAB.get(new DMS().getMID().getID());
		double slaq = argAB.get(new SliceLayerArchitectureQuality().getMID().getID());
		
		double couplingAB = argAB.get(new Coupling().getMID().getID());
		double couplingBA = argBA.get(new Coupling().getMID().getID());
		double coupling = Math.max(couplingAB, couplingBA);
		
		double interfaceViolationAB = argAB.get(new InterfaceViolation().getMID().getID());
		double interfaceViolationBA = argBA.get(new InterfaceViolation().getMID().getID());
		double interfaceViolation = Math.max(interfaceViolationAB, interfaceViolationBA);
		
		double w1=0, w2=0, w3=0;
		
		double w4 = Double.parseDouble(properties.getProperty("org.somox.packageMapping.weightPackageMapping"));
		double w5 = Double.parseDouble(properties.getProperty("org.somox.dms.weightDMS"));
		
		//determine weight of nameResemblance
		if (coupling < 0.2) {
			w1 = Double.parseDouble(properties.getProperty("org.somox.nameResemblance.weightLowCoupling"));
		} else if (coupling < 0.7) {
			w1 = Double.parseDouble(properties.getProperty("org.somox.nameResemblance.weightMidCoupling"));
		} else {
			if (nameResemblance < 0.5) {
				w1 = Double.parseDouble(properties.getProperty("org.somox.nameResemblance.weightLowNameResemblance"));
			} else if (nameResemblance < 0.7) {
				w1  = Double.parseDouble(properties.getProperty("org.somox.nameResemblance.weightMidNameResemblance"));
			} else if (nameResemblance < 0.9) {
				w1  = Double.parseDouble(properties.getProperty("org.somox.nameResemblance.weightHighNameResemblance"));
			} else {
				w1  = Double.parseDouble(properties.getProperty("org.somox.nameResemblance.weightHighestNameResemblance"));
			}
		}
		
		//determine weight of interfaceViolation
		if (coupling >=0.5 && interfaceViolation > 0.0) {
			w2  = Double.parseDouble(properties.getProperty("org.somox.interfaceViolation.weightInterfaceViolationRelevant"));
		} else {
			w2  = Double.parseDouble(properties.getProperty("org.somox.interfaceViolation.weightInterfaceViolationIrrelevant"));
		}
		
		//determine weight of subsystemComponent
		if (slaq >= 0.5) {
			w3 = Double.parseDouble(properties.getProperty("org.somox.subsystemComponent.weightHighSLAQ"));
		} else {
			w3 = Double.parseDouble(properties.getProperty("org.somox.subsystemComponent.weightLowSLAQ"));
		}
		
		//compute overall metric score
		double sum = w1+w2+w3+w4+w5;
		double score = nameResemblance*(double)w1 + interfaceViolation*(double)w2 
		               + subsystemComponent*(double)w3 + packageMapping*(double)w4 - dms*(double)w5;
		
		score = score/sum;
		
		return score;
	}

	private void loadProperties() {
		this.properties = new Properties();
	    Bundle bundle = Platform.getBundle("org.somox.analyzer.sissymodelanalyzer");
	    Path path = new Path(CONFIG_SIMPLE_ANALYZER_PROPERTIES_FILE);
	    URL fileURL = FileLocator.find(bundle, path, null);
	    
	
	    try {
	    	InputStream in = fileURL.openStream();
	        properties.load(in);
	    } catch (IOException e) {
	    	e.printStackTrace();
	    }
	}	
}
