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

import org.opt4j.core.Genotype;
import org.opt4j.genotype.CompositeGenotype;
import org.opt4j.operator.common.Apply;

import com.google.inject.Inject;

/**
 * Copy operator for the {@link CompositeGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
@Apply(CompositeGenotype.class)
public class CopyComposite implements Copy {

	protected final CopyGeneric copyGeneric;

	/**
	 * Constructs a new {@link CopyComposite}.
	 * 
	 * @param copyGeneric
	 *            the {@code CopyGeneric}
	 */
	@Inject
	public CopyComposite(final CopyGeneric copyGeneric) {
		this.copyGeneric = copyGeneric;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.copy.Copy#copy(org.opt4j.core.Genotype)
	 */
	@SuppressWarnings("unchecked")
	public Genotype copy(Genotype genotype) {
		CompositeGenotype g = (CompositeGenotype) genotype;
		
		CompositeGenotype offspring = genotype.newInstance();
		offspring.clear();

		for (final Object key : g.keySet()) {
			Genotype go = copyGeneric.copy(g.get(key));

			offspring.put(key, go);
		}

		return offspring;
	}

}
