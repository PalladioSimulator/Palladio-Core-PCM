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

import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

import org.opt4j.core.Archive;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.Population;

import com.google.inject.Inject;

/**
 * This {@code AbstractOptimizer} is an abstract implementation of a
 * population-based {@code Optimizer}. All population based optimizers can be
 * derived from this class.
 * 
 * @author glass, lukasiewycz
 * 
 */
public abstract class AbstractOptimizer implements Optimizer {

	protected int iteration = 0;

	protected final Population population;

	protected final Archive archive;

	protected final IndividualBuilder individualBuilder;

	protected final Completer completer;

	protected final Control control;

	protected final Set<OptimizerStateListener> stateListeners = new CopyOnWriteArraySet<OptimizerStateListener>();

	protected final Set<OptimizerIterationListener> iterationListeners = new CopyOnWriteArraySet<OptimizerIterationListener>();

	protected boolean optimizing = false;

	/**
	 * Constructs an {@code AbstractOptimizer} with a {@code Population}, an
	 * {@code Archive}, an {@code IndividualBuilder}, and a {@code Completer}.
	 * 
	 * @param population
	 *            the specified population
	 * @param archive
	 *            the specified archive
	 * @param individualBuilder
	 *            the specified individualBuilder
	 * @param completer
	 *            the specified completer
	 * @param control
	 *            the control
	 */
	public AbstractOptimizer(Population population, Archive archive,
			IndividualBuilder individualBuilder, Completer completer,
			Control control) {
		this.population = population;
		this.archive = archive;
		this.individualBuilder = individualBuilder;
		this.completer = completer;
		this.control = control;
	}

	@Inject
	protected void injectListeners(Set<OptimizerStateListener> stateListeners,
			Set<OptimizerIterationListener> iterationListeners) {
		this.stateListeners.addAll(stateListeners);
		this.iterationListeners.addAll(iterationListeners);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#getIteration()
	 */
	public int getIteration() {
		return iteration;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#isRunning()
	 */
	public boolean isRunning() {
		return optimizing;
	}

	/**
	 * Call this method if a new iteration started.
	 * 
	 * @throws StopException
	 *             if the optimization is stopped
	 * @throws TerminationException
	 *             if the optimization is terminated
	 */
	protected void nextIteration() throws TerminationException, StopException {
		completer.complete(population);
		archive.update(population);
		for (OptimizerIterationListener listener : iterationListeners) {
			listener.iterationComplete(this, iteration);
		}
		iteration++;
		control.checkpointStop();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#startOptimization()
	 */
	public void startOptimization() {
		optimizing = true;
		for (OptimizerStateListener listener : stateListeners) {
			listener.optimizationStarted(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#stopOptimization()
	 */
	public void stopOptimization() {
		optimizing = false;
		for (OptimizerStateListener listener : stateListeners) {
			listener.optimizationStopped(this);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.Optimizer#addOptimizerIterationListener(org.
	 * opt4j.core.optimizer.OptimizerIterationListener)
	 */
	@Override
	public void addOptimizerIterationListener(
			OptimizerIterationListener listener) {
		iterationListeners.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.Optimizer#addOptimizerStateListener(org.opt4j
	 * .core.optimizer.OptimizerStateListener)
	 */
	@Override
	public void addOptimizerStateListener(OptimizerStateListener listener) {
		stateListeners.add(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.Optimizer#removeOptimizerIterationListener(org
	 * .opt4j.core.optimizer.OptimizerIterationListener)
	 */
	@Override
	public void removeOptimizerIterationListener(
			OptimizerIterationListener listener) {
		iterationListeners.remove(listener);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.Optimizer#removeOptimizerStateListener(org.opt4j
	 * .core.optimizer.OptimizerStateListener)
	 */
	@Override
	public void removeOptimizerStateListener(OptimizerStateListener listener) {
		stateListeners.remove(listener);
	}

}
