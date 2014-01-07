package com.palladio_simulator.protocom.framework;

import java.lang.reflect.Method;
import java.rmi.RemoteException;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.apache.log4j.ConsoleAppender;
import org.apache.log4j.Level;
import org.apache.log4j.PatternLayout;

import com.palladio_simulator.protocom.framework.experiment.ExperimentManager;
import com.palladio_simulator.protocom.framework.experiment.IExperimentManager;
import com.palladio_simulator.protocom.framework.registry.RmiRegistry;
import com.palladio_simulator.protocom.framework.utils.CommandLineParser;
import com.palladio_simulator.protocom.framework.utils.RunProperties;
import com.palladio_simulator.protocom.framework.utils.UserMenu;
import com.palladio_simulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;

import de.uka.ipd.sdq.probfunction.math.IProbabilityFunctionFactory;
import de.uka.ipd.sdq.probfunction.math.impl.DefaultRandomGenerator;
import de.uka.ipd.sdq.probfunction.math.impl.ProbabilityFunctionFactoryImpl;
import de.uka.ipd.sdq.sensorframework.entities.Experiment;
import de.uka.ipd.sdq.sensorframework.entities.ExperimentRun;
import de.uka.ipd.sdq.simucomframework.variables.cache.StoExCache;

/**
 * Abstract parent class of the main class of a QoS prototype. The class
 * includes static, i.e., not generator or model dependent, code like command
 * line reading, taking measurements or setting up prototyped resources.
 * 
 * @author Steffen Becker, Sebastian Lehrig, Thomas Zolynski
 * 
 */
public abstract class AbstractMain {

	/**
	 * Root logger of the whole application. Changing its configuration impacts
	 * all log output.
	 */
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

	/**
	 * Threads used to simulate users.
	 */
	protected List<Thread> threads = new ArrayList<Thread>();

	protected RunProperties runProps;

	/**
	 * Main method to run the generated prototype. It implements the main
	 * workflow, i.e., parsing cmd line, setting up resources, datastores, RMI
	 * registry, etc.
	 * 
	 * @param args
	 *            Command line arguments given for the prototype according to
	 *            Apache CLI's configuration
	 */
	protected void run(String[] args) {
		runProps = CommandLineParser.parseCommandLine(args);
		setupLogging();
		logger.info("Command line read. Logging initialised. Protocom starts its workflow now...");

		logger.info("Reading allocation configuration. Callibrating container if needed");
		initAllocationStorage();
		AbstractAllocationStorage.initContainer();

		// FIXME: This should be removed. A fixed seed makes no sense in
		//        ProtoCom since the order of numbers will be messed up anyway.
		DefaultRandomGenerator randomGen = new DefaultRandomGenerator();
		if (runProps.hasOption('E')) {
			randomGen.setSeed(Long.parseLong(runProps.getOptionValue('E')));
		}

		RmiRegistry.setRemoteAddress(getRMIRegistry());
		RmiRegistry.setRegistryPort(getRMIPort());
		
		logger.info("Initialising StoEx Cache " + (runProps.hasOption('E') ? " - Seed: " + runProps.getOptionValue('E') : ""));

		IProbabilityFunctionFactory probFunctionFactory = ProbabilityFunctionFactoryImpl.getInstance();
		probFunctionFactory.setRandomGenerator(randomGen);
		StoExCache.initialiseStoExCache(probFunctionFactory);

		createUserMenu();
	}

	/**
	 * Creates the user menu with starting options item by item.
	 */
	private void createUserMenu() {
		List<Integer> itemIds = UserMenu.showUserMenu(getSystems());
		for (int itemId : itemIds) {
			handleMenuItem(itemId);
		}
	}

	/**
	 * Executes the action that corresponds to itemId.
	 * 
	 * @param itemId
	 *            The id of a menu item to execute
	 */
	private void handleMenuItem(int itemId) {
		if (itemId == 1) {
			// Start everything in local mode
			logger.debug("Start: Start everything in local mode");

			RmiRegistry.startRegistry();
			AbstractAllocationStorage.setLocalMode(true);
			setupResources();
			startLocalMode();
		} else if (itemId == 2) {
			// RmiRegistry
			logger.debug("Start: RmiRegistry");
			RmiRegistry.main(null);
		} else if (itemId == 3) {
			// Usage Scenarios
			logger.debug("Start: Usage Scenarios");

			try {
				ExperimentManager.init(runProps.getOptionValue('n') + " (Usage Scenario)", runProps.getOptionValue('d') + "-UsageScenario", IExperimentManager.EXPERIMENT_MANAGER_MASTER);
				ExperimentManager.getInstance().startNewExperimentRun();
			} catch (RemoteException e) {
				e.printStackTrace();
			}
			
			startMeasurements();
		} else {
			int i = 4;

			// systems
			String[][] systems = getSystems();
			for (String[] system : systems) {
				if (itemId == i) {
					logger.debug("Start: System " + system[0]);
					invokeMethod(getMain(system[0]), getRMIRegistry(), "" + getRMIPort());
				}
				i++;
			}

			// container
			Collection<String> containers = AbstractAllocationStorage.getContainerIds();
			for (String containerId : containers) {
				if (itemId == i) {
					logger.debug("Start: Container " + AbstractAllocationStorage.getContainerName(containerId));
					AbstractAllocationStorage.setActiveContainer(containerId);
					
					ExperimentManager.init(runProps.getOptionValue('n') + " (" + AbstractAllocationStorage.getContainerName(containerId) + ")", runProps.getOptionValue('d') + "-" + AbstractAllocationStorage.getContainerName(containerId), IExperimentManager.EXPERIMENT_MANAGER_SLAVE);
					ExperimentManager.getInstance().createExperimentRun();
					
					setupResources();

					startComponentsFromContainer(containerId);

				}
				i++;
			}
		}
	}

	private String getRMIRegistry() {
		if (runProps.hasOption("R")) {
			return runProps.getOptionValue("R");
		}
		return RmiRegistry.LOCALHOST;
	}
	
	private int getRMIPort() {
		if (runProps.hasOption("O")) {
			return Integer.parseInt(runProps.getOptionValue("O"));
		}
		return Registry.REGISTRY_PORT;
	}

	private Method getMain(Class<?> mainClass) {
		if (mainClass == null) {
			return null;
		}
		try {
			return mainClass.getMethod("main", String[].class);
		} catch (Throwable e) {
		}

		return null;
	}

	protected void startMeasurements() {
		// init threads if configuration is active server (not -P) or only
		// warmup requested.
		if (!runProps.hasOption('P') || runProps.hasOption('W')) {
			initialiseThreads(ExperimentManager.getExperiment(), ExperimentManager.getLatestExperimentRun());
		}

		// run measurements if the configuration is neither passive nor warmup
		// only.
		if (!runProps.hasOption('P') && !runProps.hasOption('W')) {

			try {

				logger.info("Current time: " + new Date());
				startThreads();

				stop();

				logger.info("Current time: " + new Date());
				ExperimentManager.getInstance().writeResultsAndClose();
				
			} catch (RuntimeException e) {
				throw e;
			} catch (RemoteException e) {
				logger.error("Error when calling remote server.", e);
			}
		}

		// close all running threads
		System.exit(0);
	}

	/**
	 * Starts the prototype in a local mode. This can only be used for testing,
	 * since all systems/components are started on one piece of hardware.
	 */
	private void startLocalMode() {
		ExperimentManager.init(runProps.getOptionValue('n'), runProps.getOptionValue('d'), IExperimentManager.EXPERIMENT_MANAGER_SLAVE);
		ExperimentManager.getInstance().createExperimentRun();

		Collection<String> containers = AbstractAllocationStorage.getContainerIds();

		for (String containerId : containers) {
			startComponentsFromContainer(containerId);
		}

		initialiseSystems();
		
		startMeasurements();
	}

	private void startComponentsFromContainer(String containerId) {
		Collection<ComponentAllocation> components = AbstractAllocationStorage.getComponents(containerId);

		for (ComponentAllocation component : components) {			
			logger.info("Start: Component " + component.getComponentClass().getName() + ", assembly context: " + component.getAssemblyContext());
			invokeMethod(getMain(component.getComponentClass()), getRMIRegistry(), "" + getRMIPort(), component.getAssemblyContext());
		}
	}

	protected abstract void initAllocationStorage();

	private void invokeMethod(Method method, String... params) {
		try {
			method.invoke(null, (Object) params);
		} catch (Exception e) {
			logger.error("Failed to run main method", e);
			System.exit(-1);
		}
	}

	private Method getMain(String mainClass) {
		if (mainClass == null) {
			return null;
		}
		try {
			Class<?> cls = Class.forName(mainClass);
			return cls.getMethod("main", String[].class);
		} catch (Throwable e) {
			logger.info("Failed to retrieve main class. Falling back to menu mode");
		}
		return null;
	}

	private void startThreads() {
		logger.info("Starting workload threads. ");
		if (runProps.hasOption('m')) {
			logger.info("Taking " + runProps.getOptionValue('m') + " measurements");
		} else {
			logger.info("Request a measurement stop by pressing any key!");
		}
		for (Thread t : threads) {
			t.start();
		}
	}

	private void setupLogging() {
		logger.removeAllAppenders();
		PatternLayout layout = new PatternLayout("%d{HH:mm} %-5p [%t]: %m%n");
		logger.addAppender(new ConsoleAppender(layout));
		if (runProps.hasOption('D')) {
			logger.setLevel(Level.DEBUG);
		} else {
			logger.setLevel(Level.INFO);
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

	/**
	 * Setup of resource
	 */
	protected abstract void setupResources();

	/**
	 * Starts all system elements by calling their main methods.
	 */
	protected abstract void initialiseSystems();

	/**
	 * Starts all components (for local mode!)
	 */
	// protected abstract void initialiseComponents();

	/**
	 * Returns an array of systems (class + name tuple).
	 * 
	 * @return [0]: class, [1]: name of each system element in this model
	 */
	protected abstract String[][] getSystems();

	protected DegreeOfAccuracyEnum getAccuracy() {
		DegreeOfAccuracyEnum accuracy = DegreeOfAccuracyEnum.MEDIUM;
		if (runProps.hasOption('a')) {
			try {
				String acc = runProps.getOptionValue('a').toUpperCase();
				accuracy = DegreeOfAccuracyEnum.valueOf(acc);
				logger.info("Using accuracy for calibration: " + acc);
			} catch (IllegalArgumentException e) {
				logger.warn("Calibration accuracy " + runProps.getOptionValue('a') + " not found! Using MEDIUM instead");
			}
		} else {
			logger.info("Using default accuracy for calibration: MEDIUM");
		}

		return accuracy;
	}

	/**
	 * Initialise threads and perform warmup, if requested.
	 * 
	 * @param exp
	 * @param expRun
	 */
	protected abstract void initialiseThreads(Experiment exp, ExperimentRun expRun);

	
	
	/**
	 * Returns an assembly context from an argument string array.
	 * 
	 * @param args
	 * @return
	 */
	public static String getAssemblyContextFromArguments(String[] args) {
		if (args != null && args.length > 2) {
			return args[2];
		}
		return "";
	}
	
}
