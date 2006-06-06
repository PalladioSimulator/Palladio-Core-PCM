package Example;

import java.io.File;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import RegEx.Complex;
import RegEx.DistributionFunction;
import RegEx.impl.RegExFactoryImpl;
import RegEx.util.Monitoring;
import RegEx.util.Serialization;
import RegEx.util.Visualization;

import sun.misc.Cleaner;



/**
 * 
 */

/**
 * @author Koziolek
 *
 */
public class MainClass {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//executeExampleScenario();
		exampleDist();
		//compareMeasurements();
	}

	private static void executeExampleScenario() {
		ClientComponent cc = new ClientComponent(3);
		ExecutorService tpes = Executors.newCachedThreadPool();

		for(int i=0; i<500; i++){
			long startTime = System.nanoTime();
			cc.providedMethod1(tpes);
			//cc.providedMethod1();
			tpes.shutdown();
			Monitoring.addCallMeasurement(System.nanoTime()-startTime);
			tpes = Executors.newCachedThreadPool();
		}
		
		Monitoring.printResults();
		
		DistributionFunction distFunc = Monitoring.getDistFunc(1000000.0);

		Serialization.saveToXMI(distFunc, "measurements\\test.xmi");
	}

	private static void compareMeasurements() {
		DistributionFunction distFunc1 = (DistributionFunction)
			Serialization.loadFromXMI("measurements/fft_cpu_2_threads_3.xmi");
		
		DistributionFunction distFunc2 = (DistributionFunction)
			Serialization.loadFromXMI("measurements/fft_cpu_2_seq_3.xmi");
		
		Visualization vis = new Visualization(distFunc1.getDistance());
		vis.addDistributionFunction(distFunc1, "3 Threads");
		vis.addDistributionFunction(distFunc2, "3 Seq");
		vis.visualize();
	}

	private static void exampleDist() {
		double[] points1 = {0.0, 0.0, 0.0, 0.01, 0.04, 0.07, 0.09, 0.11, 0.15, 0.10, 0.08, 0.05, 0.03, 0.07, 0.15, 0.05, 0.00, 0.00, 0.00, 0.00};
		double[] points2 = {0.0, 0.0, 0.0, 0.00, 0.00, 0.01, 0.04, 0.05, 0.08, 0.12, 0.19, 0.15, 0.11, 0.09, 0.06, 0.04, 0.03, 0.02, 0.01, 0.00};
		
		DistributionFunction df1 = getDistFunc(points1);
		DistributionFunction df2 = getDistFunc(points2);
		
		printDF(df1);
		printDF(df2);
		
		
		Visualization vis = new Visualization(df1.getDistance());
		vis.addDistributionFunction(df1, "PMF1");
		vis.addDistributionFunction(df2, "PMF2");
		vis.visualizeOverlay();
		
		DistributionFunction convoluted = df1.getCDF().multiply(df2.getCDF());
		convoluted = convoluted.getPMF();
		
		printDF(convoluted);
		
		Visualization vis2 = new Visualization(convoluted.getDistance());
		vis2.addDistributionFunction(convoluted, "PMF3 = max(PMF1,PMF2)");
		vis2.visualizeOverlay();
		
	}

	private static DistributionFunction getDistFunc(double[] points) {
		RegExFactoryImpl regExFact = new RegExFactoryImpl();
		DistributionFunction distFunc = regExFact.createDistributionFunction(); 
		distFunc.setDistance(1.0);
		for (int i=0; i<points.length; i++){
			Complex point = regExFact.createComplex();
			point.setRe(points[i]);
			point.setIm(0.0);
			distFunc.addPoint(point);
		}
		return distFunc;
	}
	
	public static void printDF(DistributionFunction df){
		Complex[] points = getPointArray(df);
		double sum = 0;
		for (int i = 0; i < points.length; i++) {
			if (points[i].getRe() < 0.0001){
				System.out.println("0");				
			} else {
				System.out.println(points[i].getRe());				
			}
			sum += points[i].getRe();
		}		
		System.out.println();
		System.out.println(sum);
		System.out.println();
	}
	
	public static Complex[] getPointArray(DistributionFunction df){
		return (Complex[]) df.getPoints().toArray();
	}	
}
