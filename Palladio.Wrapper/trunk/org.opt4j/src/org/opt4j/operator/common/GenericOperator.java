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
package org.opt4j.operator.common;

import java.util.Collection;

import org.opt4j.core.Genotype;
import org.opt4j.core.optimizer.Operator;

/**
 * The {@code GenericOperator} is an interface for generic operators.
 * 
 * @author lukasiewycz
 * 
 * @param <O>
 *            the operator
 */
public interface GenericOperator<O extends Operator> {
	/**
	 * Adds a handler.
	 * 
	 * @param clazz
	 *            The identifier
	 * @param operator
	 *            The {@code Operator}
	 */
	public void addHandler(Class<? extends Genotype> clazz, O operator);

	/**
	 * Returns the {@code Operator} for a specific genotype {@code Class}.
	 * 
	 * @param clazz
	 *            The identifier {@code Class}
	 * @return the {@code Operator} for this {@code Class}
	 */
	public O getHandler(Class<? extends Genotype> clazz);

	/**
	 * Returns all handlers
	 * 
	 * @return all handlers
	 */
	public Collection<O> getHandlers();

}
