package de.uka.ipd.sdq.BySuite.benchmarking;

import de.uka.ipd.sdq.BySuite.benchmarking.AbstractBenchmarkingResult.Units;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.BenchmarkingResultNotInitialisedProperlyException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.ParametersNotSuitableException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.ParametersRequiredButNotSetException;

public class ParameterlessBytecodeBenchmarkingResult extends
		AbstractBenchmarkingResult {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	/**
	 * TODO
	 * @param opcode
	 * @param setting
	 * @param unit
	 * @param value
	 */
	public ParameterlessBytecodeBenchmarkingResult(int opcode,
			BenchmarkingSetting setting, Units unit, double value) {
		super(opcode, setting, unit, value);
		// TODO Auto-generated constructor stub
	}

	@Override
	public double getBenchmarkingValue(
			Object[] parameterValues,
			Integer[] parameterTypes) throws ParametersNotSuitableException, BenchmarkingResultNotInitialisedProperlyException {
		try {
			return getBenchmarkingValue();
		} catch (ParametersRequiredButNotSetException e) {
			e.printStackTrace();
			return Double.NaN;
		}
	}

	@Override
	public int verifyParameterTypes() {
		return 0;
	}

}
