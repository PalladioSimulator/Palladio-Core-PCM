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

package org.opt4j.operator.neighbor;

import java.util.Random;

import org.opt4j.common.random.Rand;
import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.CompositeGenotype;

import com.google.inject.Inject;

/**
 * The {@code NeighborComposite} operator for the {@link CompositeGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
public class NeighborComposite implements Neighbor<CompositeGenotype<?, ?>> {

	protected final NeighborGeneric neighborGeneric;

	protected final Random random;

	/**
	 * Constructs a {@code NeighborComposite}.
	 * 
	 * @param neighborGeneric
	 *            a Neighbor operator for the elements of the {@code
	 *            CompositeGenotype}
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public NeighborComposite(final NeighborGeneric neighborGeneric, Rand random) {
		this.neighborGeneric = neighborGeneric;
		this.random = random;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.neighbor.Neighbor#neighbor(org.opt4j.core.Genotype)
	 */
	public void neighbor(CompositeGenotype<?, ?> genotype) {
		int size = genotype.size();

		int i = random.nextInt(size);
		int sum = 0;

		Genotype g = null;

		for (Genotype entry : genotype.values()) {
			g = entry;
			sum += g.size();
			if (i < sum) {
				break;
			}
		}

		neighborGeneric.neighbor(g);
	}

}
