package de.uka.ipd.sdq.dsexplore.launch;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.model.ILaunchConfigurationDelegate;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuLaunchConfigurationDelegate;
import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisProxy;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.newcandidates.INewCandidates;
import de.uka.ipd.sdq.dsexplore.newcandidates.NewCandidateProxy;

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
		
			logger.debug("Starting...");
		
		    INewCandidates newCands = new NewCandidateProxy();
		    
		    //TODO: Get the PCM Instances here!
		    PCMInstance pcmInstance = new PCMInstance(configuration);
		    
		    newCands.generateNewCandidates(pcmInstance);
		    
		    IAnalysis analysisTool = new AnalysisProxy();
		    
		    analysisTool.analyse(pcmInstance, null);


	}

}
