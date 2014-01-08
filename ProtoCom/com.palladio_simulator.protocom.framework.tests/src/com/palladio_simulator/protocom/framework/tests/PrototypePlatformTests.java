package com.palladio_simulator.protocom.framework.tests;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import junit.framework.Assert;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.palladio_simulator.protocom.framework.strategies.DemandConsumerStrategiesRegistry;
import com.palladio_simulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import com.palladio_simulator.protocom.resourcestrategies.activeresource.IDemandStrategy;
import com.palladio_simulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;
import com.palladio_simulator.protocom.resourcestrategies.activeresource.cpu.FibonacciDemand;
import com.palladio_simulator.protocom.resourcestrategies.activeresource.hdd.ReadLargeChunksDemand;

public class PrototypePlatformTests {

	private static final double CPU_PROCESSING_RATE = 1000.0;
	private static final double HDD_PROCESSING_RATE = 1000.0;
	private static Logger logger = Logger
			.getLogger(PrototypePlatformTests.class.getName());
	
	@Before
	public void initialise() {
		/*
		 * This is done by the Strategy Register itself at the moment, but will
		 * be needed later.
		 */
		System.out.println("Pls pin processor! Press a key when ready.");
		/*try {
			System.in.read();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}*/
		logger.debug("Initialising Testbed");
		IDemandStrategy cpuStrategy = new FibonacciDemand();
		cpuStrategy.initializeStrategy(DegreeOfAccuracyEnum.HIGH,CPU_PROCESSING_RATE);
		DemandConsumerStrategiesRegistry.singleton().registerStrategyFor(
				ResourceTypeEnum.CPU, cpuStrategy);

		IDemandStrategy hddStrategy = new ReadLargeChunksDemand();
		hddStrategy.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM,HDD_PROCESSING_RATE);
		DemandConsumerStrategiesRegistry.singleton().registerStrategyFor(
				ResourceTypeEnum.HDD, hddStrategy);
		logger.debug("Testbed inialised");
	}

	@Test
	public void testConsumeCPU() {
		// long unitsToConsume = 5000;
		final double ERROR_LEVEL = 0.1; // Total error level for a single
										// measurement

		final int TEST_ITERATIONS = 1;
		final double OUTLIER_RATIO = 0.1; // How many measurements may be
										  // outside bounds
		final int START_UNIT = 512;		  // Lower units cause larger relative overhead

		for (long unitsToConsume = START_UNIT; unitsToConsume <= 2048; unitsToConsume = unitsToConsume * 2) {
			testConsumeCPUUnits(ERROR_LEVEL, TEST_ITERATIONS, OUTLIER_RATIO,
					unitsToConsume);

		}
	}

	private void testConsumeCPUUnits(final double ERROR_LEVEL,
			final int TEST_ITERATIONS, final double OUTLIER_RATIO,
			long unitsToConsume) {

		double lowerAcceptanceBound = (unitsToConsume - (unitsToConsume
				* ERROR_LEVEL / 2))
				/ CPU_PROCESSING_RATE;
		double upperAcceptanceBound = (unitsToConsume + (unitsToConsume
				* ERROR_LEVEL / 2))
				/ CPU_PROCESSING_RATE;

		IDemandStrategy cpuStrategy = DemandConsumerStrategiesRegistry
				.singleton().getStrategyFor(ResourceTypeEnum.CPU);

		int countOutliers = 0;
		for (int i = 0; i < TEST_ITERATIONS; i++) {

			long start = System.nanoTime();
			cpuStrategy.consume(unitsToConsume);
			long end = System.nanoTime();

			double timeConsumptionInSeconds = (end - start) / 1.0E9;

			if (timeConsumptionInSeconds < lowerAcceptanceBound
					|| timeConsumptionInSeconds > upperAcceptanceBound) {
				countOutliers++;
				if (timeConsumptionInSeconds < lowerAcceptanceBound)
					logger.info("Lower acceptance level not reached in run "
							+ i + ": Time is " + timeConsumptionInSeconds
							+ " and must be higher than "
							+ lowerAcceptanceBound);
				if (timeConsumptionInSeconds > upperAcceptanceBound)
					logger.
							info("Upper acceptance level not reached in run "
									+ i + ": Time is "
									+ timeConsumptionInSeconds
									+ " and must be lower than "
									+ upperAcceptanceBound);
			}
		}
		logger.info("There have been " + countOutliers + " outliers out of "
				+ TEST_ITERATIONS + " values for " + unitsToConsume
				+ " workunits.");
		Assert.assertTrue("There have been more than " + TEST_ITERATIONS
				* OUTLIER_RATIO + " outliers for " + unitsToConsume
				+ " work units: " + countOutliers,
				countOutliers <= TEST_ITERATIONS * OUTLIER_RATIO);
	}

	@Test
	public void testConsumeHDD() throws IOException {

		ReadLargeChunksDemand hddStrategy = (ReadLargeChunksDemand) DemandConsumerStrategiesRegistry
				.singleton().getStrategyFor(ResourceTypeEnum.HDD);

		Assert
				.assertEquals(hddStrategy.getClass(),
						ReadLargeChunksDemand.class);

		BufferedWriter bw = new BufferedWriter(new FileWriter(
				"testConsumeHDDResults.csv"));
		bw.write("SizeRead;Time");
		bw.newLine();

		hddStrategy.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM,0.0);

		boolean random = true;

		int iterations = 100;

		double demand = 1000000;
		// warmup
		for (int i = 0; i < 100; i++) {
			hddStrategy.consume(demand);
		}

		if (!random) {
			consumeDecreasingHDDDemand(hddStrategy, bw, iterations);
		} else {
			consumeRandomHDDDemand(hddStrategy, bw, iterations);
		}

		// TODO: Noch mehr Tests.
	}
	
	private void consumeRandomHDDDemand(ReadLargeChunksDemand hddStrategy,
			BufferedWriter bw, int iterations) throws IOException {
		double[] demand = new double[iterations];
		long[] startTime = new long[iterations];
		long[] endTime = new long[iterations];
		for (int i = 0; i < iterations; i++) {
			demand[i] = Math.random() * hddStrategy.getMaxFileSize();
			startTime[i] = System.nanoTime();
			hddStrategy.consume(demand[i]);
			endTime[i] = System.nanoTime();
		}
		for (int i = 0; i < iterations; i++) {
			writeHDDResultToFile(bw, startTime[i], endTime[i], demand[i], i);
		}

	}

	private void consumeDecreasingHDDDemand(ReadLargeChunksDemand hddStrategy,
			BufferedWriter bw, int iterations) throws IOException {

		long sum;
		double demand;

		long[] startTimes = new long[iterations];
		long[] endTimes = new long[iterations];

		for (int j = hddStrategy.getMaxFileSize(); j > 0; j -= 1000000) {
			demand = j;

			for (int i = 0; i < iterations; i++) {
				startTimes[i] = System.nanoTime();
				hddStrategy.consume(demand);
				endTimes[i] = System.nanoTime();
			}
			sum = 0;
			for (int i = 0; i < iterations; i++) {

				sum += endTimes[i] - startTimes[i];
				writeHDDResultToFile(bw, startTimes[i], endTimes[i], demand, i);
			}
			double mean = sum / (double) iterations;
			System.out.println("Mean is " + mean + " nanoseconds, that is "
					+ (mean / 1000000000) + " seconds.");
		}
	}

	private void writeHDDResultToFile(BufferedWriter bw, long startTime,
			long endTime, double demand, int i) throws IOException {
		System.out.println(i + ": Reading " + demand + " B took "
				+ (endTime - startTime) + " ns.");
		bw.write(demand + ";" + (endTime - startTime));
		bw.newLine();
		bw.flush();
	}

}
