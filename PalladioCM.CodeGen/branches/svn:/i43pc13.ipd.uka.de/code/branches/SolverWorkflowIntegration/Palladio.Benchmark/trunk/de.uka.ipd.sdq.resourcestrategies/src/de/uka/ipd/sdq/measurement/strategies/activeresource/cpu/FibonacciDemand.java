package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;

public class FibonacciDemand extends AbstractDemandStrategy {

	public FibonacciDemand() {
		
		/** define the calibration accuracy parameter */
		high = 2; 
		medium = 0;
		low = -3;

		/** which fibonacci number is calculated for the test */
		defaultIterationCount = 10000;
		
		/** number of warm up cycles before calibrating */
		warmUpCycles = 5000;
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

	@Override
	public void run(long initial) {
		fibonacci(initial);
	}

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public String getName() {
		return "Fibonacci";
	}

}
