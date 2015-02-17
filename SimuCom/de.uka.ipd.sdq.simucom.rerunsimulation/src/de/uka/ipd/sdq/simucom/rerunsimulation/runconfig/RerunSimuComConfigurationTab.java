package de.uka.ipd.sdq.simucom.rerunsimulation.runconfig;

import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.ILaunchConfigurationTab;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComConfigurationTab;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;

/**
 * This tab is basically the same tab as SimuComConfigurationTab. The only difference is that in
 * this tab the first section, the simulator section, is left out since there is no simulator
 * specification needed when rerunning a simulated project
 * 
 * @author Michael Junker
 *
 */
public class RerunSimuComConfigurationTab extends SimuComConfigurationTab implements ILaunchConfigurationTab {

    @Override
    protected void createSimulatorGroup() {
        // Do nothing here
    }

    @Override
    protected void initializeSimulatorGroup(ILaunchConfiguration configuration) {
        // Do nothing here
    }

    @Override
    protected void applySimulatorGroup(ILaunchConfigurationWorkingCopy configuration) {
        configuration
                .setAttribute(AbstractSimulationConfig.SIMULATOR_ID, AbstractSimulationConfig.DEFAULT_SIMULATOR_ID);
    }

    @Override
    protected boolean isSimulatorGroupValid() {
        return true;
    }
}
