/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.config;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * Configuration class for NoNewParetoOptimalCandidatesFound termination criterion.
 * @author Atanas Dimitrov
 */
public class NoNewParetoOptimalCandidatesFoundConfig extends
		AbstractConfiguration {
	
	//Number of iterations without a new pareto optimal candidate
	private Integer iterationsWithoutNewCandidates;
	
	public NoNewParetoOptimalCandidatesFoundConfig(){
		super(TerminationCriteriaNames.NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if (this.getTerminationCriterionName() != TerminationCriteriaNames.NO_NEW_PARETO_OPTIMAL_CANDIDATES_FOUND
				|| this.iterationsWithoutNewCandidates == null) {
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Set the required number of iterations without new pareto optimal candidates in the pareto optimal set.
	 * @param numberOfIterations required number of iterations without new pareto optimal candidates in the pareto optimal set. Must be a >=1.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setIterationsWithoutNewCandidates(int numberOfIterations) throws InvalidConfigException{
		if(numberOfIterations < 1){
			throw new InvalidConfigException("NoNewParetoOptimalCandidatesFoundConfig.setNumberOfGenerationWithoutNewCandidates: " +
					"The minimum number of generations without new pareto optimal candidate" +
					" must be at least 1.");
		}else{
			this.iterationsWithoutNewCandidates = numberOfIterations;
		}
	}
	
	/**
	 * Get the required number of iterations without new pareto optimal candidates in the pareto optimal set.
	 * @return the required number of iterations without new pareto optimal candidates in the pareto optimal set. Guaranteed to be >=1
	 */
	public int getIterationsWithoutNewCandidates(){
		return this.iterationsWithoutNewCandidates;
	}

}
