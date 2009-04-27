package org.somox.ui.runconfig;

import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

public class ModelAnalyzerConfiguration extends
		AbstractWorkflowBasedRunConfiguration {
	
	ILaunchConfiguration configuration = null;

	public ModelAnalyzerConfiguration(ILaunchConfiguration configuration) {
		this.configuration = configuration;
	}

	public ILaunchConfiguration getSomoxConfiguration() {
		return configuration;
	}

}
