/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.config;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * Configuration class for InsignificantParetoFrontChange termination criterion.
 * @author Atanas Dimitrov
 */
public class InsignificantParetoFrontChangeConfig extends AbstractConfiguration {

	//Difference between the pareto front from the n-x. generation and the one from the n. generation
	private Double percentageDifference;
	//the n-x. pareto front to compare with
	private Integer pastInterationNumber;
	
	public InsignificantParetoFrontChangeConfig(){
		super(TerminationCriteriaNames.INSIGNIFICANT_PARETO_FRONT_CHANGE);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if (this.getTerminationCriterionName() != TerminationCriteriaNames.INSIGNIFICANT_PARETO_FRONT_CHANGE ||
				this.percentageDifference == null ||
				this.pastInterationNumber == null){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Set the minimum allowed difference between the two fronts. If the difference, measured in coverage
	 * percentages is smaller then the one entered here, then the improvement is considered insignificant.
	 * Else it is not. The parameter is a percentage value and is exacted to be in the interval [0, 1].
	 * @param percentages Minimum allowed difference between the two pareto fronts. A percentage value in the interval [0, 1]
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setMinimumAllowedDifference(double percentages) throws InvalidConfigException{
		if(percentages < 0 || percentages > 1){
			throw new InvalidConfigException("InsignificantParetoFrontChangeConfig.setDifference: " +
			"the supplied parameter should be in range 0 - 1");
		}
		
		this.percentageDifference = percentages;
	}
	
	/**
	 * Returns the minimum allowed difference, measured in coverage percentages between the two fronts.
	 * The value is guaranteed to be in the interval [0, 1]
	 * @return the minimum allowed difference, measured in coverage percentages between the two fronts.
	 */
	public double getMinimumAllowedDifference(){
		return this.percentageDifference;
	}
	
	/**
	 * Sets the number for the x. past iteration to compare the current pareto front with.
	 * @param compareWithIterationsAgo the number for the x. past generation to compare the current pareto front with.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setPastIterationNumber(int pastInterationNumber) throws InvalidConfigException{
		if(pastInterationNumber < 1){
			throw new InvalidConfigException("InsignificantParetoFrontChangeConfig.setDifference: " +
			"the supplied parameter should be >= 1");
		}
		
		this.pastInterationNumber = pastInterationNumber;
	}
	
	/**
	 * Get the number for the x. past generation to compare the current pareto front with.
	 * @return the number for the x. past generation to compare the current pareto front with.
	 */
	public int getPastIterationNumber(){
		return this.pastInterationNumber;
	}

}