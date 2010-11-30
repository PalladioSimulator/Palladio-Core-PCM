package de.uka.ipd.sdq.reliability.solver.pcm2markov;

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
	static final String NOTSPECIFIED = "UNKNOWN";

	/**
	 * The id of the surrounding resource container.
	 */
	private String containerId;

	/**
	 * The name of the surrounding resource container.
	 */
	private String containerName;

	/**
	 * The current state during Markov analysis.
	 */
	private MarkovProcessingResourceState currentState;

	/**
	 * The probabilities of each resource state.
	 */
	private HashMap<MarkovProcessingResourceState, Double> stateProbabilities = new HashMap<MarkovProcessingResourceState, Double>();

	/**
	 * The type of resource.
	 */
	private MarkovProcessingResourceType type;

	/**
	 * The constructor.
	 */
	public ProcessingResourceDescriptor() {

		// Provide consistent default state probabilities:
		setStateProbability(MarkovProcessingResourceState.OK, 1.0);
		setStateProbability(MarkovProcessingResourceState.NA, 0.0);

		// Set a default current state:
		setCurrentState(MarkovProcessingResourceState.OK);

		// Set default names:
		setContainerId(NOTSPECIFIED);
		setContainerName(NOTSPECIFIED);

		// Set type information:
		type = new MarkovProcessingResourceType();
	}

	/**
	 * Gets the current resource state.
	 * 
	 * @return the current state
	 */
	public MarkovProcessingResourceState getCurrentState() {
		return currentState;
	}

	/**
	 * Gets the id of the surrounding resource container.
	 * 
	 * @return the id
	 */
	public String getResourceContainerId() {
		return containerId;
	}

	/**
	 * Gets the name of the surrounding resource container.
	 * 
	 * @return the name
	 */
	public String getResourceContainerName() {
		return containerName;
	}

	/**
	 * Retrieves the probability of a given resource state.
	 * 
	 * @param state
	 *            the resource state
	 * @return the probability
	 */
	public Double getStateProbability(final MarkovProcessingResourceState state) {
		return stateProbabilities.get(state);
	}

	/**
	 * Retrieves the resource type.
	 * 
	 * @return the resource type
	 */
	public MarkovProcessingResourceType getType() {
		return type;
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
	 * Sets the name of the surrounding resource container.
	 * 
	 * @param resourceContainerName
	 *            the name to set
	 */
	public void setContainerName(final String resourceContainerName) {
		this.containerName = resourceContainerName;
	}

	/**
	 * Sets the current resource state.
	 * 
	 * @param state
	 *            the state to set
	 */
	public void setCurrentState(final MarkovProcessingResourceState state) {
		currentState = state;
	}

	/**
	 * Sets the resource type id.
	 * 
	 * @param typeId
	 *            the resource type id to set
	 */
	public void setId(String typeId) {
		this.type.setId(typeId);
	}

	/**
	 * Sets the resource type name.
	 * 
	 * @param typeName
	 *            the resource type name to set
	 */
	public void setName(String typeName) {
		this.type.setName(typeName);
	}

	/**
	 * Sets a probability for a given resource state.
	 * 
	 * @param state
	 *            the resource state
	 * @param probability
	 *            the probability
	 */
	public void setStateProbability(final MarkovProcessingResourceState state,
			final Double probability) {
		stateProbabilities.put(state, probability);
	}

	/**
	 * Switches the state from either ProcessingResourceState.OK to
	 * ProcessingResourceState.NA or ProcessingResourceState.NA to
	 * ProcessingResourceState.OK.
	 */
	public void switchState() {
		if (currentState == MarkovProcessingResourceState.OK) {
			currentState = MarkovProcessingResourceState.NA;
		} else {
			currentState = MarkovProcessingResourceState.OK;
		}
	}

	/**
	 * Returns the default state of this resource.
	 * @return the default state
	 */
	public MarkovProcessingResourceState getDefaultState() {
		return MarkovProcessingResourceState.OK;
	}
}
