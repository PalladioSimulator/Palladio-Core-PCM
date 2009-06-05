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
package org.opt4j.operator.diversity;

import org.opt4j.core.Genotype;
import org.opt4j.genotype.IntegerGenotype;

/**
 * The {@code DiversityIntegerEuclidean} is an implementation of the
 * {@link DiversityInteger} that calculates the diversity of two
 * {@link IntegerGenotype} objects by normalizing the values to {@code [0,1]}
 * and calculating the euclidean distance.
 * 
 * @author lukasiewycz
 * 
 */
public class DiversityIntegerEuclidean implements DiversityInteger {

	@Override
	public double diversity(Genotype a, Genotype b) {
		IntegerGenotype genotypeA = (IntegerGenotype) a;
		IntegerGenotype genotypeB = (IntegerGenotype) b;

		double diversity = 0;
		int size = genotypeA.size();
		for (int i = 0; i < size; i++) {
			double diff = genotypeA.getUpperBound(i)
					* genotypeA.getLowerBound(i);
			double dist = ((double) genotypeA.get(i) - (double) genotypeB
					.get(i))
					/ diff;
			diversity += dist * dist;
		}

		return Math.sqrt(diversity) / Math.sqrt(size);
	}

}
