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
import de.uka.ipd.sdq.pcmsolver.PCMSolver;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.Pcm2MarkovStrategy;

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


	private PCMSolver solver;
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public IAnalysisResult analyse(final PCMInstance pcmInstance)
			throws AnalysisFailedException, CoreException {
		
		iteration++;
		
		launchReliabilitySolver(pcmInstance);
		
		IAnalysisResult result = retrieveRealiabilitySolverResults(pcmInstance);
	
		
		return result;
	}
	
	private IAnalysisResult retrieveRealiabilitySolverResults(PCMInstance pcmInstance) throws AnalysisFailedException {
		
		ReliabilityAnalysisResult result = new ReliabilityAnalysisResult(pcmInstance, this.solver);
	
		return result;
	}
	
	/**
	 * Launches the LQN Solver.
	 * 
	 * @param pcmInstance the instance of PCM
	 * @throws AnalysisFailedException 
	 * @throws CoreException 
	 */
	private void launchReliabilitySolver(final PCMInstance pcmInstance)
			throws AnalysisFailedException, CoreException {
		
		this.config = ConfigurationHelper.getInstance().updateConfig(config, pcmInstance);
		pcmInstance.saveUpdatesToFile();
		
		logger.debug("Starting analysis of "+pcmInstance.getName());
		
		//TODO catch exceptions due to convergence problems and handle them nicely. For example, set the response time to MAXINT or similar.
		// Create a new PCM Solver:
		this.solver = new PCMSolver(config, monitor, true);

		// Start the solver:
		solver.execute();

		
		logger.debug("Finished reliability solver analysis");
		
	}

	/**
	 * {@inheritDoc}
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysis#initialise(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void initialise(ILaunchConfiguration configuration, String mode, ILaunch launch,IProgressMonitor monitor) {
		this.monitor = monitor;
		this.config = configuration;
	}
	
	@Override
	public IAnalysisResult retrieveLastResults(PCMInstance pcmInstance)
			throws CoreException, AnalysisFailedException {
		return retrieveRealiabilitySolverResults(pcmInstance);
	}

	
	
}
