package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.opt4j.common.archive.BoundedArchive;
import org.opt4j.common.archive.CrowdingArchive;
import org.opt4j.common.archive.DefaultArchive;
import org.opt4j.config.Task;
import org.opt4j.config.Task.State;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualCollection;
import org.opt4j.core.IndividualCollectionListener;
import org.opt4j.core.Population;
import org.opt4j.core.Value;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.optimizer.ea.EvolutionaryAlgorithmModule;
import org.opt4j.optimizer.sa.SimulatedAnnealingModule;
import org.opt4j.start.Opt4J;
import org.opt4j.start.Opt4JTask;

import com.google.inject.Module;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.cost.CostEvaluator;
import de.uka.ipd.sdq.dsexplore.helper.ResultsWriter;
import de.uka.ipd.sdq.dsexplore.opt4j.archive.PopulationTracker;
import de.uka.ipd.sdq.dsexplore.opt4j.archive.PopulationTrackerModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEProblem;
import de.uka.ipd.sdq.pcm.cost.CostRepository;

public class Opt4JStarter {
	
	public static List<IAnalysis> evaluators = null; 
	
	public static DSEProblem problem = null;
	
	private static Opt4JTask task = null;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public static List<Value<Double>> upperConstraints;
	
	public static void init(List<IAnalysis> evaluators, List<Value<Double>> upperConstraints, PCMInstance pcmInstance, boolean newProblem) throws CoreException{
		
		Opt4JStarter.evaluators = evaluators;
		Opt4JStarter.upperConstraints = upperConstraints;
		
		if (newProblem){
			Opt4JStarter.problem = new DSEProblem(pcmInstance);
			Opt4JStarter.problem.saveProblem();
		} else {
			Opt4JStarter.problem = new DSEProblem(pcmInstance, false);
		}
		
	}
	
	/**
	 * Only starts Opt4J, needs can to {@link Opt4JStarter#init(IAnalysis, IAnalysis, List, CostRepository, PCMInstance, boolean)} first.
	 * @param maxIterations
	 * @param individualsPerGeneration
	 * @param monitor
	 * @param genotypes May be null
	 * @throws CoreException
	 */
	public static void runOpt4JWithPopulation(
			int maxIterations, int individualsPerGeneration,
			IProgressMonitor monitor,
			List<DoubleGenotype> genotypes) throws CoreException {
		
		if (Opt4JStarter.evaluators == null
				||	  Opt4JStarter.problem == null){
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, "Opt4JStarter has not been properly initialised. Contact developers.", null));
		}
		
		//TODO put initial population in Problem.
		if (genotypes != null && genotypes.size() > 0){
			Opt4JStarter.problem.setInitialPopulation(genotypes);
		}
		
		Collection<Module> modules = new ArrayList<Module>();

		DSEModule dseModule = new DSEModule();
		modules.add(dseModule);
		
		addOptimisationModules(maxIterations, individualsPerGeneration,
				modules);
		
		addPopulationModule(modules);

		DSEListener listener = new DSEListener(monitor, maxIterations);
		runTask(modules, listener);
		
	}

	/**
	 * inits and starts Opt4J
	 * @param perfAnalysisTool
	 * @param relAnalysisTool
	 * @param pcmInstance
	 * @param maxIterations
	 * @param individualsPerGeneration
	 * @param upperConstraints
	 * @param monitor
	 * @param newProblem
	 * @throws CoreException
	 */
	public static void initAndStartOpt4J(List<IAnalysis> evaluators, PCMInstance pcmInstance, int maxIterations,
			int individualsPerGeneration, List<Value<Double>> upperConstraints, IProgressMonitor monitor, boolean newProblem)
			throws CoreException {
		
		init(evaluators, upperConstraints, pcmInstance, newProblem);
		runOpt4JWithPopulation(maxIterations, individualsPerGeneration, monitor, null);

	}

	private static void runTask(Collection<Module> modules, DSEListener listener)
			throws CoreException {
		Opt4JStarter.task = new Opt4JTask(false);
		task.init(modules);

		try {
			task.open();
			Optimizer opt = task.getInstance(Optimizer.class);
			opt.addOptimizerIterationListener(listener);
			
			task.execute();
			
			
		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, e.getMessage(), e));
		} finally {
			try {

				ResultsWriter resultsWriter = new ResultsWriter(); 
				
			Collection<Individual> archive = getArchiveIndividuals();
			resultsWriter.printOutIndividuals(archive, "NGSA2Archive");

			PopulationTracker allIndividuals = getAllIndividuals();
			resultsWriter.printOutIndividuals(allIndividuals, "All Individuals");
			
			resultsWriter.printOutIndividuals(allIndividuals.getParetoOptimalIndividuals(), "Own Optimal Candidates");
			
			} catch (Exception e){
				logger.error("Optimisation failed, I could not save the results.");
				e.printStackTrace();
			}
			
			DSEEvaluator evaluator = task.getInstance(DSEEvaluator.class);
			List<Exception> exceptions = evaluator.getExceptionList();
			if (exceptions.size() > 0){
				logger.warn("Errors occured during evaluation.");
				for (Exception exception : exceptions) {
					exception.printStackTrace();
				}
			}
		}
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
			int individualsPerGeneration, Collection<Module> modules) {
		EvolutionaryAlgorithmModule ea = new EvolutionaryAlgorithmModule();
		ea.setGenerations(maxIterations);
		ea.setAlpha(individualsPerGeneration);
		ea.setLambda((int) Math.floor(individualsPerGeneration / 2.0 + 0.5));
		
		SimulatedAnnealingModule sa = new SimulatedAnnealingModule();
		sa.setIterations(maxIterations);


		/*
		 * GUIModule gui = new GUIModule(); gui.setCloseOnStop(true);
		 */
		modules.add(ea);
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
			
		} catch (Exception e) {
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
	 * @return
	 */
	public static Archive getArchiveIndividuals(){
		return (Archive)task.getInstance(Archive.class);
	}
	
	/**
	 * Returns the instance of {@link Population} from the Opt4J {@link Task}, 
	 * which is a plain {@link IndividualCollection}.  
	 * @return
	 */
	public static Population getPopulationIndividuals(){
		return (Population)task.getInstance(Population.class);
	}
	
	/**
	 * Returns the instance of {@link PopulationTracker} from the Opt4J {@link Task}, 
	 * which is an {@link IndividualCollectionListener} that listens on the 
	 * {@link Population} instance from the Opt4J {@link Task}.  
	 * @return
	 */
	public static PopulationTracker getAllIndividuals(){
		return (PopulationTracker)task.getInstance(PopulationTracker.class);
	}
	
	public static void tearDown(){
		evaluators = null;
		
		problem = null;
		
		task = null;
		
		upperConstraints = null;
	}


	

	
}
