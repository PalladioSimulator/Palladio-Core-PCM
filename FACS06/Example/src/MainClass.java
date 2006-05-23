import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import sun.misc.Cleaner;
import RegEx.impl.*;


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

		for(int i=0; i<10; i++){
			long startTime = System.nanoTime();
			cc.providedMethod1(tpes);
			tpes.shutdown();
			Monitoring.addCallMeasurement(System.nanoTime()-startTime);
			tpes = Executors.newCachedThreadPool();
		}
		
		Monitoring.printResults();
		
	}
		

}
