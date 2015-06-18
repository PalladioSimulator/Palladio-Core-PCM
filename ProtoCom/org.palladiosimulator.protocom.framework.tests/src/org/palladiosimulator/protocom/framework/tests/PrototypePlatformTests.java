package org.palladiosimulator.protocom.framework.tests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import org.apache.log4j.Level;
import org.apache.log4j.Logger;
import org.junit.BeforeClass;
import org.junit.Test;
import org.palladiosimulator.protocom.framework.java.se.strategies.DemandConsumerStrategiesRegistry;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.FibonacciDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.hdd.ReadLargeChunksDemand;

public class PrototypePlatformTests {

    private static final double CPU_PROCESSING_RATE = 1000.0;
    private static final double HDD_PROCESSING_RATE = 1000.0;
    private static final String CALIBRATION_PATH = "../..";
    private static final Logger LOGGER = Logger.getLogger(PrototypePlatformTests.class.getName());

    @BeforeClass
    public static void setUp() {
        LOGGER.setLevel(Level.INFO);
        LOGGER.info("Initialising Testbed");
        final IDemandStrategy cpuStrategy = new FibonacciDemand();
        cpuStrategy.initializeStrategy(DegreeOfAccuracyEnum.HIGH, CPU_PROCESSING_RATE, CALIBRATION_PATH);
        cpuStrategy.ensureCalibrationExists();
        DemandConsumerStrategiesRegistry.singleton().registerStrategyFor(ResourceTypeEnum.CPU, cpuStrategy);

        final IDemandStrategy hddStrategy = new ReadLargeChunksDemand();
        hddStrategy.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM, HDD_PROCESSING_RATE, CALIBRATION_PATH);
        hddStrategy.ensureCalibrationExists();
        DemandConsumerStrategiesRegistry.singleton().registerStrategyFor(ResourceTypeEnum.HDD, hddStrategy);
        LOGGER.info("Testbed inialised");
    }

    @Test
    public void testConsumeCPU() {
        // long unitsToConsume = 5000;
        final double ERROR_LEVEL = 0.1; // Total error level for a single
        // measurement

        final int TEST_ITERATIONS = 1;
        final double OUTLIER_RATIO = 1.0; // How many measurements may be
        // outside bounds
        final int START_UNIT = 512; // Lower units cause larger relative overhead

        for (long unitsToConsume = START_UNIT; unitsToConsume <= 2048; unitsToConsume = unitsToConsume * 2) {
            testConsumeCPUUnits(ERROR_LEVEL, TEST_ITERATIONS, OUTLIER_RATIO, unitsToConsume);

        }
    }

    @Test
    public void testConsumeHDD() throws IOException {

        final ReadLargeChunksDemand hddStrategy = (ReadLargeChunksDemand) DemandConsumerStrategiesRegistry.singleton()
                .getStrategyFor(ResourceTypeEnum.HDD);

        assertEquals(hddStrategy.getClass(), ReadLargeChunksDemand.class);

        final BufferedWriter bw = new BufferedWriter(new FileWriter("testConsumeHDDResults.csv"));
        bw.write("SizeRead;Time");
        bw.newLine();

        hddStrategy.initializeStrategy(DegreeOfAccuracyEnum.MEDIUM, 0.0, CALIBRATION_PATH);
        hddStrategy.ensureCalibrationExists();

        final boolean random = true;

        final int iterations = 100;

        final double demand = 1000000;
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

    private void testConsumeCPUUnits(final double ERROR_LEVEL, final int TEST_ITERATIONS, final double OUTLIER_RATIO,
            final long unitsToConsume) {

        final double lowerAcceptanceBound = (unitsToConsume - (unitsToConsume * ERROR_LEVEL / 2)) / CPU_PROCESSING_RATE;
        final double upperAcceptanceBound = (unitsToConsume + (unitsToConsume * ERROR_LEVEL / 2)) / CPU_PROCESSING_RATE;

        final IDemandStrategy cpuStrategy = DemandConsumerStrategiesRegistry.singleton().getStrategyFor(
                ResourceTypeEnum.CPU);

        int countOutliers = 0;
        for (int i = 0; i < TEST_ITERATIONS; i++) {

            final long start = System.nanoTime();
            cpuStrategy.consume(unitsToConsume);
            final long end = System.nanoTime();

            final double timeConsumptionInSeconds = (end - start) / 1.0E9;

            if (timeConsumptionInSeconds < lowerAcceptanceBound || timeConsumptionInSeconds > upperAcceptanceBound) {
                countOutliers++;
                if (timeConsumptionInSeconds < lowerAcceptanceBound) {
                    LOGGER.info("Lower acceptance level not reached in run " + i + ": Time is "
                            + timeConsumptionInSeconds + " and must be higher than " + lowerAcceptanceBound);
                }
                if (timeConsumptionInSeconds > upperAcceptanceBound) {
                    LOGGER.info("Upper acceptance level not reached in run " + i + ": Time is "
                            + timeConsumptionInSeconds + " and must be lower than " + upperAcceptanceBound);
                }
            }
        }
        LOGGER.info("There have been " + countOutliers + " outliers out of " + TEST_ITERATIONS + " values for "
                + unitsToConsume + " workunits.");
        assertTrue("There have been more than " + TEST_ITERATIONS * OUTLIER_RATIO + " outliers for " + unitsToConsume
                + " work units: " + countOutliers, countOutliers <= TEST_ITERATIONS * OUTLIER_RATIO);
    }

    private void consumeRandomHDDDemand(final ReadLargeChunksDemand hddStrategy, final BufferedWriter bw,
            final int iterations) throws IOException {
        final double[] demand = new double[iterations];
        final long[] startTime = new long[iterations];
        final long[] endTime = new long[iterations];
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

    private void consumeDecreasingHDDDemand(final ReadLargeChunksDemand hddStrategy, final BufferedWriter bw,
            final int iterations) throws IOException {

        long sum;
        double demand;

        final long[] startTimes = new long[iterations];
        final long[] endTimes = new long[iterations];

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
            final double mean = sum / (double) iterations;
            System.out.println("Mean is " + mean + " nanoseconds, that is " + (mean / 1000000000) + " seconds.");
        }
    }

    private void writeHDDResultToFile(final BufferedWriter bw, final long startTime, final long endTime,
            final double demand, final int i) throws IOException {
        System.out.println(i + ": Reading " + demand + " B took " + (endTime - startTime) + " ns.");
        bw.write(demand + ";" + (endTime - startTime));
        bw.newLine();
        bw.flush();
    }

}
