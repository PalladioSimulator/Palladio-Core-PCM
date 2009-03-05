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

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

import org.opt4j.core.Genotype;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.operator.copy.Copy;
import org.opt4j.operator.crossover.Crossover;
import org.opt4j.operator.mutate.Mutate;

import com.google.inject.Inject;

/**
 * The {@code Mating} creates offspring from a given set of parents.
 * 
 * @author glass
 * 
 */
public class Mating {

	protected final Crossover crossover;
	protected final Mutate mutate;
	protected final Copy copy;
	protected final Coupler coupler;
	protected final CrossoverRate crossoverRate;
	protected final Random random;
	protected final IndividualBuilder individualBuilder;

	/**
	 * Constructs a {@code EvolutionaryAlgorithmMating} with a given {@code
	 * Crossover}, {@code Mutate}, {@code Copy}, {@code PairCoupler}, {@code
	 * CrossoverRate}, {@code Random}, and {@code IndividualBuilder}.
	 * 
	 * @param crossover
	 *            the crossover operator
	 * @param mutate
	 *            the mutate operator
	 * @param copy
	 *            the copy operator
	 * @param coupler
	 *            the coupler
	 * @param crossoverRate
	 *            the used crossover rate
	 * @param random
	 *            the random number generator
	 * @param individualBuilder
	 *            the individual builder
	 */
	@Inject
	public Mating(Crossover crossover, Mutate mutate,
			Copy copy, Coupler coupler, CrossoverRate crossoverRate,
			Random random, IndividualBuilder individualBuilder) {
		super();
		this.crossover = crossover;
		this.mutate = mutate;
		this.copy = copy;
		this.coupler = coupler;
		this.crossoverRate = crossoverRate;
		this.random = random;
		this.individualBuilder = individualBuilder;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mating.Mating#getOffspring(int,
	 * java.util.Collection)
	 */
	public Collection<Individual> getOffspring(int size,
			Collection<Individual> parents) {
		Collection<Individual> offspring = new ArrayList<Individual>();
		Collection<Pair<Individual>> couples = coupler.getCouples((int) Math
				.ceil(((double) size / 2)), new ArrayList<Individual>(parents));

		for (Pair<Individual> couple : couples) {
			boolean crossover = random.nextDouble() <= crossoverRate.get();
			Individual parent1 = couple.getFirst();
			Individual parent2 = couple.getSecond();
			Pair<Individual> i = mate(parent1, parent2, crossover);
			Individual i1 = i.getFirst();
			Individual i2 = i.getSecond();
			
			offspring.add(i1);
			if (offspring.size() < size) {
				offspring.add(i2);
			}
		}

		return offspring;
	}

	/**
	 * Performs the actual coupler process of two parents.
	 * 
	 * @param parent1
	 *            parent one
	 * @param parent2
	 *            parent two
	 * @param doCrossover
	 *            indicates whether the coupler shall take place
	 * @return the two offspring individuals
	 */
	private Pair<Individual> mate(Individual parent1, Individual parent2,
			boolean doCrossover) {
		Genotype p1 = parent1.getGenotype();
		Genotype p2 = parent2.getGenotype();
		Genotype o1, o2;

		if (doCrossover) {
			Pair<Genotype> offspring = crossover.crossover(p1, p2);
			o1 = offspring.getFirst();
			o2 = offspring.getSecond();
		} else {
			o1 = copy.copy(p1);
			o2 = copy.copy(p2);
		}

		mutate.mutate(o1);
		mutate.mutate(o2);

		Individual i1 = individualBuilder.build(o1);
		Individual i2 = individualBuilder.build(o2);

		Pair<Individual> individuals = new Pair<Individual>(i1, i2);
		return individuals;
	}

}
