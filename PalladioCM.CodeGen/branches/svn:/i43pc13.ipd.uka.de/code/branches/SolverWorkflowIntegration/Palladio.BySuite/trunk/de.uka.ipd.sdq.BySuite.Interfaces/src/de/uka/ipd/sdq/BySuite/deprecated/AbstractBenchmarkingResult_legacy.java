package de.uka.ipd.sdq.BySuite.deprecated;

import java.io.Serializable;
import java.util.UUID;

import de.uka.ipd.sdq.BySuite.utils.AbstractExecutionSetting;
import de.uka.ipd.sdq.BySuite.utils.ParametersNotSuitableException;
import de.uka.ipd.sdq.BySuite.utils.ParametersRequiredButNotSetException;


/**
 * A generic class to describe (for ONE bytecode instruction or ONE method)
 * its benchmarked value. Accounts for parametric dependencies.

 * @author Michael
 */
public abstract class AbstractBenchmarkingResult_legacy implements Serializable{
	
	/**
	 * Nanoseconds (ns) or CPU cycle (CPUCYCLE)
	 */
	private enum Units{CPUCYCLE, NS}

	/**
	 * for implementing Serializable
	 */
	private static final long serialVersionUID = 1L;
	
	/**
	 * Describes parameter conversion flags for the parameters of this 
	 * opcode/method, if any are needed. For example, "java.lang.String" means 
	 * that the parameter at the same position of parameterValues is of the type 
	 * java.lang.String. This flags are needed because primitive types cannot 
	 * be stored in parameterValues, and Java Reflection is problematic for 
	 * getting the dynamic type of parameterValues' elements.
	 */
	private String[] parameterTypes;
	
	/**
	 * If the benchmarked entity requires parameters, those used for benchmarking 
	 * should be save in this field. Then, getBenchmarkedValue should be called with 
	 * (different) parameters to obtain the performance value. If no parameters 
	 * are required by the benchmarked entity, this field can be null. 
	 */
	private Object[] parameterValues;
	
	/**
	 * Instruction opcode, or method name, or method signature.
	 */
	private String readableRepresentation;
	
	/**
	 * Can be used for versioning, e.g. for distinguishing equal-named methods 
	 */
	private UUID resultUID;;
	
	/**
	 * Pointer to the description of the setting where the benchmarking 
	 * was performed (e.g. time, CPU, JVM, JVM parameters etc.)
	 */
	private AbstractExecutionSetting setting;
	
//	/**
//	 * E.g. -9 for nanoseconds, or -3 for milliseconds
//	 */
//	int timeUnitExponentOfSecond;
	
	/**
	 * The unique ID of the instruction/method benchmarked
	 */
	private UUID subjectUID;
	
	/**
	 * The unit of this instance (see <code>Units</code>)
	 */
	private Units unit;
	
	/** Computes the duration of the opcode/method if parameters are set
	 * (if any needed), otherwise, throws an exception
	 * @return the duration in <code>timeUnitExponentOfSecond</code>
	 * @throws ParametersRequiredButNotSetException
	 */
	public abstract double getBenchmarkedValue() 
		throws ParametersRequiredButNotSetException;
	
	/** Computes the duration of the opcode/method if given parameters are 
	 * correct (if any parameters needed), otherwise, throws an exception
	 * @param parameterValues
	 * @param parameterTypes
	 * @return
	 * @throws ParametersNotSuitableException
	 */
	public abstract double getBenchmarkedValue(
			Object[] parameterValues, 
			String[] parameterTypes)  
		throws ParametersNotSuitableException;

	public String[] getParameterTypes() {
		return parameterTypes;
	}

	public Object[] getParameterValues() {
		return parameterValues;
	}

	public String getReadableRepresentation() {
		return readableRepresentation;
	}

	public UUID getResultUID() {
		return resultUID;
	}

	public AbstractExecutionSetting getSetting() {
		return setting;
	}

	public UUID getSubjectUID() {
		return subjectUID;
	}
	
	public Units getUnit() {
		return unit;
	}

	@SuppressWarnings("unused")
	private void setParameterTypes(String[] parameterTypes) {
		this.parameterTypes = parameterTypes;
	}

	@SuppressWarnings("unused")
	private void setParameterValues(Object[] parameterValues) {
		this.parameterValues = parameterValues;
	}

	public void setReadableRepresentation(String readableRepresentation) {
		this.readableRepresentation = readableRepresentation;
	}

	public void setResultUID(UUID resultUID) {
		this.resultUID = resultUID;
	}

	@SuppressWarnings("unused")
	private void setSetting(AbstractExecutionSetting setting) {
		this.setting = setting;
	}

	public void setSubjectUID(UUID subjectUID) {
		this.subjectUID = subjectUID;
	}

	@SuppressWarnings("unused")
	private void setUnit(Units unit) {
		this.unit = unit;
	}

	public abstract int verifyParameterTypes();

	public abstract int verifyParameterTypes(Object[] parameterValues, 
			String[] parameterTypes);
}
