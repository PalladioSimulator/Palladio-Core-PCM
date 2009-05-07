package de.uka.ipd.sdq.TimerMeter;

/**
 * This interface defines the analysis methods available to study the effects 
 * of rounding and truncating. It was designed to study the effects in 
 * timer method implementations. The methods prefixed with "v_" analyse values,
 * while those prefixed with "d_" analyse intervals (considered as distances 
 * here). The uncommented methods are for future implementations that cache 
 * the parameters and the computed values/distances.
 * 
 * @author Michael Kuperberg
 *
 */
public interface EffectFinder {
	public int[] d_findFirstOccurenceOfDistanceTriples_Rounding(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findFirstOccurenceOfDistanceTriples_Truncating(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findFirstOccurenceOfDistanceTuples_Rounding(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findFirstOccurenceOfDistanceTuples_Truncating(double accuracy, double epsilon, int stepsToTry);
	
//	public int[] d_findLargestDistanceNeighbors_Rounding(double accuracy, double epsilon, int stepsToTry);
//	
//	public int[] d_findLargestDistanceNeighbors_Truncating(double accuracy, double epsilon, int stepsToTry);
//	
//	public int[] d_findSmallestDistanceNeighbors_Rounding(double accuracy, double epsilon, int stepsToTry);
//	
//	public int[] d_findSmallestDistanceNeighbors_Truncating(double accuracy, double epsilon, int stepsToTry);
//	
	public int v_findFirstEffectlessValue_Rounding(double accuracy, double epsilon, int stepsToTry);
	
	public int v_findFirstEffectlessValue_Truncating(double accuracy, double epsilon, int stepsToTry);
	
	public int v_findLargestValueRoundingDown_Rounding(double accuracy, double epsilon, int stepsToTry);
	
	public int v_findLargestValueRoundingUp_Rounding(double accuracy, double epsilon, int stepsToTry);
	
	public int v_findLargestValueTruncation_Truncating(double accuracy, double epsilon, int stepsToTry);

}
//public int[] d_findFirstOccurenceOfDistanceTriples_Rounding() throws EffectFinderUninitialisedException;
//public int[] d_findFirstOccurenceOfDistanceTriples_Truncating() throws EffectFinderUninitialisedException;
//public int[] d_findFirstOccurenceOfDistanceTuples_Rounding() throws EffectFinderUninitialisedException;
//public int[] d_findFirstOccurenceOfDistanceTuples_Truncating() throws EffectFinderUninitialisedException;
//public int[] d_findLargestDistanceRoundingNeighbors() throws EffectFinderUninitialisedException;
//public int[] d_findLargestDistanceTruncatedNeighbors() throws EffectFinderUninitialisedException;
//public int[] d_findSmallestDistanceRoundingNeighbors() throws EffectFinderUninitialisedException;
//public int[] d_findSmallestDistanceTruncatedNeighbors() throws EffectFinderUninitialisedException;
//public int v_findFirstEffectlessValueRounding() throws EffectFinderUninitialisedException;
//public int v_findFirstEffectlessValueTruncation() throws EffectFinderUninitialisedException;
//public int v_findLargestValueRoundingDown() throws EffectFinderUninitialisedException;
//public int v_findLargestValueRoundingUp() throws EffectFinderUninitialisedException;
//public int v_findLargestValueTruncation() throws EffectFinderUninitialisedException;
