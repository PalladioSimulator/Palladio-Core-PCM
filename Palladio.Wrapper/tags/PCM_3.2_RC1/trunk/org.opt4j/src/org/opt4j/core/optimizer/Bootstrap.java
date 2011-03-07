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

import com.google.inject.Inject;

/**
 * The {@code Bootstrap} is used to start the optimization process.
 * 
 * @author glass, lukasiewycz
 * 
 */
public class Bootstrap {

	protected final Optimizer optimizer;

	/**
	 * Constructs an {@code Executor} with a given {@code Optimizer}.
	 * 
	 * @param optimizer
	 *            the optimizer that is executed
	 */
	@Inject
	public Bootstrap(Optimizer optimizer) {
		this.optimizer = optimizer;
	}

	/**
	 * Returns the {@code Optimizer}.
	 * 
	 * @return the optimizer
	 * 
	 */
	public Optimizer getOptimizer() {
		return optimizer;
	}

	/**
	 * Starts the optimization process.
	 */
	public void execute() {
		optimizer.startOptimization();
		try {
			optimizer.optimize();
		} catch (StopException e) {
			System.out.println("Optimization stopped.");
		} catch (TerminationException e) {
			System.err.println("Optimization terminated.");
		} finally {
			optimizer.stopOptimization();
		}
		
	}

}
