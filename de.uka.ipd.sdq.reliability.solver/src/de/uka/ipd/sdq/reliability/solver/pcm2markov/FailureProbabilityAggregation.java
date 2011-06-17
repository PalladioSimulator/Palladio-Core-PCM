package de.uka.ipd.sdq.reliability.solver.pcm2markov;

/**
 * Class used for aggregation of failure probabilities according to an entity. An entity
 * may be a component's ID, a component's interface ID, a component's signature ID, etc.
 * 
 * @author Daniel Patejdl
 *
 */
public class FailureProbabilityAggregation {
	/**
	 * A string that uniquely identifies the entity.
	 */
	private String entityIdentifier;

	/**
	 * The entity's name.
	 */
	private String entityName;

	/**
	 * The aggregated failure probability of the entity.
	 */
	private double failureProbability;

	/**
	 * Creates a new failure probability aggregation instance.
	 * 
	 * @param entityIdentifier the entity's identification string
	 * @param entityName the entity's name
	 * @param failureProbability the failure probability of the entity
	 */
	public FailureProbabilityAggregation(String entityIdentifier, String entityName, double failureProbability) {
		this.entityIdentifier = entityIdentifier;
		this.entityName = entityName;
		this.failureProbability = failureProbability;
	}

	/**
	 * Retrieves the identification string of the entity.
	 * 
	 * @return the identification string
	 */
	public String getEntityIdentifier() {
		return entityIdentifier;
	}

	/**
	 * Sets the identification string of the entity.
	 * 
	 * @param entityIdentifier the identification string
	 */
	public void setEntityIdentifier(String entityIdentifier) {
		this.entityIdentifier = entityIdentifier;
	}

	/**
	 * Retrieves the name of the entity.
	 * 
	 * @return the name of the entity
	 */
	public String getEntityName() {
		return entityName;
	}

	/**
	 * Sets the name of the entity.
	 * 
	 * @param entityName the name of the entity
	 */
	public void setEntityName(String entityName) {
		this.entityName = entityName;
	}

	/**
	 * Retrieves the entity's aggregated failure probability.
	 * 
	 * @return the entity's aggregated failure probability
	 */
	public double getFailureProbability() {
		return failureProbability;
	}

	/**
	 * Sets the entity's aggregated failure probability
	 * 
	 * @param failureProbability the entity's aggregated failure probability
	 */
	public void setFailureProbability(double failureProbability) {
		this.failureProbability = failureProbability;
	}

	/**
	 * Adds to the current entity's aggregated failure probability additional
	 * failure probability.
	 * 
	 * @param failureProbability the failure probability to be added to the existing one
	 */
	public void addToFailureProbabilityBy(double failureProbability) {
		this.failureProbability += failureProbability;
	}
}
