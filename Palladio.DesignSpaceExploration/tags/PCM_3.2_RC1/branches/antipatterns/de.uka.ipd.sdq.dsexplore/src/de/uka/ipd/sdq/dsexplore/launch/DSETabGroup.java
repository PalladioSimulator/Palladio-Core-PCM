package de.uka.ipd.sdq.dsexplore.launch;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab;

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
		
		QMLManager qmlManager = new QMLManager();
		
		ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
				new FileNamesInputTab(), // Default tab
				new DSEOptionsTab(),
				new DSEAnalysisMethodTab(DSEConstantsContainer.PERFORMANCE),
				new DSEAnalysisMethodTab(DSEConstantsContainer.RELIABILITY),
				new DSEAnalysisMethodTab(DSEConstantsContainer.COST),
				//new DSEAnalysisMethodTab(DSEConstantsContainer.SECURITY),
				new TacticsTab(),
				new StartingPopulationHeuristicTab(),
				//Atanas: add you tab here and pass the qmlManager as a parameter. 
				
				new DebugEnabledCommonTab()
		};
		setTabs(tabs);
	}

}
