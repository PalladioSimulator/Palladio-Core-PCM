package de.uka.ipd.sdq.tcfmoop.config;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * Configuration class for MaxGenerationNumber termination criterion.
 * @author Atanas Dimitrov
 */
public class MaxGenerationNumberConfig extends AbstractConfiguration {

	private Integer maximumNumberOfIterations;
	
	public MaxGenerationNumberConfig(){
		super(TerminationCriteriaNames.MAXIMUM_NUMBER_OF_GENERATIONS);
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if(this.getTerminationCriterionName() != TerminationCriteriaNames.MAXIMUM_NUMBER_OF_GENERATIONS ||
		   this.maximumNumberOfIterations == null){
			return false;
		}else{
			return true;
		}
	}
	
	/**
	 * Set the maximum number of iterations that the optimization algorithm 
	 * will perform before terminating.
	 * @param maximumNumberOfIterations if parameter is less then 1, an Exception is thrown.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setMaximumNumberOfIterations(int maximumNumberOfIterations) throws InvalidConfigException{
		if(maximumNumberOfIterations > 0){
			this.maximumNumberOfIterations = maximumNumberOfIterations;
		}else{
			throw new InvalidConfigException("MaxGenerationNumberConfig.setMaximumNumberOfIterations: The supplied Parameter is < 1");
		}
	}
	
	/**
	 * Returns the number of iterations that the optimization framework should execute.
	 * @return the number of iterations that the optimization framework should execute.
	 */
	public int getMaximumNumberOfIterations(){
		return this.maximumNumberOfIterations;
	}

}
