import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.OptionGroup;
import org.apache.commons.cli.Options;

import com.sun.appserv.security.ProgrammaticLogin;

class defaultUsageScenarioThread extends
		de.uka.ipd.sdq.prototype.framework.AbstractScenarioThread {

	public defaultUsageScenarioThread(
			de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
			de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor,
			CommandLine cmdLine) {
		super(expRun, timeSensor, cmdLine);
	}

	@Override
	protected Runnable getScenarioRunner(CommandLine cmdLine) {
		return new downloadfiles.impl.DownloadFiles(cmdLine.hasOption("rmi"));
	}
}

public class Main extends de.uka.ipd.sdq.prototype.framework.AbstractMain {
	@Override
	protected void initialiseThreads(
			de.uka.ipd.sdq.sensorframework.entities.ExperimentRun expRun,
			de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor timeSensor) {
		for (int i = 0; i < 1; i++) {
			threads.add(new defaultUsageScenarioThread(expRun, timeSensor, cmdLine));
		}
	}

	@Override
	protected void getAdditionalOptions(Options o) {
		OptionGroup og = new OptionGroup().
			addOption(OptionBuilder.withDescription("Use RMI based communication").create("rmi")).
			addOption(OptionBuilder.withDescription("Use SOAP based communication").create("soap"));
		og.setRequired(true);
		o.addOptionGroup(og);
	}
	
	@Override
	protected void setupResources() {
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		new Main().run(args);
	}
}
