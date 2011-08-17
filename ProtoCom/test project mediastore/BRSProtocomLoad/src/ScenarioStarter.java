/**
 * 
 */


import java.util.ArrayList;
import java.util.Iterator;


/**
 * @author Nikolas
 *
 */

public class ScenarioStarter {

	public static void start(){
		final int virtualUsers = 1;      //#of Users per specified UsageScenario
		final int userThinkTime = 10000; //sleep in ms
		
		ArrayList<Thread> threads = new ArrayList<Thread>();
		for (int i = 0; i < virtualUsers; i++) {

			threads.add(new Thread(new java.lang.Runnable() {
								
				public void run() {

					//Only one call for now for testing
					//while (true) {

						new brs_usage_scenario.impl.BRS_usage_scenario().run();
								
						
							
						try {

							// TODO: Wait for think time of the model instance
							Thread.sleep(userThinkTime);

						} catch (InterruptedException e) {

							// TODO Auto-generated catch block
							e.printStackTrace();

						}
						
					//}
				}
					
			}));

		}
		for (Iterator<Thread> it = threads.iterator(); it.hasNext();)
			it.next().start();
	}
	
}
