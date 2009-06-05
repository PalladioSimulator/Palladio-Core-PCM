package de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results;

import de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.exceptions.ParametersNotSuitableException;
import de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.exceptions.ParametersRequiredButNotSetException;

public class ParameterlessBytecodeBenchmarkingResult extends
		AbstractBenchmarkingResult {

	@Override
	public double getBenchmarkingValue(
			Object[] parameterValues,
			Integer[] parameterTypes) throws ParametersNotSuitableException {
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
