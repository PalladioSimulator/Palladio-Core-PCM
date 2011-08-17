package de.uka.ipd.sdq.dsexplore.analysis.lqn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.core.ILaunchManager;
import org.opt4j.core.Constraint;
import org.opt4j.core.Criterion;
import org.opt4j.core.Objective;

import LqnCore.LqnModelType;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysisResult;
import de.uka.ipd.sdq.dsexplore.analysis.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedCriterion;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedInfeasibilityConstraint;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedObjective;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedSatisfactionConstraint;
import de.uka.ipd.sdq.dsexplore.qml.pcm.reader.PCMDeclarationsReader;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.UsageScenarioRequirement;
import de.uka.ipd.sdq.pcm.usagemodel.UsageModel;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.RunPCMAnalysisJob;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.pcmsolver.runconfig.MessageStrings;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverConfigurationBasedConfigBuilder;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.pcmsolver.transformations.SolverStrategy;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.LqnXmlHandler;
import de.uka.ipd.sdq.pcmsolver.transformations.pcm2lqn.Pcm2LqnStrategy;
import de.uka.ipd.sdq.workflow.exceptions.JobFailedException;
import de.uka.ipd.sdq.workflow.exceptions.UserCanceledException;
import de.uka.ipd.sdq.workflow.launchconfig.AbstractWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.PCMWorkflowConfigurationBuilder;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

public abstract class AbstractLQNAnalysis implements IAnalysis {

	/** Logger for log4j. */
	protected static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.analysis.lqn.LQNSolverAnalysis");
	
	
	/**
	 * Store the launch parameters so that we do not have to pass them all the
	 * time.
	 */
	private ILaunchConfiguration config;
	
	protected int iteration = -1;

	private MDSDBlackboard blackboard;

	private LQNQualityAttribute lQNQualityAttribute = new LQNQualityAttribute();
	
	//Constraint handling
	private List<Constraint> constraints = new ArrayList<Constraint>();
	private Map<Constraint, EvaluationAspectWithContext> constraintToAspect = new HashMap<Constraint, EvaluationAspectWithContext>(); //This is needed to determine, what THE result is (Mean,  Variance, ...)

	private List<Objective> objectives = new ArrayList<Objective>();
	private Map<Objective, EvaluationAspectWithContext> objectiveToAspect = new HashMap<Objective, EvaluationAspectWithContext>();


	private Map<Long, String> previousResultFileName = new HashMap<Long, String>();
	
	/**
	 * {@inheritDoc}
	 * @throws UserCanceledException 
	 */
	public void analyse(PCMPhenotype pheno, IProgressMonitor monitor)
			throws AnalysisFailedException, CoreException, UserCanceledException {
		
		ILaunchConfigurationWorkingCopy wcopy = this.config.getWorkingCopy();
		wcopy.setAttribute(MessageStrings.SOLVER,
				this.getSolverMessageString());
		this.config = wcopy.doSave();
		
		iteration++;
		
		PCMInstance pcm = new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		
		try {
			launchLQNSolver(pheno, monitor);
			//IAnalysisResult result = retrieveLQNSolverResults(pcm);
			//return result;
		} catch (RuntimeException e){
			handleException(e, pcm);
		}
		
		
	}
	
	/**
	 * FIXME: Make this method independent of the blackboard state.  
	 */
	public IAnalysisResult retrieveResultsFor(PCMPhenotype pheno, Criterion criterion) throws AnalysisFailedException{
		PCMInstance pcm = new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		IAnalysisResult result = retrieveLQNSolverResults(pheno, pcm,criterion);
		return result;
	}
	
	/**
	 * try to handle the exception or throw it back. 
	 * @param e
	 * @param pcm 
	 * @return
	 */
	protected abstract IAnalysisResult handleException(RuntimeException e, PCMInstance pcm);

	protected abstract String getSolverMessageString();

	ILQNResult retrieveLQNSolverResults(PCMPhenotype pheno, PCMInstance pcm, Criterion criterion) throws AnalysisFailedException {
		
		String xmlFileName = this.previousResultFileName.get(pheno.getNumericID());
		
		// Read XML output file generated by LQNSolver
		LqnModelType model =  LqnXmlHandler.loadModelFromXMI(xmlFileName);
		
		if (model == null){
			throw new AnalysisFailedException("LQN model "+xmlFileName+" could not be loaded. See previous logging entries for details.");
		}
		if (criterion instanceof UsageScenarioBasedObjective){
			ILQNResult result = retrieveResult(pcm, model,(UsageScenarioBasedObjective) criterion);
			return result;
		} else if(criterion instanceof UsageScenarioBasedInfeasibilityConstraint) {
			//Handle Type of constraint, if other types possible
			ILQNResult result = retrieveResult(pcm, model,(UsageScenarioBasedInfeasibilityConstraint) criterion);
			return result;
		} else if(criterion instanceof UsageScenarioBasedSatisfactionConstraint) {
			//Handle Type of constraint, if other types possible
			ILQNResult result = retrieveResult(pcm, model,(UsageScenarioBasedSatisfactionConstraint) criterion);
			return result;
		} else { 		
			throw new AnalysisFailedException("Wrong criterion type "+criterion.getClass()+". Expected UsageScenarioBasedCriterion.");
		}
		
		
	}

	protected abstract ILQNResult retrieveResult(PCMInstance pcm,
			LqnModelType model,UsageScenarioBasedCriterion criterion) throws AnalysisFailedException;

	/**
	 * Launches the LQN Solver.
	 * @param monitor 
	 * 
	 * @param pcmInstance the instance of PCM
	 * @return 
	 * @throws AnalysisFailedException 
	 * @throws CoreException 
	 * @throws UserCanceledException 
	 */
	private void  launchLQNSolver(PCMPhenotype pheno, IProgressMonitor monitor)
			throws AnalysisFailedException, CoreException, UserCanceledException {
	
		if (monitor == null){
			throw new AnalysisFailedException(this.getClass().getName()+" was not correctly initialised.");
		}


		PCMSolverWorkflowRunConfiguration solverConfiguration = new PCMSolverWorkflowRunConfiguration();
		AbstractWorkflowConfigurationBuilder builder;

		builder = new PCMWorkflowConfigurationBuilder(this.config, ILaunchManager.RUN_MODE);
		builder.fillConfiguration(solverConfiguration);

		builder = new PCMSolverConfigurationBasedConfigBuilder(this.config,
				ILaunchManager.RUN_MODE);
		builder.fillConfiguration(solverConfiguration);
		solverConfiguration.setInteractive(false);
		
		
		// Create a new Analysis job
		RunPCMAnalysisJob solverJob = new RunPCMAnalysisJob(solverConfiguration);

		solverJob.setBlackboard(blackboard);
		SolverStrategy strategy = solverJob.getStrategy();
		if (strategy instanceof Pcm2LqnStrategy){
			this.previousResultFileName.put(pheno.getNumericID(), ((Pcm2LqnStrategy)strategy).getFilenameResultXML());
		}

		try {
			
			//TODO catch exceptions due to convergence problems and handle them nicely. For example, set the response time to MAXINT or similar.
			
			//execute the job
			solverJob.execute(monitor);
			
			logger.debug("Finished PCMSolver LQN analysis");
			
		} catch (JobFailedException e) {  
			logger.error(e.getMessage());
			throw new AnalysisFailedException(e);
		} 
		
		
	}

	/**
	 * {@inheritDoc}
	 * @throws CoreException 
	 * @see de.uka.ipd.sdq.dsexplore.analysis.IAnalysis#initialise(org.eclipse.debug.core.ILaunchConfiguration, java.lang.String, org.eclipse.debug.core.ILaunch, org.eclipse.core.runtime.IProgressMonitor)
	 */
	@Override
	public void initialise(ILaunchConfiguration configuration) throws CoreException {
		this.config = configuration;
		
		PCMInstance pcmInstance = new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		List<UsageScenario> scenarios = pcmInstance.getUsageModel().getUsageScenario_UsageModel();
		
		initialiseCriteria(configuration, scenarios);

//		this.objectives = new ArrayList<Objective>(scenarios.size());
//		for (UsageScenario usageScenario : scenarios) {
//			//FIXME: hardcoded usage scenario selection
//			String scenName = usageScenario.getEntityName();
//			if (!scenName.contains("AlarmRetrieve") 
//					&& !scenName.contains("Wrapper")
//					&& !scenName.contains("HistoryRetrieve")){
//				objectives.add(new UsageScenarioBasedObjective(this.getQualityAttribute(), Objective.Sign.MIN, usageScenario));
//			}
//		}


	}
	
	private void initialiseCriteria(ILaunchConfiguration configuration, List<UsageScenario> scenarios) throws CoreException{
		PCMInstance pcm = new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		UsageModel usageModel = pcm.getUsageModel();
		
		PCMDeclarationsReader reader = new PCMDeclarationsReader( 
				configuration.getAttribute("qmlDefinitionFile", ""));
		
		List<EvaluationAspectWithContext> responseTimeAspect = reader.getDimensionConstraintContextsForUsageModel(usageModel, lQNQualityAttribute.getDimension().getId());
		responseTimeAspect.addAll(reader.getDimensionObjectiveContextsForUsageModel(usageModel, lQNQualityAttribute.getDimension().getId()));
	
		//Check constraint aspects and create Constraint-Objects for every Aspect
		for (Iterator<EvaluationAspectWithContext> iterator = responseTimeAspect.iterator(); iterator.hasNext();) {
			EvaluationAspectWithContext aspectContext = iterator
					.next();
			
			if(aspectContext.getRequirement() instanceof UsageScenarioRequirement) {  
				
						//handle possible aspects here
						if (canEvaluateAspect(aspectContext.getEvaluationAspect())) {
							
							if(((UsageScenarioRequirement)aspectContext.getRequirement()).getUsageScenario() == null) {
								//The criterion refers to EVERY US since none is explicitly specified
								for (Iterator<UsageScenario> iterator2 = scenarios.iterator(); iterator2.hasNext();) {
									UsageScenario usageScenario = (UsageScenario) iterator2
											.next();
									
									//FIXME: hardcoded usage scenario selection
									String scenName = usageScenario.getEntityName();
									if (scenName.contains("AlarmRetrieve") 
											|| scenName.contains("Wrapper")
											|| scenName.contains("HistoryRetrieve")){
										continue;
									}
									
									if(aspectContext.getCriterion() instanceof de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint) {
										UsageScenarioBasedInfeasibilityConstraint c = 
											reader.translateEvalAspectToInfeasibilityConstraint(aspectContext, usageScenario);
										
										constraints.add(c);
										constraintToAspect.put(c, aspectContext);
									} else {
										//instanceof Objective
										Objective o = reader.translateEvalAspectToObjective(this.getQualityAttribute(), aspectContext, usageScenario);
										objectives.add(o);
										objectiveToAspect.put(o, aspectContext); 
										
										UsageScenarioBasedSatisfactionConstraint c = 
												reader.translateEvalAspectToSatisfactionConstraint(aspectContext, o, usageScenario); 
										constraints.add(c);
										constraintToAspect.put(c, aspectContext);
									}
								}
							} else {
								if(aspectContext.getCriterion() instanceof de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint) {
									UsageScenarioBasedInfeasibilityConstraint c = 
										reader.translateEvalAspectToInfeasibilityConstraint(aspectContext, ((UsageScenarioRequirement)aspectContext.getRequirement()).getUsageScenario());
									constraints.add(c);
									constraintToAspect.put(c, aspectContext);
								} else {
									//instanceof Objective
									Objective o = reader.translateEvalAspectToObjective(this.getQualityAttribute(), aspectContext, ((UsageScenarioRequirement)aspectContext.getRequirement()).getUsageScenario());
									objectives.add(o);
									objectiveToAspect.put(o, aspectContext);
									
									UsageScenarioBasedSatisfactionConstraint c = 
											reader.translateEvalAspectToSatisfactionConstraint(aspectContext, o, 
											((UsageScenarioRequirement)aspectContext.getRequirement()).getUsageScenario());
									constraints.add(c);
									constraintToAspect.put(c, aspectContext);
								}
							}
							
						} else {
							//XXX: This should never be the case if the optimization is started with the LaunchConfig the aspect is checked there as well
							throw new RuntimeException("Evaluation aspect not supported("+aspectContext.getEvaluationAspect()+")!");
						}			
				
			} else {
				throw new RuntimeException("Unsupported Requirement!");
			}
		}
	}
	
	private boolean canEvaluateAspect(EvaluationAspect aspect){
		return lQNQualityAttribute.canEvaluateAspect(aspect);
	}
	
	//MOVED to PCMDeclarationsReader
//	public UsageScenarioBasedObjective translateEvalAspectToObjective(EvaluationAspectWithContext aspect, UsageScenario usageScenario){
//		//Make sure, the aspect IS an objective
//		try {
//			if(aspect.getDimension().getType().getRelationSemantics().getRelSem() == EnumRelationSemantics.DECREASING) {
//				return new UsageScenarioBasedObjective(this.getQualityAttribute(), Objective.Sign.MIN, usageScenario);
//			} else {
//				//INCREASING
//				return new UsageScenarioBasedObjective(this.getQualityAttribute(), Objective.Sign.MAX, usageScenario);
//			}
//		} catch (CoreException e) {
//			e.printStackTrace();
//			throw new RuntimeException("Could not get response time quality attribute!");
//		}
//	}
	
	public String getQualityAttribute() throws CoreException {
		//return DSEConstantsContainer.MEAN_RESPONSE_TIME_QUALITY;
		return lQNQualityAttribute.getDimension().getEntityName();
	}

	public abstract boolean hasStatisticResults() throws CoreException;
	
	@Override
	public List<Criterion> getCriterions() throws CoreException {
		List<Criterion> list = new ArrayList<Criterion>();
		list.addAll(this.objectives);
		list.addAll(this.constraints);
		return list;
	}
	
	@Override
	public void setBlackboard(MDSDBlackboard blackboard){
		this.blackboard = blackboard;
	}

}
