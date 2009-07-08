package org.somox.metrics;

import java.util.List;
import java.util.Set;

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
	
	public DMS () {
		abstractness = new Abstractness();
		instability = new Instability();
	}
	
	/**
	 * Delegate for the setBlacklist method in Instability
	 */
	public void setBlacklist (Set<String> blacklist) {
		instability.setBlacklist(blacklist);
	}
	
	/**
	 * Delegate for the setBlacklistIndicator method in Instability
	 */
	public void setBlacklistIndicator (boolean blacklistIndicator) {
		instability.setBlacklistIndicator(blacklistIndicator);
	}
	
	/**
	 * Delegate for the setWhitelist method in Instability
	 */
	public void setWhitelist (Set<String> whitelist) {
		instability.setWhitelist(whitelist);
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
	}
}
