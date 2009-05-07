package org.somox.ui.runconfig;

import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowBasedRunConfiguration;

public class ModelExtractionConfiguration extends
		AbstractWorkflowBasedRunConfiguration {
	
	ILaunchConfiguration configuration = null;

	public ModelExtractionConfiguration(ILaunchConfiguration configuration) {
		this.configuration = configuration;
	}

	public ILaunchConfiguration getSomoxConfiguration() {
		return configuration;
	}

}
