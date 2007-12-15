/**
 * 
 */
package de.uka.ipd.sdq.prototype.framework;

import java.io.File;
import java.util.ArrayList;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.TimeSpanSensor;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;

/**
 * @author Snowball
 *
 */
public abstract class AbstractMain {
	protected org.apache.log4j.Logger logger = org.apache.log4j.Logger
		.getLogger(AbstractScenarioThread.class);
	
	public static de.uka.ipd.sdq.sensorframework.entities.Experiment exp = null;
	protected ArrayList<Thread> threads = new ArrayList<Thread>();
	private ExperimentRun expRun;
	protected CommandLine cmdLine;

	protected void run(String[] args) {
		parseCommandLine(args);
		setupLogging();
		
		IDAOFactory datasource = prepareDatasource();
		exp = datasource.createExperimentDAO().addExperiment(cmdLine.getOptionValue('n'));
		expRun = exp.addExperimentRun(new java.util.Date().toString());

		TimeSpanSensor tss = exp.addTimeSpanSensor("Scenario overall defaultUsageScenario");

		if (cmdLine.hasOption('w')) {
			System.out.println("Please pin java runtime to a single processor if needed! Press a key to continue!");
			waitForStopCondition();
		}
		
		setupResources();
		initialiseThreads(expRun, tss);
		
		startThreads();
		
		waitForStopCondition();
		
		stop();

		System.out.println("Storing results...");
		datasource.createExperimentDAO().store(exp);
		datasource.finalizeAndClose();
		System.out.println("...Done!");
	}


	private void startThreads() {
		System.out.print("Starting workload threads. ");
		if (cmdLine.hasOption('m'))
			System.out.println("Taking "+cmdLine.getOptionValue('m')+" measurements");
		else
			System.out.println("Request a measurement stop by pressing any key!");
		for (Thread t : threads) {
			t.start();
		}
	}


	private void setupLogging() {
		PatternLayout layout = new PatternLayout( "%d{ISO8601} %-5p [%t] %c: %m%n" );
		logger.addAppender( new ConsoleAppender(layout) );
		if (cmdLine.hasOption('D'))
			logger.setLevel( Level.DEBUG );
		else
			logger.setLevel( Level.INFO );
	}


	private CommandLine parseCommandLine(String[] arguments) {
		Options o = new Options();
		o.addOption("w", "wait", false, "Suspend program execution before starting to pin program to a single processor");
		o.addOption("h", "help", false, "Show this help");
		o.addOption(OptionBuilder.hasArg().isRequired().withArgName("dataDirectory").
				withLongOpt("dataDir").
				withDescription("Datadirectory used by the FileStorage Sensor DAO to store the measured times").create("d"));
		o.addOption(OptionBuilder.withDescription("Name of the experiment for use in the stored data").hasArg().
				withLongOpt("name").isRequired().create('n'));
		o.addOption(OptionBuilder.hasArg().withArgName("user count").withLongOpt("threadcount").
				withDescription("Override usage scenario population (only for closed workloads)").create("c"));
		o.addOption(OptionBuilder.hasArg().withArgName("max measurements").withLongOpt("maxmeasurement").
				withDescription("Maximum measurements to take").create("m"));
		o.addOption(OptionBuilder.hasArg().withArgName("warmup runs").withLongOpt("warmup").
				withDescription("Warmup runs before measuring (default: 1000)").create("u"));
		o.addOption("D", "debug", false, "Print debug information. Turn off for real experiments!");
		
		getAdditionalOptions(o);
		
		boolean parserError = false;
		try {
			cmdLine = new GnuParser().parse(o, arguments);
		} catch (ParseException e) {
			System.out.println("Unable to start execution\n" + e.getMessage() + "\n");
			parserError  = true;
		}
		if (parserError || cmdLine.hasOption('h')){
			new HelpFormatter().printHelp("Main", "Prottype runner, copyright 2007, SDQ, IPD, Uni Karlsruhe\n", o, "\nWritten by Steffen Becker (sbecker@ipd.uka.de)");
			System.exit(-1);
		}
		return cmdLine;
	}


	protected void getAdditionalOptions(Options o) {}


	private void waitForStopCondition() {
		if (!cmdLine.hasOption('m')){
			try {
				System.in.read();
				while (System.in.available() > 0) System.in.read();
			} catch (java.io.IOException e1) {
				e1.printStackTrace();
				System.exit(-1);
			}
		}
	}

	private void stop() {
		if (!cmdLine.hasOption('m')) {
			logger.debug("Request Thread stop");
			for (Thread t : threads) {
				((IStopable) t).requestStop();
			}
		}
		for (Thread t : threads) {
			try {
				t.join();
			} catch (InterruptedException e) {
				e.printStackTrace();
				System.exit(-1);
			}
		}
	}

	private IDAOFactory prepareDatasource() {
		if (!checkDirectory(cmdLine.getOptionValue('d'))) {
			System.out.println("Unable to find data directory. Ensure data directory exists and is writeable");
			System.exit(-1);
		}
		IDAOFactory datasource = new FileDAOFactory(cmdLine.getOptionValue('d'));
		return datasource;
	}

	private boolean checkDirectory(String path) {
		File f = new File(path);
		if (!f.isDirectory())
			return false;
		return true;
	}

	protected abstract void setupResources();
	protected abstract void initialiseThreads(ExperimentRun expRun, TimeSpanSensor tss);
}
