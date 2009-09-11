package de.uka.ipd.sdq.workflow.launchconfig.tabs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;

import de.uka.ipd.sdq.workflow.AbstractJobConfiguration;
import de.uka.ipd.sdq.workflow.launchconfig.configbuilder.AbstractUIBasedConfigurationBuilder;

public abstract class AbstractConfigBuilderTab 
extends AbstractLaunchConfigurationTab {

	@Override
	public boolean isValid(ILaunchConfiguration launchConfig) {
		AbstractUIBasedConfigurationBuilder<?> builder;
		try {
			builder = getConfigurationBuilder(
					launchConfig);
		} catch (CoreException e) {
			return false;
		}
		AbstractJobConfiguration config = builder.build();
		
		if (config.isValid()) {
			return true;
		} else {
			String errorMessage = config.getErrorMessage();
			this.setErrorMessage(errorMessage);
			
			return false;
		}
	}

	abstract protected AbstractUIBasedConfigurationBuilder<?> getConfigurationBuilder(
			ILaunchConfiguration launchConfig) throws CoreException;	
}
