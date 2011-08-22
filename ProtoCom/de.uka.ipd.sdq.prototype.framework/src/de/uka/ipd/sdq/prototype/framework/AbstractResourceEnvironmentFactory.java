package de.uka.ipd.sdq.prototype.framework;

import de.uka.ipd.sdq.measurement.strategies.activeresource.DegreeOfAccuracyEnum;
import de.uka.ipd.sdq.measurement.strategies.activeresource.IDemandStrategy;
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

public class AbstractResourceEnvironmentFactory {
	
	protected static org.apache.log4j.Logger logger = org.apache.log4j.Logger.getRootLogger();

	protected static final String[] cpuStrategies = { "primes", "count_numbers", "fft", "fibonacci", "mandelbrot", "sortarray", "void", "wait" };
	protected static final Class<?>[] cpuStrategiesClasses = { CalculatePrimesDemand.class, CountNumbersDemand.class, FFTDemand.class, FibonacciDemand.class, MandelbrotDemand.class, SortArrayDemand.class, VoidDemand.class, WaitDemand.class };
	
	protected static final String[] hddStrategies = { "largeChunks" };
	protected static final Class<?>[] hddStrategiesClasses = { ReadLargeChunksDemand.class };

	private static IDemandStrategy getStrategy(String usedStrategy, String[] strategies, Class<?>[] strategiesClasses)
	{
		IDemandStrategy strategy = null;
		for (int i = 0; i < strategies.length; i ++) {
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
	
	protected static void setUpCPU(String usedStrategy, String calibrationPath, DegreeOfAccuracyEnum accuracy, String processingRate) {
		IDemandStrategy strategy = getStrategy(usedStrategy, cpuStrategies, cpuStrategiesClasses);

		if (strategy == null) {
			logger.error("CPU strategy " + (usedStrategy == null ? "" : usedStrategy) + " not found. Using Fibonacci instead");
			strategy = new FibonacciDemand();
		}

		// evaluateStatic returns an object which can be both, an integer or a double
		double procRate = Double.parseDouble(StackContext.evaluateStatic(processingRate).toString());
		
		strategy.initializeStrategy(accuracy, procRate, calibrationPath);
		de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton().registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.CPU, strategy);

	}
	
	protected static void setUpHDD(String usedStrategy, String calibrationPath, DegreeOfAccuracyEnum accuracy, String processingRate) {
		IDemandStrategy strategy = getStrategy(usedStrategy, cpuStrategies, cpuStrategiesClasses);;
		
		if (strategy == null) {
			logger.error("HDD strategy " + (usedStrategy == null ? "" : usedStrategy) + " not found. Using LargeChunks instead");
			strategy = new de.uka.ipd.sdq.measurement.strategies.activeresource.hdd.ReadLargeChunksDemand();
		}

		// evaluateStatic returns an object which can be both, an integer or a double
		double procRate = Double.parseDouble(StackContext.evaluateStatic(processingRate).toString());
		
		strategy.initializeStrategy(accuracy, procRate, calibrationPath);
		de.uka.ipd.sdq.prototype.framework.strategies.DemandConsumerStrategiesRegistry.singleton().registerStrategyFor(de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum.HDD, strategy);
	}
	
	public static void performDelay(double delay) {
		try {
			Thread.sleep(Math.round(delay));
		} catch (InterruptedException e) {
			logger.error("Interrupted while performing a delay", e);
		}
	}
}
