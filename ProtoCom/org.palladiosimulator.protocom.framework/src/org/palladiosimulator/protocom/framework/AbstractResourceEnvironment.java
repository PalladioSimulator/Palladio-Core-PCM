package org.palladiosimulator.protocom.framework;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.DegreeOfAccuracyEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.IDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.CalculatePrimesDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.CountNumbersDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.FFTDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.FibonacciDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.MandelbrotDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.SortArrayDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.VoidDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu.WaitDemand;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.hdd.ReadLargeChunksDemand;

import de.uka.ipd.sdq.simucomframework.variables.StackContext;

/**
 * Assigns strategies for resource demand simulation. Also starts calibration for active resources.
 * 
 * Strategy is chosen by its name.
 * 
 * @author Sebastian Lehrig, Thomas Zolynski
 */
public class AbstractResourceEnvironment {

    protected static final org.apache.log4j.Logger LOGGER = org.apache.log4j.Logger.getRootLogger();

    /**
     * CPU strategies, names
     */
    protected static final String[] cpuStrategies = {
            "primes", "count_numbers", "fft", "fibonacci", "mandelbrot", "sortarray", "void", "wait"
    };
    /**
     * CPU strategies, corresponding classes
     */
    protected static final Class<?>[] cpuStrategiesClasses = {
            CalculatePrimesDemand.class, CountNumbersDemand.class, FFTDemand.class, FibonacciDemand.class,
            MandelbrotDemand.class, SortArrayDemand.class, VoidDemand.class, WaitDemand.class
    };

    /**
     * HDD strategies, names
     */
    protected static final String[] hddStrategies = {
        "largeChunks"
    };
    /**
     * HDD strategies, corresponding classes
     */
    protected static final Class<?>[] hddStrategiesClasses = {
        ReadLargeChunksDemand.class
    };

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
                    LOGGER.error("CPU strategy " + usedStrategy + " can not be instantiated");
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
     *            path where old calibration runs can be retrieved from and new ones will be stored
     * @param accuracy
     *            accuracy of the calibration: LOW, MEDIUM or HIGH
     * @param processingRate
     *            processing rate
     */
    protected static void setUpCPU(String usedStrategy, String calibrationPath, DegreeOfAccuracyEnum accuracy,
            String processingRate) {
        IDemandStrategy strategy = getStrategy(usedStrategy, cpuStrategies, cpuStrategiesClasses);

        if (strategy == null) {
            LOGGER.warn("CPU strategy " + (usedStrategy == null ? "" : usedStrategy)
                    + " not found. Using Fibonacci instead");
            strategy = new FibonacciDemand();
        }

        registerStrategy(calibrationPath, accuracy, processingRate, strategy,
                org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum.CPU);
    }

    /**
     * Starts the HDD calibration.
     * 
     * @param usedStrategy
     *            name of the used strategy
     * @param calibrationPath
     *            path where old calibration runs can be retrieved from and new ones will be stored
     * @param accuracy
     *            accuracy of the calibration: LOW, MEDIUM or HIGH
     * @param processingRate
     *            processing rate
     */
    protected static void setUpHDD(String usedStrategy, String calibrationPath, DegreeOfAccuracyEnum accuracy,
            String processingRate) {
        IDemandStrategy strategy = getStrategy(usedStrategy, cpuStrategies, cpuStrategiesClasses);

        if (strategy == null) {
            LOGGER.warn("HDD strategy " + (usedStrategy == null ? "" : usedStrategy)
                    + " not found. Using LargeChunks instead");
            strategy = new org.palladiosimulator.protocom.resourcestrategies.activeresource.hdd.ReadLargeChunksDemand();
        }

        registerStrategy(calibrationPath, accuracy, processingRate, strategy,
                org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum.HDD);
    }

    private static void registerStrategy(String calibrationPath, DegreeOfAccuracyEnum accuracy, String processingRate,
            IDemandStrategy strategy, ResourceTypeEnum resourceType) {
        double procRate = StackContext.evaluateStatic(processingRate, Double.class);
        strategy.initializeStrategy(accuracy, procRate, calibrationPath);

        org.palladiosimulator.protocom.framework.strategies.DemandConsumerStrategiesRegistry.singleton()
                .registerStrategyFor(resourceType, strategy);
    }

    /**
     * Performs the "delay" resource demand. TODO: Does not really fit into this class. However, we
     * didn't find a more suiting one.
     * 
     * @param delay
     *            delay duration in ms
     */
    public static void performDelay(double delay) {
        try {
            Thread.sleep(Math.round(delay));
        } catch (InterruptedException e) {
            LOGGER.error("Interrupted while performing a delay", e);
        }
    }
}
