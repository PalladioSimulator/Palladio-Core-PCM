package de.uka.ipd.sdq.dsexplore.analysis.reliability.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.pcmsolver.runconfig.OptionsTab;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab;

/**
 * Provides a configuration tab group for the reliability Solver analysis method.
 * 
 * @author anne
 *
 */
public class ReliabilityAnalysisTabGroup extends AbstractLaunchConfigurationTabGroup {

	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new OptionsTab()
		};
		setTabs(tabs);
		
	}
	


}
