package de.uka.ipd.sdq.dsexplore.analysis.reliability;

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
import de.uka.ipd.sdq.pcmsolver.RunPCMAnalysisJob;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverLaunchConfigurationDelegate;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverReliabilityLaunchConfigurationDelegate;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.Pcm2MarkovStrategy;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;

/**
 * Starts a reliability Solver Analysis for the design space exploration.
 * 
 * @author pmerkle, anne
 *
 */
public class ReliabilityAnalysis implements IAnalysis {

	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	

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
	
	private int iteration = -1;


	private double pofod = 0.0;


	private String mode;


	private ILaunch launch;
	
	/**
	 * {@inheritDoc}
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 */
	@Override
	public IAnalysisResult analyse(final PCMInstance pcmInstance)
			throws CoreException, JobFailedException, UserCanceledException {
		
		iteration++;
		
		launchReliabilitySolver(pcmInstance);
		
		IAnalysisResult result = retrieveRealiabilitySolverResults(pcmInstance);
	
		
		return result;
	}
	
	private IAnalysisResult retrieveRealiabilitySolverResults(PCMInstance pcmInstance)  {
		
		ReliabilityAnalysisResult result = new ReliabilityAnalysisResult(pcmInstance, this.pofod);
	
		return result;
	}
	
	/**
	 * Launches the LQN Solver.
	 * 
	 * @param pcmInstance the instance of PCM
	 * @throws AnalysisFailedException RunPCMAnalysisJob solver = new RunPCMAnalysisJob(configuration, true);
	 * @throws CoreException 
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 */
	private void launchReliabilitySolver(final PCMInstance pcmInstance)
			throws CoreException, JobFailedException, UserCanceledException {
		
		this.config = ConfigurationHelper.getInstance().updateConfig(this.config, pcmInstance);
		pcmInstance.saveUpdatesToFile();
		
		logger.debug("Starting analysis of "+pcmInstance.getName());
		
		//TODO catch exceptions due to convergence problems and handle them nicely. For example, set the response time to MAXINT or similar.
		// Create a new PCM Solver:
		PCMSolverReliabilityLaunchConfigurationDelegate solverDelegate = new PCMSolverReliabilityLaunchConfigurationDelegate();
		
		
		// Start the solver:
		solverDelegate.launch(this.config, this.mode, this.launch, this.monitor);
		
		this.pofod = 1 - solverDelegate.getStrategy().getSolvedValue();
		
		logger.debug("Finished reliability solver analysis");
		
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
		return retrieveRealiabilitySolverResults(pcmInstance);
	}

	@Override
	public String getQualityAttribute() throws CoreException {
		return "POFOD";
	}

	
	
}
