package de.uka.ipd.sdq.dsexplore.helper;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

public class ConfigurationHelper {

	
	public static ILaunchConfiguration updateConfig(ILaunchConfiguration configuration,
			PCMInstance instance) throws CoreException {
		
			ILaunchConfigurationWorkingCopy workingCopy = configuration.copy(instance.getName());
			workingCopy.setAttribute(ConstantsContainer.REPOSITORY_FILE, instance.getRepositoryFileName());
			workingCopy.setAttribute(ConstantsContainer.ALLOCATION_FILE, instance.getAllocationFileName());
			workingCopy.setAttribute(ConstantsContainer.SYSTEM_FILE, instance.getSystemFileName());
			workingCopy.setAttribute(ConstantsContainer.USAGE_FILE, instance.getUsageModelFileName());
			workingCopy.setAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, instance.getResourceRepositoryFileName());
			
			workingCopy.setAttribute(SimuComConfig.EXPERIMENT_RUN, instance.getName());
			
			ILaunchConfiguration newLaunchConfig = workingCopy.doSave();

			return newLaunchConfig;
		
	}
}
