package de.uka.ipd.sdq.reliability.core;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.log4j.Logger;

/**
 * Singleton class that is used for counting simulated failures and printing statistics.
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
     * Maps numeric IDs to failure type names.
     */
    private Map<Integer, String> executionResultTypes;

    /**
     * Stores the session ids of all failed usage scenario runs.
     * 
     * This is required because with forked behaviours, multiple failures can occur in one usage
     * scenario run. If so, the counter for failed runs must not be incremented for the second or
     * any further failure within the same run.
     */
    private HashSet<Long> failedRuns;

    /**
     * Counts all handled failure occurrences since last reset.
     */
    private long handledFailureCount;

    /**
     * Counters for all handled failure occurrences since last reset.
     */
    private Map<MarkovFailureType, Integer> handledFailureCounters;

    /**
     * Counts usage scenario runs since last reset.
     */
    private long runCount;

    /**
     * Maps failure types to numeric IDs.
     */
    private Map<MarkovFailureType, Integer> simFailureTypes;

    /**
     * Counts all failure occurrences (handled and unhandled) since last reset.
     */
    private long totalFailureCount;

    /**
     * Counters for all failure occurrences since last reset.
     */
    private Map<MarkovFailureType, Integer> totalFailureCounters;

    /**
     * Counts all unhandled failure occurrences since last reset.
     */
    private long unhandledFailureCount;

    /**
     * Counters for all unhandled failure occurrences since last reset.
     */
    private Map<MarkovFailureType, Integer> unhandledFailureCounters;

    /**
     * The constructor.
     */
    private FailureStatistics() {
        reset();
    }

    /**
     * Retrieves the id of a given execution result.
     * 
     * Used for logging sensor data.
     * 
     * @param failureType
     *            the failure type that occurred as an execution result
     * @return the numerical id of the execution result
     */
    public int getExecutionResultId(MarkovFailureType failureType) {
        if (failureType == null) {
            return 0;
        }
        return simFailureTypes.get(failureType);
    }

    /**
     * Retrieves a complete mapping from numeric IDs to failure type names.
     * 
     * Used for building up execution result sensors.
     * 
     * @return a mapping from numeric IDs to failure type names
     */
    public Map<Integer, String> getExecutionResultTypes() {
        return executionResultTypes;
    }

    /**
     * Retrieves the system-external hardware-induced failure type with the given ids.
     * 
     * @param resourceTypeId
     *            the resource type id
     * @param systemRequiredRoleId
     *            the id of the corresponding system-external role
     * @param signatureId
     *            the id of the corresponding system-external signature
     * @return the corresponding failure type
     */
    public MarkovFailureType getExternalHardwareFailureType(final String resourceTypeId,
            final String systemRequiredRoleId, final String signatureId) {
        MarkovHardwareInducedFailureType comparator = MarkovHardwareInducedFailureType.createExternalFailureType(
                MarkovEvaluationType.POINTSOFFAILURE, resourceTypeId, signatureId, systemRequiredRoleId);
        return getFailureType(comparator);
    }

    /**
     * Retrieves the system-external network-induced failure type with the given ids.
     * 
     * @param commLinkResourceTypeId
     *            the communication link resource type id
     * @param systemRequiredRoleId
     *            the id of the corresponding system-external role
     * @param signatureId
     *            the id of the corresponding system-external signature
     * @return the corresponding failure type
     */
    public MarkovFailureType getExternalNetworkFailureType(final String commLinkResourceTypeId,
            final String systemRequiredRoleId, final String signatureId) {
        MarkovNetworkInducedFailureType comparator = MarkovNetworkInducedFailureType.createExternalFailureType(
                MarkovEvaluationType.POINTSOFFAILURE, commLinkResourceTypeId, signatureId, systemRequiredRoleId);
        return getFailureType(comparator);
    }

    /**
     * Retrieves the system-external software-induced failure type with the given id.
     * 
     * @param softwareFailureId
     *            the software-induced failure type id
     * @param systemRequiredRoleId
     *            the id of the corresponding system-external role
     * @param signatureId
     *            the id of the corresponding system-external signature
     * @return the corresponding failure type
     */
    public MarkovFailureType getExternalSoftwareFailureType(final String softwareFailureId,
            final String systemRequiredRoleId, final String signatureId) {
        MarkovSoftwareInducedFailureType comparator = MarkovSoftwareInducedFailureType.createExternalFailureType(
                MarkovEvaluationType.POINTSOFFAILURE, softwareFailureId, signatureId, systemRequiredRoleId);
        return getFailureType(comparator);
    }

    /**
     * Retrieves the failure type with the given id.
     * 
     * @param failureTypeId
     *            the failure type id
     * @return the failure type
     */
    public MarkovFailureType getFailureType(String failureTypeId) {
        Iterator<MarkovFailureType> iterator = simFailureTypes.keySet().iterator();
        while (iterator.hasNext()) {
            MarkovFailureType failureType = iterator.next();
            if (failureType.getId().equals(failureTypeId)) {
                return failureType;
            }
        }
        return null;
    }

    /**
     * Retrieves the numerical index that corresponds to a given failure type
     * 
     * @param failureType
     *            the failure type
     * @return the corresponding index
     */
    public int getFailureTypeIndex(final MarkovFailureType failureType) {
        return simFailureTypes.get(failureType);
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
     * Retrieves the counters for all handled failure occurrences.
     * 
     * @return the counters
     */
    public Map<MarkovFailureType, Integer> getHandledFailureCounters() {
        return handledFailureCounters;
    }

    /**
     * Retrieves the system-internal hardware-induced failure type with the given ids.
     * 
     * @param resourceContainerId
     *            the resource container id
     * @param resourceTypeId
     *            the resource type id
     * @return the corresponding failure type
     */
    public MarkovFailureType getInternalHardwareFailureType(final String resourceContainerId,
            final String resourceTypeId) {
        MarkovHardwareInducedFailureType comparator = MarkovHardwareInducedFailureType.createInternalFailureType(
                MarkovEvaluationType.POINTSOFFAILURE, resourceContainerId, resourceTypeId);
        return getFailureType(comparator);
    }

    /**
     * Retrieves the system-internal network-induced failure type with the given ids.
     * 
     * @param linkingResourceId
     *            the linking resource id
     * @param commLinkResourceTypeId
     *            the communication link resource type id
     * @return the corresponding failure type
     */
    public MarkovFailureType getInternalNetworkFailureType(final String linkingResourceId,
            final String commLinkResourceTypeId) {
        MarkovNetworkInducedFailureType comparator = MarkovNetworkInducedFailureType.createInternalFailureType(
                MarkovEvaluationType.POINTSOFFAILURE, linkingResourceId, commLinkResourceTypeId);
        return getFailureType(comparator);
    }

    /**
     * Retrieves the system-internal software-induced failure type with the given id.
     * 
     * @param softwareFailureId
     *            the software-induced failure type id
     * @param internalActionId
     *            the surrounding internal action id
     * @return the corresponding failure type
     */
    public MarkovFailureType getInternalSoftwareFailureType(final String softwareFailureId,
            final String internalActionId) {
        MarkovSoftwareInducedFailureType comparator = MarkovSoftwareInducedFailureType.createInternalFailureType(
                MarkovEvaluationType.POINTSOFFAILURE, softwareFailureId, internalActionId);
        return getFailureType(comparator);

    }

    /**
     * Retrieves the system-internal passive resource timeout failure type with the given ids.
     * 
     * @param assemblyContextId
     *            the id of the surrounding assembly context
     * @param passiveResourceId
     *            the passive resource id
     * @return the corresponding failure type
     */
    public MarkovFailureType getResourceTimeoutFailureType(final String assemblyContextId,
            final String passiveResourceId) {
        MarkovResourceTimeoutFailureType comparator = MarkovResourceTimeoutFailureType
                .createResourceTimeoutFailureType(MarkovEvaluationType.POINTSOFFAILURE, assemblyContextId,
                        passiveResourceId);
        return getFailureType(comparator);
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
     * Retrieves the total number of failure occurrences (handled and unhandled).
     * 
     * @return the number of all failure occurrences
     */
    public long getTotalFailureCount() {
        return totalFailureCount;
    }

    /**
     * Retrieves the counters for all failure occurrences (handled and unhandled).
     * 
     * @return the counters
     */
    public Map<MarkovFailureType, Integer> getTotalFailureCounters() {
        return totalFailureCounters;
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
     * Retrieves the counters for all unhandled failure occurrences.
     * 
     * @return the counters
     */
    public Map<MarkovFailureType, Integer> getUnhandledFailureCounters() {
        return unhandledFailureCounters;
    }

    /**
     * Increases the counter for handled failures for the defined type.
     * 
     * @param MarkovFailureType
     *            the failure type
     */
    public synchronized void increaseHandledFailureCounter(final MarkovFailureType failureType) {
        Integer count = handledFailureCounters.get(failureType);
        if (count == null) {
            count = 0;
        }
        handledFailureCounters.put(failureType, ++count);
        ++handledFailureCount;
    }

    /**
     * Increases total scenario run counter by one.
     */
    public synchronized void increaseRunCount() {
        ++runCount;
    }

    /**
     * Increases the total failure counter for the defined type.
     * 
     * @param failureType
     *            the failure type
     */
    public synchronized void increaseTotalFailureCounter(final MarkovFailureType failureType) {
        Integer count = totalFailureCounters.get(failureType);
        if (count == null) {
            count = 0;
        }
        totalFailureCounters.put(failureType, ++count);
        ++totalFailureCount;
    }

    /**
     * Inceases the unhandled failure counter for the defined type.
     * 
     * An unhandled failure means also a failed run. Thus, the list of failed runs is also updated
     * with the given session id.
     * 
     * @param failureType
     *            the failure type
     * @param sessionId
     *            the session id of the current run
     */
    public synchronized void increaseUnhandledFailureCounter(final MarkovFailureType failureType, final Long sessionId) {
        Integer count = unhandledFailureCounters.get(failureType);
        if (count == null) {
            count = 0;
        }
        unhandledFailureCounters.put(failureType, ++count);
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
    public void printFailureStatistics(final Logger logger) {
        logger.warn("---- System Failure Statistics: START ----");
        logger.warn("- Total usage scenario runs:        " + runCount);
        logger.warn("- Total failed usage scenario runs: " + failedRuns.size());
        logger.warn("- Total probability of success:     " + (1 - failedRuns.size() / ((double) runCount)));
        for (String failureString : getFailureStringsSorted()) {
            logger.warn(failureString);
        }
        printHandledFailuresStatistics(logger);
        logger.warn("---- System Failure Statistics: END -----");

        // ************* TEMPORORY START **************************
        // try {
        // // Append current results to log file:
        // java.io.FileWriter fstream = new java.io.FileWriter(
        // "C:\\temp\\log.txt", true);
        // java.io.BufferedWriter out = new java.io.BufferedWriter(fstream);
        // out
        // .write(runCount
        // + ";"
        // + failedRuns.size()
        // + ";"
        // + getUnhandledFailureCount(MarkovSoftwareInducedFailureType.class)
        // + ";"
        // + getUnhandledFailureCount(MarkovHardwareInducedFailureType.class)
        // + ";"
        // + getUnhandledFailureCount(MarkovNetworkInducedFailureType.class)
        // + ";");
        // out.newLine();
        // out.close();
        // } catch (Exception e) {
        // System.err.println("Error: " + e.getMessage());
        // }
        // ************* TEMPORORY STOP ***************************
    }

    // /**
    // * TEMPORARY
    // */
    // private long getUnhandledFailureCount(final Class clazz) {
    // int result = 0;
    // for (MarkovFailureType ft : unhandledFailureCounters.keySet()) {
    // if (ft.getClass() == clazz) {
    // result += unhandledFailureCounters.get(ft);
    // }
    // }
    // return result;
    // }

    /**
     * Prints intermediate failure statistics to logger.
     * 
     * @param logger
     *            The logger to write the statistics to
     */
    public synchronized void printRunCount(final Logger logger) {
        if ((runCount % 50000) == 0) {
            printFailureStatistics(logger);
        } else if ((runCount % 10000) == 0) {
            logger.warn("Current usage scenario run count: " + runCount);
        }
    }

    /**
     * Resets all counters.
     */
    public void reset() {
        unhandledFailureCounters = new HashMap<MarkovFailureType, Integer>();
        totalFailureCounters = new HashMap<MarkovFailureType, Integer>();
        handledFailureCounters = new HashMap<MarkovFailureType, Integer>();
        failedRuns = new HashSet<Long>();

        unhandledFailureCount = 0;
        handledFailureCount = 0;
        totalFailureCount = 0;

        runCount = 0;

        // ************* TEMPORORY START **************************
        // try {
        // // Create Log file if not yet existent:
        // java.io.File f = new java.io.File("C:\\temp\\log.txt");
        // if (!f.exists()) {
        // f.createNewFile();
        // java.io.BufferedWriter out = new java.io.BufferedWriter(
        // new java.io.FileWriter(f));
        // out.write("TotalRuns;TotalFailed;SWFailed;HWFailed;NWFailed;");
        // out.newLine();
        // out.close();
        // }
        // } catch (java.io.IOException e) {
        // System.err.println("IO Error: " + e.getMessage());
        // }
        // ************* TEMPORORY STOP ***************************
    }

    /**
     * Sets the failure types that may occur during the simulation.
     * 
     * @param failureTypes
     *            the list of failure types
     */
    public void setFailureTypes(final List<MarkovFailureType> failureTypes) {

        // Build failure type mapping:
        simFailureTypes = new HashMap<MarkovFailureType, Integer>();
        for (int index = 0; index < failureTypes.size(); index++) {
            if (!simFailureTypes.containsKey(failureTypes.get(index))) {
                // Reserve index = 0 for the success case:
                simFailureTypes.put(failureTypes.get(index), index + 1);
            }
        }

        // Build result type mapping:
        executionResultTypes = new HashMap<Integer, String>();
        executionResultTypes.put(0, "Success");
        for (MarkovFailureType failureType : simFailureTypes.keySet()) {
            executionResultTypes.put(simFailureTypes.get(failureType), failureType.getName());
        }
    }

    /**
     * Retrieves the sorted list of recorded failure occurrences.
     * 
     * @return the failure occurrences list
     */
    private TreeSet<String> getFailureStringsSorted() {
        TreeSet<String> result = new TreeSet<String>();
        for (MarkovFailureType failureType : unhandledFailureCounters.keySet()) {
            double count = unhandledFailureCounters.get(failureType);
            result.add("- " + failureType.getName() + ": " + (int) count + " (" + count / runCount + ")");
        }
        return result;
    }

    /**
     * Retrieves the failure type that equals to the given comparator.
     * 
     * @param comparator
     *            the comparator failure type
     * @return the corresponding failure type
     */
    private MarkovFailureType getFailureType(final MarkovFailureType comparator) {
        Iterator<MarkovFailureType> iterator = simFailureTypes.keySet().iterator();
        while (iterator.hasNext()) {
            MarkovFailureType failureType = iterator.next();
            if (failureType.equals(comparator)) {
                return failureType;
            }
        }
        return null;
    }

    /**
     * Prints handling statistics to a logger.
     * 
     * @param logger
     *            The logger to write the statistics to
     */
    private void printHandledFailuresStatistics(final Logger logger) {
        boolean headerPrinted = false;
        for (MarkovFailureType failureType : handledFailureCounters.keySet()) {
            int handledCount = handledFailureCounters.get(failureType);
            Integer totalFailureCount = totalFailureCounters.get(failureType);
            if (totalFailureCount == null) {
                totalFailureCount = 0;
            }
            if (!headerPrinted) {
                logger.warn("---- Handled Failures:");
                headerPrinted = true;
            }
            logger.warn("- " + failureType.getName() + ": Handled " + handledCount + " out of " + totalFailureCount
                    + " (" + ((double) handledCount) / (totalFailureCount) + ")");
        }
    }
}
