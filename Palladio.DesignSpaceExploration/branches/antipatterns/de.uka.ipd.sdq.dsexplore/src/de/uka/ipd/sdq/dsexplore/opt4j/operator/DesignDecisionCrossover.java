package de.uka.ipd.sdq.dsexplore.opt4j.operator;

import org.opt4j.common.random.Rand;
import org.opt4j.operator.crossover.Crossover;
import org.opt4j.operator.crossover.CrossoverListRate;
import org.opt4j.optimizer.ea.ConstantCrossoverRate;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

import de.uka.ipd.sdq.dsexplore.opt4j.genotype.DesignDecisionGenotype;

/**
 * Crossover implementation with possible multiple crossover points, depending on the rate. 
 * The larger rate, the more crossover points will be generated in average. 
 *
 * Inherits behaviour from {@link CrossoverListRate}
 * 
 * @author martens
 *
 */
public class DesignDecisionCrossover extends CrossoverListRate<DesignDecisionGenotype> implements Crossover<DesignDecisionGenotype> {

	@Inject
	public DesignDecisionCrossover(
			@Constant(value = "rate", namespace = ConstantCrossoverRate.class) double rate, 
			Rand random) {
		super(rate, random);
	}

}
