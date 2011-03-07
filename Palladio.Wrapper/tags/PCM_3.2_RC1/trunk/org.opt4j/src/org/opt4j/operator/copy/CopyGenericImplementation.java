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

import java.util.Collection;

import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.AbstractGenericOperator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Implementation of the {@link CopyGeneric} interface.
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
public class CopyGenericImplementation extends
		AbstractGenericOperator<Copy<Genotype>> implements CopyGeneric {

	/**
	 * Constructs the {@link CopyGenericImplementation}.
	 * 
	 * @param holder
	 *            the holder contains all algebra operators
	 */
	@Inject
	protected CopyGenericImplementation(CopyHolder holder) {
		this(holder.get());
	}

	/**
	 * The {@code CopyHolder} holds all copy operators.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	static class CopyHolder extends OperatorHolder<Copy<?>> {

		/**
		 * Constructs a {@code CopyHolder}.
		 * 
		 * @param copyComposite
		 *            Copy for the {@code CompositeGenotype}
		 * @param copyList
		 *            Copy for the {@code ListGenotype}
		 */
		@Inject
		protected CopyHolder(CopyComposite copyComposite, CopyList copyList) {
			add(copyComposite);
			add(copyList);
		}
	}

	/**
	 * Constructs an {@code CopyGenericImplementation} with a collection of copy
	 * operators.
	 * 
	 * @param copies
	 *            the copy operators
	 */
	@SuppressWarnings("unchecked")
	public CopyGenericImplementation(Collection<Copy<?>> copies) {
		for (Copy<?> copy : copies) {
			addOperator((Copy<Genotype>)copy);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.copy.Copy#copy(org.opt4j.core.Genotype)
	 */
	public Genotype copy(Genotype genotype) {
		Copy<Genotype> copy = getOperator(genotype.getClass());

		return copy.copy(genotype);

	}
}
