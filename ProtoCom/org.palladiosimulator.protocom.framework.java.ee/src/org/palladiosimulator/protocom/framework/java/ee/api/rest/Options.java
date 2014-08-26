package org.palladiosimulator.protocom.framework.java.ee.api.rest;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

import javax.servlet.ServletContext;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.palladiosimulator.protocom.framework.java.ee.api.sockets.CalibrationSocket;
import org.palladiosimulator.protocom.framework.java.ee.json.JsonHelper;
import org.palladiosimulator.protocom.framework.java.ee.storage.Storage;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.CalibrationTable;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.ICalibrationListener;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.cpu.FibonacciDemand;
import org.palladiosimulator.protocom.resourcestrategies.ee.activeresource.hdd.ReadLargeChunksDemand;

/**
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
 *
 * @author Christian Klaussner
 */
class Calibrator implements Runnable, ICalibrationListener {
	enum StrategyType {
		CPU, HDD
	}

	private ServletContext context;
	private Storage storage;
	private StrategyType strategyType;

	/**
	 *
	 * @param strategy
	 * @param filename
	 */
	private void calibrateStrategy(IDemandStrategy strategy, String filename) {
		CalibrationTable table;

		strategy.setCalibrationListener(this);
		strategy.initializeStrategy(DegreeOfAccuracyEnum.LOW, 1.0);
		table = strategy.calibrate();

		try {
			storage.createFolder("calibration");
			storage.writeFile("calibration/" + filename, table.toBinary());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public Calibrator(ServletContext context) {
		this.context = context;

		storage = new Storage();
	}

	@Override
	public void progressChanged(float progress) {
		int percent = (int) (progress * 100.0f);
		int totalProgress;

		String message = "Calibrating " + strategyType + " Strategy (" + percent + "%)";

		if (strategyType == StrategyType.CPU) {
			totalProgress = percent / 2;
		} else {
			totalProgress = 50 + percent / 2;
		}

		CalibrationSocket.update(totalProgress, message);
	}

	@Override
	public void run() {
		// Calibrate CPU strategy.
		FibonacciDemand cpuStrategy = new FibonacciDemand();
		strategyType = StrategyType.CPU;

		calibrateStrategy(cpuStrategy, "low.cpu.fibonacci");

		// Calibrate HDD strategy.
		ReadLargeChunksDemand hddStrategy = new ReadLargeChunksDemand();
		strategyType = StrategyType.HDD;

		calibrateStrategy(hddStrategy, "low.hdd.largeChunks");

		// Update status.
		context.setAttribute("status", "started");
	}
}

/**
 *
 * @author Christian Klaussner
 */
class OptionsData {
	private String name;
	private String cpuStrategy, hddStrategy;
	private String accuracy;

	private String[] calibrated;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpuStrategy() {
		return cpuStrategy;
	}

	public void setCpuStrategy(String cpuStrategy) {
		this.cpuStrategy = cpuStrategy;
	}

	public String getHddStrategy() {
		return hddStrategy;
	}

	public void setHddStrategy(String hddStrategy) {
		this.hddStrategy = hddStrategy;
	}

	public String getAccuracy() {
		return accuracy;
	}

	public void setAccuracy(String accuracy) {
		this.accuracy = accuracy;
	}

	public String[] getCalibrated() {
		return calibrated;
	}

	public void setCalibrated(String[] calibrated) {
		this.calibrated = calibrated;
	}
}

/**
 *
 * @author Christian Klaussner
 */
@Path("/options")
public class Options {
	@Context
	private ServletContext context;

	private static ExecutorService executor;

	static {
		CalibrationThreadFactory factory = new CalibrationThreadFactory();
		executor = Executors.newFixedThreadPool(1, factory);
	}

	/**
	 *
	 * @return
	 */
	@GET
	@Produces(MediaType.TEXT_PLAIN)
	public Response getOptions() {
		Storage storage = new Storage();

		String optionsJson;
		String[] files;

		try {
			optionsJson = storage.readFileAsString("options.json");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		try {
			Set<String> calibrated = storage.getFiles("calibration");
			files = calibrated.toArray(new String[0]);
		} catch (IOException e) {
			// Calibration folder does not exist yet.
			files = new String[0];
		}

		OptionsData options = (OptionsData) JsonHelper.fromJson(optionsJson, OptionsData.class);
		options.setCalibrated(files);

		return Response.ok(JsonHelper.toJson(options)).build();
	}

	/**
	 *
	 * @param data
	 * @return
	 */
	@POST
	public Response setOptions(String data) {
		Storage storage = new Storage();
		boolean isCalibrated;

		try {
			Set<String> files = storage.getFiles("calibration");

			if (files.contains("low.cpu.fibonacci") && files.contains("low.hdd.largeChunks")) {
				isCalibrated = true;
			} else {
				isCalibrated = false;
			}
		} catch (IOException e) {
			// Calibration folder does not exist yet.
			isCalibrated = false;
		}

		if (isCalibrated) {
			context.setAttribute("status", "started");
		} else {
			context.setAttribute("status", "calibrating");
			executor.submit(new Calibrator(context));
		}

		try {
			// TODO: Validate input
			storage.writeFile("options.json", data);
		} catch (IOException e) {
			e.printStackTrace();
			return Response.serverError().build();
		}

		return Response.noContent().build();
	}
}
