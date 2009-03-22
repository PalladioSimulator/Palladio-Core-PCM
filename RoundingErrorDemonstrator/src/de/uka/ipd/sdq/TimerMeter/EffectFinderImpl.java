package de.uka.ipd.sdq.TimerMeter;

import java.io.PrintStream;

import de.uka.ipd.sdq.TimerMeter.exceptions.EffectFinderUninitialisedException;
import de.uka.ipd.sdq.TimerMeter.exceptions.WrongEffectFinderConfigurationException;

public class EffectFinderImpl implements EffectFinder{
	
	static PrintStream o = System.out;

	@SuppressWarnings("unused")
	private boolean abort = false;

	@SuppressWarnings("unused")
	private double accuracy;
	@SuppressWarnings("unused")
	private double epsilon;
	@SuppressWarnings("unused")
	private int stepsToTry;
	public EffectFinderImpl() {
		super();
		this.accuracy = 1.99D;
		this.epsilon = 0.01D;
		this.stepsToTry = 2000;
	}
	
	public EffectFinderImpl(double accuracy, double epsilon, int stepsToTry) throws WrongEffectFinderConfigurationException {
		super();
		int errorCode = this.checkParameters(accuracy, epsilon, stepsToTry);
		if(errorCode<0){
			this.abort = true;
			throw new WrongEffectFinderConfigurationException(errorCode);
		}
		this.accuracy = accuracy;
		this.epsilon = epsilon;
		this.stepsToTry = stepsToTry;
	}
	private int checkParameters(double accuracy, double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTriples_Rounding()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTriples_Rounding(double accuracy,
			double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTriples_Truncating()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTriples_Truncating(
			double accuracy, double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTuples_Rounding()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTuples_Rounding(double accuracy,
			double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTuples_Truncating()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTuples_Truncating(double accuracy,
			double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findLargestDistanceRoundingNeighbors()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findLargestDistanceRoundingNeighbors(double accuracy,
			double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findLargestDistanceTruncatedNeighbors()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findLargestDistanceTruncatedNeighbors(double accuracy,
			double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findSmallestDistanceRoundingNeighbors()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findSmallestDistanceRoundingNeighbors(double accuracy,
			double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findSmallestDistanceTruncatedNeighbors()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int[] d_findSmallestDistanceTruncatedNeighbors(double accuracy,
			double epsilon, int stepsToTry) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int v_findFirstEffectlessValueRounding()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int v_findFirstEffectlessValueRounding(double accuracy, double epsilon, int stepsToTry) {
		double currPreciseValue;
		long currRoundedValue;
		double currAbsDistance;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)==-1){
			return -1;
		}
		for(int i=1; i<=stepsToTry; i++){
			currPreciseValue = i*accuracy;
			currRoundedValue = Math.round(currPreciseValue);
			currAbsDistance = Math.abs(currPreciseValue-currRoundedValue);
//			o.println("Abs distance: "+currAbsDistance);
			if((new Double(Math.abs(currAbsDistance))).compareTo(epsilon)<0){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int v_findFirstEffectlessValueTruncation()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int v_findFirstEffectlessValueTruncation(double accuracy, double epsilon, int stepsToTry) {
		double currPreciseValue;
		long currTruncatedValue;
		double currAbsDistance;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)==-1){
			return -1;
		}
		for(int i=1; i<=stepsToTry; i++){
			currPreciseValue = i*accuracy;
			currTruncatedValue = new Double(currPreciseValue).longValue();
			currAbsDistance = Math.abs(currPreciseValue-currTruncatedValue);
//			o.println("Abs distance: "+currAbsDistance);
			if((new Double(Math.abs(currAbsDistance))).compareTo(epsilon)<0){
				return i;
			}
		}
		return -1;
	}

	@Override
	public int v_findLargestValueRoundingDown()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int v_findLargestValueRoundingDown(double accuracy, double epsilon, int stepsToTry) {
		double currPreciseValue;
		long currRoundedValue;
		int result = -1;
		double currRoundingAmount;
		double largestRoundingAmount = -1D;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)==-1){
			return -1;
		}
		for(int i=1; i<=stepsToTry; i++){
			currPreciseValue = i*accuracy;
			currRoundedValue = Math.round(currPreciseValue);
			currRoundingAmount = currPreciseValue-currRoundedValue;
			if((new Double(currRoundingAmount)).compareTo(0.0D)>0){
				if(currRoundingAmount>largestRoundingAmount){
					largestRoundingAmount=currRoundingAmount;
					result = i;
				}
			}
		}
		o.println(largestRoundingAmount);
		return result;
	}

	@Override
	public int v_findLargestValueRoundingUp()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int v_findLargestValueRoundingUp(double accuracy, double epsilon, int stepsToTry) {
		double currPreciseValue;
		long currRoundedValue;
		int result = -1;
		double currRoundingAmount;
		double largestRoundingAmount = -1D;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)==-1){
			return -1;
		}
		for(int i=1; i<=stepsToTry; i++){
			currPreciseValue = i*accuracy;
			currRoundedValue = Math.round(currPreciseValue);
			currRoundingAmount = currRoundedValue - currPreciseValue;
			if((new Double(currRoundingAmount)).compareTo(0.0D)>0){
				if(currRoundingAmount>largestRoundingAmount){
					largestRoundingAmount=currRoundingAmount;
					result = i;
				}
			}
		}
		o.println(largestRoundingAmount);
		return result;
	}

	@Override
	public int v_findLargestValueTruncation()
			throws EffectFinderUninitialisedException {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int v_findLargestValueTruncation(double accuracy, double epsilon,
			int stepsToTry) {
		double currPreciseValue;
		long currTruncatedValue;
		int result = -1;
		double currTruncationAmount;
		double largestTruncationAmount = -1D;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)==-1){
			return -1;
		}
		for(int i=1; i<=stepsToTry; i++){
			currPreciseValue = i*accuracy;
			currTruncatedValue = new Double(currPreciseValue).longValue();
			currTruncationAmount = currPreciseValue - currTruncatedValue;
			if(currTruncationAmount>largestTruncationAmount){
				largestTruncationAmount=currTruncationAmount;
				result = i;
			}
		}
		o.println(largestTruncationAmount);
		return result;
	}

}
