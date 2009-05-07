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
	 * The default value for members of this class that have not been specified.
	 */
	private static final String NOTSPECIFIED = "UNKNOWN";

	/**
	 * The id of the surrounding resource container.
	 */
	private String containerId;

	/**
	 * Gets the id of the surrounding resource container.
	 * 
	 * @return the id
	 */
	public String getResourceContainerId() {
		return containerId;
	}

	/**
	 * Sets the id of the surrounding resource container.
	 * 
	 * @param resourceContainerId
	 *            the id to set
	 */
	public void setContainerId(final String resourceContainerId) {
		this.containerId = resourceContainerId;
	}

	/**
	 * The name of the surrounding resource container.
	 */
	private String containerName;

	/**
	 * Gets the name of the surrounding resource container.
	 * 
	 * @return the name
	 */
	public String getResourceContainerName() {
		return containerName;
	}

	/**
	 * Sets the name of the surrounding resource container.
	 * 
	 * @param resourceContainerName
	 *            the name to set
	 */
	public void setContainerName(final String resourceContainerName) {
		this.containerName = resourceContainerName;
	}

	/**
	 * The id of the associated resource type.
	 */
	private String typeId;

	/**
	 * Gets the id of the associated resource type.
	 * 
	 * @return the id
	 */
	public String getProcessingResourceTypeId() {
		return typeId;
	}

	/**
	 * Sets the id of the associated resource type.
	 * 
	 * @param processingResourceTypeId
	 *            the id to set
	 */
	public void setTypeId(
			final String processingResourceTypeId) {
		this.typeId = processingResourceTypeId;
	}

	/**
	 * The name of the resource type.
	 */
	private String typeName;

	/**
	 * Gets the name of the resource type.
	 * 
	 * @return the name
	 */
	public String getResourceTypeName() {
		return typeName;
	}

	/**
	 * Sets the name of the resource type.
	 * 
	 * @param resourceTypeName
	 *            the name to set
	 */
	public void setTypeName(final String resourceTypeName) {
		this.typeName = resourceTypeName;
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
	public void setStateProbability(final ProcessingResourceState state,
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

	/**
	 * The contructor.
	 */
	public ProcessingResourceDescriptor() {

		// Provide consistent default state probabilities:
		setStateProbability(ProcessingResourceState.OK, 1.0);
		setStateProbability(ProcessingResourceState.NA, 0.0);

		// Set a default current state:
		setCurrentState(ProcessingResourceState.OK);

		// Set default names:
		setTypeId(NOTSPECIFIED);
		setContainerId(NOTSPECIFIED);
		setTypeName(NOTSPECIFIED);
		setContainerName(NOTSPECIFIED);
	}
}
