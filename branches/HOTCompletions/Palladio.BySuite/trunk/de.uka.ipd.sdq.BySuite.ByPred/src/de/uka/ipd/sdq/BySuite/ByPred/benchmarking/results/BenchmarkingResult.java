package de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results;

public abstract class BenchmarkingResult {
	/**
	 * Pointer to the description of the setting where the benchmarking 
	 * was performed (e.g. time, CPU, JVM, JVM parameters etc.)
	 */
	private BenchmarkingSetting setting;
	
	/**
	 * Nanoseconds (ns) or CPU cycle (CPUCYCLE)
	 * @author Michael
	 *
	 */
	private enum Units{NS, CPUCYCLE};
	
	/**
	 * The unit of this instance (see <code>Units</code>
	 */
	private Units unit;
	
//	/**
//	 * E.g. -9 for nanoseconds, or -3 for milliseconds
//	 */
//	int timeUnitExponentOfSecond;
	
	/**
	 * Describes parameter values of this opcode/method, if any
	 */
	private Object[] parameterValues;
	
	/**
	 * Describes parameter conversion flags of this opcode/method, if any
	 */
	private String[] parameterTypes;
	
	/** Computes the duration of the opcode/method if parameters are set
	 * (if any needed), otherwise, throws an exception
	 * @return the duration in <code>timeUnitExponentOfSecond</code>
	 * @throws ParametersRequiredButNotSetException
	 */
	public abstract double getBenchmarkingValue() 
		throws ParametersRequiredButNotSetException;
	
	/** Computes the duration of the opcode/method if given parameters are 
	 * correct (if any parameters needed), otherwise, throws an exception
	 * @param parameterValues
	 * @param parameterTypes
	 * @return
	 * @throws ParametersNotSuitableException
	 */
	public abstract double getBenchmarkingValue(
			Object[] parameterValues, 
			String[] parameterTypes)  
		throws ParametersNotSuitableException;

	public BenchmarkingSetting getSetting() {
		return setting;
	}

	@SuppressWarnings("unused")
	private void setSetting(BenchmarkingSetting setting) {
		this.setting = setting;
	}

	public Object[] getParameterValues() {
		return parameterValues;
	}

	@SuppressWarnings("unused")
	private void setParameterValues(Object[] parameterValues) {
		this.parameterValues = parameterValues;
	}

	public String[] getParameterTypes() {
		return parameterTypes;
	}

	@SuppressWarnings("unused")
	private void setParameterTypes(String[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}
	
	public abstract int verifyParameterTypes();

	@SuppressWarnings("unused")
	private void setUnit(Units unit) {
		this.unit = unit;
	}

	public Units getUnit() {
		return unit;
	}
}
