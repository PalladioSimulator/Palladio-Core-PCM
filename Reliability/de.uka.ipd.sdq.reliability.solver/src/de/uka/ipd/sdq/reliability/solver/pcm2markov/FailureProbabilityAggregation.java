package de.uka.ipd.sdq.reliability.solver.pcm2markov;

import java.util.ArrayList;
import java.util.List;

/**
 * Class used for aggregation of failure probabilities according to an entity. An entity
 * may be a component's ID, a component's interface ID, a component's signature ID, etc.
 * 
 * @author Daniel Patejdl
 *
 */
public class FailureProbabilityAggregation {
	/**
	 * The failure probability aggregation type.
	 */
	FailureAggregationType failureAggregationType;

	/**
	 * A list of identification strings that make up the entire identifier and uniquely identify this
	 * instance.
	 */
	private List<String> entityIdentifiers;

	/**
	 * The entity's name parts. The entity's name is made up of its single parts.
	 */
	private List<String> entityNameParts;

	/**
	 * The aggregated failure probability of the entity.
	 */
	private double failureProbability;

	/**
	 * Creates a new failure probability aggregation instance.
	 * 
	 * @param failureAggregationType the failure probability aggregation type of the entity
	 * @param entityIdentifiers the entity's identification strings list
	 * @param entityNameParts the entity's name parts; the entity's name is made up of its single parts
	 * @param failureProbability the failure probability of the entity
	 */
	public FailureProbabilityAggregation(FailureAggregationType failureAggregationType,
			List<String> entityIdentifiers, List<String> entityNameParts, double failureProbability) {
		this.failureAggregationType = failureAggregationType;
		this.entityIdentifiers = new ArrayList<String>(entityIdentifiers.size());
		for (String identifier : entityIdentifiers) {
			this.entityIdentifiers.add(identifier);
		}
		this.entityNameParts = new ArrayList<String>(entityNameParts);
		this.failureProbability = failureProbability;
	}

	/**
	 * Compares this instance's failure probability aggregation type and identification strings List
	 * to the given type and identification strings, respectively.
	 * 
	 * @param otherEntityType the other entity's failure probability aggregation type
	 * @param otherEntityIdentifiers the other entitity's identification strings List
	 * @return <code>true</code>, if both types and identification strings match each other, <code>false</code>
	 * otherwise
	 */
	public boolean compareToIdentifier(FailureAggregationType otherEntityType, List<String> otherEntityIdentifiers) {
		if (failureAggregationType == otherEntityType && entityIdentifiers.size() == otherEntityIdentifiers.size()) {
			for (int i = 0; i < entityIdentifiers.size(); i++) {
				if (entityIdentifiers.get(i).equals(otherEntityIdentifiers.get(i))) {
					continue;
				} else {
					return false;	// at least one identification string does not match the other,
									// so the overall IDs must be different as well
				}
			}
		} else {
			return false;	// type and/or list size already don't match, so they're different identifiers
		}
		return true;
	}

	/**
	 * Returns the failure probability aggregation type.
	 * 
	 * @return the failure probability aggregation type
	 */
	public FailureAggregationType getType() {
		return failureAggregationType;
	}

	/**
	 * Sets the failure probability aggregation type.
	 * 
	 * @param failureAggregationType the failure probability aggregation type
	 */
	public void setType(FailureAggregationType failureAggregationType) {
		this.failureAggregationType = failureAggregationType;
	}

	/**
	 * Retrieves the identification strings List of the entity.
	 * 
	 * @return the identification strings List
	 */
	public List<String> getEntityIdentifiers() {
		return entityIdentifiers;
	}

	/**
	 * Sets the identification strings List of the entity.
	 * 
	 * @param entityIdentifier the identification strings List
	 */
	public void setEntityIdentifiers(List<String> entityIdentifiers) {
		this.entityIdentifiers = entityIdentifiers;
	}

	/**
	 * Retrieves the name parts of the entity. The entity's name is made up of its single parts.
	 * 
	 * @return the name parts of the entity
	 */
	public List<String> getEntityNameParts() {
		return entityNameParts;
	}

	/**
	 * Sets the name parts of the entity. The entity's name is made up of its single parts.
	 * 
	 * @param entityNameParts the name parts of the entity
	 */
	public void setEntityNameParts(List<String> entityNameParts) {
		this.entityNameParts = entityNameParts;
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
	 * Sets the entity's aggregated failure probability.
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
