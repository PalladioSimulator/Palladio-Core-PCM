class defaultUsageScenarioThread extends
		de.uka.ipd.sdq.prototype.framework.AbstractScenarioThread {
	public defaultUsageScenarioThread(
			de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
			de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor) {
		super(expRun, timeSensor);
	}

	@Override
	protected Runnable getScenarioRunner() {
		return new downloadfiles.impl.DownloadFiles();
	}
}

public class Main extends de.uka.ipd.sdq.prototype.framework.AbstractMain {
	@Override
	protected void initialiseThreads(
			de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
			de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor) {
		for (int i = 0; i < 1; i++) {
			threads.add(new defaultUsageScenarioThread(expRun, timeSensor));
		}
	}

	@Override
	protected void setupResources() {
		//ResourceEnvironmentFactory.setUpResources();
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().run(args);
	}
}
