package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.opt4j.common.archive.BoundedArchive;
import org.opt4j.common.archive.CrowdingArchive;
import org.opt4j.common.archive.DefaultArchive;
import org.opt4j.config.Task;
import org.opt4j.config.Task.State;
//import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualFactory;
//import org.opt4j.core.IndividualFactory;
//import org.opt4j.core.IndividualSet;
//import org.opt4j.core.IndividualSetListener;
import org.opt4j.core.Objective;
//import org.opt4j.core.optimizer.Population;
import org.opt4j.core.Value;
import org.opt4j.core.domination.ConstraintDominationModule;
import org.opt4j.core.domination.ConstraintDominationModule.Strategy;
//import org.opt4j.core.optimizer.IndividualCompleter;
import org.opt4j.core.optimizer.Archive;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.IndividualCompleter;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.Population;
import org.opt4j.core.problem.Evaluator;
import org.opt4j.optimizer.ea.EvolutionaryAlgorithmModule;
import org.opt4j.optimizer.ea.ScalingNsga2Module;
//import org.opt4j.optimizer.ea.ScalingNsga2Module;
import org.opt4j.optimizer.rs.RandomSearchModule;
import org.opt4j.start.Opt4J;
import org.opt4j.start.Opt4JTask;

import com.google.inject.Module;

import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.exception.ExceptionHelper;
import de.uka.ipd.sdq.dsexplore.helper.GenotypeReader;
import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.launch.DSEWorkflowConfiguration;
import de.uka.ipd.sdq.dsexplore.opt4j.archive.PopulationTracker;
import de.uka.ipd.sdq.dsexplore.opt4j.archive.PopulationTrackerModule;
import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSECreator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvolutionaryAlgorithmModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividual;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEIndividualFactory;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEMutateModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEProblem;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.GivenInstanceModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.RuleBasedSearchModule;
import de.uka.ipd.sdq.dsexplore.qml.pcm.datastructures.UsageScenarioBasedObjective;
import de.uka.ipd.sdq.pcm.cost.CostRepository;
import de.uka.ipd.sdq.pcm.designdecision.Choice;
import de.uka.ipd.sdq.pcmsolver.models.PCMInstance;
import de.uka.ipd.sdq.tcfmoop.config.GivenParetoFrontIsReachedConfig;
import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig;
import de.uka.ipd.sdq.tcfmoop.config.MinimalQualityCriteriaValueConfig;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig.UnresolvedValueDifference;
import de.uka.ipd.sdq.tcfmoop.config.InsignificantSetQualityImprovementConfig.ValueDifference;
import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;
import de.uka.ipd.sdq.tcfmoop.tcmanager.TerminationCriteriaManager;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;

//import org.aopalliance.intercept.MethodInterceptor;

/**
 * Main class to start the whole Opt4J stuff. 
 * 
 * TODO: Make this a Singleton instead of static? Even better: Handle the global stuff properly. Similar to SimuComModel.
 * @author martens
 *
 */
public class Opt4JStarter {
	
	private static DSEProblem problem = null;
	private static DSECreator creator = null;
	
	private static Opt4JTask task = null;
	
	private static DSEWorkflowConfiguration myDSEConfig = null;

	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter");

	private static List<ResultsWriter> writers = null;
	
	public static void init(List<IAnalysis> evaluators, DSEWorkflowConfiguration dseConfig, PCMInstance pcmInstance, IProgressMonitor monitor, MDSDBlackboard blackboard) throws CoreException{
		
		Opt4JStarter.myDSEConfig = dseConfig;
		
		Collection<Module> modules = new ArrayList<Module>();

		DSEModule dseModule = new DSEModule();
		modules.add(dseModule);

		addOptimisationModules(dseConfig.getMaxIterations(), dseConfig,
				modules);

		addPopulationModule(modules);
		

		ConstraintDominationModule m = new ConstraintDominationModule();
		m.setStrategyForFeasibleSolutions(Strategy.GoalAttainmentDomination);
		modules.add(m); //XXX:
		//Don't forget to disable cache in GenotypReader.java if using constraints... 
		//Check QML declarations	
		
		// set tournament value because default of 0 is stupid.
		ScalingNsga2Module nsgaModule = new ScalingNsga2Module();
		nsgaModule.setTournament(3);
		modules.add(nsgaModule);
		
		openTask(modules);
		
		Opt4JStarter.writers = new LinkedList<ResultsWriter>();
		
		Opt4JStarter.problem = new DSEProblem(dseConfig, pcmInstance);
		if (dseConfig.isNewProblem()){
			Opt4JStarter.problem.saveProblem();
		} 
		
		GenotypeReader.setTask(task); //QUICKHACK
		
		DSEEvaluator ev = task.getInstance(DSEEvaluator.class);
		ev.init(evaluators, monitor,blackboard, dseConfig.isStopOnInitialFailure());
		
		//Termination Criteria Manager Initializitation if needed
		if(myDSEConfig.getUseTerminationCriteria()){
			TerminationCriteriaManager tcm = task.getInstance(TerminationCriteriaManager.class);
			
			resolveObjectivesForTCM();
			
			tcm.initialize(myDSEConfig.getTCConfigurations());
			
			if(myDSEConfig.getActivateComposedTerminationCriteria()){
				tcm.activateComposedCriterion();
				tcm.setComposedCriterionExpression(myDSEConfig.getComposedCriteriaExpression());
			}
			
			if(myDSEConfig.getRunInComparisionMode()){
				tcm.activateTCComparisionMode();
			}
			
		}
		
	}

	public static void openTask(Collection<Module> modules) {
		Opt4JStarter.task = new Opt4JTask(false);
		task.init(modules);
		task.open();
	}
		
	/**
	 * Only starts Opt4J, needs call to {@link Opt4JStarter#init(IAnalysis, IAnalysis, List, CostRepository, PCMInstance, boolean)} first.
	 * @param dseConfig
	 *@param monitor
	 * @param genotypes May be null
	 * @param allCandidates 
	 * @param archiveCandidates 
	 * @throws CoreException
	 */
	public static void runOpt4JWithPopulation(
			DSEWorkflowConfiguration dseConfig, 
			IProgressMonitor monitor,
			List<DesignDecisionGenotype> genotypes, 
			List<DesignDecisionGenotype> allCandidates, List<DesignDecisionGenotype> archiveCandidates) throws CoreException {
		
		if (Opt4JStarter.problem == null){
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, "Opt4JStarter has not been properly initialised. Contact developers.", null));
		}
		
		if (genotypes != null && genotypes.size() > 0){
			Opt4JStarter.problem.setInitialPopulation(genotypes);
		}
		
		DSEListener listener = new DSEListener(monitor,dseConfig);
		runTask(listener, dseConfig, allCandidates, archiveCandidates);

	}

	/**
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * @param listener
	 * @param dseConfig
	 * @param allCandidates may be null
	 * @param archiveCandidates 
	 * @throws CoreException
	 */
	private static void runTask(DSEListener listener, DSEWorkflowConfiguration dseConfig, List<DesignDecisionGenotype> allCandidates, List<DesignDecisionGenotype> archiveCandidates)
			throws CoreException {
		
		try {
			Opt4JStarter.creator = task.getInstance(DSECreator.class);
			Optimizer opt = task.getInstance(Optimizer.class);
			opt.addOptimizerIterationListener(listener);
			IndividualFactory indivBuilder = getIndividualFactory();
			//indivBuilder.addIndividualStateListener(new DSEIndividualStateListener(dseConfig));
			
			//add the previously defined all candidates to the custom PopulationTracker archive, 
			PopulationTracker populationTracker = getAllIndividuals();
			Archive archive = getArchiveIndividuals();
			IndividualCompleter completer = task.getInstance(IndividualCompleter.class);
			if (allCandidates != null && allCandidates.size() > 0){
				if (indivBuilder instanceof DSEIndividualFactory){
					logger.debug("Reading in predefined all candidates.");
					DSEIndividualFactory dseBuilder = (DSEIndividualFactory)indivBuilder;
					for (DesignDecisionGenotype designDecisionGenotype : allCandidates) {
						DSEIndividual individual = dseBuilder.create(designDecisionGenotype);
						completer.complete(individual);
						populationTracker.addIndividualsManually(individual);
					}
					logger.debug("Finished reading in predefined all candidates.");
					
					logger.debug("Reading in archive candidates to add them to Archive");
				
					try {
						for (DesignDecisionGenotype designDecisionGenotype : archiveCandidates) {
							Individual individual = dseBuilder.create(designDecisionGenotype);
							completer.complete(individual);
							archive.add(individual);
						}
					} catch (Exception e) {
						throw new CoreException(new Status(Status.ERROR,
								"de.uka.ipd.sdq.dsexplore", 0, "Cannot archive candidates to archive "+archive.getClass().getSimpleName()+". Maybe too many? Reason: " + e.getMessage(), e));
					}
					logger.debug("Finished reading in archive candidates");
					
				}
				
			}
			
			task.execute();
			
			
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, e.getMessage(), e));
		} finally {

			DSEEvaluator evaluator = task.getInstance(DSEEvaluator.class);
			List<Exception> exceptions = evaluator.getExceptionList();

			try {

				
//				PopulationTracker allIndividuals = getAllIndividuals();
//				ResultsWriter.printOutIndividuals(allIndividuals.getIndividuals(), "All Individuals");
//				
//				ResultsWriter.printOutIndividuals(allIndividuals.getParetoOptimalIndividuals(), "Own Optimal Candidates");

				// final iteration as csv
				Optimizer opt = task.getInstance(Optimizer.class);
				int iteration = opt.getIteration();

				ResultsWriter.writeDSEIndividualsToFile(Opt4JStarter.getPopulationIndividuals(), dseConfig.getResultFolder()+"population", iteration, true, true, exceptions);
				ResultsWriter.writeIndividualsToFile(Opt4JStarter.getArchiveIndividuals(), dseConfig.getResultFolder()+"archiveCandidates", iteration, exceptions, true, true);	

			} catch (Exception e){
				logger.error("Optimisation failed, I could not save the last results.");
				e.printStackTrace();
			}
			
			String config = dseConfig.getOriginalConfiguration().getMemento();
			ResultsWriter.writeStringToFile("config", config, listener.getIteration(), exceptions, ".txt");
			
			if (exceptions.size() > 0){
				logger.warn("Errors occured during evaluation.");
				for (Exception exception : exceptions) {
					exception.printStackTrace();
				}
			}
			
		}
	}

	/**
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * @return
	 * @throws CoreException 
	 */
	public static DSEIndividualFactory getIndividualFactory() throws CoreException {
		if (task != null){
			IndividualFactory indivBuilder = task.getInstance(IndividualFactory.class);
			if (!(indivBuilder instanceof DSEIndividualFactory)){
				ExceptionHelper.createNewInitialisationException("Internal Error: IndividualFactory is not a DSEIndividualFactory, Opt4JStarter has not properly been initialised.");
			}
			return (DSEIndividualFactory)indivBuilder;
		} else 
			throw ExceptionHelper.createNewInitialisationException("Internal Error: Cannot access IndividualFactory, Opt4JStarter has not properly been initialised.");
	}

	private static void addPopulationModule(Collection<Module> modules) {
		// ArchiveModule am = new ArchiveModule();
		// am.setType(ArchiveModule.Type.);
		PopulationTrackerModule p = new PopulationTrackerModule();
		
		modules.add(p);
		// modules.add(dtlz);
		// modules.add(gui);
	}
		
	private static void addOptimisationModules(int maxIterations,
			DSEWorkflowConfiguration config,
			Collection<Module> modules) throws CoreException {
		
		int individualsPerGeneration = config.getIndividualsPerGeneration();
		double crossoverRate = config.getCrossoverRate();
		
		if (config.getMaxIterations() == 0 && config.hasPredefinedInstances()){
			GivenInstanceModule givenInstanceModule = new GivenInstanceModule();
			modules.add(givenInstanceModule);
		} else if (config.isRuleBasedSearch()){
			RuleBasedSearchModule rbModule = new RuleBasedSearchModule();
			rbModule.setGenerations(maxIterations);
			rbModule.setFullSearch(config.isFullRuleBasedSearch());
			modules.add(rbModule);
		} else if (config.isRandomSearch()){
			RandomSearchModule rsm = new RandomSearchModule(){
				@Override
				public void config(){
					super.config();
					bind(IndividualFactory.class).to(DSEIndividualFactory.class);
				}
			};
			rsm.setBatchsize(config.getIndividualsPerGeneration());
			rsm.setIterations(maxIterations);
			modules.add(rsm);
		} else {
			EvolutionaryAlgorithmModule ea = new DSEEvolutionaryAlgorithmModule();
			ea.setGenerations(maxIterations);
			ea.setAlpha(individualsPerGeneration);
			ea.setLambda((int) Math.floor(individualsPerGeneration / 2.0 + 0.5));
			ea.setCrossoverRate(crossoverRate);
			
			DSEMutateModule mutation = new DSEMutateModule();
			// adaptive rate uses 1/genotype length * mutation intensity, so we use that, too
			// is only set once per run, so genotypes of changing length are not supported.
			mutation.setMutationIntensity(3);
			
			/*		SimulatedAnnealingModule sa = new SimulatedAnnealingModule();
			sa.setIterations(maxIterations);*/


			/*
			 * GUIModule gui = new GUIModule(); gui.setCloseOnStop(true);
			 */
			modules.add(ea);
		}
	}


	public static void closeTask(){
		if (Opt4JStarter.task != null){
			Opt4JStarter.task.close(); 
			}
		}
		
	@Deprecated
	public static void startOpt4JWithGUI(){
		//String id = Opt4JPluginActivator.PLUGIN_ID;
		
			try {
			Opt4J.main(new String[0]);
			
			} catch (Exception e){
			// TODO Auto-generated catch block
			e.printStackTrace();
			}
		
			}

	public synchronized static void terminate (){
		if (task != null && !task.getState().equals(State.DONE)){
			Control control = task.getInstance(Control.class);
			control.doTerminate();	
			logger.warn("Terminating run");
		} else {
			logger.warn("Cannot terminate as no task is executing");
		}
		}

	/**
	 * Returns the instance of {@link Archive} from the Opt4J {@link Task},
	 *  which is a {@link DefaultArchive} inheriting from 
	 *  {@link CrowdingArchive} and {@link BoundedArchive}.  
	 * 
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * 
	 * @return
	 */
	public static Archive getArchiveIndividuals(){
		return task.getInstance(Archive.class);
	}

	/**
	 * Returns the instance of {@link Population} from the Opt4J {@link Task}, 
	 * which is a plain {@link IndividualSet}.
	 * 
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 *   
	 * @return
	 */
	public static List<DSEIndividual> getPopulationIndividuals(){
		Population p = task.getInstance(Population.class);
		List<DSEIndividual> individuals = new ArrayList<DSEIndividual>(p.size());
		for (Individual individual : p) {
			if (individual instanceof DSEIndividual){
				individuals.add((DSEIndividual) individual);
			} else {
				logger.error("There was an illegal individual that is not instance of DSEIndividual. Ignoring it. "+individual.toString());
			}
		}
		return individuals; 
	}

	/**
	 * Returns the instance of {@link PopulationTracker} from the Opt4J {@link Task}, 
	 * which is an {@link IndividualSetListener} that listens on the 
	 * {@link Population} instance from the Opt4J {@link Task}.  
	 * 
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * 
	 * @return
	 */
	public static PopulationTracker getAllIndividuals(){
		return task.getInstance(PopulationTracker.class);
		}
	
	public static void tearDown(){
		
		for (ResultsWriter writer : writers) {
			writer.close();
		}
		
		writers = null;
			
		problem = null;
		
		creator = null;
	
		task = null;

		}

	/**
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * @param writer
	 */
	public static void registerWriter(ResultsWriter writer) {
		writers.add(writer);
		
	}

	public static Choice createRandomGene(int index, DesignDecisionGenotype genotype) {
		if (Opt4JStarter.creator != null){
			return Opt4JStarter.creator.createRandomChoice(genotype.get(index).getDegreeOfFreedomInstance());
		} else {
			logger.error("Could not create random value as DSECreator is not available.");
			throw new RuntimeException("Could not create random value as DSECreator is not available.");
		}
		
	}

	/**
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * If not, this returns null. 
	 * @return the problem or null.
	 */
	public static DSEProblem getProblem() {
		return problem;
	}
	
	/**
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * @return
	 * @throws CoreException
	 */
	public static DSEEvaluator getDSEEvaluator() throws CoreException{
		Evaluator<?> e = task.getInstance(Evaluator.class);
		if (e != null && e instanceof DSEEvaluator){
			return (DSEEvaluator)e;
		} else {
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", "Wrong initialisation of Evaluator: class DSEEvaluator expected, but found "+e == null ? "null" : e.getClass().getName()));
		}
	}
	
	/**
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * @return
	 * @throws CoreException
	 */
	public static DSEDecoder getDSEDecoder() throws CoreException{
		DSEDecoder e = task.getInstance(DSEDecoder.class);
		if (e != null){
			return e;
		} else {
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", "Wrong initialisation of Decoder: class DSEDecoder expected, but found null"));
		}
	}

	/**
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * @return the {@link DSEWorkflowConfiguration} or null is init has not been called before. 
	 */
	public static DSEWorkflowConfiguration getDSEWorkflowConfig() {
		return myDSEConfig;
	}
	
	/**
	 * Can only be called after calling {@link Opt4JStarter#init(List, DSEWorkflowConfiguration, PCMInstance, IProgressMonitor, MDSDBlackboard)}.
	 * @return
	 * @throws CoreException
	 */
	public static DSECreator getDSECreator() throws CoreException{
		DSECreator e = task.getInstance(DSECreator.class);
		if (e != null){
			return e;
		} else {
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", "Wrong initialisation of Decoder: class DSEDecoder expected, but found null"));
		}
	}
	
	/**
	 * Resolves Objectives in the Configuration classes by using their String representation.
	 * Also Builds a Pareto Front for the "A Given Pareto Front Is Reached" from a file if needed.
	 * @author Atanas Dimitrov
	 * @throws CoreException
	 */
	private static void resolveObjectivesForTCM() throws CoreException {

		for (IConfiguration conf : myDSEConfig.getTCConfigurations()) {

			switch (conf.getTerminationCriterionName()) {
			
			case MINIMAL_QUALITY_CIRTERIA_VALUE:
				Map<String, Value<?>> unresolvedObjectiveMap = ((MinimalQualityCriteriaValueConfig) conf).getUnresolvedObjectiveMinimalValue();
				
				if (unresolvedObjectiveMap != null && !unresolvedObjectiveMap.isEmpty()) {
					
					Collection<Objective> objectives = Opt4JStarter.getDSEEvaluator().getObjectives();
					Set<String> unresolvedObjectives = unresolvedObjectiveMap.keySet();
					Map<Objective, Value<?>> configuredObjectives = new HashMap<Objective, Value<?>>();
					
					
					for (String unresolveObjective : unresolvedObjectives) {
						for (Objective o : objectives) {
							if(o instanceof UsageScenarioBasedObjective){
								if (unresolveObjective.contains(((UsageScenarioBasedObjective)o).getUsageScenario().getId())) {
									configuredObjectives.put(o, unresolvedObjectiveMap.get(unresolveObjective));
									break;
								}
							}else{
								if (o.getName().contains(unresolveObjective) || unresolveObjective.contains(o.getName())) {
									configuredObjectives.put(o, unresolvedObjectiveMap.get(unresolveObjective));
									break;
								}
							}
							
						}
					}
					
					unresolvedObjectiveMap.clear();
					
					try {
						((MinimalQualityCriteriaValueConfig) (conf)).setObjectiveMinimalValues(configuredObjectives);
					} catch (InvalidConfigException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
				
				break;
			
			case INSIGNIFICANT_SET_QUALITY_IMPROVEMENT:
				List<UnresolvedValueDifference> unresolvedValueDifferences = ((InsignificantSetQualityImprovementConfig) conf).getUnresolvedValueDifferences();

				if(unresolvedValueDifferences != null && !unresolvedValueDifferences.isEmpty()){
					Collection<Objective> objectives = Opt4JStarter.getDSEEvaluator().getObjectives();
					List<ValueDifference> valueDifferences = new LinkedList<ValueDifference>();
					
					for(UnresolvedValueDifference uvd : unresolvedValueDifferences){
						
						for (Objective o : objectives) {
							if(o instanceof UsageScenarioBasedObjective){
								if (uvd.objective.contains(((UsageScenarioBasedObjective)o).getUsageScenario().getId())) {
									try {
										valueDifferences.add(((InsignificantSetQualityImprovementConfig) conf).new ValueDifference(o, uvd.averageImprovement, uvd.maxMinImprovement));
									} catch (InvalidConfigException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								}
							}else{
								if (o.getName().contains(uvd.objective) || uvd.objective.contains(o.getName())) {
									try {
										valueDifferences.add(((InsignificantSetQualityImprovementConfig) conf).new ValueDifference(o, uvd.averageImprovement, uvd.maxMinImprovement));
									} catch (InvalidConfigException e) {
										// TODO Auto-generated catch block
										e.printStackTrace();
									}
									break;
								}
							}
						}
						
					}
					
					unresolvedValueDifferences.clear();
					
					try {
						((InsignificantSetQualityImprovementConfig) conf).setValueDifferences(valueDifferences);
					} catch (InvalidConfigException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				}				
				
				break;
			
			case GIVEN_PARETO_FRONT_IS_REACHED:

				String filePath = ((GivenParetoFrontIsReachedConfig) conf).getParetoFrontFile();
					
				if(filePath != null && !filePath.isEmpty()){
					try {
						((GivenParetoFrontIsReachedConfig) conf).setParetoFront(GenotypeReader.getObjectives(filePath));
					} catch (InvalidConfigException e) {
						e.printStackTrace();
					}
				}
				
				((GivenParetoFrontIsReachedConfig) conf).setParetoFrontFile("");
				
				break;
			}

		}

	}
}
	
		
