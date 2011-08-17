package  de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.CompletionConfigurationProvider;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

/**
 * Base class of workflow configuration objects where the corresponding workflow
 * makes completion transformations on PCM models.
 * 
 * See also {@link CompletionConfigurationProvider} and {@link CompletionConfiguration}
 * 
 * @author Thomas Schuischel
 *
 */
public abstract class AbstractPCMCompletionWorkflowRunConfiguration extends AbstractCodeGenerationWorkflowRunConfiguration implements CompletionConfigurationProvider {

	protected CompletionConfiguration completionConfiguration;
	
	@Override
	public CompletionConfiguration getCompletionConfiguration() {
		return completionConfiguration;
	}

	@Override
	public void setCompletionConfiguration(CompletionConfiguration configuration) {
		completionConfiguration = configuration;
	}

}
