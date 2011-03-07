package de.uka.ipd.sdq.tcfmoop.config;

import java.util.HashMap;
import java.util.Map;

import org.opt4j.core.Objective;
import org.opt4j.core.Value;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * Configuration class for MinimalQualityCriteriaValue termination criterion.
 * @author Atanas Dimitrov
 */
public class MinimalQualityCriteriaValueConfig extends AbstractConfiguration {
	
	//Unresolved Objectives and Values. Objectives are still String keys
	private Map<String, Value<?>> unresolvedObjectives = new HashMap<String, Value<?>>();	
	//Already configured Objectives with their minimum required values.
	private Map<Objective, Value<?>> configuredObjectives = new HashMap<Objective, Value<?>>();
	//The required minimal number of parameters that need to have greater quality criteria values then the minimum values. 
	private Integer numberOfCandidatesToConform;
	
	public MinimalQualityCriteriaValueConfig(){
		super(TerminationCriteriaNames.MINIMAL_QUALITY_CIRTERIA_VALUE);
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if (this.getTerminationCriterionName() != TerminationCriteriaNames.MINIMAL_QUALITY_CIRTERIA_VALUE ||
				this.configuredObjectives == null || this.configuredObjectives.isEmpty() ||
				this.numberOfCandidatesToConform == null){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Set the List of objective minimum values.
	 * @param objectiveDescriptions a Map of objective minimum values. The List should not be null or empty.
	 * The Map will not be copied by reference. But its Elements will.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setObjectiveMinimalValues(Map<Objective, Value<?>> configuredObjectives) throws InvalidConfigException{
		if(configuredObjectives == null || configuredObjectives.isEmpty()){
			throw new InvalidConfigException("MinimalQualityCriteriaValueConfig.setObjectiveMinimalValue: " +
					"the supplied parameter should not be null or empty");
		}
		
		this.configuredObjectives.putAll(configuredObjectives);
	}
	
	/**
	 * Returns the List the configured Minimal Values for some or for all objectives of the optimization.
	 * @return the List the configured Minimal Values for some or for all objectives of the optimization.
	 */
	public Map<Objective, Value<?>> getObjectiveMinimalValues(){
		return this.configuredObjectives;
	}
	
	/**
	 * Configures the minimal values for the objectives without resolving them.
	 * The String keys of the objectives are used instead. The map can be later read 
	 * for fully resolving the objectives. This must be done, before the configuration object is
	 * supplied to the TerminationCriteriaManager. The TerminationCriterion cannot work with
	 * unresolved Objectives and therefore the validation of the Configuration object is not
	 * influenced by this parameter at all.
	 * @param unresolvedObjectives
	 */
	public void setUnresolvedObjectiveMinimalValue(Map<String, Value<?>> unresolvedObjectives){
		this.unresolvedObjectives.putAll(unresolvedObjectives);
	}
	
	/**
	 * Returns a map of String - Value<?> items. The String is the key that can be used to
	 * resolve the object. The Map must be previously set or it will be empty.
	 * @return map of String, Value pairs.
	 */
	public Map<String, Value<?>> getUnresolvedObjectiveMinimalValue(){
		return this.unresolvedObjectives;
	}
	
	/**
	 * Set the number of candidates that must have quality criteria values greater then the supplied minimum.
	 * @param numberOfCandidates the number of candidates that must have quality criteria values greater then the supplied minimum. Must be >=1.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setNumberOfCandidatesToConform(int numberOfCandidates) throws InvalidConfigException{
		if(numberOfCandidates < 1){
			throw new InvalidConfigException("MinimalQualityCriteriaValueConfig.setNumberOfCandidatesToConform: " +
			"the provided number of candidates to conform to the conditions must be at least 1");
		}
		
		this.numberOfCandidatesToConform = numberOfCandidates;
	}
	
	/**
	 * Get the number of candidates that must have quality criteria values greater then the supplied minimum.
	 * @return the number of candidates that must have quality criteria values greater then the supplied minimum.
	 */
	public int getNumberOfCandidatesToConform(){
		return this.numberOfCandidatesToConform;
	}
}