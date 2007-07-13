package de.uka.ipd.sdq.prototype.framework.tests;

import junit.framework.Assert;

import org.junit.Test;
import org.junit.Before;

import de.uka.ipd.sdq.prototype.framework.resourcetypes.ResourceTypeEnum;
import de.uka.ipd.sdq.prototype.framework.strategies.FibonacciCPUStrategy;
import de.uka.ipd.sdq.prototype.framework.strategies.IConsumerStrategy;
import de.uka.ipd.sdq.prototype.framework.strategies.StrategiesRegistry;

public class PrototypePlatformTests {
	
	private static final double CPU_PROCESSING_RATE = 1000.0;

	@Before public void initialise() {
		IConsumerStrategy cpuStrategy = new FibonacciCPUStrategy();
		cpuStrategy.initialiseStrategy(CPU_PROCESSING_RATE);
		StrategiesRegistry.singleton().registerStrategyFor(
				ResourceTypeEnum.CPU, cpuStrategy);
	}
	
	@Test public void testConsumeCPU() {
		final long UNITS_TO_CONSUME = 5000;
		final double ERROR_LEVEL = 0.10; // Total error level
		
		double lowerAcceptanceBound = (UNITS_TO_CONSUME - (UNITS_TO_CONSUME * ERROR_LEVEL/2))/CPU_PROCESSING_RATE;
		double upperAcceptanceBound = (UNITS_TO_CONSUME + (UNITS_TO_CONSUME * ERROR_LEVEL/2))/CPU_PROCESSING_RATE;
		
		IConsumerStrategy cpuStrategy = StrategiesRegistry.singleton().getStrategyFor(ResourceTypeEnum.CPU);
		long start = System.nanoTime();
		cpuStrategy.consume(UNITS_TO_CONSUME);
		long end = System.nanoTime();
		double timeConsumptionInSeconds = (end-start)/1.0E9; 
		Assert.assertTrue("Lower acceptance level not reached "+timeConsumptionInSeconds+" "+lowerAcceptanceBound,timeConsumptionInSeconds >= lowerAcceptanceBound);
		Assert.assertTrue("Upper acceptance level not reached "+timeConsumptionInSeconds+" "+upperAcceptanceBound,timeConsumptionInSeconds <= upperAcceptanceBound);
	}
}
