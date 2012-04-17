package de.uka.ipd.sdq.dsexplore.csvanalyzer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map.Entry;

import jmetal.qualityIndicator.Hypervolume;

import org.opt4j.core.DoubleValue;
import org.opt4j.core.Objective;
import org.opt4j.core.Objective.Sign;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.domination.ParetoDomination;

import de.uka.ipd.sdq.dsexplore.csvanalyzer.ValueVector.ORIGIN;

public class ValueVectorHandler {
	
	private List<Objective> objectiveCache = new ArrayList<Objective>();
	
	public ValueVectorHandler(){
		
		
		
	}
	
	public int getNumberOfObjectives(){
		return this.objectiveCache.size();
	}
	
	public List<Objective> getObjectives(){
		return this.objectiveCache;
	}
	
	
	public static Collection<ValueVector> getParetoOptimalSet(
			Collection<ValueVector> set1, Collection<ValueVector> set2) {
		resetDominationForBoth(set1, set2);
		for (ValueVector v1 : set1) {
			for (ValueVector v2 : set2) {
				if (v1.isDominating(v2)) {
					v2.setDominated(true);
				}
			}
		}
		for (ValueVector v2 : set2) {
			for (ValueVector v1 : set1) {
				if (v2.isDominating(v1)) {
					v1.setDominated(true);
				}
			}
		}
		Collection<ValueVector> paretoOptimalSet = new ArrayList<ValueVector>();
		paretoOptimalSet.addAll(getNonDominatedSet(set1));
		paretoOptimalSet.addAll(getNonDominatedSet(set2));
		return paretoOptimalSet;
	}

	public static Collection<ValueVector> getNonDominatedSet(
			Collection<ValueVector> set) {
		Collection<ValueVector> paretoOptimalSet = new ArrayList<ValueVector>();
		for (ValueVector v : set) {
			if (!v.isDominated()) {
				paretoOptimalSet.add(v);
			}
		}
		return paretoOptimalSet;
	}

	public static void resetDominationForBoth(Collection<ValueVector> set1,
			Collection<ValueVector> set2) {
		resetDomination(set1);
		resetDomination(set2);
	}
	
	public static void resetDomination(Collection<ValueVector> set){
		for (ValueVector v : set) {
			v.setDominated(false);
		}
	}

	/**
	 * Reads only feasible candidates if Starter.HAS_INFEASIBILITY_CONSTRAINTS is true.
	 * Returns null for infeasible ones. 
	 * @param line
	 * @param origin
	 * @return
	 */
	public static ValueVector getValueVectorFromLine(String line, ORIGIN origin, List<Objective> objectiveList, String folderName) {
		List<String> result = new ArrayList<String>();
		String[] matches = line.split(Starter.CSV_SEPARATOR);
		for (int i = 0; i < objectiveList.size() && i < matches.length; i++) {
			result.add(matches[i]);
			if(Starter.HAS_INFEASIBILITY_CONSTRAINTS){
				switch(Starter.INFEASIBILITY_OPERATOR) {
				case less:
					if (!(Double.valueOf(matches[i]) < Starter.INFEASIBILITY_CONSTRAINTS[i])) {
						return null;
					}
					break;
				default:
					throw new RuntimeException("Operator is not handled" + Starter.INFEASIBILITY_OPERATOR );
				}
			}
		}
		// remaining line as string
		String genome = "";
		for (int i = objectiveList.size(); i < matches.length; i++) {
			genome += matches[i]+Starter.CSV_SEPARATOR;
		} 
		
		return new ValueVector(result, origin, objectiveList, genome, folderName);
	}
	
	/**
	 * Reads only feasible candidates if Starter.HAS_INFEASIBILITY_CONSTRAINTS is true.
	 * Calls {@link #getFromFile(File, ORIGIN, boolean)} with deleteDuplicates = true.
	 * @param file
	 * @param origin
	 * @return
	 */
	public List<ValueVector> getFromFile(File file, ORIGIN origin) {
		return getFromFile(file, origin, true);
	}

	/**
	 * Reads only feasible candidates if Starter.HAS_INFEASIBILITY_CONSTRAINTS is true.
	 * @param file
	 * @param origin
	 * @param deleteDuplicates 
	 * @return
	 */
	public List<ValueVector> getFromFile(File file, ORIGIN origin, boolean deleteDuplicates) {
		List<ValueVector> set = new ArrayList<ValueVector>();
		try {
			// Open the file
			FileInputStream fstream = new FileInputStream(file);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			
			List<Objective> objectiveList = new ArrayList<Objective>();
			if (Starter.HAS_HEADER) {
				String headline = br.readLine(); 
				String[] headlineArray = headline.split(";");
				for (String headlineEntry : headlineArray) {
					Objective objective = getObjectiveForHeadline(headlineEntry);
					if (objective == null){
						// end of objectives in file
						break;
					}
					objectiveList.add(objective);
				}
			}
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				ValueVector v = getValueVectorFromLine(strLine, origin, objectiveList, file.getCanonicalPath());
				if (v != null) { 
					if(!deleteDuplicates || !set.contains(v)) {
					set.add(v);
				}
			}
			}
			// Close the input stream
			in.close();
		} catch (Exception e) {// Catch exception if any
			System.err.println("Error: " + e.getMessage());
		}
		return set;
	}
	
	/**
	 * Calculate Zitzler's coverage indicator I_C(origin, anderer): 
	 * "Coverage indicator I_C where I_C(A,B) gives the fraction of solutions in B 
	 * that are weakly dominated by at least one solution in A. IC(A,B) = 1 is 
	 * equivalent to [...] A weakly dominates B."
	 * (from Zitzler 2002 TR Performance Assessment)
	 * @param origin
	 * @return
	 */
	public static double getCoverageIndicatorZitzler(ORIGIN origin){
		return 0.0; //TODO;
	}
	
	public static double getCoverageForOptimalSet(Collection<ValueVector> paretoOptimalSet, ORIGIN origin){
		int counter = 0;
		for (ValueVector v : paretoOptimalSet) {
			if (v.getOrigin() == origin) {
				counter++;
			}
		}
		return (new Integer(counter)).doubleValue() / (new Integer(paretoOptimalSet.size())).doubleValue();
	}
	
	public static double getCoverage(Collection<ValueVector> set1, Collection<ValueVector> set2, ORIGIN origin) {
		if(set1.size() == 0 && set2.size() == 0) {//No feasible solutions in any set
			return 0.5;
		}
		Collection<ValueVector> paretoOptimalSet = getParetoOptimalSet(set1, set2);
		
		double coverage =  getCoverageForOptimalSet(paretoOptimalSet, origin);
		
		Starter.log("  size Pareto set: "+paretoOptimalSet.size()+",coverage "+coverage);
		
		return coverage;
	}
	
	public static Collection<ValueVector> getParetoOptimalSubset(Collection<ValueVector> set){
		resetDomination(set);
		
		Collection<ValueVector> result = new ArrayList<ValueVector>(set.size());
		
		for (ValueVector valueVector : set) {
			if (!valueVector.isDominated()){
				for (ValueVector valueVector2 : set) {
					if (valueVector.isDominating(valueVector2)){
						valueVector2.setDominated(true);
					}
				}
			}
		}
		
		for (ValueVector valueVector : set) {
			if (!valueVector.isDominated())
				result.add(valueVector);
		}
		
		return result;
		
		
	}
	

	/**
	 * Assumes minimisation. Either an array with the same number of dimensions as the value vectors is passed, 
	 * or an exception is thrown. 
	 * Constraints are also ignored if considerConstraints is false. In that case, the maximum value in each dimension
	 * is used as the reference.
	 * Assumes that infeasible candidates are already removed if considerConstraints is true.
	 * All objective values are assumed to be positive.   
	 * @param setA
	 * @param setB
	 * @param originToBeChecked
	 * @param infeasibilityConstraints
	 * @param considerConstraints Used to determine which region to use to limit the hypervolume
	 * @return
	 */
	public static HypervolumeResult getHypervolume(Collection<ValueVector> setA,
			Collection<ValueVector> setB,
			Objectives infeasibilityConstraints, List<Objective> objectives, boolean considerConstraints) {
		
		int numberOfObjectives = objectives.size();
		
		if (infeasibilityConstraints.size() != numberOfObjectives){
			throw new RuntimeException("Number of columns must match infeasibility constraint array dimension, even if no constraints are considered.");
		}
		
		Objectives constraints = new Objectives(new ParetoDomination());
	
		if (considerConstraints){
			//if considerConstraints == true, we assume that all infeasible are already removed.
//			for (Objectives constraint : infeasibilityConstraints) {
//				constraints.add(constraint);
//			}
			constraints = infeasibilityConstraints;
			//if constraints: determine minimal and maximum value using constraints
			
		} else {
			// if no constraints: determine minimal and maximum value just like that
			// --> put values in pareto true front, then Hypervolume will determine min and max
			
			//constraints = new ArrayList<Double>();
			for (Objective constraint : objectives) {
				constraints.add(constraint, 0);
			}
			
			constraints = setToMaximumOfPopulation(setA, constraints);
			constraints = setToMaximumOfPopulation(setB, constraints);
			
			System.out.println("Warning: Using reference values per run, the results may be not comparable because runs have different min and max values.");
		}

	
//		String constraintsString = "[";
//		for (double d : constraints) {
//			constraintsString += d + ", ";
//		}
		//System.out.println("Reference values: "+constraintsString+"]");
		
		
		// convert to doubles
		double[][] frontA = asDoubleArrays(setA,numberOfObjectives);
		double[][] frontB = asDoubleArrays(setB,numberOfObjectives);
		
		// make a reference front that contains the maximum and minimum values for each dimension and one 0 value
		// reference front is thus a matrix size numberOfObjectives*numberOfObjectives
		// in 2 d case: 
		//  [ 0  c2 ]
		//  [ c1 0  ]
		// in 3d case: 
		//  [ 0  c2  c3] 
		//  [ c1 0   c3]  
		//  [ c1 c2  0 ]  

		
		double[][] referenceFront = new double[numberOfObjectives][numberOfObjectives];

		Iterator<Entry<Objective, Value<?>>> it = constraints.iterator();
		int j = 0;
		for (; it.hasNext();) {
			Entry<Objective, Value<?>> constraintEntry = it.next();
			
//		for (int i = 0; i < constraints.size(); i++) {
			for (int i = 0; i < constraints.size(); i++) {
				if (j == i){
					referenceFront[i][j] = 0.0;
				} else {
					referenceFront[i][j] = constraintEntry.getValue().getDouble();
				}
			} 
			j++;
		}
		
		//double[][] referenceFront = {{0.0,0.0,0.0},{0.0,0.0,0.0},{0.0,0.0,0.0}};
		
		
		Hypervolume hypervolume = new Hypervolume();
		
		// calculate whether min (true) or max (false)
		boolean[] isMinimisedObjective = new boolean[objectives.size()];
		for (int i = 0; i < isMinimisedObjective.length; i++) {
			isMinimisedObjective[i] = objectives.get(i).getSign().equals(Objective.Sign.MIN);
		}
				
		double hyperA = hypervolume.hypervolume(frontA, referenceFront, numberOfObjectives, isMinimisedObjective);
		double hyperB = hypervolume.hypervolume(frontB, referenceFront, numberOfObjectives, isMinimisedObjective);
		
		//System.out.println("Hypervolume of A: "+hyperA);
		//System.out.println("Hypervolume of B: "+hyperB);
		
		Collection<ValueVector> setUnion = getParetoOptimalSet(setA, setB);
		double[][] frontUnion = asDoubleArrays(setUnion, numberOfObjectives);
		
		double hyperUnion = hypervolume.hypervolume(frontUnion, referenceFront, numberOfObjectives, isMinimisedObjective);
		//System.out.println("Hypervolume of Union: "+hyperUnion);
		
		
		HypervolumeResult result = new HypervolumeResult(hyperA, hyperB, hyperUnion);
		
		//System.out.println("Hypervolume of A over B: "+ (hyperUnion - hyperB));
		//System.out.println("Hypervolume of B over A: "+ (hyperUnion - hyperA));
				
		// metric: D(A,B) := S(A+B) -S(B)
		return result;
		
		
		// 
		
		
/*		if (!considerConstraints){
			
			for (int i = 0; i < constraints.length; i++) {
				constraints[i] = Double.NEGATIVE_INFINITY;
			}
			
			// set constraints to the maximum in the population
			constraints = setToMaximumOfPopulation(setA,constraints);
			constraints = setToMaximumOfPopulation(setB,constraints);
			
		}*/
		
		
		
		// assume 
		

	}

	private static void removeInfeasible(Collection<ValueVector> setA,
			boolean considerConstraints) {
		
		
	}

	private static double[][] asDoubleArrays(Collection<ValueVector> setA, int numberOfDimensions) {
		double[][] result= new double[setA.size()][numberOfDimensions];
		int i = 0;
		for (ValueVector valueVector : setA) {
			double[] values = valueVector.asArray();
			result[i] = values;
			i++;
		}
		return result;
	}
	
	/**
	 * Puts the maximum values of each dimension in the passed array, if larger that what is already in the array.
	 * Ignore infinity values. 
	 * @param set
	 * @param max
	 * @return
	 */
	public static Objectives setToMaximumOfPopulation(
			Collection<ValueVector> set, Objectives max) {
		
		if (max == null){
			ParetoDomination dominationStrategy = new ParetoDomination();
			max = new Objectives(dominationStrategy);
		}
		
		for (ValueVector v : set) {
			
			for (Objective o : v.getValues().getKeys()) {
				Value currentMaxValue = max.get(o);
				if (currentMaxValue == null){
					currentMaxValue = new DoubleValue(0.0);
					max.add(o, 0.0);
				}
				double value = v.getValue(o);
				if (value > currentMaxValue.getDouble()){
					if (!Double.isInfinite(value)){
						currentMaxValue.setValue(value);
					}
				}
			}
			
		}

		return max;
	}
	

	/**
	 * helper variable only needed in the method below. 
	 */
	private static boolean hasNotifiedAboutEquivalentCost = false; 	
	
		public Objective getObjectiveForHeadline(String headlineEntry){
		
		// check cache 
		for (Objective objective : this.objectiveCache) {
			if (objective.getName().equals(headlineEntry)){
				return objective;
			}
			if (objective.getName().contains("cost") && headlineEntry.contains("cost")){
				if (!hasNotifiedAboutEquivalentCost){
					System.out.println("Warning: handling "+ objective.getName() +" and "+headlineEntry+" as equivalent, change ValueVector line 450 if not wanted anymore.");
					hasNotifiedAboutEquivalentCost = true;
				}
				return objective;
			}
		}
		
		// reuse objectives... 
		Objective objective;
		if (headlineEntry.toLowerCase().contains("cost")
				|| headlineEntry.toLowerCase().contains("response time")
				|| headlineEntry.toLowerCase().contains("pofod")){
			objective = new Objective(headlineEntry, Sign.MIN);
			this.objectiveCache.add(objective);
		} else if (headlineEntry.toLowerCase().contains("throughput")){
			objective = new Objective(headlineEntry, Sign.MAX);
			this.objectiveCache.add(objective);
		} else {
			// this is not an objective, leave it null
			objective = null;
		}
		
		return objective;
	}


}
