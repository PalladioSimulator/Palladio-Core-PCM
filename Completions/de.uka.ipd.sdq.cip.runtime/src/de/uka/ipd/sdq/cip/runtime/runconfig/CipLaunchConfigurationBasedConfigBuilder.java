package de.uka.ipd.sdq.cip.runtime.runconfig;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.cip.runtime.configuration.CompletionRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;

public class CipLaunchConfigurationBasedConfigBuilder extends AbstractWorkflowConfigurationBuilder {

	public CipLaunchConfigurationBasedConfigBuilder(ILaunchConfiguration configuration, String mode)
			throws CoreException {
		super(configuration, mode);
	}

	@Override
	public void fillConfiguration(
			AbstractWorkflowBasedRunConfiguration configuration)
			throws CoreException {
		CipConfiguration cipConfiguration = (CipConfiguration) configuration;
		
		cipConfiguration.setCompletionConfiguration(new CompletionRunConfiguration(properties));
	}

}
