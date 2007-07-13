package de.uka.ipd.sdq.prototype.framework.strategies;

import de.uka.ipd.sdq.prototype.framework.resourcetypes.ResourceTypeEnum;

public class FibonacciCPUStrategy implements IConsumerStrategy {

	private static final int TEST_ITERATION_COUNT = 10000;
	private static final int WARM_UP_CYCLES = 3000;
	private long lastResult;
	private double iterationsPerUnit;

	public long getLastResult() {
		return lastResult;
	}

	@Override
	public void consume(double demand) {
		assert iterationsPerUnit > 0;
		
		long iterationCount = Math.round(demand * iterationsPerUnit);

		long i3 = fibonacci(iterationCount);
		
		this.lastResult = i3;
	}

	@Override
	public ResourceTypeEnum getStrategiesResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public void initialiseStrategy(double processingRate) {
		for (int i = 0; i < WARM_UP_CYCLES; i++)
			fibonacci(TEST_ITERATION_COUNT);
		long start = System.nanoTime();
		fibonacci(TEST_ITERATION_COUNT);
		long end = System.nanoTime() - start;
		double seconds = end / 1.0E9;
		double iterationsPerSecond = TEST_ITERATION_COUNT / seconds;
		iterationsPerUnit = iterationsPerSecond / processingRate;
	}

	private long fibonacci(long iterationCount) {
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
	
}
