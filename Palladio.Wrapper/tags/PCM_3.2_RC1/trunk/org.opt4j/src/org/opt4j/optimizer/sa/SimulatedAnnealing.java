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

package org.opt4j.optimizer.sa;

import java.util.Random;

import org.opt4j.common.random.Rand;
import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.Objectives;
import org.opt4j.core.Population;
import org.opt4j.core.optimizer.AbstractOptimizer;
import org.opt4j.core.optimizer.Completer;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.StopException;
import org.opt4j.core.optimizer.TerminationException;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.copy.Copy;
import org.opt4j.operator.neighbor.Neighbor;

import com.google.inject.Inject;

/**
 * The {@code SimulatedAnnealing} is a standard implementation of the
 * optimization heuristic. This heuristic optimizes a single objective
 * (multi-objective problems are optimized by the sum of all objectives).
 * 
 * @author lukasiewycz
 * 
 */
public class SimulatedAnnealing extends AbstractOptimizer {

	protected final Random random;

	protected final Neighbor<Genotype> neighbor;

	protected final Copy<Genotype> copy;

	protected final int iterations;

	protected final CoolingSchedule coolingSchedule;

	/**
	 * Constructs a new {@code SimulatedAnnealing}.
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
	 * @param random
	 *            the random number generator
	 * @param neighbor
	 *            the neighbor operator
	 * @param copy
	 *            the copy operator
	 * @param iterations
	 *            the number of maximal iterations
	 * @param coolingSchedule
	 *            the cooling schedule
	 */
	@Inject
	public SimulatedAnnealing(Population population, Archive archive,
			IndividualBuilder individualBuilder, Completer completer,
			Control control, Rand random, Neighbor<Genotype> neighbor,
			Copy<Genotype> copy, @Iterations int iterations,
			CoolingSchedule coolingSchedule) {
		super(population, archive, individualBuilder, completer, control);
		this.random = random;
		this.neighbor = neighbor;
		this.copy = copy;
		this.iterations = iterations;
		this.coolingSchedule = coolingSchedule;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#optimize()
	 */
	public void optimize() throws TerminationException, StopException {

		Individual x = individualBuilder.build();
		Individual y = null;

		population.add(x);
		completer.complete(population);
		archive.update(x);
		nextIteration();

		double fx = f(x);
		double fy;

		for (int i = 0; i < iterations; i++) {

			Genotype g = copy.copy(x.getGenotype());
			neighbor.neighbor(g);

			y = individualBuilder.build(g);

			completer.complete(y);
			archive.update(y);

			fy = f(y);

			// boolean value that indicates a switch of the individuals
			boolean sw = false;

			if (fy <= fx) {
				sw = true;
			} else {
				double a = (fx - fy)
						/ coolingSchedule.getTemperature(i, iterations);
				double e = Math.exp(a);
				if (random.nextDouble() < e) {
					sw = true;
				}
			}

			if (sw) {
				population.remove(x);
				population.add(y);
				fx = fy;
				x = y;
			}

			nextIteration();
		}
	}

	/**
	 * Calculates the sum of the objectives of one individual.
	 * 
	 * @param individual
	 *            the individual
	 * @return the sum of the objective values
	 */
	protected double f(Individual individual) {
		Objectives objectives = individual.getObjectives();

		double sum = 0;

		for (double d : objectives.array()) {
			sum += d;
		}

		return sum;
	}

}
