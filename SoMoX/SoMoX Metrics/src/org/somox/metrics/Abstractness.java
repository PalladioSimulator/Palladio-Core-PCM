package org.somox.metrics;

import java.util.List;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;
import de.fzi.gast.types.GASTClass;

/**
 * Abstractness metric
 * 
 * @author Grischa Liebel
 *
 */
public class Abstractness implements Metric {
	
	/**
	 * {@inheritDoc}
	 */
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		double abstractness = 0.0;
		double abstractClasses = 0.0;
		double totalClasses = 0.0;

		for (ModelElement current : elements1) {
			if (current instanceof GASTClass) {
				if (((GASTClass) current).isAbstract()) {
					abstractClasses += 1.0;
				}
				totalClasses += 1.0;
			}
		}
		
		for (ModelElement current : elements2) {
			if (current instanceof GASTClass) {
				if (((GASTClass) current).isAbstract()) {
					abstractClasses += 1.0;
				}
				totalClasses += 1.0;
			}
		}
		
		abstractness = abstractClasses/totalClasses;

		return abstractness;
	}
	
	/**
	 * {@inheritDoc}
	 */
	public MetricTab getLaunchConfigurationTab() {
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	public MetricID getMID() {
		return new MetricID(234);
	}

	/**
	 * {@inheritDoc}
	 */
	public void initialize(Root root) {
	}
}