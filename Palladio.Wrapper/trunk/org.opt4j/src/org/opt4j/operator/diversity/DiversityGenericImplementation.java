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

import java.util.Collection;

import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.BooleanGenotype;
import org.opt4j.genotype.CompositeGenotype;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.genotype.IntegerGenotype;
import org.opt4j.genotype.PermutationGenotype;
import org.opt4j.operator.AbstractGenericOperator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The {@code DiversityGenericImplementation} is a standard implementation of
 * the {@code DiversityGeneric} interface.
 * 
 * @author glass, lukasiewycz
 * 
 */
@Singleton
public class DiversityGenericImplementation extends
		AbstractGenericOperator<Diversity<Genotype>> implements DiversityGeneric {

	/**
	 * Constructs the {@link DiversityGenericImplementation}.
	 * 
	 * @param holder
	 *            the holder contains all diversity operators
	 */
	@Inject
	protected DiversityGenericImplementation(DiversityHolder holder) {
		this(holder.get());
	}

	/**
	 * The {@code DiversityHolder} holds all diversity operators.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	static class DiversityHolder extends OperatorHolder<Diversity<?>> {

		/**
		 * Constructs a {@code DiversityHolder}.
		 * 
		 * @param diversityBoolean
		 *            Diversity for the {@link BooleanGenotype}
		 * @param diversityDouble
		 *            Diversity for the {@link DoubleGenotype}
		 * @param diversityInteger
		 *            Diversity for the {@link IntegerGenotype}
		 * @param diversityPermutation
		 *            Diversity for the {@link PermutationGenotype}
		 * @param diversityComposite
		 *            Diversity for the {@link CompositeGenotype}
		 */
		@Inject
		protected DiversityHolder(DiversityBoolean diversityBoolean,
				DiversityDouble diversityDouble,
				DiversityInteger diversityInteger,
				DiversityPermutation diversityPermutation,
				DiversityComposite diversityComposite) {
			add(diversityBoolean);
			add(diversityDouble);
			add(diversityInteger);
			add(diversityPermutation);
			add(diversityComposite);
		}
	}

	/**
	 * Constructs an {@code DiversityGenericImplementation} with a collection of
	 * diversity operators.
	 * 
	 * @param diversities
	 *            the diversity operators
	 */
	@SuppressWarnings("unchecked")
	public DiversityGenericImplementation(Collection<Diversity<?>> diversities) {
		for (Diversity<?> diversity : diversities) {
			addOperator((Diversity<Genotype>)diversity);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.diversity.Diversity#diversity(org.opt4j.core.Genotype,
	 * org.opt4j.core.Genotype)
	 */
	public double diversity(Genotype a, Genotype b) {
		Diversity<Genotype> diversity = getOperator(a.getClass());

		return diversity.diversity(a, b);
	}

}
