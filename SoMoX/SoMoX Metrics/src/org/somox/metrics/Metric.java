package org.somox.metrics;

import java.util.List;

import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

/**
 * Interface modelling a Metric
 * 
 * @author Grischa Liebel
 *
 */
public interface Metric {
	//TODO Test for innerclasses where necessary (currently not possible, method doesn't work)
	
	/**
	 * Computes the Metric for a composite component
	 * 
	 * @param root Root-Object of the Software-Project modeled as GAST-model
	 * @param elements1 First part of the composite component
	 * @param elements2 Second part of the composite component
	 * @return the computed metric between 0.0 and 1.0
	 */
	public double compute (Root root, List<GASTClass> elements1, List<GASTClass> elements2);
	
	/**
	 * Initializes the Metric. Must be called before metrics are computed.
	 * Should be called again, if the model changed
	 * 
	 * @param root The Root object of the GAST model
	 */
	public void initialize (Root root);
	
	/**
	 * Returns the GUI launch configuration tab that can be used to configure the metric
	 */
	public MetricTab getLaunchConfigurationTab();
	
	/**
	 * Unique identifier for a metric (not an metric instance)
	 * @return the identifier
	 */
	public MetricID getMID();
	
}
