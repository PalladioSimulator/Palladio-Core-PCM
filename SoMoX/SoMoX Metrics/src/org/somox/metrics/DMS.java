package org.somox.metrics;

import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

public class DMS implements Metric {
	protected Instability instability;
	protected Abstractness abstractness;
	
	
	/**
	 * Setter-method for a Instability-Object
	 * 
	 * This method is necessary, so that a blacklist can be added to the Instability-object
	 * 
	 * @param instability a Instability-object with set blacklist
	 */
	public void setInstability (Instability instability) {
		this.instability = instability;
	}

	@Override
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		if (abstractness == null) {
			abstractness = new Abstractness();
		}
		if (instability == null) {
			instability = new Instability();
		}
		
		double abs = abstractness.compute(root, elements1, elements2);
		double ins = instability.compute(root, elements1, elements2);
		
		double dms = Math.abs(abs + ins - 1.0);
		
		return dms;
	}
	
	@Override
	public ILaunchConfigurationTab getLaunchConfigurationTab() {
		// TODO Auto-generated method stub
		return null;
	}
}
