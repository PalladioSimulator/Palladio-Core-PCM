package de.uka.ipd.sdq.workflow.pcm.configurations;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.launchconfig.ConstantsContainer;

public class PCMWorkflowConfigurationBuilder extends
		AbstractWorkflowConfigurationBuilder {

	public PCMWorkflowConfigurationBuilder(ILaunchConfiguration configuration,
			String mode) throws CoreException {
		super(configuration, mode);
	}

	@Override
	public void fillConfiguration(
			AbstractWorkflowBasedRunConfiguration configuration)
			throws CoreException {
		AbstractPCMWorkflowRunConfiguration config = (AbstractPCMWorkflowRunConfiguration) configuration;
		
		setPCMFilenames(config);
	}

	private void setPCMFilenames(AbstractPCMWorkflowRunConfiguration config) throws CoreException {
		
		config.setRepositoryFile   ( getStringAttribute(ConstantsContainer.REPOSITORY_FILE) );
		config.setResourceTypeFile ( getStringAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE) );
		config.setSystemFile       ( getStringAttribute(ConstantsContainer.SYSTEM_FILE) );
		config.setAllocationFile   ( getStringAttribute(ConstantsContainer.ALLOCATION_FILE) );
		config.setUsageModelFile   ( getStringAttribute(ConstantsContainer.USAGE_FILE) );
		config.setMiddlewareFile   ( getStringAttribute(ConstantsContainer.MWREPOSITORY_FILE) );

	}	
}
