package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugTarget;
import de.uka.ipd.sdq.codegen.simucontroller.dockmodel.DockModel;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;

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

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractMDSDLaunchConfigurationDelegate#setupLogging(org.apache.log4j.Level)
	 */
	@Override
	protected ArrayList<LoggerAppenderStruct> setupLogging(Level logLevel) throws CoreException {
		ArrayList<LoggerAppenderStruct> loggerList = super.setupLogging(logLevel);
		loggerList.add(setupLogger("de.uka.ipd.sdq.codegen", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		loggerList.add(setupLogger("de.uka.ipd.sdq.simucomframework", logLevel, Level.DEBUG == logLevel ? DETAILED_LOG_PATTERN : SHORT_LOG_PATTERN));
		
		return loggerList;
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
						launch.removeDebugTarget(target);
						target.dispose();
					}
				}

			};
		}
		return new SimuComJob(config,listener);
	}	
}
