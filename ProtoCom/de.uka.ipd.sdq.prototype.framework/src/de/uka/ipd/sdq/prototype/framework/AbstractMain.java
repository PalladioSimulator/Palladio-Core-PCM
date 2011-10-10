package de.uka.ipd.sdq.prototype.framework;

import java.io.File;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

import org.apache.commons.cli.GnuParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.OptionBuilder;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;
import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator;
import de.uka.ipd.sdq.sensorframework.dao.file.FileDAOFactory;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.sensorframework.entities.dao.IDAOFactory;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;

/**
 * Abstract parent class of the main class of a QoS prototype. The class includes static,
 * i.e., not generator or model dependent, code like command line reading, taking measurements 
 * or setting up prototyped resources.
 * 
 * @author Steffen Becker, Thomas Zolynski, Sebastian Lehrig
 * 
 */
public abstract class AbstractMain {

	/**
	 * Root logger of the whole application. Changing its configuration impacts all log output.
	 */
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

	/**
	 * Attributes for the measurements store
	 */
	private static IDAOFactory datasource = null;
	private ExperimentRun expRun;

	/**
	 * Threads used to simulate users
	 */
	protected ArrayList<Thread> threads = new ArrayList<Thread>();
	protected RunProperties runProps;

	/**
	 * Main method to run the generated prototype. It implements the main workflow, i.e.,
	 * parsing cmd line, setting up resources, datastores, RMI registry, etc.
	 *  
	 * @param args Command line arguments given for the prototype accoring to Apache CLI's configuration
	 */
	protected void run(String[] args) {

		parseCommandLine(args);
		setupLogging();
		logger.info("Command line read. Logging initialised. Protocom starts its workflow now...");
	
		logger.info("Reading allocation configuration. Callibrating container if needed");
		initAllocationStorage();
		AbstractAllocationStorage.initContainer();
		
		DefaultRandomGenerator randomGen = new DefaultRandomGenerator();
		if (runProps.hasOption('E')) {
			randomGen.setSeed(Long.parseLong(runProps.getOptionValue('E')));
		}
	
		logger.info("Initialising StoEx Cache " + (runProps.hasOption('E') ? " - Seed: " + runProps.getOptionValue('E') : ""));
	
		StoExCache.initialiseStoExCache(randomGen);
	
		if (runProps.hasOption('M')) // main class option set
		{
			String mainClass = runProps.getOptionValue('M');
			Method mainMethod = getMain(mainClass);
	
			if (!mainMethodFound(mainMethod))
			{
				// show menu & invoke selected method
				List<Integer> itemIds = showUserMenu();
				for (int itemId : itemIds)
				{
					handleMenuItem(itemId);
				}
			}
			else 
			{
				invokeMethod(mainMethod, new String[]{});
			}
		} else {
			startDefaultMain();
		}
	}

	private boolean mainMethodFound(Method mainMethod) {
		logger.debug(mainMethod == null ? "Main method not found. Falling back" : "Main method passed on command line.");
		return mainMethod != null;
	}

	protected void initMeasurement() {
		datasource = prepareDatasource();
		ExperimentManager.setExperiment(datasource.createExperimentDAO().addExperiment(runProps.getOptionValue('n')));
		expRun = ExperimentManager.addExperimentRun();
		logger.info("Created data source at event time " + (System.nanoTime() / Math.pow(10, 9)));

		if (runProps.hasOption('w')) {
			logger.info("Please pin java runtime to a single processor if needed! Press a key to continue!");
			waitForKey();
		}

		// init threads if configuration is active server (not -P) or only
		// warmup requested.
		if (!runProps.hasOption('P') || runProps.hasOption('W')) {
			initialiseThreads(ExperimentManager.getExperiment(), expRun);
		}

		// run measurements if the configuration is neither passive nor warmup
		// only.
		if (!runProps.hasOption('P') && !runProps.hasOption('W')) {

			try {

				logger.info("Current time: " + new Date());
				startThreads();

				stop();

			} catch (RuntimeException e) {
				throw e;
			} finally {
				logger.info("Current time: " + new Date());
				writeResultsAndClose(datasource);
			}
		}
		
		// close all running threads
		System.exit(0);
	}

	private void startDefaultMain() {
		if (!runProps.hasOption('R')) {
			initialiseSystems();
		}
		initMeasurement();
	}

	protected abstract void initAllocationStorage();

	private void invokeMethod(Method method, String[] params) {
		try {
			method.invoke(null, (Object) params);
		} catch (Exception e) {
			logger.error("Failed to run main method",e);
			System.exit(-1);
		}
	}

	private Method getMain(String mainClass) {
		if (mainClass == null)
			return null;
		try {
			Class<?> cls = Class.forName(mainClass);
			return cls.getMethod("main", String[].class);
		} catch (Throwable e) {
			logger.info("Failed to retrieve main class. Falling back to menu mode");
		}
		return null;
	}
	
	private Method getMain(Class<?> mainClass) {
		if (mainClass == null)
			return null;
		try {
			return mainClass.getMethod("main", String[].class);
		} catch (Throwable e) {
		}

		return null;
	}
	
	private List<Integer> showUserMenu() {
		System.out.println("Select starting option:");
		showMenuItems();
		System.out.print("Option: ");
		Scanner sc = new Scanner(System.in);
		String st = null;
		if (sc.hasNextLine()) {
			st = sc.nextLine();
		}
		sc.close();

		List<Integer> ids = new LinkedList<Integer>();
		if (st != null) {
			sc = new Scanner(st);

			while (sc.hasNextInt()) {
				ids.add(sc.nextInt());
			}
		}
		sc.close();

		return ids;
	}
	
	private void showMenuItems()
	{
		System.out.println("1: Start everything in local mode (hardware container #1 is used, only for testing purpose!)");
		System.out.println("2: RmiRegistry");
		System.out.println("3: Usage Scenarios");
		
		int i = 4;

		// systems
		String[][] systems = getSystems();
		for(String[] system : systems)
		{
			System.out.println(i+": System "+system[1]);
			i++;
		}
		
		// container
		Collection<String> containers = AbstractAllocationStorage.getContainerNames();
		for(String container : containers)
		{
			System.out.println(i+": Container "+container);
			i++;
		}
	}

	private void handleMenuItem(int itemId)
	{
		if(itemId == 1)
		{
			// Start everything in local mode
			logger.debug("Start: Start everything in local mode");
			RmiRegistry.startRegistry();
			AbstractAllocationStorage.setLocalMode(true);
			setupResources();
			startDefaultMain();
		}
		else if(itemId == 2)
		{
			// RmiRegistry
			logger.debug("Start: RmiRegistry");
			RmiRegistry.main(null);
		}
		else if(itemId == 3)
		{
			// Usage Scenarios
			logger.debug("Start: Usage Scenarios");
			initMeasurement();
		}
		else
		{
			int i = 4;
			
			// systems
			String[][] systems = getSystems();
			for(String[] system : systems)
			{
				if(itemId == i)
				{
					logger.debug("Start: System "+system[0]);
					invokeMethod(getMain(system[0]), getRMIRegistry());
				}
				i++;
			}
			
			// container
			Collection<String> containers = AbstractAllocationStorage.getContainerIds();
			for(String containerId : containers)
			{
				if(itemId == i)
				{
					logger.debug("Start: Container "+AbstractAllocationStorage.getContainerName(containerId));
					Collection<Class<?>> components = AbstractAllocationStorage.getComponents(containerId);
					AbstractAllocationStorage.setActiveContainer(containerId);
					setupResources();
					
					for(Class<?> component : components)
					{
						logger.debug("Start: Component "+component.getName());
						invokeMethod(getMain(component), getRMIRegistry());
					}
				}
				i++;
			}
		}
	}

	private String[] getRMIRegistry() {
		if (runProps.hasOption("R")) {
			return new String[]{ runProps.getOptionValue("R") };
		}
		return new String[]{};
	}

	private static void writeResultsAndClose(IDAOFactory datasource) {
		logger.info("Storing results...");
		datasource.createExperimentDAO().storeAll();
		datasource.finalizeAndClose();
		logger.info("...Done!");

		// wait a little before closing down results writer
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			logger.error("Failed to persist measurements", e);
			System.exit(-1);
		}
	}

	private void startThreads() {
		logger.info("Starting workload threads. ");
		if (runProps.hasOption('m'))
			logger.info("Taking " + runProps.getOptionValue('m') + " measurements");
		else
			logger.info("Request a measurement stop by pressing any key!");
		for (Thread t : threads) {
			t.start();
		}
	}

	private void setupLogging() {
		logger.removeAllAppenders();
		PatternLayout layout = new PatternLayout("%d{HH:mm} %-5p [%t]: %m%n");
		logger.addAppender(new ConsoleAppender(layout));
		if (runProps.hasOption('D'))
			logger.setLevel(Level.DEBUG);
		else
			logger.setLevel(Level.INFO);
	}

	@SuppressWarnings("static-access")
	private RunProperties parseCommandLine(String[] arguments) {
		Options o = new Options();
		o.addOption("w", "wait", false, "Suspend program execution before starting to pin program to a single processor");
		o.addOption("h", "help", false, "Show this help");

		// for required arguments see comment at the end of this function!
		o.addOption(OptionBuilder.hasArg().withArgName("propertyFile").withLongOpt("propFile").withDescription(
				"Property file used to set default commandline parameters. Defaults can be overwritten by additional parameters.").create("f"));

		o.addOption(OptionBuilder.hasArg().withArgName("dataDirectory").withLongOpt("dataDir").withDescription(
				"Datadirectory used by the FileStorage Sensor DAO to store the measured times [mandatory]").create('d'));

		o.addOption(OptionBuilder.withDescription("Name of the experiment for use in the stored data [mandatory]").hasArg().withLongOpt("name").create('n'));

		o.addOption(OptionBuilder.hasArg().withArgName("user count").withLongOpt("threadcount").withDescription(
				"Override usage scenario population (only for closed workloads)").create("c"));

		o.addOption(OptionBuilder.hasArg().withArgName("max measurements").withLongOpt("maxmeasurement").withDescription("Maximum measurements to take")
				.create("m"));

		o.addOption(OptionBuilder.hasArg().withArgName("warmup runs").withLongOpt("warmup").withDescription("Warmup runs before measuring (default: 1000)")
				.create("u"));

		o.addOption(OptionBuilder.hasArg().withArgName("calibrationPath").withLongOpt("storeCalPath").withDescription(
				"Path to the directory where the calibration is stored [mandatory]").create("s"));

		o.addOption(OptionBuilder.hasArg().withArgName("ip").withLongOpt("remoteAddr").withDescription("Remote address to the system component.").create("R"));

		o.addOption(OptionBuilder.hasOptionalArg().withArgName("main").withLongOpt("mainClass").withDescription("Remote address to the system component.")
				.create("M"));

		o.addOption(OptionBuilder.hasArg().withArgName("seed").withLongOpt("randomGenerator").withDescription("Seed for the StoEx random generator")
				.create("E"));

		o.addOption("D", "debug", false, "Print debug information. Turn off for real experiments!");

		o.addOption("P", "passive", false, "Make server passive, no load drivers are started. No warmup runs are executed, either.");
		o.addOption("W", "warmup only", false,
				"Execute a number of runs equal to the warmup runs configuration. Depending on configuration, the inner times might be measured.");

		o.addOption(OptionBuilder.hasArgs().withLongOpt("cpuStrategy").withArgName("CPU Strategy").withDescription("CPU calibration strategy. Fibonacci on default.").create('p'));
		o.addOption(OptionBuilder.hasArgs().withLongOpt("hddStrategy").withArgName("HDD Strategy").withDescription("HDD calibration strategy. LargeChunks on default.").create('H'));
		o.addOption(OptionBuilder.hasArgs().withLongOpt("accuracy").withArgName("Accuracy").withDescription("Accuracy of CPU and HDD calibration: LOW, MEDIUM, or HIGH. MEDIUM on default.").create('a'));
		
		getAdditionalOptions(o);

		boolean parserError = false;
		try {
			runProps = new RunProperties(new GnuParser().parse(o, arguments), o);
		} catch (ParseException e) {
			logger.error("Unable to start execution\n" + e.getMessage() + "\n");
			parserError = true;
		}

		if (parserError || runProps.hasOption('h') || !runProps.hasOption('d') || !runProps.hasOption('n') || !runProps.hasOption('s') || !runProps.hasOption('m')) {
			new HelpFormatter().printHelp("Main", "Prototype runner, copyright 2007-2011, SDQ, IPD, Uni Karlsruhe & MDE, Uni Paderborn\n", o,
					"\nInitiated by Steffen Becker (steffen.becker@upb.de)");
			System.exit(-1);
		}
		return runProps;
	}

	protected void getAdditionalOptions(Options o) {
	}

	private void waitForKey() {
		try {
			System.in.read();
			while (System.in.available() > 0) {
				System.in.read();
			}
		} catch (java.io.IOException e) {
			logger.error("Failed to wait for key. " + e);
			System.exit(-1);
		}		
	}

	private void stop() {
		if (!runProps.hasOption('m')) {
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
		if (!checkDirectory(runProps.getOptionValue('d'))) {
			String error = "Unable to find data directory. Ensure data directory exists and is writeable";
			logger.error(error);
			throw new RuntimeException(error);
		}
		IDAOFactory datasource = new FileDAOFactory(runProps.getOptionValue('d'));
		return datasource;
	}

	private boolean checkDirectory(String path) {
		File f = new File(path);
		if (f.isDirectory() && f.canWrite())
			return true;
		if (!f.exists()) {
			return f.mkdir();
		} else {
			return false;
		}
	}

	protected abstract void setupResources();

	protected abstract void initialiseSystems();

	protected abstract String[][] getSystems();
	
	protected DegreeOfAccuracyEnum getAccuracy()
	{
		DegreeOfAccuracyEnum accuracy = DegreeOfAccuracyEnum.MEDIUM;
		if(runProps.hasOption('a'))
		{
			try
			{
				String acc = runProps.getOptionValue('a').toUpperCase();
				accuracy = DegreeOfAccuracyEnum.valueOf( acc );
				logger.info("Using accuracy for calibration: " + acc);
			}
			catch(IllegalArgumentException e)
			{
				logger.warn("Calibration accuracy "+runProps.getOptionValue('a')+" not found! Using MEDIUM instead");
			}
		}
		else
		{
			logger.info("Using default accuracy for calibration: MEDIUM");
		}
		
		return accuracy;
	}
	
	/** 
	 * Initialise threads and perform warmup, if requested. 
	 */
	protected abstract void initialiseThreads(Experiment exp, ExperimentRun expRun);

	public static ExperimentRun getLatestExperimentRun() {
		Collection<ExperimentRun> runs = ExperimentManager.getExperiment().getExperimentRuns();
		Iterator<ExperimentRun> it = runs.iterator();

		ExperimentRun experimentRun = null;

		// just take the last run...
		while (it.hasNext()) {
			experimentRun = (ExperimentRun) it.next();
		}

		return experimentRun;
	}
}
