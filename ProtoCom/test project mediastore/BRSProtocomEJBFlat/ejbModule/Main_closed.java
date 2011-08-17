
	
		
class BRS_usage_scenarioThread extends de.uka.ipd.sdq.prototype.framework.AbstractClosedScenarioThread {
	
	public BRS_usage_scenarioThread(
			de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
			de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor,
					org.apache.commons.cli.CommandLine commandLine) {
		super(expRun,timeSensor,commandLine);
	}

	@Override
	protected Runnable getScenarioRunner(org.apache.commons.cli.CommandLine commandLine) {
		return new brs_usage_scenario.impl.BRS_usage_scenario_closed();
	}
}

	
		public class Main_closed extends de.uka.ipd.sdq.prototype.framework.AbstractMain {

			@Override
			protected void initialiseThreads(
					de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
					de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor) {
				
					
	int count = 1;
	if (cmdLine.hasOption("c")) {
		count = (Integer)cmdLine.getOptionObject("c");
	}
	for (int i = 0; i < count; i++) {
		threads.add(new BRS_usage_scenarioThread(expRun, timeSensor, cmdLine));
	}

				
			}
		
			@Override
			protected void setupResources() {
				ResourceEnvironmentFactory.setUpResources();
			}
			
			/**
			 * @param args
			 */
			public static void main(String[] args) {
				new Main_closed().run(args);
			}
		}
	