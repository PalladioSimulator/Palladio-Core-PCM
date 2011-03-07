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

package org.opt4j.operator.algebra;

import java.util.Collection;

import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.CompositeGenotype;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.operator.AbstractGenericOperator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * The {@code AlgebraGenericImplementation} is a standard implementation of the
 * {@code AlgebraGeneric} interface.
 * 
 * @author glass, lukasiewycz
 * 
 */
@Singleton
public class AlgebraGenericImplementation extends
		AbstractGenericOperator<Algebra<Genotype>> implements AlgebraGeneric {

	/**
	 * Constructs the {@link AlgebraGenericImplementation}.
	 * 
	 * @param holder
	 *            the holder contains all algebra operators
	 */
	@Inject
	protected AlgebraGenericImplementation(AlgebraHolder holder) {
		this(holder.get());
	}

	/**
	 * The {@code AlgebraHolder} holds all mutate operators.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	static class AlgebraHolder extends OperatorHolder<Algebra<?>> {

		/**
		 * Constructs an {@code AlgebraHolder}.
		 * 
		 * @param algebraDouble
		 *            Algebra for {@link DoubleGenotype}
		 * @param algebraComposite
		 *            Algebra for {@link CompositeGenotype}
		 */
		@Inject
		protected AlgebraHolder(AlgebraDouble algebraDouble,
				AlgebraComposite algebraComposite) {
			add(algebraDouble);
			add(algebraComposite);
		}
	}

	/**
	 * Constructs an {@code AlgebraGenericImplementation} with a collection of
	 * algebra operators.
	 * 
	 * @param algebras
	 *            the algebra operators
	 */
	@SuppressWarnings("unchecked")
	public AlgebraGenericImplementation(Collection<Algebra<?>> algebras) {
		for (Algebra<?> algebra : algebras) {
			addOperator((Algebra<Genotype>) algebra);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.algebra.Algebra#algebra(org.opt4j.operator.algebra
	 * .Term, org.opt4j.core.Genotype[])
	 */
	public Genotype algebra(Term term, Genotype... genotypes) {
		Algebra<Genotype> algebra = getOperator(genotypes[0].getClass());

		return algebra.algebra(term, genotypes);
	}

}
