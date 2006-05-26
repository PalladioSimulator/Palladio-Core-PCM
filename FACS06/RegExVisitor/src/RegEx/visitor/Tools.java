package RegEx.visitor;

import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.RegExFactory;

public class Tools {
	public static int ACCURACY = 128;
	public static double DISTANCE = 1000000.0;
	
	
	public static DistributionFunction getDiracImpulse(int length, double distance) {
		DistributionFunction df = RegExFactory.eINSTANCE.createDistributionFunction();
		df.setDistance(distance);
	    Complex one = RegExFactory.eINSTANCE.createComplex();
	    one.setRe(1.0);
		df.addPoint(one);
		df.expandTo(length);
		return df;
	}

	public static DistributionFunction getOnes(int length, double distance) {
		DistributionFunction df = RegExFactory.eINSTANCE.createDistributionFunction();
		df.setDistance(distance);
		for(int i=0; i<length; i++){
		    Complex one = RegExFactory.eINSTANCE.createComplex();
		    one.setRe(1.0);
			df.addPoint(one);			
		}
		return df;
	}

	public static DistributionFunction getZeros(int length, double distance) {
		DistributionFunction df = RegExFactory.eINSTANCE.createDistributionFunction();
		df.setDistance(distance);
		for(int i=0; i<length; i++){
		    Complex zero = RegExFactory.eINSTANCE.createComplex();
			df.addPoint(zero);			
		}
		return df;
	}	
	
	public static Complex[] getPointArray(DistributionFunction df){
		return (Complex[]) df.getPoints().toArray();
	}
}
