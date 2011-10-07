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
import de.uka.ipd.sdq.reliability.solver.pcm2markov.FailureAggregationType;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.FailureProbabilityAggregation;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovResultApproximation;
import de.uka.ipd.sdq.reliability.solver.pcm2markov.MarkovTransformationResult;

/**
 * Class used for aggregation and output of success/failure probabilities that were
 * calculated during a reliability analysis.
 * 
 * @author Daniel Patejdl
 * 
 */
public class MarkovReporting {
	/**
	 * List of aggregated results of a PCM2MarkovTransformation
	 */
	private List<MarkovTransformationResult> markovResults;

	/**
	 * Configuration properties for the reliability solver workflow.
	 */
	PCMSolverWorkflowRunConfiguration configuration;

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

	/**
	 * Creates a new MarkovReporting instance that is used for result aggregation according
	 * to the given Markov transformation results.
	 * 
	 * @param markovResults the Markov transformation results
	 * @param config the configuration properties for the reliability solver workflow
	 */
	public MarkovReporting(List<MarkovTransformationResult> markovResults, PCMSolverWorkflowRunConfiguration configuration) {
		this.markovResults = markovResults;
		this.configuration = configuration;
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

	private String getFormattedProbabilityAsString(double probability) {
		return String.format("%1$.11f", probability);
	}

	private String getFormattedProbabilityAsString(double lowerBound, double upperBound) {
		MarkovResultApproximation approximation = new MarkovResultApproximation(
				lowerBound, upperBound);
		int places = approximation.getAccuracy() + 1;
		return String.format("%1$." + places + "f - %2$."
				+ places + "f", approximation.getAdjustedLowerBound(),
				approximation.getAdjustedUpperBound());
	}

	/*
	 * Consider all Markov transformation results: For each such result we will
	 * calculate the probabilities of interest, and then enclose them in a MarkovResultItem
	 * for further processing.
	 */
	private void createMarkovReportItems() {
		Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities = null;
		double cumulatedPhysicalStateProbability = 0;
		boolean doApproximate = false;
		double cumulatedSuccessProbability = -1.0;	// error value
		
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
				markovReportItem = new MarkovReportItem(
						scenario.getEntityName(),
						scenario.getId(),
						getFormattedProbabilityAsString(cumulatedSuccessProbability,
								cumulatedSuccessProbability + 1 - cumulatedPhysicalStateProbability));
			} else {
				markovReportItem = new MarkovReportItem(
						scenario.getEntityName(),
						scenario.getId(),
						getFormattedProbabilityAsString(cumulatedSuccessProbability));
			}

			/*
			 * Create failure mode tables first.
			 */
			TreeSet<MarkovFailureType> failureTypesSorted = getFailureTypesSorted(cumulatedFailureTypeProbabilities);

			/*
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

			/*
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
						externalSoftwareFailuresTableRow
								.add(doApproximate ? getFormattedProbabilityAsString(
										getFailureTypeProbability(
												softwareInducedFailureType,
												cumulatedFailureTypeProbabilities),
										getFailureTypeProbability(
												softwareInducedFailureType,
												cumulatedFailureTypeProbabilities)
												+ 1
												- cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(getFailureTypeProbability(
												softwareInducedFailureType,
												cumulatedFailureTypeProbabilities)));
						externalSoftwareFailuresTable.addRow(externalSoftwareFailuresTableRow);
					} else if (failureType instanceof MarkovHardwareInducedFailureType) {
						MarkovHardwareInducedFailureType hardwareInducedFailureType = (MarkovHardwareInducedFailureType) failureType;
						externalHardwareFailuresTableRow = new ArrayList<String>(externalHardwareFailuresTableHeaderRow.size());
						externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getRoleName());
						externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getSignatureName());
						externalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceTypeName());
						externalHardwareFailuresTableRow
								.add(doApproximate ? getFormattedProbabilityAsString(
										getFailureTypeProbability(
												hardwareInducedFailureType,
												cumulatedFailureTypeProbabilities),
										getFailureTypeProbability(
												hardwareInducedFailureType,
												cumulatedFailureTypeProbabilities)
												+ 1
												- cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(getFailureTypeProbability(
												hardwareInducedFailureType,
												cumulatedFailureTypeProbabilities)));
						externalHardwareFailuresTable.addRow(externalHardwareFailuresTableRow);
					} else if (failureType instanceof MarkovNetworkInducedFailureType) {
						MarkovNetworkInducedFailureType networkInducedFailureType = (MarkovNetworkInducedFailureType) failureType;
						externalNetworkFailuresTableRow = new ArrayList<String>(externalNetworkFailuresTableHeaderRow.size());
						externalNetworkFailuresTableRow.add(networkInducedFailureType.getRoleName());
						externalNetworkFailuresTableRow.add(networkInducedFailureType.getSignatureName());
						externalNetworkFailuresTableRow.add(networkInducedFailureType.getCommLinkResourceTypeName());
						externalNetworkFailuresTableRow
								.add(doApproximate ? getFormattedProbabilityAsString(
										getFailureTypeProbability(
												networkInducedFailureType,
												cumulatedFailureTypeProbabilities),
										getFailureTypeProbability(
												networkInducedFailureType,
												cumulatedFailureTypeProbabilities)
												+ 1
												- cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(getFailureTypeProbability(
												networkInducedFailureType,
												cumulatedFailureTypeProbabilities)));
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
						internalSoftwareFailuresTableRow
								.add(doApproximate ? getFormattedProbabilityAsString(
										getFailureTypeProbability(
												softwareInducedFailureType,
												cumulatedFailureTypeProbabilities),
										getFailureTypeProbability(
												softwareInducedFailureType,
												cumulatedFailureTypeProbabilities)
												+ 1
												- cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(getFailureTypeProbability(
												softwareInducedFailureType,
												cumulatedFailureTypeProbabilities)));
						internalSoftwareFailuresTable.addRow(internalSoftwareFailuresTableRow);
					} else if (failureType instanceof MarkovHardwareInducedFailureType) {
						MarkovHardwareInducedFailureType hardwareInducedFailureType = (MarkovHardwareInducedFailureType) failureType;
						internalHardwareFailuresTableRow = new ArrayList<String>(internalHardwareFailuresTableHeaderRow.size());
						internalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceContainerName());
						internalHardwareFailuresTableRow.add(hardwareInducedFailureType.getResourceTypeName());
						internalHardwareFailuresTableRow
								.add(doApproximate ? getFormattedProbabilityAsString(
										getFailureTypeProbability(
												hardwareInducedFailureType,
												cumulatedFailureTypeProbabilities),
										getFailureTypeProbability(
												hardwareInducedFailureType,
												cumulatedFailureTypeProbabilities)
												+ 1
												- cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(getFailureTypeProbability(
												hardwareInducedFailureType,
												cumulatedFailureTypeProbabilities)));
						internalHardwareFailuresTable.addRow(internalHardwareFailuresTableRow);
					} else if (failureType instanceof MarkovNetworkInducedFailureType) {
						MarkovNetworkInducedFailureType networkInducedFailureType = (MarkovNetworkInducedFailureType) failureType;
						internalNetworkFailuresTableRow = new ArrayList<String>(internalNetworkFailuresTableHeaderRow.size());
						internalNetworkFailuresTableRow.add(networkInducedFailureType.getLinkingResourceName());
						internalNetworkFailuresTableRow.add(networkInducedFailureType.getCommLinkResourceTypeName());
						internalNetworkFailuresTableRow
								.add(doApproximate ? getFormattedProbabilityAsString(
										getFailureTypeProbability(
												networkInducedFailureType,
												cumulatedFailureTypeProbabilities),
										getFailureTypeProbability(
												networkInducedFailureType,
												cumulatedFailureTypeProbabilities)
												+ 1
												- cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(getFailureTypeProbability(
												networkInducedFailureType,
												cumulatedFailureTypeProbabilities)));
						internalNetworkFailuresTable.addRow(internalNetworkFailuresTableRow);
					}
				}
			}

			/*
			 * Finally, add the generated failure mode tables to our report item.
			 */
			markovReportItem.addFailureModeTable(internalSoftwareFailuresTable);
			markovReportItem.addFailureModeTable(internalHardwareFailuresTable);
			markovReportItem.addFailureModeTable(internalNetworkFailuresTable);
			markovReportItem.addFailureModeTable(externalSoftwareFailuresTable);
			markovReportItem.addFailureModeTable(externalHardwareFailuresTable);
			markovReportItem.addFailureModeTable(externalNetworkFailuresTable);

			/*
			 * Calculate accumulated failure probabilities if our configuration is set accordingly.
			 * Otherwise, we are done at this point.
			 */
			if (MarkovEvaluationType.valueOf(configuration.getMarkovEvaluationMode()) == MarkovEvaluationType.POINTSOFFAILURE) {
				calculateComponentsInternalActionFailureProbabilities(cumulatedFailureTypeProbabilities);
				calculateComponentsServiceFailureProbabilities(cumulatedFailureTypeProbabilities);
				calculateComponentsServiceOperationFailureProbabilities(cumulatedFailureTypeProbabilities);
				calculateExternalServiceFailureProbabilities(cumulatedFailureTypeProbabilities);
				calculateExternalServiceOperationFailureProbabilities(cumulatedFailureTypeProbabilities);
				/*
				 * Now, create impact analysis tables. Insert calculated failure probabilities into report...
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
				/*
				 * ... by creating a table row for each failure probability aggregation, and adding
				 * this row to the according impact analysis table.
				 */
				double failureProbability = -1.0;	// error value
				for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
					failureProbability = aggregation.getFailureProbability();
					switch (aggregation.getType()) {
					case COMPONENTS_INTERNAL_ACTIONS:
						List<String> componentsInternalActionFailureProbabilitiesTableRow = new ArrayList<String>(
								componentsInternalActionFailureProbabilitiesTableHeaderRow.size()); // create new row
						for (String entityNamePart : aggregation.getEntityNameParts()) { // add name parts to row; one column per name part
							componentsInternalActionFailureProbabilitiesTableRow.add(entityNamePart);
						}
						componentsInternalActionFailureProbabilitiesTableRow.add(
								doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(failureProbability)); // also add failure probability to this row
						componentsInternalActionFailureProbabilitiesTable.addRow(componentsInternalActionFailureProbabilitiesTableRow); // insert row into table
						break;
					case COMPONENTS_SERVICES:
						List<String> componentsServicesFailureProbabilitiesTableRow = new ArrayList<String>(
								componentsServiceFailureProbabilitiesTableHeaderRow.size()); // create new row
						for (String entityNamePart : aggregation.getEntityNameParts()) { // add name parts to row; one column per name part
							componentsServicesFailureProbabilitiesTableRow.add(entityNamePart);
						}
						componentsServicesFailureProbabilitiesTableRow.add(
								doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(failureProbability)); // also add failure probability to this row
						componentsServiceFailureProbabilitiesTable.addRow(componentsServicesFailureProbabilitiesTableRow); // insert row into table
						break;
					case COMPONENTS_SERVICE_OPERATIONS:
						List<String> componentsServiceOperationFailureProbabilitiesTableRow = new ArrayList<String>(
								componentsServiceOperationFailureProbabilitiesTableHeaderRow.size()); // create new row
						for (String entityNamePart : aggregation.getEntityNameParts()) { // add name parts to row; one column per name part
							componentsServiceOperationFailureProbabilitiesTableRow.add(entityNamePart);
						}
						componentsServiceOperationFailureProbabilitiesTableRow.add(
								doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(failureProbability)); // also add failure probability to this row
						componentsServiceOperationFailureProbabilitiesTable.addRow(componentsServiceOperationFailureProbabilitiesTableRow); // insert row into table
						break;
					case EXTERNAL_SERVICES:
						List<String> externalServiceFailureProbabilitiesTableRow = new ArrayList<String>(
								externalServiceFailureProbabilitiesTableHeaderRow .size()); // create new row
						for (String entityNamePart : aggregation.getEntityNameParts()) { // add name parts to row; one column per name part
							externalServiceFailureProbabilitiesTableRow.add(entityNamePart);
						}
						externalServiceFailureProbabilitiesTableRow.add(
								doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(failureProbability)); // also add failure probability to this row
						externalServiceFailureProbabilitiesTable.addRow(externalServiceFailureProbabilitiesTableRow); // insert row into table
						break;
					case EXTERNAL_SERVICE_OPERATIONS:
						List<String> externalServiceOperationFailureProbabilitiesTableRow = new ArrayList<String>(
								externalServiceFailureProbabilitiesTableHeaderRow.size()); // create new row
						for (String entityNamePart : aggregation.getEntityNameParts()) { // add name parts to row; one column per name part
							externalServiceOperationFailureProbabilitiesTableRow.add(entityNamePart);
						}
						externalServiceOperationFailureProbabilitiesTableRow.add(
								doApproximate ? getFormattedProbabilityAsString(failureProbability, failureProbability + 1 - cumulatedPhysicalStateProbability)
										: getFormattedProbabilityAsString(failureProbability)); // also add failure probability to this row
						externalServiceOperationFailureProbabilitiesTable.addRow(externalServiceOperationFailureProbabilitiesTableRow); // insert row into table
						break;
					default:
						break;
					}
				}
				/*
				 * Finally, add the tables to our report item.
				 */
				markovReportItem.addImpactAnalysisTable(componentsInternalActionFailureProbabilitiesTable);
				markovReportItem.addImpactAnalysisTable(componentsServiceFailureProbabilitiesTable);
				markovReportItem.addImpactAnalysisTable(componentsServiceOperationFailureProbabilitiesTable);
				markovReportItem.addImpactAnalysisTable(externalServiceFailureProbabilitiesTable);
				markovReportItem.addImpactAnalysisTable(externalServiceOperationFailureProbabilitiesTable);
			}
		}
		/*
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
}
