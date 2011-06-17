package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType;

/**
 * Class used for aggregation and output of failure probabilities that were calculated
 * during a reliability analysis.
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
	 * Will store the overall failure probabilities of the components' internal actions.
	 */
	List<FailureProbabilityAggregation> componentsInternalActionsFailureProbabilityAggregation;

	/**
	 * Will store the overall failure probabilities of the components' services (interfaces).
	 */
	List<FailureProbabilityAggregation> componentsServiceFailureProbabilityAggregation;

	/**
	 * Will store the overall failure probabilities of the components' service operations (signatures).
	 */
	List<FailureProbabilityAggregation> componentsServiceOperationFailureProbabilityAggregation;

	/**
	 * Will store the overall failure probabilities of the external services (roles and interfaces).
	 */
	List<FailureProbabilityAggregation> externalServiceFailureProbabilityAggregation;

	/**
	 * Will store the overall failure probabilities of the external service operations (signatures).
	 */
	List<FailureProbabilityAggregation> externalServiceOperationFailureProbabilityAggregation;

	/**
	 * Creates a new MarkovReporting instance that is used for result aggregation according
	 * to the given accumulated failure type probabilities.
	 * @param cumulatedFailureTypeProbabilities the overall failure type probabilities,
	 * accumulated over all considered physical system states.
	 */
	public MarkovReporting(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		this.cumulatedFailureTypeProbabilities = cumulatedFailureTypeProbabilities;

		componentsInternalActionsFailureProbabilityAggregation = new ArrayList<FailureProbabilityAggregation>();
		componentsServiceFailureProbabilityAggregation = new ArrayList<FailureProbabilityAggregation>();
		componentsServiceOperationFailureProbabilityAggregation = new ArrayList<FailureProbabilityAggregation>();
		externalServiceFailureProbabilityAggregation = new ArrayList<FailureProbabilityAggregation>();
		externalServiceOperationFailureProbabilityAggregation = new ArrayList<FailureProbabilityAggregation>();

		// precalculate component as well as external service failure probabilities
		calculateComponentsInternalActionFailureProbabilities();
		calculateComponentsServiceFailureProbabilities();
		calculateComponentsServiceOperationFailureProbabilities();
		calculateExternalServiceFailureProbabilities();
		calculateExternalServiceOperationFailureProbabilities();

		System.out.println("=======================");
		System.out.println("=== MarkovReporting ===");
		System.out.println("=======================");
		System.out.println();

		for (MarkovFailureType failureType : this.cumulatedFailureTypeProbabilities.keySet()) {
			System.out.println("==================================================");
			System.out.println("Failure type name and ID: " + failureType.getName()
					+ ", " + failureType.getId());
			System.out.println("- Is external: " + failureType.isSystemExternal());
			System.out.println("- Failure probability: " + cumulatedFailureTypeProbabilities.get(failureType));
		}
		System.out.println();
		System.out.println();

		printComponentsInternalActionFailureProbabilities();
		System.out.println();

		printComponentsServiceFailureProbabilities();
		System.out.println();

		printComponentsServiceOperationFailureProbabilities();
		System.out.println();

		printExternalServiceFailureProbabilities();
		System.out.println();

		printExternalServiceOperationFailureProbabilities();
		System.out.println();

		System.out.println("==============================");
		System.out.println("=== End of MarkovReporting ===");
		System.out.println("==============================");
	}

	/**
	 * Calculates all components' internal action failure probabilities for later output.
	 */
	private void calculateComponentsInternalActionFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
			if (!failureType.isSystemExternal()) {	// only consider (internal) components
				if (failureType instanceof MarkovSoftwareInducedFailureType) {
					MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;

					/*
					 * If the component ID is not in our data structure, we will add a new entry to it.
					 * If the component ID is already in the data structure, we will not add it again,
					 * but we will add to (the existing failure probability) the current failure type's
					 * probability.
					 */
					boolean foundEntry = false;
					for (FailureProbabilityAggregation aggregation :
						componentsInternalActionsFailureProbabilityAggregation) {
						if (softwareInducedFailureType.getComponentId().equals(aggregation.getEntityIdentifier())) {
							// this component ID is already in our data structure, therefore we do not
							// add a new entry, but update the existing one
							aggregation.addToFailureProbabilityBy(
									cumulatedFailureTypeProbabilities.get(failureType));
							foundEntry = true;
							break;	// found and updated the entry, so we are done
						}
					}
					if (!foundEntry) {
						// we did not find a fitting entry, so we add a new one and set its values
						// accordingly
						componentsInternalActionsFailureProbabilityAggregation.add(
								new FailureProbabilityAggregation(softwareInducedFailureType.getComponentId(),
										softwareInducedFailureType.getComponentName(),
										cumulatedFailureTypeProbabilities.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 *  Calculates all components' service (interface) failure probabilities for later output.
	 */
	private void calculateComponentsServiceFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
			if (!failureType.isSystemExternal()) {	// only consider (internal) components
				if (failureType instanceof MarkovSoftwareInducedFailureType) {
					MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;

					/*
					 * If the interface ID is not in our data structure, we will add a new entry to it.
					 * If the interface ID is already in the data structure, we will not add it again,
					 * but we will add to (the existing failure probability) the current failure type's
					 * probability.
					 */
					boolean foundEntry = false;
					for (FailureProbabilityAggregation aggregation :
						componentsServiceFailureProbabilityAggregation) {
						if (softwareInducedFailureType.getInterfaceId().equals(aggregation.getEntityIdentifier())) {
							// this interface ID is already in our data structure, therefore we do not
							// add a new entry, but update the existing one
							aggregation.addToFailureProbabilityBy(
									cumulatedFailureTypeProbabilities.get(failureType));
							foundEntry = true;
							break;	// found and updated the entry, so we are done
						}
					}
					if (!foundEntry) {
						// we did not find a fitting entry, so we add a new one and set its values
						// accordingly
						componentsServiceFailureProbabilityAggregation.add(
								new FailureProbabilityAggregation(softwareInducedFailureType.getInterfaceId(),
										softwareInducedFailureType.getInterfaceName(),
										cumulatedFailureTypeProbabilities.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 *  Calculates all components' service operation (signature) failure probabilities for later output.
	 */
	private void calculateComponentsServiceOperationFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
			if (!failureType.isSystemExternal()) {	// only consider (internal) components
				if (failureType instanceof MarkovSoftwareInducedFailureType) {
					MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;

					/*
					 * If the signature ID is not in our data structure, we will add a new entry to it.
					 * If the signature ID is already in the data structure, we will not add it again,
					 * but we will add to (the existing failure probability) the current failure type's
					 * probability.
					 */
					boolean foundEntry = false;
					for (FailureProbabilityAggregation aggregation :
						componentsServiceOperationFailureProbabilityAggregation) {
						if (softwareInducedFailureType.getSignatureId().equals(aggregation.getEntityIdentifier())) {
							// this signature ID is already in our data structure, therefore we do not
							// add a new entry, but update the existing one
							aggregation.addToFailureProbabilityBy(
									cumulatedFailureTypeProbabilities.get(failureType));
							foundEntry = true;
							break;	// found and updated the entry, so we are done
						}
					}
					if (!foundEntry) {
						// we did not find a fitting entry, so we add a new one and set its values
						// accordingly
						componentsServiceOperationFailureProbabilityAggregation.add(
								new FailureProbabilityAggregation(softwareInducedFailureType.getSignatureId(),
										softwareInducedFailureType.getSignatureName(),
										cumulatedFailureTypeProbabilities.get(failureType)));
					}
				}
			}
		}
	}

	/**
	 *  Calculates all external service (role and interface) failure probabilities for later output.
	 */
	private void calculateExternalServiceFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
			if (failureType.isSystemExternal()) {	// only consider external services

				/*
				 * If the role ID and interface ID are not in our data structure, we will add a new entry to it.
				 * If the role ID and interface ID are already in the data structure, we will not add it again,
				 * but we will add to (the existing failure probability) the current failure type's
				 * probability.
				 */
				boolean foundEntry = false;
				for (FailureProbabilityAggregation aggregation :
					externalServiceFailureProbabilityAggregation) {
					if ((failureType.getRoleId() + failureType.getInterfaceId()).equals(
							aggregation.getEntityIdentifier())) {
						// this role ID and interface ID is already in our data structure, therefore
						// we do not add a new entry, but update the existing one
						aggregation.addToFailureProbabilityBy(
								cumulatedFailureTypeProbabilities.get(failureType));
						foundEntry = true;
						break;	// found and updated the entry, so we are done
					}
				}
				if (!foundEntry) {
					// we did not find a fitting entry, so we add a new one and set its values
					// accordingly
					externalServiceFailureProbabilityAggregation.add(
							new FailureProbabilityAggregation(
									(failureType.getRoleId() + failureType.getInterfaceId()),
									failureType.getRoleName() + " / " + failureType.getInterfaceName(),	// TODO check with Franz if this is okay
									cumulatedFailureTypeProbabilities.get(failureType)));
				}
			}
		}
	}

	/**
	 *  Calculates all external service operation (signature) failure probabilities for later output.
	 */
	private void calculateExternalServiceOperationFailureProbabilities() {
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
			if (failureType.isSystemExternal()) {	// only consider external services

				/*
				 * If the signature ID is not in our data structure, we will add a new entry to it.
				 * If the signature ID is already in the data structure, we will not add it again,
				 * but we will add to (the existing failure probability) the current failure type's
				 * probability.
				 */
				boolean foundEntry = false;
				for (FailureProbabilityAggregation aggregation :
					externalServiceOperationFailureProbabilityAggregation) {
					if (failureType.getSignatureId().equals(
							aggregation.getEntityIdentifier())) {
						// this signature ID is already in our data structure, therefore
						// we do not add a new entry, but update the existing one
						aggregation.addToFailureProbabilityBy(
								cumulatedFailureTypeProbabilities.get(failureType));
						foundEntry = true;
						break;	// found and updated the entry, so we are done
					}
				}
				if (!foundEntry) {
					// we did not find a fitting entry, so we add a new one and set its values
					// accordingly
					externalServiceOperationFailureProbabilityAggregation.add(
							new FailureProbabilityAggregation(failureType.getSignatureId(),
									failureType.getSignatureName(),
									cumulatedFailureTypeProbabilities.get(failureType)));
				}
			}
		}
	}

	/**
	 * Method used for printing all components' internal action failure probabilities.
	 */
	public void printComponentsInternalActionFailureProbabilities() {
		System.out.println("Components' internal actions:");
		for (FailureProbabilityAggregation aggregation : componentsInternalActionsFailureProbabilityAggregation) {
			System.out.println("- " + aggregation.getEntityName() + " has failure probability "
					+ aggregation.getFailureProbability() + ".");
		}
	}

	/**
	 * Method used for printing all components' service (interface) failure probabilities.
	 */
	public void printComponentsServiceFailureProbabilities() {
		System.out.println("Components' services (interfaces):");
		for (FailureProbabilityAggregation aggregation : componentsServiceFailureProbabilityAggregation) {
			System.out.println("- " + aggregation.getEntityName() + " has failure probability "
					+ aggregation.getFailureProbability() + ".");
		}
	}

	/**
	 * Method used for printing all components' service operation (signature) failure probabilities.
	 */
	public void printComponentsServiceOperationFailureProbabilities() {
		System.out.println("Components' service operations (signatures):");
		for (FailureProbabilityAggregation aggregation : componentsServiceOperationFailureProbabilityAggregation) {
			System.out.println("- " + aggregation.getEntityName() + " has failure probability "
					+ aggregation.getFailureProbability() + ".");
		}
	}

	/**
	 * Method used for printing all external service (role and interface) failure probabilities.
	 */
	public void printExternalServiceFailureProbabilities() {
		System.out.println("External services (roles and interfaces):");
		for (FailureProbabilityAggregation aggregation : externalServiceFailureProbabilityAggregation) {
			System.out.println("- " + aggregation.getEntityName() + " has failure probability "
					+ aggregation.getFailureProbability() + ".");
		}
	}

	/**
	 * Method used for printing all external service operation (signature) failure probabilities.
	 */
	public void printExternalServiceOperationFailureProbabilities() {
		System.out.println("External service operations (signatures):");
		for (FailureProbabilityAggregation aggregation : externalServiceOperationFailureProbabilityAggregation) {
			System.out.println("- " + aggregation.getEntityName() + " has failure probability "
					+ aggregation.getFailureProbability() + ".");
		}
	}
}
