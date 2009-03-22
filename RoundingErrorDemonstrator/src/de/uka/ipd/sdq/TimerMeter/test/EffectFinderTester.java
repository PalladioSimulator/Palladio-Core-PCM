package de.uka.ipd.sdq.TimerMeter.test;

import java.util.Arrays;

import de.uka.ipd.sdq.TimerMeter.EffectFinder;
import de.uka.ipd.sdq.TimerMeter.EffectFinderImpl;

/**
 * @author Michael
 * 	TODO test precise (from Long) value; test values <1, test different epsilons
 */
public class EffectFinderTester {
	public static void main(String args[]){
		EffectFinder efff = new EffectFinderImpl();
		System.out.println(efff.v_findFirstEffectlessValue_Rounding(1.4D, 0.01D, 100));
		System.out.println(efff.v_findFirstEffectlessValue_Truncating(1.4D, 0.01D, 100));
		System.out.println(efff.v_findLargestValueRoundingDown_Rounding(1.28, 0.01D, 100));
		System.out.println(efff.v_findLargestValueRoundingUp_Rounding(1.28, 0.01D, 100));
		System.out.println(efff.v_findLargestValueTruncation_Truncating(1.28, 0.01D, 100));
		System.out.println(Arrays.toString(efff.d_findFirstOccurenceOfDistanceTriples_Rounding(1.28, 0.01D, 1000)));
				
	}
}
