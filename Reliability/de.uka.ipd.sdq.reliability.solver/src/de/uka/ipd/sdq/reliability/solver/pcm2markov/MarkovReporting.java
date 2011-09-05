package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType;

/**
 * Class used for aggregation and output of failure probabilities that were
 * calculated during a reliability analysis.
 * 
 * @author Daniel Patejdl
 * 
 */
public class MarkovReporting {
	/**
	 * Overall failure type probabilities, accumulated over all considered
	 * physical system states.
	 */
	private Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities;

	/**
	 * Overall physical state probability, accumulated over all considered
	 * physical system states.
	 */
	private double cumulatedPhysicalStateProbability;

//	/**
//	 * Whether result approximation is enabled or not.
//	 */
//	private boolean doApproximate;

	/**
	 * A logger to give detailed information about the PCM instance
	 * transformation.
	 */
	private static Logger logger = Logger.getLogger(MarkovReporting.class
			.getName());

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
	 * Consider all Markov transformation results: For each such result we will
	 * calculate the probabilities of interest, and then enclose them in a MarkovResultItem
	 * for further processing.
	 */
	private void createMarkovReportItems() {
		Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities = null;
		double cumulatedPhysicalStateProbability = 0;
		// TODO consider "doApproximate" functionality (use cumulatedPhysicalStateProbability for this)
		UsageScenario scenario = null;
		MarkovReportListItem markovReportItem = null;	// TODO Add "list or table" functionality. For now, we assume lists.
		for (MarkovTransformationResult markovResult : markovResults) {
			cumulatedFailureTypeProbabilities = markovResult.getCumulatedFailureTypeProbabilities();
			cumulatedPhysicalStateProbability = markovResult.getCumulatedPhysicalStateProbability();
			scenario = markovResult.getScenario();

			// create a new Markov report item using the data of this scenario
			markovReportItem = new MarkovReportListItem(scenario.getEntityName(), scenario.getId(),
					markovResult.getSuccessProbability());

			// calculate accumulated failure probabilities
			calculateComponentsInternalActionFailureProbabilities(cumulatedFailureTypeProbabilities);
			calculateComponentsServiceFailureProbabilities(cumulatedFailureTypeProbabilities);
			calculateComponentsServiceOperationFailureProbabilities(cumulatedFailureTypeProbabilities);
			calculateExternalServiceFailureProbabilities(cumulatedFailureTypeProbabilities);
			calculateExternalServiceOperationFailureProbabilities(cumulatedFailureTypeProbabilities);

			// insert calculated failure probabilities into report
			List<String> componentsInternalActionFailureProbabilitiesLines = new ArrayList<String>();
			List<String> componentsServiceFailureProbabilitiesLines = new ArrayList<String>();
			List<String> componentsServiceOperationFailureProbabilitiesLines = new ArrayList<String>();
			List<String> externalServiceFailureProbabilitiesLines = new ArrayList<String>();
			List<String> externalServiceOperationFailureProbabilitiesLines = new ArrayList<String>();
			componentsInternalActionFailureProbabilitiesLines.add("Component failure probabilities:");
			componentsServiceFailureProbabilitiesLines.add("Component service failure probabilities:");
			componentsServiceOperationFailureProbabilitiesLines.add("Component operation failure probabilities:");
			externalServiceFailureProbabilitiesLines.add("External service failure probabilities:");
			externalServiceOperationFailureProbabilitiesLines.add("External operation failure probabilities:");
			for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
				String entityName = "";
				for (String namePart : aggregation.getEntityNameParts()) {
					entityName += namePart + "/";
				}
				entityName = entityName.substring(0, entityName.length() - 1);	// remove last "/"	TODO better solution?
				switch (aggregation.getType()) {
					case COMPONENTS_INTERNAL_ACTIONS:
						componentsInternalActionFailureProbabilitiesLines.add(entityName + ": " + aggregation.getFailureProbability());
						break;
					case COMPONENTS_SERVICES:
						componentsServiceFailureProbabilitiesLines.add(entityName + ": " + aggregation.getFailureProbability());
						break;
					case COMPONENTS_SERVICE_OPERATIONS:
						componentsServiceOperationFailureProbabilitiesLines.add(entityName + ": " + aggregation.getFailureProbability());
						break;
					case EXTERNAL_SERVICES:
						externalServiceFailureProbabilitiesLines.add(entityName + ": " + aggregation.getFailureProbability());
						break;
					case EXTERNAL_SERVICE_OPERATIONS:
						externalServiceOperationFailureProbabilitiesLines.add(entityName + ": " + aggregation.getFailureProbability());
						break;
					default:
						break;
				}
			}
			markovReportItem.addEntry(componentsInternalActionFailureProbabilitiesLines);
			markovReportItem.addEntry(componentsServiceFailureProbabilitiesLines);
			markovReportItem.addEntry(componentsServiceOperationFailureProbabilitiesLines);
			markovReportItem.addEntry(externalServiceFailureProbabilitiesLines);
			markovReportItem.addEntry(externalServiceOperationFailureProbabilitiesLines);

			// add this report item to our list
			markovReportItems.add(markovReportItem);
		}
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
