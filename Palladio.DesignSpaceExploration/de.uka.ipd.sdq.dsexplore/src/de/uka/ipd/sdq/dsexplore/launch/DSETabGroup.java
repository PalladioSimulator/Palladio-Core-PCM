package de.uka.ipd.sdq.dsexplore.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.codegen.runconfig.tabs.FeatureOptionsTab;
import de.uka.ipd.sdq.codegen.runconfig.tabs.FileNamesInputTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComConfigurationTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuConfigurationTab;

/**
 * Creates a Tab Group for the launch configuration.
 * @author Anne
 *
 */
public class DSETabGroup extends AbstractLaunchConfigurationTabGroup {

	/**
	 * Actually creates the tabs.
	 * @param dialog not needed
	 * @param mode not needed
	 */
	@Override
	public void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new FileNamesInputTab(), // Default tab
				
				//TODO: Get these depending on available plugins / availaible analyses
				new SimuComConfigurationTab(),
				new SimuConfigurationTab(),
				new FeatureOptionsTab(),
				new DSEOptionsTab()
		};
		setTabs(tabs);

	}

}
