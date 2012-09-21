package de.uka.ipd.sdq.cip.runtime.workflow.jobs;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.simucomframework.SimuComConfigExtension;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtensionJobConfiguration;

public class CompletionExtensionConfiguration extends AbstractExtensionJobConfiguration {

	CompletionConfiguration completionConfiguration;

	public CompletionConfiguration getCompletionConfiguration() {
		return completionConfiguration;
	}

	public void setCompletionConfiguration(CompletionConfiguration configuration) {
		completionConfiguration = configuration;
	}
	
    @Override
    public final String getErrorMessage() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void setDefaults() {
        // TODO Auto-generated method stub

    }


}
