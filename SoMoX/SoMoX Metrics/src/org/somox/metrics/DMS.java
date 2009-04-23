package org.somox.metrics;

import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;

public class DMS implements Metric {
	@Override
	public double compute (Root root, List<ModelElement> elements1, List<ModelElement> elements2) {
		Abstractness abstractness = new Abstractness();
		Instability instability = new Instability();
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
