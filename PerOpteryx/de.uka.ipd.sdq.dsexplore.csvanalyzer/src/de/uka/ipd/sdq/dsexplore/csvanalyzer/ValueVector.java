/**
 * 
 */
package de.uka.ipd.sdq.dsexplore.csvanalyzer;

import java.util.Collection;
import java.util.List;
import java.util.Map.Entry;

import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Value;
import org.opt4j.core.domination.ParetoDomination;

/**
 * @author Tom Beyer
 * 
 */
public class ValueVector {
	
	private Objectives values;
	private boolean dominated = false;
	private ORIGIN origin;
	
	private List<Objective> objectiveList;
	
	private String genome;
	private String homeFolder;
	
	public enum ORIGIN {A, B};

	public ValueVector(List<String> values, ORIGIN origin, List<Objective> objectiveList, String genome, String folder) {
		
		this.genome = genome;
		this.homeFolder = folder;
		
		ParetoDomination dominationStrategy = new ParetoDomination();
		this.values = new Objectives(dominationStrategy);
		this.objectiveList = objectiveList;
		
		for (int i = 0; i < values.size(); i++) {
			String value = values.get(i);
			try {
				double tmp_value = Double.valueOf(value);
				
				if(Starter.HAS_SATISFACTION_CONSTRAINTS){
					switch(Starter.SATISFACTION_OPERATOR) {
					case less:
						if(!(tmp_value < Starter.SATISFACTION_CONSTRAINTS[i])) {
				this.values.add(objectiveList.get(i),Double.valueOf(value));
						} else {
							this.values.add(objectiveList.get(i),Starter.SATISFACTION_CONSTRAINTS[i]);
						}
						break;
					default:
						throw new RuntimeException("Operator is not handled" + Starter.SATISFACTION_OPERATOR );
					}
				} else {
					this.values.add(objectiveList.get(i),Double.valueOf(value));
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

	public Objectives getValues() {
		return values;
	}

	@Deprecated
	public Double getValue(int index) {
		return values.get(this.objectiveList.get(index)).getDouble();
	}
	
	public Double getValue(Objective criterion) {
		return values.get(criterion).getDouble();
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
		return this.values.dominates(comparison.getValues());
	}

	public void setDominated(boolean dominated) {
		this.dominated = dominated;
	}

	public boolean isDominated() {
		return dominated;
	}

	
	public ORIGIN getOrigin() {
		return origin;
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



	double[] asArray() {
		double[] result = new double[this.values.size()];
		int i = 0;
		for (Entry<Objective, Value<?>> value : this.values) {
			result[i] = value.getValue().getDouble().doubleValue();
			i++;
		};

		return result;
	}

	public String getGenome() {
		return this.genome;
	}

	public String getHomeFolder() {
		return this.homeFolder;
	}

	public List<Objective> getObjectiveList() {
		return objectiveList;
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
	
	public double getHypervolumeDifference(){
		return this.hypervolumeA - this.hypervolumeB;
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
	
	/**
	 * Returns the mean of hypervolume union - hypervolume B
	 * @param collection
	 * @return
	 */
	public static double getMeanHyperVolumeIndicatorAOverB(Collection<HypervolumeResult> collection){
		
		double mean = 0;
		for (HypervolumeResult hypervolumeResult : collection) {
			mean += hypervolumeResult.getHyperVolumeIndicatorAOverB();
		}
		mean = mean / collection.size();
		return mean;
	}
	
	/**
	 * Returns the mean difference of hypervolumes: hypervolume A - hypervolume B
	 * @param collection
	 * @return
	 */
	public static double getMeanHypervolumeDifference(Collection<HypervolumeResult> collection){
		
		double mean = 0;
		for (HypervolumeResult hypervolumeResult : collection) {
			mean += hypervolumeResult.getHypervolumeDifference();
		}
		mean = mean / collection.size();
		return mean;
	}
	

	
}

