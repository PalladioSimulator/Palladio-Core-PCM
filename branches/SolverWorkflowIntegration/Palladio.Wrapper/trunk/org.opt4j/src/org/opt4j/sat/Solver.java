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

import com.google.inject.ImplementedBy;

/**
 * This interface is used for objects that solve the {@code Instances} of the
 * {@code Problem}. In particular, this is an interface for a SAT/PB-solver.
 * <br/><br/> Usage: Create an concrete Implementation of the solver (e.g.
 * {@code SAT4JSolver}). Retrieve an {@code Instance} from the {@code Solver}
 * by using the {@code getInstance()} method. Solve the {@code Instance} by
 * using the {@code solve()} method and return the {@code Instance} back to the
 * {@code Solver} using {@code returnInstance(Instance instance)}.
 * 
 * @author lukasiewycz
 * 
 */
@ImplementedBy(DefaultSolver.class)
public interface Solver {

	/**
	 * Returns one {@code Instance} of the {@code Problem}.
	 * 
	 * @return one instance of the problem
	 */
	public Instance getInstance();

	/**
	 * Returns the {@code Instance} back to the {@code Solver}.
	 * 
	 * @param instance
	 *            the returned instance
	 */
	public void returnInstance(Instance instance);

	/**
	 * Adds a {@code Constraint} to the {@code Solver}.
	 * 
	 * @param constraint
	 *            the added constraint
	 */
	public void addConstraint(Constraint constraint);

	/**
	 * Allocates new variables. {@code Solvers} that dont need this method can
	 * simply ignore it.
	 * 
	 * @param newVars
	 *            the number of the new variables.
	 */
	public void addVars(int newVars);

}
