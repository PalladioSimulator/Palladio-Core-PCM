package de.uka.ipd.sdq.reliability.core;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.commons.collections15.Bag;
import org.apache.commons.collections15.bag.TreeBag;
import org.apache.log4j.Logger;
import org.palladiosimulator.commons.designpatterns.AbstractObservable;
import org.palladiosimulator.metricspec.Identifier;
import org.palladiosimulator.metricspec.util.builder.IdentifierBuilder;
import org.palladiosimulator.probeframework.probes.EventProbe;

import de.uka.ipd.sdq.reliability.core.probe.TakeExecutionResultProbe;

/**
 * Singleton class that is used for counting simulated failures and printing statistics.
 */
public class FailureStatistics extends AbstractObservable<IFailureStatisticsListener> {

    /**
     * Stores the session ids of all failed usage scenario runs.
     * 
     * This is required because with forked behaviours, multiple failures can occur in one usage
     * scenario run. If so, the counter for failed runs must not be incremented for the second or
     * any further failure within the same run.
     */
    private final HashSet<Long> failedRuns = new HashSet<Long>();

    /**
     * Counts usage scenario runs since last reset.
     */
    private long runCount = 0;

    /**
     * Maps failure types to numeric IDs.
     */
    private static Map<MarkovFailureType, Identifier> simFailureTypes;

    private final TakeExecutionResultProbe resultProbe;

    public enum FailureType {
        HANDLED, UNHANDLED, TOTAL
    }

    private final Map<FailureType, Bag<MarkovFailureType>> failureCounter = new HashMap<FailureStatistics.FailureType, Bag<MarkovFailureType>>();

    private final Identifier successIdentifier;

    /**
     * The constructor.
     */
    @SuppressWarnings("unchecked")
    public FailureStatistics() {
        super();
        for (final FailureType t : FailureType.values()) {
            failureCounter.put(t, new TreeBag<MarkovFailureType>());
        }
        this.successIdentifier = IdentifierBuilder.newIdentifierBuilder().literal("Success").build();
        if (simFailureTypes == null) {
            simFailureTypes = Collections.EMPTY_MAP;
        }
        resultProbe = new TakeExecutionResultProbe(this, simFailureTypes, successIdentifier);
    }

    public EventProbe<FailureStatistics> getExecutionResultProbe() {
        return resultProbe;
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
    public void increaseUnhandledFailureCounter(final MarkovFailureType failureType, final Long sessionId) {
        increaseFailureCounter(FailureType.UNHANDLED, failureType);
        if (!failedRuns.contains(sessionId)) {
            failedRuns.add(sessionId);
        }
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
    public Identifier getExecutionResultId(final MarkovFailureType failureType) {
        if (failureType == null) {
            return successIdentifier;
        }
        return simFailureTypes.get(failureType);
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
        final MarkovHardwareInducedFailureType comparator = MarkovHardwareInducedFailureType.createExternalFailureType(
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
        final MarkovNetworkInducedFailureType comparator = MarkovNetworkInducedFailureType.createExternalFailureType(
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
        final MarkovSoftwareInducedFailureType comparator = MarkovSoftwareInducedFailureType.createExternalFailureType(
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
    public MarkovFailureType getFailureType(final String failureTypeId) {
        final Iterator<MarkovFailureType> iterator = simFailureTypes.keySet().iterator();
        while (iterator.hasNext()) {
            final MarkovFailureType failureType = iterator.next();
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
    public Identifier getFailureTypeIndex(final MarkovFailureType failureType) {
        return simFailureTypes.get(failureType);
    }

    /**
     * Retrieves the total number of handled failure occurrences.
     * 
     * @return The number of handled failure occurrences
     */
    public long getFailureCount(final FailureType failureType) {
        return getFailureCounters(failureType).size();
    }

    /**
     * Retrieves the counters for all handled failure occurrences.
     * 
     * @return the counters
     */
    public Bag<MarkovFailureType> getFailureCounters(final FailureType failureType) {
        return failureCounter.get(failureType);
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
        final MarkovHardwareInducedFailureType comparator = MarkovHardwareInducedFailureType.createInternalFailureType(
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
        final MarkovNetworkInducedFailureType comparator = MarkovNetworkInducedFailureType.createInternalFailureType(
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
        final MarkovSoftwareInducedFailureType comparator = MarkovSoftwareInducedFailureType.createInternalFailureType(
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
        final MarkovResourceTimeoutFailureType comparator = MarkovResourceTimeoutFailureType
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
     * Increases the counter for handled failures for the defined type.
     * 
     * @param MarkovFailureType
     *            the failure type
     */
    public void increaseFailureCounter(final FailureType failureKind, final MarkovFailureType failureType) {
        failureCounter.get(failureKind).add(failureType);
        this.getEventDispatcher().executionResultRecorder(failureType);
    }

    public void recordSuccess() {
        this.getEventDispatcher().executionResultRecorder(null);
    }

    /**
     * Increases total scenario run counter by one.
     */
    public void increaseRunCount() {
        ++runCount;
    }

    /**
     * Prints failure and handling statistics to a logger.
     * 
     * @param logger
     *            The logger to write the statistics to
     * @param simulationTime
     */
    public void printFailureStatistics(final Logger logger, final double simulationTime) {
        logger.warn("---- System Failure Statistics: START ----");
        logger.warn("- Total usage scenario runs:            " + runCount);
        logger.warn("- Total failed usage scenario runs:     " + failedRuns.size());
        logger.warn("- Total simulated time units:           " + simulationTime);
        logger.warn("- Total probability of success:         " + (1 - failedRuns.size() / ((double) runCount)));
        logger.warn("- Failure rate (failures per simulated time unit): " + (failedRuns.size() / simulationTime));
        logger.warn("- Mean time between failure:            " + (simulationTime / failedRuns.size()));

        logger.warn("- Total number of faults:               " + getFailureCount(FailureType.TOTAL));
        logger.warn("- Total probability of fault:           "
                + (getFailureCount(FailureType.TOTAL) / (double) runCount));
        logger.warn("- Total probability of no fault:        "
                + (1 - (getFailureCount(FailureType.TOTAL) / (double) runCount)));
        logger.warn("- Fault rate (recovered and non-recovered, faults per simulated time unit): "
                + (getFailureCount(FailureType.TOTAL) / simulationTime));
        logger.warn("- Mean time between faults (recovered and non-recovered): "
                + (simulationTime / getFailureCount(FailureType.TOTAL)));

        for (final String failureString : getFailureStringsSorted(simulationTime)) {
            logger.warn(failureString);
        }
        printHandledFailuresStatistics(logger, simulationTime);
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
     * @param simulationTime
     */
    public void printRunCount(final Logger logger, final double simulationTime) {
        if ((runCount % 50000) == 0) {
            printFailureStatistics(logger, simulationTime);
        } else if ((runCount % 10000) == 0) {
            logger.warn("Current usage scenario run count: " + runCount);
        }
    }

    /**
     * FIXME should not be static Sets the failure types that may occur during the simulation.
     * 
     * @param failureTypes
     *            the list of failure types
     */
    public static void setFailureTypes(final List<MarkovFailureType> failureTypes) {

        // Build failure type mapping:
        simFailureTypes = new HashMap<MarkovFailureType, Identifier>();
        for (final MarkovFailureType failureType : failureTypes) {
            final Identifier identifier = IdentifierBuilder.newIdentifierBuilder().literal(failureType.getName())
                    .build();
            simFailureTypes.put(failureType, identifier);
        }
    }

    /**
     * Retrieves the sorted list of recorded failure occurrences.
     * 
     * @param simulationTime
     * 
     * @return the failure occurrences list
     */
    private TreeSet<String> getFailureStringsSorted(final double simulationTime) {
        final TreeSet<String> result = new TreeSet<String>();
        for (final MarkovFailureType failureType : failureCounter.get(FailureType.UNHANDLED)) {
            final double count = failureCounter.get(FailureType.UNHANDLED).getCount(failureType);
            result.add("-- " + failureType.getName() + ": " + (int) count + " (" + count / runCount + ")");
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
        final Iterator<MarkovFailureType> iterator = simFailureTypes.keySet().iterator();
        while (iterator.hasNext()) {
            final MarkovFailureType failureType = iterator.next();
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
     * @param simulationTime
     *            The overall simulated time to calculate rates
     */
    public void printHandledFailuresStatistics(final Logger logger, final double simulationTime) {
        if (logger.isDebugEnabled()) {
            boolean headerPrinted = false;

            final Map<String, SoftwareFailureStatistics> softwareFailureStatisticsMap = new HashMap<String, SoftwareFailureStatistics>();

            for (final MarkovFailureType failureType : failureCounter.get(FailureType.HANDLED)) {
                final int handledCount = failureCounter.get(FailureType.HANDLED).getCount(failureType);
                Integer totalFailureCount = failureCounter.get(FailureType.TOTAL).getCount(failureType);
                if (totalFailureCount == null) {
                    totalFailureCount = 0;
                }
                if (!headerPrinted) {
                    logger.debug("---- Handled Failures:");
                    headerPrinted = true;
                }
                logger.debug("- " + failureType.getName() + ": Handled " + handledCount + " out of "
                        + totalFailureCount + " (" + ((double) handledCount) / (totalFailureCount) + ")");
                logger.debug("  Fault rate (faults per time unit):                 "
                        + (totalFailureCount / simulationTime));
                logger.debug("  Mean time to fault (time units):                   "
                        + (simulationTime / totalFailureCount));
                logger.debug("  Non-recoverable fault rate (failures per time unit): "
                        + ((totalFailureCount - handledCount) / simulationTime));
                logger.debug("  Mean time to non-recoverable failure (time units):   "
                        + (simulationTime / (totalFailureCount - handledCount)));

                // aggregate software failures by type
                if (failureType instanceof MarkovSoftwareInducedFailureType) {
                    final MarkovSoftwareInducedFailureType swFailureType = (MarkovSoftwareInducedFailureType) failureType;

                    SoftwareFailureStatistics softwareFailureStatistics = softwareFailureStatisticsMap
                            .get(swFailureType.getSoftwareFailureId());
                    if (softwareFailureStatistics == null) {
                        softwareFailureStatistics = new SoftwareFailureStatistics(swFailureType.getSoftwareFailureId(),
                                swFailureType.getSoftwareFailureName());
                        softwareFailureStatisticsMap.put(swFailureType.getSoftwareFailureId(),
                                softwareFailureStatistics);
                    }
                    softwareFailureStatistics.addTotalFailureCount(totalFailureCount);
                    softwareFailureStatistics.addHandledCount(handledCount);

                }
            }

            logger.debug("\n---- Handled failures aggregated by software failure type:");
            for (final SoftwareFailureStatistics softwareFailureStatistics : softwareFailureStatisticsMap.values()) {

                logger.debug("- " + softwareFailureStatistics.getName() + "(" + softwareFailureStatistics.getId()
                        + ") : Handled " + softwareFailureStatistics.getHandledCount() + " out of "
                        + softwareFailureStatistics.getTotalFailureCount() + " ("
                        + ((double) softwareFailureStatistics.getHandledCount())
                        / (softwareFailureStatistics.getTotalFailureCount()) + ")");
                logger.debug("  Fault rate (faults per time unit):                 "
                        + (softwareFailureStatistics.getTotalFailureCount() / simulationTime));
                logger.debug("  Mean time to fault (time units):                   "
                        + (simulationTime / softwareFailureStatistics.getTotalFailureCount()));
                logger.debug("  Non-recoverable fault rate (failures per time unit): "
                        + ((softwareFailureStatistics.getTotalFailureCount() - softwareFailureStatistics
                                .getHandledCount()) / simulationTime));
                logger.debug("  Mean time to non-recoverable failure (time units):   "
                        + (simulationTime / (softwareFailureStatistics.getTotalFailureCount() - softwareFailureStatistics
                                .getHandledCount())));
            }
        }

    }
}

class SoftwareFailureStatistics {
    private final String id;
    private final String name;
    private int totalFailureCount = 0;
    private int handledCount = 0;

    public String getId() {
        return id;
    }

    public int getTotalFailureCount() {
        return totalFailureCount;
    }

    public int getHandledCount() {
        return handledCount;
    }

    public SoftwareFailureStatistics(final String softwareFailureId, final String softwareFailureName) {
        this.id = softwareFailureId;
        this.name = softwareFailureName;
    }

    public String getName() {
        return this.name;
    }

    public void addHandledCount(final int handledCount2) {
        this.handledCount += handledCount2;

    }

    public void addTotalFailureCount(final Integer totalFailureCount2) {
        this.totalFailureCount += totalFailureCount2;

    }

}
