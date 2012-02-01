/**
 *
 */
package de.fzi.se.validation.effort.workflow;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.BlackboardBasedWorkflow;
import de.uka.ipd.sdq.workflow.IJob;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.mdsd.AbstractWorkflowBasedMDSDLaunchConfigurationDelegate;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.ui.UIBasedWorkflow;


/**Workflow-based launch configuration for validation effort estimation.
 *
 * @author groenda
 *
 */
public class EstimatorWorkflowLauncher extends
	AbstractWorkflowBasedMDSDLaunchConfigurationDelegate<EstimatorConfiguration> {
	/** Temporary storage of launch configuration which is forwarded to the estimators. */
	private ILaunchConfiguration launchConfiguration;

	@Override
	protected IJob createWorkflowJob(EstimatorConfiguration config,
			ILaunch launch) throws CoreException {
		return new RunEstimationsJob(config, launchConfiguration);
	}

	@Override
	protected EstimatorConfiguration deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		this.launchConfiguration = configuration;
		EstimatorConfiguration config = new EstimatorConfiguration();

		AbstractWorkflowConfigurationBuilder builder = new EstimatorConfigurationBuilder(configuration, mode);
		builder.fillConfiguration(config);
		return config;
	}

	@Override
	protected MDSDBlackboard createBlackboard() {
		return new MDSDBlackboard();
	}

	@Override
	protected BlackboardBasedWorkflow<MDSDBlackboard> createWorkflow(
			EstimatorConfiguration workflowConfiguration,
			IProgressMonitor monitor, ILaunch launch) throws CoreException {
		return new UIBasedWorkflow<MDSDBlackboard>(
				createWorkflowJob(workflowConfiguration, launch),
				monitor,
				createExcpetionHandler(workflowConfiguration.isInteractive()),
				createBlackboard());
	}
}
