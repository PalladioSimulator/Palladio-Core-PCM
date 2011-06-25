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
	 * The failure probability aggregation mode.
	 */
	FailureProbabilityAggregationMode failureProbabilityAggregationMode;

	/**
	 * A list of identification strings that make up the entire identifier and uniquely identify this
	 * instance.
	 */
	private List<String> entityIdentifiers;

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
	 * @param failureProbabilityAggregationMode the failure probability aggregation mode of the entity
	 * @param entityIdentifiers the entity's identification strings list
	 * @param entityName the entity's name
	 * @param failureProbability the failure probability of the entity
	 */
	public FailureProbabilityAggregation(FailureProbabilityAggregationMode failureProbabilityAggregationMode,
			List<String> entityIdentifiers, String entityName, double failureProbability) {
		this.failureProbabilityAggregationMode = failureProbabilityAggregationMode;
		this.entityIdentifiers = new ArrayList<String>(entityIdentifiers.size());
		for (String identifier : entityIdentifiers) {
			this.entityIdentifiers.add(identifier);
		}
		this.entityName = entityName;
		this.failureProbability = failureProbability;
	}

	/**
	 * Compares this instance's failure probability aggregation mode and identification strings List
	 * to the given mode and identification strings, respectively.
	 * 
	 * @param otherEntityMode the other entity's failure probability aggregation mode
	 * @param otherEntityIdentifiers the other entitity's identification strings List
	 * @return <code>true</code>, if both modes and identification strings match each other, <code>false</code>
	 * otherwise
	 */
	public boolean compareToIdentifier(FailureProbabilityAggregationMode otherEntityMode, List<String> otherEntityIdentifiers) {
		if (failureProbabilityAggregationMode == otherEntityMode && entityIdentifiers.size() == otherEntityIdentifiers.size()) {
			for (int i = 0; i < entityIdentifiers.size(); i++) {
				if (entityIdentifiers.get(i).equals(otherEntityIdentifiers.get(i))) {
					continue;
				} else {
					return false;	// at least one identification string does not match the other,
									// so the overall IDs must be different as well
				}
			}
		} else {
			return false;	// mode and/or list size already don't match, so they're different identifiers
		}
		return true;
	}

	/**
	 * Returns the failure probability aggregation mode.
	 * 
	 * @return the failure probability aggregation mode
	 */
	public FailureProbabilityAggregationMode getMode() {
		return failureProbabilityAggregationMode;
	}

	/**
	 * Sets the failure probability aggregation mode.
	 * 
	 * @param failureProbabilityAggregationMode the failure probability aggregation mode
	 */
	public void setMode(FailureProbabilityAggregationMode failureProbabilityAggregationMode) {
		this.failureProbabilityAggregationMode = failureProbabilityAggregationMode;
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
