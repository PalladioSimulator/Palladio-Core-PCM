package de.uka.ipd.sdq.dsexplore.helper;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;

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
	public ILaunchConfiguration updateConfig(final ILaunchConfiguration configuration) throws CoreException {
		
		
 		ILaunchConfigurationWorkingCopy workingCopy = configuration.copy(configuration.getName()+"-c");
 		copyAndMarkAttribute(ConstantsContainer.ALLOCATION_FILE, configuration, workingCopy);
 		copyAndMarkAttribute(ConstantsContainer.SYSTEM_FILE, configuration, workingCopy);
 		copyAndMarkAttribute(ConstantsContainer.USAGE_FILE, configuration, workingCopy);
 		
 		//workingCopy.setAttribute(ConstantsContainer.FEATURE_CONFIG, instance.getConnectorConfigFilename());

 		workingCopy.setAttribute(SimuComConfig.EXPERIMENT_RUN, configuration.getName()+"-c");

 		workingCopy.setAttribute(SimuComConfig.SHOULD_THROW_EXCEPTION, false);

 		ILaunchConfiguration newLaunchConfig = workingCopy.doSave();

 		this.rememberedLaunchConfigs.add(newLaunchConfig);

 		return newLaunchConfig;
		
	}
	
	public void copyAndMarkAttribute(String id, ILaunchConfiguration original, ILaunchConfigurationWorkingCopy workingCopy) throws CoreException{
 		String suffix = "-c";
		String fileName = original.getAttribute(id, "");
		String newFileName = appendToFilename(suffix, fileName);
		workingCopy.setAttribute(id, newFileName);
		
		/*//copy file
		File in = new File(fileName);
		File out = new File(newFileName);

        
        FileChannel inChannel;
		try {
			inChannel = new FileInputStream(in).getChannel();
		} catch (FileNotFoundException e1) {
			throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "PCM model file could not be accessed: "+fileName+".", e1));
		}
		
        FileChannel outChannel;
		try {
			outChannel = new FileOutputStream(out).getChannel();
		} catch (FileNotFoundException e1) {
			throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "New PCM model file could not be accessed: "+newFileName+".", e1));
		}

        try {
            inChannel.transferTo(0, inChannel.size(),
                    outChannel);
        } 
        catch (IOException e) {
            throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "PCM model file could not be copied: "+fileName+" to "+newFileName+".", e));
        }
        finally {
            if (inChannel != null)
				try {
					inChannel.close();
				} catch (IOException e) {
					throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Could not close PCM model file: "+fileName+".", e));
				}
            if (outChannel != null)
				try {
					outChannel.close();
				} catch (IOException e) {
					throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, "Could not close new PCM model file: "+newFileName+".", e));
				}
        }*/
    }

		

	private String appendToFilename(String fileNameSuffix, String fileName) {
		int indexOfLastDot = fileName.lastIndexOf(".");
		
		if (indexOfLastDot < 1){
			return fileName + fileNameSuffix;
		} else {
		return fileName.substring(0, indexOfLastDot) + fileNameSuffix
				+ fileName.substring(indexOfLastDot);
	}
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
