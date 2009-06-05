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

import org.opt4j.core.Genotype;
import org.opt4j.genotype.CompositeGenotype;
import org.opt4j.operator.common.Apply;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Mutate for the {@link CompositeGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
@Apply(CompositeGenotype.class)
public class MutateComposite implements Mutate {

	protected final MutateGeneric mutateGeneric;

	/**
	 * Constructs a new {@code MutateComposite} for the
	 * {@code CompositeGenotype}.
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
	@SuppressWarnings("unchecked")
	public void mutate(Genotype genotype) {
		CompositeGenotype composite = (CompositeGenotype) genotype;

		for (Object entry : composite.values()) {
			mutateGeneric.mutate((Genotype) entry);
		}

	}

}
