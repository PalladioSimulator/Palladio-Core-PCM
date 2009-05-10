package org.somox.metrics;

import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

/**
 * Interface modelling a Metric
 * 
 * @author Grischa Liebel
 *
 */
public interface Metric {
	
	/**
	 * Computes the Metric for a composite component
	 * 
	 * @param root Root-Object of the Software-Project modeled as GAST-model
	 * @param elements1 First part of the composite component
	 * @param elements2 Second part of the composite component
	 * @return the computed metric between 0.0 and 1.0
	 */
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2);
	
	public void initialize (Root root);
	
	/**
	 * Returns the GUI launch configuration tab that can be used to configure the metric
	 */
	public ILaunchConfigurationTab getLaunchConfigurationTab();
	
	/**
	 * Unique identifier for a metric (not an metric instance)
	 * @return the identifier
	 */
	public MetricID getMID();
	
}
