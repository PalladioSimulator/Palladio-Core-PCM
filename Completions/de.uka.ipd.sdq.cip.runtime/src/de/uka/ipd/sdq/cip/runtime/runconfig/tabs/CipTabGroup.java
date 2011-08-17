package de.uka.ipd.sdq.cip.runtime.runconfig.tabs;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;

public class CipTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab commonTab = new DebugEnabledCommonTab();
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new CipModelTab(),
				new CipCompletionTab(),
				new CipConfigTab(),
				commonTab
		};
		setTabs(tabs);

	}

}
