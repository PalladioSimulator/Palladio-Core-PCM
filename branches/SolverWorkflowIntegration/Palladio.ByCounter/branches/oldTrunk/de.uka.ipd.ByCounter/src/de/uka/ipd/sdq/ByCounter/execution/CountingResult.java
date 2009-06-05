package de.uka.ipd.sdq.ByCounter.execution;

import java.util.HashMap;


/**
 * Class that holds the results of an instrumented method run.
 *
 * @author Martin Krogmann
 * @author Michael Kuperberg
 * @since 0.1
 * @version 0.3
 */
public class CountingResult {
	
	private HashMap<Integer, Long> opcodeCounts;
	private HashMap<String, Long>  methodCallCounts;
	
	private long[] newArrayCounts;
	private int[] newArrayDim;
	private String[] newArrayType;
	
	private String qualifyingMethodName;
	private long time; //TODO what kind of timestamp?
	
//	private static Logger log = Logger.getLogger(CountingResult.class.getCanonicalName());
	
	/**
	 * Constructs a new Result instance with the given values.
	 * @param time Time of method execution as returned by System.nanoTime().
	 * @param qualifyingMethodName Name of the evaluated method.
	 * @param opcodeCounts HashMap containing counts for every opcode occurrence.
	 * @param methodCallCounts HashMap containing count for every method that was called.
	 * @param newArrayCounts The counts for the specific array construction.
	 * @param newArrayDim The dimension information for the 
	 * specific array construction if more than one dimension exists.
	 * @param newArrayType The descriptor string for array construction of non-
	 * simple type or a string identifying the type else.
	 */
	public CountingResult(long time, 
			String qualifyingMethodName, 
			HashMap<Integer, Long> opcodeCounts, 
			HashMap<String, Long> methodCallCounts,
			long[] newArrayCounts,
			int[] newArrayDim,
			String[] newArrayType) {
		this.time = time;
		this.qualifyingMethodName = qualifyingMethodName;
		this.opcodeCounts = opcodeCounts;
		this.methodCallCounts = methodCallCounts;
		this.newArrayCounts = newArrayCounts;
		this.newArrayDim = newArrayDim;
		this.newArrayType = newArrayType;
	}

	/**
	 * @return the methodCallCounts
	 */
	public HashMap<String, Long> getMethodCallCounts() {
		return methodCallCounts;
	}

	/**
	 * Counts for array constructions.
	 * @return The array when recording was enabled. Null else.
	 */
	public long[] getNewArrayCounts() {
		return newArrayCounts;
	}

	/**
	 * The dimension of the new array if applicable. -1 else.
	 * @return The array when recording was enabled. Null else.
	 */
	public int[] getNewArrayDim() {
		return newArrayDim;
	}

	/**
	 * The types of the new arrays.
	 * @return The array when recording was enabled. Null else.
	 */
	public String[] getNewArrayTypes() {
		return newArrayType;
	}

	/**
	 * @return The counts.
	 * 		  A HashMap of integers where each bytecode instruction is 
	 *        the key for which the value represents the number of calls to a 
	 *        specific instruction.
	 */
	public HashMap<Integer, Long> getOpcodeCounts() {
		return opcodeCounts;
	}

	/**
	 * @return the qualifyingMethodName
	 */
	public String getQualifyingMethodName() {
		return qualifyingMethodName;
	}

	/**
	 * @return the time
	 */
	public long getTime() {
		return time;
	}
	
}
