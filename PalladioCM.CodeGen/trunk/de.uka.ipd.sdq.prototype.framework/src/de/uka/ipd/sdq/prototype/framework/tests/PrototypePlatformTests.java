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

	@Before
	public void initialise() {
		IConsumerStrategy cpuStrategy = new FibonacciCPUStrategy();
		cpuStrategy.initialiseStrategy(CPU_PROCESSING_RATE);
		StrategiesRegistry.singleton().registerStrategyFor(
				ResourceTypeEnum.CPU, cpuStrategy);
	}

	@Test
	public void testConsumeCPU() {
		// long unitsToConsume = 5000;
		final double ERROR_LEVEL = 0.1; // Total error level for a single
		// measurement

		final int TEST_ITERATIONS = 20;
		final double OUTLIER_RATIO = 0.1; // How many measurements may be
		// outside bounds

		for (long unitsToConsume = 1; unitsToConsume <= 2048; unitsToConsume = unitsToConsume * 2) {
			double lowerAcceptanceBound = (unitsToConsume - (unitsToConsume
					* ERROR_LEVEL / 2))
					/ CPU_PROCESSING_RATE;
			double upperAcceptanceBound = (unitsToConsume + (unitsToConsume
					* ERROR_LEVEL / 2))
					/ CPU_PROCESSING_RATE;

			IConsumerStrategy cpuStrategy = StrategiesRegistry.singleton()
					.getStrategyFor(ResourceTypeEnum.CPU);

			int countOutliers = 0;
			for (int i = 0; i < TEST_ITERATIONS; i++) {
				long start = System.nanoTime();
				cpuStrategy.consume(unitsToConsume);
				long end = System.nanoTime();
				double timeConsumptionInSeconds = (end - start) / 1.0E9;
				if (timeConsumptionInSeconds < lowerAcceptanceBound
						|| timeConsumptionInSeconds > upperAcceptanceBound) {
					countOutliers++;
					/*if (timeConsumptionInSeconds < lowerAcceptanceBound)
						System.out
								.println("Lower acceptance level not reached in run "
										+ i
										+ ": Time is "
										+ timeConsumptionInSeconds
										+ " and must be higher than "
										+ lowerAcceptanceBound);
					if (timeConsumptionInSeconds > upperAcceptanceBound)
						System.out
								.println("Upper acceptance level not reached in run "
										+ i
										+ ": Time is "
										+ timeConsumptionInSeconds
										+ " and must be lower than "
										+ upperAcceptanceBound);*/
				}
				/*
				 * Assert.assertTrue("Lower acceptance level not reached in run " +
				 * i + ": Time is " + timeConsumptionInSeconds + " and must be
				 * higher than " + lowerAcceptanceBound,
				 * timeConsumptionInSeconds >= lowerAcceptanceBound);
				 * Assert.assertTrue("Upper acceptance level not reached in run " +
				 * i + ": Time is " + timeConsumptionInSeconds + " and must be
				 * lower than " + upperAcceptanceBound, timeConsumptionInSeconds <=
				 * upperAcceptanceBound);
				 */
			}

			/*System.out.println("There have been " + countOutliers
					+ " outliers out of " + TEST_ITERATIONS + " values for "
					+ unitsToConsume + " work units.");*/
			Assert.assertTrue("There have been more than " + TEST_ITERATIONS
					* OUTLIER_RATIO + " outliers for " + unitsToConsume
					+ " work units: " + countOutliers,
					countOutliers <= TEST_ITERATIONS * OUTLIER_RATIO);

		}
	}
}
