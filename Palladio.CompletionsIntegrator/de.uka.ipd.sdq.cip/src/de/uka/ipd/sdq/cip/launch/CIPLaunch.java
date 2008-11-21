package de.uka.ipd.sdq.cip.launch;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;
import org.eclipse.jface.dialogs.MessageDialog;

import de.uka.ipd.sdq.cip.PCMInstance;

/**
 * Launches multiple simulation runs. 
 * 
 * @author Anne
 *
 */
public class CIPLaunch implements ILaunchConfigurationDelegate {
	
	/**
	 * A default to be overridden by the settings in the run dialog.
	 */
	private int maxIterations = Integer.MAX_VALUE;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.cip");
	
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
		
		//TODO use Workflow mechanism already provided by the codegen packages?
		/* Add jobs for simulation one by one --> no, too low level, need to start whole simulations. */
		
			//super.createRunCompositeJob(new SimuAttributesGetMethods(configuration), true, launch);
			//super.launch(configuration, mode, launch, monitor);
			//LoggerHelper.initializeLogger(configuration);
			
			Long timestampMillis = System.currentTimeMillis();
		
			logger.debug("Starting...");
			logger.debug("Launch Configuration: "+configuration.getMemento());
			
			String maxIterationsString = configuration.getAttribute(CIPConstantsContainer.MAX_ITERATIONS, "");
			if (!maxIterationsString.equals("")){
				try{
				this.maxIterations = Integer.parseInt(maxIterationsString);
				} catch (Exception e){
					//ok, it was worth a try, so just keep the old value. 
				}
			} else {
				maxIterations = Integer.MAX_VALUE;
			}
			
			
			//List<IAnalysisResult> allCandidates = null;
			
				
			//Get the initial PCM Instance
		    PCMInstance pcmInstance = new PCMInstance(configuration);
		    List<PCMInstance> instances = new ArrayList<PCMInstance>();
		    instances.add(pcmInstance);
		    
		    
		    

		    
		    //logger.info("Best candidate: "+currentPopulation.get(0).getPCMInstance().getName());
		    
			
			//IIndividual individual = null;

	//		logger.debug("DSE launch done");

	}

	
	
}
