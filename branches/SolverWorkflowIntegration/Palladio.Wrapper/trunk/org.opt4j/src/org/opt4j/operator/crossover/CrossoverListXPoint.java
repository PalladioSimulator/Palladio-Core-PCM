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
import java.util.SortedSet;
import java.util.TreeSet;

import org.opt4j.core.Genotype;
import org.opt4j.core.optimizer.Operator;
import org.opt4j.optimizer.ea.Pair;

import com.google.inject.Inject;

/**
 * <p>
 * The {@code CrossoverListXPoint} performs a crossover on {@link Genotype}
 * objects that are lists of values.
 * </p>
 * <p>
 * The crossover is performed on {@code x} points of the {@code Genotype}.
 * </p>
 * 
 * @author lukasiewycz
 * 
 */
public abstract class CrossoverListXPoint implements Operator {

	protected final int x;

	protected final Random random;

	/**
	 * Constructs a {@code CrossoverBooleanXPoint}.
	 * 
	 * @param x
	 *            the number of crossover points
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public CrossoverListXPoint(int x, Random random) {
		this.x = x;
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

		if (x <= 0 || x > size - 1) {
			throw new RuntimeException(this.getClass() + " : x is " + x
					+ " for binary vector size " + size);
		}

		SortedSet<Integer> points = new TreeSet<Integer>();

		while (points.size() < x) {
			points.add(random.nextInt(size - 1) + 1);
		}

		int flip = 0;
		boolean select = random.nextBoolean();

		for (int i = 0; i < size; i++) {
			if (i == flip) {
				select = !select;

				if (points.size() > 0) {
					flip = points.first();
					points.remove(flip);
				}
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
