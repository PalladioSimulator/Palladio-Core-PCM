package org.somox.metrics;

import java.util.List;

import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.fzi.gast.core.ModelElement;
import de.fzi.gast.core.Root;


public class InterfaceViolation implements Metric {

	@Override
	public double compute(Root root, List<ModelElement> elements1,
			List<ModelElement> elements2) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public ILaunchConfigurationTab getLaunchConfigurationTab() {
		// TODO Auto-generated method stub
		return null;
	}

}
