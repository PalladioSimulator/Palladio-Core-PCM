package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.HashMap;
import java.util.Map;

import de.uka.ipd.sdq.reliability.core.MarkovFailureType;
import de.uka.ipd.sdq.reliability.core.MarkovSoftwareInducedFailureType;

public class MarkovReporting {

	/**
	 * Overall failure type probabilities, accumulated over all considered
	 * physical system states.
	 */
	private Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities;

	/**
	 * Will store the overall failure probabilities of the system's components.
	 */
	Map<String, Double> cumulatedComponentFailureProbabilities;

	/**
	 * Will store the overall failure probabilities of the external services.
	 */
	Map<String, Double> cumulatedExternalServiceFailureProbabilities;

	/**
	 * Creates a new MarkovReporting instance that is used for result aggregation according
	 * to the given accumulated failure type probabilities.
	 * @param cumulatedFailureTypeProbabilities the overall failure type probabilities,
	 * accumulated over all considered physical system states.
	 */
	public MarkovReporting(Map<MarkovFailureType, Double> cumulatedFailureTypeProbabilities) {
		this.cumulatedFailureTypeProbabilities = cumulatedFailureTypeProbabilities;

		cumulatedComponentFailureProbabilities = new HashMap<String, Double>();
		cumulatedExternalServiceFailureProbabilities = new HashMap<String, Double>();

		// precalculate overall component as well as external service failure probabilities
		calculateComponentAndExternalServiceFailureProbabilities();

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

		printComponentFailureProbabilities();
		System.out.println();

		printExternalServiceFailureProbabilities();
	}

	/**
	 * 
	 */
	// TODO choose proper method name
	private void calculateComponentAndExternalServiceFailureProbabilities() {
		// TODO check with Franz if code logic is correct
		String serviceName = null;
		for (MarkovFailureType failureType : cumulatedFailureTypeProbabilities.keySet()) {
			serviceName = failureType.getName().substring(0, failureType.getName().indexOf("/"));
			if (failureType.isSystemExternal()) {	// we only consider externals here...
					//if (failureType.)
				/*
				 * If the external service name is not in our hash map, we will add it. Also, we will
				 * store failure probability information for the current failure type.
				 * If the external service name is already in our hash map, we will not add it again,
				 * but we will add to (the existing failure probability) the current failure type's
				 * probability.
				 */
				if (!cumulatedExternalServiceFailureProbabilities.containsKey(serviceName)) {
					// insert external service's name and failure probability for current failure type
					cumulatedExternalServiceFailureProbabilities.put(serviceName,
							cumulatedFailureTypeProbabilities.get(failureType));
				}
				else {
					// add to the current overall failure probability of the external service the failure
					// probability of the current failure type
					cumulatedExternalServiceFailureProbabilities.put(serviceName,
							cumulatedExternalServiceFailureProbabilities.get(serviceName)
							+ cumulatedFailureTypeProbabilities.get(failureType));	// put will overwrite current entry
																					// in hash map (which is what we want)
				}
			} else {	// we only consider internals here...

				//if (failureType instanceof MarkovSoftwareInducedFailureType) {
					//MarkovSoftwareInducedFailureType softwareInducedFailureType = (MarkovSoftwareInducedFailureType) failureType;
					// Unterscheidung anhand softwareInducedFailureType.getComponentId(), Aggregation darüber
					// und Ausgabe des Namens später
				//}
				/*
				 * If the internal service name is not in our hash map, we will add it. Also, we will
				 * store failure probability information for the current failure type.
				 * If the service name is already in our hash map, we will not add it again,
				 * but we will add to (the existing failure probability) the current failure type's
				 * probability.
				 */
				if (!cumulatedComponentFailureProbabilities.containsKey(serviceName)) {
					// insert internal service's name and failure probability for current failure type
					cumulatedComponentFailureProbabilities.put(serviceName,
							cumulatedFailureTypeProbabilities.get(failureType));
				}
				else {
					// add to the current overall failure probability of the internal service the failure
					// probability of the current failure type
					cumulatedComponentFailureProbabilities.put(serviceName,
							cumulatedComponentFailureProbabilities.get(serviceName)
							+ cumulatedFailureTypeProbabilities.get(failureType));	// put will overwrite current entry
																					// in hash map (which is what we want)
				}
			}
		}
	}

	/**
	 * 
	 */
	// TODO choose proper method name
	public void printComponentFailureProbabilities() {
		// TODO check with Franz if code logic is correct
		System.out.println("Components:");
		for (String componentName : cumulatedComponentFailureProbabilities.keySet()) {
			System.out.println("- " + componentName + " has failure probability "
					+ cumulatedComponentFailureProbabilities.get(componentName) + ".");
		}
	}

	/**
	 * 
	 */
	// TODO choose proper method name
	public void printComponentServiceFailureProbabilities() {
		// TODO add code logic
	}

	/**
	 * 
	 */
	// TODO choose proper method name
	public void printComponentServiceOperationFailureProbabilities() {
		// TODO add code logic
	}

	/**
	 * 
	 */
	// TODO choose proper method name
	public void printExternalServiceFailureProbabilities() {
		// TODO check with Franz if code logic is correct
		System.out.println("External services:");
		for (String externalServiceName : cumulatedExternalServiceFailureProbabilities.keySet()) {
			System.out.println("- " + externalServiceName + " has failure probability "
					+ cumulatedExternalServiceFailureProbabilities.get(externalServiceName) + ".");
		}
	}

	/**
	 * 
	 */
	// TODO choose proper method name
	public void printExternalServiceOperationFailureProbabilities() {
		// TODO add code logic
	}
}
