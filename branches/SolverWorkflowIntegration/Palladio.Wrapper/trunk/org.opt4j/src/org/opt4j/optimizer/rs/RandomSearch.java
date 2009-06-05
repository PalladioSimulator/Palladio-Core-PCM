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

package org.opt4j.optimizer.rs;

import org.opt4j.core.Archive;
import org.opt4j.core.Individual;
import org.opt4j.core.IndividualBuilder;
import org.opt4j.core.Population;
import org.opt4j.core.optimizer.AbstractOptimizer;
import org.opt4j.core.optimizer.Completer;
import org.opt4j.core.optimizer.Control;
import org.opt4j.core.optimizer.StopException;
import org.opt4j.core.optimizer.TerminationException;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code RandomSearch} simply generates random {@code Individuals} and
 * evaluations them.
 * 
 * @author lukasiewycz
 * 
 */
public class RandomSearch extends AbstractOptimizer {

	protected final int evaluations;

	protected final int batchsize;

	/**
	 * Constructs a {@code RandomSearch}.
	 * 
	 * @param population
	 *            the population
	 * @param archive
	 *            the archive
	 * @param individualBuilder
	 *            the individual builder
	 * @param completer
	 *            the completer
	 * @param control
	 *            the control
	 * @param evaluations
	 *            the number of evaluations
	 * @param batchsize
	 *            the size of the batch for an evaluation
	 */
	@Inject
	public RandomSearch(Population population, Archive archive,
			IndividualBuilder individualBuilder, Completer completer,
			Control control, 
			@Constant(value="evaluations", namespace=RandomSearch.class)
			int evaluations, 
			@Constant(value="batchsize", namespace=RandomSearch.class)
			int batchsize) {
		super(population, archive, individualBuilder, completer, control);
		this.evaluations = evaluations;
		this.batchsize = batchsize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.optimizer.Optimizer#optimize()
	 */
	public void optimize() throws StopException, TerminationException {

		for (int i = 0; i < evaluations; i++) {

			Individual individual = individualBuilder.build();
			population.add(individual);

			if ((i + 1) % batchsize == 0) {
				nextIteration();
				population.clear();
			}
		}

		if (population.size() > 0) {
			nextIteration();
			population.clear();
		}

	}

}
