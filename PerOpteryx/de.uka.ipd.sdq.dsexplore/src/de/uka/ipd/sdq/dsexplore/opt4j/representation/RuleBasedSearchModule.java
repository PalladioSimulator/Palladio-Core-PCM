package de.uka.ipd.sdq.dsexplore.opt4j.representation;

import org.opt4j.config.annotations.Info;
import org.opt4j.config.annotations.Order;
import org.opt4j.core.Genotype;
import org.opt4j.core.IndividualFactory;
import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.operator.copy.Copy;
import org.opt4j.start.Constant;

import com.google.inject.TypeLiteral;

import de.uka.ipd.sdq.dsexplore.opt4j.operator.CopyDesignDecisionGenotype;
import de.uka.ipd.sdq.dsexplore.opt4j.optimizer.RuleBasedSearch;

public class RuleBasedSearchModule extends OptimizerModule {

	@Info("The number of generations.")
	@Order(0)
	protected int generations = 1000;
	
	@Info("Whether to perform a full search (true) or discard / prune suboptimal candidates (false)")
	@Order(1)
	@Constant(value = "fullSearch", namespace = RuleBasedSearch.class)
	protected boolean fullSearch;


	@Override
	protected void config() {
		bindOptimizer(RuleBasedSearch.class);
		
		bind(IndividualFactory.class).to(DSEIndividualFactory.class);
		
		bind(new TypeLiteral<Copy<Genotype>>() {}).to((Class<? extends Copy<Genotype>>) CopyDesignDecisionGenotype.class);
		
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

	public void setFullSearch(boolean fullRuleBasedSearch) {
		this.fullSearch = fullRuleBasedSearch;
	}
	
	public boolean isFullSearch(){
		return this.fullSearch;
	}
	

}
