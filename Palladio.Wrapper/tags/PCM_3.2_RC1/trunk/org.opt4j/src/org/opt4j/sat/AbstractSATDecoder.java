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

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

import org.opt4j.common.random.Rand;
import org.opt4j.core.problem.Creator;
import org.opt4j.core.problem.Decoder;
import org.opt4j.core.problem.Genotype;
import org.opt4j.core.problem.Phenotype;

import com.google.inject.Inject;

/**
 * The {@code AbstractSATDecoder} can be used for the construction of custom SAT
 * {@code Decoders}. The abstract methods must be overridden with the specific
 * {@code Problem}.
 * 
 * @author lukasiewycz
 * 
 * @param <G>
 *            The genotype (use {@code Genotype} if you do not override the
 *            decode method)
 * @param <P>
 *            The phenotype
 */
public abstract class AbstractSATDecoder<G extends Genotype, P extends Phenotype>
		implements Decoder<G, P>, Creator<G> {

	protected List<Constraint> constraints = new ArrayList<Constraint>();

	protected List<Object> variables = new ArrayList<Object>();

	protected Map<Object, Double> lowerBounds;

	protected Map<Object, Double> upperBounds;

	protected final Random random;

	protected final SATManager manager;

	protected boolean isInit = false;

	/**
	 * Constructs an {@code AbstractSATSecoder} with the given {@code
	 * SATManager}.
	 * 
	 * @param manager
	 *            the specified sat manager
	 * @param random
	 *            the random number generator
	 */
	@Inject
	public AbstractSATDecoder(SATManager manager, Rand random) {
		this.random = random;
		this.manager = manager;
	}

	/**
	 * Initializes the constraints and variables.
	 */
	protected synchronized void init() {

		if (!isInit) {
			try {
				Solver solver = manager.getSolver();

				Set<Constraint> constraints = new HashSet<Constraint>();

				init(constraints);

				Set<Object> variables = new HashSet<Object>();

				for (Constraint constraint : constraints) {
					solver.addConstraint(constraint);
					this.constraints.add(constraint);

					for (Literal literal : constraint.getLiterals()) {
						variables.add(literal.variable());
					}
				}

				Set<Object> ignores = ignoreVariables(variables);

				variables.removeAll(ignores);
				this.variables.addAll(variables);

				lowerBounds = getLowerBounds(variables);
				upperBounds = getUpperBounds(variables);

			} catch (Throwable e) {
				System.err.println("Failed initialization of "
						+ getClass().getName() + " with " + e);
				throw new RuntimeException(e);
			} finally {
				isInit = true;
			}

		}
	}

	/**
	 * Collects all {@code Constraints} of the {@code Problem}. Override this
	 * method for your custom {@code Decoder}.
	 * 
	 * @param constraints
	 *            the set of all constraints of the given problem
	 * 
	 */
	public abstract void init(Set<Constraint> constraints);

	/**
	 * Creates a random initialization of the priorities and phases for the
	 * variables. Override this method for a custom initialization.
	 * 
	 * @param variables
	 *            all variables
	 * @param lowerBounds
	 *            the lower bounds for the priority for the variables
	 * @param upperBounds
	 *            the upper bounds for the priority for the variables
	 * @param priorities
	 *            the priorities of the variables
	 * @param phases
	 *            the phases of the variables
	 */
	public void randomize(Collection<Object> variables,
			Map<Object, Double> lowerBounds, Map<Object, Double> upperBounds,
			Map<Object, Double> priorities, Map<Object, Boolean> phases) {
		for (Object variable : variables) {
			Double lb = lowerBounds.get(variable);
			Double ub = upperBounds.get(variable);
			if (lb == null) {
				lb = 0.0;
			}
			if (ub == null) {
				ub = 1.0;
			}

			double priority = lb + (ub - lb) * random.nextDouble();

			priorities.put(variable, priority);
			phases.put(variable, random.nextBoolean());
		}
	}

	/**
	 * Set the variables to be ignored (not part of the search process and
	 * genotype). Override this method if variables are ignored.
	 * 
	 * @param variables
	 *            all variables of the problem
	 * @return the variables to be ignored
	 */
	public Set<Object> ignoreVariables(Set<Object> variables) {
		return new HashSet<Object>();
	}

	/**
	 * Returns the lower bounds for the variables.
	 * 
	 * @param variables
	 *            all variables of the problem
	 * @return the lower bounds
	 */
	public Map<Object, Double> getLowerBounds(Set<Object> variables) {
		return new HashMap<Object, Double>();
	}

	/**
	 * Returns the upper bounds for the variables.
	 * 
	 * @param variables
	 *            all variables of the problem
	 * @return the upper bounds
	 */
	public Map<Object, Double> getUpperBounds(Set<Object> variables) {
		return new HashMap<Object, Double>();
	}

	/**
	 * Converts a {@code Model} into a {@code Phenotype}. Override this with
	 * your custom method.
	 * 
	 * @param model
	 *            the found model
	 * @return the converted phenotype
	 */
	public abstract P convertModel(Model model);

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.problem.Creator#create()
	 */
	@SuppressWarnings("unchecked")
	public G create() {
		return (G) createSATGenotype();
	}

	/**
	 * Returns a random SAT genotype of the constrained problem.
	 * 
	 * @return a random SAT genotype
	 */
	protected Genotype createSATGenotype() {
		if (!isInit) {
			init();
		}

		Map<Object, Double> priorities = new HashMap<Object, Double>();
		Map<Object, Boolean> phases = new HashMap<Object, Boolean>();

		randomize(variables, lowerBounds, upperBounds, priorities, phases);

		return manager.createSATGenotype(variables, lowerBounds, upperBounds,
				priorities, phases);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.core.problem.Decoder#decode(org.opt4j.core.Genotype)
	 */
	public P decode(G genotype) {
		Model model = decodeSATGenotype(genotype);

		return convertModel(model);
	}

	/**
	 * Decodes the {@code Genotype} to a {@code Phenotye} by using a SAT/PB
	 * solver.
	 * 
	 * @param genotype
	 *            the genotype
	 * @return the phenotype
	 */
	protected Model decodeSATGenotype(Genotype genotype) {
		if (!isInit) {
			init();
		}

		return manager.decodeSATGenotype(variables, genotype);
	}

	/**
	 * Returns the constraints.
	 * 
	 * @return the constraints
	 */
	public List<Constraint> getConstraints() {
		return constraints;
	}

	/**
	 * Returns the variables.
	 * 
	 * @return the variables
	 */
	public List<Object> getVariables() {
		return variables;
	}

}
