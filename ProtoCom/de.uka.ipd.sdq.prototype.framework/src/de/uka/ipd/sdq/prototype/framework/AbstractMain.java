/**
 * 
 */
package de.uka.ipd.sdq.prototype.framework;

import java.io.File;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

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
import de.uka.ipd.sdq.sensorframework.entities.Sensor;
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
	private static IDAOFactory datasource = null;
	
	protected ArrayList<Thread> threads = new ArrayList<Thread>();
	private ExperimentRun expRun;
	protected CommandLine cmdLine;

	

	private static boolean measureInnerResponseTimes = false;

	protected void init(String[] args){
		parseCommandLine(args);
		setupLogging();
		
		datasource = prepareDatasource();
		exp = datasource.createExperimentDAO().addExperiment(cmdLine.getOptionValue('n'));
		expRun = exp.addExperimentRun(new java.util.Date().toString());
		System.out.println("Created data source at event time "+(System.nanoTime() / Math.pow(10, 9)));
		
		if (cmdLine.hasOption('w')) {
			System.out.println("Please pin java runtime to a single processor if needed! Press a key to continue!");
			waitForStopCondition();
		}
		
		setupResources();

		
		measureInnerResponseTimes = false;
		if (cmdLine.hasOption('C') || cmdLine.hasOption('S')){
			measureInnerResponseTimes = true;
		}

	}

	protected void run(String[] args) {
		init(args);
		
		// init threads if configuration is active server (not -P) or only warmup requested.
		if (!cmdLine.hasOption('P') || cmdLine.hasOption('W')){
			TimeSpanSensor tss = exp.addTimeSpanSensor("Scenario overall defaultUsageScenario");
			initialiseThreads(expRun, tss);
		}

		// run measurements if the configuration is neither passive nor warmup only. 
		if (!cmdLine.hasOption('P') && !cmdLine.hasOption('W')){
			
			try {
			
				startThreads();

				waitForStopCondition();

				stop();
			
			} catch (RuntimeException e){
				throw e;
			} finally {
				writeResultsAndClose(datasource);
			}
		} 

	}
	
	/**
	 * This stops all currently running measurements. 
	 * Use this to stop measurements when this server is passive. 
	 */
	public static void stopMeasurements(){
		measureInnerResponseTimes = false;
		writeResultsAndClose(datasource);
	}


	private static void writeResultsAndClose(IDAOFactory datasource) {
		System.out.println("Storing results...");
		datasource.createExperimentDAO().storeAll();
		datasource.finalizeAndClose();
		System.out.println("...Done!");
		
		//wait a little before closing down results writer
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
		
		// TODO: make configurable which of the two is measured.
		o.addOption("C", "calls", false, "Measure response time of external call actions and SEFFs");
		o.addOption("S", "seffs", false, "Measure response time of SEFFs and externall call actions");
		
		o.addOption("P", "passive", false, "Make server passive, no load drivers are started. No warmup runs are executed, either.");
		o.addOption("W", "warmup only", false, "Execute a number of runs equal to the warmup runs configuration. Depending on configuration, the inner times might be measured.");
		
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
				throw new RuntimeException(e1);
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
				throw new RuntimeException(e);
			}
		}
	}

	private IDAOFactory prepareDatasource() {
		if (!checkDirectory(cmdLine.getOptionValue('d'))) {
			String error = "Unable to find data directory. Ensure data directory exists and is writeable";
			System.out.println(error);
			throw new RuntimeException(error);
		}
		IDAOFactory datasource = new FileDAOFactory(cmdLine.getOptionValue('d'));
		return datasource;
	}

	private boolean checkDirectory(String path) {
		File f = new File(path);
		if (f.isDirectory() && f.canWrite())
			return true;
		if (!f.exists()){
			return f.mkdir();
		} else {
			return false;
		}
	}

	protected abstract void setupResources();
	
	/** Initialise threads and perform warmup, if requested. */
	protected abstract void initialiseThreads(ExperimentRun expRun, TimeSpanSensor tss);
	
	public static ExperimentRun getLatestExperimentRun(){
		Collection<ExperimentRun> runs = AbstractMain.exp.getExperimentRuns();
		Iterator<ExperimentRun> it = runs.iterator();
		
		ExperimentRun experimentRun = null;
		
		//just take the last run... 
		while (it.hasNext()) {
			experimentRun = (ExperimentRun) it.next();
		}
		
		return experimentRun;
	}
	
	/**
	 * Returns a {@link TimeSpanSensor} in the experiment that has the name 
	 * sensorName. Creates a new sensor and returns it of no sensor with this name exists.
	 * The reuse is required because the EJB container may decide at times to create new instances
	 * of the components, so for one component type and one signature, this method may be 
	 * called multiple times during the measurements. We want to store all results per component
	 * type into one sensor, though. 
	 * @param sensorName The sensor name to match
	 * @return The {@link TimeSpanSensor} with the passed name or a 
	 * new {@link TimeSpanSensor} with that name that is then also added to the experiment.
	 */
	public static TimeSpanSensor createOrReuseTimeSpanSensor(String sensorName){

		Collection<Sensor> existingSesors = AbstractMain.exp.getSensors();
		for (Sensor sensor : existingSesors) {
			if (sensor instanceof TimeSpanSensor && sensor.getSensorName().equals(sensorName)){
				return (TimeSpanSensor)sensor;
			}
		}
		
		TimeSpanSensor tss = AbstractMain.exp.addTimeSpanSensor(sensorName);
		return tss;
	}
	
	public static long takeStartTimeForInnerMeasurement(){
		if (measureInnerResponseTimes){
			return System.nanoTime();
		} else {
			return 0;
		}
	}
	
	public static void takeMeasurement(long start, ExperimentRun experimentRun, TimeSpanSensor overallTimeSpanSensor) {
		
		if (measureInnerResponseTimes){
			long now = System.nanoTime();
			double measuredTimeSpan = (now - start) / Math.pow(10, 9);
		
			experimentRun.addTimeSpanMeasurement(overallTimeSpanSensor, 
				now / Math.pow(10, 9), measuredTimeSpan);
		}
		
	}
}
