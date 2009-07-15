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

import org.opt4j.operator.normalize.NormalizeDouble;

import com.google.inject.Inject;

/**
 * The {@code MutateDoubleDefault} is the {@link MutateDoublePolynomial} with
 * {@code eta=20}.
 * 
 * @author lukasiewycz
 * 
 */
public class MutateDoubleDefault extends MutateDoublePolynomial {

	/**
	 * Constructs a {@code MutateDoubleDefault} with a {@code MutationRate}, a
	 * {@code Random} number generator, and a {@code DoubleNormalizeOperator}.
	 * 
	 * @param mutationRate
	 *            the mutation rate
	 * @param random
	 *            the random number generator
	 * @param normalize
	 *            the normalizer
	 */
	@Inject
	public MutateDoubleDefault(MutationRate mutationRate, Random random,
			NormalizeDouble normalize) {
		super(mutationRate, random, normalize, 20);
	}

}
