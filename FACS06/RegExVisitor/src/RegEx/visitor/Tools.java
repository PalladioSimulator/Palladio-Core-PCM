package RegEx.visitor;

import java.util.Iterator;
import java.util.List;

import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.Expression;
import RegEx.RegExFactory;
import RegEx.TimeConsumption;

public class Tools {
	public static int ACCURACY = 4096;
	public static double DISTANCE = 1000000.0;
	
	public static boolean doPrint = false;
	
	public static void println(String text){
		if (!doPrint) return;
		System.out.println(text);
	}

	public static void printExpr(Expression expr){
		if (!doPrint) return;
		System.out.println(expr.getAsString() + "\n");
		printTC(expr.getCpuTimes());
	}
	
	public static void printTC(List<TimeConsumption> tcList){
		if (!doPrint) return;
		int i=1;
		for (TimeConsumption tc : tcList) {
			System.out.println("CPU"+i);
			printDF(tc.getNormDF());
			System.out.println();
			i++;
		}
		System.out.println();
	}	
	
	public static void printDF(DistributionFunction df){
		if (!doPrint) return;
		int i = 0;
		for (Iterator iter = df.getPoints().iterator(); iter.hasNext();) {
			Complex point = (Complex) iter.next();
			double val = point.getRe();
			if (java.lang.Math.abs(val) > 0.0001)
			{
				System.out.print("(" + i + ", " + val +") ");
			}
			i++;
		}
		System.out.println(sum(df)+"\n");
	}
	
	public static double sum(DistributionFunction df) {
		double sum = 0;
		
		for (Iterator iter = df.getPoints().iterator(); iter.hasNext();) {
			Complex point = (Complex) iter.next();
			sum += point.getRe();
		}
		
		return sum;
	}

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
