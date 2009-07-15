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
import org.opt4j.genotype.DoubleGenotype;

/**
 * The {@code DiversityDoubleAbsolute} calculates the {@code Diversity} as the
 * mean absolute difference of each entry in the double vector.
 * 
 * @author glass, lukasiewycz
 * 
 */
public class DiversityDoubleAbsolute implements DiversityDouble {

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.diversity.Diversity#diversity(org.opt4j.core.Genotype,
	 *      org.opt4j.core.Genotype)
	 */
	public double diversity(Genotype a, Genotype b) {
		DoubleGenotype genotypeA = (DoubleGenotype) a;
		DoubleGenotype genotypeB = (DoubleGenotype) b;

		int size = genotypeA.size();

		double diversity = 0;
		for (int i = 0; i < size; i++) {
			double diff = genotypeA.getUpperBound(i)*genotypeA.getLowerBound(i);
			diversity += Math.abs(genotypeA.get(i) - genotypeB.get(i))/diff;
		}

		return diversity / size;
	}

}
