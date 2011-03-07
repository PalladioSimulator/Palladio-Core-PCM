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

import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.CompositeGenotype;

import com.google.inject.Inject;

/**
 * Mutate for the {@link CompositeGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
public class MutateComposite implements Mutate<CompositeGenotype<?, ?>> {

	protected final MutateGeneric mutateGeneric;

	/**
	 * Constructs a new {@code MutateComposite} for the {@code
	 * CompositeGenotype}.
	 * 
	 * @param mutateGeneric
	 *            a generic mutate which can handle different types of genotypes
	 */
	@Inject
	public MutateComposite(MutateGeneric mutateGeneric) {
		this.mutateGeneric = mutateGeneric;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mutate.Mutate#mutate(org.opt4j.core.Genotype)
	 */
	public void mutate(CompositeGenotype<?, ?> genotype) {
		for (Genotype entry : genotype.values()) {
			mutateGeneric.mutate(entry);
		}

	}

}
