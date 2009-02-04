package de.uka.ipd.sdq.dsexplore.analysis.lqnsolver;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.helper.ConfigurationHelper;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverLaunchConfigurationDelegate;

import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.*;

/**
 * Starts a LQNSolver Analysis for the design space exploration.
 * 
 * @author pmerkle
 *
 */
public class LQNSolverAnalysis implements IAnalysis {

	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	/**
	 * Store the launch parameters so that we do not have to pass them all the
	 * time.
	 */
	private String mode;
	/**
	 * Store the launch parameters so that we do not have to pass them all the
	 * time.
	 */
	private ILaunch launch;
	/**
	 * Store the launch parameters so that we do not have to pass them all the
	 * time.
	 */
	private IProgressMonitor monitor;
	/**
	 * Store the launch parameters so that we do not have to pass them all the
	 * time.
	 */
	private ILaunchConfiguration config;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IAnalysisResult analyse(final PCMInstance pcmInstance)
			throws AnalysisFailedException, CoreException {
		
		launchLQNSolver(pcmInstance);
		
		IAnalysisResult result = retrieveLQNSolverResults(pcmInstance);
		
		return result;
	}
	
	private IAnalysisResult retrieveLQNSolverResults(PCMInstance pcmInstance) {
		// TODO Read XML output file generated from LQNSolver
		
//		LqnXmlHandler.loadModelFromXMI(fileName); // TODO: Only for testing purposes. Delete!
		
		return null;
	}
	
	/**
	 * Launches the LQN Solver.
	 * 
	 * @param pcmInstance the instance of PCM
	 * @throws AnalysisFailedException 
	 * @throws CoreException 
	 */
	private void launchLQNSolver(final PCMInstance pcmInstance)
			throws AnalysisFailedException, CoreException {
		
		this.config = ConfigurationHelper.getInstance().updateConfig(config, pcmInstance);
		pcmInstance.saveUpdatesToFile();
		
		logger.debug("Starting analysis of "+pcmInstance.getName());
		
		PCMSolverLaunchConfigurationDelegate pcmSolver = new PCMSolverLaunchConfigurationDelegate();
		
		try {
			pcmSolver.launch(config, mode, launch, monitor);
//			restoreLogger(config); // TODO: Do we need this?
			logger.debug("Finished PCMSolver analysis");
		} catch (CoreException e) {  
			String standardError = "PCMSolver launch failed for PCM instance \""+pcmInstance.getName()+"\"";
			logger.error(standardError);
			throw new AnalysisFailedException(standardError+": "+e.getMessage(), e);
		}
		
	}

	/**
	 * {@inheritDoc}
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysis#initialise(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void initialise(ILaunchConfiguration configuration, String mode, ILaunch launch,IProgressMonitor monitor) {
		this.mode = mode;
		this.launch = launch;
		this.monitor = monitor;
		this.config = configuration;
	}
	
	@Override
	public IAnalysisResult retrieveLastResults(PCMInstance pcmInstance)
			throws CoreException, AnalysisFailedException {
		return retrieveLQNSolverResults(pcmInstance);
	}

	
	
}
