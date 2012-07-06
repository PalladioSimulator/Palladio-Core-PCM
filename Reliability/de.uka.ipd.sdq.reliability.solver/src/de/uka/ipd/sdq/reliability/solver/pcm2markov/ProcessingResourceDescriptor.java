package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.HashMap;

/**
 * Describes the characteristics of a PCM processing resource with respect to its availability.
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
    private MarkovResourceState currentState;

    /**
     * Indicates if unavailability of this resource leads to unavailability of the surrounding
     * resource container.
     */
    private boolean requiredByContainer;

    /**
     * The probabilities of each resource state.
     */
    private HashMap<MarkovResourceState, Double> stateProbabilities = new HashMap<MarkovResourceState, Double>();

    /**
     * The type of resource.
     */
    private MarkovResourceType type;

    /**
     * The constructor.
     */
    public ProcessingResourceDescriptor() {

        // Provide consistent default state probabilities:
        setStateProbability(MarkovResourceState.OK, 1.0);
        setStateProbability(MarkovResourceState.NA, 0.0);

        // Set default values:
        setCurrentState(MarkovResourceState.OK);
        setContainerId(NOTSPECIFIED);
        setContainerName(NOTSPECIFIED);
        setRequiredByContainer(false);

        // Set type information:
        type = new MarkovResourceType();
    }

    /**
     * Gets the current resource state.
     * 
     * @return the current state
     */
    public MarkovResourceState getCurrentState() {
        return currentState;
    }

    /**
     * Returns the default state of this resource.
     * 
     * @return the default state
     */
    public MarkovResourceState getDefaultState() {
        return MarkovResourceState.OK;
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
    public Double getStateProbability(final MarkovResourceState state) {
        return stateProbabilities.get(state);
    }

    /**
     * Retrieves the resource type.
     * 
     * @return the resource type
     */
    public MarkovResourceType getType() {
        return type;
    }

    /**
     * Retrieves the availability relation to the surrounding resource container.
     * 
     * @return the availability relation to the surrounding resource container
     */
    public boolean isRequiredByContainer() {
        return requiredByContainer;
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
    public void setCurrentState(final MarkovResourceState state) {
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
     * Sets the availability relation to the surrounding resource container.
     * 
     * @param requiredByContainer
     *            the availability relation to the surrounding resource container
     */
    public void setRequiredByContainer(final boolean requiredByContainer) {
        this.requiredByContainer = requiredByContainer;
    }

    /**
     * Sets a probability for a given resource state.
     * 
     * @param state
     *            the resource state
     * @param probability
     *            the probability
     */
    public void setStateProbability(final MarkovResourceState state, final Double probability) {
        stateProbabilities.put(state, probability);
    }

    /**
     * Switches the state from either ProcessingResourceState.OK to ProcessingResourceState.NA or
     * ProcessingResourceState.NA to ProcessingResourceState.OK.
     */
    public void switchState() {
        if (currentState == MarkovResourceState.OK) {
            currentState = MarkovResourceState.NA;
        } else {
            currentState = MarkovResourceState.OK;
        }
    }
}
