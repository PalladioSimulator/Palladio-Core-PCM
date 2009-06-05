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
import java.util.List;
import java.util.Random;

import org.opt4j.core.Individual;

import com.google.inject.Inject;

/**
 * The {@code CouplerRandom} uses the set of parents and creates couples
 * randomly from this set. In particular, there is no handling for duplicated
 * {@code Individuals} in the parents list or in one couple.
 * 
 * @author glass
 * 
 */
public class CouplerRandom implements Coupler {

	protected Random random;

	/**
	 * Constructs a {@code CouplerRandom} with a given {@code Random} number
	 * generator.
	 * 
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public CouplerRandom(Random random) {
		this.random = random;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mating.Coupler#getCouples(int, java.util.List)
	 */
	public Collection<Pair<Individual>> getCouples(int size,
			List<Individual> parents) {
		Collection<Pair<Individual>> couples = new ArrayList<Pair<Individual>>();
		for (int i = 0; i < size; i++) {

			Individual first = parents.get(random.nextInt(parents.size()));
			Individual second = parents.get(random.nextInt(parents.size()));
			Pair<Individual> pair = new Pair<Individual>(first, second);
			couples.add(pair);
		}
		return couples;
	}

}
