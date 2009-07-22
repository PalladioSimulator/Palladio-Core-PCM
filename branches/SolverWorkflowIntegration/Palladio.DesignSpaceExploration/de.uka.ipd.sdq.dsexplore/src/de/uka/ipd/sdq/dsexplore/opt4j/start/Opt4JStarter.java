package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.Status;
import org.opt4j.config.Task.State;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Value;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.Optimizer;
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
	
	public static IAnalysis perfAnalysisTool = null; 
	
	public static IAnalysis relAnalysisTool = null;
	
	public static CostEvaluator costEvaluator = null;
	
	public static DSEProblem problem = null;
	
	private static Opt4JTask task = null;
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");

	public static List<Value<Double>> upperConstraints;
	
	public static void init(IAnalysis perfAnalysisTool, IAnalysis relAnalysisTool, List<Value<Double>> upperConstraints, CostRepository costs, PCMInstance pcmInstance){
		
		Opt4JStarter.perfAnalysisTool = perfAnalysisTool;
		Opt4JStarter.relAnalysisTool = relAnalysisTool;
		Opt4JStarter.costEvaluator = new CostEvaluator(costs);
		Opt4JStarter.problem = new DSEProblem(pcmInstance);
		
		Opt4JStarter.upperConstraints = upperConstraints;
		
		
		Opt4JStarter.problem.saveProblem();
		
	}

	public static void startOpt4J(IAnalysis perfAnalysisTool,
			IAnalysis relAnalysisTool, PCMInstance pcmInstance, int maxIterations,
			int individualsPerGeneration, CostRepository costs, List<Value<Double>> upperConstraints, IProgressMonitor monitor)
			throws CoreException {


		init(perfAnalysisTool, relAnalysisTool, upperConstraints, costs, pcmInstance);
		
		Collection<Module> modules = new ArrayList<Module>();

		DSEModule dseModule = new DSEModule();
		modules.add(dseModule);
		
		addOptimisationModules(maxIterations, individualsPerGeneration,
				modules);
		
		addPopulationModule(modules);

		DSEListener listener = new DSEListener(monitor, maxIterations);
		runTask(modules, listener);
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
			Collection<Individual> archive = task.getInstance(Archive.class);
			ResultsWriter.printOutIndividuals(archive, "Archive");

			Collection<Individual> allIndividuals = task.getInstance(PopulationTracker.class);
			ResultsWriter.printOutIndividuals(allIndividuals, "All Individuals");
			
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
	
	public static Collection<Individual> getParetoOptimalIndividuals(){
		return task.getInstance(Archive.class);
	}
	
	public static Collection<Individual> getAllIndividuals(){
		return task.getInstance(PopulationTracker.class);
	}
	

	
}
