package de.uka.ipd.sdq.pipesandfilters.framework.recorder.launch;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

public class RecorderTabGroup extends AbstractLaunchConfigurationTabGroup {

	@Override
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = null;
		try {
			tabs = RecorderExtensionHelper.getLaunchConfigTabs();
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		setTabs(tabs);
	}

}
