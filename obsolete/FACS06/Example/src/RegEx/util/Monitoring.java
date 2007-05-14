package RegEx.util; 

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

import java.util.Hashtable;

import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.impl.*;


public class Monitoring {

	public static ArrayList measuredThreadValues = new ArrayList();
	public static ArrayList measuredCallValues = new ArrayList();
	
	public static void addThreadMeasurement(long time){
		measuredThreadValues.add(time);
	}

	public static void addCallMeasurement(long time){
		measuredCallValues.add(time);
	}

	public static void printResults(){
		for (int i=0; i<measuredThreadValues.size(); i++){
			System.out.print(measuredThreadValues.get(i)+" ");
			if((i+1)%5==0) {
				long x = (Long)measuredCallValues.get(i/5);
				long blah = Math.round((double)x/1000000);
				
				//long blah = ((Long)measuredCallValues.get(i/5)).longValue() / ((Integer)1000000).longValue();
				
				System.out.println("Call: "+blah);
			}
		}
	}

	public static DistributionFunction getDistFunc(double distance){

		Hashtable resultMap = new Hashtable();
		// key = measurement, value = probability

		double singleProb = (double)1/measuredCallValues.size();
		long largestMeas = 0;
		
		for (int i=0; i<measuredCallValues.size(); i++){
			long meas = (Long)measuredCallValues.get(i);
			meas = Math.round((double) meas / distance);

			if (meas > largestMeas) largestMeas = meas;
			
			if (resultMap.containsKey(meas)){
				double prob = (Double)resultMap.get(meas);
				resultMap.put(meas, prob+singleProb); 
			} else {
				resultMap.put(meas, singleProb);
			}
		}
		
		RegExFactoryImpl regExFact = new RegExFactoryImpl();
		DistributionFunction distFunc = regExFact.createDistributionFunction(); 
		distFunc.setDistance(distance);
		for (int j=0; j<=largestMeas; j++){
			Complex point = regExFact.createComplex();
			point.setRe(0.0);
			point.setIm(0.0);
			if (resultMap.containsKey((long)j)) {
				double prob = (Double)resultMap.get((long)j);
				point.setRe(prob);
			} 
			distFunc.addPoint(point);
		}
		
		return distFunc;
	}
	
}
