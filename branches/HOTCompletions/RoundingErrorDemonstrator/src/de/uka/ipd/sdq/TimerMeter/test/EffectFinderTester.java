package de.uka.ipd.sdq.TimerMeter.test;

import java.util.Arrays;

import de.uka.ipd.sdq.TimerMeter.EffectFinder;
import de.uka.ipd.sdq.TimerMeter.EffectFinderImpl;

/**
 * @author Michael
 * 	TODO test precise (from Long) value; test values <1, test different epsilons
 * JVM command line memory settings: -Xms64M -Xmx1G
 */
public class EffectFinderTester {
	private static final double DEFAULT_EPSILON = 0.01D;
	private static final int DEFAULT_NR_OF_STEPS = 2000;

	public static void main(String args[]){
		EffectFinderTester effft = new EffectFinderTester();
		String s1 = effft.run(1.99D);
		String s2 = effft.run(2.01D);
		System.out.println(s1+"\n"+s2);
	}

	private String run(double accuracy) {
		return this.run(accuracy, EffectFinderTester.DEFAULT_EPSILON);
	}
	
	private String run(double accuracy, double epsilon) {
		return this.run(accuracy, EffectFinderTester.DEFAULT_EPSILON, EffectFinderTester.DEFAULT_NR_OF_STEPS);
	}

	private String run(double accuracy, double epsilon, int stepsToWork) {
		EffectFinder efff = new EffectFinderImpl();
		StringBuffer sb = new StringBuffer();
		sb.append("Accuracy: "+accuracy+", epsilon: "+epsilon+", stepsToWork: "+stepsToWork+"\n");
		sb.append("FirstEffectlessValue_Rounding: "+efff.v_findFirstEffectlessValue_Rounding(accuracy, epsilon, stepsToWork)+"\n");
		sb.append("FirstEffectlessValue_Truncating: "+efff.v_findFirstEffectlessValue_Truncating(accuracy, epsilon, stepsToWork)+"\n");
		sb.append("LargestValueRoundingDown_Rounding: "+efff.v_findLargestValueRoundingDown_Rounding(accuracy, epsilon, stepsToWork)+"\n");
		sb.append("LargestValueRoundingUp_Rounding: "+efff.v_findLargestValueRoundingUp_Rounding(accuracy, epsilon, stepsToWork)+"\n");
		sb.append("LargestValueTruncation_Truncating: "+efff.v_findLargestValueTruncation_Truncating(accuracy, epsilon, stepsToWork)+"\n");
		
		sb.append("FirstOccurenceOfDistanceTriples_Rounding: "+Arrays.toString(efff.
				d_findFirstOccurenceOfDistanceTriples_Rounding(accuracy, epsilon, stepsToWork))+"\n");
		sb.append("FirstOccurenceOfDistanceTriples_Truncating: "+Arrays.toString(efff.
				d_findFirstOccurenceOfDistanceTriples_Truncating(accuracy, epsilon, stepsToWork))+"\n");
		sb.append("FirstOccurenceOfDistanceTuples_Rounding: "+Arrays.toString(efff.
				d_findFirstOccurenceOfDistanceTuples_Rounding(accuracy, epsilon, stepsToWork))+"\n");
		sb.append("FirstOccurenceOfDistanceTuples_Truncating: "+Arrays.toString(efff.
				d_findFirstOccurenceOfDistanceTuples_Truncating(accuracy, epsilon, stepsToWork))+"\n");
		String retString = sb.toString();
		System.out.println(retString);
		return retString;
	}
}
