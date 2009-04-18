package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugTarget;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.codegen.workflow.IJob;

/**
 * The class adapts defined functionality in the AbstractMDSDLaunchConfigurationDelegate for
 * SimuCom Framework.
 * 
 */
public class SimuComWorkflowLauncher extends
		AbstractMDSDLaunchConfigurationDelegate<SimuComWorkflowConfiguration> {

	/*
	 * (non-Javadoc)
	 * 
	 * @seede.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#
	 * creataAttributesGetMethods(org.eclipse.debug.core.ILaunchConfiguration)
	 */
	@Override
	protected SimuComWorkflowConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		SimuComConfigurationBuilder builder = new SimuComLaunchConfigurationBasedConfigBuilder(
				configuration, mode);
		return builder.getConfiguration();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @seede.uka.ipd.sdq.codegen.runconfig.LaunchConfigurationDelegate#
	 * createRunCompositeJob
	 * (de.uka.ipd.sdq.codegen.runconfig.AttributesGetMethods)
	 */
	@Override
	protected IJob createWorkflowJob(SimuComWorkflowConfiguration config,
			final ILaunch launch) throws CoreException {
		IDebugListener listener = null;
		
		if (config.isDebug()) {
			listener = new IDebugListener() {

				private SimulationDebugTarget target = null;

				public void simulationStartsInDock(DockModel dock) {
					target   = new SimulationDebugTarget(launch,dock);
					launch.addDebugTarget(target);
				}

				public void simulationStoppedInDock() {
					if (target != null) {
						// Wait for termination, needed as termination is reported via async events by the dock
						while (!target.isTerminated()) {
							try {
								Thread.sleep(100);
							} catch (InterruptedException e) {
							}
						}
						target.dispose();
						launch.removeDebugTarget(target);
					}
				}

			};
		}
		return new SimuComJob(config,listener);
	}
}
