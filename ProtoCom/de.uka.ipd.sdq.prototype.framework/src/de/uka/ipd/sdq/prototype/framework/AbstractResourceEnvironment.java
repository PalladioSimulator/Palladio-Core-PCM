package de.uka.ipd.sdq.prototype.framework;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.CalculatePrimesDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.CountNumbersDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FFTDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.FibonacciDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.MandelbrotDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.SortArrayDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.VoidDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.cpu.WaitDemand;
import de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand;
import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * Assigns strategies for resource demand simulation. Also starts calibration
 * for active resources.
 * 
 * Strategy is chosen by its name.
 * 
 * @author Sebastian Lehrig, Thomas Zolynski
 */
public class AbstractResourceEnvironment {

	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

	/**
	 * CPU strategies, names
	 */
	protected static final String[] cpuStrategies = { "primes", "count_numbers", "fft", "fibonacci", "mandelbrot", "sortarray", "void", "wait" };
	/**
	 * CPU strategies, corresponding classes
	 */
	protected static final Class<?>[] cpuStrategiesClasses = { CalculatePrimesDemand.class, CountNumbersDemand.class, FFTDemand.class, FibonacciDemand.class,
			MandelbrotDemand.class, SortArrayDemand.class, VoidDemand.class, WaitDemand.class };

	/** 
	 * HDD strategies, names 
	 */
	protected static final String[] hddStrategies = { "largeChunks" };
	/** 
	 * HDD strategies, corresponding classes 
	 */
	protected static final Class<?>[] hddStrategiesClasses = { ReadLargeChunksDemand.class };

	/**
	 * Maps a strategy string to a strategy class.
	 * 
	 * @param usedStrategy
	 *            name of the strategy
	 * @param strategies
	 *            array of strategy names
	 * @param strategiesClasses
	 *            array of corresponding strategy classes
	 * @return new instance of the strategy class whose name was given
	 */
	private static IDemandStrategy getStrategy(String usedStrategy, String[] strategies, Class<?>[] strategiesClasses) {
		IDemandStrategy strategy = null;
		for (int i = 0; i < strategies.length; i++) {
			if (strategies[i].equals(usedStrategy)) {
				try {

					strategy = (IDemandStrategy) strategiesClasses[i].newInstance();
				} catch (InstantiationException e) {
					logger.error("CPU strategy " + usedStrategy + " can not be instantiated");
				} catch (IllegalAccessException e) {
				}
			}
		}
		return strategy;
	}

	/**
	 * Starts the CPU calibration.
	 * 
	 * @param usedStrategy
	 *            name of the used strategy
	 * @param calibrationPath
	 *            path where old calibration runs can be retrieved from and new
	 *            ones will be stored
	 * @param accuracy
	 *            accuracy of the calibration: LOW, MEDIUM or HIGH
	 * @param processingRate
	 *            processing rate
	 */
	protected static void setUpCPU(String usedStrategy, String calibrationPath, DegreeOfAccuracyEnum accuracy, String processingRate) {
		IDemandStrategy strategy = getStrategy(usedStrategy, cpuStrategies, cpuStrategiesClasses);

		if (strategy == null) {
			logger.warn("CPU strategy " + (usedStrategy == null ? "" : usedStrategy) + " not found. Using Fibonacci instead");
			strategy = new FibonacciDemand();
		}

		registerStrategy(calibrationPath, accuracy, processingRate, strategy, de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU);
	}

	/**
	 * Starts the HDD calibration.
	 * 
	 * @param usedStrategy
	 *            name of the used strategy
	 * @param calibrationPath
	 *            path where old calibration runs can be retrieved from and new
	 *            ones will be stored
	 * @param accuracy
	 *            accuracy of the calibration: LOW, MEDIUM or HIGH
	 * @param processingRate
	 *            processing rate
	 */
	protected static void setUpHDD(String usedStrategy, String calibrationPath, DegreeOfAccuracyEnum accuracy, String processingRate) {
		IDemandStrategy strategy = getStrategy(usedStrategy, cpuStrategies, cpuStrategiesClasses);

		if (strategy == null) {
			logger.warn("HDD strategy " + (usedStrategy == null ? "" : usedStrategy) + " not found. Using LargeChunks instead");
			strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand();
		}

		registerStrategy(calibrationPath, accuracy, processingRate, strategy, de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD);
	}

	private static void registerStrategy(String calibrationPath, DegreeOfAccuracyEnum accuracy, String processingRate, IDemandStrategy strategy,
			ResourceTypeEnum resourceType) {
		double procRate = StackContext.evaluateStatic(processingRate, Double.class);
		strategy.initializeStrategy(accuracy, procRate, calibrationPath);

		de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton().registerStrategyFor(resourceType, strategy);
	}

	/**
	 * Performs the "delay" resource demand. TODO: Does not really fit into this
	 * class. However, we didn't find a more suiting one.
	 * 
	 * @param delay
	 *            delay duration in ms
	 */
	public static void performDelay(double delay) {
		try {
			Thread.sleep(Math.round(delay));
		} catch (InterruptedException e) {
			logger.error("Interrupted while performing a delay", e);
		}
	}
}
