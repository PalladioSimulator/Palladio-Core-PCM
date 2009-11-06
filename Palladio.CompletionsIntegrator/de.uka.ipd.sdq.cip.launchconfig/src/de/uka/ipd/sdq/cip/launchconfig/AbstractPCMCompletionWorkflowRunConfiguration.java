package de.uka.ipd.sdq.cip.launchconfig;

import de.uka.ipd.sdq.cip.runconfig.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public abstract class AbstractPCMCompletionWorkflowRunConfiguration extends
		AbstractCodeGenerationWorkflowRunConfiguration {

	private CompletionConfiguration completionConfig = null;
	
	public void setCompletionConfig(CompletionConfiguration completionConfig) {
		this.completionConfig = completionConfig;
	}

	public CompletionConfiguration getCompletionConfig() {
		return completionConfig;
	}
}
