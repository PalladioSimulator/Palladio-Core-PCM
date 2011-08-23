package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

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

	/**
	 * Whether result approximation is enabled or not.
	 */
	private boolean doApproximate;

	/**
	 * A logger to give detailed information about the PCM instance
	 * transformation.
	 */
	private static Logger logger = Logger.getLogger(MarkovReporting.class
			.getName());

	/**
	 * Will store the overall failure probabilities of entities (components'
	 * internal actions, their services and service operations, external
	 * services and their operations).
	 */
	List<FailureProbabilityAggregation> failureProbabilityAggregations;

	/**
	 * Creates a new MarkovReporting instance that is used for result
	 * aggregation according to the given accumulated failure type
	 * probabilities.
	 * 
	 * @param cumulatedFailureTypeProbabilities
	 *            the overall failure type probabilities, accumulated over all
	 *            considered physical system states.
	 * @param doApproximate
	 *            whether result approximation is enabled or not
	 * @param cumulatedPhysicalStateProbability
	 *            the overall physical state probability, accumulated over all
	 *            considered physical system states.
	 */
	public MarkovReporting(
			Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities,
			double cumulatedPhysicalStateProbability, boolean doApproximate) {
		this.cumulatedFailureTypeProbabilities = cumulatedFailureTypeProbabilities;
		this.cumulatedPhysicalStateProbability = cumulatedPhysicalStateProbability;
		this.doApproximate = doApproximate;

		failureProbabilityAggregations = new ArrayList<FailureProbabilityAggregation>();

		// calculate accumulated component as well as external service failure
		// probabilities...
		calculateComponentsInternalActionFailureProbabilities();
		calculateComponentsServiceFailureProbabilities();
		calculateComponentsServiceOperationFailureProbabilities();
		calculateExternalServiceFailureProbabilities();
		calculateExternalServiceOperationFailureProbabilities();

		// ...and print those accumulated failure probabilities
		printComponentsInternalActionFailureProbabilities();
		printComponentsServiceFailureProbabilities();
		printComponentsServiceOperationFailureProbabilities();
		printExternalServiceFailureProbabilities();
		printExternalServiceOperationFailureProbabilities();
	}

	/**
	 * Calculates all components' internal action failure probabilities for
	 * later output.
	 */
	private void calculateComponentsInternalActionFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
			if (!failureType.isSystemExternal()) { // only consider (internal)
													// components
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
					identifiers
							.add(softwareInducedFailureType.getComponentId());
					for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
						if (aggregation
								.compareToIdentifier(
										FailureAggregationType.COMPONENTS_INTERNAL_ACTIONS,
										identifiers)) {
							// this component ID is already in our data
							// structure, therefore we do not
							// add a new entry, but update the existing one
							// accordingly
							aggregation
									.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities
											.get(failureType));
							foundEntry = true;
							break; // found and updated the entry, so we are
									// done
						}
					}
					if (!foundEntry) {
						// we did not find a fitting entry, so we add a new one
						// and set its values
						// accordingly
						failureProbabilityAggregations
								.add(new FailureProbabilityAggregation(
										FailureAggregationType.COMPONENTS_INTERNAL_ACTIONS,
										identifiers, softwareInducedFailureType
												.getComponentName(),
										cumulatedFailureTypeProbabilities
												.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 * Calculates all components' service (interface) failure probabilities for
	 * later output.
	 */
	private void calculateComponentsServiceFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
			if (!failureType.isSystemExternal()) { // only consider (internal)
													// components
				if (failureType instanceof MarkovSoftwareInducedFailureType) {
					MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;
					boolean foundEntry = false;
					List<String> identifiers = new ArrayList<String>(2);
					identifiers
							.add(softwareInducedFailureType.getComponentId());
					identifiers
							.add(softwareInducedFailureType.getInterfaceId());
					for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
						if (aggregation.compareToIdentifier(
								FailureAggregationType.COMPONENTS_SERVICES,
								identifiers)) {
							// this entity is already in our data structure,
							// therefore we do not
							// add a new entry, but update the existing one
							// accordingly
							aggregation
									.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities
											.get(failureType));
							foundEntry = true;
							break; // found and updated the entry, so we are
									// done
						}
					}
					if (!foundEntry) {
						// we did not find a fitting entry, so we add a new one
						// and set its values
						// accordingly
						failureProbabilityAggregations
								.add(new FailureProbabilityAggregation(
										FailureAggregationType.COMPONENTS_SERVICES,
										identifiers, softwareInducedFailureType
												.getComponentName()
												+ "/"
												+ softwareInducedFailureType
														.getInterfaceName(),
										cumulatedFailureTypeProbabilities
												.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 * Calculates all components' service operation (signature) failure
	 * probabilities for later output.
	 */
	private void calculateComponentsServiceOperationFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
			if (!failureType.isSystemExternal()) { // only consider (internal)
													// components
				if (failureType instanceof MarkovSoftwareInducedFailureType) {
					MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;
					boolean foundEntry = false;
					List<String> identifiers = new ArrayList<String>(3);
					identifiers
							.add(softwareInducedFailureType.getComponentId());
					identifiers
							.add(softwareInducedFailureType.getInterfaceId());
					identifiers
							.add(softwareInducedFailureType.getSignatureId());
					for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
						if (aggregation
								.compareToIdentifier(
										FailureAggregationType.COMPONENTS_SERVICE_OPERATIONS,
										identifiers)) {
							// this entity is already in our data structure,
							// therefore we do not
							// add a new entry, but update the existing one
							// accordingly
							aggregation
									.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities
											.get(failureType));
							foundEntry = true;
							break; // found and updated the entry, so we are
									// done
						}
					}
					if (!foundEntry) {
						// we did not find a fitting entry, so we add a new one
						// and set its values
						// accordingly
						failureProbabilityAggregations
								.add(new FailureProbabilityAggregation(
										FailureAggregationType.COMPONENTS_SERVICE_OPERATIONS,
										identifiers, softwareInducedFailureType
												.getComponentName()
												+ "/"
												+ softwareInducedFailureType
														.getInterfaceName()
												+ "/"
												+ softwareInducedFailureType
														.getSignatureName(),
										cumulatedFailureTypeProbabilities
												.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 * Calculates all external service (role and interface) failure
	 * probabilities for later output.
	 */
	private void calculateExternalServiceFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
			if (failureType.isSystemExternal()) { // only consider external
													// services
				boolean foundEntry = false;
				List<String> identifiers = new ArrayList<String>(2);
				identifiers.add(failureType.getRoleId());
				identifiers.add(failureType.getInterfaceId());
				for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
					if (aggregation.compareToIdentifier(
							FailureAggregationType.EXTERNAL_SERVICES,
							identifiers)) {
						// this entity is already in our data structure,
						// therefore we do not
						// add a new entry, but update the existing one
						// accordingly
						aggregation
								.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities
										.get(failureType));
						foundEntry = true;
						break; // found and updated the entry, so we are done
					}
				}
				if (!foundEntry) {
					// we did not find a fitting entry, so we add a new one and
					// set its values
					// accordingly
					failureProbabilityAggregations
							.add(new FailureProbabilityAggregation(
									FailureAggregationType.EXTERNAL_SERVICES,
									identifiers, failureType.getRoleName()
											+ "/"
											+ failureType.getInterfaceName(),
									cumulatedFailureTypeProbabilities
											.get(failureType)));
				}
			}
		}
	}

	/**
	 * Calculates all external service operation (signature) failure
	 * probabilities for later output.
	 */
	private void calculateExternalServiceOperationFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities
				.keySet()) {
			if (failureType.isSystemExternal()) { // only consider external
													// services
				boolean foundEntry = false;
				List<String> identifiers = new ArrayList<String>(3);
				identifiers.add(failureType.getRoleId());
				identifiers.add(failureType.getInterfaceId());
				identifiers.add(failureType.getSignatureId());
				for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
					if (aggregation.compareToIdentifier(
							FailureAggregationType.EXTERNAL_SERVICE_OPERATIONS,
							identifiers)) {
						// this entity is already in our data structure,
						// therefore we do not
						// add a new entry, but update the existing one
						// accordingly
						aggregation
								.addToFailureProbabilityBy(cumulatedFailureTypeProbabilities
										.get(failureType));
						foundEntry = true;
						break; // found and updated the entry, so we are done
					}
				}
				if (!foundEntry) {
					// we did not find a fitting entry, so we add a new one and
					// set its values
					// accordingly
					failureProbabilityAggregations
							.add(new FailureProbabilityAggregation(
									FailureAggregationType.EXTERNAL_SERVICE_OPERATIONS,
									identifiers, failureType.getRoleName()
											+ "/"
											+ failureType.getInterfaceName()
											+ "/"
											+ failureType.getSignatureName(),
									cumulatedFailureTypeProbabilities
											.get(failureType)));
				}
			}
		}
	}

	/**
	 * Method used for printing all components' internal action failure
	 * probabilities.
	 */
	public void printComponentsInternalActionFailureProbabilities() {
		boolean hasEntries = false;
		MarkovResultPrinter printer = new MarkovResultPrinter();
		logger.info("Component failure probabilities:");
		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
			if (aggregation.getType() == FailureAggregationType.COMPONENTS_INTERNAL_ACTIONS) {
				if (doApproximate) {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
				} else {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
				}
				hasEntries = true;
			}
		}
		if (!hasEntries) {
			logger.info(" (none)");
		}
	}

	/**
	 * Method used for printing all components' service (interface) failure
	 * probabilities.
	 */
	public void printComponentsServiceFailureProbabilities() {
		boolean hasEntries = false;
		MarkovResultPrinter printer = new MarkovResultPrinter();
		logger.info("Component service failure probabilities:");
		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
			if (aggregation.getType() == FailureAggregationType.COMPONENTS_SERVICES) {
				if (doApproximate) {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
				} else {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
				}
				hasEntries = true;
			}
		}
		if (!hasEntries) {
			logger.info(" (none)");
		}
	}

	/**
	 * Method used for printing all components' service operation (signature)
	 * failure probabilities.
	 */
	public void printComponentsServiceOperationFailureProbabilities() {
		boolean hasEntries = false;
		MarkovResultPrinter printer = new MarkovResultPrinter();
		logger.info("Component operation failure probabilities:");
		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
			if (aggregation.getType() == FailureAggregationType.COMPONENTS_SERVICE_OPERATIONS) {
				if (doApproximate) {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
				} else {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
				}
				hasEntries = true;
			}
		}
		if (!hasEntries) {
			logger.info(" (none)");
		}
	}

	/**
	 * Method used for printing all external service (role and interface)
	 * failure probabilities.
	 */
	public void printExternalServiceFailureProbabilities() {
		boolean hasEntries = false;
		MarkovResultPrinter printer = new MarkovResultPrinter();
		logger.info("External service failure probabilities:");
		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
			if (aggregation.getType() == FailureAggregationType.EXTERNAL_SERVICES) {
				if (doApproximate) {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
				} else {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
				}
				hasEntries = true;
			}
		}
		if (!hasEntries) {
			logger.info(" (none)");
		}
	}

	/**
	 * Method used for printing all external service operation (signature)
	 * failure probabilities.
	 */
	public void printExternalServiceOperationFailureProbabilities() {
		boolean hasEntries = false;
		MarkovResultPrinter printer = new MarkovResultPrinter();
		logger.info("External operation failure probabilities:");
		for (FailureProbabilityAggregation aggregation : failureProbabilityAggregations) {
			if (aggregation.getType() == FailureAggregationType.EXTERNAL_SERVICE_OPERATIONS) {
				if (doApproximate) {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability(),
							aggregation.getFailureProbability() + 1 - cumulatedPhysicalStateProbability);
				} else {
					printer.print(aggregation.getEntityName() + ":", aggregation.getFailureProbability());
				}
				hasEntries = true;
			}
		}
		if (!hasEntries) {
			logger.info(" (none)");
		}
	}
}
