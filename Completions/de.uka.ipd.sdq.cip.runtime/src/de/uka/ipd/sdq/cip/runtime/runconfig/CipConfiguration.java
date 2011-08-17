package de.uka.ipd.sdq.cip.runtime.runconfig;

import java.util.List;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.cip.configuration.CompletionConfigurationProvider;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

public class CipConfiguration extends
		AbstractWorkflowBasedRunConfiguration implements CompletionConfigurationProvider{

	private List <String> inputFiles;
	private List <String> outputFiles;
	
	private CompletionConfiguration completionConfiguration;
	
	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefaults() {
		// TODO Auto-generated method stub

	}

	@Override
	public CompletionConfiguration getCompletionConfiguration() {
		return completionConfiguration;
	}

	@Override
	public void setCompletionConfiguration(CompletionConfiguration configuration) {
		completionConfiguration = configuration;
	}

}
