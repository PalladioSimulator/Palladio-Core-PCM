package de.uka.ipd.sdq.simucomframework.exceptions;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * Singleton class that is used for counting simulated failures and printing
 * statistics.
 */
public class FailureStatistics {

	/**
	 * Singleton instance.
	 */
	private static FailureStatistics instance = new FailureStatistics();

	/**
	 * Retrieves the singleton instance.
	 * 
	 * @return the singleton instance
	 */
	public static synchronized FailureStatistics getInstance() {
		return instance;
	}

	/**
	 * Stores the session ids of all failed usage scenario runs.
	 * 
	 * This is required because with forked behaviours, multiple failures can
	 * occur in one usage scenario run. If so, the counter for failed runs must
	 * not be incremented for the second or any further failure within the same
	 * run.
	 */
	private HashSet<Long> failedRuns;

	/**
	 * Counters for all handled failure occurrences since last reset.
	 */
	private Map<String, Integer> handledFailureCounters;

	/**
	 * Counters for all failure occurrences since last reset.
	 */
	private Map<String, Integer> totalFailureCounters;

	/**
	 * Counts usage scenario runs since last reset.
	 */
	private long runCount;

	/**
	 * Counters for all unhandled failure occurrences since last reset.
	 */
	private Map<String, Integer> unhandledFailureCounters;

	/**
	 * Counts all handled failure occurrences since last reset.
	 */
	private long handledFailureCount;

	/**
	 * Counts all failure occurrences (handled and unhandled) since last reset.
	 */
	private long totalFailureCount;

	/**
	 * Counts all unhandled failure occurrences since last reset.
	 */
	private long unhandledFailureCount;

	/**
	 * The constructor.
	 */
	private FailureStatistics() {
		reset();
	}

	/**
	 * Retrieves the counters for all handled failure occurrences.
	 * 
	 * @return the counters
	 */
	public Map<String, Integer> getHandledFailureCounters() {
		return handledFailureCounters;
	}

	/**
	 * Retrieves the counters for all failure occurrences (handled and
	 * unhandled).
	 * 
	 * @return the counters
	 */
	public Map<String, Integer> getTotalFailureCounters() {
		return totalFailureCounters;
	}

	/**
	 * Retrieves the current usage scenario run count.
	 * 
	 * @return the usage scenario run count
	 */
	public long getRunCount() {
		return runCount;
	}

	/**
	 * Retrieves the counters for all unhandled failure occurrences.
	 * 
	 * @return the counters
	 */
	public Map<String, Integer> getUnhandledFailureCounters() {
		return unhandledFailureCounters;
	}

	/**
	 * Retrieves the total number of handled failure occurrences.
	 * 
	 * @return The number of handled failure occurrences
	 */
	public long getHandledFailureCount() {
		return handledFailureCount;
	}

	/**
	 * Retrieves the total number of failure occurrences (handled and
	 * unhandled).
	 * 
	 * @return the number of all failure occurrences
	 */
	public long getTotalFailureCount() {
		return totalFailureCount;
	}

	/**
	 * Retrieves the total number of unhandled failure occurrences.
	 * 
	 * @return the number of unhandled failure occurrences
	 */
	public long getUnhandledFailureCount() {
		return unhandledFailureCount;
	}

	/**
	 * Increases the counter for handled failures for the defined type.
	 * 
	 * @param type
	 *            The failure type as string.
	 */
	public synchronized void increaseHandledFailureCounter(String type) {
		Integer count = handledFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		handledFailureCounters.put(type, ++count);
		++handledFailureCount;
	}

	/**
	 * Increases the total failure counter for the defined type.
	 * 
	 * @param type
	 *            the failure type as string
	 */
	public synchronized void increaseTotalFailureCounter(String type) {
		Integer count = totalFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		totalFailureCounters.put(type, ++count);
		++totalFailureCount;
	}

	/**
	 * Increases total scenario run counter by one.
	 */
	public synchronized void increaseRunCount() {
		++runCount;
	}

	/**
	 * Inceases the unhandled failure counter for the defined type.
	 * 
	 * An unhandled failure means also a failed run. Thus, the list of failed
	 * runs is also updated with the given session id.
	 * 
	 * @param type
	 *            the failure type as string
	 * @param sessionId
	 *            the session id of the current run
	 */
	public synchronized void increaseUnhandledFailureCounter(String type,
			Long sessionId) {
		Integer count = unhandledFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		unhandledFailureCounters.put(type, ++count);
		++unhandledFailureCount;
		if (!failedRuns.contains(sessionId)) {
			failedRuns.add(sessionId);
		}
	}

	/**
	 * Prints failure and handling statistics to a logger.
	 * 
	 * @param logger
	 *            The logger to write the statistics to
	 */
	public void printFailureStatistics(Logger logger) {
		logger.warn("---- System Failure Statistics: START ----");
		logger.warn("Total usage scenario runs:        " + runCount);
		logger.warn("Total failed usage scenario runs: " + failedRuns.size());
		logger.warn("Total probability of success:     "
				+ (1 - failedRuns.size() / ((double) runCount)));
		for (String failureType : unhandledFailureCounters.keySet()) {
			double count = unhandledFailureCounters.get(failureType);
			logger.warn("Failure '" + failureType + "': " + (int) count + " ("
					+ count / runCount + ")");
		}
		printHandledFailuresStatistics(logger);
		logger.warn("---- System Failure Statistics: END -----");
	}

	/**
	 * Prints every one out of 1000 run counts to a logger.
	 * 
	 * @param logger
	 *            The logger to write the statistics to
	 */
	public synchronized void printRunCount(Logger logger) {
		if ((runCount % 50000) == 0) {
			// logger.warn("Current usage scenario runs: " + runCount);
			printFailureStatistics(logger);
		} else if ((runCount % 10000) == 0) {
			logger.warn("Current usage scenario runs: " + runCount);
		}
	}

	/**
	 * Resets all counters.
	 */
	public void reset() {
		unhandledFailureCounters = new HashMap<String, Integer>();
		totalFailureCounters = new HashMap<String, Integer>();
		handledFailureCounters = new HashMap<String, Integer>();
		failedRuns = new HashSet<Long>();

		unhandledFailureCount = 0;
		handledFailureCount = 0;
		totalFailureCount = 0;

		runCount = 0;
	}

	/**
	 * Prints handling statistics to a logger.
	 * 
	 * @param logger
	 *            The logger to write the statistics to
	 */
	private void printHandledFailuresStatistics(Logger logger) {
		for (String failureType : handledFailureCounters.keySet()) {
			int handledCount = handledFailureCounters.get(failureType);
			Integer totalFailureCount = totalFailureCounters.get(failureType);
			if (totalFailureCount == null) {
				totalFailureCount = 0;
			}
			logger.warn("Failure '" + failureType + "': Handled "
					+ handledCount + " out of " + totalFailureCount + " ("
					+ ((double) handledCount) / (totalFailureCount) + ")");
		}
	}
}
