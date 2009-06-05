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

package org.opt4j.benchmark.queens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

import org.opt4j.core.problem.Creator;
import org.opt4j.core.problem.Decoder;
import org.opt4j.genotype.PermutationGenotype;

import com.google.inject.Inject;

/**
 * A permutation decoder strategy. The permutation contains the values {@code
 * 1,...,size}. This value indicates for each row in which column a queen is.
 * This strategy ensures that queens dont attack each other in rows and columns.
 * 
 * The genotype is a {@code PermutationGenotype} of the length {@code size}.
 * 
 * 
 * @author lukasiewycz
 * 
 */
public class QueensPermutationDecoder implements
		Decoder<PermutationGenotype<Integer>, QueensBoard>,
		Creator<PermutationGenotype<Integer>> {

	protected final QueensProblem problem;
	protected final Random random;

	/**
	 * Constructs a {@code QueensPermutationDecoder}.
	 * 
	 * @param problem
	 *            the queens problem
	 * @param random
	 *            the random number generator
	 * 
	 */
	@Inject
	public QueensPermutationDecoder(QueensProblem problem, Random random) {
		this.problem = problem;
		this.random = random;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.problem.Creator#create()
	 */
	public PermutationGenotype<Integer> create() {
		int size = problem.size();

		List<Integer> list = new ArrayList<Integer>();

		for (int i = 0; i < size; i++) {
			list.add(i);
		}

		Collections.shuffle(list, random);

		PermutationGenotype<Integer> genotype = new PermutationGenotype<Integer>();

		for (int i = 0; i < size; i++) {
			genotype.add(list.get(i));
		}

		return genotype;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.problem.Decoder#decode(org.opt4j.core.Genotype)
	 */
	public QueensBoard decode(PermutationGenotype<Integer> permutation) {
		int size = problem.size();

		QueensBoard queensBoard = new QueensBoard(size);

		for (int i = 0; i < permutation.size(); i++) {
			queensBoard.setQueen(i, permutation.get(i), true);
		}

		return queensBoard;
	}

}
