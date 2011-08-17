
		
			
/*    //TODO: Fix me
	new Thread(new java.lang.Runnable(){
	
		private static org.apache.log4j.Logger logger = 
			org.apache.log4j.Logger.getLogger("User Log");
		
		public void run() {
			while (true) {
				brs_usage_scenario.impl.BRS_usage_scenario us = new brs_usage_scenario.impl.BRS_usage_scenario();
				logger.debug("Starting my scenario");
				new Thread(us).run();
				logger.debug("Finished my scenario");
                try {
                	// TODO: Wait for specified model time
					Thread.sleep(200);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
	}*/

		
	
		public class Main extends de.uka.ipd.sdq.prototype.framework.AbstractMain {

			@Override
			protected void initialiseThreads(
					de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
					de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor) {
				
					
	

				
			}
		
			@Override
			protected void setupResources() {
				ResourceEnvironmentFactory.setUpResources();
			}
			
			/**
			 * @param args
			 */
			public static void main(String[] args) {
				new Main().run(args);
			}
		}
	