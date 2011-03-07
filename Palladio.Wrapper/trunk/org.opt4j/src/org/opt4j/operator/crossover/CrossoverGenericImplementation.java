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

package org.opt4j.operator.crossover;

import java.util.Collection;

import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.AbstractGenericOperator;
import org.opt4j.optimizer.ea.Pair;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Implementation of the {@link CrossoverGeneric} interface.
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
public class CrossoverGenericImplementation extends
		AbstractGenericOperator<Crossover<Genotype>> implements
		CrossoverGeneric {

	/**
	 * Constructs the {@link CrossoverGenericImplementation}.
	 * 
	 * @param holder
	 *            the holder contains all crossover operators
	 */
	@Inject
	protected CrossoverGenericImplementation(CrossoverHolder holder) {
		this(holder.get());
	}

	/**
	 * The {@code CrossoverHolder} holds all crossover operators.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	static class CrossoverHolder extends OperatorHolder<Crossover<?>> {

		/**
		 * Constructs a {@code CrossoverHolder}.
		 * 
		 * @param crossoverBoolean
		 *            Crossover for the {@code BooleanGenotype}
		 * @param crossoverDouble
		 *            Crossover for the {@code DoubleGenotype}
		 * @param crossoverInteger
		 *            Crossover for the {@code IntegerGenotype}
		 * @param crossoverComposite
		 *            Crossover for the {@code CompositeGenotype}
		 * @param crossoverPermutation
		 *            Crossover for the {@code PermutationGenotype}
		 */
		@Inject
		protected CrossoverHolder(CrossoverBoolean crossoverBoolean,
				CrossoverDouble crossoverDouble,
				CrossoverInteger crossoverInteger,
				CrossoverComposite crossoverComposite,
				CrossoverPermutation crossoverPermutation) {
			add(crossoverBoolean);
			add(crossoverDouble);
			add(crossoverInteger);
			add(crossoverComposite);
			add(crossoverPermutation);
		}
	}

	/**
	 * Constructs an {@code CrossoverGenericImplementation} with a collection of
	 * crossover operators.
	 * 
	 * @param crossovers
	 *            the crossover operators
	 */
	@SuppressWarnings("unchecked")
	public CrossoverGenericImplementation(Collection<Crossover<?>> crossovers) {
		for (Crossover crossover : crossovers) {
			addOperator((Crossover<Genotype>) crossover);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.crossover.Crossover#crossover(org.opt4j.core.Genotype,
	 * org.opt4j.core.Genotype)
	 */
	public Pair<Genotype> crossover(Genotype parent1, Genotype parent2) {
		Crossover<Genotype> crossover = getOperator(parent1.getClass());

		return crossover.crossover(parent1, parent2);

	}
}
