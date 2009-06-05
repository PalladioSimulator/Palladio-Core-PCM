package de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results;

import java.io.Serializable;

import de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.exceptions.ParametersNotSuitableException;
import de.uka.ipd.sdq.BySuite.ByPred.benchmarking.results.exceptions.ParametersRequiredButNotSetException;

/**
 * Base class for bytecode benchmarking results
 * @author Michael Kuperberg, mkuper@ipd.uka.de
 *
 */
public abstract class AbstractBenchmarkingResult implements Comparable<AbstractBenchmarkingResult>, Serializable{
	/**
	 * Nanoseconds (ns) or CPU cycle (CPUCYCLE)
	 * @author Michael
	 * TODO extract to a common package
	 */
	public enum Units{CPUCYCLE, NS}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Describes parameter conversion flags of this opcode/method, if any
	 */
	Integer[] parameterTypes;
	
	/**
	 * Describes parameter values of this opcode/method, if any
	 */
	Object[] parameterValues;
	
	/**
	 * Pointer to the description of the setting where the benchmarking 
	 * was performed (e.g. time, CPU, JVM, JVM parameters etc.)
	 */
	BenchmarkingSetting setting;
	
	/**
	 * The unit of this instance (see <code>Units</code>
	 */
	Units unit;
	
	/**
	 * Actual benchmark result value
	 */
	double value;
	
	/** Computes the duration of the opcode/method if parameters are set
	 * (if any needed), otherwise, throws an exception
	 * @return the duration in <code>timeUnitExponentOfSecond</code>
	 * @throws ParametersRequiredButNotSetException
	 */
	public double getBenchmarkingValue() throws ParametersRequiredButNotSetException{
		return value;
	}
	
	/** Computes the duration of the opcode/method if given parameters are 
	 * correct (if any parameters needed), otherwise, throws an exception
	 * @param parameterValuesParam
	 * @param parameterTypesParam
	 * @return
	 * @throws ParametersNotSuitableException
	 */
	public abstract double getBenchmarkingValue(
			Object[] parameterValuesParam, 
			Integer[] parameterTypesParam)  
		throws ParametersNotSuitableException;

	public Integer getParameterType(int index) {
		if(index>=0 && index<parameterTypes.length){
			return parameterTypes[index];
		}else{
			System.err.println("False index passed to getParameterType: "+index);
			return null;
		}
	}

	/**
	 * Simple getter
	 * @return
	 */
	public Integer[] getParameterTypes() {
		return parameterTypes;
	}

	public Object getParameterValue(int index) {
		if(index>=0 && index<parameterTypes.length){
			return parameterValues[index];
		}else{
			System.err.println("False index passed to getParameterValue: "+index);
			return null;
		}
	}

	/**
	 * Simple getter
	 * @return
	 */
	public Object[] getParameterValues() {
		return parameterValues;
	}

	/**
	 * Simple getter
	 * @return
	 */
	public BenchmarkingSetting getSetting() {
		return setting;
	}

	/**
	 * Simple getter
	 * @return
	 */
	public Units getUnit() {
		return unit;
	}

	/**
	 * Simple setter
	 * @param parameterTypesParam
	 */
	@SuppressWarnings("unused")
	private void setParameterTypes(Integer[] parameterTypesParam) {
		this.parameterTypes = parameterTypesParam;
	}

	/**
	 * Simple setter
	 * @param parameterValuesParam
	 */
	@SuppressWarnings("unused")
	private void setParameterValues(Object[] parameterValuesParam) {
		this.parameterValues = parameterValuesParam;
	}
	
	/**
	 * Simple setter
	 * @param settingParam
	 */
	@SuppressWarnings("unused")
	private void setSetting(BenchmarkingSetting settingParam) {
		this.setting = settingParam;
	}

	/**
	 * Simple setter
	 * @param unitParam
	 */
	@SuppressWarnings("unused")
	private void setUnit(Units unitParam) {
		this.unit = unitParam;
	}

	/**
	 * TODO to implement
	 * @return
	 * @throws NoSuchMethodException 
	 */
	public abstract int verifyParameterTypes() throws NoSuchMethodException;
	
	int opcode; //if the benchmarking result refers to a method invocation, than the 182-185 opcodes should be used
	String opcodeOrMethod;
//	/**
//	 * E.g. -9 for nanoseconds, or -3 for milliseconds
//	 */
//	int timeUnitExponentOfSecond;

	@Override
	public int compareTo(AbstractBenchmarkingResult o) {
		int compareSettings = this.setting.compareTo(o.setting);
		if(compareSettings==0){
			int compareOpcodes = new Integer(this.opcode).compareTo(new Integer(o.opcode)); 
			if(compareOpcodes==0){
				int compareStrings = new String(this.opcodeOrMethod).compareTo(new String(o.opcodeOrMethod)); 
				return compareStrings;
			}else{
				return compareOpcodes;
			}
		}else{
			return compareSettings;
		}
	}

	
}
