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
package org.opt4j.gui;

import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.Optimizer;

import com.google.inject.Inject;

/**
 * The {@code Progress} offers some methods for the measurement of the progress
 * of an {@code Optimizer}.
 * 
 * @see Optimizer
 * @author lukasiewycz
 * 
 */
public class Progress {

	@Inject(optional = true)
	@Iterations
	protected Integer maxIterations = null;

	protected final Optimizer optimizer;

	/**
	 * Constructs a {@code Progress}.
	 * 
	 * @param optimizer
	 *            the optimizer
	 */
	@Inject
	public Progress(Optimizer optimizer) {
		this.optimizer = optimizer;
	}

	/**
	 * Returns the progress value between {@code 0} and {@code 1}.
	 * 
	 * @return the progress value
	 */
	public Double get() {
		if (maxIterations == null) {
			return null;
		} else {
			return (double) getCurrentIteration() / (double) getMaxIterations();
		}
	}

	/**
	 * Returns the number of maximal iterations.
	 * 
	 * @return the number of maximal iteration
	 */
	public Integer getMaxIterations() {
		return maxIterations == null ? getCurrentIteration() : maxIterations;
	}

	/**
	 * Returns the current iteration.
	 * 
	 * @return the current iteration
	 */
	public int getCurrentIteration() {
		return Math.min(optimizer.getIteration(),
				maxIterations == null ? optimizer.getIteration()
						: maxIterations);
	}

}
