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

package org.opt4j.operator.algebra;

import java.util.Random;

import org.opt4j.core.Genotype;
import org.opt4j.genotype.BooleanGenotype;
import org.opt4j.operator.common.Apply;

import com.google.inject.Inject;

/**
 * The {@code AlgebraBoolean} for {@link BooleanGenotype}. Status: Experimental.
 * 
 * @author lukasiewycz
 * 
 */
@Apply(BooleanGenotype.class)
public class AlgebraBoolean implements Algebra {

	protected final Random random;

	/**
	 * Constructs an {@code AlgebraBoolean}.
	 * 
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public AlgebraBoolean(Random random) {
		super();
		this.random = random;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.algebra.Algebra#algebra(org.opt4j.operator.algebra
	 * .Term, org.opt4j.core.Genotype[])
	 */
	public Genotype algebra(Term term, Genotype... genotypes) {
		int n = genotypes.length;
		assert (n > 0);

		BooleanGenotype[] list = new BooleanGenotype[n];

		for (int i = 0; i < n; i++) {
			list[i] = (BooleanGenotype) genotypes[i];
		}

		BooleanGenotype offspring = list[0].newInstance();
		offspring.clear();

		int size = list[0].size();

		double[] values = new double[n];

		for (int j = 0; j < size; j++) {
			for (int i = 0; i < n; i++) {
				double u = random.nextDouble();
				if (list[i] == null) {
					values[i] = 0;
				} else {
					boolean value = list[i].get(j);
					if (!value) {
						values[i] = Math.pow(u, 4);
					} else {
						values[i] = 1 - Math.pow(u, 4);
					}
				}
			}
			double result = term.calculate(values);
			result = 1 / (1 + Math.exp(-(result - 0.5) * 6));

			double y = random.nextDouble();
			boolean r = (result > y);

			offspring.add(r);
		}

		return offspring;
	}

}
