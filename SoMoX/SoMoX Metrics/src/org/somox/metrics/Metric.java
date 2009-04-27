package org.somox.metrics;

import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

public interface Metric {
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2);
	
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
