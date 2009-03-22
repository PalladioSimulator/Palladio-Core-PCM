package de.uka.ipd.sdq.TimerMeter.test;

import de.uka.ipd.sdq.TimerMeter.EffectFinder;
import de.uka.ipd.sdq.TimerMeter.EffectFinderImpl;

/**
 * @author Michael
 * 	TODO test precise (from Long) value; test values <1, test different epsilons
 */
public class EffectFinderTester {
	public static void main(String args[]){
		EffectFinder efff = new EffectFinderImpl();
		System.out.println(efff.v_findFirstEffectlessValueRounding(1.4D, 0.01D, 100));
		System.out.println(efff.v_findFirstEffectlessValueTruncation(1.4D, 0.01D, 100));
		System.out.println(efff.v_findLargestValueRoundingDown(1.28, 0.01D, 100));
		System.out.println(efff.v_findLargestValueRoundingUp(1.28, 0.01D, 100));
		System.out.println(efff.v_findLargestValueTruncation(1.28, 0.01D, 100));
	}
}
