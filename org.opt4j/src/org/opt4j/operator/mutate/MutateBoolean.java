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

package org.opt4j.operator.mutate;

import java.util.Random;

import org.opt4j.core.Genotype;
import org.opt4j.genotype.BooleanGenotype;
import org.opt4j.operator.common.Apply;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Mutate for the {@link BooleanGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
@Apply(BooleanGenotype.class)
public class MutateBoolean implements Mutate {

	protected final Random random;

	protected final MutationRate mutationRate;

	/**
	 * Constructs a new {@code MutateBoolean} with the given mutation rate.
	 * 
	 * @param mutationRate
	 *            the mutation rate for the mutation operation
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public MutateBoolean(MutationRate mutationRate, Random random) {
		this.mutationRate = mutationRate;
		this.random = random;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mutate.Mutate#mutate(org.opt4j.core.Genotype)
	 */
	public void mutate(Genotype genotype) {
		BooleanGenotype vector = (BooleanGenotype) genotype;

		int size = vector.size();

		for (int i = 0; i < size; i++) {
			if (random.nextDouble() < mutationRate.get()) {
				vector.set(i, !vector.get(i));
			}
		}

	}

}
