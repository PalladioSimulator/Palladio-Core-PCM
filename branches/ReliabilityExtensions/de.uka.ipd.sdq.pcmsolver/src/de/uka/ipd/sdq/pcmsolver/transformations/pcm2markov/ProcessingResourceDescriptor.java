package de.uka.ipd.sdq.pcmsolver.transformations.pcm2markov;

import java.util.HashMap;

/**
 * Describes the characteristics of a PCM processing resource with respect to
 * its availability.
 * 
 * @author brosch
 * 
 */
public class ProcessingResourceDescriptor {

	/**
	 * The id of the surrounding resource container.
	 */
	private String resourceContainerId;

	/**
	 * Gets the id of the surrounding resource container.
	 * 
	 * @return the id
	 */
	public String getResourceContainerId() {
		return resourceContainerId;
	}

	/**
	 * Sets the id of the surrounding resource container.
	 * 
	 * @param resourceContainerId
	 *            the id to set
	 */
	public void setResourceContainerId(final String resourceContainerId) {
		this.resourceContainerId = resourceContainerId;
	}

	/**
	 * The id of the associated resource type.
	 */
	private String processingResourceTypeId;

	/**
	 * Gets the id of the associated resource type.
	 * 
	 * @return the id
	 */
	public String getProcessingResourceTypeId() {
		return processingResourceTypeId;
	}

	/**
	 * Sets the id of the associated resource type.
	 * 
	 * @param processingResourceTypeId
	 *            the id to set
	 */
	public void setProcessingResourceTypeId(
			final String processingResourceTypeId) {
		this.processingResourceTypeId = processingResourceTypeId;
	}

	/**
	 * The probabilities of each resource state.
	 */
	private HashMap<ProcessingResourceState, Double> stateProbabilities = new HashMap<ProcessingResourceState, Double>();

	/**
	 * Sets a probability for a given resource state.
	 * 
	 * @param state
	 *            the resource state
	 * @param probability
	 *            the probability
	 */
	public void addStateProbability(final ProcessingResourceState state,
			final Double probability) {
		stateProbabilities.put(state, probability);
	}

	/**
	 * Retrieves the probability of a given resource state.
	 * 
	 * @param state
	 *            the resource state
	 * @return the probability
	 */
	public Double getStateProbability(final ProcessingResourceState state) {
		return stateProbabilities.get(state);
	}

	/**
	 * The current state during Markov analysis.
	 */
	private ProcessingResourceState currentState;

	/**
	 * Gets the current resource state.
	 * 
	 * @return the current state
	 */
	public ProcessingResourceState getCurrentState() {
		return currentState;
	}

	/**
	 * Sets the current resource state.
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setCurrentState(final ProcessingResourceState state) {
		currentState = state;
	}
}
