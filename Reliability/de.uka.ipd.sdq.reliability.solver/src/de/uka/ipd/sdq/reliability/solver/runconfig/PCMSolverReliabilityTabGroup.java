package de.uka.ipd.sdq.reliability.solver.runconfig;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

/**
 * The configuration tabs shown in the run dialog or debug dialog for the PCM Solver Reliability
 * launch.
 * 
 * The extension point org.eclipse.debug.ui.launchConfigurationTabGroups in the plugin.xml refers to
 * this class. The class inherits from the eclipse-internal tab group.
 * 
 * @author brosch
 * 
 */
public class PCMSolverReliabilityTabGroup extends AbstractLaunchConfigurationTabGroup {

    /**
     * The main routine that creates and sets the individual tab pages.
     * 
     * @param dialog
     *            the run or debug dialog
     * @param mode
     *            distinguishes between run and debug modes
     * @see org.eclipse.debug.ui.ILaunchConfigurationTabGroup#createTabs(org.eclipse.debug.ui.ILaunchConfigurationDialog,
     *      java.lang.String)
     */
    public void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {

        // Assemble the tab pages:
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] {
                new FileNamesInputTab(), new ReliabilityConfigurationTab(), new OptionsTab(),
                new DebugEnabledCommonTab()
        };

        // Do the setup:
        setTabs(tabs);
    }
}
