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
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.launch.DSEConstantsContainer.QualityAttribute;
import de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.EvaluationAspect;
import de.uka.ipd.sdq.dsexplore.qml.contracttype.QMLContractType.Dimension;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.EvaluationAspectWithContext;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedCriterion;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedInfeasibilityConstraint;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedObjective;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedSatisfactionConstraint;
import de.uka.ipd.sdq.dsexplore.qml.pcm.reader.PCMDeclarationsReader;
import de.uka.ipd.sdq.dsexplore.qml.profile.QMLProfile.EntryLevelSystemCallRequirement;
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

	protected LQNQualityAttributeDeclaration lQNQualityAttribute = new LQNQualityAttributeDeclaration();
	
	//Criteria handling
	private List<Criterion> criteriaList = new ArrayList<Criterion>();
	protected Map<Criterion, EvaluationAspectWithContext> criterionToAspect = new HashMap<Criterion, EvaluationAspectWithContext>(); //This is needed to determine, what THE result is (Mean,  Variance, ...)
	

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
	public void initialise(DSEWorkflowConfiguration configuration) throws CoreException {
		this.config = configuration.getRawConfiguration();
		
		PCMInstance pcmInstance = new PCMInstance((PCMResourceSetPartition)this.blackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID));
		List<UsageScenario> scenarios = pcmInstance.getUsageModel().getUsageScenario_UsageModel();
		
		initialiseCriteria(this.config, scenarios);

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
		
		List<Dimension> dimensions = this.lQNQualityAttribute.getDimensions();
		
		List<EvaluationAspectWithContext> responseTimeAspect = new ArrayList<EvaluationAspectWithContext>(6);
		for (Dimension dimension : dimensions) {
			responseTimeAspect.addAll(reader.getDimensionConstraintContextsForUsageModel(usageModel, dimension.getId()));
			responseTimeAspect.addAll(reader.getDimensionObjectiveContextsForUsageModel(usageModel, dimension.getId()));
		}
		
		//Check constraint aspects and create Constraint-Objects for every Aspect
		for (Iterator<EvaluationAspectWithContext> iterator = responseTimeAspect.iterator(); iterator.hasNext();) {
			EvaluationAspectWithContext aspectContext = iterator
					.next();
			//handle possible aspects here
			if (canEvaluateAspect(aspectContext.getEvaluationAspect(), aspectContext.getDimension())) {

				if(aspectContext.getRequirement() instanceof UsageScenarioRequirement) {  

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

								criteriaList.add(c);
								criterionToAspect.put(c, aspectContext);
							} else {
								//instanceof Objective
								Objective o = reader.translateEvalAspectToObjective(this.getQualityAttribute().getName(), aspectContext, usageScenario);
								criteriaList.add(o);
								criterionToAspect.put(o, aspectContext); 

								UsageScenarioBasedSatisfactionConstraint c = 
									reader.translateEvalAspectToSatisfactionConstraint(aspectContext, o, usageScenario); 
								criteriaList.add(c);
								criterionToAspect.put(c, aspectContext);
							}
						}
					} else {
						if(aspectContext.getCriterion() instanceof de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint) {
							UsageScenarioBasedInfeasibilityConstraint c = 
								reader.translateEvalAspectToInfeasibilityConstraint(aspectContext, ((UsageScenarioRequirement)aspectContext.getRequirement()).getUsageScenario());
							criteriaList.add(c);
							criterionToAspect.put(c, aspectContext);
						} else {
							//instanceof Objective
							Objective o = reader.translateEvalAspectToObjective(this.getQualityAttribute().getName(), aspectContext, ((UsageScenarioRequirement)aspectContext.getRequirement()).getUsageScenario());
							criteriaList.add(o);
							criterionToAspect.put(o, aspectContext);

							UsageScenarioBasedSatisfactionConstraint c = 
								reader.translateEvalAspectToSatisfactionConstraint(aspectContext, o, 
										((UsageScenarioRequirement)aspectContext.getRequirement()).getUsageScenario());
							criteriaList.add(c);
							criterionToAspect.put(c, aspectContext);
						}
					}

//				} else if (aspectContext.getRequirement() instanceof EntryLevelSystemCallRequirement) {
//					if(aspectContext.getCriterion() instanceof de.uka.ipd.sdq.dsexplore.qml.contract.QMLContract.Constraint) {
//						UsageScenarioBasedInfeasibilityConstraint c = 
//							reader.translateEvalAspectToInfeasibilityConstraint(aspectContext, ((EntryLevelSystemCallRequirement)aspectContext.getRequirement()).getEntryLevelSystemCall());
//						criteriaList.add(c);
//						criterionToAspect.put(c, aspectContext);
//					} else {
//						//instanceof Objective
//						Objective o = reader.translateEvalAspectToObjective(this.getQualityAttribute().getName(), aspectContext, ((EntryLevelSystemCallRequirement)aspectContext.getRequirement()).getEntryLevelSystemCall());
//						criteriaList.add(o);
//						criterionToAspect.put(o, aspectContext);
//
//						UsageScenarioBasedSatisfactionConstraint c = 
//							reader.translateEvalAspectToSatisfactionConstraint(aspectContext, o, 
//									((UsageScenarioRequirement)aspectContext.getRequirement()).getUsageScenario());
//						criteriaList.add(c);
//						criterionToAspect.put(c, aspectContext);
//					}

				} else {
					throw new RuntimeException("Unsupported Requirement!");
				}
			} else {
				//XXX: This should never be the case if the optimization is started with the LaunchConfig the aspect is checked there as well
				throw new RuntimeException("Evaluation aspect not supported("+aspectContext.getEvaluationAspect()+")!");
			}
		}
	}
	
	private boolean canEvaluateAspect(EvaluationAspect aspect, Dimension dimension){
		return lQNQualityAttribute.canEvaluateAspectForDimension(aspect, dimension);
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
	
	public QualityAttribute getQualityAttribute() throws CoreException {
		//return DSEConstantsContainer.MEAN_RESPONSE_TIME_QUALITY;
		return lQNQualityAttribute.getQualityAttribute();
	}

	public abstract boolean hasStatisticResults() throws CoreException;
	
	@Override
	public List<Criterion> getCriterions() throws CoreException {
		List<Criterion> list = new ArrayList<Criterion>();
		list.addAll(this.criteriaList);
		return list;
	}
	
	@Override
	public void setBlackboard(MDSDBlackboard blackboard){
		this.blackboard = blackboard;
	}

}
