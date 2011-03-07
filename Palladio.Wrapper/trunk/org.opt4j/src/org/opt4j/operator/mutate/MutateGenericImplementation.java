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

import java.util.Collection;

import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.AbstractGenericOperator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Implementation of the {@link MutateGeneric} interface.
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
public class MutateGenericImplementation extends
		AbstractGenericOperator<Mutate<Genotype>> implements MutateGeneric {

	/**
	 * Constructs the {@link MutateGenericImplementation}.
	 * 
	 * @param holder
	 *            the holder contains all mutate operators
	 */
	@Inject
	protected MutateGenericImplementation(MutateHolder holder) {
		this(holder.get());
	}

	/**
	 * The {@code MutateHolder} holds all mutate operators.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	static class MutateHolder extends OperatorHolder<Mutate<?>> {

		/**
		 * Constructs a {@code MutateHolder}.
		 * 
		 * @param mutateBoolean
		 *            the mutate operator for the {@code BooleanGenotype}
		 * @param mutateDouble
		 *            the mutate operator for the {@code DoubleGenotype}
		 * @param mutateInteger
		 *            the mutate operator for the {@code IntegerGenotype}
		 * @param mutateComposite
		 *            the mutate operator for the {@code CompositeGenotype}
		 * @param mutatePermutation
		 *            the mutate operator for the {@code PermutationGenotype}
		 */
		@Inject
		protected MutateHolder(MutateBoolean mutateBoolean,
				MutateDouble mutateDouble, MutateInteger mutateInteger,
				MutateComposite mutateComposite,
				MutatePermutation mutatePermutation) {
			add(mutateBoolean);
			add(mutateDouble);
			add(mutateInteger);
			add(mutateComposite);
			add(mutatePermutation);
		}
	}

	/**
	 * Constructs a {@code MutateGenericImplementation} with a collection of
	 * mutate operators.
	 * 
	 * @param mutates
	 *            the mutate operators
	 */
	@SuppressWarnings("unchecked")
	public MutateGenericImplementation(Collection<Mutate<?>> mutates) {
		for (Mutate<?> mutate : mutates) {
			addOperator((Mutate<Genotype>) mutate);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mutate.Mutate#mutate(org.opt4j.core.Genotype)
	 */
	public void mutate(Genotype genotype) {
		Mutate<Genotype> mutate = getOperator(genotype.getClass());
		mutate.mutate(genotype);
	}
}
