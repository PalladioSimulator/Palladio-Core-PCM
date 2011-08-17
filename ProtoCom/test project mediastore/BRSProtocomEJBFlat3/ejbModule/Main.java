
class BRSUsageThread extends de.uka.ipd.sdq.prototype.framework.AbstractOpenScenarioThread {
	
		
	public BRSUsageThread(
			de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
			de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor,
					org.apache.commons.cli.CommandLine commandLine) {
		super(expRun,timeSensor,commandLine,"4");
	}

	@Override
	protected Runnable getScenarioRunner(org.apache.commons.cli.CommandLine commandLine) {
		return new brs_usage_scenario.impl.BRS_usage_scenario();
	}
	

}
			

		public class Main extends de.uka.ipd.sdq.prototype.framework.AbstractMain {
			
			@Override
			protected void initialiseThreads(
					de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
					de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor) {
				
				threads.add(new BRSUsageThread(expRun, timeSensor, cmdLine));	
				
			}
		
			@Override
			protected void setupResources() {
				ResourceEnvironmentFactory.setUpResources();
				
				// Initialise Protocom environmnt
				// TODO: Move this someplace else as soon as ejbs are distributed

				// Create 1 System(s)
				//defaultsystem.impl.defaultSystem mydefaultSystem = new defaultsystem.impl.defaultSystem();
				//defaultsystem.impl.contexts.defaultSystemContext contextdefaultSystem = new defaultsystem.impl.contexts.defaultSystemContext();
				//mydefaultSystem.setContext(contextdefaultSystem);
			}
			
			/**
			 * @param args
			 */
			public static void main(String[] args) {
				new Main().run(args);
			}
			
			
		}
	