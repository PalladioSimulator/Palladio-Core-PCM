package de.uka.ipd.sdq.TimerMeter;

import java.io.PrintStream;
import java.util.Iterator;
import java.util.SortedSet;
import java.util.TreeSet;

//import de.uka.ipd.sdq.TimerMeter.exceptions.EffectFinderUninitialisedException;
import de.uka.ipd.sdq.TimerMeter.exceptions.WrongEffectFinderConfigurationException;

public class EffectFinderImpl implements EffectFinder{
	
	static PrintStream o = System.out;

	@SuppressWarnings("unused")
	private boolean abort = false;

	private double accuracy;

	private double epsilon;
	
	private int stepsToTry;
	
	public EffectFinderImpl() {
		super();
		this.accuracy = 1.99D;
		this.epsilon = 0.01D;
		this.stepsToTry = 2000;
		o.println("Initialised EffectFinderImpl with " +
				"accuracy "+accuracy+", " +
				"epsilon "+epsilon+", " +
				"stepsToTry "+ stepsToTry+".");
	}
	
	public EffectFinderImpl(
			double accuracy, 
			double epsilon, 
			int stepsToTry) 
	throws WrongEffectFinderConfigurationException {
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
		if(accuracy <= 0){
			System.err.println("Accuracy cannot be 0 or less.");
			return -1;
		}
		if(epsilon <= 0){
			System.err.println("Epsilon cannot be 0 or less.");
			return -2;
		}
		if(epsilon >= 1){
			System.err.println("Epsilon cannot be 1 or larger.");
			return -3;
		}
		if(stepsToTry < 5){
			System.err.println("StepsToTry cannot be 4 or smaller.");
			return -4;
		}
		return 0;
	}

//	@Override
//	public int[] d_findFirstOccurenceOfDistanceTriples_Rounding()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	/**
	 * @param accuracy
	 * @param stepsToTry
	 * @return
	 */
	private int[] d_findFirstOccurenceOfDistanceTriples(
			double accuracy,
			int stepsToTry,
			boolean rounding) {
		SortedSet<Interval> intervals = new TreeSet<Interval>();
		boolean added;
		int addedInstances = 0;
		for(int i=1; i<stepsToTry; i++){
			for(int j=i+1; j<=stepsToTry; j++){
				added = intervals.add(new IntervalImpl(accuracy, i, j, rounding));
				if(!added){
					o.println("Not added distance from "+i+" to "+j+"!");
				}else{
					addedInstances++;
					if(addedInstances%50000==1){
						o.println("Added "+addedInstances+" instances so far");
					}
				}
			}
		}
		Iterator<Interval> iter = intervals.iterator();
		int idx = 0;
		Interval a = iter.next();
		Interval b = iter.next();
		Interval c = iter.next();
		long lenA;
		long lenB;
		long lenC;
		
		do{
			lenA = a.getDisplayedIntervalLength();
			lenB = b.getDisplayedIntervalLength();
			lenC = c.getDisplayedIntervalLength();
//			o.println("Lengths: "+lenA+","+lenB+","+lenC);
			if(lenA+1 == lenB && lenB+1==lenC){
				o.println("The three neighbors: "+a+", "+b+", "+c+".");
				return new int[]{idx, idx+1, idx+2};
			}
			idx++;
			if(idx%50000==1){
				o.println("Analysed "+idx+" distance triples so far");
			}
			a = b;
			b = c;
			c = iter.next();
		}while(iter.hasNext());
		
		return new int[]{-1, -1, -1};
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTriples_Rounding(
			double accuracy,
			double epsilon, 
			int stepsToTry) {
		o.println("Entering d_findFirstOccurenceOfDistanceTriples_Rounding");
		return d_findFirstOccurenceOfDistanceTriples(accuracy, stepsToTry, true);
	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTriples_Truncating(
			double accuracy, 
			double epsilon, 
			int stepsToTry) {
		o.println("Entering d_findFirstOccurenceOfDistanceTriples_Truncating");
		return d_findFirstOccurenceOfDistanceTriples(accuracy, stepsToTry, false);
	}

//	@Override
//	public int[] d_findFirstOccurenceOfDistanceTriples_Truncating()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	/**
//	 * @param accuracy
//	 * @param stepsToTry
//	 * @return
//	 */
//	private int[] d_findFirstOccurenceOfDistanceTuples(
//			double accuracy,
//			int stepsToTry,
//			boolean rounding) {
//		SortedSet<Interval> intervals = new TreeSet<Interval>();
//		boolean added;
//		int addedInstances = 0;
//		for(int i=1; i<stepsToTry; i++){
//			for(int j=i+1; j<=stepsToTry; j++){
//				added = intervals.add(new IntervalImpl(accuracy, i, j, rounding));
//				if(!added){
//					o.println("Not added distance from "+i+" to "+j+"!");
//				}else{
//					addedInstances++;
//					if(addedInstances%1000==1){
//						o.println("Added "+addedInstances+" instances so far");
//					}
//				}
//			}
//		}
//		Iterator<Interval> iter = intervals.iterator();
//		int idx = 0;
//		Interval a = iter.next();
//		Interval b = iter.next();
//		long lenA;
//		long lenB;
//		
//		do{
//			lenA = a.getDisplayedIntervalLength();
//			lenB = b.getDisplayedIntervalLength();
//			o.println("Lengths: "+lenA+","+lenB);
//			if(lenA+1 == lenB){
//				o.println("The two neighbors: "+a+", "+b+".");
//				return new int[]{idx, idx+1};
//			}
//			idx++;
//			a = b;
//			b = iter.next();
//		}while(iter.hasNext());
//		
//		return new int[]{-1, -1};
//	}

//	@Override
//	public int[] d_findFirstOccurenceOfDistanceTuples_Rounding()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTuples_Rounding(
			double accuracy,
			double epsilon,
			int stepsToTry) {
		o.println("Entering d_findFirstOccurenceOfDistanceTuples_Rounding");
		return d_findFirstOccurenceOfDistanceTuples(accuracy, stepsToTry, true);
	}

//	@Override
//	public int[] d_findFirstOccurenceOfDistanceTuples_Truncating()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	@Override
	public int[] d_findFirstOccurenceOfDistanceTuples_Truncating(
			double accuracy,
			double epsilon, 
			int stepsToTry) {
		o.println("Entering d_findFirstOccurenceOfDistanceTuples_Truncating");
		return d_findFirstOccurenceOfDistanceTuples(accuracy, stepsToTry, false);
	}

//	@Override
//	public int[] d_findLargestDistanceRoundingNeighbors()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return null;
//	}

	private int[] d_findFirstOccurenceOfDistanceTuples(
			double accuracy,
			int stepsToTry,
			boolean rounding) {
		SortedSet<Interval> intervals = new TreeSet<Interval>();
		boolean added;
		int addedInstances = 0;
		for(int i=1; i<stepsToTry; i++){
			for(int j=i+1; j<=stepsToTry; j++){
				added = intervals.add(new IntervalImpl(accuracy, i, j, rounding));
				if(!added){
					o.println("Not added distance from "+i+" to "+j+"!");
				}else{
					addedInstances++;
					if(addedInstances%50000==1){
						o.println("Added "+addedInstances+" instances so far");
					}
				}
			}
		}
		Iterator<Interval> iter = intervals.iterator();
		int idx = 0;
		Interval a = iter.next();
		Interval b = iter.next();
		long lenA;
		long lenB;
		
		do{
			lenA = a.getDisplayedIntervalLength();
			lenB = b.getDisplayedIntervalLength();
//			o.println("Lengths: "+lenA+","+lenB);
			if(lenA+1 == lenB){
				o.println("The two neighbors: "+a+", "+b+".");
				return new int[]{idx, idx+1};
			}
			idx++;
			if(idx%50000==1){
				o.println("Analysed "+idx+" distance tuples so far");
			}
			a = b;
			b = iter.next();
		}while(iter.hasNext());
		
		return new int[]{-1, -1};
	}

//	/* (non-Javadoc)
//	 * @see de.uka.ipd.sdq.TimerMeter.EffectFinder#d_findLargestDistanceRoundingNeighbors(double, double, int)
//	 */
//	@Override
//	public int[] d_findLargestDistanceNeighbors_Rounding(
//			double accuracy,
//			double epsilon, 
//			int stepsToTry) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public int[] d_findLargestDistanceTruncatedNeighbors()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public int[] d_findLargestDistanceNeighbors_Truncating(double accuracy,
//			double epsilon, int stepsToTry) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public int[] d_findSmallestDistanceRoundingNeighbors()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public int[] d_findSmallestDistanceNeighbors_Rounding(double accuracy,
//			double epsilon, int stepsToTry) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public int[] d_findSmallestDistanceTruncatedNeighbors()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public int[] d_findSmallestDistanceNeighbors_Truncating(double accuracy,
//			double epsilon, int stepsToTry) {
//		// TODO Auto-generated method stub
//		return null;
//	}

//	@Override
//	public int v_findFirstEffectlessValueRounding()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int v_findFirstEffectlessValue_Rounding(
			double accuracy, 
			double epsilon, 
			int stepsToTry) {
		o.println("Entering v_findFirstEffectlessValue_Rounding");
		double currPreciseValue;
		long currRoundedValue;
		double currAbsDistance;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)<=-1){
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

//	@Override
//	public int v_findFirstEffectlessValueTruncation()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int v_findFirstEffectlessValue_Truncating(
			double accuracy, 
			double epsilon, 
			int stepsToTry) {
		o.println("Entering v_findFirstEffectlessValue_Truncating");
		double currPreciseValue;
		long currTruncatedValue;
		double currAbsDistance;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)<=-1){
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

//	@Override
//	public int v_findLargestValueRoundingDown()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int v_findLargestValueRoundingDown_Rounding(
			double accuracy, 
			double epsilon, 
			int stepsToTry) {
		o.println("Entering v_findLargestValueRoundingDown_Rounding");
		double currPreciseValue;
		long currRoundedValue;
		int result = -1;
		double currRoundingAmount;
		double largestRoundingAmount = -1D;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)<=-1){
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

//	@Override
//	public int v_findLargestValueRoundingUp()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int v_findLargestValueRoundingUp_Rounding(
			double accuracy, 
			double epsilon, 
			int stepsToTry) {
		o.println("Entering v_findLargestValueRoundingUp_Rounding");
		double currPreciseValue;
		long currRoundedValue;
		int result = -1;
		double currRoundingAmount;
		double largestRoundingAmount = -1D;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)<=-1){
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

//	@Override
//	public int v_findLargestValueTruncation()
//			throws EffectFinderUninitialisedException {
//		// TODO Auto-generated method stub
//		return 0;
//	}

	@Override
	public int v_findLargestValueTruncation_Truncating(
			double accuracy, 
			double epsilon,
			int stepsToTry) {
		o.println("Entering v_findLargestValueTruncation_Truncating");
		double currPreciseValue;
		long currTruncatedValue;
		int result = -1;
		double currTruncationAmount;
		double largestTruncationAmount = -1D;
		if (this.checkParameters(accuracy,epsilon,stepsToTry)<=-1){
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
