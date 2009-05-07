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

import org.opt4j.config.annotations.Info;
import org.opt4j.core.optimizer.Iterations;
import org.opt4j.core.optimizer.OptimizerModule;
import org.opt4j.start.Constant;

/**
 * The {@code RandomSearchModule}.
 * 
 * @author lukasiewycz
 * @see RandomSearch
 * 
 */
@Info("A simple random search.")
public class RandomSearchModule extends OptimizerModule {

	@Info("A number of evaluations.")
	@Constant(value = "evaluations", namespace = RandomSearch.class)
	protected int evaluations = 25000;

	@Info("A number of batched evaluations.")
	@Constant(value = "batchsize", namespace = RandomSearch.class)
	protected int batchsize = 25;

	/**
	 * Returns the number of evaluations.
	 * 
	 * @return the evaluations
	 */
	public int getEvaluations() {
		return evaluations;
	}

	/**
	 * Sets the number of evaluations.
	 * 
	 * @param evaluations
	 *            the evaluations to set
	 */
	public void setEvaluations(int evaluations) {
		this.evaluations = evaluations;
	}

	/**
	 * Returns the number of batched individuals for the evaluation.
	 * 
	 * @return the batchsize
	 */
	public int getBatchsize() {
		return batchsize;
	}

	/**
	 * Sets the number of batched individuals for the evaluation.
	 * 
	 * @param batchsize
	 *            the batchsize to set
	 */
	public void setBatchsize(int batchsize) {
		this.batchsize = batchsize;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.start.Opt4JModule#config()
	 */
	@Override
	protected void config() {
		bindOptimizer(RandomSearch.class);
		bindConstant(Iterations.class).to(evaluations / batchsize);
	}

}
