package org.somox.metrics;

import java.util.List;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

/**
 * DMS metric, calculated by using Abstractness and Instability
 * 
 * @author Grischa Liebel
 *
 */
public class DMS implements Metric {
	protected Instability instability;
	protected Abstractness abstractness;
	
	
	/**
	 * Setter-method for a Instability-Object
	 * 
	 * This method is necessary, so that a black- or whitelist can be added to the Instability-object
	 * 
	 * @param instability a Instability-object with set black- or whitelist
	 */
	public void setInstability (Instability instability) {
		this.instability = instability;
	}

	/**
	 * {@inheritDoc}
	 */
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		double abs = abstractness.compute(root, elements1, elements2);
		double ins = instability.compute(root, elements1, elements2);
		
		double dms = Math.abs(abs + ins - 1.0);
		
		return dms;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MetricTab getLaunchConfigurationTab() {
		return new DMSTab();
	}

	/**
	 * {@inheritDoc}
	 */
	public MetricID getMID() {
		return new MetricID(3);
	}

	/**
	 * {@inheritDoc}
	 */
	public void initialize(Root root) {
		abstractness = new Abstractness();
		instability = new Instability();
	}
}
