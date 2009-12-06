package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.CommonTab;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.cip.launchconfig.CompletionTab;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab;

/**
 * The class defines tabs for the SimuBench Launch configuration menu.
 * 
 * @author Roman Andrej
 */
public class SimuTabGroup extends AbstractLaunchConfigurationTabGroup {

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog, java.lang.String)
	 */
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
        ILaunchConfigurationTab commonTab = new DebugEnabledCommonTab();
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new FileNamesInputTab(), // Default tab
				new SimuComConfigurationTab(),
				new SimuConfigurationTab(),
				new FeatureOptionsTab(),
				new CompletionTab(),
				commonTab
		};
		setTabs(tabs);
	}
}
