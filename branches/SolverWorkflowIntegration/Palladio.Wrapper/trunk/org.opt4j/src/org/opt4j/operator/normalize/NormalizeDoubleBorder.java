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

package org.opt4j.operator.normalize;

import org.opt4j.core.Genotype;
import org.opt4j.genotype.DoubleGenotype;

/**
 * The {@code NormalizeDoubleBorder} normalizes the {@code DoubleGenotype} by
 * setting the values to the borders if the bounds are violated.
 * 
 * @author lukasiewycz
 * 
 */
public class NormalizeDoubleBorder implements NormalizeDouble {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.normalize.Normalize#normalize(org.opt4j.core.Genotype)
	 */
	@Override
	public void normalize(Genotype genotype) {
		DoubleGenotype d = (DoubleGenotype) genotype;

		int size = d.size();

		for (int i = 0; i < size; i++) {
			double value = d.get(i);
			if (value < d.getLowerBound(i)) {
				d.set(i, d.getLowerBound(i));
			} else if (value > d.getUpperBound(i)) {
				d.set(i, d.getUpperBound(i));
			}
		}

	}

}
