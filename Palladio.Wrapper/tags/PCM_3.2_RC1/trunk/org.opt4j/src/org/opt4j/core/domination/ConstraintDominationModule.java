/**
 * 
 */
package org.opt4j.core.domination;

import org.opt4j.config.annotations.Info;
import org.opt4j.start.Opt4JModule;

import com.google.inject.name.Names;

/**
 * Constraint Domination Module.
 * 
 * @see ConstraintDomination
 * @author noorshams
 *
 */
@Info("Constraint Domination")
public class ConstraintDominationModule extends Opt4JModule {

	@Info("Strategy when examining two feasible solutions")
	protected Strategy strategyForFeasibleSolutions = Strategy.ParetoDomination;
	
	protected Class<? extends DominationStrategy> strategyForFeasibleSolutionsClass = ParetoDomination.class;
	
	
	
	/**
	 * @return the strategyForFeasibleSolutions
	 */
	public Strategy getStrategyForFeasibleSolutions() {
		return strategyForFeasibleSolutions;
	}

	/**
	 * @param strategyForFeasibleSolutions the strategyForFeasibleSolutions to set
	 */
	public void setStrategyForFeasibleSolutions(
			Strategy strategyForFeasibleSolutions) {
		this.strategyForFeasibleSolutions = strategyForFeasibleSolutions;
	}

	public enum Strategy{
		/**
		 * @see ParetoDomination
		 */
		@Info("Pareto Domination")
		ParetoDomination,
		
		/**
		 * @see GoalAttainmentDomination
		 */
		@Info("Goal Attainment Domination")
		GoalAttainmentDomination
	}
	
	@Override
	protected void config() {
		// use ConstraintDomination
		bind(DominationStrategy.class).to(ConstraintDomination.class).in(SINGLETON);
		switch (strategyForFeasibleSolutions) {		
		case GoalAttainmentDomination:
			this.strategyForFeasibleSolutionsClass = GoalAttainmentDomination.class;
			break;
		default: //ParetoDomination
			//nothing left to do
			break;
		}
		bind(DominationStrategy.class).annotatedWith(Names.named("StrategyForFeasibleObjectives"))
		.to(strategyForFeasibleSolutionsClass);
		//use ConstraintCheckerImpl and register as IndividualStateListener (required!)
		bind(ConstraintChecker.class).to(ConstraintCheckerImpl.class).in(SINGLETON);
		addIndividualStateListener(ConstraintCheckerImpl.class);
	}

}
