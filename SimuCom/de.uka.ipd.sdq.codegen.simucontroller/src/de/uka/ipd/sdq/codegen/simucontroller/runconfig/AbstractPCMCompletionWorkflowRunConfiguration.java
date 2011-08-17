package  de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.CompletionConfigurationProvider;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public abstract class AbstractPCMCompletionWorkflowRunConfiguration extends AbstractCodeGenerationWorkflowRunConfiguration implements CompletionConfigurationProvider {

	CompletionConfiguration completionConfiguration;
	
	@Override
	public CompletionConfiguration getCompletionConfiguration() {
		return completionConfiguration;
	}

	@Override
	public void setCompletionConfiguration(CompletionConfiguration configuration) {
		completionConfiguration = configuration;
	}

}
