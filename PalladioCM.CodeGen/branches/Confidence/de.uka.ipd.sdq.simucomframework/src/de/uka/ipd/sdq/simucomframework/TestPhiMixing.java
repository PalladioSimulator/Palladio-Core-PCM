package de.uka.ipd.sdq.simucomframework;

import java.util.LinkedList;
import java.util.List;

import umontreal.iro.lecuyer.probdist.StudentDist;

public class TestPhiMixing {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		List<Double> buffer = new LinkedList<Double>();
//		buffer.add(1.0);
//		buffer.add(2.0);
//		buffer.add(3.0);
//		buffer.add(4.0);
//		buffer.add(5.0);
//		buffer.add(6.0);
//		buffer.add(7.0);
//		buffer.add(8.0);
//		buffer.add(9.0);
//		buffer.add(10.0);
//		
////		buffer = PhiMixingConfidenceStopCondition.discardAndRearrange(buffer);
//		System.out.println(buffer);
//		System.out.println(2^2);

		double alpha = 0.005;
		int degreesOfFreedom = 4;
		StudentDist dist = new StudentDist(degreesOfFreedom);
//		double x = dist.cdf(1-alpha/2);
		double x = dist.inverseF(1-alpha);
		System.out.println(x);
	}

}
