/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.config;

import java.util.List;

import org.opt4j.core.Objective;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * Configuration class for InsignificantSetQualityImprovement termination criterion.
 * @author Atanas Dimitrov
 */
public class InsignificantSetQualityImprovementConfig extends
		AbstractConfiguration {
	
	//Contains information about an objective, its allowed average Improvement and maxMin Improvement
	private List<ValueDifference> valueDifferences;
	//Contains information about an objective (in String Representation), its allowed average Improvement and maxMin Improvement
	//The state of this attribute does not interfere with the state of the configuration object at all.
	private List<UnresolvedValueDifference> unresolvedValueDifferences;
	//the n-x. set to compare with
	private Integer pastIterationNumber;


	public InsignificantSetQualityImprovementConfig(){
		super(TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if (this.getTerminationCriterionName() != TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT ||
				this.valueDifferences == null || this.valueDifferences.isEmpty() ||
				this.pastIterationNumber == null){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Set the list ValueObjects(objective name, allowed averages, wallower maxMin).
	 * @param valueDifferences (objective name, allowed averages, wallower maxMin)
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setValueDifferences(List<ValueDifference> valueDifferences) throws InvalidConfigException{
		if(valueDifferences == null || valueDifferences.isEmpty()){
			throw new InvalidConfigException("InsignificantSetQualityImprovementConfig.setMaximumValueDifferences: " +
					"the supplied parameter should not be null or empty");
		}
		
		this.valueDifferences = valueDifferences;
	}
	
	/**
	 * Return a List of ValueObjects witch contain the allowed average and maxMin improvement for a specific
	 * Objective.
	 * @return List of ValueObjects witch contains the allowed average and maxMin improvement for a specific
	 * Objective
	 */
	public List<ValueDifference> getValueDifferences(){
		return this.valueDifferences;
	}
	
	/**
	 * Configures the average and the MaxMin improvement values for the objectives without resolving it.
	 * The String keys of the objectives are used instead. The List can later be read 
	 * for fully resolving the objectives. This must be done, before the configuration object is
	 * supplied to the TerminationCriteriaManager. The TerminationCriterion cannot work with
	 * unresolved Objectives and therefore the validation of the Configuration object is not
	 * influenced by this parameter at all.
	 * @param unresolvedValueDifferences
	 */
	public void setUnresolvedValueDifferences(List<UnresolvedValueDifference> unresolvedValueDifferences){
		this.unresolvedValueDifferences = unresolvedValueDifferences;
	}
	
	/**
	 * Returns a List of UnresolvedValueDifferences (Objective String, Average improvement, MaxMin improvement).
	 * The String is the key that can be used to resolve the object.
	 * The List must be previously set or it will be empty.
	 * @return
	 */
	public List<UnresolvedValueDifference> getUnresolvedValueDifferences(){
		return this.unresolvedValueDifferences;
	}
	
	/**
	 * Sets the number for the x. past iteration to compare the current set with.
	 * @param pastIterationNumber the number for the x. past set to compare the current one with.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setComparisionGenerations(int pastIterationNumber) throws InvalidConfigException{
		if(pastIterationNumber < 1){
			throw new InvalidConfigException("InsignificantSetQualityImprovementConfig.setComparisionGenerations: " +
					"The parameter indicates how many generations in the past the current value is going to be compared with and " +
					" must be at least 1.");
		}else{
			this.pastIterationNumber = pastIterationNumber;
		}
	}
	
	/**
	 * Get the number for the x. past set to compare the current one with.
	 * @return the number for the x. past set to compare the current one with.
	 */
	public int getComparisionGenerations(){
		return this.pastIterationNumber;
	}
	
	public class ValueDifference{
		public final Objective objective;
		public final Double averageImprovement;
		public final Double maxMinImprovement;
		
		/**
		 * A helper Class to bind objectiveName to a specific ObjectiveSign and ObjectiveMinimalValue
		 * @param objective should not be null
		 * @param maxMinImprovement should not be null
		 * @param averageImprovement should not be null
		 * @throws Exception if parameter(s) are null
		 */
		public ValueDifference(Objective objective, Double averageImprovement, Double maxMinImprovement) throws InvalidConfigException{
			if(averageImprovement == null || objective == null || maxMinImprovement == null || 
					averageImprovement < 0 || averageImprovement > 1 ||
					maxMinImprovement < 0 || maxMinImprovement > 1){
				throw new InvalidConfigException("ValueDifference.ValueDifference: " +
						"None of the supplied parameters should be null and averageImprovement and maxMinimprovement must be a percentage values between 0 and 1");
			}
			this.objective = objective;
			this.averageImprovement = averageImprovement;
			this.maxMinImprovement = maxMinImprovement;
		}
	}
	
	public class UnresolvedValueDifference{
		public final String objective;
		public final Double averageImprovement;
		public final Double maxMinImprovement;
		
		/**
		 * A helper Class to bind objectiveName (in String representation) to a specific ObjectiveSign and ObjectiveMinimalValue
		 * The objectives must later be resolved, because the Termination Criterion can only work with resolved Objectives.
		 * @param objective should not be null
		 * @param maxMinImprovement should not be null
		 * @param averageImprovement should not be null
		 * @throws Exception if parameter(s) are null
		 */
		public UnresolvedValueDifference(String objective, Double averageImprovement, Double maxMinImprovement) throws Exception{
			this.objective = objective;
			this.averageImprovement = averageImprovement;
			this.maxMinImprovement = maxMinImprovement;
		}
	}

}