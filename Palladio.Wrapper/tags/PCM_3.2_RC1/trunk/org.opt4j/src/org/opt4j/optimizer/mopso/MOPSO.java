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
package org.opt4j.optimizer.mopso;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map.Entry;

import org.opt4j.common.archive.CrowdingArchive;
import org.opt4j.common.random.Rand;
import org.opt4j.core.Archive;
import org.opt4j.core.IncompatibilityException;
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
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.operator.algebra.Add;
import org.opt4j.operator.algebra.AlgebraDouble;
import org.opt4j.operator.algebra.Index;
import org.opt4j.operator.algebra.Term;
import org.opt4j.operator.normalize.NormalizeDouble;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code MOPSO} is an implementation of a muli-objective particle swarm
 * optimizer. This implementation is based on the OMOPSO. Thus, this MOPSO is
 * restricted to problems that are based on the {@code DoubleGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
public class MOPSO extends AbstractOptimizer {

	protected final int iterations;

	protected final int size;

	protected final Archive leaders;

	protected final ParticleBuilder particleBuilder;

	protected final AlgebraDouble algebra;

	protected final Random random;

	protected final VelocityTerm velocityTerm;

	protected final Term positionTerm;

	protected final MutateDoubleUniform uniform;

	protected final MutateDoubleUniform nonUniform;

	/**
	 * Constructs a {@code MOPSO}.
	 * 
	 * @param population
	 *            the population
	 * @param archive
	 *            the archive
	 * @param individualBuilder
	 *            the individual (particle) builder
	 * @param completer
	 *            the completer
	 * @param control
	 *            the control
	 * @param random
	 *            the random number generator
	 * @param uniform
	 *            the uniform mutation
	 * @param nonUniform
	 *            the non-uniform mutation
	 * @param iterations
	 *            the number of iterations
	 * @param size
	 *            the number of particles
	 * @param archiveSize
	 *            the size of the archive for the global leaders
	 */
	@Inject
	public MOPSO(
			Population population,
			Archive archive,
			IndividualBuilder individualBuilder,
			Completer completer,
			Control control,
			Rand random,
			MutateDoubleUniform uniform,
			MutateDoubleNonUniform nonUniform,
			@Iterations int iterations,
			@Constant(value = "size", namespace = MOPSO.class) int size,
			@Constant(value = "archiveSize", namespace = MOPSO.class) int archiveSize) {
		super(population, archive, individualBuilder, completer, control);
		this.particleBuilder = (ParticleBuilder) individualBuilder;
		this.leaders = new CrowdingArchive(archiveSize);
		this.random = random;
		this.uniform = uniform;
		this.nonUniform = nonUniform;

		this.size = size;
		this.iterations = iterations;

		this.algebra = new AlgebraDouble(new NormalizeDouble() {
			@Override
			public void normalize(DoubleGenotype genotype) {
				// do nothing
			}
		});

		Index x = new Index(0);
		Index v = new Index(1);
		positionTerm = new Add(x, v);
		velocityTerm = new VelocityTerm(random);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#optimize()
	 */
	public void optimize() throws StopException, TerminationException {

		initPopulation();
		nextIteration();

		for (int i = 0; i < iterations; i++) {

			// determine the leaders
			updateLeaders(leaders, population);

			// determine one leader for each particle
			Map<Particle, Particle> lead = getLeaders(leaders, population);
			// determine the next position of each particle
			Map<Particle, Particle> next = move(population, lead);

			population.addAll(next.values());
			completer.complete(population);

			// update the personal best of each particle
			updatePersonalBest(next);

			// remove the old positions
			population.removeAll(next.keySet());

			nextIteration();

		}

	}

	/**
	 * Determine the new positions for the particles in the population.
	 * 
	 * @param population
	 *            the population
	 * @param leaders
	 *            the map for the global leaders
	 * @return the map of the old to the new particle
	 */
	protected Map<Particle, Particle> move(Population population,
			Map<Particle, Particle> leaders) {
		Map<Particle, Particle> map = new HashMap<Particle, Particle>();

		for (Individual individual : population) {

			Particle particle = (Particle) individual;

			DoubleGenotype position = (DoubleGenotype) particle.getGenotype();
			DoubleGenotype velocity = (DoubleGenotype) particle.getVelocity();
			DoubleGenotype best = (DoubleGenotype) particle.getBest();
			int id = particle.getId();

			DoubleGenotype leader = (DoubleGenotype) leaders.get(particle)
					.getGenotype();

			velocityTerm.randomize();

			DoubleGenotype nextVelocity = algebra.algebra(velocityTerm,
					position, velocity, best, leader);

			DoubleGenotype nextPosition = algebra.algebra(positionTerm,
					position, nextVelocity);

			for (int k = 0; k < nextPosition.size(); k++) {
				double value = nextPosition.get(k);
				double lb = nextPosition.getLowerBound(k);
				double ub = nextPosition.getUpperBound(k);
				if (value < lb) {
					nextPosition.set(k, lb);
					nextVelocity.set(k, -nextVelocity.get(k));
				} else if (value > ub) {
					nextPosition.set(k, ub);
					nextVelocity.set(k, -nextVelocity.get(k));
				}
			}

			if (id % 3 == 0) {
				uniform.mutate(nextPosition);
			} else if (id % 3 == 1) {
				nonUniform.mutate(nextPosition);
			} // else do nothing

			Particle p = particleBuilder.build(id, nextPosition, nextVelocity);

			map.put(particle, p);
		}

		return map;
	}

	/**
	 * Initialize the population.
	 */
	protected void initPopulation() {
		int id = 0;
		while (population.size() < size) {
			Particle particle = particleBuilder.build();
			particle.setId(id++);
			Genotype genotype = particle.getGenotype();
			if (!(genotype instanceof DoubleGenotype)) {
				throw new IncompatibilityException("MOPSO is restricted to "
						+ DoubleGenotype.class + ", current Genotype is: "
						+ genotype.getClass());
			}
			population.add(particle);
		}
	}

	/**
	 * Update the global leaders archive.
	 * 
	 * @param leaders
	 *            the archive
	 * @param population
	 *            the population
	 */
	protected void updateLeaders(Archive leaders, Population population) {
		leaders.update(population);
	}

	/**
	 * Update the personal best of each {@code Particle}.
	 * 
	 * @param next
	 *            the old and new positions
	 */
	protected void updatePersonalBest(Map<Particle, Particle> next) {
		for (Entry<Particle, Particle> entry : next.entrySet()) {

			Particle old = entry.getKey();
			Particle current = entry.getValue();

			if (dominates(old, current)) {
				current.setBest(old.getBest(), old.getBestObjectives());
			} else {
				current.setBest(current.getGenotype(), current.getObjectives());
			}
		}
	}

	/**
	 * Returns {@code true} if the old particle position dominates the new one.
	 * 
	 * @param old
	 *            the old particle
	 * @param current
	 *            the new particle
	 * @return {@code true} if the old particle position dominates the new one
	 */
	protected boolean dominates(Particle old, Particle current) {
		if (old.getBest() == null) {
			return false;
		}

		Objectives oldObjectives = old.getBestObjectives();
		Objectives currentObjectives = current.getObjectives();
		return oldObjectives.dominates(currentObjectives);
	}

	/**
	 * Assigns each {@code Particle} a leader.
	 * 
	 * @param leaders
	 *            the archive of available leader
	 * @param population
	 *            the population
	 * @return the map of each particle to its leader
	 */
	protected Map<Particle, Particle> getLeaders(Archive leaders,
			Population population) {
		Map<Particle, Particle> map = new HashMap<Particle, Particle>();

		Crowding crowding = new Crowding();
		Map<Individual, Double> values = crowding.getValues(leaders);

		List<Individual> l = new ArrayList<Individual>(leaders);
		List<Individual> best = new ArrayList<Individual>();

		for (int i = 0; i < population.size(); i++) {
			Individual i1 = l.get(random.nextInt(l.size()));
			Individual i2 = l.get(random.nextInt(l.size()));

			if (values.get(i1) >= values.get(i2)) {
				best.add(i1);
			} else {
				best.add(i2);
			}
		}

		int i = 0;

		for (Individual individual : population) {
			Particle particle = (Particle) individual;
			Particle leader = (Particle) best.get(i++);
			map.put(particle, leader);
		}

		return map;
	}
}
