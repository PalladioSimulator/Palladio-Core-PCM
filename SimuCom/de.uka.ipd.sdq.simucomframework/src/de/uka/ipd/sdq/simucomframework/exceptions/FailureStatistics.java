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

public class FailureStatistics {

	private static FailureStatistics instance = new FailureStatistics();

	private Writer writer;
	private List<String> knownFailures = new ArrayList<String>();

	private FailureStatistics() {
		try {
			reset();
			writer = new BufferedWriter(new FileWriter("C:\\Users\\bja\\statistcs.csv", false));
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public void finalize() {
		try {
			writer.write("Success; ");
			for (String knownFailure : this.knownFailures) {
				writer.write(String.format("%s; ", knownFailure));
			}
			writer.write("\n\n");
			writer.close();
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
	public static FailureStatistics getInstance() {
		return instance;
	}

	private Map<String, Integer> systemFailureCounters;
	private Map<String, Integer> localFailureCounters;
	private Map<String, Integer> handledFailureCounters;

	private int totalSystemFailureCount;
	private int totalHandledFailureCount;
	private int totalLocalFailureCount;

	private int runCount;

	public synchronized void increaseSystemFailureCounter(String type) {
		Integer count = systemFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		systemFailureCounters.put(type, ++count);
		++totalSystemFailureCount;
	}

	public synchronized void increaseHandledFailureCounter(String type) {
		Integer count = handledFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		handledFailureCounters.put(type, ++count);
		++totalHandledFailureCount;
	}

	public synchronized void increaseLocalFailureCounter(String type) {
		Integer count = localFailureCounters.get(type);
		if (count == null) {
			count = 0;
		}
		localFailureCounters.put(type, ++count);
		++totalLocalFailureCount;
	}

	public Map<String, Integer> getLocalFailureCounters() {
		return localFailureCounters;
	}

	public synchronized void increaseRunCount() {
		++runCount;
	}

	public Map<String, Integer> getSystemFailureCounters() {
		return systemFailureCounters;
	}

	public Map<String, Integer> getHandledFailureCounters() {
		return handledFailureCounters;
	}

	public int getTotalLocalFailureCount() {
		return totalLocalFailureCount;
	}

	public int getTotalSystemFailureCount() {
		return totalSystemFailureCount;
	}

	public int getTotalHandledFailureCount() {
		return totalHandledFailureCount;
	}

	public int getRunCount() {
		return runCount;
	}

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
		try {
			appendStatistics();
		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

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

	private void appendStatistics() throws IOException {
		for (String newFailure : this.localFailureCounters.keySet()) {
			if (!knownFailures.contains(newFailure)) {
				knownFailures.add(newFailure);
			}
		}


		writer.write(String.format("%.6f; ", 1 - totalSystemFailureCount / ((double) runCount)));
		for (String failure : this.knownFailures) {
			Integer count = systemFailureCounters.get(failure);
			if(count==null)
				count=0;
			writer.write(String.format("%.6f; ", ((double)count) / runCount));
		}
		writer.write('\n');

	}

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
