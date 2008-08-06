package de.uka.ipd.sdq.dsexplore.launch;

import java.util.List;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Logger;
import org.apache.log4j.PatternLayout;
import org.apache.log4j.Priority;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuLaunchConfigurationDelegate;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.helper.LoggerHelper;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.dsexplore.newcandidates.NewCandidateProxy;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * Launches multiple simulation runs. 
 * 
 * @author Anne
 *
 */
public class DSELaunch implements ILaunchConfigurationDelegate {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	/**
	 * Test for starting multiple simulations.
	 * @param configuration
	 * @param mode
	 * @param launch
	 * @param monitor
	 */
	@Override
	public void launch(ILaunchConfiguration configuration, String mode,
			ILaunch launch, IProgressMonitor monitor) throws CoreException {
		// TODO Auto-generated method stub
		
		//TODO use Workflow mechanism already provided by the codegen packages?
		/* Add jobs for simulation one by one --> no, too low level, need to start whole simulations. */
		
			//super.createRunCompositeJob(new SimuAttributesGetMethods(configuration), true, launch);
			//super.launch(configuration, mode, launch, monitor);
			LoggerHelper.initializeLogger(configuration);
		
			logger.debug("Starting...");
			logger.debug("Launch Configuration: "+configuration.getMemento());
			try {
				
			//Get the initial PCM Instance
		    PCMInstance pcmInstance = new PCMInstance(configuration);
		    
		    //analyse the initial PCM instance
			IAnalysis analysisTool = new AnalysisProxy();
		    analysisTool.analyse(pcmInstance, configuration, mode, launch, monitor);
		
		    //Generate alternatives
		    INewCandidates newCands = new NewCandidateProxy();
		    List<PCMInstance> population = newCands.generateNewCandidates(pcmInstance);
		    
		    
		    //analyse the alternatives
		    for (PCMInstance instance : population) {
		    	ILaunchConfiguration newConfig = updateConfig(configuration, instance);
				analysisTool.analyse(instance, newConfig, mode, launch, monitor);

			}
				
			} catch (AnalysisFailedException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
				throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, e.getMessage(), e));
			}



	}

	private ILaunchConfiguration updateConfig(ILaunchConfiguration configuration,
			PCMInstance instance) {
		
		try {
			ILaunchConfigurationWorkingCopy workingCopy = configuration.copy(instance.getName());
			workingCopy.setAttribute(ConstantsContainer.REPOSITORY_FILE, instance.getRepositoryFileName());
			workingCopy.setAttribute(ConstantsContainer.ALLOCATION_FILE, instance.getAllocationFileName());
			workingCopy.setAttribute(ConstantsContainer.SYSTEM_FILE, instance.getSystemFileName());
			workingCopy.setAttribute(ConstantsContainer.USAGE_FILE, instance.getUsageModelFileName());
			workingCopy.setAttribute(ConstantsContainer.RESOURCETYPEREPOSITORY_FILE, instance.getResourceRepositoryFileName());
			
			workingCopy.setAttribute(SimuComConfig.EXPERIMENT_RUN, instance.getName());
			
			ILaunchConfiguration newLaunchConfig = workingCopy.doSave();

			return newLaunchConfig;
		} catch (CoreException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	


}
