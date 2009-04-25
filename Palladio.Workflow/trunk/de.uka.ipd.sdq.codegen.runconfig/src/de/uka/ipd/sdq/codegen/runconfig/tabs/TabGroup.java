package de.uka.ipd.sdq.codegen.runconfig.tabs;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;


/**
 * The main job of a tab group is to specify the tabs that will appear in the
 * LaunchConfigurationDelegate and set their order. These tabs may have been
 * specially written for the particular config type in question, or they may be
 * general purpose tabs that appear for multiple config types. The tab group for
 * our applet launcher creates 3 tabs:
 * 
 * FileNamesInputTab - is responsible for the input of an instance Palladio
 * 							Component Model. 
 * ConfigurationTab - here is made the minimum configuration
 * 							input for oAW the generator. 
 * FeatureOptionsTab - here are set specific
 * 							characteristics for the simulation.
 * 
 * @author Roman Andrej
 */
public class TabGroup extends AbstractLaunchConfigurationTabGroup {

	/* (non-Javadoc)
	 * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog, java.lang.String)
	 */
	public void createTabs(ILaunchConfigurationDialog dialog, String mode) {
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new FileNamesInputTab(), // Default tab
				new ConfigurationTab(), 
				new FeatureOptionsTab() };
		setTabs(tabs);
	}
}
