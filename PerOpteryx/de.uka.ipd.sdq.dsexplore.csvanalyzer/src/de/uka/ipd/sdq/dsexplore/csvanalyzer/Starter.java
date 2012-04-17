package de.uka.ipd.sdq.dsexplore.csvanalyzer;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;
import java.util.logging.FileHandler;
import java.util.logging.Logger;

import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.domination.ParetoDomination;

import de.uka.ipd.sdq.dsexplore.csvanalyzer.ValueVector.ORIGIN;
import de.uka.ipd.sdq.dsexplore.helper.Pair;

public class Starter {

	/**
	 * Need to set the number of genes to read in heuristic statistics.
	 */
	// private static final int NUMBER_OF_GENES = 26; // BRS Diss
	private static final int NUMBER_OF_GENES = 11; // Hybrid experiment
	//private static final int NUMBER_OF_GENES = 14;

	/**
	 * The input folders. The folders need to contain folders for each run of
	 * the following format 1) a folder for a run is called x with x being the
	 * number of the run. For example: Result folder of run 4 is called 4 2) a
	 * run x is split to several folders. Then, the naming needs to be as
	 * follows. The first folder with the starting is called "x partly 0 - y"
	 * with y being the last iteration of that folder. The other folders are
	 * called "x partly z + 0 - v" with z being the iteration completed before
	 * this folder, so that iteration 0 in this folder contains the true
	 * iteration z of the overall run. v is the last iteration of this folder,
	 * relative to this folder. Example: if this folder contains 20 iterations,
	 * starting from iteration 100, it is called "x partly 100 + 0 - 20". 
	 * 
	 * Do not forget the trailing backslash.
	 */
	
	// 3D
//	private static final String PATH_RUNS_B = "C:\\Hybrid-experiments\\hybrid graphicalOnly 3D\\pure evol\\";
//	private static final String PATH_RUNS_A = "C:\\Hybrid-experiments\\hybrid graphicalOnly 3D\\hybrid\\";
	
	// performance and costs
//	private static final String PATH_RUNS_B = "C:\\Hybrid-experiments\\hybrid graphicalOnly perf costs\\pure evol\\";
//	private static final String PATH_RUNS_A = "C:\\Hybrid-experiments\\hybrid graphicalOnly perf costs\\hybrid\\";

	// reliability and costs
	private static final String PATH_RUNS_B = "C:\\Hybrid-experiments\\hybrid graphicalOnly rel costs\\pure evol\\";
	private static final String PATH_RUNS_A = "C:\\Hybrid-experiments\\hybrid graphicalOnly rel costs\\hybrid\\";
	
	
	
	// evaluation diss BRS
	//private static final String PATH_RUNS_B = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\random\\";
	//private static final String PATH_RUNS_B = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\pure evol\\";
	//private static final String PATH_RUNS_B = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tactics\\";
	//private static final String PATH_RUNS_B = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tactics continued\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\intensification results for tactics run\\";
	
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\rule based\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\intensification results for tactics run\\" ;
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\start population heuristic\\";
	
	// evaluation diss ABB
	//static final double[] INFEASIBILITY_CONSTRAINTS = { 2500.0, 1000 };
	//private static final String PATH_RUNS_B = "D:\\uka\\paper\\2010\\Martens_ASE\\data\\Results ABB\\ohne Taktiken\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\paper\\2010\\Martens_ASE\\data\\Results ABB\\mit Taktiken\\";

	//private static final String PATH_RUNS_A = "D:\\code\\Palladio.Examples_trunk\\PCM3.3_BRS_Optimisation_Heuristics\\pure evol 0 n 100 m3 conv 0.001 CR 0.9\\";
	
	// evaluation diss quality reqs / model postproceedings
	// D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 1 etc s. unten.
	
	// andere tests
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evol new n 20 conv 0.001 maybe it limit 20 CR 0.95\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evolk neu n 60 conv 0.005 it lim 15 CR 0.95\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evol new n 100 conv 0.001 it 20 CR 0.9\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evol p 100 m3 conv 0.001 it 20 CR 0.9\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evol 0 n 100 m3 conv 0.001 CR 0.9\\";
	
	// evaluation diss mediastore
	//private static final String PATH_RUNS_B = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\Mediastore\\results\\pure evol\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\Mediastore\\results\\pure evol\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\Mediastore\\results\\tactics\\";
	
	//private static final String PATH_RUNS_A = "H:\\VALIDATION_RUNS\\Run4_SP";// Qais
	//private static final String PATH_RUNS_B = "H:\\VALIDATION_RUNS\\Run1_SP";// Qais
	
	//private static final String PATH_RUNS_B = "D:\\code\\Palladio.Examples_trunk\\PCM3.3_BRS_Optimisation_heuristics_PerOpteryx_results\\qais taktiken\\conf 2 T\\";//Anne
	//private static final String PATH_RUNS_A = "D:\\code\\Palladio.Examples_trunk\\PCM3.3_BRS_Optimisation_heuristics_PerOpteryx_results\\qais taktiken\\conf 1 T\\";//Anne
	
	// Szenario 1: without constraints = scenario S0 in Diss
	//private static final String PATH_RUNS_B = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 1\\";
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 1\\";
	
	// normal constraints = medium constraints (scenario S2) in diss
	static final double[] INFEASIBILITY_CONSTRAINTS = { 0.0015, 2000.0, 3 };
	//Szenario 2: Inf Constraint with Deb
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 2\\";
	//Szenario 3: Inf Constraint with Fonseca
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 3\\";
	
	//(Szenario 7: Wide constraints and goal value with both) 
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 4\\";
	
	// strict constraints = strict requirements (scenario S3) in Diss
	//static final double[] INFEASIBILITY_CONSTRAINTS = { 0.0015, 1500.0, 2.5 };
	
	//Szenario 8: Strict constraints with Deb
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 8\\";
	//Szenario 9: Strict constraints with Fonseca
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 9\\";
	
	// cost only constraints
	// bounds for the other two dimensions are just for calculating the hypervolume. 
	// They are set to the maximum seen in all files for scenario 1, scenario 10 and scenario 12. 
	// POFOD: 
	// RT: 
	//static final double[] INFEASIBILITY_CONSTRAINTS = { 0.00194, 1000.0, 10 };
	
	//Szenario 10: Cost constraints with Deb
	// Max values in feasible ones : Max value: [0.0019389625392234322, 999.6937168385502, 9.9934088, ]
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 10\\";
	//Szenario 12: Cost constraints with Fonseca
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 12\\";
	
	// weak constraints  = weak requirements (scenario 1 in Diss)
	//static final double[] INFEASIBILITY_CONSTRAINTS = { 0.00175, 3000.0, 5 };
	
	//Szenario 13: Weak constraints with Deb
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 13\\";
	//Szenario 14: Weak constraints with Fonseca
	//private static final String PATH_RUNS_A = "D:\\uka\\stud\\QaisNoorshams\\Evaluation\\Results\\scenario 14\\";
	
	// comparison new runs for diss validation optmisation problem 
	//private static final String PATH_RUNS_A = "J:\\Results BRS Opt Approach Valid\\pure evol\\";
	
	//made up constraints for brs opt approach
	//static final double[] INFEASIBILITY_CONSTRAINTS = { 1, 2500.0, 10 };
	
	static final boolean HAS_INFEASIBILITY_CONSTRAINTS = false;
	static final boolean HAS_SATISFACTION_CONSTRAINTS = false;
	
	private static final int[] RUNS = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
	//private static final int[] RUNS = {0, 1, 3, 4, 7, 8, 9};
	//private static final int[] RUNS = {1};


	private static final String PATH_BOOTSTRAPPING = "C:\\runtime-New_configuration\\BRS Optimisation Milano\\PerOpteryx_results\\10-02-26 Vergleichslaeufe ohne Heuristik Run 1\\";
	// private static final String PATH_BOOTSTRAPPING_A =
	// "C:\\runtime-New_configuration\\BRS Optimisation Milano\\PerOpteryx_results\\10-02-26 Vergleichslaeufe mit Heuristik Run 1\\";
	// private static final String PATH_BOOTSTRAPPING_B =
	// "C:\\runtime-New_configuration\\BRS Optimisation Milano\\PerOpteryx_results\\10-02-26 Vergleichslaeufe ohne Heuristik Run 1\\";


	private static final int START_ITERATION = 0;
	private static final int FINAL_ITERATION = 200; //Integer.MAX_VALUE; // final iteration = Integer.maxvalue means as far as data is available

	private static final String FILENAME_REGEXP_PREFIX = "archiveCandidates";
	private static final String FILENAME_REGEXP_PREFIX_ALL_CANDIDATES = "allCandidates";
	private static final String FILENAME_REGEXP_CORRECTION = "ownOptimalCandidatesInput40_[0-9]{4}-[0-9]{2}-[0-9]{2}-[0-9]{6}\\.csv";
	private static final String FILENAME_REGEXP_SUFFIX = "_[0-9]{4}-[0-9]{2}-[0-9]{2}-[0-9]{6}\\.csv";
	private static final String FILENAME_REGEXP = FILENAME_REGEXP_PREFIX
			+ "[0-9]" + FILENAME_REGEXP_SUFFIX;

	private static final String DIRECTORY_NAME_REGEXP_PARTLY = " partly [0-9][^a-zA-Z]*";

	private static final String HEURISTICS_INFO_REGEXP = "heuristicsInfo_[0-9]{4}-[0-9]{2}-[0-9]{2}-[0-9]{6}\\.csv";

	private static final class CompareFilesByModifcationDateComparator
			implements Comparator<File> {
		@Override
		public int compare(File arg0, File arg1) {
			return new Date(arg0.lastModified()).compareTo(new Date (arg1.lastModified()));
		}
	}

	public static enum TacticClass {
		PROCRATE("ProcessingRateImpl"), SERVER_CONSOLIDATION(
				"ServerConsolidationImpl"), SERVER_EXPANSION(
				"ServerExpansionImpl"), REALLOCATION("ReallocationImpl");

		private String className;

		TacticClass(String name) {
			this.className = name;
		}
	};

	private static final String CANDIDATE_RETURNED = "candidate returned";

	//static final int NUMBER_OF_COLUMNS = 2;//Anne
	//static final int NUMBER_OF_COLUMNS = 3;//Qais

	static final Objective.Sign[] objectiveSigns = { Objective.Sign.MIN, Objective.Sign.MAX  };
	static final String[] objectiveNames = { "costs", "throughput"  };
	

	static final Operator INFEASIBILITY_OPERATOR = Operator.less;

	static final double[] SATISFACTION_CONSTRAINTS = { 0.001425, 1000.0, 2 };
	static final Operator SATISFACTION_OPERATOR = Operator.less;

	enum Operator {
		less, lessOrEqual, equal, greaterOrEqual, greater
	};

	static final String CSV_SEPARATOR = ";";

	static final boolean HAS_HEADER = true;

	static final ORIGIN ORIGIN_TO_BE_CHECKED = ORIGIN.A;

	static final int BOOTSTRAPPING_SAMPLE_SIZE = 1000;

	// static final int FIXED_ITERATION_OF_B = 190;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("CSVAnalyzer");
		initLogger();

//		if (NUMBER_OF_COLUMNS != INFEASIBILITY_CONSTRAINTS.length) { // weird
//																		// construction
//																		// to
//																		// avoid
//																		// "dead code"-alert
//			if (HAS_INFEASIBILITY_CONSTRAINTS) {
//				throw new RuntimeException(
//						"Number of constraints must be equal to number of columns");
//			}
//		}
		
		//printHeuristicStatistics();
		
		//printTimeSavings_CompareEachAWithEachB(200, FINAL_ITERATION);
		
		// calculate coverage time savings
		//printTimeSavings(198, 198, true);
		
		//calculate hypervolume time saving
		//printTimeSavings(198, 198, false);
		
		//printCoverageForGivenIteration(200);
		
		//printMaxValues();
		
		//printHypervolumeDifferenceOfLastIteration();
		
		//printHypervolumeStatisticsForIteration(21);
		//printHypervolumeIndicatorForIteration(200);
		//printHypervolumeDifferenceForIteration(24);
		
		//printHypervolumeForAllIterations();
		printHypervolumeDifferenceForAllIterations();
		
		// mean, min, max, variance for all iterations
		//printCoverageStatisticsForAllIterations();
		//printCoverageOfLastIterations();
		
		//printCoverageForAllIterations();
		
		//printCoverageForGivenIteration(29);

		
		//printCoverageForAOverTime(PATH_RUNS_A);
		//printCoverageForAOverTime(PATH_RUNS_B);
		
		//bootstrapping();
		
		
		// configure which objective values to use and in which order. 
		//int[] orderOfObjectives = {0, 1, 2};
		//printFrontsForPISAAssessment(200, orderOfObjectives);
		
		//System.out.println(getEvaluationsForIteration(PATH_RUNS_A, 0, ORIGIN_TO_BE_CHECKED, 200));
		
//		String[] folders = {
//				"D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\random\\",
//				"D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\pure evol\\",
//				"D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tactics\\",
//				"D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evol new n 20 conv 0.001 maybe it limit 20 CR 0.95\\",
//				"D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evol new n 100 conv 0.001 it 20 CR 0.9\\",
//				"D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evol p 100 m3 conv 0.001 it 20 CR 0.9\\",
//				"D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tries with varying parameters\\pure evol 0 n 100 m3 conv 0.001 CR 0.9\\"
//		};
		//String[] folders = { "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\rule based\\"};
		//String[] folders = { "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\intensification results for tactics run\\"  };
		//String[] folders = { "D:\\uka\\stud\\AnneMartens\\thesis2\\trunk\\diss\\data\\BRS Opt Approach\\tactics\\"  };
		//printOverallParetoFront(folders);
		
	}
	
	private static void printOverallParetoFront(String[] folders) {
		ValueVectorHandler handler = new ValueVectorHandler();
		
		int[] runs = RUNS;
		
		List<ValueVector> allFinalCandidates = new ArrayList<ValueVector>(50 * runs.length * folders.length);
		int totalNumberOfCandidates = 0;
		int numberOfComparedRuns = 0;
		
		for (String folder : folders) {
			for (int i : runs) {
				
				File archiveFile = getNewestFileForRun(folder, i, FILENAME_REGEXP_PREFIX);
				if (archiveFile != null){
					List<ValueVector> front = handler.getFromFile(archiveFile, ORIGIN.A, true);
					allFinalCandidates.addAll(front);
					
					File allCandidatesFile = getNewestFileForRun(folder, i, FILENAME_REGEXP_PREFIX_ALL_CANDIDATES);
					totalNumberOfCandidates += getNumberOfLines(allCandidatesFile);
					
					numberOfComparedRuns ++;
				}
			}
		}
		
		Collection<ValueVector> overallParetoFront = ValueVectorHandler.getParetoOptimalSubset(allFinalCandidates);
		
		printCandidates(overallParetoFront);
		
		System.out.println("\n Total number of evaluated candidates (possibly with duplicates): "+totalNumberOfCandidates);
		System.out.println("\n Number of compared optimization runs: "+numberOfComparedRuns);
		
		
	}


	private static int getNumberOfLines(File allCandidatesFile) {
		InputStream is = null;
	    try {
	    	is = new BufferedInputStream(new FileInputStream(allCandidatesFile));
	        byte[] c = new byte[1024];
	        int count = 0;
	        int readChars = 0;
	        while ((readChars = is.read(c)) != -1) {
	            for (int i = 0; i < readChars; ++i) {
	                if (c[i] == '\n')
	                    ++count;
	            }
	        }
	        return count;
	    } catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
	    	if (is != null){
	    		try {
					is.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
	    	}
	    }
		return 0;

	}

	private static void printCandidates(
			Collection<ValueVector> overallParetoFront) {
		for (ValueVector valueVector : overallParetoFront) {
			Collection<Value<?>> o = valueVector.getValues().getValues();
			String line = "";
			for (Value<?> value : o) {
				line += value.getDouble()+";"; 
			}
			line += valueVector.getGenome() + valueVector.getHomeFolder();
			System.out.println(line);
		}
		
	}

	/**
	 * Print fronts in format to calculate attainment front with EAF tools, 
	 * see http://iridia.ulb.ac.be/~manuel/eaftools
	 * Format: One solution per line, values separated by space.
	 * Fronts of different runs separated by an empty line.
	 * 
	 * Only prints the front of PATH_RUNS_A. You need to configure which objective values 
	 * to consider in the code of this method.
	 * 
	 * Note that the attainment function tool only supporst two dimensions.  
	 * 
	 * Infinity values are ignored.
	 * 
	 * @param generation
	 * @param orderOfObjectives configure which objective values to use and in which order. 
	 */
	private static void printFrontsForPISAAssessment(int generation, int[] orderOfObjectives) {
		
		System.out.println("Fronts for PISA tools, iteration "+generation+", for "+PATH_RUNS_A);
		int countInfinites = 0;
		
		List<Collection<ValueVector>> frontsRunB = new ArrayList<Collection<ValueVector>>(RUNS.length);
		ValueVectorHandler handler = new ValueVectorHandler();
		
		
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			File file = getFileForIteration(PATH_RUNS_A, generation, run);
			
			Pair<Collection<ValueVector>, Collection<ValueVector>> fronts = getFrontsToCompare(generation, run, handler);
			
			Collection<ValueVector> front = fronts.getFirst();
			frontsRunB.add(fronts.getSecond());
			
			for (ValueVector valueVector : front) {
				
				String line = "";
				for (int i = 0; i < orderOfObjectives.length; i++) {
					line += valueVector.getValue(orderOfObjectives[i])+" ";
				}
				if (!line.contains(""+Double.POSITIVE_INFINITY)){
					System.out.println(line);
				} else {
					countInfinites ++;
				}
			}
			System.out.println("");
			
		}
		System.out.println("Skipped infinite values in front A: "+countInfinites);
		
		System.out.println("Fronts for PISA tools, same number of evaluations, for "+PATH_RUNS_B+"");
		countInfinites = 0;
		
		for (Collection<ValueVector> front : frontsRunB) {
			for (ValueVector valueVector : front) {
				
				String line = "";
				for (int i = 0; i < orderOfObjectives.length; i++) {
					line += valueVector.getValue(orderOfObjectives[i])+" ";
				}
				if (!line.contains(""+Double.POSITIVE_INFINITY)){
					System.out.println(line);
				} else {
					countInfinites ++;
				}
			}
			System.out.println("");
		}
		
		System.out.println("Skipped infinite values in front B: "+countInfinites);
		
	}

	private static void printMaxValues() {
		String maxValuesString = "[";
		Objectives maxValues = getMaximumValues(PATH_RUNS_A,200);
		for (Objective d : maxValues.getKeys()) {
			maxValuesString += maxValues.get(d) + ", ";
		}
		System.out.println("Max value: "+maxValuesString+"]");
		
	}

	private static Objectives getMaximumValues(String pathRunsA, int i) {
		Objectives max = new Objectives(new ParetoDomination());
		ValueVectorHandler handler = new ValueVectorHandler();
		
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			//for (int i = 0; i < RUNS.length; i++) {
			//	int run = RUNS[i];
				File file = getFileForIteration(PATH_RUNS_A, i, run, FILENAME_REGEXP_PREFIX_ALL_CANDIDATES); 
				Collection<ValueVector> set = handler.getFromFile(file,ValueVector.ORIGIN.A);
				max = ValueVectorHandler.setToMaximumOfPopulation(set, max);
		}
		return max;
	}

	private static void printHypervolumeStatisticsForAllIterations(){
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);

		if (HAS_INFEASIBILITY_CONSTRAINTS){
			String constraintsString = "[";
			for (double d : INFEASIBILITY_CONSTRAINTS) {
				constraintsString += d + ", ";
			}
			System.out.println("Constraints: "+constraintsString+"]");
		} else {
			System.out.println("No constraints");
		}
		System.out
				.println("Iteration\tMeanHyperA\tMaxA\tMinA\tMeanHyperB\tMaxB\tMinB\tMean Difference ");
		for (int iteration = START_ITERATION; iteration <= FINAL_ITERATION; iteration++) {
			printHypervolumeStatisticsForIteration(iteration);
		}
	}

	private static void printHypervolumeStatisticsForIteration(int iteration) {
		Collection<HypervolumeResult> resultsRun = calculateHypervolume(iteration);
		
		System.out.println( iteration + "\t"
				+ HypervolumeResult.getMeanHyperVolumeA(resultsRun) + "\t" 
				+ HypervolumeResult.getMaxHyperVolumeA(resultsRun) + "\t"
				+ HypervolumeResult.getMinHyperVolumeA(resultsRun) + "\t"
				+ HypervolumeResult.getMeanHyperVolumeB(resultsRun) + "\t"
				+ HypervolumeResult.getMaxHyperVolumeB(resultsRun) + "\t"
				+ HypervolumeResult.getMinHyperVolumeB(resultsRun) +"\t"
				+ HypervolumeResult.getMeanHypervolumeDifference(resultsRun)
		);
	}
	
	/**
	 * This method determines the hypervolume indicator as hypervolume union - hypervolume B
	 * for all iterations. 
	 * This is not what I use in the thesis, as the newer tutorial of Knowles et al. (2006) 
	 * directly compared the hypervolume values. So use {@link #printHypervolumeDifferenceForAllIterations()}
	 * instead.   
	 */
	@Deprecated
	private static void printHypervolumeIndicatorForAllIterations() {
		// Print the coverage for all iterations between START_ITERATION and
		// FINAL_ITERATION
		// of the given runs.
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);

		String headline = "";
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			headline += "run " + run + ";";
		}
		System.out.println("Printing hypervolume indicator A over B, defined as hypervolume union - hypervolume B (always positive and not symmetric)");
		
		System.out.println("Iteration;" + headline +";mean;" + "of "
				+ ORIGIN_TO_BE_CHECKED);

		for (int iteration = START_ITERATION; iteration <= FINAL_ITERATION; iteration++) {
			
			printHypervolumeIndicatorForIteration(iteration);
		}
	}

	/**
	 * This method determines the hypervolume indicator as hypervolume union - hypervolume B. 
	 * This is not what I use in the thesis, as the newer tutorial of Knowles et al. (2006) 
	 * directly compared the hypervolume values. So use {@link #printHypervolumeDifferenceForIteration(int)}
	 * instead.   
	 * @param iteration
	 */
	@Deprecated
	private static void printHypervolumeIndicatorForIteration(int iteration) {
		Collection<HypervolumeResult> hypervolumes = calculateHypervolume(iteration);
		String line = iteration + ";";
		double indicatorSum = 0;
		for (HypervolumeResult hypervolumeResult : hypervolumes) {
			double indicator = hypervolumeResult.getHyperVolumeIndicatorAOverB();
			line += indicator + ";";
			indicatorSum += indicator;
		}
		double mean = indicatorSum / hypervolumes.size();
		System.out.println(line+";"+mean);
	}
	
	private static void printHypervolumeDifferenceForAllIterations() {
		
		// Print the coverage for all iterations between START_ITERATION and
		// FINAL_ITERATION
		// of the given runs.
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);

		String headline = "";
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			headline += "run " + run + ";";
		}
		System.out.println("Iteration;" + headline +";mean;" + "of "
				+ ORIGIN_TO_BE_CHECKED);

		for (int iteration = START_ITERATION; iteration <= FINAL_ITERATION; iteration++) {
			
			printHypervolumeDifferenceForIteration(iteration);
		}
	}
	
	/**
	 * Print the hypervolume difference for the last iteration only
	 */
	private static void printHypervolumeDifferenceOfLastIteration() {
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);

		String headline = "";
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			headline += "run " + run + ";";
		}
		System.out.println("Iteration;" + headline +";mean;" + "of "
				+ ORIGIN_TO_BE_CHECKED);

		printHypervolumeDifferenceForIteration(Integer.MAX_VALUE);
		
	}
	
	/**
	 * Print the hypervolume difference for the given iteration.
	 */
	private static void printHypervolumeDifferenceForIteration(int iteration) {
		Collection<HypervolumeResult> hypervolumes = calculateHypervolume(iteration);
		String line = iteration + ";";
		double indicatorSum = 0;
		for (HypervolumeResult hypervolumeResult : hypervolumes) {
			double indicator = hypervolumeResult.getHypervolumeDifference();
			line += indicator + ";";
			indicatorSum += indicator;
		}
		double mean = indicatorSum / hypervolumes.size();
		System.out.println(line+";"+mean);
	}
	
	/**
	 * Print the hypervolume for all iterations.
	 */
	private static void printHypervolumeForAllIterations() {
		// Print the hypervolume for all iterations between START_ITERATION and
		// FINAL_ITERATION
		// of the given runs.
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);

		String headline = "";
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			headline += "run "+run+";";
		}
		

		List<Collection<HypervolumeResult>> results = new ArrayList<Collection<HypervolumeResult>>();
		for (int iteration = START_ITERATION; iteration <= FINAL_ITERATION; iteration++) {
			
			results.add(calculateHypervolume(iteration));
		}
		
		System.out.println("Hypervolume of A");
		System.out.println("Iteration;" + headline);
		for (Collection<HypervolumeResult> collection : results) {
			// collection has the hyper volume values of all runs for that iteration
			String line = "";
			for (HypervolumeResult hypervolumeResult : collection) {
				line += hypervolumeResult.getHyperVolumeA()+";";
			}
			System.out.println(line);
		}
		
		System.out.println("Hypervolume of B");
		System.out.println("Iteration;" + headline);
		for (Collection<HypervolumeResult> collection : results) {
			// collection has the hyper volume values of all runs for that iteration
			String line = "";
			for (HypervolumeResult hypervolumeResult : collection) {
				line += hypervolumeResult.getHyperVolumeB()+";";
			}
			System.out.println(line);
		}
	}
	
	private static Collection<HypervolumeResult> calculateHypervolume(int iteration) {
		Collection<HypervolumeResult> hypervolumeResults = new ArrayList<HypervolumeResult>();
		
		ValueVectorHandler handler = new ValueVectorHandler();
		
		List<Collection<ValueVector>> resultsOfAllRunsA = new ArrayList<Collection<ValueVector>>(RUNS.length);
		List<Collection<ValueVector>> resultsOfAllRunsB = new ArrayList<Collection<ValueVector>>(RUNS.length);
		
		try {

			for (int j = 0; j <= RUNS.length -1; j++) {
				int run = RUNS[j];

				// first pair element will contain front of run A, second of run B
				Pair<Collection<ValueVector>,Collection<ValueVector>> frontsToCompare = getFrontsToCompare(iteration, run, handler);

				//nur zur info wie groﬂ front
				//getFrontsToCompare(0, run, handler);

				resultsOfAllRunsA.add(frontsToCompare.getFirst());
				resultsOfAllRunsB.add(frontsToCompare.getSecond());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		Objectives constraints = determineOverallReferencePointForHypervolume(
				resultsOfAllRunsA, resultsOfAllRunsB);
		
		for (int i = 0; i < resultsOfAllRunsA.size(); i++) {
			
			//System.out.println("Run "+(i + START_RUN)+" ************ ");
			HypervolumeResult hyperVolumeResult = ValueVectorHandler.getHypervolume(resultsOfAllRunsA.get(i), resultsOfAllRunsB.get(i), constraints, handler.getObjectives(), true);
			//System.out.println("Run " + (i + START_RUN) + " - Hypervolume of A over B: " + hyperVolumeDiff);
			hypervolumeResults.add(hyperVolumeResult);
			
	
		}
		
		return hypervolumeResults;
	}

	private static Objectives determineOverallReferencePointForHypervolume(
			List<Collection<ValueVector>> resultsOfAllRunsA,
			List<Collection<ValueVector>> resultsOfAllRunsB) {
		Objectives constraints = new Objectives(new ParetoDomination());
		
		if (!HAS_INFEASIBILITY_CONSTRAINTS){

			// determine bounds to use as reference point for the calculations.
			for (Collection<ValueVector> r : resultsOfAllRunsA) {
				constraints = ValueVectorHandler.setToMaximumOfPopulation(r, constraints);
			}
			for (Collection<ValueVector> r : resultsOfAllRunsB) {
				constraints = ValueVectorHandler.setToMaximumOfPopulation(r, constraints);
			}
			
		} else {
			
			// just to get the objectives 
			for (Collection<ValueVector> r : resultsOfAllRunsA) {
				constraints = ValueVectorHandler.setToMaximumOfPopulation(r, constraints);
			}
			List<Objective> objectiveList = resultsOfAllRunsA.get(0).iterator().next().getObjectiveList();
			System.out.println("Warning: Assuming objective order for infeasibility constraints.");
			for (int i = 0; i < objectiveList.size(); i++) {
				Objective o = objectiveList.get(i);
				constraints.add(o, INFEASIBILITY_CONSTRAINTS[i]);
				System.out.println(o.getName()+" has constraint "+INFEASIBILITY_CONSTRAINTS[i]);
			}
			System.out.println("reorder infeasibility constraints if this is wrong.");

		}
		return constraints;
	}

	/**
	 * Read fronts to compare from file. 
	 * First pair element will contain front of run A, second of run B
	 * 
	 * Retrieve the front of run A for the given iteration i, then find the minimum iteration of B
	 * that has at least as much evaluations than A at iteration i. 
	 * 
	 * @param iteration
	 * @param run
	 * @return Pair with the front of run A in the first pair element and the front of run B in the second pair element.
	 */
	private static Pair<Collection<ValueVector>, Collection<ValueVector>> getFrontsToCompare(
			int iteration,
			int run, ValueVectorHandler handler) {
		Pair<Collection<ValueVector>, Collection<ValueVector>> frontsToCompare = new Pair<Collection<ValueVector>, Collection<ValueVector>>();
		
		File fileA = getFileForIteration(PATH_RUNS_A, iteration, run); 
		//File fileA = getFilesOfDirectory(getPath(PATH_RUNS_A, run),
		//		getRegExp(iteration))[0];
		Collection<ValueVector> setA = handler.getFromFile(fileA,
				ValueVector.ORIGIN.A);
		frontsToCompare.setFirst(setA);
		
		int numberOfEvaluationsInA = getNumberOfEvaluations(PATH_RUNS_A, iteration, run, ValueVector.ORIGIN.A, handler);
		
		int iterationForB = getIterationForNumberOfEvaluations(numberOfEvaluationsInA, PATH_RUNS_B, iteration, run, ValueVector.ORIGIN.B, handler);
		File fileB = getFileForIteration(PATH_RUNS_B, iterationForB, run);
		Collection<ValueVector> setB = handler.getFromFile(fileB,
				ValueVector.ORIGIN.B);
		frontsToCompare.setSecond(setB);
		
		//System.out.println("Comparing iteration "+iteration+" with iteration "+iterationForB+", desired "+numberOfEvaluationsInA+" evaluations.");
		
		return frontsToCompare;
	}

	/**
	 * Bootstrapping implementation, not yet adjusted to new name schema
	 */
	private static void bootstrapping(ValueVectorHandler handler) {

		Collection<Double> coverageValues = new ArrayList<Double>();
		;
		System.out.println("Bootstrapping files: " + PATH_BOOTSTRAPPING);
		for (int sample = 1; sample <= BOOTSTRAPPING_SAMPLE_SIZE; sample++) {
			int j = getRandomInt(0, RUNS.length - 1);
			int randomIntA = RUNS[j];
			
			File fileA = getFilesOfDirectory(getPath(PATH_BOOTSTRAPPING, randomIntA),
					FILENAME_REGEXP)[0];
			Collection<ValueVector> setA = handler.getFromFile(fileA,
					ValueVector.ORIGIN.A);
			j = getRandomInt(0, RUNS.length - 1);
			int randomIntB = RUNS[j]; 
			File fileB = getFilesOfDirectory(getPath(PATH_BOOTSTRAPPING, randomIntB),
					FILENAME_REGEXP)[0];
			Collection<ValueVector> setB = handler.getFromFile(fileB,
					ValueVector.ORIGIN.B);
			double coverage = handler.getCoverage(setA, setB,
					ORIGIN_TO_BE_CHECKED);
			System.out.println("Sample " + sample + " - Mean of "
					+ ORIGIN_TO_BE_CHECKED + ": " + coverage + "\t (run "
					+ randomIntA + " vs run " + randomIntB + ")");
			coverageValues.add(coverage);
		}
		System.out.println("Mean coverage:\t" + mean(coverageValues)
				+ "\t Standard deviation:\t"
				+ standardDeviation(coverageValues));

		/*
		 * // probably also part of bootstrapping coverageValues = new
		 * ArrayList<Double>(); System.out.println(ValueVector.ORIGIN.A + ": " +
		 * PATH_BOOTSTRAPPING_A); System.out.println(ValueVector.ORIGIN.B + ": "
		 * + PATH_BOOTSTRAPPING_B); for (int sample = 1; sample <=
		 * BOOTSTRAPPING_SAMPLE_SIZE; sample++) { int randomIntA =
		 * getRandomInt(START_RUN, NUMBER_OF_RUNS); File fileA =
		 * getFilesOfDirectory(getPath(PATH_BOOTSTRAPPING_A, randomIntA),
		 * FILENAME_REGEXP)[0]; Collection<ValueVector> setA =
		 * ValueVector.getFromFile(fileA, ValueVector.ORIGIN.A); int randomIntB
		 * = getRandomInt(START_RUN, NUMBER_OF_RUNS); File fileB =
		 * getFilesOfDirectory(getPath(PATH_BOOTSTRAPPING_B, randomIntB),
		 * FILENAME_REGEXP)[0]; Collection<ValueVector> setB =
		 * ValueVector.getFromFile(fileB, ValueVector.ORIGIN.B); double coverage
		 * = ValueVector.getCoverage(setA, setB, originToBeChecked);
		 * System.out.println("Sample " + sample + " - Mean of " +
		 * originToBeChecked + ": " + coverage + "\t (run " + randomIntA +
		 * " vs run " + randomIntB + ")"); coverageValues.add(coverage); }
		 * System.out.println("Mean coverage of " + originToBeChecked + ":\t" +
		 * mean(coverageValues) + "\t Standard deviation:\t" +
		 * standardDeviation(coverageValues));
		 */
	}

	private static void printTimeSavings(int fixedIterationOfB,
			int finalIteration, boolean isCalculateCoverage) {

		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);
		ArrayList<Double> resultValues = new ArrayList<Double>();
		ArrayList<Double> relativeResultValues = new ArrayList<Double>();
		ValueVectorHandler handler = new ValueVectorHandler();
		
		// determine overall reference point for hypervolume
		Objectives constraints = null;
		if (!isCalculateCoverage){
			constraints = determineReferencePointForAllRunsAtIteration(
					fixedIterationOfB, handler);
		}
		
		
		
		for (int i = 0; i < RUNS.length; i++) {
			int run = RUNS[i];

			System.out.println("=================================");
			System.out.println("Run: " + run + " ...");
			printTimeSavings_TheInnerLoop(fixedIterationOfB, finalIteration,
					run, run, resultValues, relativeResultValues, isCalculateCoverage, handler, constraints);

		}
		System.out.println("===============\n" + "Overall absolute results: \n"
				+ "Mean:\t" + mean(resultValues) + "\n" + "Max:\t"
				+ max(resultValues) + "\n" + "Min:\t" + min(resultValues)
				+ "\n" + "Overall relative results: \n" + "Mean:\t"
				+ mean(relativeResultValues) + "\n" + "Max:\t"
				+ max(relativeResultValues) + "\n" + "Min:\t"
				+ min(relativeResultValues));

		System.out.println(relativeResultValues);

	}

	private static Objectives determineReferencePointForAllRunsAtIteration(
			int fixedIterationOfB, ValueVectorHandler handler) {
		Objectives constraints;
		List<Collection<ValueVector>> resultsOfAllRunsA = new ArrayList<Collection<ValueVector>>(RUNS.length);
		List<Collection<ValueVector>> resultsOfAllRunsB = new ArrayList<Collection<ValueVector>>(RUNS.length);
		
		for (int j = 0; j < RUNS.length; j++) {
			int run = RUNS[j];
			
			// first pair element will contain front of run A, second of run B
			Pair<Collection<ValueVector>,Collection<ValueVector>> frontsToCompare = getFrontsToCompare(fixedIterationOfB, run, handler);
			
			resultsOfAllRunsA.add(frontsToCompare.getFirst());
			resultsOfAllRunsB.add(frontsToCompare.getSecond());
		}
		
		constraints = determineOverallReferencePointForHypervolume(
				resultsOfAllRunsA, resultsOfAllRunsB);
		return constraints;
	}

	/**
	 * 
	 * @param fixedIterationOfBThe
	 *            iteration of B to compare A with. That is, the algorithm looks
	 *            for an iteartion i of A that covers this iteration of B
	 * @param finalIteration
	 * @param handler 
	 */
	private static void printTimeSavings_CompareEachAWithEachB(
			int fixedIterationOfB, int finalIteration, boolean isCalculateCoverage, ValueVectorHandler handler) {

		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);
		ArrayList<Double> resultValues = new ArrayList<Double>();
		ArrayList<Double> relativeResultValues = new ArrayList<Double>();
		
		Objectives constraints = null;
		if (!isCalculateCoverage){
			constraints = determineReferencePointForAllRunsAtIteration(fixedIterationOfB, handler);
		}
		
		for (int i = 0; i <= RUNS.length - 1; i++) {
			int runA = RUNS[i];
		
			for (int j = 0; j <= RUNS.length -1; j++) {
				int runB = RUNS[j];
				System.out.println("=================================");
				System.out.println("Run: " + runA + "," + runB + " ...");
				printTimeSavings_TheInnerLoop(fixedIterationOfB,
						finalIteration, runA, runB, resultValues,
						relativeResultValues, isCalculateCoverage, handler, constraints);
			}
		}
		System.out.println("===============\n" + "Overall absolute results: \n"
				+ "Mean:\t" + mean(resultValues) + "\n" + "Max:\t"
				+ max(resultValues) + "\n" + "Min:\t" + min(resultValues)
				+ "\n" + "Overall relative results: \n" + "Mean:\t"
				+ mean(relativeResultValues) + "\n" + "Max:\t"
				+ max(relativeResultValues) + "\n" + "Min:\t"
				+ min(relativeResultValues));

	}

	/**
	 * 
	 * @param fixedIterationOfB
	 *            : The iteration of B to compare A with. That is, the algorithm
	 *            looks for an iteration i of A that covers this iteration of B
	 * @param finalIteration
	 * @param runA
	 * @param runB
	 * @param resultValues
	 * @param relativeResultValues
	 * @param constraints 
	 */
	private static void printTimeSavings_TheInnerLoop(int fixedIterationOfB,
			int finalIteration, int runA, int runB,
			ArrayList<Double> resultValues,
			ArrayList<Double> relativeResultValues,
			boolean calculateCoverage,
			ValueVectorHandler handler, Objectives constraints) {
		
		double coverage = Double.NEGATIVE_INFINITY;
		
		HypervolumeResult hypervolumeA = new HypervolumeResult(0, 0, 0);

		Collection<ValueVector> setA = null;
		File fileB = getFileForIteration(PATH_RUNS_B, fixedIterationOfB,
				runB);
		Collection<ValueVector> setB = handler.getFromFile(fileB,
				ValueVector.ORIGIN.B);
		
		if (setB.size() == 0){
			System.out.println("Run B found no feasible optimal candidates at the end, so find lowest run A with feasible candidate.");
		}
		
		int iteration = 0;
		for (; iteration <= finalIteration// & coverage < 0.5
		; iteration++) {
			File fileA = getFileForIteration(PATH_RUNS_A, iteration, runA);
			setA = handler.getFromFile(fileA,
					ValueVector.ORIGIN.A);
			
			if (setB.size() == 0){
				// if run B was empty, we just look for a non empty run A and then return results
				if (setA.size() > 0){
					double relativeResult = (finalIteration - iteration)/ (double) finalIteration;
					
					System.out.println("Result: B (" + finalIteration + ") - A ("
							+ iteration + "):\t" + (finalIteration - iteration));
					System.out.println("Relative: \t "+relativeResult);
					resultValues.add((double) (finalIteration - iteration));
					relativeResultValues.add(relativeResult);
					return;
				}
			} else {

				if (calculateCoverage){
					coverage = ValueVectorHandler.getCoverage(setA, setB, ORIGIN_TO_BE_CHECKED);
					
					if (coverage >= 0.5) {
						//Don't increment iteration counter
						break;
					}
				} else {
					hypervolumeA = ValueVectorHandler.getHypervolume(setA, setB, constraints, handler.getObjectives(), true);
					if (hypervolumeA.getHypervolumeDifference() >= 0){
						// do not increment counter
						break;
					}
				}
			}
		}
		
		//XXX: Consider number of evaluations instead of number of iterations for time saving.
		
		iteration = iteration > finalIteration ? finalIteration : iteration;
		if (calculateCoverage){
			System.out.println("A(" + iteration + ") covers B("
				+ fixedIterationOfB + ") with coverage\t" + coverage);
		} else {
			System.out.println("A(" + iteration + ") larger than B("
				+ fixedIterationOfB + ") with difference\t" + (hypervolumeA.getHypervolumeDifference()));
		}

		
		Collection<ValueVector> setBEarlier = null;
		double coverage2 = Double.NEGATIVE_INFINITY;
		HypervolumeResult hypervolumeB = new HypervolumeResult(0, 0, 0);
		int iteration2;
		
		// Need to put the other origin to setB now to compare to setBEarlier.
		fileB = getFileForIteration(PATH_RUNS_B, fixedIterationOfB,
				runB);
		setB = handler.getFromFile(fileB, ValueVector.ORIGIN.A);
		
		for (iteration2 = 0; iteration2 <= finalIteration
				//& coverage2 < 0.5
				; iteration2++) {

			// turn around the value origins so that we can compare
			// BEarlier and A later
			File fileA = getFileForIteration(PATH_RUNS_B, iteration2, runB);
			setBEarlier = handler.getFromFile(fileA,
					ValueVector.ORIGIN.B);

	
			
//			if(iteration2 == finalIteration){
//				@SuppressWarnings("unused")
//				int a = 123;
//			}
			
			if (calculateCoverage){
				coverage2 = ValueVectorHandler.getCoverage(setBEarlier, setB,
						ValueVector.ORIGIN.B);
				if(coverage2 >= 0.5) {
				//	Don't increment iteration counter
					break;
				}
			} else {
				hypervolumeB = ValueVectorHandler.getHypervolume(setBEarlier, setB, constraints, handler.getObjectives(), true);

				if (hypervolumeB.getHypervolumeDifference() >= 0){
					// do not increment counter
					break;
				}
			}
		}

		if (calculateCoverage){
			System.out.println("B(" + iteration2 + ") covers B("
					+ fixedIterationOfB + ") with coverage\t" + coverage2);
		} else {
			System.out.println("B(" + iteration2 + ") larger than B("
					+ fixedIterationOfB + ") with difference\t" + (hypervolumeB.getHypervolumeDifference()));
		}
		
		//relative result always in relation to the slower one. 
		double slowerIteration = iteration > iteration2 ? iteration : iteration2;
		double relativeResult = (iteration2 - iteration)/ (double) slowerIteration;
		
		System.out.println("Result: B (" + iteration2 + ") - A ("
				+ iteration + "):\t" + (iteration2 - iteration));
		System.out.println("Relative: "+relativeResult);
		resultValues.add((double) (iteration2 - iteration));
		relativeResultValues.add(relativeResult);

		if (setBEarlier != null && setA != null) {
			if (calculateCoverage){
				double coverage3 = ValueVectorHandler.getCoverage(setA,
						setBEarlier, ValueVector.ORIGIN.A);
				System.out.println("Check: A(" + iteration + ") covers B ("
						+ iteration2 + ") with coverage\t" + coverage3);
			} else {
				HypervolumeResult hypervolumeCheck = ValueVectorHandler.getHypervolume(setA, setBEarlier, constraints, handler.getObjectives(), true);
				System.out.println("Check: A(" + iteration + ") has volume \t"+hypervolumeCheck.getHyperVolumeA()+
						"\nB ("+ iteration2 + ") has volume \t" + hypervolumeCheck.getHyperVolumeB());
			}
		} else {
			System.out.println("No earlier iteration of B found.");
		}
	}

	private static List<Date> getIterationToTimestampMapping(int run,
			int finalIteration, String pathOfRun) {

		//
		List<Date> endTimestampOfIteration = new ArrayList<Date>(finalIteration);

		SimpleDateFormat simpleFormat = new SimpleDateFormat(
				"yyyy-MM-dd-HHmmss");

		for (int iteration = 0; iteration < finalIteration; iteration++) {
			try {
				File fileA = getFileForIteration(pathOfRun, iteration, run);
				String fileName = fileA.getName();
				String dateString = fileName.substring(
						fileName.indexOf("_") + 1, fileName.length() - 4);
				endTimestampOfIteration.add(simpleFormat.parse(dateString));
			} catch (Exception e) {
				System.out
						.println("Cannot create iteration to timestamp mapping for iteration "
								+ iteration
								+ " and run "
								+ run
								+ " in folder "
								+ pathOfRun);
				e.printStackTrace();
				endTimestampOfIteration.add(null);
			}
		}

		return endTimestampOfIteration;

	}

	/**
	 * Coverage t vs. t+1
	 * 
	 * @param pathOfRuns
	 */
	private static void printCoverageForAOverTime(String pathOfRuns) {
		System.out.println(ValueVector.ORIGIN.A + ": " + pathOfRuns);
		System.out
				.println("Iteration\tMeanCoverage\tStandard deviation\tMin\tMax\tof "
						+ ORIGIN_TO_BE_CHECKED);
		Collection<Double> coverageValues;
		for (int iteration = START_ITERATION; iteration < FINAL_ITERATION; iteration++) {
			coverageValues = new ArrayList<Double>();
			
			for (int j = 0; j <= RUNS.length -1; j++) {
				int run = RUNS[j];
				
				ValueVectorHandler handler = new ValueVectorHandler();
				Pair<Collection<ValueVector>, Collection<ValueVector>> frontsToCompare = getFrontsToCompare(iteration, run, handler);
				
				Collection<ValueVector> setA = frontsToCompare.getFirst();
				Collection<ValueVector> setB = frontsToCompare.getSecond();

				double coverage = ValueVectorHandler.getCoverage(setA, setB,
						ORIGIN_TO_BE_CHECKED);
				// System.out.println("Run " + run + " - Coverage of " +
				// originToBeChecked + ": " + coverage);
				coverageValues.add(coverage);
			}
			System.out.println(iteration + "\t" + mean(coverageValues) + "\t"
					+ standardDeviation(coverageValues) + "\t"
					+ min(coverageValues) + "\t" + max(coverageValues));
		}
	}

	private static void printCoverageStatisticsForAllIterations() {
		// Print the coverage for all iterations between START_ITERATION and
		// FINAL_ITERATION
		// of the given runs.
		Collection<Double> coverageValues = new ArrayList<Double>();
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);
		System.out
				.println("Iteration\tMeanCoverage\tStandard deviation\tMin\tMax\tof "
						+ ORIGIN_TO_BE_CHECKED);
		for (int iteration = START_ITERATION; iteration <= FINAL_ITERATION; iteration++) {
			coverageValues = getCoverageValuesOfAllRuns(iteration);
			System.out.println(iteration + "\t" + mean(coverageValues) + "\t"
					+ standardDeviation(coverageValues) + "\t"
					+ min(coverageValues) + "\t" + max(coverageValues));
		}
	}
	
	private static void printCoverageOfLastIterations() {
		// Print the coverage for all iterations between START_ITERATION and
		// FINAL_ITERATION
		// of the given runs.
		Collection<Double> coverageValues = new ArrayList<Double>();
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);

		String headline = "";
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			headline += "run " + run + ";";
		}
		System.out.println("Iteration;" + headline + "of "
				+ ORIGIN_TO_BE_CHECKED);
		
		coverageValues = getCoverageValuesOfAllRuns(Integer.MAX_VALUE);
		String line = "lastIteration;";
		for (Double coverageValue : coverageValues) {
			line += coverageValue + ";";
		}
		System.out.println(line);
		
	}

	private static void printCoverageForAllIterations() {
		// Print the coverage for all iterations between START_ITERATION and
		// FINAL_ITERATION
		// of the given runs.
		Collection<Double> coverageValues = new ArrayList<Double>();
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);

		String headline = "";
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			headline += "run " + run + ";";
		}
		System.out.println("Iteration;" + headline + "of "
				+ ORIGIN_TO_BE_CHECKED);


		for (int iteration = START_ITERATION; iteration <= FINAL_ITERATION; iteration++) {
			try {
				coverageValues = getCoverageValuesOfAllRuns(iteration);
				String line = iteration + ";";
				for (Double coverageValue : coverageValues) {
					line += coverageValue + ";";
				}
				System.out.println(line);
			} catch (RuntimeException e){
				e.printStackTrace();
				System.out.println("End of available iterations reached at iteration "+(iteration - 1));
				break;
			}
		}

	}

	/**
	 * Returns the coverage values for all runs between START_RUN and FINAL_RUN
	 * 
	 * @param iteration
	 * @return
	 */
	private static Collection<Double> getCoverageValuesOfAllRuns(int iteration) {
		Collection<Double> coverageValues;
		coverageValues = new ArrayList<Double>();
		log("Iteration: "+iteration);
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			
			ValueVectorHandler handler = new ValueVectorHandler();
			Pair<Collection<ValueVector>, Collection<ValueVector>> frontsToCompare = getFrontsToCompare(iteration, run, handler);
			
			Collection<ValueVector> setA = frontsToCompare.getFirst();
			Collection<ValueVector> setB = frontsToCompare.getSecond();

			log("RUN: "+run+", size Set A: " + setA.size() +", size Set: B " + setB.size());
			
			double coverage = ValueVectorHandler.getCoverage(setA, setB,
					ORIGIN_TO_BE_CHECKED);
			// System.out.println("Run " + run + " - Coverage of " +
			// originToBeChecked + ": " + coverage);
			coverageValues.add(coverage);
		}
		return coverageValues;
	}

	private static void printCoverageForGivenIteration(int givenIteration) {
		// Prints the coverage of iterations ITERATION of the given runs.
		Collection<Double> coverageValues = new ArrayList<Double>();
		System.out.println(ValueVector.ORIGIN.A + ": " + PATH_RUNS_A);
		System.out.println(ValueVector.ORIGIN.B + ": " + PATH_RUNS_B);
		System.out.println("Iteration " + givenIteration);
		
		System.out.println("run;C(A,B);cand of A in set;size of pareto set;size of A;size of B;");
		
		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];
			// One value vector always comes from one file.

			// warn if value vector is equal to 100 as then the archive might be
			// filled.
			ValueVectorHandler handler = new ValueVectorHandler();
			Pair<Collection<ValueVector>, Collection<ValueVector>> frontsToCompare = getFrontsToCompare(givenIteration, run, handler);
			
			Collection<ValueVector> setA = frontsToCompare.getFirst();
			Collection<ValueVector> setB = frontsToCompare.getSecond();

			Collection<ValueVector> optimalSet = ValueVectorHandler
					.getParetoOptimalSet(setA, setB);
			double coverage = ValueVectorHandler.getCoverageForOptimalSet(optimalSet,
					ORIGIN_TO_BE_CHECKED);
			double numberOfCandidatesFromOriginToBeChecked = optimalSet.size()
					* coverage;

//			System.out.println("Run " + run + " - Coverage of "
//					+ ORIGIN_TO_BE_CHECKED + ": " + coverage + " ("
//					+ numberOfCandidatesFromOriginToBeChecked + " cand. from "
//					+ ORIGIN_TO_BE_CHECKED + " in optimal set from "
//					+ optimalSet.size() + " total)");
//			System.out.println("Pareto-optimal candidates of A: "
//					+ ValueVector.getParetoOptimalSubset(setA).size());
//			System.out.println("Pareto-optimal candidates of B: "
//					+ ValueVector.getParetoOptimalSubset(setB).size());
			System.out.println(run+";"+coverage+";"+numberOfCandidatesFromOriginToBeChecked+";"+optimalSet.size()+";"
					+ValueVectorHandler.getParetoOptimalSubset(setA).size()+";"
					+ValueVectorHandler.getParetoOptimalSubset(setB).size());
			coverageValues.add(coverage);
		}
		System.out.println("Mean coverage of " + ORIGIN_TO_BE_CHECKED + ": "
				+ mean(coverageValues) + "\t Standard deviation:\t"
				+ standardDeviation(coverageValues));
	}

	private static void printHeuristicStatistics() {
		System.out.println("Heuristics statistics");
		System.out.println("Input dir: " + PATH_RUNS_A);
		HashMap<String, Integer> heuristicResults = new HashMap<String, Integer>();
		HashMap<String, Integer> heuristicCandidates = new HashMap<String, Integer>();
		for (TacticClass className : TacticClass.values()) {
			heuristicResults.put(className.className, 0); // inititalize with 0
			heuristicCandidates.put(className.className, 0);
		}
		File file;

		List<TacticApplicationResult> tacticsApplicationResults = new LinkedList<TacticApplicationResult>();

		for (int j = 0; j <= RUNS.length -1; j++) {
			int run = RUNS[j];

			ArrayList<File> directoriesWithHeuristicInfo = new ArrayList<File>(
					10);

			List<Date> iterationToTimestampList = getIterationToTimestampMapping(
					run, FINAL_ITERATION, PATH_RUNS_A);

			File dirFile = new File(PATH_RUNS_A + run + "\\");
			if (!dirFile.exists()) {
				File[] dirsForRun = getAllMatchingFiles(run
						+ DIRECTORY_NAME_REGEXP_PARTLY, new File(PATH_RUNS_A));
				directoriesWithHeuristicInfo.addAll(Arrays.asList(dirsForRun));
			} else {
				directoriesWithHeuristicInfo.add(dirFile);
			}

			for (File directory : directoriesWithHeuristicInfo) {
				file = getHeuristicInfo(directory.getAbsolutePath());
				// get the end iteration in this folder to decide where to load
				// the candidates from
				int endIteration = FINAL_ITERATION;
				int startIteration = 0;
				if (directory.getName().contains("partly")) {
					startIteration = getAbsoluteStartIterationOfDirectory(directory);
					endIteration = getAbsoluteEndIterationOfDirectory(
							directory, startIteration);
				}
				List<Candidate> candidateResults = readInCandidates(directory,
						endIteration - startIteration);
				updateHeuristicInfoStatistics(file, heuristicResults,
						heuristicCandidates, tacticsApplicationResults,
						iterationToTimestampList, candidateResults, run);
			}
		}
		int sum = 0;
		System.out.println("\nReturned tactic candidates (avg. per run):");
		for (String className : heuristicResults.keySet()) {
			sum += heuristicResults.get(className);
			System.out.println(className
					+ ": "
					+ (((double) heuristicResults.get(className)) / (RUNS.length)));
		}
		System.out.println(((double) sum) / (RUNS.length));

		sum = 0;
		System.out
				.println("\nOverall matching tactic candidates (returned plus discarded, avg. per run):");
		for (String className : heuristicCandidates.keySet()) {
			sum += heuristicCandidates.get(className);
			System.out
					.println(className
							+ ": "
							+ (((double) heuristicCandidates.get(className)) / (RUNS.length)));
		}
		System.out.println(((double) sum) / (RUNS.length));

		StringBuffer buffer = new StringBuffer(10000);
		buffer
				.append("Tactic;iteration;run;relative delta cost;relative delta RT;\n");
		for (TacticApplicationResult tacticApplicationResult : tacticsApplicationResults) {
			buffer.append(tacticApplicationResult.getTactic().className
					+ ";"
					+ tacticApplicationResult.getIteration()
					+ ";"
					+ tacticApplicationResult.getRun()
					+ ";"
					+ tacticApplicationResult.getRelativeCostImprovement()
					+ ";"
					+ tacticApplicationResult
							.getRelativeResponseTimeImprovement() + ";\n");
		}

		try {
			FileWriter outputFile = new FileWriter(PATH_RUNS_A
					+ "tactic output.csv");
			outputFile.write(buffer.toString());
			outputFile.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		// print our the tactics application results
		System.out.println("\n\nTactics application results written to "
				+ PATH_RUNS_A + "tactic output.csv");

	}

	/**
	 * Need to manually conigure the number of objectives and genes for
	 * simplicity. The number of objectives is fixed to 2.
	 * 
	 * @param directory
	 * @param iteration
	 * @return
	 */
	private static List<Candidate> readInCandidates(File directory,
			int iteration) {

		File candidateFile = getFilesOfDirectory(directory.getAbsolutePath(),
				FILENAME_REGEXP_PREFIX_ALL_CANDIDATES + iteration
						+ FILENAME_REGEXP_SUFFIX)[0];

		List<Candidate> candidateList = new ArrayList<Candidate>();

		try {

			// Open the file
			FileInputStream fstream = new FileInputStream(candidateFile);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			// first line is headline.
			String strLine = br.readLine();
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				List<String> lineArray = Arrays.asList(strLine.split(";"));
				double cost = Double.parseDouble(lineArray.get(0));
				double responseTime = Double.parseDouble(lineArray.get(1));
				List<String> genome = lineArray.subList(2, 2 + NUMBER_OF_GENES);
				Candidate candidate = new Candidate(cost, responseTime, genome);
				candidateList.add(candidate);
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}

		return candidateList;

	}
	
	private static File getFileForIteration(String pathRuns, int iteration,
			int run) {
		return getFileForIteration(pathRuns, iteration, run, FILENAME_REGEXP_PREFIX);
	}
	
	private static int getNumberOfEvaluations(String pathRuns, int iteration,
			int run, ValueVector.ORIGIN origin, ValueVectorHandler handler) {
		
		File allCandFile = getFileForIteration(pathRuns, iteration, run, FILENAME_REGEXP_PREFIX_ALL_CANDIDATES);
		
		Collection<ValueVector> setAllCand = handler.getFromFile(allCandFile, origin, false);
		
		return setAllCand.size(); 
	}
	

	/**
	 * Get the minimal iteration of the passed run where the run has reached the passed number of evaluations. 
	 * 
	 * @param desiredNumberOfEvaluations Number of evaluations that the run should have completed in the desired iteration
	 * @param pathRuns The folder with the results with all runs 
	 * @param startIteration A hint for the iteration where to start searching. 
	 * @param run The number of the run in the pathRunsB folder
	 * @param origin The origin to set in the ValueVector (does not matter at this point)
	 * @return
	 */
	private static int getIterationForNumberOfEvaluations(int desiredNumberOfEvaluations, String pathRuns,
			int startIteration, int run, ValueVector.ORIGIN origin, ValueVectorHandler handler) {
		
		int evaluationsInCurrentIteration = -1;
		

		if (startIteration == Integer.MAX_VALUE){
			startIteration = 0;
		}

		try { 
			evaluationsInCurrentIteration = getEvaluationsForIteration(pathRuns, run, origin, startIteration, handler);
		} catch (IndexOutOfBoundsException e){
			// run pathsRuns does not have enough files, start search at iteration 0
		}
		
		//XXX: Do I need to delete duplicates?
		
		// each branch of the if contains a return statement. 
		if (evaluationsInCurrentIteration > desiredNumberOfEvaluations){
			// need to look whether there is a lower iteration with the desired number of iterations
			for (int i = startIteration - 1; i >= 0; i--){
				evaluationsInCurrentIteration = getEvaluationsForIteration(pathRuns, run, origin, i, handler);
				if (evaluationsInCurrentIteration < desiredNumberOfEvaluations){
					return i+1;
				}
			}
			System.out.println("Iteration 0 already contains more evaluations than requested, returning 0");
			return 0;
		} else if (evaluationsInCurrentIteration < desiredNumberOfEvaluations){
			// need to look for a higher iteration with the desired number of iterations.
			int i = 0;
			if (evaluationsInCurrentIteration != -1){
				// if we already know that has enough files to look for file number startIteration and we know the number of evaluations there.
				i = startIteration +1;
			}
			try {
				while ( true ){
					evaluationsInCurrentIteration = getEvaluationsForIteration(pathRuns, run,
							origin, i, handler);
					if (evaluationsInCurrentIteration >= desiredNumberOfEvaluations){
						return i;
					}
					i++;
				}
			} catch (Exception e){
				// end of available files has been reached
				System.out.println("Not enough evaluations in files for run "+run+" in folder "+pathRuns+".");
				throw new RuntimeException("Not enough evaluations in files for run "+run+" in folder "+pathRuns+". Requested "+desiredNumberOfEvaluations+" evaluations.");
			}
		} else {
			return startIteration;
		}
	}

	private static int getEvaluationsForIteration(
			String pathRuns, int run, ValueVector.ORIGIN origin, int i, ValueVectorHandler handler) {
		
		Integer evaluations = readIterationToEvaluationInfoFile(pathRuns, run, i);
		
		if (evaluations == null){
			File allCandFile = getFileForIteration(pathRuns, i, run, FILENAME_REGEXP_PREFIX_ALL_CANDIDATES);
			Collection<ValueVector> setAllCand = handler.getFromFile(allCandFile, origin, false);
			createIterationToEvaluationsInfoFile(pathRuns, run, i, setAllCand.size());
			evaluations = setAllCand.size(); 
		}
		return evaluations.intValue();
		
	}

	private static void createIterationToEvaluationsInfoFile(String pathRuns,
			int run, int i, int size) {
		
		File infoFile = new File(pathRuns+"run_"+run+"_iteration_"+i+"_number_of_evaluations.info");
		
		try {
			infoFile.createNewFile();
			java.io.FileOutputStream fos = new java.io.FileOutputStream(infoFile);
			java.io.ObjectOutputStream oos = new java.io.ObjectOutputStream(fos);

			oos.writeObject(size);
			oos.flush();
			fos.close();

		} catch (IOException e) {
			// this should not happen.
			e.printStackTrace();
		}
	}
	
	private static Integer readIterationToEvaluationInfoFile(String pathRuns, int run, int i){
		Integer value = null;
		File infoFile = new File(pathRuns+"run_"+run+"_iteration_"+i+"_number_of_evaluations.info");
		
		try{

			java.io.FileInputStream fis = new java.io.FileInputStream(infoFile);
			java.io.ObjectInputStream ois = new java.io.ObjectInputStream(fis);

			value = (Integer) ois.readObject();
			fis.close();
		}
		catch(Exception e){
			//return null, have yet to determine the number of evaluations 
		}
		return value;
	}
	
	private static File getNewestFileForRun(String pathRuns, int run, String fileType){
		File dirFile = new File(pathRuns + run + "\\");
		
		if (!dirFile.exists()) {
			// partial runs
			// get all files that match
			
			File[] dirsForRun = getAllMatchingFiles(run
					+ DIRECTORY_NAME_REGEXP_PARTLY, new File(pathRuns));
			
			// get newest directory
			if (dirsForRun.length > 0){
				File newestDirectory = getLatestFileFromSet(fileType, dirsForRun);
				return getLatestFileOfTypeFromDirectory(newestDirectory, fileType);
			} else {
				return null; 
			}
			
		} else {
			return getLatestFileOfTypeFromDirectory(dirFile, fileType);
		}
	}

	private static File getLatestFileFromSet(String fileType, File[] dirsForRun) {
		List<File> directoryList = Arrays.asList(dirsForRun);
		
		Comparator<File> comp = new CompareFilesByModifcationDateComparator();
		
		// sort initial population to put the first one back into the list
		Collections.sort(directoryList, comp);
		
		if (directoryList.size() > 0){
			File latestDir = directoryList.get(directoryList.size()-1);
			return latestDir;
		} else {
			System.out.println("Warning: No files of type "+fileType+" found in directory.");
			return null;
		}
	}

	private static File getLatestFileOfTypeFromDirectory(File dirFile, String fileType) {
		File[] matchingFiles = getAllMatchingFiles(fileType+"[0-9]*"+FILENAME_REGEXP_SUFFIX, dirFile);
		return getLatestFileFromSet(fileType, matchingFiles);
	}

	private static File getFileForIteration(String pathRuns, int iteration,
			int run, String fileType) {

		File dirFile = new File(pathRuns + run + "\\");
		if (!dirFile.exists()) {
			// partial runs
			// get all files that match

			File[] dirsForRun = getAllMatchingFiles(run
					+ DIRECTORY_NAME_REGEXP_PARTLY, new File(pathRuns));

			for (int i = 0; i < dirsForRun.length; i++) {
				File currentDir = dirsForRun[i];
				if (!currentDir.isDirectory()) {
					throw new RuntimeException("The files contained in "
							+ pathRuns + " starting with number " + run
							+ " must be directories.");
				}

				int absoluteStartIterationOfCurrentDir = getAbsoluteStartIterationOfDirectory(currentDir);

				int absoluteEndIterationOfCurrentDir = getAbsoluteEndIterationOfDirectory(
						currentDir, absoluteStartIterationOfCurrentDir);

				if (iteration >= absoluteStartIterationOfCurrentDir
						&& iteration <= absoluteEndIterationOfCurrentDir) {
					// file that we look for is in this directory at position
					// iteration - start
					return getFilesOfDirectory(currentDir.toString(),
							getRegExp(iteration
									- absoluteStartIterationOfCurrentDir, fileType))[0];
				}
			}
			throw new RuntimeException(
					"Could not find directory that contains partial results of iteration "
							+ iteration + " for run " + run
							+ " in result folder " + pathRuns+
							" (getting the latest file is not supported yet for directories with partial results, sorry)");
		} else {
			
			if (getAllMatchingFiles(getRegExp(0, fileType), dirFile).length == 1){
				if (getAllMatchingFiles(getRegExp(iteration, fileType), dirFile).length >= 1 ){
					return getFilesOfDirectory(dirFile.toString(), getRegExp(iteration, fileType))[0];
				} else {
					if (iteration == Integer.MAX_VALUE){
						File[] allFiles = getAllMatchingFiles(getRegExp("[0-9]*", fileType), dirFile);
						
						List<File> allFilesList = Arrays.asList(allFiles);
						
						Comparator<File> comp = new CompareFilesByModifcationDateComparator();
						
						// sort initial population to put the first one back into the list
						Collections.sort(allFilesList, comp);
						
						int lastIteration = allFilesList.size()-1;
						System.out.println("returning last iteration file "+lastIteration);
						
						return allFilesList.get(lastIteration);
					} else {
						throw new RuntimeException("Not enough files to get iteration "+iteration+".");
					}
				}
			} else {
				// one directory contains all partial runs
				
				// get all archive files
				String regex = fileType + "[0-9]*" + FILENAME_REGEXP_SUFFIX;
				File[] allFilesWithType = getAllMatchingFiles(regex, dirFile);
				
				// remove all of runs with 0
				String regexInitialPopulations = getRegExp(0, fileType);
				File[] initialPopulationFiles = getAllMatchingFiles(regexInitialPopulations, dirFile);
				

				List<File> allFilesWithTypeList = Arrays.asList(allFilesWithType);
				// the list does not support removeAll, so I have to make it an ArrayList explicitly. 
				ArrayList<File> list = new ArrayList<File>(allFilesWithTypeList.size());
				list.addAll(allFilesWithTypeList);
				allFilesWithTypeList = list;
				
				List<File> initialPopulationFilesList = Arrays.asList(initialPopulationFiles);
				
				allFilesWithTypeList.removeAll(initialPopulationFilesList);
				
				Comparator<File> comp = new CompareFilesByModifcationDateComparator();
				
				// sort initial population to put the first one back into the list
				Collections.sort(initialPopulationFilesList, comp);
				
				allFilesWithTypeList.add(initialPopulationFilesList.get(0));
				
				// sort by their date
				Collections.sort(allFilesWithTypeList, comp);
				
				// take the "iteration"'s entry
				File result;
				if (iteration != Integer.MAX_VALUE){
					try {
						result = allFilesWithTypeList.get(iteration);
					} catch (IndexOutOfBoundsException e) {
						System.out.println("Not enough files to get iteration "+iteration+", only "+(allFilesWithTypeList.size()-1)+" files available");
						//System.out.println("Not enough files to get iteration "+iteration+", only "+(allFilesWithTypeList.size()-1)+" files available. Taking newest one.");
						//result = allFilesWithTypeList.get(allFilesWithTypeList.size()-1);

						throw new RuntimeException("Not enough files to get iteration "+iteration+", only "+(allFilesWithTypeList.size()-1)+" files available");
					}
				} else {
					System.out.println("returning last iteration file "+(allFilesWithTypeList.size()-1));
					result = allFilesWithTypeList.get(allFilesWithTypeList.size()-1);
				}
				return result;
			}
		}
	}

	private static int getAbsoluteEndIterationOfDirectory(File currentDir,
			int absoluteStartIterationOfCurrentDir) {
		String[] currentDirNameArray = currentDir.getName().split(" ");
		String relativeEndIterationOfCurrentDirString = currentDirNameArray[currentDirNameArray.length - 1];
		int relativeEndIterationOfCurrentDir = Integer
				.parseInt(relativeEndIterationOfCurrentDirString);

		int absoluteEndIterationOfCurrentDir = absoluteStartIterationOfCurrentDir
				+ relativeEndIterationOfCurrentDir;
		return absoluteEndIterationOfCurrentDir;
	}

	private static int getAbsoluteStartIterationOfDirectory(File currentDir) {
		int absoluteStartIterationOfCurrentDir = 0;

		if (currentDir.getName().contains("+")) {
			// the start population of this dir is not 0, but the number before
			// the + sign.
			String partBeforePlus = currentDir.getName().substring(0,
					currentDir.getName().indexOf("+"));
			String[] splitDirNameArray = partBeforePlus.split(" ");
			// start iteration is now the last entry of this array
			String startIterationString = splitDirNameArray[splitDirNameArray.length - 1];
			absoluteStartIterationOfCurrentDir = Integer
					.parseInt(startIterationString);
		}
		return absoluteStartIterationOfCurrentDir;
	}

	private static File getHeuristicInfo(String dir) {
		File dirFile = new File(dir);
		if (!dirFile.exists()) {
			throw new IllegalArgumentException("Directory " + dir
					+ " does not exist.");
		}
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.matches(HEURISTICS_INFO_REGEXP);
			}
		};
		File[] file = dirFile.listFiles(filter);
		if (file.length < 1) {
			throw new IllegalArgumentException("Directory " + dir
					+ " contains no files to compare!");
		}
		if (file.length > 1) {
			throw new IllegalArgumentException("Directory " + dir
					+ " contains multiple files to compare!");
		}
		return dirFile.listFiles(filter)[0];
	}

	public static void updateHeuristicInfoStatistics(File file,
			HashMap<String, Integer> heuristicResults,
			HashMap<String, Integer> heuristicCandidates,
			List<TacticApplicationResult> tacticsApplicationResults,
			List<Date> iterationToTimestampList,
			List<Candidate> candidatesWithResults, int run) {
		try {

			// Open the file
			FileInputStream fstream = new FileInputStream(file);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				for (TacticClass className : TacticClass.values()) {
					if (strLine.contains(className.className)
							&& strLine.contains(CANDIDATE_RETURNED)) {
						heuristicResults.put(className.className,
								heuristicResults.get(className.className) + 1);
						TacticApplicationResult tacticResult = createNewTacticsApplicationResult(
								strLine, candidatesWithResults,
								iterationToTimestampList, className, run);
						if (tacticResult != null) {
							tacticsApplicationResults.add(tacticResult);
						}

					} else if (strLine.contains(className.className)) {
						heuristicCandidates
								.put(className.className, heuristicCandidates
										.get(className.className) + 1);
					}
				}
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
			e.printStackTrace();
		}
	}

	private static TacticApplicationResult createNewTacticsApplicationResult(
			String strLine, List<Candidate> candidatesWithResults,
			List<Date> iterationToTimestampList, TacticClass tactic, int run) {

		String[] lineArray = strLine.split(";");

		SimpleDateFormat simpleFormat = new SimpleDateFormat(
				"yyyy-MM-dd HH:mm:ss");
		try {
			// first entry is the timestamp
			Date tacticDate = simpleFormat.parse(lineArray[0]);
			int iteration = 0;

			for (Date date : iterationToTimestampList) {
				if (date.before(tacticDate) || date.equals(tacticDate)) {
					iteration = iterationToTimestampList.indexOf(date);
				}
			}

			// second entry is class name.

			List<String> lineEntryList = Arrays.asList(lineArray);

			List<String> genomeOffspring = lineEntryList.subList(2,
					2 + NUMBER_OF_GENES);
			// empty column in between
			List<String> genomeParent = lineEntryList.subList(
					3 + NUMBER_OF_GENES, 3 + 2 * NUMBER_OF_GENES);

			Candidate offspring = null;
			Candidate parent = null;
			for (Candidate candidate : candidatesWithResults) {
				if (candidate.hasGenome(genomeOffspring)) {
					offspring = candidate;
				}
				if (candidate.hasGenome(genomeParent)) {
					parent = candidate;
				}

			}
			// Not all returned tactic candidates are necessarily in
			// allCandidates, because the mating may
			// leave out candidates if the population is full. Thus, check for
			// null and if yes,
			// ignore the tactic candidate
			if (offspring != null) {
				TacticApplicationResult tacticResult = new TacticApplicationResult(
						iteration, parent.getResponseTime(), offspring
								.getResponseTime(), parent.getCost(), offspring
								.getCost(), tactic, run);
				return tacticResult;
			} else {
				return null;
			}

		} catch (ParseException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}

	}

	private static double mean(Collection<Double> set) {
		double sum = 0; // sum of all the elements
		for (double value : set) {
			sum += value;
		}
		return sum / set.size();
	}

	private static File[] getFilesOfDirectory(String dir,
			final String filenameRegExp) {
		File dirFile = new File(dir);
		if (!dirFile.exists()) {
			throw new IllegalArgumentException("Directory " + dir
					+ " does not exist.");
		}
		File[] file = getAllMatchingFiles(filenameRegExp, dirFile);
		if (file.length < 1) {
			throw new IllegalArgumentException("Directory " + dir
					+ " contains no files to compare for regex "
					+ filenameRegExp);
		}
		if (file.length > 1) {
			throw new IllegalArgumentException("Directory " + dir
					+ " contains multiple files to compare for regex "
					+ filenameRegExp);
		}
		return file;
	}

	/**
	 * Get all files inside dirFile that match the filenameRegExp regular
	 * expression.
	 * 
	 * @param filenameRegExp
	 * @param dirFile
	 * @return
	 */
	private static File[] getAllMatchingFiles(final String filenameRegExp,
			File dirFile) {
		FilenameFilter filter = new FilenameFilter() {
			public boolean accept(File dir, String name) {
				return name.matches(filenameRegExp);
			}
		};
		File[] file = dirFile.listFiles(filter);
		return file;
	}

	private static String getPath(String pathRun, int run) {
		return pathRun + run + "\\";
		// return pathRun + "\\";
	}

	private static String getRegExp(String iteration, String fileType) {
		return fileType + iteration + FILENAME_REGEXP_SUFFIX;
	}
	
	private static String getRegExp(int iteration, String fileType) {
		return getRegExp(""+iteration, fileType);
	}

	private static String getRegExpCorrection() {
		return FILENAME_REGEXP_CORRECTION;
	}

	private static double standardDeviation(Collection<Double> set) {
		double mean = mean(set);
		double sum = 0;
		for (double value : set) {
			sum += Math.pow(value - mean, 2);
		}
		return Math.sqrt(1.0 / (set.size() - 1) * sum);
	}

	private static double min(Collection<Double> set) {
		double min = Double.POSITIVE_INFINITY;
		for (double value : set) {
			if (value < min) {
				min = value;
			}
		}
		return min;
	}

	private static double max(Collection<Double> set) {
		double max = Double.NEGATIVE_INFINITY;
		for (double value : set) {
			if (value > max) {
				max = value;
			}
		}
		return max;
	}

	/**
	 * Generates random int between from (inclusive) and to (inclusive) based on
	 * uniform distribution
	 * 
	 * @param from
	 * @param to
	 * @return Random int with from <= return value <= to
	 */
	private static int getRandomInt(int from, int to) {
		Random random = new Random();
		return random.nextInt(to - from + 1) + from;
	}

	
	
	public static String logpath = "csvanalizer.log";
	public static Logger logger = Logger.getLogger("MyLog");
	public static FileHandler fh;
	public static FileOutputStream fos2;
	public static DataOutputStream output;
	public static void initLogger() {
		try {
			fos2 = new FileOutputStream(logpath);
			output = new DataOutputStream(fos2);
			
			output.writeBytes("");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void log(String what){
		
		try {
			//System.out.println(what);
			//output.writeBytes(what+"\r\n");
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	

	
}
