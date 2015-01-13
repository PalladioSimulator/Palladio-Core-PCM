package org.palladiosimulator.protocom.framework;

import java.io.File;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.CalibrationTable;
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
    protected static final String[] CPU_STRATEGIES = {
            "primes", "count_numbers", "fft", "fibonacci", "mandelbrot", "sortarray", "void", "wait"
    };
    /**
     * CPU strategies, corresponding classes
     */
    protected static final Class<?>[] CPU_STRATEGIES_CLASSES = {
            CalculatePrimesDemand.class, CountNumbersDemand.class, FFTDemand.class, FibonacciDemand.class,
            MandelbrotDemand.class, SortArrayDemand.class, VoidDemand.class, WaitDemand.class
    };

    /**
     * HDD strategies, names
     */
    protected static final String[] HDD_STRATEGIES = {
        "largeChunks"
    };
    /**
     * HDD strategies, corresponding classes
     */
    protected static final Class<?>[] HDD_STRATEGIES_CLASSES = {
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
        IDemandStrategy strategy = getStrategy(usedStrategy, CPU_STRATEGIES, CPU_STRATEGIES_CLASSES);

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
        IDemandStrategy strategy = getStrategy(usedStrategy, CPU_STRATEGIES, CPU_STRATEGIES_CLASSES);

        if (strategy == null) {
            LOGGER.warn("HDD strategy " + (usedStrategy == null ? "" : usedStrategy)
                    + " not found. Using LargeChunks instead");
            strategy = new org.palladiosimulator.protocom.resourcestrategies.activeresource.hdd.ReadLargeChunksDemand();
        }

        registerStrategy(calibrationPath, accuracy, processingRate, strategy,
                org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum.HDD);
    }

    
    
    
    
    
    
    
    
    /**
     * Returns the name of the file used to store the calibration table Filename depends on
     * paramters of this class
     * 
     * @return The calibration table file name
     */
    protected static String getCalibrationFileName(IDemandStrategy strategy, DegreeOfAccuracyEnum accuracy, String basePath) {
    	if (basePath == null) {
    		basePath = "../ProtoComCalibration/";
    	}
    	
    	File path = new File(basePath);
    	
    	if (!path.exists()) {
            if (path.mkdirs()) {
                LOGGER.info("Created Calibration Path " + path);
            } else {
                LOGGER.error("Could not create " + path
                	+ ". Assure you have the rights to create and write to this folder.");
                System.exit(0);
            }
    	}
    	
        return basePath
        	+ "/" + strategy.getName()
        	+ "_" + CalibrationTable.DEFAULT_CALIBRATION_TABLE_SIZE
        	+ "_" + accuracy.name() + ".ser";
    }
    
    
    
    private static void registerStrategy(String calibrationPath, DegreeOfAccuracyEnum accuracy, String processingRate,
            IDemandStrategy strategy, ResourceTypeEnum resourceType) {
        
    	double procRate = StackContext.evaluateStatic(processingRate, Double.class);
        
    	// Load calibration table here.
    	String fileName = getCalibrationFileName(strategy, accuracy, calibrationPath);
    	
    	File calibrationFile = new File(fileName);
    	CalibrationTable calibrationTable = CalibrationTable.load(calibrationFile);
    	
    	if (calibrationTable != null) {
    		strategy.setCalibrationTable(calibrationTable);
    	} else {
    		// TODO Fix resource strategies such that initialization is not required before calibration
    		strategy.initializeStrategy(accuracy, 0);
    		
    		calibrationTable = strategy.calibrate();
    		calibrationTable.save(calibrationFile);
    	}
    	
    	strategy.initializeStrategy(accuracy, procRate);

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
