package de.uka.ipd.sdq.tcfmoop.config;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * Configuration class for ParetoOptimalSetStability termination criterion.
 * @author Atanas Dimitrov
 */
public class ParetoOptimalSetStabilityConfig extends AbstractConfiguration {

	/**
	 * The evaluation modes that this criterion supports. If mode is set to EXACT_NUMBER, then the criterion searches every time 
	 * for exactly x candidates who have survived for n iterations. If PERCENTAGE is set as evaluation mode, then the number of
	 * the survived candidates is relative to the current amount of candidates in the archive.
	 * The NOT_SET value will cause a validation error of the criterion configuration object and an InvalidConfigException 
	 * if this value is supplied to the set Method of the Configuration class. This value only exists as indicator 
	 * that the value has not been set.
	 * @author Atanas Dimitrov
	 */
	public enum EvaluationMode{EXACT_NUMBER, PERCENTAGE, NOT_SET};
	
	//The minimum number of individual who must survive
	private Integer minimumSurvivors;
	//The minimum number of individual in percentage who must survive
	private Double minimumSurvivorsInPercentage;
	//The minimum amount of iterations these individuals have to survive
	private Integer minimumIterationsToSurvive;
	/*
	 * The evaluation modes that this criterion supports. If mode is set to EXACT_NUMBER, then the criterion searches every time 
	 * for exactly x candidates who have survived for n iterations. If PERCENTAGE is set as evaluation mode, then the number of
	 * the survived candidates is relative to the current amount of candidates in the archive. 
	 */
	private EvaluationMode mode = EvaluationMode.NOT_SET;

	public ParetoOptimalSetStabilityConfig() {
		super(TerminationCriteriaNames.PARETO_OPTIMAL_SET_STABILITY);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if (this.getTerminationCriterionName() != TerminationCriteriaNames.PARETO_OPTIMAL_SET_STABILITY
				|| this.mode == EvaluationMode.NOT_SET
				|| this.minimumIterationsToSurvive == null
				|| (this.mode == EvaluationMode.EXACT_NUMBER && this.minimumSurvivors == null)
				|| (this.mode == EvaluationMode.PERCENTAGE && this.minimumSurvivorsInPercentage == null)) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Set the minimum number of iterations the individuals have to survive.
	 * @param minimumIterationsToSurvive the minimum number of iterations the individuals have to survive. Number must be greater than 1
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setMinimumIterationsToSurvive(int minimumIterationsToSurvive) throws InvalidConfigException{
		if(minimumIterationsToSurvive < 2){
			throw new InvalidConfigException("ParetoOptimalSetStabilityConfig.setMinNumberOfGenerationsToSurvive: " +
					"The minimum number of generations that the pareto optimal candidates need to survive" +
					" must be at least 2, or there is no set stability.");
		}else{
			this.minimumIterationsToSurvive = minimumIterationsToSurvive;
		}
	}
	
	/**
	 * Get the minimum number of iterations the individuals have to survive.
	 * @return the minimum number of iterations the individuals have to survive. Is guaranteed to be at least 2.
	 */
	public int getMinimumIterationsToSurvive(){
		return this.minimumIterationsToSurvive;
	}
	
	/**
	 * Set the minimum number of individuals to survive.
	 * @param minimumSurvivors the minimum number of individuals to survive. Parameter must be >= 1
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setMinimumSurvivors(int minimumSurvivors) throws InvalidConfigException{
		if(minimumSurvivors < 1){
			throw new InvalidConfigException("ParetoOptimalSetStabilityConfig.setMinimumNumberOfSurvivors: " +
					"The minimum number of pareto optimal candidate that need to survive" +
					" must be at least 1.");
		}else{
			this.minimumSurvivors = minimumSurvivors;
		}
	}
	
	/**
	 * Get the minimum number of individuals to survive.
	 * @return the minimum number of individuals to survive. Number is guaranteed to be >= 1.
	 */
	public int getMinimumSurvivors(){
		return minimumSurvivors;
	}
	
	/**
	 * Set the minimum percentage number of individuals to survive.
	 * @param minimumSurvivors the minimum percentage number of individuals to survive. The parameter is a percentage value and is exacted to be in the interval [0, 1].
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setMinimumSurvivorsInPercentage(double minimumSurvivorsInPercentage) throws InvalidConfigException{
		if(minimumSurvivorsInPercentage < 0 || minimumSurvivorsInPercentage > 1){
			throw new InvalidConfigException("ParetoOptimalSetStabilityConfig.setMinimumSurvivorsInPercentage: " +
					"The minimum percentage number of pareto optimal candidates that need to survive" +
					" must be at a value in the interval [0, 1].");
		}else{
			this.minimumSurvivorsInPercentage = minimumSurvivorsInPercentage;
		}
	}
	
	/**
	 * Get the minimum percentage number of individuals to survive.
	 * @return the minimum number of individuals to survive. Number is guaranteed to be in the interval [0, 1].
	 */
	public double getMinimumSurvivorsInPercentage(){
		return this.minimumSurvivorsInPercentage;
	}
	
	/**
	 * Set the evaluation mode that this criterion supports. If mode is set to EXACT_NUMBER, then the criterion searches every time 
	 * for exactly x candidates who have survived for n iterations. If PERCENTAGE is set as evaluation mode, then the number of
	 * the survived candidates is relative to the current amount of candidates in the archive.
	 * The NOT_SET value will cause a validation error of the criterion configuration object and an InvalidConfigException 
	 * if this value is supplied to the set Method of the Configuration class. This value only exists as indicator 
	 * that the value has not been set.
	 * @param mode EXACT_NUMBER, then the criterion searches every time for exactly x candidates who have survived for n iterations.
	 * 			   PERCENTAGE, then the number of the survived candidates is relative to the current amount of candidates in the archive
	 * 			   NOT_SET, will result in a InvalidConfigException.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setEvaluationMode(EvaluationMode mode) throws InvalidConfigException{
		if(mode != EvaluationMode.EXACT_NUMBER && mode != EvaluationMode.PERCENTAGE){
			throw new InvalidConfigException("ParetoOptimalSetStabilityConfig.setEvaluationMode: " +
					"The evaluation mode can be either EXACT_NUMBER or PERCENTAGE.");
		}else{
			this.mode = mode;
		}
	}
	
	/**
	 * Returns the mode of the evaluation.
	 * @return the mode of the evaluation. The value is guaranteed to be EXACT_NUMBER or PERCENTAGE.
	 */
	public EvaluationMode getEvaluationMode(){
		return this.mode;
	}

}
