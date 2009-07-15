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

package org.opt4j.operator.copy;

import java.util.List;

import org.opt4j.core.Genotype;
import org.opt4j.genotype.BooleanGenotype;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.genotype.ListGenotype;
import org.opt4j.genotype.PermutationGenotype;
import org.opt4j.operator.common.Apply;

/**
 * Copy operator for plain lists like {@link BooleanGenotype},
 * {@link DoubleGenotype}, and {@link PermutationGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
@Apply(ListGenotype.class)
public class CopyList implements Copy {

	/**
	 * Constructs a {@code CopyList}.
	 */
	public CopyList() {
		super();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.copy.Copy#copy(org.opt4j.core.Genotype)
	 */
	@SuppressWarnings("unchecked")
	public Genotype copy(Genotype genotype) {
		List<Object> original = (List<Object>) genotype;
		List<Object> copy = (List<Object>) genotype.newInstance();

		for (Object element : original) {
			copy.add(element);
		}

		return (Genotype) copy;
	}

}
