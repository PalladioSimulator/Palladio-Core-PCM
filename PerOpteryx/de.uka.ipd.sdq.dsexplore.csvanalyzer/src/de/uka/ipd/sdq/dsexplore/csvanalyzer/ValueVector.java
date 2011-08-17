/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.csvanalyzer;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import jmetal.qualityIndicator.Hypervolume;

/**
 * @author Tom Beyer
 * 
 */
public class ValueVector {
	
	private List<Double> values = new ArrayList<Double>();
	private boolean dominated = false;
	private ORIGIN origin;
	
	public enum ORIGIN {A, B};

	public ValueVector(List<String> values, ORIGIN origin) {
		for (int i = 0; i < values.size(); i++) {
			String value = values.get(i);
			try {
				double tmp_value = Double.valueOf(value);
				
				if(Starter.HAS_SATISFACTION_CONSTRAINTS){
					switch(Starter.SATISFACTION_OPERATOR) {
					case less:
						if(!(tmp_value < Starter.SATISFACTION_CONSTRAINTS[i])) {
				this.values.add(Double.valueOf(value));
						} else {
							this.values.add(Starter.SATISFACTION_CONSTRAINTS[i]);
						}
						break;
					default:
						throw new RuntimeException("Operator is not handled" + Starter.SATISFACTION_OPERATOR );
					}
				} else {
					this.values.add(Double.valueOf(value));
				}
				
			} catch (NumberFormatException e) {
				throw new NumberFormatException("Cannot convert " + value + " to double");
			}
		}
		this.origin = origin;
	}

	/*
	 * public ValueVector(Collection<Double> values) { for (double value :
	 * values) { this.values.add(value); } }
	 */

	public List<Double> getValues() {
		return values;
	}

	public Double getValue(int index) {
		return values.get(index);
	}

	/**
	 * Returns true if {@link ValueVector} comparison is strongly 
	 * dominated by this {@link ValueVector}, i.e. no value of {@link ValueVector}
	 * comparison is better than and value of this vector, and at least one 
	 * value of this vector is better than a value of {@link ValueVector} comparison. 
	 * @param comparison The {@link ValueVector} to compare to. 
	 * @return
	 * @throws IllegalArgumentException if the vectors have different lengths. 
	 */
	public boolean isDominating(ValueVector comparison) {
		if (comparison.getValues().size() != getValues().size()) {
			throw new IllegalArgumentException(
					"Both vectors must have the same dimension.");
		}
		for (int index = 0; index < getValues().size(); index++) {
			if (getValue(index) > comparison.getValue(index)) {
				return false;
			}
		}
		for (int index = 0; index < getValues().size(); index++) {
			if (getValue(index) < comparison.getValue(index)) {
				return true;
			}
		}
		return false;
	}

	public void setDominated(boolean dominated) {
		this.dominated = dominated;
	}

	public boolean isDominated() {
		return dominated;
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
	public static ValueVector getValueVectorFromLine(String line, ORIGIN origin) {
		List<String> result = new ArrayList<String>();
		String[] matches = line.split(Starter.CSV_SEPARATOR);
		for (int i = 0; i < Starter.NUMBER_OF_COLUMNS && i < matches.length; i++) {
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
		return new ValueVector(result, origin);
	}

	/**
	 * Reads only feasible candidates if Starter.HAS_INFEASIBILITY_CONSTRAINTS is true.
	 * @param file
	 * @param origin
	 * @return
	 */
	public static List<ValueVector> getFromFile(File file, ORIGIN origin) {
		List<ValueVector> set = new ArrayList<ValueVector>();
		try {
			// Open the file
			FileInputStream fstream = new FileInputStream(file);
			// Get the object of DataInputStream
			DataInputStream in = new DataInputStream(fstream);
			BufferedReader br = new BufferedReader(new InputStreamReader(in));
			String strLine;
			if (Starter.HAS_HEADER) {
				br.readLine(); // ignore header
			}
			// Read File Line By Line
			while ((strLine = br.readLine()) != null) {
				// Print the content on the console
				ValueVector v = getValueVectorFromLine(strLine, origin);
				if (v != null) { 
					if(!set.contains(v)) {
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
	
	public ORIGIN getOrigin() {
		return origin;
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
	
	public boolean equals(Object o) {
		ValueVector vector = (ValueVector) o;
		if (vector.getValues().size() != this.getValues().size()) {
			return false;
		}
		for (int i = 0; i < vector.getValues().size(); i++) {
			if (!vector.getValue(i).equals(this.getValue(i))) {
				return false;
			}
		}
		return true;
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
			double[] infeasibilityConstraints, int numberOfObjectives, boolean considerConstraints) {
		
		if (infeasibilityConstraints.length != numberOfObjectives){
			throw new RuntimeException("Number of columns must match infeasibility constraint array dimension, even if no constraints are considered.");
		}
		
		double[] constraints = infeasibilityConstraints;

		
		if (considerConstraints){
			//if considerConstraints == true, we assume that all infeasible are already removed.
			
			//if constraints: determine minimal and maximum value using constraints
			
		} else {
			// if no constraints: determine minimal and maximum value just like that
			// --> put values in pareto true front, then Hypervolume will determine min and max
			
			constraints = new double[numberOfObjectives];
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
		double[][] frontA = ValueVector.asDoubleArrays(setA,numberOfObjectives);
		double[][] frontB = ValueVector.asDoubleArrays(setB,numberOfObjectives);
		
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
		for (int i = 0; i < constraints.length; i++) {
			for (int j = 0; j < constraints.length; j++) {
				if (j == i){
					referenceFront[i][j] = 0.0;
				} else {
					referenceFront[i][j] = constraints[j];
				}
			} 
		}
		
		//double[][] referenceFront = {{0.0,0.0,0.0},{0.0,0.0,0.0},{0.0,0.0,0.0}};
		
		
		Hypervolume hypervolume = new Hypervolume();
		
		double hyperA = hypervolume.hypervolume(frontA, referenceFront, 3);
		double hyperB = hypervolume.hypervolume(frontB, referenceFront, 3);
		
		//System.out.println("Hypervolume of A: "+hyperA);
		//System.out.println("Hypervolume of B: "+hyperB);
		
		Collection<ValueVector> setUnion = ValueVector.getParetoOptimalSet(setA, setB);
		double[][] frontUnion = ValueVector.asDoubleArrays(setUnion, numberOfObjectives);
		
		double hyperUnion = hypervolume.hypervolume(frontUnion, referenceFront, numberOfObjectives);
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

	double[] asArray() {
		double[] result = new double[this.values.size()];
		int i = 0;
		for (Double value : this.values) {
			result[i] = value.doubleValue();
			i++;
		};

		return result;
	}

	/**
	 * Puts the maximum values of each dimension in the passed array, if larger that what is already in the array.
	 * Ignore infinity values. 
	 * @param set
	 * @param constraints
	 * @return
	 */
	public static double[] setToMaximumOfPopulation(
			Collection<ValueVector> set, double[] constraints) {
		
		for (ValueVector v : set) {
			
			for (int i = 0; i < constraints.length; i++) {
				double value = v.getValue(i);
				if (value > constraints[i]){
					if (!Double.isInfinite(value)){
						constraints[i] = value;
					}
				}
			}
			
		}

		return constraints;
	}

}

class HypervolumeResult{
	
	private double hypervolumeA;
	private double hypervolumeB;
	private double hypervolumeUnion;
	
	private enum ResultType {A, B, UNION};
	
	
	public HypervolumeResult(double hypervolumeA, double hypervolumeB, double hyperUnion) {
		super();
		this.hypervolumeA = hypervolumeA;
		this.hypervolumeB = hypervolumeB;
		this.hypervolumeUnion = hyperUnion;
	}
	
	public double getHyperVolumeA(){
		return this.hypervolumeA;
	}
	
	public double getHyperVolumeB(){
		return this.hypervolumeB;
	}
	
	public double getHyperVolumeUnion(){
		return this.hypervolumeUnion;
	}
	
	public double getHyperVolumeIndicatorAOverB(){
		return this.hypervolumeUnion - this.hypervolumeB;
	}
	
	public double getHyperVolumeIndicatorBOverA(){
		return this.hypervolumeUnion - this.hypervolumeA;
	}
	
	private static double getMeanHyperVolumeFor(Collection<HypervolumeResult> collection, ResultType type ){
		
		double mean = 0;
		for (HypervolumeResult hypervolumeResult : collection) {
			mean += hypervolumeResult.getValueForType(type);
		}
		mean = mean / collection.size();
		return mean;
	}
	
	private static double getMinHyperVolumeFor(Collection<HypervolumeResult> collection, ResultType type ){
		
		double min = Double.POSITIVE_INFINITY;
		for (HypervolumeResult hypervolumeResult : collection) {
			double value = hypervolumeResult.getValueForType(type);
			if (value < min){
				min = value;
			}
		}
		return min;
	}
	
	private static double getMaxHyperVolumeFor(Collection<HypervolumeResult> collection, ResultType type ){
		
		double max = Double.NEGATIVE_INFINITY;
		for (HypervolumeResult hypervolumeResult : collection) {
			double value = hypervolumeResult.getValueForType(type);
			if (value > max){
				max = value;
			}
		}
		return max;
	}
	
	private double getValueForType(ResultType type) {
		switch (type) {
		case A:
			return this.getHyperVolumeA();
		case B:
			return this.getHyperVolumeB();
		case UNION:
			return this.getHyperVolumeUnion();
		}
		return 0;
	}

	public static double getMeanHyperVolumeB(Collection<HypervolumeResult> collection){
		return getMeanHyperVolumeFor(collection, ResultType.B);
	}
	
	public static double getMeanHyperVolumeA(Collection<HypervolumeResult> collection){
		return getMeanHyperVolumeFor(collection, ResultType.A);
	}
	
	public static double getMeanHyperVolumeUnion(Collection<HypervolumeResult> collection){
		return getMeanHyperVolumeFor(collection, ResultType.UNION);
	}
	
	public static double getMinHyperVolumeB(Collection<HypervolumeResult> collection){
		return getMinHyperVolumeFor(collection, ResultType.B);
	}
	
	public static double getMinHyperVolumeA(Collection<HypervolumeResult> collection){
		return getMinHyperVolumeFor(collection, ResultType.A);
	}
	
	public static double getMinHyperVolumeUnion(Collection<HypervolumeResult> collection){
		return getMinHyperVolumeFor(collection, ResultType.UNION);
	}
	
	public static double getMaxHyperVolumeB(Collection<HypervolumeResult> collection){
		return getMaxHyperVolumeFor(collection, ResultType.B);
	}
	
	public static double getMaxHyperVolumeA(Collection<HypervolumeResult> collection){
		return getMaxHyperVolumeFor(collection, ResultType.A);
	}
	
	public static double getMaxHyperVolumeUnion(Collection<HypervolumeResult> collection){
		return getMaxHyperVolumeFor(collection, ResultType.UNION);
	}
	
}

