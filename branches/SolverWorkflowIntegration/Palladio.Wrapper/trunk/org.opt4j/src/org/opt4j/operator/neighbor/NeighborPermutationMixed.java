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

import org.opt4j.core.Genotype;

import com.google.inject.Inject;

/**
 * <p>
 * Randomly selects between {@link NeighborPermutationSwap},
 * {@code NeighborInsertPermutation}, and {@link NeighborPermutationRevert}.
 * </p>
 * 
 * @author lukasiewycz
 * 
 */
public class NeighborPermutationMixed implements NeighborPermutation {

	protected final Random random;

	protected final NeighborPermutationSwap swap;

	protected final NeighborPermutationInsert insert;

	protected final NeighborPermutationRevert revert;

	/**
	 * Constructs a {@code NeighborPermutationMixed} operator for the
	 * {@code PermutationGenotype}.
	 * 
	 * @param swap
	 *            the swap permutation
	 * @param insert
	 *            the insert permutation
	 * @param revert
	 *            the revert permutation
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public NeighborPermutationMixed(NeighborPermutationSwap swap,
			NeighborPermutationInsert insert, NeighborPermutationRevert revert,
			Random random) {
		this.swap = swap;
		this.insert = insert;
		this.random = random;
		this.revert = revert;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.neighbor.Neighbor#neighbor(org.opt4j.core.Genotype)
	 */
	public void neighbor(Genotype genotype) {
		if (random.nextDouble() < 0.33) {
			swap.neighbor(genotype);
		} else if (random.nextBoolean()) {
			insert.neighbor(genotype);
		} else {
			revert.neighbor(genotype);
		}
	}
}
