package de.uka.ipd.sdq.ByCounter.execution;

import java.util.TreeMap;

public interface IFullCountingResult extends ISimpleCountingResult{

	/** 
	 * Simple getter for method call counts.
	 * @return A {@link HashMap} were the method name is mapped to the number 
	 * of calls of that method.
	 */
	public TreeMap<String, Long> getMethodCallCounts();
	
	/**
	 * TODO
	 * @param methodName
	 * @return
	 */
	public Long getMethodCountByString(String methodName);

	/**
	 * TODO
	 * @return
	 */
	public long getMethodInvocationBeginning();
	
	/**
	 * TODO
	 * @return
	 */
	public long getMethodReportingTime();
	
	/**
	 * TODO
	 * @return
	 */
	public Long getOpcodeCountByInteger(int opcode);

	/**
	 * TODO
	 * @return
	 */
	public Long getOpcodeCountByString(String opcode);

	/** 
	 * Simple getter for the opcode counts as a HashMap integers 
	 * where each bytecode instruction is the key for which 
	 * the value represents the number of calls to a specific instruction.
	 * @return The counts.
	 */
	public TreeMap<Integer, Long> getOpcodeCounts();

	/**
	 * Simple getter
	 * @return the qualifyingMethodName
	 */
	public String getQualifyingMethodName();

}