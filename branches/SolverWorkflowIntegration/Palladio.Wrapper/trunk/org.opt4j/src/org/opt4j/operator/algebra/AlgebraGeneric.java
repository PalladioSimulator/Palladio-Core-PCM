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

import org.opt4j.operator.common.GenericOperator;

import com.google.inject.ImplementedBy;

/**
 * The {@code AlgebraGeneric} is an interface for a generic {@code Algebra}
 * operator that is able to handle different {@code Genotypes}.
 * 
 * @author lukasiewycz
 * 
 */
@ImplementedBy(AlgebraGenericImplementation.class)
public interface AlgebraGeneric extends Algebra, GenericOperator<Algebra> {

}