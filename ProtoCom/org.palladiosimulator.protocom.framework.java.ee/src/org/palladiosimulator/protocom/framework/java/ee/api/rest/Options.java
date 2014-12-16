package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.inject.Inject;
import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.palladiosimulator.protocom.framework.java.ee.api.rest.data.OptionsData;
import org.palladiosimulator.protocom.framework.java.ee.api.sockets.CalibrationSocket;
import org.palladiosimulator.protocom.framework.java.ee.experiment.IExperiment;
import org.palladiosimulator.protocom.framework.java.ee.main.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.main.MainServlet;
import org.palladiosimulator.protocom.framework.java.ee.prototype.StrategiesRegistry;
import org.palladiosimulator.protocom.framework.java.ee.storage.IStorage;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.CalibrationTable;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.ICalibrationListener;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.ResourceTypeEnum;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.CalculatePrimesDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.CountNumbersDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.FFTDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.FibonacciDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.MandelbrotDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.SortArrayDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.VoidDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.WaitDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.hdd.ReadLargeChunksDemand;

/**
 * The CalibrationThreadFactory class is used to create background threads
 * for the calibration of resource strategies.
 *
 * @author Christian Klaussner
 */
class CalibrationThreadFactory implements ThreadFactory {
	@Override
	public Thread newThread(Runnable r) {
		Thread thread = new Thread(r);
		thread.setDaemon(true);

		return thread;
	}
}

/**
 * The StrategyBuilder class is used to create IDemandStrategy objects from strings.
 * @author Christian Klaussner
 */
class StrategyBuilder {
	private static final HashMap<String, Class<?>> cpu;
	private static final HashMap<String, Class<?>> hdd;

	private IStorage storage;

	static {
		// Add CPU strategies.
		cpu = new HashMap<String, Class<?>>();

		cpu.put("primes", CalculatePrimesDemand.class);
		cpu.put("countNumbers", CountNumbersDemand.class);
		cpu.put("fft", FFTDemand.class);
		cpu.put("fibonacci", FibonacciDemand.class);
		cpu.put("mandelbrot", MandelbrotDemand.class);
		cpu.put("sortArray", SortArrayDemand.class);
		cpu.put("void", VoidDemand.class);
		cpu.put("wait", WaitDemand.class);

		// Add HDD strategies.
		hdd = new HashMap<String, Class<?>>();

		hdd.put("largeChunks", ReadLargeChunksDemand.class);
	}

	/**
	 * Constructs a new StrategyBuilder object.
	 * @param storage the storage used for loading existing calibration data
	 */
	public StrategyBuilder(IStorage storage) {
		this.storage = storage;
	}

	/**
	 * Creates an IDemandStrategy object for the specified name.
	 * @param name the name of the strategy
	 * @param load true if the calibration data should be loaded, otherwise false
	 * @return an IDemandStrategy object for the specified name
	 */
	public IDemandStrategy create(String name, boolean load) {
		IDemandStrategy strategy = null;

		ResourceTypeEnum type;
		String strategyName = name.substring(4);

		// Find out the type of the strategy.
		if (name.startsWith("cpu.")) {
			type = ResourceTypeEnum.CPU;
		} else {
			type = ResourceTypeEnum.HDD;
		}

		try {
			switch (type) {
			case CPU:
				strategy = (IDemandStrategy) cpu.get(strategyName).newInstance();
				break;

			case HDD:
				strategy = (IDemandStrategy) hdd.get(strategyName).newInstance();
				break;
			}
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}

		// strategy.setDebug(true);

		if (load) {
			byte[] data = null;

			try {
				data = storage.readFile("calibration/" + name);
			} catch (IOException e) {
				e.printStackTrace();
			}

			CalibrationTable table = CalibrationTable.fromBinary(data);
			strategy.setCalibrationTable(table);
		} else {
			// TODO refactor resource strategies such that initialization is not required before calibration
			strategy.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM, 0);
		}

		StrategiesRegistry.getInstance()
			.registerStrategy(type, strategy);

		return strategy;
	}
}

/**
 * The StrategyCalibrator class is used to initialize a set of resource strategies.
 * @author Christian Klaussner
 */
class StrategyCalibrator implements Runnable, ICalibrationListener {
	private ServletContext context;
	private IStorage storage;

	private ArrayList<String> strategyNames;
	private int totalProgress = 0;

	/**
	 * Calibrates the specified resource strategy and stores the results.
	 * @param strategy the strategy to calibrate
	 * @param filename the filename under which the calibration data is stored
	 */
	private void calibrateStrategy(IDemandStrategy strategy, String filename) {
		CalibrationTable table;

		strategy.setCalibrationListener(this);
		table = strategy.calibrate();

		if (!strategy.debugEnabled()) {
			try {
				storage.createFolder("calibration");
				storage.writeFile("calibration/" + filename, table.toBinary());
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * Constructs a new Calibrator object.
	 * @param context the context of the application used to update the progress
	 * @param storage the storage used for storing the calibration data
	 */
	public StrategyCalibrator(ServletContext context, IStorage storage) {
		this.context = context;
		this.storage = storage;

		strategyNames = new ArrayList<String>(2);
	}

	/**
	 * Adds a resource strategy to the list of strategies to calibrate.
	 * @param strategyName the name of the strategy to calibrate
	 */
	public void addStrategy(String strategyName) {
		strategyNames.add(strategyName);
	}

	@Override
	public void progressChanged(IDemandStrategy strategy, float progress) {
		int percent = (int) (progress * 100.0f);
		String message = "Calibrating '" + strategy.getName() + "' strategy (" + percent + "%)";

		CalibrationSocket.update(totalProgress + percent / strategyNames.size(), message);
	}

	@Override
	public void run() {
		Logger logger = Logger.getRootLogger();
		logger.setLevel(Level.OFF);

		StrategyBuilder initializer = new StrategyBuilder(storage);

		// Calibrate all added strategies.
		for (int i = 0; i < strategyNames.size(); i++) {
			String strategyName = strategyNames.get(i);

			IDemandStrategy strategy = initializer.create(strategyName, false);
			calibrateStrategy(strategy, strategyName);

			totalProgress = 100 / strategyNames.size() * (i + 1);
		}

		// Update status.
		CalibrationSocket.update(100, "");
		context.setAttribute("status", "started");

		logger.setLevel(Level.INFO);
	}
}

/**
 * The Options class provides REST APIs for retrieving and setting the prototype's options.
 * @author Christian Klaussner
 */
@Path("/options")
public class Options {
	@Context
	private ServletContext context;

	private static ExecutorService executor;

	@Inject
	private IStorage storage;

	@Inject
	private IExperiment experiment;

	static {
		CalibrationThreadFactory factory = new CalibrationThreadFactory();
		executor = Executors.newFixedThreadPool(1, factory);
	}

	/**
	 * Gets the options for the prototype.
	 * @return a JSON object containing previously stored options or the default options.
	 */
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public Response getOptions() {
		String optionsJson;
		String[] files;

		try {
			optionsJson = storage.readFileAsString("options.json");
		} catch (FileNotFoundException e) {
			return Response.ok("{}").build();
		}

		try {
			Set<String> calibrated = storage.getFiles("calibration");
			files = calibrated.toArray(new String[0]);
		} catch (IOException e) {
			// Calibration folder does not exist yet.
			files = new String[0];
		}

		OptionsData options = JsonHelper.fromJson(optionsJson, OptionsData.class);
		options.setCalibrated(files);

		return Response.ok(JsonHelper.toJson(options)).build();
	}

	/**
	 * Sets the options for the prototype.
	 * @param data a JSON string containing the new option data
	 * @return a HTTP 204 response if the request could be fulfilled
	 */
	@POST
	public Response setOptions(String data) {
		boolean isCalibrated = true;

		OptionsData options = JsonHelper.fromJson(data, OptionsData.class);
		Set<String> files;
		
		StrategyBuilder builder = new StrategyBuilder(storage);
		StrategyCalibrator calibrator = new StrategyCalibrator(context, storage);

		String cpuStrategy = "cpu." + options.getCpuStrategy();
		String hddStrategy = "hdd." + options.getHddStrategy();

		try {
			files = storage.getFiles("calibration");

			// Load or calibrate CPU strategy.
			if (files.contains(cpuStrategy)) {
				builder.create(cpuStrategy, true);
			} else {
				isCalibrated = false;
				calibrator.addStrategy(cpuStrategy);
			}

			// Load or calibrate HDD strategy.
			if (files.contains(hddStrategy)) {
				builder.create(hddStrategy, true);
			} else {
				isCalibrated = false;
				calibrator.addStrategy(hddStrategy);
			}
		} catch (IOException e) {
			// Calibration folder does not exist yet.
			isCalibrated = false;

			calibrator.addStrategy(cpuStrategy);
			calibrator.addStrategy(hddStrategy);
		}

		if (isCalibrated) {
			context.setAttribute("status", "started");
		} else {
			context.setAttribute("status", "calibrating");
			executor.submit(calibrator);
		}

		// Set remaining options.
		experiment.init(options.getName());
		
		String seed = options.getSeed();
		
		if (seed.length() > 0) {
			try {
				MainServlet.setStoExSeed(Long.parseLong(options.getSeed()));
			} catch (NumberFormatException e) {
				MainServlet.setStoExSeed(0);
			}
		}

		// Store new options.
		try {
			// TODO Validate input
			storage.writeFile("options.json", data);
		} catch (IOException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		return Response.noContent().build();
	}
}
