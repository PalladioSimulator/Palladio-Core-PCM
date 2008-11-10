package de.uka.ipd.sdq.dsexplore.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * helps handling the {@link ILaunchConfiguration} needed during a Design Exploration. Offers methods to generate new {@link ILaunchConfiguration} to run the simulation and also delete the generated {@link ILaunchConfiguration}s again.
 * 
 * The {@link ConfigurationHelper} is globally available as a singleton instance, you can also create a new {@link ConfigurationHelper} for local use. 
 * @author Anne
 *
 */
public class ConfigurationHelper {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	/**
	 * Singleton instance
	 */
	private static ConfigurationHelper helper = new ConfigurationHelper();

	/**
	 * Remembers the {@link ILaunchConfiguration} this Helper generated so that it can delete them again. 
	 */
	private List<ILaunchConfiguration> rememberedLaunchConfigs = new ArrayList<ILaunchConfiguration>();

	/**
	 * Creates a copy of the passed {@link ILaunchConfiguration} and updates the file names of the passed {@link PCMInstance}.
	 * @param configuration The base configuration to copy from
	 * @param instance the {@link PCMInstance} to use the file names from. 
	 * @return a copy of configuration in which the filenames of the instance are used.
	 * @throws CoreException if the configuration cannot be copied or the new configuration cannot be saved to the run dialogs
	 */
	public ILaunchConfiguration updateConfig(final ILaunchConfiguration configuration,
			PCMInstance instance) throws CoreException {
		
 		//FIXME: really append the suffixes. 
		
			ILaunchConfigurationWorkingCopy workingCopy = configuration.copy(instance.getName());
			workingCopy.setAttribute(ConstantsContainer.REPOSITORY_FILE, instance.getRepositoryFileName());
			workingCopy.setAttribute(ConstantsContainer.ALLOCATION_FILE, instance.getAllocationFileName());
			workingCopy.setAttribute(ConstantsContainer.SYSTEM_FILE, instance.getSystemFileName());
			workingCopy.setAttribute(ConstantsContainer.USAGE_FILE, instance.getUsageModelFileName());
			workingCopy.setAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, instance.getResourceRepositoryFileName());
			
			workingCopy.setAttribute(SimuComConfig.EXPERIMENT_RUN, instance.getName());
			
			ILaunchConfiguration newLaunchConfig = workingCopy.doSave();
			
			this.rememberedLaunchConfigs.add(newLaunchConfig);
			
			return newLaunchConfig;
		
	}
	
	/**
	 * Deletes all {@link ILaunchConfiguration} this helper has generated before. 
	 */
	public void cleanUp(){
		for (Iterator<ILaunchConfiguration> iterator = rememberedLaunchConfigs.iterator(); iterator
				.hasNext();) {
			ILaunchConfiguration config = iterator.next();
			try {
				config.delete();
			} catch (CoreException e) {
				logger.warn("Could not clean up the launch configs, thus some will stay in your run dialog.");
				e.printStackTrace();
			}			
		}
	}
	
	/**
	 * Get the global singleton instance of this helper.  
	 * @return
	 */
	public static ConfigurationHelper getInstance(){
		return helper;
	}
	

}
