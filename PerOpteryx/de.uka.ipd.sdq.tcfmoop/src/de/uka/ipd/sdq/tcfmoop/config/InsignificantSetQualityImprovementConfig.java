/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.config;

import java.util.List;

import org.opt4j.core.Objective;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * @author Atanas Dimitrov
 *
 */
public class InsignificantSetQualityImprovementConfig extends
		AbstractConfiguration {
	
	//Contains information about an objective, its allowed average Improvement and maxMin Improvement
	private List<ValueDifference> valueDifferences;
	//the n-x. set to compare with
	private Integer pastIterationNumber;


	public InsignificantSetQualityImprovementConfig(){
		this.criterionName = TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if (this.criterionName != TerminationCriteriaNames.INSIGNIFICANT_SET_QUALITY_IMPROVEMENT ||
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
		public ValueDifference(Objective objective, Double averageImprovement, Double maxMinImprovement) throws Exception{
			if(averageImprovement == null || objective == null || maxMinImprovement == null || 
					averageImprovement < 0 || averageImprovement > 1 ||
					maxMinImprovement < 0 || maxMinImprovement > 1){
				throw new Exception("ValueDifference.ValueDifference: " +
						"None of the supplied parameters should be null and averageImprovement and maxMinimprovement must be a percentage values between 0 and 1");
			}
			this.objective = objective;
			this.averageImprovement = averageImprovement;
			this.maxMinImprovement = maxMinImprovement;
		}
	}

}