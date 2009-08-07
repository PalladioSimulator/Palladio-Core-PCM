package de.uka.ipd.sdq.dsexplore.helper;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.opt4j.core.Individual;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;

/**
 * XXX: Maybe make this a proper label provider for the results? Metamodel results?
 * @author Anne
 *
 */
public class ResultsWriter {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore");
	
	public static void writeIndividualsToFile(Collection<Individual> individuals, String filename, int iteration,
			List<Exception> exceptionList){
				String results = addResultsToString(individuals, exceptionList);
				writeToFile(filename, results, iteration, exceptionList);
			}

	private static String addResultsToString(Collection<Individual> individuals,
			List<Exception> exceptionList) {
		String output = ""; 
		output = prettyPrintHeadlineCSV(individuals, output);
		int counter = 0;

		// content
		for (Individual ind2 : individuals) {
			try {
			output = prettyPrintResultLineCSV(output, ind2);
			} catch (Exception e){
				exceptionList.add(new Exception("Encountered corrupted result number "+counter+", skipped it", e));
			}
			counter++;
		}
		return output;
	}

	private static void writeToFile(String filename, String output, int iteration, List<Exception> exceptionList) {
		filename = filename + iteration + ".csv";
		try {
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(filename)));
			
			w.write(output);
			
			w.flush();
			
			w.close();
		} catch (FileNotFoundException e) {
			exceptionList.add(e);
			e.printStackTrace();
		} catch (IOException e) {
			exceptionList.add(e);
			e.printStackTrace();
		}
		
	}
	
	public static void printOutIndividuals(Collection<Individual> individuals,
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

	static String prettyPrintResultLineCSV(String output, Individual ind) {
		
		DSEDecoder decoder = new DSEDecoder();
		
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

	static String prettyPrintHeadlineCSV(
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

	
}
