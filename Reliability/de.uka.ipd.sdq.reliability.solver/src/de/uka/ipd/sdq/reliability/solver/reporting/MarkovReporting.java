package de.uka.ipd.sdq.reliability.solver.reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.pcmsolver.runconfig.PCMSolverWorkflowRunConfiguration;
import de.uka.ipd.sdq.reliability.core.MarkovEvaluationType;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovHardwareInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovNetworkInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovResultApproximation;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovTransformationResult;

/**
 * Class used for aggregation and output of success/failure probabilities that were calculated
 * during a reliability analysis.
 * 
 * @author Daniel Patejdl
 * 
 */
public class MarkovReporting {
    /**
     * Configuration properties for the reliability solver workflow.
     */
    PCMSolverWorkflowRunConfiguration configuration;

    /**
     * Will store the overall failure probabilities of entities (components' internal actions, their
     * services and service operations, external services and their operations).
     */
    List<ImpactAnalysisFailureProbabilityAggregation> failureProbabilityAggregations;

    /**
     * A list of MarkovReportItem instances, which are generated as a result of all Markov
     * transformation results. They will be used for later output to the user.
     */
    List<MarkovReportItem> markovReportItems;

    /**
     * List of aggregated results of a PCM2MarkovTransformation
     */
    private List<MarkovTransformationResult> markovResults;

    /**
     * Creates a new MarkovReporting instance that is used for result aggregation according to the
     * given Markov transformation results.
     * 
     * @param markovResults
     *            the Markov transformation results
     * @param config
     *            the configuration properties for the reliability solver workflow
     */
    public MarkovReporting(List<MarkovTransformationResult> markovResults,
            PCMSolverWorkflowRunConfiguration configuration) {
        this.markovResults = markovResults;
        this.configuration = configuration;
        // failureProbabilityAggregations = new
        // ArrayList<ImpactAnalysisFailureProbabilityAggregation>();
        markovReportItems = new ArrayList<MarkovReportItem>();

        createMarkovReportItems();
    }

    /**
     * Calculates all components' internal action failure probabilities for later output.
     */
    private void calculateComponentsInternalActionFailureProbabilities(
            Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
        for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
            if (!failureType.isSystemExternal()) { // only consider (internal)
                                                   // components
                if (failureType instanceof MarkovSoftwareInducedFailureType) {
                    MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;

                    /*
                     * If the component ID is not in our data structure, we will add a new entry to
                     * it. If the component ID is already in the data structure, we will not add it
                     * again, but we will add to (the existing failure probability) the current
                     * failure type's probability.
                     */
                    boolean foundEntry = false;
                    List<String> identifiers = new ArrayList<String>(1);
                    identifiers.add(softwareInducedFailureType.getComponentId());
                    List<String> nameParts = new ArrayList<String>(1);
                    nameParts.add(softwareInducedFailureType.getComponentName());
                    for (ImpactAnalysisFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
                        if (aggregation.compareToIdentifier(ImpactAnalysisFailureType.COMPONENTS_INTERNAL_ACTIONS,
                                identifiers)) {
                            // this component ID is already in our data
                            // structure, therefore we do not
                            // add a new entry, but update the existing one
                            // accordingly
                            aggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities.get(failureType));
                            foundEntry = true;
                            break; // found and updated the entry, so we are
                                   // done
                        }
                    }
                    if (!foundEntry) {
                        // we did not find a fitting entry, so we add a new one
                        // and set its values accordingly
                        failureProbabilityAggregations.add(new ImpactAnalysisFailureProbabilityAggregation(
                                ImpactAnalysisFailureType.COMPONENTS_INTERNAL_ACTIONS, identifiers, nameParts,
                                cumulatedFailureTypeProbabilities.get(failureType)));
                    }
                }
            }
        }
    }

    /**
     * Calculates all components' service (interface) failure probabilities for later output.
     */
    private void calculateComponentsServiceFailureProbabilities(
            Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
        for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
            if (!failureType.isSystemExternal()) { // only consider (internal)
                // components
                if (failureType instanceof MarkovSoftwareInducedFailureType) {
                    MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;
                    boolean foundEntry = false;
                    List<String> identifiers = new ArrayList<String>(2);
                    identifiers.add(softwareInducedFailureType.getComponentId());
                    identifiers.add(softwareInducedFailureType.getInterfaceId());
                    List<String> nameParts = new ArrayList<String>(2);
                    nameParts.add(softwareInducedFailureType.getComponentName());
                    nameParts.add(softwareInducedFailureType.getInterfaceName());
                    for (ImpactAnalysisFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
                        if (aggregation.compareToIdentifier(ImpactAnalysisFailureType.COMPONENTS_SERVICES, identifiers)) {
                            // this entity is already in our data structure,
                            // therefore we do not
                            // add a new entry, but update the existing one
                            // accordingly
                            aggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities.get(failureType));
                            foundEntry = true;
                            break; // found and updated the entry, so we are
                            // done
                        }
                    }
                    if (!foundEntry) {
                        // we did not find a fitting entry, so we add a new one
                        // and set its values
                        // accordingly
                        failureProbabilityAggregations.add(new ImpactAnalysisFailureProbabilityAggregation(
                                ImpactAnalysisFailureType.COMPONENTS_SERVICES, identifiers, nameParts,
                                cumulatedFailureTypeProbabilities.get(failureType)));
                    }
                }
            }
        }
    }

    /**
     * Calculates all components' service operation (signature) failure probabilities for later
     * output.
     */
    private void calculateComponentsServiceOperationFailureProbabilities(
            Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
        for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
            if (!failureType.isSystemExternal()) { // only consider (internal)
                // components
                if (failureType instanceof MarkovSoftwareInducedFailureType) {
                    MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;
                    boolean foundEntry = false;
                    List<String> identifiers = new ArrayList<String>(3);
                    identifiers.add(softwareInducedFailureType.getComponentId());
                    identifiers.add(softwareInducedFailureType.getInterfaceId());
                    identifiers.add(softwareInducedFailureType.getSignatureId());
                    List<String> nameParts = new ArrayList<String>(3);
                    nameParts.add(softwareInducedFailureType.getComponentName());
                    nameParts.add(softwareInducedFailureType.getInterfaceName());
                    nameParts.add(softwareInducedFailureType.getSignatureName());
                    for (ImpactAnalysisFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
                        if (aggregation.compareToIdentifier(ImpactAnalysisFailureType.COMPONENTS_SERVICE_OPERATIONS,
                                identifiers)) {
                            // this entity is already in our data structure,
                            // therefore we do not
                            // add a new entry, but update the existing one
                            // accordingly
                            aggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities.get(failureType));
                            foundEntry = true;
                            break; // found and updated the entry, so we are
                            // done
                        }
                    }
                    if (!foundEntry) {
                        // we did not find a fitting entry, so we add a new one
                        // and set its values
                        // accordingly
                        failureProbabilityAggregations.add(new ImpactAnalysisFailureProbabilityAggregation(
                                ImpactAnalysisFailureType.COMPONENTS_SERVICE_OPERATIONS, identifiers, nameParts,
                                cumulatedFailureTypeProbabilities.get(failureType)));
                    }
                }
            }
        }
    }

    /**
     * Calculates all external service (role and interface) failure probabilities for later output.
     */
    private void calculateExternalServiceFailureProbabilities(
            Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
        for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
            if (failureType.isSystemExternal()) { // only consider external
                // services
                boolean foundEntry = false;
                List<String> identifiers = new ArrayList<String>(2);
                identifiers.add(failureType.getRoleId());
                identifiers.add(failureType.getInterfaceId());
                List<String> nameParts = new ArrayList<String>(2);
                nameParts.add(failureType.getRoleName());
                nameParts.add(failureType.getInterfaceName());
                for (ImpactAnalysisFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
                    if (aggregation.compareToIdentifier(ImpactAnalysisFailureType.EXTERNAL_SERVICES, identifiers)) {
                        // this entity is already in our data structure,
                        // therefore we do not
                        // add a new entry, but update the existing one
                        // accordingly
                        aggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities.get(failureType));
                        foundEntry = true;
                        break; // found and updated the entry, so we are done
                    }
                }
                if (!foundEntry) {
                    // we did not find a fitting entry, so we add a new one and
                    // set its values
                    // accordingly
                    failureProbabilityAggregations.add(new ImpactAnalysisFailureProbabilityAggregation(
                            ImpactAnalysisFailureType.EXTERNAL_SERVICES, identifiers, nameParts,
                            cumulatedFailureTypeProbabilities.get(failureType)));
                }
            }
        }
    }

    /**
     * Calculates all external service operation (signature) failure probabilities for later output.
     */
    private void calculateExternalServiceOperationFailureProbabilities(
            Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
        for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
            if (failureType.isSystemExternal()) { // only consider external
                // services
                boolean foundEntry = false;
                List<String> identifiers = new ArrayList<String>(3);
                identifiers.add(failureType.getRoleId());
                identifiers.add(failureType.getInterfaceId());
                identifiers.add(failureType.getSignatureId());
                List<String> nameParts = new ArrayList<String>(3);
                nameParts.add(failureType.getRoleName());
                nameParts.add(failureType.getInterfaceName());
                nameParts.add(failureType.getSignatureName());
                for (ImpactAnalysisFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
                    if (aggregation.compareToIdentifier(ImpactAnalysisFailureType.EXTERNAL_SERVICE_OPERATIONS,
                            identifiers)) {
                        // this entity is already in our data structure,
                        // therefore we do not
                        // add a new entry, but update the existing one
                        // accordingly
                        aggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities.get(failureType));
                        foundEntry = true;
                        break; // found and updated the entry, so we are done
                    }
                }
                if (!foundEntry) {
                    // we did not find a fitting entry, so we add a new one and
                    // set its values
                    // accordingly
                    failureProbabilityAggregations.add(new ImpactAnalysisFailureProbabilityAggregation(
                            ImpactAnalysisFailureType.EXTERNAL_SERVICE_OPERATIONS, identifiers, nameParts,
                            cumulatedFailureTypeProbabilities.get(failureType)));
                }
            }
        }
    }

    private void createClassesFailureAnalysisTable(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities,
            double cumulatedPhysicalStateProbability, boolean doApproximate, MarkovReportItem markovReportItem) {
        double failureProbability;
        MarkovReportingTable failureCategoryTable = new MarkovReportingTable("Failure mode categories");
        List<String> failureCategoryTableHeaderRow = new ArrayList<String>(2);
        failureCategoryTableHeaderRow.add("Category");
        failureCategoryTableHeaderRow.add("Failure Mode Probability");
        failureCategoryTable.setHeaderRow(failureCategoryTableHeaderRow);

        // determine failure probabilities
        ClassesFailureProbabilityAggregation softwareInducedFailureAggregation = new ClassesFailureProbabilityAggregation(
                FailureAnalysisFailureType.SOFTWARE_INDUCED);
        ClassesFailureProbabilityAggregation hardwareInducedFailureAggregation = new ClassesFailureProbabilityAggregation(
                FailureAnalysisFailureType.HARDWARE_INDUCED);
        ClassesFailureProbabilityAggregation networkInducedFailureAggregation = new ClassesFailureProbabilityAggregation(
                FailureAnalysisFailureType.NETWORK_INDUCED);
        for (MarkovFailureType type : cumulatedFailureTypeProbabilities.keySet()) {
            if (!type.isSystemExternal()) { // only consider internal failures
                if (type instanceof MarkovSoftwareInducedFailureType) {
                    softwareInducedFailureAggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities
                            .get(type));
                } else if (type instanceof MarkovHardwareInducedFailureType) {
                    hardwareInducedFailureAggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities
                            .get(type));
                } else if (type instanceof MarkovNetworkInducedFailureType) {
                    networkInducedFailureAggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities
                            .get(type));
                }
            }
        }

        // create rows of table
        List<String> row = new ArrayList<String>(failureCategoryTableHeaderRow.size());
        row.add("Software-induced failure");
        failureProbability = softwareInducedFailureAggregation.getFailureProbability();
        row.add(String.valueOf(doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability
                + 1 - cumulatedPhysicalStateProbability) : getFormattedProbabilityAsString(failureProbability)));
        if (failureProbability > 0.0) {
            failureCategoryTable.addRow(row);
        }

        row = new ArrayList<String>(failureCategoryTableHeaderRow.size());
        row.add("Hardware-induced failure");
        failureProbability = hardwareInducedFailureAggregation.getFailureProbability();
        row.add(String.valueOf(doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability
                + 1 - cumulatedPhysicalStateProbability) : getFormattedProbabilityAsString(failureProbability)));
        if (failureProbability > 0.0) {
            failureCategoryTable.addRow(row);
        }

        row = new ArrayList<String>(failureCategoryTableHeaderRow.size());
        row.add("Network-induced failure");
        failureProbability = networkInducedFailureAggregation.getFailureProbability();
        row.add(String.valueOf(doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability
                + 1 - cumulatedPhysicalStateProbability) : getFormattedProbabilityAsString(failureProbability)));
        if (failureProbability > 0.0) {
            failureCategoryTable.addRow(row);
        }

        // finally, add table to report item if it contains at least one row
        if (failureCategoryTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(failureCategoryTable);
        }
    }

    private void createFailureAnalysisTables(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities,
            double cumulatedPhysicalStateProbability, boolean doApproximate, MarkovReportItem markovReportItem,
            MarkovEvaluationType mode) {
        switch (mode) {
        case SINGLE:
            // do nothing
            break;
        case CLASSES: // failure categories
            createClassesFailureAnalysisTable(cumulatedFailureTypeProbabilities, cumulatedPhysicalStateProbability,
                    doApproximate, markovReportItem);
            break;
        case TYPES:
            createTypesFailureAnalysisTable(cumulatedFailureTypeProbabilities, cumulatedPhysicalStateProbability,
                    doApproximate, markovReportItem);
            break;
        case POINTSOFFAILURE:
            createPointsOfFailureAnalysisTable(cumulatedFailureTypeProbabilities, cumulatedPhysicalStateProbability,
                    doApproximate, markovReportItem);
            break;
        default:
            break;
        }
    }

    private void createImpactAnalysisTables(double cumulatedPhysicalStateProbability, boolean doApproximate,
            MarkovReportItem markovReportItem) {
        MarkovReportingTable componentsInternalActionFailureProbabilitiesTable = new MarkovReportingTable(
                "Component failure impacts");
        List<String> componentsInternalActionFailureProbabilitiesTableHeaderRow = new ArrayList<String>(3);
        componentsInternalActionFailureProbabilitiesTableHeaderRow.add("Component");
        componentsInternalActionFailureProbabilitiesTableHeaderRow.add("Aggregated Failure Mode Probability");
        componentsInternalActionFailureProbabilitiesTable
                .setHeaderRow(componentsInternalActionFailureProbabilitiesTableHeaderRow);
        // componentsServiceFailureProbabilities
        MarkovReportingTable componentsServiceFailureProbabilitiesTable = new MarkovReportingTable(
                "Component service failure impacts");
        List<String> componentsServiceFailureProbabilitiesTableHeaderRow = new ArrayList<String>(3);
        componentsServiceFailureProbabilitiesTableHeaderRow.add("Component");
        componentsServiceFailureProbabilitiesTableHeaderRow.add("Interface");
        componentsServiceFailureProbabilitiesTableHeaderRow.add("Aggregated Failure Mode Probability");
        componentsServiceFailureProbabilitiesTable.setHeaderRow(componentsServiceFailureProbabilitiesTableHeaderRow);
        // componentsServiceOperationFailureProbabilities
        MarkovReportingTable componentsServiceOperationFailureProbabilitiesTable = new MarkovReportingTable(
                "Component operation failure impacts");
        List<String> componentsServiceOperationFailureProbabilitiesTableHeaderRow = new ArrayList<String>(4);
        componentsServiceOperationFailureProbabilitiesTableHeaderRow.add("Component");
        componentsServiceOperationFailureProbabilitiesTableHeaderRow.add("Interface");
        componentsServiceOperationFailureProbabilitiesTableHeaderRow.add("Signature");
        componentsServiceOperationFailureProbabilitiesTableHeaderRow.add("Aggregated Failure Mode Probability");
        componentsServiceOperationFailureProbabilitiesTable
                .setHeaderRow(componentsServiceOperationFailureProbabilitiesTableHeaderRow);
        // externalServiceFailureProbabilities
        MarkovReportingTable externalServiceFailureProbabilitiesTable = new MarkovReportingTable(
                "External service failure impacts");
        List<String> externalServiceFailureProbabilitiesTableHeaderRow = new ArrayList<String>(4);
        externalServiceFailureProbabilitiesTableHeaderRow.add("System-required Role");
        externalServiceFailureProbabilitiesTableHeaderRow.add("Interface");
        externalServiceFailureProbabilitiesTableHeaderRow.add("Aggregated Failure Mode Probability");
        externalServiceFailureProbabilitiesTable.setHeaderRow(externalServiceFailureProbabilitiesTableHeaderRow);
        // externalServiceOperationFailureProbabilities
        MarkovReportingTable externalServiceOperationFailureProbabilitiesTable = new MarkovReportingTable(
                "External operation failure impacts");
        List<String> externalServiceOperationFailureProbabilitiesTableHeaderRow = new ArrayList<String>(4);
        externalServiceOperationFailureProbabilitiesTableHeaderRow.add("System-required Role");
        externalServiceOperationFailureProbabilitiesTableHeaderRow.add("Interface");
        externalServiceOperationFailureProbabilitiesTableHeaderRow.add("Signature");
        externalServiceOperationFailureProbabilitiesTableHeaderRow.add("Aggregated Failure Mode Probability");
        externalServiceOperationFailureProbabilitiesTable
                .setHeaderRow(externalServiceOperationFailureProbabilitiesTableHeaderRow);

        /*
         * Create a table row for each failure probability aggregation, and add this row to the
         * according impact analysis table.
         */
        for (ImpactAnalysisFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
            double failureProbability = aggregation.getFailureProbability();
            if (!(failureProbability > 0.0)) {
                continue;
            }
            switch (aggregation.getType()) {
            case COMPONENTS_INTERNAL_ACTIONS:
                List<String> componentsInternalActionFailureProbabilitiesTableRow = new ArrayList<String>(
                        componentsInternalActionFailureProbabilitiesTableHeaderRow.size()); // create
                                                                                            // new
                                                                                            // row
                for (String entityNamePart : aggregation.getEntityNameParts()) { // add
                                                                                 // name
                                                                                 // parts
                                                                                 // to
                                                                                 // row;
                                                                                 // one
                                                                                 // column
                                                                                 // per
                                                                                 // name
                                                                                 // part
                    componentsInternalActionFailureProbabilitiesTableRow.add(entityNamePart);
                }
                componentsInternalActionFailureProbabilitiesTableRow
                        .add(doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability + 1
                                - cumulatedPhysicalStateProbability)
                                : getFormattedProbabilityAsString(failureProbability)); // also
                                                                                        // add
                                                                                        // failure
                                                                                        // probability
                                                                                        // to
                                                                                        // this
                                                                                        // row
                componentsInternalActionFailureProbabilitiesTable
                        .addRow(componentsInternalActionFailureProbabilitiesTableRow); // insert
                                                                                       // row
                                                                                       // into
                                                                                       // table
                break;
            case COMPONENTS_SERVICES:
                List<String> componentsServicesFailureProbabilitiesTableRow = new ArrayList<String>(
                        componentsServiceFailureProbabilitiesTableHeaderRow.size()); // create new
                                                                                     // row
                for (String entityNamePart : aggregation.getEntityNameParts()) { // add
                                                                                 // name
                                                                                 // parts
                                                                                 // to
                                                                                 // row;
                                                                                 // one
                                                                                 // column
                                                                                 // per
                                                                                 // name
                                                                                 // part
                    componentsServicesFailureProbabilitiesTableRow.add(entityNamePart);
                }
                componentsServicesFailureProbabilitiesTableRow.add(doApproximate ? getFormattedProbabilityAsString(
                        failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
                        : getFormattedProbabilityAsString(failureProbability)); // also
                                                                                // add
                                                                                // failure
                                                                                // probability
                                                                                // to
                                                                                // this
                                                                                // row
                componentsServiceFailureProbabilitiesTable.addRow(componentsServicesFailureProbabilitiesTableRow); // insert
                                                                                                                   // row
                                                                                                                   // into
                                                                                                                   // table
                break;
            case COMPONENTS_SERVICE_OPERATIONS:
                List<String> componentsServiceOperationFailureProbabilitiesTableRow = new ArrayList<String>(
                        componentsServiceOperationFailureProbabilitiesTableHeaderRow.size()); // create
                                                                                              // new
                                                                                              // row
                for (String entityNamePart : aggregation.getEntityNameParts()) { // add
                                                                                 // name
                                                                                 // parts
                                                                                 // to
                                                                                 // row;
                                                                                 // one
                                                                                 // column
                                                                                 // per
                                                                                 // name
                                                                                 // part
                    componentsServiceOperationFailureProbabilitiesTableRow.add(entityNamePart);
                }
                componentsServiceOperationFailureProbabilitiesTableRow
                        .add(doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability + 1
                                - cumulatedPhysicalStateProbability)
                                : getFormattedProbabilityAsString(failureProbability)); // also
                                                                                        // add
                                                                                        // failure
                                                                                        // probability
                                                                                        // to
                                                                                        // this
                                                                                        // row
                componentsServiceOperationFailureProbabilitiesTable
                        .addRow(componentsServiceOperationFailureProbabilitiesTableRow); // insert
                                                                                         // row
                                                                                         // into
                                                                                         // table
                break;
            case EXTERNAL_SERVICES:
                List<String> externalServiceFailureProbabilitiesTableRow = new ArrayList<String>(
                        externalServiceFailureProbabilitiesTableHeaderRow.size()); // create new row
                for (String entityNamePart : aggregation.getEntityNameParts()) { // add
                                                                                 // name
                                                                                 // parts
                                                                                 // to
                                                                                 // row;
                                                                                 // one
                                                                                 // column
                                                                                 // per
                                                                                 // name
                                                                                 // part
                    externalServiceFailureProbabilitiesTableRow.add(entityNamePart);
                }
                externalServiceFailureProbabilitiesTableRow.add(doApproximate ? getFormattedProbabilityAsString(
                        failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
                        : getFormattedProbabilityAsString(failureProbability)); // also
                                                                                // add
                                                                                // failure
                                                                                // probability
                                                                                // to
                                                                                // this
                                                                                // row
                externalServiceFailureProbabilitiesTable.addRow(externalServiceFailureProbabilitiesTableRow); // insert
                                                                                                              // row
                                                                                                              // into
                                                                                                              // table
                break;
            case EXTERNAL_SERVICE_OPERATIONS:
                List<String> externalServiceOperationFailureProbabilitiesTableRow = new ArrayList<String>(
                        externalServiceFailureProbabilitiesTableHeaderRow.size()); // create new row
                for (String entityNamePart : aggregation.getEntityNameParts()) { // add
                                                                                 // name
                                                                                 // parts
                                                                                 // to
                                                                                 // row;
                                                                                 // one
                                                                                 // column
                                                                                 // per
                                                                                 // name
                                                                                 // part
                    externalServiceOperationFailureProbabilitiesTableRow.add(entityNamePart);
                }
                externalServiceOperationFailureProbabilitiesTableRow
                        .add(doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability + 1
                                - cumulatedPhysicalStateProbability)
                                : getFormattedProbabilityAsString(failureProbability)); // also
                                                                                        // add
                                                                                        // failure
                                                                                        // probability
                                                                                        // to
                                                                                        // this
                                                                                        // row
                externalServiceOperationFailureProbabilitiesTable
                        .addRow(externalServiceOperationFailureProbabilitiesTableRow); // insert
                                                                                       // row
                                                                                       // into
                                                                                       // table
                break;
            default:
                break;
            }
        }

        /*
         * Finally, add the tables to our report item if they contain at least one row (per table).
         */
        if (componentsInternalActionFailureProbabilitiesTable.getRows().size() > 0) {
            markovReportItem.addImpactAnalysisTable(componentsInternalActionFailureProbabilitiesTable);
        }
        if (componentsServiceFailureProbabilitiesTable.getRows().size() > 0) {
            markovReportItem.addImpactAnalysisTable(componentsServiceFailureProbabilitiesTable);
        }
        if (componentsServiceOperationFailureProbabilitiesTable.getRows().size() > 0) {
            markovReportItem.addImpactAnalysisTable(componentsServiceOperationFailureProbabilitiesTable);
        }
        if (externalServiceFailureProbabilitiesTable.getRows().size() > 0) {
            markovReportItem.addImpactAnalysisTable(externalServiceFailureProbabilitiesTable);
        }
        if (externalServiceOperationFailureProbabilitiesTable.getRows().size() > 0) {
            markovReportItem.addImpactAnalysisTable(externalServiceOperationFailureProbabilitiesTable);
        }
    }

    /*
     * Consider all Markov transformation results: For each such result we will calculate the
     * probabilities of interest, and then enclose them in a MarkovResultItem for further
     * processing.
     */
    private void createMarkovReportItems() {
        Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities = null;
        double cumulatedPhysicalStateProbability = 0;
        boolean doApproximate = false;
        double cumulatedSuccessProbability = -1.0; // error value

        MarkovEvaluationType mode = MarkovEvaluationType.valueOf(configuration.getMarkovEvaluationMode());

        /*
         * Create table-style output format.
         */
        UsageScenario scenario = null;
        MarkovReportItem markovReportItem = null;
        for (MarkovTransformationResult markovResult : markovResults) {
            scenario = markovResult.getScenario();
            cumulatedFailureTypeProbabilities = markovResult.getCumulatedFailureTypeProbabilities();
            cumulatedPhysicalStateProbability = markovResult.getCumulatedPhysicalStateProbability();
            cumulatedSuccessProbability = markovResult.getSuccessProbability();
            doApproximate = markovResult.isDoApproximate();

            /*
             * Create a new Markov report item using the data of this scenario.
             */
            if (doApproximate) {
                markovReportItem = new MarkovReportItem(scenario.getEntityName(), scenario.getId(),
                        getFormattedProbabilityAsString(cumulatedSuccessProbability, cumulatedSuccessProbability + 1
                                - cumulatedPhysicalStateProbability));
            } else {
                markovReportItem = new MarkovReportItem(scenario.getEntityName(), scenario.getId(),
                        getFormattedProbabilityAsString(cumulatedSuccessProbability));
            }

            /*
             * Create failure mode tables first: Create a table row for each failure probability
             * aggregation, and add this row to the according impact analysis table.
             */
            createFailureAnalysisTables(cumulatedFailureTypeProbabilities, cumulatedPhysicalStateProbability,
                    doApproximate, markovReportItem, mode);

            /*
             * Calculate accumulated failure probabilities if our configuration is set accordingly.
             * Otherwise, we are done at this point.
             */
            if (mode == MarkovEvaluationType.POINTSOFFAILURE) {
                failureProbabilityAggregations = new ArrayList<ImpactAnalysisFailureProbabilityAggregation>(); // do
                                                                                                               // not
                                                                                                               // put
                                                                                                               // this
                                                                                                               // line
                                                                                                               // into
                                                                                                               // constructor

                calculateComponentsInternalActionFailureProbabilities(cumulatedFailureTypeProbabilities);
                calculateComponentsServiceFailureProbabilities(cumulatedFailureTypeProbabilities);
                calculateComponentsServiceOperationFailureProbabilities(cumulatedFailureTypeProbabilities);
                calculateExternalServiceFailureProbabilities(cumulatedFailureTypeProbabilities);
                calculateExternalServiceOperationFailureProbabilities(cumulatedFailureTypeProbabilities);

                /*
                 * Now, create impact analysis tables. Insert calculated failure probabilities into
                 * report.
                 */
                createImpactAnalysisTables(cumulatedPhysicalStateProbability, doApproximate, markovReportItem);
            }

            /*
             * Add this report item to our list of report items.
             */
            markovReportItems.add(markovReportItem);
        }
    }

    private void createPointsOfFailureAnalysisTable(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities,
            double cumulatedPhysicalStateProbability, boolean doApproximate, MarkovReportItem markovReportItem) {
        /*
         * System-internal entities.
         */
        MarkovReportingTable internalSoftwareFailuresTable = new MarkovReportingTable(
                "System-internal software-induced failure modes");
        List<String> internalSoftwareFailuresTableHeaderRow = new ArrayList<String>(6);
        internalSoftwareFailuresTableHeaderRow.add("Component");
        internalSoftwareFailuresTableHeaderRow.add("Interface");
        internalSoftwareFailuresTableHeaderRow.add("Signature");
        internalSoftwareFailuresTableHeaderRow.add("Internal Action");
        internalSoftwareFailuresTableHeaderRow.add("Failure Type");
        internalSoftwareFailuresTableHeaderRow.add("Failure Mode Probability");
        internalSoftwareFailuresTable.setHeaderRow(internalSoftwareFailuresTableHeaderRow);
        List<String> internalSoftwareFailuresTableRow;

        MarkovReportingTable internalHardwareFailuresTable = new MarkovReportingTable(
                "System-internal hardware-induced failure modes");
        List<String> internalHardwareFailuresTableHeaderRow = new ArrayList<String>(3);
        internalHardwareFailuresTableHeaderRow.add("Resource Container");
        internalHardwareFailuresTableHeaderRow.add("Resource Type");
        internalHardwareFailuresTableHeaderRow.add("Failure Mode Probablity");
        internalHardwareFailuresTable.setHeaderRow(internalHardwareFailuresTableHeaderRow);
        List<String> internalHardwareFailuresTableRow;

        MarkovReportingTable internalNetworkFailuresTable = new MarkovReportingTable(
                "System-internal network-induced failure modes");
        List<String> internalNetworkFailuresTableHeaderRow = new ArrayList<String>(3);
        internalNetworkFailuresTableHeaderRow.add("Communication Link");
        internalNetworkFailuresTableHeaderRow.add("Communication Resource Type");
        internalNetworkFailuresTableHeaderRow.add("Failure Mode Probablity");
        internalNetworkFailuresTable.setHeaderRow(internalNetworkFailuresTableHeaderRow);
        List<String> internalNetworkFailuresTableRow;

        /*
         * System-external entities.
         */
        MarkovReportingTable externalSoftwareFailuresTable = new MarkovReportingTable(
                "System-external software-induced failure modes");
        List<String> externalSoftwareFailuresTableHeaderRow = new ArrayList<String>(4);
        externalSoftwareFailuresTableHeaderRow.add("System-required Role");
        externalSoftwareFailuresTableHeaderRow.add("Signature");
        externalSoftwareFailuresTableHeaderRow.add("Failure Type");
        externalSoftwareFailuresTableHeaderRow.add("Failure Mode Probability");
        externalSoftwareFailuresTable.setHeaderRow(externalSoftwareFailuresTableHeaderRow);
        List<String> externalSoftwareFailuresTableRow;

        MarkovReportingTable externalHardwareFailuresTable = new MarkovReportingTable(
                "System-external hardware-induced failure modes");
        List<String> externalHardwareFailuresTableHeaderRow = new ArrayList<String>(4);
        externalHardwareFailuresTableHeaderRow.add("System-required Role");
        externalHardwareFailuresTableHeaderRow.add("Signature");
        externalHardwareFailuresTableHeaderRow.add("Communication Resource Type");
        externalHardwareFailuresTableHeaderRow.add("Failure Mode Probablity");
        externalHardwareFailuresTable.setHeaderRow(externalHardwareFailuresTableHeaderRow);
        List<String> externalHardwareFailuresTableRow;

        MarkovReportingTable externalNetworkFailuresTable = new MarkovReportingTable(
                "System-external network-induced failure modes");
        List<String> externalNetworkFailuresTableHeaderRow = new ArrayList<String>(4);
        externalNetworkFailuresTableHeaderRow.add("System-required Role");
        externalNetworkFailuresTableHeaderRow.add("Signature");
        externalNetworkFailuresTableHeaderRow.add("Communication Resource Type");
        externalNetworkFailuresTableHeaderRow.add("Failure Mode Probablity");
        externalNetworkFailuresTable.setHeaderRow(externalNetworkFailuresTableHeaderRow);
        List<String> externalNetworkFailuresTableRow;

        TreeSet<MarkovFailureType> failureTypesSorted = getFailureTypesSorted(cumulatedFailureTypeProbabilities);
        for (MarkovFailureType failureType : failureTypesSorted) {
            double failureProbability = getFailureTypeProbability(failureType, cumulatedFailureTypeProbabilities);
            if (!(failureProbability > 0.0)) {
                continue;
            }
            if (failureType.isSystemExternal()) { // external
                if (failureType instanceof MarkovSoftwareInducedFailureType) {
                    MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;

                    externalSoftwareFailuresTableRow = new ArrayList<String>(
                            externalSoftwareFailuresTableHeaderRow.size());
                    externalSoftwareFailuresTableRow.add(softwareInducedFailureType.getRoleName());
                    externalSoftwareFailuresTableRow.add(softwareInducedFailureType.getSignatureName());
                    externalSoftwareFailuresTableRow.add(softwareInducedFailureType.getSoftwareFailureName());
                    externalSoftwareFailuresTableRow.add(doApproximate ? getFormattedProbabilityAsString(
                            getFailureTypeProbability(softwareInducedFailureType, cumulatedFailureTypeProbabilities),
                            /*
                             * getFailureTypeProbability( softwareInducedFailureType,
                             * cumulatedFailureTypeProbabilities)
                             */
                            failureProbability + 1 - cumulatedPhysicalStateProbability)
                            : getFormattedProbabilityAsString(/*
                                                               * getFailureTypeProbability(
                                                               * softwareInducedFailureType ,
                                                               * cumulatedFailureTypeProbabilities )
                                                               */
                            failureProbability));
                    externalSoftwareFailuresTable.addRow(externalSoftwareFailuresTableRow);
                } else if (failureType instanceof MarkovHardwareInducedFailureType) {
                    MarkovHardwareInducedFailureType hardwareInducedFailureType = (MarkovHardwareInducedFailureType) failureType;
                    externalHardwareFailuresTableRow = new ArrayList<String>(
                            externalHardwareFailuresTableHeaderRow.size());
                    externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getRoleName());
                    externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getSignatureName());
                    externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceTypeName());
                    externalHardwareFailuresTableRow.add(doApproximate ? getFormattedProbabilityAsString(
                    /*
                     * getFailureTypeProbability( hardwareInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability,
                    /*
                     * getFailureTypeProbability( hardwareInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability + 1 - cumulatedPhysicalStateProbability) : getFormattedProbabilityAsString(/*
                                                                                                                   * getFailureTypeProbability
                                                                                                                   * (
                                                                                                                   * hardwareInducedFailureType
                                                                                                                   * ,
                                                                                                                   * cumulatedFailureTypeProbabilities
                                                                                                                   * )
                                                                                                                   */
                    failureProbability));
                    externalHardwareFailuresTable.addRow(externalHardwareFailuresTableRow);
                } else if (failureType instanceof MarkovNetworkInducedFailureType) {
                    MarkovNetworkInducedFailureType networkInducedFailureType = (MarkovNetworkInducedFailureType) failureType;
                    externalNetworkFailuresTableRow = new ArrayList<String>(
                            externalNetworkFailuresTableHeaderRow.size());
                    externalNetworkFailuresTableRow.add(networkInducedFailureType.getRoleName());
                    externalNetworkFailuresTableRow.add(networkInducedFailureType.getSignatureName());
                    externalNetworkFailuresTableRow.add(networkInducedFailureType.getCommLinkResourceTypeName());
                    externalNetworkFailuresTableRow.add(doApproximate ? getFormattedProbabilityAsString(
                    /*
                     * getFailureTypeProbability( networkInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability,
                    /*
                     * getFailureTypeProbability( networkInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability + 1 - cumulatedPhysicalStateProbability) : getFormattedProbabilityAsString(/*
                                                                                                                   * getFailureTypeProbability
                                                                                                                   * (
                                                                                                                   * networkInducedFailureType
                                                                                                                   * ,
                                                                                                                   * cumulatedFailureTypeProbabilities
                                                                                                                   * )
                                                                                                                   */
                    failureProbability));
                    externalNetworkFailuresTable.addRow(externalNetworkFailuresTableRow);
                }
            } else { // internal
                if (failureType instanceof MarkovSoftwareInducedFailureType) {
                    MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;
                    internalSoftwareFailuresTableRow = new ArrayList<String>(
                            internalSoftwareFailuresTableHeaderRow.size());
                    internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getComponentName());
                    internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getInterfaceName());
                    internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getSignatureName());
                    internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getInternalActionName());
                    internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getSoftwareFailureName());
                    internalSoftwareFailuresTableRow.add(doApproximate ? getFormattedProbabilityAsString(
                    /*
                     * getFailureTypeProbability( softwareInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability,
                    /*
                     * getFailureTypeProbability( softwareInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability + 1 - cumulatedPhysicalStateProbability) : getFormattedProbabilityAsString(/*
                                                                                                                   * getFailureTypeProbability
                                                                                                                   * (
                                                                                                                   * softwareInducedFailureType
                                                                                                                   * ,
                                                                                                                   * cumulatedFailureTypeProbabilities
                                                                                                                   * )
                                                                                                                   */
                    failureProbability));
                    internalSoftwareFailuresTable.addRow(internalSoftwareFailuresTableRow);
                } else if (failureType instanceof MarkovHardwareInducedFailureType) {
                    MarkovHardwareInducedFailureType hardwareInducedFailureType = (MarkovHardwareInducedFailureType) failureType;
                    internalHardwareFailuresTableRow = new ArrayList<String>(
                            internalHardwareFailuresTableHeaderRow.size());
                    internalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceContainerName());
                    internalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceTypeName());
                    internalHardwareFailuresTableRow.add(doApproximate ? getFormattedProbabilityAsString(
                    /*
                     * getFailureTypeProbability( hardwareInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability,
                    /*
                     * getFailureTypeProbability( hardwareInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability + 1 - cumulatedPhysicalStateProbability) : getFormattedProbabilityAsString(/*
                                                                                                                   * getFailureTypeProbability
                                                                                                                   * (
                                                                                                                   * hardwareInducedFailureType
                                                                                                                   * ,
                                                                                                                   * cumulatedFailureTypeProbabilities
                                                                                                                   * )
                                                                                                                   */
                    failureProbability));
                    internalHardwareFailuresTable.addRow(internalHardwareFailuresTableRow);
                } else if (failureType instanceof MarkovNetworkInducedFailureType) {
                    MarkovNetworkInducedFailureType networkInducedFailureType = (MarkovNetworkInducedFailureType) failureType;
                    internalNetworkFailuresTableRow = new ArrayList<String>(
                            internalNetworkFailuresTableHeaderRow.size());
                    internalNetworkFailuresTableRow.add(networkInducedFailureType.getLinkingResourceName());
                    internalNetworkFailuresTableRow.add(networkInducedFailureType.getCommLinkResourceTypeName());
                    internalNetworkFailuresTableRow.add(doApproximate ? getFormattedProbabilityAsString(
                    /*
                     * getFailureTypeProbability( networkInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability,
                    /*
                     * getFailureTypeProbability( networkInducedFailureType,
                     * cumulatedFailureTypeProbabilities)
                     */
                    failureProbability + 1 - cumulatedPhysicalStateProbability) : getFormattedProbabilityAsString(/*
                                                                                                                   * getFailureTypeProbability
                                                                                                                   * (
                                                                                                                   * networkInducedFailureType
                                                                                                                   * ,
                                                                                                                   * cumulatedFailureTypeProbabilities
                                                                                                                   * )
                                                                                                                   */
                    failureProbability));
                    internalNetworkFailuresTable.addRow(internalNetworkFailuresTableRow);
                }
            }
        }

        /*
         * Finally, add the generated failure mode tables to our report item if they contain at
         * least one row (per table).
         */
        if (internalSoftwareFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(internalSoftwareFailuresTable);
        }
        if (internalHardwareFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(internalHardwareFailuresTable);
        }
        if (internalNetworkFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(internalNetworkFailuresTable);
        }
        if (externalSoftwareFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(externalSoftwareFailuresTable);
        }
        if (externalHardwareFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(externalHardwareFailuresTable);
        }
        if (externalNetworkFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(externalNetworkFailuresTable);
        }
    }

    private void createTypesFailureAnalysisTable(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities,
            double cumulatedPhysicalStateProbability, boolean doApproximate, MarkovReportItem markovReportItem) {
        double failureProbability;
        // create tables
        MarkovReportingTable softwareInducedFailuresTable = new MarkovReportingTable("Software-induced failure modes");
        List<String> softwareInducedFailuresTableHeaderRow = new ArrayList<String>(2);
        softwareInducedFailuresTableHeaderRow.add("Failure Type");
        softwareInducedFailuresTableHeaderRow.add("Failure Mode Probability");
        softwareInducedFailuresTable.setHeaderRow(softwareInducedFailuresTableHeaderRow);

        MarkovReportingTable hardwareInducedFailuresTable = new MarkovReportingTable("Hardware-induced failure modes");
        List<String> hardwareInducedFailuresTableHeaderRow = new ArrayList<String>(2);
        hardwareInducedFailuresTableHeaderRow.add("Resource Type");
        hardwareInducedFailuresTableHeaderRow.add("Failure Mode Probability");
        hardwareInducedFailuresTable.setHeaderRow(hardwareInducedFailuresTableHeaderRow);

        MarkovReportingTable networkInducedFailuresTable = new MarkovReportingTable("Network-induced failure modes");
        List<String> networkInducedFailuresTableHeaderRow = new ArrayList<String>(2);
        networkInducedFailuresTableHeaderRow.add("Communication Resource Type");
        networkInducedFailuresTableHeaderRow.add("Failure Mode Probability");
        networkInducedFailuresTable.setHeaderRow(networkInducedFailuresTableHeaderRow);

        // determine failure probabilities
        List<TypesFailureProbabilityAggregation> failureProbabilityAggregations = new ArrayList<TypesFailureProbabilityAggregation>();
        for (MarkovFailureType type : cumulatedFailureTypeProbabilities.keySet()) {
            if (!type.isSystemExternal()) { // only consider internal failures
                if (type instanceof MarkovSoftwareInducedFailureType) { // only
                                                                        // consider
                                                                        // software-induced
                                                                        // failures
                    MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) type;
                    boolean foundEntry = false;
                    for (TypesFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
                        if (aggregation.compareTo(FailureAnalysisFailureType.SOFTWARE_INDUCED,
                                softwareInducedFailureType.getSoftwareFailureName())) { // see if
                                                                                        // there
                                                                                        // exists
                                                                                        // already
                                                                                        // a
                                                                                        // fitting
                                                                                        // aggregation
                                                                                        // to
                                                                                        // which
                                                                                        // can
                                                                                        // add
                                                                                        // this
                                                                                        // type's
                                                                                        // failure
                                                                                        // probability
                                                                                        // to
                            // yes, we found such an entry, so add up the
                            // probabilities
                            aggregation.addToFailureProbability(cumulatedFailureTypeProbabilities
                                    .get(softwareInducedFailureType));
                            foundEntry = true;
                            break;
                        } // else continue with next
                    }
                    // we have not found a fitting entry previously, so we will
                    // create a new one
                    if (!foundEntry) {
                        failureProbabilityAggregations.add(new TypesFailureProbabilityAggregation(
                                FailureAnalysisFailureType.SOFTWARE_INDUCED, softwareInducedFailureType
                                        .getSoftwareFailureName(), cumulatedFailureTypeProbabilities
                                        .get(softwareInducedFailureType)));
                    }
                } else if (type instanceof MarkovHardwareInducedFailureType) { // only
                                                                               // consider
                                                                               // hardware-induced
                                                                               // failures
                    MarkovHardwareInducedFailureType hardwareInducedFailureType = (MarkovHardwareInducedFailureType) type;
                    boolean foundEntry = false;
                    for (TypesFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
                        if (aggregation.compareTo(FailureAnalysisFailureType.HARDWARE_INDUCED,
                                hardwareInducedFailureType.getResourceTypeName())) { // see if
                                                                                     // there
                                                                                     // exists
                                                                                     // already a
                                                                                     // fitting
                                                                                     // aggregation
                                                                                     // to which
                                                                                     // can add
                                                                                     // this
                                                                                     // type's
                                                                                     // failure
                                                                                     // probability
                                                                                     // to
                            // yes, we found such an entry, so add up the
                            // probabilities
                            aggregation.addToFailureProbability(cumulatedFailureTypeProbabilities
                                    .get(hardwareInducedFailureType));
                            foundEntry = true;
                            break;
                        } // else continue with next
                    }
                    if (!foundEntry) {
                        // we have not found a fitting entry previously, so we
                        // will create a new one
                        failureProbabilityAggregations.add(new TypesFailureProbabilityAggregation(
                                FailureAnalysisFailureType.HARDWARE_INDUCED, hardwareInducedFailureType
                                        .getResourceTypeName(), cumulatedFailureTypeProbabilities
                                        .get(hardwareInducedFailureType)));
                    }
                } else if (type instanceof MarkovNetworkInducedFailureType) { // only
                                                                              // consider
                                                                              // network-induced
                                                                              // failures
                    MarkovNetworkInducedFailureType networkInducedFailureType = (MarkovNetworkInducedFailureType) type;
                    boolean foundEntry = false;
                    for (TypesFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
                        if (aggregation.compareTo(FailureAnalysisFailureType.NETWORK_INDUCED,
                                networkInducedFailureType.getCommLinkResourceTypeName())) { // see
                                                                                            // if
                                                                                            // there
                                                                                            // exists
                                                                                            // already
                                                                                            // a
                                                                                            // fitting
                                                                                            // aggregation
                                                                                            // to
                                                                                            // which
                                                                                            // can
                                                                                            // add
                                                                                            // this
                                                                                            // type's
                                                                                            // failure
                                                                                            // probability
                                                                                            // to
                            // yes, we found such an entry, so add up the
                            // probabilities
                            aggregation.addToFailureProbability(cumulatedFailureTypeProbabilities
                                    .get(networkInducedFailureType));
                            foundEntry = true;
                            break;
                        } // else continue with next
                    }
                    if (!foundEntry) {
                        // we have not found a fitting entry previously, so we
                        // will create a new one
                        failureProbabilityAggregations.add(new TypesFailureProbabilityAggregation(
                                FailureAnalysisFailureType.NETWORK_INDUCED, networkInducedFailureType
                                        .getCommLinkResourceTypeName(), cumulatedFailureTypeProbabilities
                                        .get(networkInducedFailureType)));
                    }
                }
            }
        }

        // now create rows of table
        List<String> softwareInducedFailuresTableRow;
        List<String> hardwareInducedFailuresTableRow;
        List<String> networkInducedFailuresTableRow;
        for (TypesFailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
            failureProbability = aggregation.getFailureProbability();
            if (!(failureProbability > 0.0)) {
                continue;
            }
            switch (aggregation.getType()) {
            case SOFTWARE_INDUCED:
                softwareInducedFailuresTableRow = new ArrayList<String>(2);
                softwareInducedFailuresTableRow.add(aggregation.getTypeIdentifier());
                softwareInducedFailuresTableRow.add(String.valueOf(doApproximate ? getFormattedProbabilityAsString(
                        failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
                        : getFormattedProbabilityAsString(failureProbability)));
                softwareInducedFailuresTable.addRow(softwareInducedFailuresTableRow);
                break;
            case HARDWARE_INDUCED:
                hardwareInducedFailuresTableRow = new ArrayList<String>(2);
                hardwareInducedFailuresTableRow.add(aggregation.getTypeIdentifier());
                hardwareInducedFailuresTableRow.add(String.valueOf(doApproximate ? getFormattedProbabilityAsString(
                        failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
                        : getFormattedProbabilityAsString(failureProbability)));
                hardwareInducedFailuresTable.addRow(hardwareInducedFailuresTableRow);
                break;
            case NETWORK_INDUCED:
                networkInducedFailuresTableRow = new ArrayList<String>(2);
                networkInducedFailuresTableRow.add(aggregation.getTypeIdentifier());
                networkInducedFailuresTableRow.add(String.valueOf(doApproximate ? getFormattedProbabilityAsString(
                        failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
                        : getFormattedProbabilityAsString(failureProbability)));
                networkInducedFailuresTable.addRow(networkInducedFailuresTableRow);
                break;
            default:
                break;
            }
        }

        // finally, add tables to report item if they contain at least one row
        // (per table)
        if (softwareInducedFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(softwareInducedFailuresTable);
        }
        if (hardwareInducedFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(hardwareInducedFailuresTable);
        }
        if (networkInducedFailuresTable.getRows().size() > 0) {
            markovReportItem.addFailureModeTable(networkInducedFailuresTable);
        }
    }

    /**
     * Retrieves the failure probability of the given failure type.
     * 
     * @param failureType
     *            the given failure type
     * @return the failure probability
     */
    private double getFailureTypeProbability(final MarkovFailureType failureType,
            Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
        Double failureTypeProbability = cumulatedFailureTypeProbabilities.get(failureType);
        return (failureTypeProbability == null) ? 0.0 : failureTypeProbability;
    }

    /**
     * Sorts the failure types alphabetically by name.
     * 
     * @return the sorted list of failure types
     */
    private TreeSet<MarkovFailureType> getFailureTypesSorted(
            Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
        TreeSet<MarkovFailureType> result = new TreeSet<MarkovFailureType>();
        for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
            result.add(failureType);
        }
        return result;
    }

    private String getFormattedProbabilityAsString(double probability) {
        return String.format("%1$.11f", probability);
    }

    private String getFormattedProbabilityAsString(double lowerBound, double upperBound) {
        MarkovResultApproximation approximation = new MarkovResultApproximation(lowerBound, upperBound);
        int places = approximation.getAccuracy() + 1;
        return String.format("%1$." + places + "f - %2$." + places + "f", approximation.getAdjustedLowerBound(),
                approximation.getAdjustedUpperBound());
    }

    /**
     * Returns a list of Markov report items that were generated from the Markov transformation
     * results.
     * 
     * @return a list of Markov report items
     */
    public List<MarkovReportItem> getMarkovReportItems() {
        return markovReportItems;
    }
}
