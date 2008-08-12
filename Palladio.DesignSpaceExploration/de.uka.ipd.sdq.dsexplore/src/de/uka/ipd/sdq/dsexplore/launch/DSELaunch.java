package de.uka.ipd.sdq.dsexplore.launch;

import java.util.ArrayList;
import java.util.List;

import net.sf.jclec.IIndividual;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import de.uka.ipd.sdq.codegen.runconfig.tabs.ConstantsContainer;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.algorithms.HillClimbingAlgorithm;
import de.uka.ipd.sdq.dsexplore.algorithms.IAlgorithm;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
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
		    List<PCMInstance> instances = new ArrayList<PCMInstance>();
		    instances.add(pcmInstance);
		    
		    //initialise the algorithm and analysis
		    IAlgorithm algorithm = new HillClimbingAlgorithm();
			IAnalysis analysisTool = new AnalysisProxy(configuration, mode, launch, monitor);
		    algorithm.initialise(instances, analysisTool);
		    
		    //analyse the initial PCMInstance
			IAnalysisResult result = analysisTool.analyse(pcmInstance);
		    logger.info("The mean value of instance "+pcmInstance.getName()+": "+result.getMeanValue());
		    List<IAnalysisResult> population = new ArrayList<IAnalysisResult>();
		    population.add(result);
		    
		    while(!algorithm.terminated()){
		    	population = algorithm.iterate(population);
		    }
		    
		    logger.info("Best candidate: "+population.get(0).getPCMInstance().getName());



				
			} catch (AnalysisFailedException e) {
				logger.error(e.getMessage());
				e.printStackTrace();
				throw new CoreException(new Status(Status.ERROR, "de.uka.ipd.sdq.dsexplore", 0, e.getMessage(), e));
			}
			
			IIndividual individual = null;



	}


	


}
