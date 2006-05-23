import java.util.ArrayList;

import RegEx.impl.DistributionFunctionImpl;


public class Monitoring {

	private static ArrayList measuredThreadValues = new ArrayList();
	private static ArrayList measuredCallValues = new ArrayList();
	
	public static void addThreadMeasurement(long time){
		measuredThreadValues.add(time);
	}
	
	public static void addCallMeasurement(long time){
		measuredCallValues.add(time);
	}
	
	public static void printResults(){
		
		System.out.println("Measured Thread Values:");
		long sum = 0;
		for(int i=0; i< measuredThreadValues.size(); i++){
			System.out.print(measuredThreadValues.get(i)+" ");
			sum+=((Long)measuredThreadValues.get(i)).longValue();
			if ((i+1)%5 == 0) {

				System.out.print(" Sum: "+sum+" ");
				sum = 0;
				System.out.println(" Call: "
						+measuredCallValues.get(i/5));

			}
		}
		
	}

/*
	public static DistributionFunctionImpl getDistFunc(){

		for(int i=0; i< measuredCallValues.size(); i++){
			System.out.println(measuredCallValues.get(i));
		}
		
		return new DistributionFunctionImpl();
	}
*/	
}
