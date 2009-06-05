package de.uka.ipd.sdq.BySuite.benchmarking;

import java.io.Serializable;

import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.BenchmarkingResultNotInitialisedProperlyException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.NoSuchOpcodeException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.ParametersNotSuitableException;
import de.uka.ipd.sdq.BySuite.benchmarking.exceptions.ParametersRequiredButNotSetException;

/**
 * Base class for bytecode benchmarking results
 * @author Michael Kuperberg, mkuper@ipd.uka.de
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
	 * If the benchmarking result refers to a method invocation, 
	 * than the 182-185 opcodes should be used here. 
	 */
	int opcode = -1;

	/**
	 * If the benchmarking results refers to an opcode, this field should 
	 * hold the standard String representation of that opcode, following 
	 * the Java VM Spec 2nd Ed. (e.g. opcode = 0; opcodeMnemonicOrMethodSignature=NOP). 
	 * If the benchmarking results refers to a method, this field should
	 * hold the fully-qualified method signature following the Java conventions.
	 */
	String opcodeMnemonicOrMethodSignature = "UNDEFINED";

	/**
	 * Describes parameter conversion flags of this opcode/method, 
	 * if any parameters are required by the opcode/method.
	 */
	Integer[] parameterTypes = null;

	/**
	 * Describes parameter values of this opcode/method, if any.
	 */
	Object[] parameterValues = null;
	
	/**
	 * Pointer to the description of the setting where the benchmarking 
	 * was performed (e.g. time, CPU, JVM, JVM parameters etc.)
	 */
	BenchmarkingSetting setting = null; 
	
	/**
	 * The unit of this instance (see <code>Units</code>)
	 */
	Units unit = null;
	
	/**
	 * Actual benchmark result value - must be non-negative.
	 */
	double value = Double.NaN;
	
	/**
	 * TODO
	 * @param opcode
	 * @param setting
	 * @param unit
	 * @param value
	 */
	public AbstractBenchmarkingResult(
			int opcode, 
			BenchmarkingSetting setting, 
			Units unit, 
			double value) {
		super();
		this.opcode = opcode;
		this.setting = setting;
		this.unit = unit;
		this.value = value;
	}
	
	/**
	 * TODO
	 * @param opcode
	 * @param parameterTypes
	 * @param parameterValues
	 * @param setting
	 * @param unit
	 * @param value
	 */
	public AbstractBenchmarkingResult(
			int opcode, 
			Integer[] parameterTypes, 
			Object[] parameterValues,
			BenchmarkingSetting setting, 
			Units unit, 
			double value) {
		super();
		this.opcode = opcode;
		this.parameterTypes = parameterTypes;
		this.parameterValues = parameterValues;
		this.setting = setting;
		this.unit = unit;
		this.value = value;
	}
	
	/**
	 * TODO
	 * @param opcode
	 * @param opcodeMnemonicOrMethodSignature
	 * @param setting
	 * @param unit
	 * @param value
	 */
	public AbstractBenchmarkingResult(
			int opcode, 
			String opcodeOrMethod,
			BenchmarkingSetting setting, 
			Units unit, 
			double value) {
		super();
		this.opcode = opcode;
		this.opcodeMnemonicOrMethodSignature = opcodeOrMethod;
		this.setting = setting;
		this.unit = unit;
		this.value = value;
	}
	
	/**
	 * TODO
	 * @param opcode
	 * @param opcodeMnemonicOrMethodSignature
	 * @param parameterTypes
	 * @param parameterValues
	 * @param setting
	 * @param unit
	 * @param value
	 */
	public AbstractBenchmarkingResult(
			int opcode, 
			String opcodeOrMethod,
			Integer[] parameterTypes, 
			Object[] parameterValues,
			BenchmarkingSetting setting, 
			Units unit, 
			double value) {
		super();
		this.opcode = opcode;
		this.opcodeMnemonicOrMethodSignature = opcodeOrMethod;
		this.parameterTypes = parameterTypes;
		this.parameterValues = parameterValues;
		this.setting = setting;
		this.unit = unit;
		this.value = value;
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(AbstractBenchmarkingResult o) {
		int compareSettings = this.setting.compareTo(o.setting);
		if(compareSettings==0){
			int compareOpcodes = new Integer(this.opcode).compareTo(new Integer(o.opcode)); 
			if(compareOpcodes==0){
				int compareStrings = new String(this.opcodeMnemonicOrMethodSignature).compareTo(new String(o.opcodeMnemonicOrMethodSignature)); 
				return compareStrings;
			}else{
				return compareOpcodes;
			}
		}else{
			return compareSettings;
		}
	}

	/** Computes the duration of the opcode/method if parameters are set
	 * (if any needed), otherwise, throws an exception
	 * @return the duration in <code>timeUnitExponentOfSecond</code>
	 * @throws ParametersRequiredButNotSetException
	 */
	public double getBenchmarkingValue() throws ParametersRequiredButNotSetException, BenchmarkingResultNotInitialisedProperlyException{
		if(value==Double.NaN){
			throw new BenchmarkingResultNotInitialisedProperlyException("TODO");
		}
		return value;
	}

	/** Computes the duration of the opcode/method if given parameters are 
	 * correct (if any parameters needed), otherwise, throws an exception
	 * @param parameterValuesParam
	 * @param parameterTypesParam
	 * @return
	 * @throws ParametersNotSuitableException
	 * @throws BenchmarkingResultNotInitialisedProperlyException 
	 */
	public abstract double getBenchmarkingValue(
			Object[] parameterValuesParam, 
			Integer[] parameterTypesParam)  
		throws ParametersNotSuitableException, BenchmarkingResultNotInitialisedProperlyException;

	/**
	 * TODO
	 * @return
	 */
	public int getOpcode() throws BenchmarkingResultNotInitialisedProperlyException{
		if(opcode==-1){
			throw new BenchmarkingResultNotInitialisedProperlyException("TODO"); 
		}
		return opcode;
	}

	/**
	 * TODO
	 * @return
	 * @throws BenchmarkingResultNotInitialisedProperlyException
	 */
	public String getOpcodeMnemonicOrMethodSignature() throws BenchmarkingResultNotInitialisedProperlyException{
		if(opcodeMnemonicOrMethodSignature.equals("UNDEFINED")){
			throw new BenchmarkingResultNotInitialisedProperlyException("TODO"); 
		}
		return opcodeMnemonicOrMethodSignature;
	}

	/**
	 * TODO
	 * @param index
	 * @return
	 */
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

	/**
	 * TODO
	 * @param index
	 * @return
	 */
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
	 * Simple getter
	 * @return
	 * @throws BenchmarkingResultNotInitialisedProperlyException
	 */
	public double getValue()  throws BenchmarkingResultNotInitialisedProperlyException{
		if(new Double(value).equals(Double.NaN)){
			throw new BenchmarkingResultNotInitialisedProperlyException("TODO"); 
		}
		return value;
	}
	
	/**
	 * Setter that checks whether opcode is valid or not, and sets 
	 * <code>opcodeMnemonicOrMethodSignature</code> to "ANY_METHOD". If you want to set both
	 * opcode and opcodeOrString, use <code>setOpcodeAndMethod</code> instead.
	 * @param opcode
	 * @throws NoSuchOpcodeException
	 */
	public void setOpcode(int opcode) throws NoSuchOpcodeException{
		if(opcode<0 || opcode>202){
			throw new NoSuchOpcodeException();
		}else{
			if(opcode>181 && opcode<186){
				this.opcodeMnemonicOrMethodSignature = "ANY_METHOD";
			}
			this.opcode = opcode;
			//TODO set opcodeMnemonicOrMethodSignature to match
		}
	}

	/**
	 * Sets <code>opcode</code> and <code>method</code>, but works only if
	 * opcode is 182, 183, 184 or 185. 
	 * @param opcode
	 * @param method
	 * @throws NoSuchOpcodeException
	 */
	public void setOpcodeAndMethod(int opcode, String method) throws NoSuchOpcodeException{
		if(opcode>181 && opcode<186){
			this.opcodeMnemonicOrMethodSignature = method;
			this.opcode = opcode;
		}else{
			//opcode opcodes 182, 183, 184 and 185 can signal a method invocation
			throw new NoSuchOpcodeException("TODO");
		}
	}

	/**
	 * Sets <code>opcodeMnemonicOrMethodSignature</code> only. Does NOT check whether the 
	 * parameter is a valid mnemonic of an opcode; instead, automatically sets
	 * the <code>opcodey</code> field to 1800 (which I define as a 
	 * "generalisation" for 182-185). 
	 * @param opcodeMnemonicOrMethodSignature
	 * @throws NoSuchOpcodeException
	 */
	public void setOpcodeMnemonicOrMethodSignature(String opcodeOrMethod) throws NoSuchOpcodeException{
		//TODO
		this.opcodeMnemonicOrMethodSignature = opcodeOrMethod;
		this.opcode = 1800; //TODO find a better solution
	}

	/**
	 * Simple setter
	 * @param parameterTypesParam
	 */
	@SuppressWarnings("unused")
	public void setParameterTypes(Integer[] parameterTypesParam) {
		this.parameterTypes = parameterTypesParam;
	}

	/**
	 * Simple setter
	 * @param parameterValuesParam
	 */
	@SuppressWarnings("unused")
	public void setParameterValues(Object[] parameterValuesParam) {
		this.parameterValues = parameterValuesParam;
	}

	/**
	 * Simple setter
	 * @param settingParam
	 */
	@SuppressWarnings("unused")
	public void setSetting(BenchmarkingSetting settingParam) {
		this.setting = settingParam;
	}

	/**
	 * Simple setter
	 * @param unitParam
	 */
	@SuppressWarnings("unused")
	public void setUnit(Units unitParam) {
		this.unit = unitParam;
	}

	/**
	 * Makes some plausibility checks before setting <code>value</code>, i.e. 
	 * the actua result of benchmarking.
	 * @param value
	 * @throws BenchmarkingResultNotInitialisedProperlyException
	 */
	public void setValue(double value) throws BenchmarkingResultNotInitialisedProperlyException{
		if(value<0 
				|| new Double(value).equals(Double.MAX_VALUE)
				|| new Double(value).equals(Double.NaN)
				|| new Double(value).equals(Double.POSITIVE_INFINITY)
				){
			this.value = 0D;
			throw new BenchmarkingResultNotInitialisedProperlyException("TODO");
		}else{
			this.value = value;
		}
	}

	/**
	 * TODO to implement
	 * @return
	 * @throws NoSuchMethodException 
	 */
	public abstract int verifyParameterTypes() throws NoSuchMethodException;

	
}
