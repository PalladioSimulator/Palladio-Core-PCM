package de.uka.ipd.sdq.workflow.launchconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;

import de.uka.ipd.sdq.workflow.Workflow;
import de.uka.ipd.sdq.workflow.launchconfig.configbuilder.AbstractUIBasedConfigurationBuilder;

public abstract class AbstractConfigBuilderBasedLaunchConfigurationDelegate
	<WorkflowConfigurationType extends AbstractWorkflowBasedRunConfiguration,
	WorkflowType extends Workflow> 
extends
		AbstractWorkflowBasedLaunchConfigurationDelegate<WorkflowConfigurationType,WorkflowType> {

	/* (non-Javadoc)
	 * @see de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedLaunchConfigurationDelegate#deriveConfiguration(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String)
	 */
	@Override
	protected WorkflowConfigurationType deriveConfiguration(
			ILaunchConfiguration configuration, String mode)
			throws CoreException {
		WorkflowConfigurationType config = getConfigurationBuilder(configuration).build();
		
		config.setDebug(mode == ILaunchManager.DEBUG_MODE);
		config.setInteractive(true);
		
		return config;
	}
	
	/**
	 * Template method which is supposed to create the configuration builder object 
	 * which is able to convert a given launch configuration into a configuration object
	 * 
	 * Clients must override this method
	 *
	 * @param configuration The configuration used to parametrise the configuration builder
	 * 
	 * @return The configuration builder object used to convert launch configurations into real 
	 * 		   configuration objects
	 * @throws CoreException 
	 */
	abstract protected AbstractUIBasedConfigurationBuilder<WorkflowConfigurationType> getConfigurationBuilder(
			ILaunchConfiguration configuration) throws CoreException;
}
