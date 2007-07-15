package de.uka.ipd.sdq.prototype.framework.strategies;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.prototype.framework.resourcetypes.ResourceTypeEnum;

public class FibonacciCPUStrategy implements IConsumerStrategy {

	private static Logger logger = 
		Logger.getLogger(FibonacciCPUStrategy.class.getName());
	
	/** which fibonacci number is calculated for the test */
	private static final int TEST_ITERATION_COUNT = 100000;
	
	/** number of warm up cycles before calibrating */ 
	private static final int WARM_UP_CYCLES = 5000;
	
	/** number of measurements of fibonacci(TEST_ITERATION_COUNT) to calculate a mean from*/
	private static final int CALIBRATION_CYLCLES = 1000;
	
	private long lastResult;
	private double otherLastResult;
	private double iterationsPerUnit;

	public long getLastResult() {
		return lastResult;
	}

	@Override
	public void consume(double demand) {
		logger.debug("Consume Fibonacci CPU demand: "+demand);
		logger.debug("Calculating "+demand * iterationsPerUnit+" Fibonacci numbers");
		this.lastResult = fibonacci(demand * iterationsPerUnit);
		logger.debug("Demand consumed");
	}

	@Override
	public ResourceTypeEnum getStrategiesResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public void initialiseStrategy(double processingRate) {
		logger.debug("Initialising Fibonacci CPU strategy");
		for (int i = 0; i < WARM_UP_CYCLES; i++)
			lastResult = fibonacci(TEST_ITERATION_COUNT);
		
		double seconds = measure(TEST_ITERATION_COUNT);
		double secondsOffset = measure(0);

		double iterationsPerSecond = TEST_ITERATION_COUNT / (seconds - secondsOffset);
		iterationsPerUnit = iterationsPerSecond / processingRate;
		
		logger.debug("Iterations per unit for Fibonacci CPU strategy: "+iterationsPerUnit);
		logger.debug("Fibonacci CPU strategy initialised");
	}

	private double measure(int iterationCount) {
		//measured times in seconds
		long[] measurementsInSec = new long[CALIBRATION_CYLCLES];
		
		//run a couple of times and calculate mean
		for (int i= 0; i < CALIBRATION_CYLCLES; i++){
			long start = System.nanoTime();
			otherLastResult = 5 * iterationsPerUnit;
			lastResult = fibonacci(iterationCount);
			measurementsInSec[i] = (System.nanoTime() - start);
			//System.out.println("Time is "+measurementsInSec[i]);
		}
		
		double seconds = mean(measurementsInSec)/ 1.0E9;
		//System.out.println("Mean time is "+seconds);
		return seconds;
	}

	private long fibonacci(double iterationCount) {
		long i1 = 1;
		long i2 = 1;
		long i3 = 0;
		for (long i = 0; i < iterationCount; i++) {
			i3 = i1 + i2;
			i2 = i1;
			i1 = i3;
		}
		return i3;
	}
	
	private static double mean(long[] p) {
	    long sum = 0;  // sum of all the elements
	    for (int i=0; i<p.length; i++) {
	        sum += p[i];
	    }
	    return sum / (double)(p.length);
	}

	public double getOtherLastResult() {
		return otherLastResult;
	}
	
}
