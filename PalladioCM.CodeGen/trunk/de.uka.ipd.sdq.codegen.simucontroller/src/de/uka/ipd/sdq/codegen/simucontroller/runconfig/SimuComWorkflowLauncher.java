package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;

import org.apache.log4j.Level;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.launchconfig.LoggerAppenderStruct;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;

/**
 * The class adapts defined functionality in the AbstractMDSDLaunchConfigurationDelegate for
 * SimuCom Framework.
 * 
 */
public class SimuComWorkflowLauncher extends
		AbstractPCMLaunchConfigurationDelegate<SimuComWorkflowConfiguration> {

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
		SimuComWorkflowConfiguration config = new SimuComWorkflowConfiguration();
		
		AbstractWorkflowConfigurationBuilder builder;
		builder = new PCMWorkflowConfigurationBuilder(configuration, mode);
		builder.fillConfiguration(config);
		
		builder = new SimuComLaunchConfigurationBasedConfigBuilder(
				configuration, mode);
		builder.fillConfiguration(config);
		
		return config;
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
			listener = new SimulationDebugListener(launch);
			/*listener = new IDebugListener() {

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

			};*/
		}
		return new SimuComJob(config,listener);
	}	
}
