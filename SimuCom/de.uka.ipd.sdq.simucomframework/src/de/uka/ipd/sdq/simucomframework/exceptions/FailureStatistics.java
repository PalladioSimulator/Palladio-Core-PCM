package de.uka.ipd.sdq.simucomframework.exceptions;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Singleton class that is used for counting simulated failures and printing statistics. 
 */
public class FailureStatistics {

	
	/**
	 * Singleton instance
	 */
	private static FailureStatistics instance = new FailureStatistics();
	public static FailureStatistics getInstance() {
		return instance;
	}
	
	/**
	 * All failures that have ever occured since last reset.
	 */
	private List<String> knownFailures = new ArrayList<String>();
	
	

	/**
	 * Returns the counters for all unhandled failures.
	 * @return Mapping of  failures to their counters
	 */
	public Map<String, Integer> getSystemFailureCounters() {
		return systemFailureCounters;
	}
	private Map<String, Integer> systemFailureCounters;
	

	/**
	 * @return The total number of all unhandled failures.
	 */
	public int getTotalSystemFailureCount() {
		return totalSystemFailureCount;
	}
	private int totalSystemFailureCount;

	/**
	 * Returns the counters for all failures that are ever raised. 
	 * @return A mapping of failure types and their counters.
	 */
	public Map<String, Integer> getLocalFailureCounters() {
		return localFailureCounters;
	}
	private Map<String, Integer> localFailureCounters;
	

	/**
	 * @return The total number of all raised failures.
	 */
	public int getTotalLocalFailureCount() {
		return totalLocalFailureCount;
	}
	private int totalLocalFailureCount;
	
	/**
	 * Counters for failures that are handled by a failure handling mechanism.
	 */
	private Map<String, Integer> handledFailureCounters;
	public Map<String, Integer> getHandledFailureCounters() {
		return handledFailureCounters;
	}
	
	/**
	 * @return The total number of successfully handled failures.
	 */
	public int getTotalHandledFailureCount() {
		return totalHandledFailureCount;
	}
	private int totalHandledFailureCount;
	

	/**
	 * @return The number of all scenario runs.
	 */
	public int getRunCount() {
		return runCount;
	}
	private int runCount;

	
	private FailureStatistics() {
		reset();
	}

	/**
	 * Increases the system failure counter for the defined type.
	 * 
	 * @param type The failure type as string.
	 */
	public synchronized void increaseSystemFailureCounter(String type) {
		Integer count = systemFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		systemFailureCounters.put(type, ++count);
		++totalSystemFailureCount;
	}

	/**
	 * Increases the counter for handled failures for the defined type.
	 * 
	 * @param type The failure type as string.
	 */
	public synchronized void increaseHandledFailureCounter(String type) {
		Integer count = handledFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		handledFailureCounters.put(type, ++count);
		++totalHandledFailureCount;
	}
	
	/**
	 * Increases the local failure counter for the defined type.
	 * 
	 * @param type The failure type as string.
	 */
	public synchronized void increaseLocalFailureCounter(String type) {
		Integer count = localFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		localFailureCounters.put(type, ++count);
		++totalLocalFailureCount;
	}

	/**
	 *  Increases total scenario run counter by one.
	 */
	public synchronized void increaseRunCount() {
		++runCount;
	}


	/**
	 * Prints failure and handling statistics to a logger.
	 * 
	 * @param logger The logger to write the statistics to
	 */
	public void printFailureStatistics(Logger logger) {
		logger.warn("---- System Failure Statistics ----");
		logger.warn("Total usage scenario runs: " + runCount);
		logger.warn("Total failures: " + totalSystemFailureCount);
		logger.warn("Total probability of success: " + (1 - totalSystemFailureCount / ((double) runCount)));
		for (String failureType : systemFailureCounters.keySet()) {
			double count = systemFailureCounters.get(failureType);
			logger.warn("Failure '" + failureType + "': " + (int) count + " (" + count / runCount + ")");
		}

		printHandledFailuresStatistics(logger);
	}

	/**
	 * Prints handling statistics to a logger.
	 * 
	 * @param logger The logger to write the statistics to
	 */
	private void printHandledFailuresStatistics(Logger logger) {
		logger.warn("---- Handled Failure Statistics ----");
		for (String failureType : handledFailureCounters.keySet()) {
			int handledCount = handledFailureCounters.get(failureType);
			Integer localFailureCount = localFailureCounters.get(failureType);
			if (localFailureCount == null)
				localFailureCount = 0;

			logger.warn("Failure '" + failureType + "': Handled " + handledCount + " out of " + localFailureCount + " (" + ((double) handledCount)
					/ (localFailureCount) + ")");
		}
	}

	/**
	 * Resets all counters.
	 */
	public void reset() {
		systemFailureCounters = new HashMap<String, Integer>();
		localFailureCounters = new HashMap<String, Integer>();
		handledFailureCounters = new HashMap<String, Integer>();

		totalSystemFailureCount = 0;
		totalHandledFailureCount = 0;
		totalLocalFailureCount = 0;

		runCount = 0;
		
		knownFailures=new ArrayList<String>();
	}
}
