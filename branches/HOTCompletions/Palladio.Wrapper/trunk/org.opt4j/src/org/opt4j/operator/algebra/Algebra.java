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

import org.opt4j.core.Genotype;
import org.opt4j.core.optimizer.Operator;

import com.google.inject.ImplementedBy;

/**
 * The {@code Algebra} operator. By default this class is implemented by the
 * {@link AlgebraDouble}.
 * 
 * @author lukasiewycz
 * 
 */
@ImplementedBy(AlgebraGeneric.class)
public interface Algebra extends Operator {

	/**
	 * Performs the term for each element of the genotypes and returns the
	 * resulting genotype.
	 * 
	 * @param term
	 *            the term
	 * @param genotypes
	 *            the genotypes
	 * @return the resulting genotype
	 */
	public Genotype algebra(Term term, Genotype... genotypes);

}
