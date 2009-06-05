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

package org.opt4j.operator.crossover;

import java.util.List;
import java.util.Random;

import org.opt4j.core.Genotype;
import org.opt4j.optimizer.ea.Pair;

import com.google.inject.Inject;

/**
 * <p>
 * The {@code CrossoverListRate} performs a crossover on {@link Genotype}
 * objects that are lists of values.
 * </p>
 * <p>
 * A point of crossover of the list is selected with a given {@code rate}.
 * </p>
 * 
 * @author lukasiewycz
 * 
 */
public abstract class CrossoverListRate implements Crossover {

	protected final Random random;

	protected final double rate;

	/**
	 * Constructs a new {@code CrossoverListRate}.
	 * 
	 * @param rate
	 *            the rate for a crossover
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public CrossoverListRate(double rate, Random random) {
		this.rate = rate;
		this.random = random;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.crossover.Crossover#crossover(org.opt4j.core.Genotype,
	 * org.opt4j.core.Genotype)
	 */
	@SuppressWarnings("unchecked")
	public Pair<Genotype> crossover(Genotype parent1, Genotype parent2) {

		List<Object> p1 = (List<Object>) parent1;
		List<Object> p2 = (List<Object>) parent2;

		List<Object> o1 = (List<Object>) parent1.newInstance();
		List<Object> o2 = (List<Object>) parent2.newInstance();

		int size = p1.size();

		boolean select = random.nextBoolean();

		for (int i = 0; i < size; i++) {
			if (random.nextDouble() < rate) {
				select = !select;
			}

			if (select) {
				o1.add(p1.get(i));
				o2.add(p2.get(i));
			} else {
				o1.add(p2.get(i));
				o2.add(p1.get(i));
			}
		}

		Pair<Genotype> offspring = new Pair<Genotype>((Genotype) o1,
				(Genotype) o2);
		return offspring;
	}

}
