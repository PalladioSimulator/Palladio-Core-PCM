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

import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.CompositeGenotype;

import com.google.inject.Inject;

/**
 * The {@code DiversityComposite} is an implementation of the {@code Diversity}
 * operator for the {@code CompositeGenotype}.
 * 
 * @author glass
 * 
 */
public class DiversityComposite implements Diversity<CompositeGenotype<?, ?>> {

	protected final DiversityGeneric diversityGeneric;

	/**
	 * Constructs a new {@code DiversityComposite} for the {@code
	 * CompositeGenotype}.
	 * 
	 * @param diversityGeneric
	 *            a generic diversity that can handle different types of
	 *            genotypes
	 */
	@Inject
	public DiversityComposite(DiversityGeneric diversityGeneric) {
		this.diversityGeneric = diversityGeneric;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.diversity.Diversity#distance(org.opt4j.core.Genotype,
	 * org.opt4j.core.Genotype)
	 */
	public double diversity(CompositeGenotype<?, ?> a, CompositeGenotype<?, ?> b) {
		
		double diversity = 0;
		for (Object key : a.keySet()) {
			Genotype childA = a.get(key);
			Genotype childB = b.get(key);
			int size = a.size();

			diversity += diversityGeneric.diversity(childA, childB) * size;
		}
		return diversity / a.size();

	}

}
