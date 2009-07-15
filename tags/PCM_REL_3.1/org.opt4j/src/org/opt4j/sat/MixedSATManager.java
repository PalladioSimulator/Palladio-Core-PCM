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
import java.util.Map;

import org.opt4j.core.Genotype;
import org.opt4j.genotype.BooleanGenotype;
import org.opt4j.genotype.BooleanMapGenotype;
import org.opt4j.genotype.DoubleBounds;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.genotype.DoubleMapGenotype;
import org.opt4j.start.Constant;

import com.google.inject.Inject;

/**
 * The {@code MixedSATManager} encodes the decision strategy into two vectors:
 * One binary vector for the phase and one double vector for the priority.
 * 
 * @author lukasiewycz
 * 
 */
public class MixedSATManager implements SATManager {

	protected final Solver solver;

	/**
	 * Constructs a {@code MixedSATManager}.
	 * 
	 * @param solver
	 *            the solver
	 * @param instances
	 *            the number of pooled instances
	 */
	@Inject
	public MixedSATManager(
			final Solver solver,
			@Constant(value = "instances", namespace = MixedSATManager.class) int instances) {
		PooledSolver pool = new PooledSolver(solver, instances);
		this.solver = pool;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.SATManager#createSATGenotype(java.util.List,
	 * java.util.Map, java.util.Map)
	 */
	public Genotype createSATGenotype(List<Object> variables,
			Map<Object, Double> lowerBounds, Map<Object, Double> upperBounds,
			Map<Object, Double> priorities, Map<Object, Boolean> phases) {

		int size = variables.size();

		double[] lower = new double[size];
		double[] upper = new double[size];

		for (int i = 0; i < size; i++) {
			Object variable = variables.get(i);
			Double lb = lowerBounds.get(variable);
			Double ub = upperBounds.get(variable);

			if (lb == null) {
				lb = 0.0;
			}
			if (ub == null) {
				ub = 1.0;
			}
			lower[i] = lb;
			upper[i] = ub;
		}

		DoubleBounds doubleBounds = new DoubleBounds(lower, upper);
		DoubleGenotype doubleVector = new DoubleMapGenotype<Object>(variables,
				doubleBounds);
		BooleanGenotype booleanVector = new BooleanMapGenotype<Object>(
				variables);

		SATGenotype satGenotype = new SATGenotype(booleanVector, doubleVector);

		for (Object variable : variables) {
			double priority = priorities.get(variable);
			boolean phase = phases.get(variable);

			doubleVector.add(priority);
			booleanVector.add(phase);
		}

		return satGenotype;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.SATManager#decodeSATGenotype(java.util.List,
	 * org.opt4j.core.Genotype)
	 */
	public Model decodeSATGenotype(List<Object> variables, Genotype genotype) {
		SATGenotype satGenotype = (SATGenotype) genotype;

		BooleanGenotype booleanVector = satGenotype.getBooleanVector();
		DoubleGenotype doubleVector = satGenotype.getDoubleVector();

		VarOrder varorder = new VarOrder();

		for (int i = 0; i < variables.size(); i++) {
			Object var = variables.get(i);
			varorder.setActivity(var, doubleVector.get(i));
			varorder.setPhase(var, booleanVector.get(i));
		}
		Instance instance = solver.getInstance();
		varorder.setVarInc(1.0 / (2.0 * variables.size()));
		varorder.setVarDecay(1.0 / 0.95);

		instance.setOrder(varorder);

		try {

			if (instance.solve()) {
				return instance.getModel();
			}

		} catch (TimeoutException e) {
			System.err.println("timeout");
			return null;
		} finally {
			solver.returnInstance(instance);
		}

		return null;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.SATManager#getSolver()
	 */
	public Solver getSolver() {
		return solver;
	}

}
