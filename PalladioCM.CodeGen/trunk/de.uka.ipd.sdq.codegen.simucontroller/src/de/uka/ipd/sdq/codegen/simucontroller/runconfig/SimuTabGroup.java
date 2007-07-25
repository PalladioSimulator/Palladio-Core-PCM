package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.codegen.runconfig.tabs.*;

/** @author roman */
public class SimuTabGroup extends AbstractLaunchConfigurationTabGroup {

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog, java.lang.String)
	 */
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new FileNamesInputTab(), // Default tab
				new SimuComConfigurationTab(),
				new SimuConfigurationTab(),
				new FeatureOptionsTab()
		};
		setTabs(tabs);
	}

}
