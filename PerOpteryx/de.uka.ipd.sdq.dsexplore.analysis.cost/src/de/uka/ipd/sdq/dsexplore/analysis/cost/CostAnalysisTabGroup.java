package de.uka.ipd.sdq.dsexplore.analysis.cost;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class CostAnalysisTabGroup extends AbstractLaunchConfigurationTabGroup {

	public CostAnalysisTabGroup() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new CostAnalysisTab()
			};
			setTabs(tabs);
		
	}

	

}
