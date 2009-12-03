package de.uka.ipd.sdq.dsexplore.helper;

import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.ArrayList;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;
import java.util.Map.Entry;

import org.apache.log4j.Logger;
import org.opt4j.core.Individual;
import org.opt4j.core.IntegerValue;
import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.genotype.DoubleGenotype;

import de.uka.ipd.sdq.dsexplore.opt4j.representation.DSEDecoder;
import de.uka.ipd.sdq.dsexplore.opt4j.representation.PCMPhenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.start.Opt4JStarter;
import de.uka.ipd.sdq.statistics.estimation.ConfidenceInterval;

/**
 * XXX: Maybe make this a proper label provider for the results? Metamodel results?
 * 
 *  
 * @author Anne
 *
 */
public class ResultsWriter {
	
	/** Logger for log4j. */
	private static Logger logger = 
		Logger.getLogger("de.uka.ipd.sdq.dsexplore.ResultsWriter");
	
	
	
	public static void writeIndividualsToFile(Collection<Individual> individuals, String filename, int iteration,
			List<Exception> exceptionList){
				StringBuilder results = addResultsToString(individuals, exceptionList);
				writeToFile(filename, results, iteration, exceptionList);
			}
	

	private static StringBuilder addResultsToString(Collection<Individual> individuals,
			List<Exception> exceptionList) {
		StringBuilder output = new StringBuilder(10000);
		List<Objective> objectivesWithConfidence = new LinkedList<Objective>();
		output = prettyPrintHeadlineCSV(individuals, output, objectivesWithConfidence);
		int counter = 0;

		// content
		for (Individual ind2 : individuals) {
			try {
			output = prettyPrintResultLineCSV(output, ind2,objectivesWithConfidence);
			} catch (Exception e){
				exceptionList.add(new Exception("Encountered corrupted result number "+counter+", skipped it", e));
			}
			counter++;
		}
		return output;
	}

	private static void writeToFile(String filename, StringBuilder results, int iteration, List<Exception> exceptionList) {
		filename = filename + iteration + ".csv";
		try {
			BufferedWriter w = new BufferedWriter(new OutputStreamWriter( new FileOutputStream(filename)));
			
			w.write(results.toString());
			
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
		
		List<Objective> objectivesWithConfidence = new LinkedList<Objective>();
				
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
		StringBuilder output = new StringBuilder(10000);
		output.append("\n");

		output = printHeadlineCSV(individuals,output);
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
		
		output.append("\n");
		output = prettyPrintHeadlineCSV(individuals, output,objectivesWithConfidence);
		counter = 0;

		// content
		for (Individual ind2 : individuals) {
			try {
			output = prettyPrintResultLineCSV(output, ind2,objectivesWithConfidence);
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

	private static StringBuilder prettyPrintResultLineCSV(StringBuilder output, Individual ind, List<Objective> objectivesWithConfidence) {
		
		// first objectives
		Objectives objs = ind.getObjectives();
		for (Entry<Objective, Value<?>> entry : objs) { 
			output.append(formatValue(entry.getValue()) + ";");
		}
		
		//then confidences if available
		for (Objective o : objectivesWithConfidence) {
			if (ind.getPhenotype() instanceof PCMPhenotype){
				PCMPhenotype pi = (PCMPhenotype)ind.getPhenotype();
				ConfidenceInterval c = pi.getConfidenceIntervalForObjective(o);
				if (c != null){
					output.append(c.getLowerBound()+";"+c.getUpperBound()+";"+c.getLevel()+";"); 
				} else {
					output.append(Double.NaN+";"+Double.NaN+";"+Double.NaN+";");
				}
			}
		}
		
		//then genes
		DoubleGenotype genes = (DoubleGenotype) ind.getGenotype();
		for (int i = 0; i < genes.size(); i++) {
			output.append(DSEDecoder.getDecisionString(i, genes.get(i))+";");
		}
		output.append("\n");
		return output;
	}

	private static StringBuilder prettyPrintHeadlineCSV(
			Collection<Individual> individuals, StringBuilder output, List<Objective> objectivesWithConfidence) {
		
		Individual i = individuals.iterator().next();
		output = printObjectives(i,output);
		
		output = determineAndPrintConfidenceIntervalHeadline(i, output, objectivesWithConfidence);
		
		output.append(Opt4JStarter.problem.toString());
		
		output.append("\n");
		
		return output; 
	}

	private static StringBuilder determineAndPrintConfidenceIntervalHeadline(Individual i, StringBuilder output, List<Objective> objectivesWithConfidence) {
		Objectives objs = i.getObjectives();
		
		for (Entry<Objective, Value<?>> entry : objs) {
		if (i.getPhenotype() instanceof PCMPhenotype){
			PCMPhenotype pi = (PCMPhenotype)i.getPhenotype();
			ConfidenceInterval c = pi.getConfidenceIntervalForObjective(entry.getKey());
			if (c != null){
				output.append("lower bound confidence("+entry.getKey().getName()+");"
						+ "upper bound confidence("+entry.getKey().getName()+");"
						+ "alpha("+entry.getKey().getName()+");"); 
				objectivesWithConfidence.add(entry.getKey());
			}
		}
		}
		return output;
	}

	private static void printResultLineNatural(Individual individual) {
		logger.warn("Result for individual "
				+ individual.getGenotype().toString() + " is: "
				+ individual.getObjectives().toString());
	}

	private static StringBuilder printResultLineCSV(StringBuilder output, Individual ind) {
		// first objectives
		Objectives objs = ind.getObjectives();
		for (Entry<Objective, Value<?>> entry : objs) {
			output.append(entry.getValue() + ";");
		}
		//then genes
		DoubleGenotype genes = (DoubleGenotype) ind.getGenotype();
		for (Double gene : genes) {
			output.append(formatDouble(gene) + ";");
		}
		output.append("\n");
		return output;
	}

	public static String formatDouble(Double gene) {
		return Double.toString(gene);
	}
	

	private static String formatValue(Value<?> value) {
		
		if (value instanceof IntegerValue){
			IntegerValue intValue = (IntegerValue)value;
			return String.valueOf(intValue);
			
		} else {
			double d = value.getDouble();
			return formatDouble(d);
		}
		
	}

	private static StringBuilder printHeadlineCSV(Collection<Individual> individuals, StringBuilder output) {
		
			Individual i = individuals.iterator().next();
			
			// headline
			// first objectives
			output = printObjectives(i, output);
			// then genes
			DoubleGenotype genes = (DoubleGenotype) i.getGenotype();
			for (int j = 0; j < genes.size(); j++) {
				output.append("gene" + j + ";");
			}
			output.append("\n");
		
		return output;
	}
	
	private static StringBuilder printObjectives(Individual i, StringBuilder output) {
		Objectives objs = i.getObjectives();
		for (Entry<Objective, Value<?>> entry : objs) {
			output.append(entry.getKey().getName() + "("
					+ entry.getKey().getSign() + ");");
		}

		return output;
	}

}
