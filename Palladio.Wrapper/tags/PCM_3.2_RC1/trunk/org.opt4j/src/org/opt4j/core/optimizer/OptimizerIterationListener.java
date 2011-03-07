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
package org.opt4j.core.optimizer;

import org.opt4j.start.Opt4JModule;

/**
 * The {@code OptimizerIterationListener} is used to monitor the iteration of
 * the {@link Optimizer}. To add an {@code OptimizerIterationListener} use the
 * method {@link Opt4JModule#addOptimizerIterationListener(Class)}.
 * 
 * @author lukasiewycz
 * 
 */
public interface OptimizerIterationListener {

	/**
	 * Invoked if the {@code Optimizer} completes an iteration.
	 * 
	 * @param optimizer
	 *            the optimizer
	 * @param iteration
	 *            the completed iteration
	 */
	public void iterationComplete(Optimizer optimizer, int iteration);

}
