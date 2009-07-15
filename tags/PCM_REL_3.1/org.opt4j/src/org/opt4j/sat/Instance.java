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

package org.opt4j.sat;

import java.util.List;

/**
 * The interface for objects that represent an {@code Instance} of a
 * {@code Problem}.
 * 
 * @author lukasiewycz
 * 
 */
public interface Instance {

	/**
	 * Adds a {@code Constraint} to the {@code Solver}.
	 * 
	 * @param constraint
	 *            the added clause
	 */
	public void addConstraint(Constraint constraint);

	/**
	 * Sets the decision {@code Order}.
	 * 
	 * @param order
	 *            the decision order
	 */
	public void setOrder(Order order);

	/**
	 * Solves the {@code Instance}.
	 * 
	 * @return {@code true} if a satisfiable solution was found
	 * @throws TimeoutException
	 *             if the solver needs too long
	 */
	public boolean solve() throws TimeoutException;

	/**
	 * Solves the {@code Instance} under assumptions, a list of {@code Literals}
	 * respectivly.
	 * 
	 * @param assumptions
	 *            the made assumptions
	 * @return {@code true} if a satisfiable solution was found
	 * @throws TimeoutException
	 *             if the solver needs too long
	 */
	public boolean solve(List<Literal> assumptions) throws TimeoutException;

	/**
	 * Returns the found {@code Model} as a witness.
	 * 
	 * @return the found model
	 */
	public Model getModel();

	/**
	 * Allocates new variables. {@code Solvers} that dont need this method can
	 * simply ignore it.
	 * 
	 * @param newVars
	 *            the number of the new variables.
	 */
	public void addVars(int newVars);

}
