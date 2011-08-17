package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.config.annotations.Info;
import org.opt4j.config.annotations.Order;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.operator.copy.CopyModule;

import de.uka.ipd.sdq.dsexplore.opt4j.operator.CopyDesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.RuleBasedSearch;

public class RuleBasedSearchModule extends OptimizerModule {
	
	@Info("The number of generations.")
	@Order(0)
	@Iterations
	protected int generations = 1000;

	@Override
	protected void config() {
		bindOptimizer(RuleBasedSearch.class);
		
		bind(IndividualBuilder.class).to(DSEIndividualBuilder.class);
		
		CopyModule.addCopy(binder(), CopyDesignDecisionGenotype.class);

	}
	
	/**
	 * Returns the number of generations.
	 * 
	 * @return the number of generations
	 */
	public int getGenerations() {
		return generations;
	}
	
	/**
	 * Sets the number of generations.
	 * 
	 * @param generations
	 *            the number of generations
	 */
	public void setGenerations(int generations) {
		this.generations = generations;
	}

}
