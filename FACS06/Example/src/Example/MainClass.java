package Example;

import java.io.File;
import java.net.URI;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import RegEx.DistributionFunction;
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
		
		ClientComponent cc = new ClientComponent();
		ExecutorService tpes = Executors.newCachedThreadPool();

		for(int i=0; i<500; i++){
			long startTime = System.nanoTime();
			cc.providedMethod1(tpes);
			tpes.shutdown();
			Monitoring.addCallMeasurement(System.nanoTime()-startTime);
			tpes = Executors.newCachedThreadPool();
		}
		
		Monitoring.printResults();
		
		DistributionFunction distFunc = Monitoring.getDistFunc(1000000.0);

		Serialization.saveToXMI(distFunc, "thread3.xmi");
		//DistributionFunction distFunc = Serialization.loadFromXMI("single_thread1.xmi");
		
		Visualization vis = new Visualization(distFunc.getDistance());
		vis.addDistributionFunction(distFunc, "Measured");
		vis.visualize();

	}


}
