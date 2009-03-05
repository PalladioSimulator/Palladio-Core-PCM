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
 * The {@code NormalizeDoubleMirror} normalizes the {@code DoubleGenotype} by
 * mirroring the values on the borders if the bounds are violated.
 * 
 * @author lukasiewycz
 * 
 */
public class NormalizeDoubleMirror implements NormalizeDouble {

	@Override
	public void normalize(Genotype genotype) {

		DoubleGenotype d = (DoubleGenotype) genotype;

		int size = d.size();

		for (int i = 0; i < size; i++) {
			double value = d.get(i);

			boolean out = false;

			double lb = d.getLowerBound(i);
			double ub = d.getUpperBound(i);

			if (value < lb) {
				out = true;
			} else if (value > ub) {
				out = true;
			}

			if (out) {
				value = mirror(value, lb, ub);
				d.set(i, value);
			}

		}

	}

	protected double mirror(double x, double lb, double ub) {
		double nh = (x - lb) / (ub - lb);

		if (nh < 0) {
			nh = -nh;
		}

		if (nh > 1) {
			double g = Math.floor(nh);
			if (g % 2 == 0) {
				nh = nh - g;
			} else {
				nh = 1 - (nh - g);
			}
		}

		return (nh * (ub - lb)) + lb;
	}

}
