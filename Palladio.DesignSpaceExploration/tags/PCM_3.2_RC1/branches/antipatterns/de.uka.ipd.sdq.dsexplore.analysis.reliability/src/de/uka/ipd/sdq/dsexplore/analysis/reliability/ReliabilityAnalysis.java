package de.uka.ipd.sdq.dsexplore.analysis.reliability;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchManager;
import org.opt4j.core.Objective;

import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer;
import de.uka.ipd.sdq.pcmsolver.RunPCMAnalysisJob;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverConfigurationBasedConfigBuilder;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov.Pcm2MarkovStrategy;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Starts a reliability Solver Analysis for the design space exploration.
 * 
 * @author pmerkle, anne
 *
 */
public class ReliabilityAnalysis implements IAnalysis {

	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.analysis.reliability.ReliabilityAnalysis");
	
	/**
	 * Store the launch parameters so that we do not have to pass them all the
	 * time.
	 */
	private ILaunchConfiguration config;
	
	private int iteration = -1;


	private double pofod = 0.0;

	private MDSDBlackboard blackboard;
	
	/**
	 * {@inheritDoc}
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 */
	public void analyse(IProgressMonitor monitor)
			throws CoreException, JobFailedException, UserCanceledException {
		
		iteration++;
		
		launchReliabilitySolver(monitor);
		
	}
	
	private IAnalysisResult retrieveReliabilitySolverResults()  {
		
		PCMInstance pcm = new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		
		ReliabilityAnalysisResult result = new ReliabilityAnalysisResult(this.pofod);
	
		return result;
	}
	
	/**
	 * Launches the LQN Solver.
	 * @param monitor 
	 * 
	 * @param pcmInstance the instance of PCM
	 * @throws AnalysisFailedException RunPCMAnalysisJob solver = new RunPCMAnalysisJob(configuration, true);
	 * @throws CoreException 
	 * @throws UserCanceledException 
	 * @throws JobFailedException 
	 */
	private void launchReliabilitySolver(IProgressMonitor monitor)
			throws CoreException, JobFailedException, UserCanceledException {
		
		//TODO catch exceptions due to convergence problems and handle them nicely. For example, set the response time to MAXINT or similar.
				
		PCMSolverWorkflowRunConfiguration solverConfiguration = new PCMSolverWorkflowRunConfiguration();
		AbstractWorkflowConfigurationBuilder builder;

		builder = new PCMWorkflowConfigurationBuilder(this.config, ILaunchManager.RUN_MODE);
		builder.fillConfiguration(solverConfiguration);

		builder = new PCMSolverConfigurationBasedConfigBuilder(this.config,
				ILaunchManager.RUN_MODE);
		builder.fillConfiguration(solverConfiguration);
		solverConfiguration.setInteractive(false);
		
		solverConfiguration.setReliabilityAnalysis(true);
		
		// Create a new Analysis job
		RunPCMAnalysisJob solverJob = new RunPCMAnalysisJob(solverConfiguration); 
		solverJob.setBlackboard(blackboard);
		
		//execute the job
		solverJob.execute(monitor);
		
		this.pofod = 1 - ((Pcm2MarkovStrategy)solverJob.getStrategy()).getSolvedValue().getSuccessProbability();
		
		logger.debug("Finished reliability solver analysis");
		
	}

	/**
	 * {@inheritDoc}
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysis#initialise(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	public void initialise(ILaunchConfiguration configuration) {
		this.config = configuration;
	}
	
	public IAnalysisResult retrieveLastResults()
			throws CoreException, AnalysisFailedException {
		return retrieveReliabilitySolverResults();
	}

	public String getQualityAttribute() throws CoreException {
		return DSEConstantsContainer.POFOD_QUALITY;
	}

	public boolean hasStatisticResults() throws CoreException {
		return false;
	}

	//TODO support several usage scenarios, then also change hasObjectivePerUsageScenario
	@Override
	public List<Objective> getObjectives() throws CoreException {
		List<Objective> objectives = new ArrayList<Objective>(1);
		Objective o = new Objective(this.getQualityAttribute(), Objective.Sign.MIN);
		objectives.add(o);
		
		return objectives;
	}
	
	//TODO: Support several usage scenarios.
	@Override
	public IAnalysisResult retrieveLastResultsForObjective(Objective objective)
			throws CoreException, AnalysisFailedException {
		IAnalysisResult result = retrieveReliabilitySolverResults();
	
		return result;
	}

	@Override
	public boolean hasObjectivePerUsageScenario() throws CoreException {
		// TODO Auto-generated method stub
		return false;
	}


	@Override
	public void setBlackboard(MDSDBlackboard blackboard) {
		this.blackboard = blackboard;
		
	}
	
	
	
}
