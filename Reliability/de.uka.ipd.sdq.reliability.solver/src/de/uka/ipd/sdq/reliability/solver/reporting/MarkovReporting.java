package de.uka.ipd.sdq.reliability.solver.reporting;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeSet;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovHardwareInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovNetworkInducedFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.FailureAggregationType;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.FailureProbabilityAggregation;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovTransformationResult;

/**
 * Class used for aggregation and output of failure probabilities that were
 * calculated during a reliability analysis.
 * 
 * @author Daniel Patejdl
 * 
 */
public class MarkovReporting {
//	/**
//	 * Overall failure type probabilities, accumulated over all considered
//	 * physical system states.
//	 */
//	private Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities;
//
//	/**
//	 * Overall physical state probability, accumulated over all considered
//	 * physical system states.
//	 */
//	private double cumulatedPhysicalStateProbability;
//
//	/**
//	 * Whether result approximation is enabled or not.
//	 */
//	private boolean doApproximate;
//
//	/**
//	 * A logger to give detailed information about the PCM instance
//	 * transformation.
//	 */
//	private static Logger logger = Logger.getLogger(MarkovReporting.class
//			.getName());

	/**
	 * List of aggregated results of a PCM2MarkovTransformation
	 */
	private List<MarkovTransformationResult> markovResults;

	/**
	 * Will store the overall failure probabilities of entities (components'
	 * internal actions, their services and service operations, external
	 * services and their operations).
	 */
	List<FailureProbabilityAggregation> failureProbabilityAggregations;

	/**
	 * A list of MarkovReportItem instances, which are generated as a result of
	 * all Markov transformation results. They will be used for later output to
	 * the user.
	 */
	List<MarkovReportItem> markovReportItems;

//	/**
//	 * Creates a new MarkovReporting instance that is used for result
//	 * aggregation according to the given accumulated failure type
//	 * probabilities.
//	 * 
//	 * @param cumulatedFailureTypeProbabilities
//	 *            the overall failure type probabilities, accumulated over all
//	 *            considered physical system states.
//	 * @param doApproximate
//	 *            whether result approximation is enabled or not
//	 * @param cumulatedPhysicalStateProbability
//	 *            the overall physical state probability, accumulated over all
//	 *            considered physical system states.
//	 */
//	public MarkovReporting(
//			Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities,
//			double cumulatedPhysicalStateProbability, boolean doApproximate) {
//		this.cumulatedFailureTypeProbabilities = cumulatedFailureTypeProbabilities;
//		this.cumulatedPhysicalStateProbability = cumulatedPhysicalStateProbability;
//		this.doApproximate = doApproximate;
//
//		failureProbabilityAggregations = new ArrayList<FailureProbabilityAggregation>();
//
//		// calculate accumulated component as well as external service failure
//		// probabilities
//		calculateComponentsInternalActionFailureProbabilities();
//		calculateComponentsServiceFailureProbabilities();
//		calculateComponentsServiceOperationFailureProbabilities();
//		calculateExternalServiceFailureProbabilities();
//		calculateExternalServiceOperationFailureProbabilities();
//	}

	/**
	 * Creates a new MarkovReporting instance that is used for result aggregation according
	 * to the given Markov transformation results.
	 * 
	 * @param markovResults the Markov transformation results
	 */
	public MarkovReporting(List<MarkovTransformationResult> markovResults) {
		this.markovResults = markovResults;
		failureProbabilityAggregations = new ArrayList<FailureProbabilityAggregation>();
		markovReportItems = new ArrayList<MarkovReportItem>();
	
		createMarkovReportItems();
	}
	
	/**
	 * Sorts the failure types alphabetically by name.
	 * 
	 * @return the sorted list of failure types
	 */
	private TreeSet<MarkovFailureType> getFailureTypesSorted(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		TreeSet<MarkovFailureType> result = new TreeSet<MarkovFailureType>();
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
			result.add(failureType);
		}
		return result;
	}
	
	/**
	 * Retrieves the failure probability of the given failure type.
	 * 
	 * @param failureType
	 *            the given failure type
	 * @return the failure probability
	 */
	private double getFailureTypeProbability(final MarkovFailureType failureType, Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		Double failureTypeProbability = cumulatedFailureTypeProbabilities
				.get(failureType);
		return (failureTypeProbability == null) ? 0.0 : failureTypeProbability;
	}

	/**
	 * Consider all Markov transformation results: For each such result we will
	 * calculate the probabilities of interest, and then enclose them in a MarkovResultItem
	 * for further processing.
	 */
	private void createMarkovReportItems() {
		Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities = null;
		double cumulatedPhysicalStateProbability = 0;
		// TODO consider "doApproximate" functionality (use cumulatedPhysicalStateProbability for this)

		// TODO check for POINTSOFFAILURE true/false

		/**
		 * Create table-style output format.
		 */
		UsageScenario scenario = null;
		MarkovReportItem markovReportItem = null;
		for (MarkovTransformationResult markovResult : markovResults) {
			cumulatedFailureTypeProbabilities = markovResult
					.getCumulatedFailureTypeProbabilities();
			cumulatedPhysicalStateProbability = markovResult
					.getCumulatedPhysicalStateProbability();
			scenario = markovResult.getScenario();

			/**
			 * Create a new Markov report item using the data of this scenario.
			 */
			markovReportItem = new MarkovReportItem(scenario
					.getEntityName(), scenario.getId(), markovResult
					.getSuccessProbability());

			/**
			 * Create failure overview tables first.
			 */
			TreeSet<MarkovFailureType> failureTypesSorted = getFailureTypesSorted(cumulatedFailureTypeProbabilities);

			/**
			 * System-internal entities.
			 */
			MarkovReportingTable internalSoftwareFailuresTable = new MarkovReportingTable("System-internal software-induced failures");
			List<String> internalSoftwareFailuresTableHeaderRow = new ArrayList<String>(6);
			internalSoftwareFailuresTableHeaderRow.add("Component");
			internalSoftwareFailuresTableHeaderRow.add("Interface");
			internalSoftwareFailuresTableHeaderRow.add("Signature");
			internalSoftwareFailuresTableHeaderRow.add("Internal Action");
			internalSoftwareFailuresTableHeaderRow.add("Software Failure");
			internalSoftwareFailuresTableHeaderRow.add("Failure Probability");
			internalSoftwareFailuresTable.setHeaderRow(internalSoftwareFailuresTableHeaderRow);
			List<String> internalSoftwareFailuresTableRow;

			MarkovReportingTable internalHardwareFailuresTable = new MarkovReportingTable("System-internal hardware-induced failures");
			List<String> internalHardwareFailuresTableHeaderRow = new ArrayList<String>(3);
			internalHardwareFailuresTableHeaderRow.add("Resource Container");
			internalHardwareFailuresTableHeaderRow.add("Resource Type");
			internalHardwareFailuresTableHeaderRow.add("Failure Probablity");
			internalHardwareFailuresTable.setHeaderRow(internalHardwareFailuresTableHeaderRow);
			List<String> internalHardwareFailuresTableRow;

			MarkovReportingTable internalNetworkFailuresTable = new MarkovReportingTable("System-internal network-induced failures");
			List<String> internalNetworkFailuresTableHeaderRow = new ArrayList<String>(3);
			internalNetworkFailuresTableHeaderRow.add("Communication Link");
			internalNetworkFailuresTableHeaderRow.add("Communication Resource Type");
			internalNetworkFailuresTableHeaderRow.add("Failure Probablity");
			internalNetworkFailuresTable.setHeaderRow(internalNetworkFailuresTableHeaderRow);
			List<String> internalNetworkFailuresTableRow;

			/**
			 * System-external entities.
			 */
			MarkovReportingTable externalSoftwareFailuresTable = new MarkovReportingTable("System-external software-induced failures");
			List<String> externalSoftwareFailuresTableHeaderRow = new ArrayList<String>(4);
			externalSoftwareFailuresTableHeaderRow.add("System-required Role");
			externalSoftwareFailuresTableHeaderRow.add("Signature");
			externalSoftwareFailuresTableHeaderRow.add("Software Failure");
			externalSoftwareFailuresTableHeaderRow.add("Failure Probability");
			externalSoftwareFailuresTable.setHeaderRow(externalSoftwareFailuresTableHeaderRow);
			List<String> externalSoftwareFailuresTableRow;

			MarkovReportingTable externalHardwareFailuresTable = new MarkovReportingTable("System-external hardware-induced failures");
			List<String> externalHardwareFailuresTableHeaderRow = new ArrayList<String>(4);
			externalHardwareFailuresTableHeaderRow.add("System-required Role");
			externalHardwareFailuresTableHeaderRow.add("Signature");
			externalHardwareFailuresTableHeaderRow.add("Communication Resource Type");
			externalHardwareFailuresTableHeaderRow.add("Failure Probablity");
			externalHardwareFailuresTable.setHeaderRow(externalHardwareFailuresTableHeaderRow);
			List<String> externalHardwareFailuresTableRow;

			MarkovReportingTable externalNetworkFailuresTable = new MarkovReportingTable("System-external network-induced failures");
			List<String> externalNetworkFailuresTableHeaderRow = new ArrayList<String>(4);
			externalNetworkFailuresTableHeaderRow.add("System-required Role");
			externalNetworkFailuresTableHeaderRow.add("Signature");
			externalNetworkFailuresTableHeaderRow.add("Communication Resource Type");
			externalNetworkFailuresTableHeaderRow.add("Failure Probablity");
			externalNetworkFailuresTable.setHeaderRow(externalNetworkFailuresTableHeaderRow);
			List<String> externalNetworkFailuresTableRow;

			for (MarkovFailureType failureType : failureTypesSorted) {
				if (failureType.isSystemExternal()) {	// external
					if (failureType instanceof MarkovSoftwareInducedFailureType) {
						MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;
						externalSoftwareFailuresTableRow = new ArrayList<String>(externalSoftwareFailuresTableHeaderRow.size());
						externalSoftwareFailuresTableRow.add(softwareInducedFailureType.getRoleName());
						externalSoftwareFailuresTableRow.add(softwareInducedFailureType.getSignatureName());
						externalSoftwareFailuresTableRow.add(softwareInducedFailureType.getSoftwareFailureName());
						externalSoftwareFailuresTableRow.add(Double.toString(getFailureTypeProbability(softwareInducedFailureType, cumulatedFailureTypeProbabilities)));
						externalSoftwareFailuresTable.addRow(externalSoftwareFailuresTableRow);
					} else if (failureType instanceof MarkovHardwareInducedFailureType) {
						MarkovHardwareInducedFailureType hardwareInducedFailureType = (MarkovHardwareInducedFailureType) failureType;
						externalHardwareFailuresTableRow = new ArrayList<String>(externalHardwareFailuresTableHeaderRow.size());
						externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getRoleName());
						externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getSignatureName());
						externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceTypeName());
						externalHardwareFailuresTableRow.add(Double.toString(getFailureTypeProbability(hardwareInducedFailureType, cumulatedFailureTypeProbabilities)));
						externalHardwareFailuresTable.addRow(externalHardwareFailuresTableRow);
					} else if (failureType instanceof MarkovNetworkInducedFailureType) {
						MarkovNetworkInducedFailureType networkInducedFailureType = (MarkovNetworkInducedFailureType) failureType;
						externalNetworkFailuresTableRow = new ArrayList<String>(externalNetworkFailuresTableHeaderRow.size());
						externalNetworkFailuresTableRow.add(networkInducedFailureType.getRoleName());
						externalNetworkFailuresTableRow.add(networkInducedFailureType.getSignatureName());
						externalNetworkFailuresTableRow.add(networkInducedFailureType.getCommLinkResourceTypeName());
						externalNetworkFailuresTableRow.add(Double.toString(getFailureTypeProbability(networkInducedFailureType, cumulatedFailureTypeProbabilities)));
						externalNetworkFailuresTable.addRow(externalNetworkFailuresTableRow);
					}
				} else {	// internal
					if (failureType instanceof MarkovSoftwareInducedFailureType) {
						MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;
						internalSoftwareFailuresTableRow = new ArrayList<String>(internalSoftwareFailuresTableHeaderRow.size());
						internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getComponentName());
						internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getInterfaceName());
						internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getSignatureName());
						internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getInternalActionName());
						internalSoftwareFailuresTableRow.add(softwareInducedFailureType.getSoftwareFailureName());
						internalSoftwareFailuresTableRow.add(Double.toString(getFailureTypeProbability(softwareInducedFailureType, cumulatedFailureTypeProbabilities)));
						internalSoftwareFailuresTable.addRow(internalSoftwareFailuresTableRow);
					} else if (failureType instanceof MarkovHardwareInducedFailureType) {
						MarkovHardwareInducedFailureType hardwareInducedFailureType = (MarkovHardwareInducedFailureType) failureType;
						internalHardwareFailuresTableRow = new ArrayList<String>(internalHardwareFailuresTableHeaderRow.size());
						internalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceContainerName());
						internalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceTypeName());
						internalHardwareFailuresTableRow.add(Double.toString(getFailureTypeProbability(hardwareInducedFailureType, cumulatedFailureTypeProbabilities)));
						internalHardwareFailuresTable.addRow(internalHardwareFailuresTableRow);
					} else if (failureType instanceof MarkovNetworkInducedFailureType) {
						MarkovNetworkInducedFailureType networkInducedFailureType = (MarkovNetworkInducedFailureType) failureType;
						internalNetworkFailuresTableRow = new ArrayList<String>(internalNetworkFailuresTableHeaderRow.size());
						internalNetworkFailuresTableRow.add(networkInducedFailureType.getLinkingResourceName());
						internalNetworkFailuresTableRow.add(networkInducedFailureType.getCommLinkResourceTypeName());
						internalNetworkFailuresTableRow.add(Double.toString(getFailureTypeProbability(networkInducedFailureType, cumulatedFailureTypeProbabilities)));
						internalNetworkFailuresTable.addRow(internalNetworkFailuresTableRow);
					}
				}
			}

			markovReportItem.addTable(internalSoftwareFailuresTable);
			markovReportItem.addTable(internalHardwareFailuresTable);
			markovReportItem.addTable(internalNetworkFailuresTable);
			markovReportItem.addTable(externalSoftwareFailuresTable);
			markovReportItem.addTable(externalHardwareFailuresTable);
			markovReportItem.addTable(externalNetworkFailuresTable);

			/**
			 * Calculate accumulated failure probabilities.
			 */
			calculateComponentsInternalActionFailureProbabilities(cumulatedFailureTypeProbabilities);
			calculateComponentsServiceFailureProbabilities(cumulatedFailureTypeProbabilities);
			calculateComponentsServiceOperationFailureProbabilities(cumulatedFailureTypeProbabilities);
			calculateExternalServiceFailureProbabilities(cumulatedFailureTypeProbabilities);
			calculateExternalServiceOperationFailureProbabilities(cumulatedFailureTypeProbabilities);

			/**
			 * Insert calculated failure probabilities into report...
			 */
			// componentsInternalActionFailureProbabilities
			MarkovReportingTable componentsInternalActionFailureProbabilitiesTable = new MarkovReportingTable("Component failure impacts");
			List<String> componentsInternalActionFailureProbabilitiesTableHeaderRow = new ArrayList<String>(3);
			componentsInternalActionFailureProbabilitiesTableHeaderRow.add("Component");
			componentsInternalActionFailureProbabilitiesTableHeaderRow.add("Failure Probability");
			componentsInternalActionFailureProbabilitiesTable.setHeaderRow(componentsInternalActionFailureProbabilitiesTableHeaderRow);

			// componentsServiceFailureProbabilities
			MarkovReportingTable componentsServiceFailureProbabilitiesTable = new MarkovReportingTable("Component service failure impacts");
			List<String> componentsServiceFailureProbabilitiesTableHeaderRow = new ArrayList<String>(3);
			componentsServiceFailureProbabilitiesTableHeaderRow.add("Component");
			componentsServiceFailureProbabilitiesTableHeaderRow.add("Interface");
			componentsServiceFailureProbabilitiesTableHeaderRow.add("Failure Probability");
			componentsServiceFailureProbabilitiesTable.setHeaderRow(componentsServiceFailureProbabilitiesTableHeaderRow);

			// componentsServiceOperationFailureProbabilities
			MarkovReportingTable componentsServiceOperationFailureProbabilitiesTable = new MarkovReportingTable("Component operation failure impacts");
			List<String> componentsServiceOperationFailureProbabilitiesTableHeaderRow = new ArrayList<String>(4);
			componentsServiceOperationFailureProbabilitiesTableHeaderRow.add("Component");
			componentsServiceOperationFailureProbabilitiesTableHeaderRow.add("Interface");
			componentsServiceOperationFailureProbabilitiesTableHeaderRow.add("Signature");
			componentsServiceOperationFailureProbabilitiesTableHeaderRow.add("Failure Probability");
			componentsServiceOperationFailureProbabilitiesTable.setHeaderRow(componentsServiceOperationFailureProbabilitiesTableHeaderRow);

			// externalServiceFailureProbabilities
			MarkovReportingTable externalServiceFailureProbabilitiesTable = new MarkovReportingTable("External service failure impacts");
			List<String> externalServiceFailureProbabilitiesTableHeaderRow = new ArrayList<String>(4);
			externalServiceFailureProbabilitiesTableHeaderRow.add("System-required Role");
			externalServiceFailureProbabilitiesTableHeaderRow.add("Interface");
			externalServiceFailureProbabilitiesTableHeaderRow.add("Failure Probability");
			externalServiceFailureProbabilitiesTable.setHeaderRow(externalServiceFailureProbabilitiesTableHeaderRow);

			// externalServiceOperationFailureProbabilities
			MarkovReportingTable externalServiceOperationFailureProbabilitiesTable = new MarkovReportingTable("External operation failure impacts");
			List<String> externalServiceOperationFailureProbabilitiesTableHeaderRow = new ArrayList<String>(4);
			externalServiceOperationFailureProbabilitiesTableHeaderRow.add("System-required Role");
			externalServiceOperationFailureProbabilitiesTableHeaderRow.add("Interface");
			externalServiceOperationFailureProbabilitiesTableHeaderRow.add("Signature");
			externalServiceOperationFailureProbabilitiesTableHeaderRow.add("Failure Probability");
			externalServiceOperationFailureProbabilitiesTable.setHeaderRow(externalServiceOperationFailureProbabilitiesTableHeaderRow);

			/**
			 * ... by creating a table row for each failure probability aggregation, and adding
			 * this row to the according table.
			 */
			for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
				switch (aggregation.getType()) {
				case COMPONENTS_INTERNAL_ACTIONS:
					List<String> componentsInternalActionFailureProbabilitiesTableRow = new ArrayList<String>(componentsInternalActionFailureProbabilitiesTableHeaderRow.size());	// create new row
					for (String entityNamePart : aggregation.getEntityNameParts()) {	// add name parts to row; one column per name part
						componentsInternalActionFailureProbabilitiesTableRow.add(entityNamePart);
					}
					componentsInternalActionFailureProbabilitiesTableRow.add(Double.toString(aggregation.getFailureProbability()));	// also add failure probability to this row
					componentsInternalActionFailureProbabilitiesTable.addRow(componentsInternalActionFailureProbabilitiesTableRow);	// insert row into table
					break;
				case COMPONENTS_SERVICES:
					List<String> componentsServicesFailureProbabilitiesTableRow = new ArrayList<String>(componentsServiceFailureProbabilitiesTableHeaderRow.size());	// create new row
					for (String entityNamePart : aggregation.getEntityNameParts()) {	// add name parts to row; one column per name part
						componentsServicesFailureProbabilitiesTableRow.add(entityNamePart);
					}
					componentsServicesFailureProbabilitiesTableRow.add(Double.toString(aggregation.getFailureProbability()));	// also add failure probability to this row
					componentsServiceFailureProbabilitiesTable.addRow(componentsServicesFailureProbabilitiesTableRow);	// insert row into table
					break;
				case COMPONENTS_SERVICE_OPERATIONS:
					List<String> componentsServiceOperationFailureProbabilitiesTableRow = new ArrayList<String>(componentsServiceOperationFailureProbabilitiesTableHeaderRow.size());	// create new row
					for (String entityNamePart : aggregation.getEntityNameParts()) {	// add name parts to row; one column per name part
						componentsServiceOperationFailureProbabilitiesTableRow.add(entityNamePart);
					}
					componentsServiceOperationFailureProbabilitiesTableRow.add(Double.toString(aggregation.getFailureProbability()));	// also add failure probability to this row
					componentsServiceOperationFailureProbabilitiesTable.addRow(componentsServiceOperationFailureProbabilitiesTableRow);	// insert row into table
					break;
				case EXTERNAL_SERVICES:
					List<String> externalServiceFailureProbabilitiesTableRow = new ArrayList<String>(externalServiceFailureProbabilitiesTableHeaderRow.size());	// create new row
					for (String entityNamePart : aggregation.getEntityNameParts()) {	// add name parts to row; one column per name part
						externalServiceFailureProbabilitiesTableRow.add(entityNamePart);
					}
					externalServiceFailureProbabilitiesTableRow.add(Double.toString(aggregation.getFailureProbability()));	// also add failure probability to this row
					externalServiceFailureProbabilitiesTable.addRow(externalServiceFailureProbabilitiesTableRow);	// insert row into table
					break;
				case EXTERNAL_SERVICE_OPERATIONS:
					List<String> externalServiceOperationFailureProbabilitiesTableRow = new ArrayList<String>(externalServiceFailureProbabilitiesTableHeaderRow.size());	// create new row
					for (String entityNamePart : aggregation.getEntityNameParts()) {	// add name parts to row; one column per name part
						externalServiceOperationFailureProbabilitiesTableRow.add(entityNamePart);
					}
					externalServiceOperationFailureProbabilitiesTableRow.add(Double.toString(aggregation.getFailureProbability()));	// also add failure probability to this row
					externalServiceOperationFailureProbabilitiesTable.addRow(externalServiceOperationFailureProbabilitiesTableRow);	// insert row into table
					break;
				default:
					break;
				}
			}

			/**
			 * Finally, add the tables to our report item.
			 */
			markovReportItem.addTable(componentsInternalActionFailureProbabilitiesTable);
			markovReportItem.addTable(componentsServiceFailureProbabilitiesTable);
			markovReportItem.addTable(componentsServiceOperationFailureProbabilitiesTable);
			markovReportItem.addTable(externalServiceFailureProbabilitiesTable);
			markovReportItem.addTable(externalServiceOperationFailureProbabilitiesTable);
		}
		/**
		 * Add this report item to our list of report items.
		 */
		markovReportItems.add(markovReportItem);
	}

	/**
	 * Returns a list of Markov report items that were generated from the
	 * Markov transformation results.
	 * @return a list of Markov report items
	 */
	public List<MarkovReportItem> getMarkovReportItems() {
		return markovReportItems;
	}

//	/**
//	 * Prints the accumulated failure probabilities.
//	 */
//	public void print() {
//		printComponentsInternalActionFailureProbabilities();
//		printComponentsServiceFailureProbabilities();
//		printComponentsServiceOperationFailureProbabilities();
//		printExternalServiceFailureProbabilities();
//		printExternalServiceOperationFailureProbabilities();
//	}
//
//	/**
//	 * Gets the accumulated failure probabilities as textual representation, i.e.,
//	 * as list of strings.
//	 * @return a list of strings containing the accumulated failure probabilities
//	 */
//	public List<String> getTextualResults() {
//		List<String> resultList = new ArrayList<String>();
//
//		resultList.addAll(getComponentsInternalActionFailureProbabilitiesAsStringList());
//		resultList.addAll(getComponentsServiceFailureProbabilitiesAsStringList());
//		resultList.addAll(getComponentsServiceOperationFailureProbabilitiesAsStringList());
//		resultList.addAll(getExternalServiceFailureProbabilitiesAsStringList());
//		resultList.addAll(getExternalServiceOperationFailureProbabilitiesAsStringList());
//
//		return resultList;
//	}

	/**
	 * Calculates all components' internal action failure probabilities for
	 * later output.
	 */
	private void calculateComponentsInternalActionFailureProbabilities(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
			if (!failureType.isSystemExternal()) { // only consider (internal) components
				if (failureType instanceof MarkovSoftwareInducedFailureType) {
					MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;

					/*
					 * If the component ID is not in our data structure, we will
					 * add a new entry to it. If the component ID is already in
					 * the data structure, we will not add it again, but we will
					 * add to (the existing failure probability) the current
					 * failure type's probability.
					 */
					boolean foundEntry = false;
					List<String> identifiers = new ArrayList<String>(1);
					identifiers.add(softwareInducedFailureType.getComponentId());
					List<String> nameParts = new ArrayList<String>(1);
					nameParts.add(softwareInducedFailureType.getComponentName());
					for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
						if (aggregation.compareToIdentifier(FailureAggregationType.COMPONENTS_INTERNAL_ACTIONS, identifiers)) {
							// this component ID is already in our data
							// structure, therefore we do not
							// add a new entry, but update the existing one
							// accordingly
							aggregation.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities.get(failureType));
							foundEntry = true;
							break; // found and updated the entry, so we are done
						}
					}
					if (!foundEntry) {
						// we did not find a fitting entry, so we add a new one and set its values accordingly
						failureProbabilityAggregations.add(new FailureProbabilityAggregation(
										FailureAggregationType.COMPONENTS_INTERNAL_ACTIONS,
										identifiers,
										nameParts,
										cumulatedFailureTypeProbabilities.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 * Calculates all components' service (interface) failure probabilities for
	 * later output.
	 */
	private void calculateComponentsServiceFailureProbabilities(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
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
					for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
						if (aggregation.compareToIdentifier(FailureAggregationType.COMPONENTS_SERVICES, identifiers)) {
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
						failureProbabilityAggregations.add(new FailureProbabilityAggregation(
								FailureAggregationType.COMPONENTS_SERVICES,
								identifiers,
								nameParts,
								cumulatedFailureTypeProbabilities.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 * Calculates all components' service operation (signature) failure
	 * probabilities for later output.
	 */
	private void calculateComponentsServiceOperationFailureProbabilities(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
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
					for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
						if (aggregation.compareToIdentifier(FailureAggregationType.COMPONENTS_SERVICE_OPERATIONS, identifiers)) {
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
						failureProbabilityAggregations.add(new FailureProbabilityAggregation(
								FailureAggregationType.COMPONENTS_SERVICE_OPERATIONS,
								identifiers,
								nameParts,
								cumulatedFailureTypeProbabilities.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 * Calculates all external service (role and interface) failure
	 * probabilities for later output.
	 */
	private void calculateExternalServiceFailureProbabilities(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
			if (failureType.isSystemExternal()) { // only consider external
													// services
				boolean foundEntry = false;
				List<String> identifiers = new ArrayList<String>(2);
				identifiers.add(failureType.getRoleId());
				identifiers.add(failureType.getInterfaceId());
				List<String> nameParts = new ArrayList<String>(2);
				nameParts.add(failureType.getRoleName());
				nameParts.add(failureType.getInterfaceName());
				for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
					if (aggregation.compareToIdentifier(
							FailureAggregationType.EXTERNAL_SERVICES,
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
					failureProbabilityAggregations.add(new FailureProbabilityAggregation(
									FailureAggregationType.EXTERNAL_SERVICES,
									identifiers,
									nameParts,
									cumulatedFailureTypeProbabilities.get(failureType)));
				}
			}
		}
	}

	/**
	 * Calculates all external service operation (signature) failure
	 * probabilities for later output.
	 */
	private void calculateExternalServiceOperationFailureProbabilities(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
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
				for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
					if (aggregation.compareToIdentifier(
							FailureAggregationType.EXTERNAL_SERVICE_OPERATIONS,
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
					failureProbabilityAggregations.add(new FailureProbabilityAggregation(
									FailureAggregationType.EXTERNAL_SERVICE_OPERATIONS,
									identifiers,
									nameParts,
									cumulatedFailureTypeProbabilities.get(failureType)));
				}
			}
		}
	}

//	/**
//	 * Method used for printing all components' internal action failure
//	 * probabilities.
//	 */
//	public void printComponentsInternalActionFailureProbabilities() {
//		boolean hasEntries = false;
//		MarkovResultPrinter printer = new MarkovResultPrinter();
//		logger.info("Component failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.COMPONENTS_INTERNAL_ACTIONS) {
//				if (doApproximate) {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//				} else {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			logger.info(" (none)");
//		}
//	}
//
//	/**
//	 * Method used for printing all components' service (interface) failure
//	 * probabilities.
//	 */
//	public void printComponentsServiceFailureProbabilities() {
//		boolean hasEntries = false;
//		MarkovResultPrinter printer = new MarkovResultPrinter();
//		logger.info("Component service failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.COMPONENTS_SERVICES) {
//				if (doApproximate) {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//				} else {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			logger.info(" (none)");
//		}
//	}
//
//	/**
//	 * Method used for printing all components' service operation (signature)
//	 * failure probabilities.
//	 */
//	public void printComponentsServiceOperationFailureProbabilities() {
//		boolean hasEntries = false;
//		MarkovResultPrinter printer = new MarkovResultPrinter();
//		logger.info("Component operation failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.COMPONENTS_SERVICE_OPERATIONS) {
//				if (doApproximate) {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//				} else {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			logger.info(" (none)");
//		}
//	}
//
//	/**
//	 * Method used for printing all external service (role and interface)
//	 * failure probabilities.
//	 */
//	public void printExternalServiceFailureProbabilities() {
//		boolean hasEntries = false;
//		MarkovResultPrinter printer = new MarkovResultPrinter();
//		logger.info("External service failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.EXTERNAL_SERVICES) {
//				if (doApproximate) {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//				} else {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			logger.info(" (none)");
//		}
//	}
//
//	/**
//	 * Method used for printing all external service operation (signature)
//	 * failure probabilities.
//	 */
//	public void printExternalServiceOperationFailureProbabilities() {
//		boolean hasEntries = false;
//		MarkovResultPrinter printer = new MarkovResultPrinter();
//		logger.info("External operation failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.EXTERNAL_SERVICE_OPERATIONS) {
//				if (doApproximate) {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//				} else {
//					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			logger.info(" (none)");
//		}
//	}
//
//	/**
//	 * Gets all components' internal action failure probabilities as list of strings.
//	 * @return the components' internal action failure probabilities as list of strings
//	 */
//	public List<String> getComponentsInternalActionFailureProbabilitiesAsStringList() {
//		boolean hasEntries = false;
//		List<String> resultList = new ArrayList<String>();
//
//		resultList.add("Component failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.COMPONENTS_INTERNAL_ACTIONS) {
//				if (doApproximate) {
//					MarkovResultApproximation approximation = new MarkovResultApproximation(
//							aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//					resultList.add(String.format("- %1$-3s %2$." + (approximation.getAccuracy() + 1) + "f - %3$."
//							+ (approximation.getAccuracy() + 1) + "f", aggregation.getEntityName() + ":",
//							approximation.getAdjustedLowerBound(), approximation.getAdjustedUpperBound()));
//				} else {
//					resultList.add(String.format("- %1$-3s %2$.11f", aggregation.getEntityName() + ":",
//							aggregation.getFailureProbability()));
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			resultList.add(" (none)");
//		}
//
//		return resultList;
//	}
//
//	/**
//	 * Gets all components' service (interface) failure probabilities as list of strings.
//	 * @return the components' service (interface) failure probabilities as list of strings
//	 */
//	public List<String> getComponentsServiceFailureProbabilitiesAsStringList() {
//		boolean hasEntries = false;
//		List<String> resultList = new ArrayList<String>();
//
//		resultList.add("Component service failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.COMPONENTS_SERVICES) {
//				if (doApproximate) {
//					MarkovResultApproximation approximation = new MarkovResultApproximation(
//							aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//					resultList.add(String.format("- %1$-3s %2$." + approximation.getAccuracy() + 1 + "f - %3$."
//							+ approximation.getAccuracy() + 1 + "f", aggregation.getEntityName() + ":",
//							approximation.getAdjustedLowerBound(), approximation.getAdjustedUpperBound()));
//				} else {
//					resultList.add(String.format("- %1$-3s %2$.11f", aggregation.getEntityName() + ":",
//							aggregation.getFailureProbability()));
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			resultList.add(" (none)");
//		}
//
//		return resultList;
//	}
//
//	/**
//	 * Gets all components' service operation (signature) failure probabilities as list of strings.
//	 * @return the components' service operation (signature) failure probabilities as list of strings
//	 */
//	public List<String> getComponentsServiceOperationFailureProbabilitiesAsStringList() {
//		boolean hasEntries = false;
//		List<String> resultList = new ArrayList<String>();
//
//		resultList.add("Component operation failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.COMPONENTS_SERVICE_OPERATIONS) {
//				if (doApproximate) {
//					MarkovResultApproximation approximation = new MarkovResultApproximation(
//							aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//					resultList.add(String.format("- %1$-3s %2$." + approximation.getAccuracy() + 1 + "f - %3$."
//							+ approximation.getAccuracy() + 1 + "f", aggregation.getEntityName() + ":",
//							approximation.getAdjustedLowerBound(), approximation.getAdjustedUpperBound()));
//				} else {
//					resultList.add(String.format("- %1$-3s %2$.11f", aggregation.getEntityName() + ":",
//							aggregation.getFailureProbability()));
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			resultList.add(" (none)");
//		}
//
//		return resultList;
//	}
//
//	/**
//	 * Gets all external service (role and interface) failure probabilities as list of strings.
//	 * @return the external service (role and interface) failure probabilities as list of strings
//	 */
//	public List<String> getExternalServiceFailureProbabilitiesAsStringList() {
//		boolean hasEntries = false;
//		List<String> resultList = new ArrayList<String>();
//
//		resultList.add("External service failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.EXTERNAL_SERVICES) {
//				if (doApproximate) {
//					MarkovResultApproximation approximation = new MarkovResultApproximation(
//							aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//					resultList.add(String.format("- %1$-3s %2$." + approximation.getAccuracy() + 1 + "f - %3$."
//							+ approximation.getAccuracy() + 1 + "f", aggregation.getEntityName() + ":",
//							approximation.getAdjustedLowerBound(), approximation.getAdjustedUpperBound()));
//				} else {
//					resultList.add(String.format("- %1$-3s %2$.11f", aggregation.getEntityName() + ":",
//							aggregation.getFailureProbability()));
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			resultList.add(" (none)");
//		}
//
//		return resultList;
//	}
//
//	/**
//	 * Gets all external service operation (signature) failure probabilities as list of strings.
//	 * @return the external service operation (signature) failure probabilities as list of strings
//	 */
//	public List<String> getExternalServiceOperationFailureProbabilitiesAsStringList() {
//		boolean hasEntries = false;
//		List<String> resultList = new ArrayList<String>();
//
//		resultList.add("External service failure probabilities:");
//		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
//			if (aggregation.getType() == FailureAggregationType.EXTERNAL_SERVICE_OPERATIONS) {
//				if (doApproximate) {
//					MarkovResultApproximation approximation = new MarkovResultApproximation(
//							aggregation.getFailureProbability(),
//							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
//					resultList.add(String.format("- %1$-3s %2$." + approximation.getAccuracy() + 1 + "f - %3$."
//							+ approximation.getAccuracy() + 1 + "f", aggregation.getEntityName() + ":",
//							approximation.getAdjustedLowerBound(), approximation.getAdjustedUpperBound()));
//				} else {
//					resultList.add(String.format("- %1$-3s %2$.11f", aggregation.getEntityName() + ":",
//							aggregation.getFailureProbability()));
//				}
//				hasEntries = true;
//			}
//		}
//		if (!hasEntries) {
//			resultList.add(" (none)");
//		}
//
//		return resultList;
//	}
}
