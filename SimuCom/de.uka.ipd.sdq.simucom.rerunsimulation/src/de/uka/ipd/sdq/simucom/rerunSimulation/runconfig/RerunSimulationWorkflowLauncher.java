package de.uka.ipd.sdq.simucom.rerunSimulation.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowLauncher;
import de.uka.ipd.sdq.simucom.rerunSimulation.jobs.RerunSimulationJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;

/**
 * This class creates the RerunSimulationJob which is needed for rerunning the simulation without
 * having to delete the original data
 * 
 * @author Michael
 *
 */
public class RerunSimulationWorkflowLauncher extends SimuComWorkflowLauncher {

    /*
     * (non-Javadoc)
     * 
     * @seede.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate# createRunCompositeJob
     * (de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods)
     */
    @Override
    protected IJob createWorkflowJob(SimuComWorkflowConfiguration config, final ILaunch launch) throws CoreException {
        IDebugListener listener = null;

        if (config.isDebug()) {
            listener = new SimulationDebugListener(launch);
        }

        return new RerunSimulationJob(config, listener);
    }
}
