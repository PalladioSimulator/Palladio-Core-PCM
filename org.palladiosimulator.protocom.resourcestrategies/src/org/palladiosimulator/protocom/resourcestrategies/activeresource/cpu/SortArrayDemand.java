package org.palladiosimulator.protocom.resourcestrategies.activeresource.cpu;

import java.util.Arrays;
import java.util.Random;

import org.palladiosimulator.protocom.resourcestrategies.activeresource.AbstractDemandStrategy;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.CalibrationTable;
import org.palladiosimulator.protocom.resourcestrategies.activeresource.ResourceTypeEnum;

public class SortArrayDemand extends AbstractDemandStrategy {

	private double[] values = null;

	private int ARRAY_SIZE = 1024 * 1024; // Default: 1M Values

	/**
	 * always use the same seed for the random values to reduce the variability
	 * of the sorting algorithms (the same seed generates the same sequence of
	 * values)
	 */
	private static final int SEED = 1234;

	public SortArrayDemand(int arraySize) {
		super(-3,0,3,10000,50);
		ARRAY_SIZE = arraySize;
		values = new double[ARRAY_SIZE];
		Random r = new Random(SEED);
		for (int i = 0; i < values.length; i++) {
			values[i] = r.nextDouble();
		}
	}

	public SortArrayDemand() {
		super(-3,0,3,10000,50);
		values = new double[ARRAY_SIZE];
		Random r = new Random(SEED);
		for (int i = 0; i < values.length; i++) {
			values[i] = r.nextDouble();
		}
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
	
	@Override
	protected String getCalibrationFileName() {
		return getCalibrationPath() + "/" + getName() + "_"
				+ CalibrationTable.DEFAULT_CALIBRATION_TABLE_SIZE + "_" + ARRAY_SIZE + "_" + this.degreeOfAccuracy.name() + ".ser";
	}
	
	@Override
	public void cleanup() {
		// Do nothing.
	}
}
