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

/**
 * This interface has to be implemented by all population-based optimizers.
 * 
 * @author glass, lukasiewycz
 * 
 */
public interface Optimizer {

	/**
	 * Starts the optimization process.
	 * 
	 * @throws StopException
	 *             if the optimization is stopped
	 * @throws TerminationException
	 *             if the optimization is terminated
	 */
	public abstract void optimize() throws StopException, TerminationException;

	/**
	 * Adds an {@code OptimizerIterationListener} to this optimizer.
	 * 
	 * @param listener
	 *            the OptimizerIterationListener to add
	 */
	public void addOptimizerIterationListener(
			OptimizerIterationListener listener);

	/**
	 * Removes an {@code OptimizerIterationListener} from this optimizer.
	 * 
	 * @param listener
	 *            the OptimizerIterationListener to remove
	 */
	public void removeOptimizerIterationListener(
			OptimizerIterationListener listener);

	/**
	 * Adds an {@code OptimizerStateListener} to this optimizer.
	 * 
	 * @param listener
	 *            the OptimizerStateListener to add
	 */
	public void addOptimizerStateListener(OptimizerStateListener listener);

	/**
	 * Removes an {@code OptimizerStateListener} from this optimizer.
	 * 
	 * @param listener
	 *            the OptimizerStateListener to remove
	 */
	public void removeOptimizerStateListener(OptimizerStateListener listener);

	/**
	 * Return the current iteration.
	 * 
	 * @return the current iteration
	 */
	public int getIteration();

	/**
	 * Returns {@code true} if the {@code Optimizer} is running.
	 * 
	 * @return {@code true} if the optimizer is running
	 */
	public boolean isRunning();

	/**
	 * This method is called once the optimization process has started.
	 */
	public void startOptimization();

	/**
	 * This method is called once the optimization process has stopped.
	 */
	public void stopOptimization();

}
