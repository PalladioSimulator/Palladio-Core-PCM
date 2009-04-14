/**
 * Opt4J is free software: you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the
 * Free Software Foundation, either version 3 of the License, or (at your
 * option) any later version.
 * 
 * Opt4J is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or
 * FITNESS FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public
 * License for more details.
 * 
 * You should have received a copy of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */
package org.opt4j.optimizer.ea;

import java.util.Collection;

import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.Population;
import org.opt4j.core.optimizer.AbstractOptimizer;
import org.opt4j.core.optimizer.Completer;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.StopException;
import org.opt4j.core.optimizer.TerminationException;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code EvolutionaryAlgorithm} is an implementation of an Evolutionary
 * Algorithm. It uses a {@code Selector} to determine the fitness of the {@code
 * Individuals}.
 * 
 * @author glass
 * 
 */
public class EvolutionaryAlgorithm extends AbstractOptimizer {

	protected final int generations;

	protected final int alpha;

	protected final int lambda;

	protected final int mu;

	protected final Selector selector;

	protected final Mating mating;

	/**
	 * Constructs an {@code EvolutionaryAlgorithm} with a {@code Population}, an
	 * {@code Archive}, an {@code IndividualBuilder}, a {@code Completer}, a
	 * {@code Control}, a {@code Selector}, a {@code Mating}, the number of
	 * generations, the population size, the number of parents, the number of
	 * offspring, and a random number generator.
	 * 
	 * @param population
	 *            the population
	 * @param archive
	 *            the archive
	 * @param individualBuilder
	 *            the individual builder
	 * @param completer
	 *            the completer
	 * @param control
	 *            the control
	 * @param selector
	 *            the selector
	 * @param mating
	 *            the mating
	 * @param generations
	 *            the number of generations
	 * @param alpha
	 *            the population size
	 * @param mu
	 *            the number of parents
	 * @param lambda
	 *            the number of offspring
	 */
	@Inject
	public EvolutionaryAlgorithm(
			Population population,
			Archive archive,
			IndividualBuilder individualBuilder,
			Completer completer,
			Control control,
			Selector selector,
			Mating mating,
			@Iterations int generations,
			@Constant(value = "alpha", namespace = EvolutionaryAlgorithm.class) int alpha,
			@Constant(value = "mu", namespace = EvolutionaryAlgorithm.class) int mu,
			@Constant(value = "lambda", namespace = EvolutionaryAlgorithm.class) int lambda) {
		super(population, archive, individualBuilder, completer, control);
		this.selector = selector;
		this.mating = mating;
		this.generations = generations;
		this.alpha = alpha;
		this.mu = mu;
		this.lambda = lambda;

		if (alpha <= 0) {
			throw new IllegalArgumentException("Invalid alpha: " + alpha);
		}

		if (mu <= 0) {
			throw new IllegalArgumentException("Invalid mu: " + mu);
		}

		if (lambda <= 0) {
			throw new IllegalArgumentException("Invalid lambda: " + lambda);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#optimize()
	 */
	public void optimize() throws TerminationException, StopException {

		selector.init(alpha + lambda);

		while (population.size() < alpha) {
			population.add(individualBuilder.build());
		}

		nextIteration();

		for (int g = 0; g < generations; g++) {

			Collection<Individual> parents = selector
					.getParents(mu, population);
			Collection<Individual> offspring = mating.getOffspring(lambda,
					parents);
			population.addAll(offspring);
			
			//Annes line
			archive.update(offspring);

			// evaluate offspring before selecting lames
			completer.complete(offspring);

			Collection<Individual> lames = selector
					.getLames(lambda, population);
			population.removeAll(lames);

			nextIteration();
		}
	}
}
