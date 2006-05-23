import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

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
		
		cc.providedMethod1(tpes);
	}
		

}
