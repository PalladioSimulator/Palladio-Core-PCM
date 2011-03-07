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

package org.opt4j.common.logger;

import java.util.concurrent.atomic.AtomicInteger;

import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.IndividualStateListener;
import org.opt4j.core.Individual.State;
import org.opt4j.core.optimizer.Optimizer;
import org.opt4j.core.optimizer.OptimizerIterationListener;
import org.opt4j.core.optimizer.OptimizerStateListener;

import com.google.inject.Inject;

/**
 * The {@code AbstractLogger} calls the methods on specific events.
 * 
 * @author lukasiewycz
 * 
 */
public abstract class AbstractLogger implements OptimizerStateListener,
		OptimizerIterationListener, IndividualStateListener {

	protected int iterationStep;

	protected int evaluationStep;

	protected int evaluationCountLast = 0;

	protected AtomicInteger evaluationCount = new AtomicInteger(0);

	protected final IndividualBuilder individualBuilder;

	/**
	 * Constructs an {@code AbstractLogger}.
	 * 
	 * @param optimizer
	 *            the optimizer
	 * @param individualBuilder
	 *            the individual builder
	 * @param iterationStep
	 *            the number of iterations between two logging events
	 * @param evaluationStep
	 *            the number of evaluations between two logging events
	 */
	public AbstractLogger(Optimizer optimizer,
			IndividualBuilder individualBuilder, int iterationStep,
			int evaluationStep) {
		super();
		this.individualBuilder = individualBuilder;
		this.iterationStep = iterationStep;
		this.evaluationStep = evaluationStep;
	}

	/**
	 * Initializes the {@code AbstractLogger}.
	 * 
	 */
	@Inject
	public void init() {
		individualBuilder.addIndividualStateListener(this);
	}

	/**
	 * Callback method called if the specific number of iterations or
	 * evaluations is reached.
	 * 
	 * @param iteration
	 *            the current iteration number
	 * @param evaluation
	 *            the current evaluation number
	 */
	public abstract void logEvent(int iteration, int evaluation);

	/**
	 * Callback method invoked once the optimization starts.
	 * 
	 */
	public abstract void optimizationStarted();

	/**
	 * Callback method invoked once optimization stops.
	 * 
	 */
	public abstract void optimizationStopped();

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerIterationListener#iterationComplete
	 * (org.opt4j.core.optimizer.Optimizer, int)
	 */
	@Override
	public void iterationComplete(Optimizer optimizer, int iteration) {
		boolean logIteration = false;
		if (iterationStep > 0) {
			logIteration = iteration % iterationStep == 0;
		}

		boolean logEvaluation = false;
		if (evaluationStep > 0) {
			logEvaluation = ((evaluationCount.intValue() - evaluationCountLast) >= evaluationStep);
		}

		if (logEvaluation) {
			do {
				evaluationCountLast += evaluationStep;
			} while ((evaluationCount.intValue() - evaluationCountLast) >= evaluationStep);
		}

		if (logIteration || logEvaluation) {
			logEvent(iteration, evaluationCount.intValue());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerStateListener#optimizationStarted(org
	 * .opt4j.core.optimizer.Optimizer)
	 */
	public void optimizationStarted(Optimizer optimizer) {
		optimizationStarted();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.optimizer.OptimizerStateListener#optimizationStopped(org
	 * .opt4j.core.optimizer.Optimizer)
	 */
	public void optimizationStopped(Optimizer optimizer) {
		optimizationStopped();
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.core.IndividualStateListener#inidividualStateChanged(org.opt4j
	 * .core.Individual)
	 */
	public void inidividualStateChanged(Individual individual) {
		if (individual.getState() == State.EVALUATED) {
			evaluationCount.incrementAndGet();
		}
	}

}
