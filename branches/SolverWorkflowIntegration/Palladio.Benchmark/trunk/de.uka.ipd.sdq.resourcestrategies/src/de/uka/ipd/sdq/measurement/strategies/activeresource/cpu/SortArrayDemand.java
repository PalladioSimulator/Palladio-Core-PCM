package de.uka.ipd.sdq.measurement.strategies.activeresource.cpu;

import java.util.Arrays;
import java.util.Random;

import de.uka.ipd.sdq.measurement.strategies.activeresource.ResourceTypeEnum;

public class SortArrayDemand extends AbstractDemandStrategy {

	private static double[] values = null;

	private static final int ARRAY_SIZE = 1024 * 1024; // 1M Values

	/**
	 * always use the same seed for the random values to reduce the variability
	 * of the sorting algorithms (the same seed generates the same sequence of
	 * values)
	 */
	private static final int SEED = 1234;

	static {
		values = new double[ARRAY_SIZE];
		Random r = new Random(1234);
		for (int i = 0; i < values.length; i++) {
			values[i] = r.nextDouble();
		}
	}

	public SortArrayDemand() {

		/** define the calibration accuracy parameter */
		high = 3;
		medium = 0;
		low = -3;

		/** which amount of numbers is calculated for the test */
		defaultIterationCount = 10000;

		/** number of warm up cycles before calibrating */
		warmUpCycles = 50;
	}

	private void sortArray(int amountOfNumbers) {
		int iterations = amountOfNumbers / ARRAY_SIZE;
		int rest = amountOfNumbers % ARRAY_SIZE;
		for (int i=0; i<iterations; i++){
			double[] lotsOfDoubles = getArray(ARRAY_SIZE);
			Arrays.sort(lotsOfDoubles);
		}
		double[] lotsOfDoubles = getArray(rest);
		Arrays.sort(lotsOfDoubles);
	}

	private double[] getArray(int amountOfNumbers) {
		return Arrays.copyOf(values, amountOfNumbers);
	}

	@Override
	public void run(long initial) {
		sortArray((int) initial);
	}

	@Override
	public ResourceTypeEnum getStrategysResource() {
		return ResourceTypeEnum.CPU;
	}

	@Override
	public String getName() {
		return "SortArray";
	}
}
