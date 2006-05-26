import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import RegEx.DistributionFunction;
import RegEx.visualise.Visualization;

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
		
		Visualization vis = new Visualization(distFunc.getDistance());
		vis.addDistributionFunction(distFunc, "Measured");
		vis.visualize();
	}
}
