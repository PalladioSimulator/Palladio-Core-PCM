/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.config;

import java.util.LinkedList;
import java.util.List;

import org.opt4j.core.Objectives;

import de.uka.ipd.sdq.tcfmoop.config.exceptions.InvalidConfigException;

/**
 * @author Atanas Dimitrov
 *
 */
public class GivenParetoFrontIsReachedConfig extends AbstractConfiguration {
	//The pareto front that the optimization targets
	private List<Objectives> paretoFront;
	//The percentage of the targeted front that needs to be dominated by the pareto front of the optimization
	private Double percentagesToCover;
	
	public GivenParetoFrontIsReachedConfig(){
		this.criterionName = TerminationCriteriaNames.GIVEN_PARETO_FRONT_IS_REACHED;
		
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public boolean validateConfiguration() {
		if (this.criterionName != TerminationCriteriaNames.GIVEN_PARETO_FRONT_IS_REACHED ||
				this.paretoFront == null || this.paretoFront.isEmpty() ||
				this.percentagesToCover == null){
			return false;
		} else {
			return true;
		}
	}
	
	/**
	 * Sets the targeted pareto front that should be partially or fully covered/dominated
	 * by the pareto from created by the optimization process.
	 * @param paretoFront targeted pareto front. Should not be empty or null. The Elements of the supplied List
	 * will be copied to a new internal list. The given list will be left intact.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setParetoFront(List<Objectives> paretoFront) throws InvalidConfigException{
		if(paretoFront == null || paretoFront.isEmpty()){
			throw new InvalidConfigException("GivenParetoFrontIsReachedConfig.setParetoFront: " +
					"the supplied parameter should not be null or empty");
		}
		this.paretoFront = new LinkedList<Objectives>(paretoFront);
	}
	
	/**
	 * Returns the targeted pareto front.
	 * @return the targeted pareto front.
	 */
	public List<Objectives> getParetoFront(){
		return this.paretoFront;
	}
	
	/**
	 * Sets the percentages of the targeted front that must be covered by the pareto front of the
	 * optimization. A value in the interval [0, 1] is required as an input. 0 means no coverage at all
	 * and the criterion will terminate the optimization right after the first iteration and 1 mean fully
	 * coverage, which might take long depending on the supplied targeted front.
	 * @param percentages the to be covered percentages. The value must be in the [0, 1] interval.
	 * @throws InvalidConfigException if the supplied parameter do not conform to the required conditions.
	 */
	public void setPercentagesToCover(double percentages) throws InvalidConfigException{
		if(percentages < 0 || percentages > 1){
			throw new InvalidConfigException("GivenParetoFrontIsReachedConfig.setPercentages: " +
			"the supplied parameter should be in range 0 - 1");
		}
		
		this.percentagesToCover = percentages;
	}
	
	/**
	 * Gets the percentages of the targeted front that must be covered by the pareto front of the
	 * optimization.
	 * @return the percentages of the targeted front that must be covered by the pareto front of the
	 * optimization.
	 */
	public double getPercentagesToCover(){
		return this.percentagesToCover;
	}
	
}