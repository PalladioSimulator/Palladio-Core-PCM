package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.debug.ui.AbstractLaunchConfigurationTabGroup;
import org.eclipse.debug.ui.ILaunchConfigurationDialog;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.workflow.launchconfig.tabs.DebugEnabledCommonTab;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ConfigurationTab;
import de.uka.ipd.sdq.workflow.pcm.runconfig.FileNamesInputTab;

/**
 * The configuration tabs shown in the run dialog or debug dialog for the PCM Solver launch.
 * 
 * The extension point org.eclipse.debug.ui.launchConfigurationTabGroups in the plugin.xml refers to
 * this class. The class inherits from the eclipse-internal tab group.
 * 
 * @author koziolek, brosch
 * 
 */
public class PCMSolverTabGroup extends AbstractLaunchConfigurationTabGroup {

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
    @Override
    public void createTabs(final ILaunchConfigurationDialog dialog, final String mode) {

        // Assemble the tab pages:
        ILaunchConfigurationTab[] tabs = new ILaunchConfigurationTab[] { new FileNamesInputTab(), new MainConfigTab(),
                new ConfigurationTab(), new DebugEnabledCommonTab() };

        // Do the setup:
        setTabs(tabs);
    }
}
