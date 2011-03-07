package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisQualityAttributes;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;

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
		
		ArrayList<DSEAnalysisMethodTab> analysisTabs = new ArrayList<DSEAnalysisMethodTab>(); 
		for(Dimension d : new AnalysisQualityAttributes().getAllDimensions()){
			analysisTabs.add(new DSEAnalysisMethodTab(d));
		}
		
		for(DSEAnalysisMethodTab tab : analysisTabs) {
			qmlManager.addTabs(tab);
		}
		
		DSEFileNamesInputTab defaultTab = new DSEFileNamesInputTab(qmlManager);
				
		DSEOptionsTab optionsTab = new DSEOptionsTab();
		
		TerminationCriteriaTab terminationTab = new TerminationCriteriaTab(qmlManager);
		
		ArrayList<ILaunchConfigurationTab> tabs = new ArrayList<ILaunchConfigurationTab>();
		
		tabs.add(defaultTab); // Default tab
		tabs.add(optionsTab);
		tabs.add(terminationTab);

		tabs.addAll(analysisTabs);

		tabs.add(new TacticsTab());
		tabs.add(new StartingPopulationHeuristicTab());
				
		tabs.add(new DebugEnabledCommonTab());
		
		
		
		ILaunchConfigurationTab[] iTabs = new ILaunchConfigurationTab[tabs.size()];
		for (int i = 0; i < iTabs.length; i++) {
			iTabs[i] = tabs.get(i);
		}
		setTabs(iTabs);

	}

}
