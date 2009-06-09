package de.uka.ipd.sdq.dsexplore.opt4j.start;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.core.runtime.Status;
import org.opt4j.common.archive.ArchiveModule;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.optimizer.ea.EvolutionaryAlgorithmModule;
import org.opt4j.optimizer.sa.SimulatedAnnealingModule;
import org.opt4j.start.Opt4J;
import org.opt4j.start.Opt4JTask;

import com.google.inject.Module;

import de.uka.ipd.sdq.dsexplore.PCMInstance;
import de.uka.ipd.sdq.dsexplore.analysis.AnalysisFailedException;
import de.uka.ipd.sdq.dsexplore.analysis.IAnalysis;
import de.uka.ipd.sdq.dsexplore.cost.CostEvaluator;
import de.uka.ipd.sdq.dsexplore.opt4j.archive.PopulationTracker;
import de.uka.ipd.sdq.dsexplore.opt4j.archive.PopulationTrackerModule;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEConstraint;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
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

	public static void startOpt4J(IAnalysis perfAnalysisTool,
			IAnalysis relAnalysisTool, PCMInstance pcmInstance, int maxIterations,
			int individualsPerGeneration, CostRepository costs, List<Value<Double>> upperConstraints)
			throws CoreException {

		Opt4JStarter.perfAnalysisTool = perfAnalysisTool;
		Opt4JStarter.relAnalysisTool = relAnalysisTool;
		Opt4JStarter.costEvaluator = new CostEvaluator(costs);
		Opt4JStarter.problem = new DSEProblem(pcmInstance);
		
		Opt4JStarter.upperConstraints = upperConstraints;
		
		
		Opt4JStarter.problem.saveProblem();
		

		DSEModule dseModule = new DSEModule();

		EvolutionaryAlgorithmModule ea = new EvolutionaryAlgorithmModule();
		ea.setGenerations(maxIterations);
		ea.setAlpha(individualsPerGeneration);
		ea.setLambda((int) Math.floor(individualsPerGeneration / 2.0 + 0.5));
		
		SimulatedAnnealingModule sa = new SimulatedAnnealingModule();
		sa.setIterations(maxIterations);


		/*
		 * GUIModule gui = new GUIModule(); gui.setCloseOnStop(true);
		 */

		// ArchiveModule am = new ArchiveModule();
		// am.setType(ArchiveModule.Type.);
		PopulationTrackerModule p = new PopulationTrackerModule();
		

		Collection<Module> modules = new ArrayList<Module>();
		modules.add(ea);
		modules.add(dseModule);
		modules.add(p);
		// modules.add(dtlz);
		// modules.add(gui);

		Opt4JStarter.task = new Opt4JTask(false);
		task.init(modules);

		try {
			task.execute();

		} catch (CoreException e) {
			throw e;
		} catch (Exception e) {
			throw new CoreException(new Status(Status.ERROR,
					"de.uka.ipd.sdq.dsexplore", 0, e.getMessage(), e));
		} finally {
			try {
			Collection<Individual> archive = task.getInstance(Archive.class);
			printOutIndividuals(archive, "Archive");

			Collection<Individual> allIndividuals = task.getInstance(PopulationTracker.class);
			printOutIndividuals(allIndividuals, "All Individuals");
			
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

	private static void printOutIndividuals(Collection<Individual> individuals,
			String collectionName) {
		logger.warn("------------ RESULTS " + collectionName
				+ " ----------------------");
		logger.warn("Printing results (number is " + individuals.size() + ").");
		
		List<Exception> exceptionList = new ArrayList<Exception>();
		
		int counter = 0;
		for (Individual individual : individuals) {
			try {
			printResultLineNatural(individual);
			} catch (Exception e){
				exceptionList.add(new Exception("Encountered corrupted result number "+counter+", skipped it", e));
			}
			counter++;
		}
		logger.warn("------------ CSV RESULTS " + collectionName
				+ " ----------------------");
		String output = "\n";

		output = printHeadlineCSV(individuals, output);
		counter = 0;

		// content
		for (Individual ind : individuals) {
			try {
			output = printResultLineCSV(output, ind);
			} catch (Exception e){
				exceptionList.add(new Exception("Encountered corrupted result number "+counter+", skipped it", e));
			}
			counter++;
		}
		logger.warn(output);
		
		logger.warn("------------ PRETTY CSV RESULTS " + collectionName
				+ " ----------------------");
		
		output = "\n";
		output = prettyPrintHeadlineCSV(individuals, output);
		counter = 0;

		// content
		for (Individual ind2 : individuals) {
			try {
			output = prettyPrintResultLineCSV(output, ind2);
			} catch (Exception e){
				exceptionList.add(new Exception("Encountered corrupted result number "+counter+", skipped it", e));
			}
			counter++;
		}
		logger.warn(output);
		
		if (exceptionList.size() > 0){
			logger.warn("Encountered exceptions while printing results");
			for (Exception exception : exceptionList) {
				exception.printStackTrace();
			}
		}
	}

	private static String prettyPrintResultLineCSV(String output, Individual ind) {
		
		DSEDecoder decoder = task.getInstance(DSEDecoder.class);
		
		// first objectives
		Objectives objs = ind.getObjectives();
		for (Entry<Objective, Value<?>> entry : objs) { 
			output += entry.getValue() + ";";
		}
		//then genes
		DoubleGenotype genes = (DoubleGenotype) ind.getGenotype();
		for (int i = 0; i < genes.size(); i++) {
			output += decoder.getDecisionString(i, genes.get(i))+";";
		}
		output += "\n";
		return output;
	}

	private static String prettyPrintHeadlineCSV(
			Collection<Individual> individuals, String output) {
		
		Individual i = individuals.iterator().next();
		output += printObjectives(i, output);
		
		output += Opt4JStarter.problem.toString();
		
		output += "\n";
		
		return output; 
	}

	private static void printResultLineNatural(Individual individual) {
		logger.warn("Result for individual "
				+ individual.getGenotype().toString() + " is: "
				+ individual.getObjectives().toString());
	}

	private static String printResultLineCSV(String output, Individual ind) {
		// first objectives
		Objectives objs = ind.getObjectives();
		for (Entry<Objective, Value<?>> entry : objs) {
			output += entry.getValue() + ";";
		}
		//then genes
		DoubleGenotype genes = (DoubleGenotype) ind.getGenotype();
		for (Double gene : genes) {
			output += gene + ";";
		}
		output += "\n";
		return output;
	}

	private static String printHeadlineCSV(Collection<Individual> individuals,
			String output) {
		{
			Individual i = individuals.iterator().next();
			
			// headline
			// first objectives
			output += printObjectives(i, output);
			// then genes
			DoubleGenotype genes = (DoubleGenotype) i.getGenotype();
			for (int j = 0; j < genes.size(); j++) {
				output += "gene" + j + ";";
			}
			output += "\n";
		}
		return output;
	}
	
	private static String printObjectives(Individual i,	String output) {
		Objectives objs = i.getObjectives();
		for (Entry<Objective, Value<?>> entry : objs) {
			output += entry.getKey().getName() + "("
					+ entry.getKey().getSign() + ");";
		}
		return output;
	}

	public static void closeTask(){
      Opt4JStarter.task.close(); 
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
}
