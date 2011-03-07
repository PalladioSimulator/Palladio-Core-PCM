package de.uka.ipd.sdq.simulation.controller.runconfig;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.cip.runtime.runconfig.tabs.CipCompletionTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.FeatureOptionsTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComConfigurationTab;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuConfigurationTab;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.launchconfig.tabs.FileNamesInputTab;

/**
 * TODO description
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimTabGroup extends AbstractLaunchConfigurationTabGroup {

    @Override
    public void createTabs(ILaunchConfigurationDialog dialog, String mode) {

        ILaunchConfigurationTab commonTab = new DebugEnabledCommonTab();
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { 
                new FileNamesInputTab(), // Default tab
                new SimuComConfigurationTab(),
                new SimuConfigurationTab(),
                new FeatureOptionsTab(),
                new CipCompletionTab(),
                commonTab };
        setTabs(tabs);

    }

}
