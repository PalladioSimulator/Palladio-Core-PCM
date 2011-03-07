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

package org.opt4j.optimizer.de;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.opt4j.common.random.Rand;
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
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.algebra.Add;
import org.opt4j.operator.algebra.Algebra;
import org.opt4j.operator.algebra.Index;
import org.opt4j.operator.algebra.Mult;
import org.opt4j.operator.algebra.Sub;
import org.opt4j.operator.algebra.Term;
import org.opt4j.operator.algebra.Var;
import org.opt4j.operator.crossover.Crossover;
import org.opt4j.optimizer.ea.Pair;
import org.opt4j.optimizer.ea.Selector;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code DifferentialEvolution}
 * 
 * @author lukasiewycz
 * 
 */
public class DifferentialEvolution extends AbstractOptimizer {

	protected final double scalingFactor;

	protected final int generations;

	protected final int alpha;

	protected final Algebra<Genotype> algebra;

	protected final Crossover<Genotype> crossover;

	protected final Selector selector;

	protected final Random random;

	/**
	 * Constructs a {@code DifferentialEvolution}.
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
	 * @param algebra
	 *            the algebra operator
	 * @param selector
	 *            the selector
	 * @param random
	 *            the random number generator
	 * @param crossover
	 *            the crossover operator
	 * @param generations
	 *            the number of generations
	 * @param alpha
	 *            the population size
	 * @param scalingFactor
	 *            the scaling factor F
	 */
	@Inject
	public DifferentialEvolution(
			Population population,
			Archive archive,
			IndividualBuilder individualBuilder,
			Completer completer,
			Control control,
			Algebra<Genotype> algebra,
			Selector selector,
			Rand random,
			Crossover<Genotype> crossover,
			@Iterations int generations,
			@Constant(value = "alpha", namespace = DifferentialEvolution.class) int alpha,
			@Constant(value = "scalingFactor", namespace = DifferentialEvolution.class) double scalingFactor) {
		super(population, archive, individualBuilder, completer, control);
		this.algebra = algebra;
		this.selector = selector;
		this.random = random;
		this.crossover = crossover;
		this.generations = generations;
		this.alpha = alpha;
		this.scalingFactor = scalingFactor;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#optimize()
	 */
	public void optimize() throws StopException, TerminationException {

		Index i0 = new Index(0);
		Index i1 = new Index(1);
		Index i2 = new Index(2);
		Var c = new Var(scalingFactor);

		Term term = new Add(i0, new Mult(c, new Sub(i1, i2)));

		selector.init(2 * alpha);
		while (population.size() < alpha) {
			population.add(individualBuilder.build());
		}

		nextIteration();

		for (int i = 0; i < generations; i++) {

			/*
			 * Map from each parent to its offspring
			 */
			Map<Individual, Individual> relation = new HashMap<Individual, Individual>();

			/*
			 * Create an offspring for each parent individual in the population
			 * and add the offspring to the population and evaluate their
			 * objectives
			 */
			List<Individual> list = new ArrayList<Individual>(population);
			for (Individual parent : population) {
				Individual offspring = createOffspring(parent, list, term);
				relation.put(parent, offspring);
			}
			population.addAll(relation.values());
			completer.complete(population);

			/*
			 * Remove those offspring individuals from the population that are
			 * dominated by their corresponding parent
			 */
			for (Entry<Individual, Individual> entry : relation.entrySet()) {
				Individual parent = entry.getKey();
				Individual offspring = entry.getValue();

				if (parent.getObjectives().weaklyDominates(
						offspring.getObjectives())) {
					population.remove(offspring);
				}
			}

			/*
			 * Truncate the population size to alpha
			 */
			Collection<Individual> lames = selector.getLames(population.size()
					- alpha, population);
			population.removeAll(lames);

			nextIteration();
		}
	}

	protected Individual createOffspring(Individual parent,
			List<Individual> individuals, Term term) {
		Triple triple = getTriple(parent, individuals);

		Genotype g0 = triple.getFirst().getGenotype();
		Genotype g1 = triple.getSecond().getGenotype();
		Genotype g2 = triple.getThird().getGenotype();

		Genotype result = algebra.algebra(term, g0, g1, g2);
		Pair<Genotype> g = crossover.crossover(result, parent.getGenotype());

		Individual i;
		if (random.nextBoolean()) {
			i = individualBuilder.build(g.getFirst());
		} else {
			i = individualBuilder.build(g.getSecond());
		}
		return i;
	}

	/**
	 * The {@code Triple} is a container for three individuals.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	protected static class Triple {
		protected final Individual first;

		protected final Individual second;

		protected final Individual third;

		public Triple(final Individual first, final Individual second,
				final Individual third) {
			super();
			this.first = first;
			this.second = second;
			this.third = third;
		}

		public Individual getFirst() {
			return first;
		}

		public Individual getSecond() {
			return second;
		}

		public Individual getThird() {
			return third;
		}
	}

	/**
	 * Returns three different Individuals from the individuals list. Each
	 * Individual is not equal to the parent.
	 * 
	 * @param parent
	 *            the parent Individual
	 * @param individuals
	 *            the popuation
	 * @return the three individuals as a Triple
	 */
	protected Triple getTriple(Individual parent, List<Individual> individuals) {
		individuals.remove(parent);
		Individual ind0 = individuals
				.remove(random.nextInt(individuals.size()));
		Individual ind1 = individuals
				.remove(random.nextInt(individuals.size()));
		Individual ind2 = individuals
				.remove(random.nextInt(individuals.size()));

		Triple triple = new Triple(ind0, ind1, ind2);

		individuals.add(parent);
		individuals.add(ind0);
		individuals.add(ind1);
		individuals.add(ind2);

		return triple;

	}

}
