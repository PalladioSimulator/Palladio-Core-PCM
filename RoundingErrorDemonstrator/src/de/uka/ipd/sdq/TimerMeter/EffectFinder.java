package de.uka.ipd.sdq.TimerMeter;

import de.uka.ipd.sdq.TimerMeter.exceptions.EffectFinderUninitialisedException;

public interface EffectFinder {
	public int[] d_findFirstOccurenceOfDistanceTriples_Rounding() throws EffectFinderUninitialisedException;
	public int[] d_findFirstOccurenceOfDistanceTriples_Rounding(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findFirstOccurenceOfDistanceTriples_Truncating() throws EffectFinderUninitialisedException;
	public int[] d_findFirstOccurenceOfDistanceTriples_Truncating(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findFirstOccurenceOfDistanceTuples_Rounding() throws EffectFinderUninitialisedException;
	public int[] d_findFirstOccurenceOfDistanceTuples_Rounding(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findFirstOccurenceOfDistanceTuples_Truncating() throws EffectFinderUninitialisedException;
	public int[] d_findFirstOccurenceOfDistanceTuples_Truncating(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findLargestDistanceRoundingNeighbors() throws EffectFinderUninitialisedException;
	public int[] d_findLargestDistanceRoundingNeighbors(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findLargestDistanceTruncatedNeighbors() throws EffectFinderUninitialisedException;
	public int[] d_findLargestDistanceTruncatedNeighbors(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findSmallestDistanceRoundingNeighbors() throws EffectFinderUninitialisedException;
	public int[] d_findSmallestDistanceRoundingNeighbors(double accuracy, double epsilon, int stepsToTry);
	
	public int[] d_findSmallestDistanceTruncatedNeighbors() throws EffectFinderUninitialisedException;
	public int[] d_findSmallestDistanceTruncatedNeighbors(double accuracy, double epsilon, int stepsToTry);
	
	/**
	 * Effectlessness w.r.t. epsilon
	 * @return
	 * @throws EffectFinderUninitialisedException
	 */
	public int v_findFirstEffectlessValueRounding() throws EffectFinderUninitialisedException;
	public int v_findFirstEffectlessValueRounding(double accuracy, double epsilon, int stepsToTry);
	
	public int v_findFirstEffectlessValueTruncation() throws EffectFinderUninitialisedException;
	public int v_findFirstEffectlessValueTruncation(double accuracy, double epsilon, int stepsToTry);
	
	public int v_findLargestValueRoundingDown() throws EffectFinderUninitialisedException;
	public int v_findLargestValueRoundingDown(double accuracy, double epsilon, int stepsToTry);
	
	public int v_findLargestValueRoundingUp() throws EffectFinderUninitialisedException;
	public int v_findLargestValueRoundingUp(double accuracy, double epsilon, int stepsToTry);
	
	public int v_findLargestValueTruncation() throws EffectFinderUninitialisedException;
	public int v_findLargestValueTruncation(double accuracy, double epsilon, int stepsToTry);
}
