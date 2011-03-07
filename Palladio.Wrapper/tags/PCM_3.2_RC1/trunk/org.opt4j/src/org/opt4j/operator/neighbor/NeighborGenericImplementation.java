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

package org.opt4j.operator.neighbor;

import java.util.Collection;

import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.BooleanGenotype;
import org.opt4j.genotype.CompositeGenotype;
import org.opt4j.genotype.DoubleGenotype;
import org.opt4j.genotype.IntegerGenotype;
import org.opt4j.genotype.PermutationGenotype;
import org.opt4j.operator.AbstractGenericOperator;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Implementation of the {@link NeighborGeneric} interface.
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
public class NeighborGenericImplementation extends
		AbstractGenericOperator<Neighbor<Genotype>> implements NeighborGeneric {

	/**
	 * Constructs the {@link NeighborGenericImplementation}.
	 * 
	 * @param holder
	 *            the holder contains all neighbor operators
	 */
	@Inject
	protected NeighborGenericImplementation(NeighborHolder holder) {
		this(holder.get());
	}

	/**
	 * The {@code NeighborHolder} holds all neighbor operators.
	 * 
	 * @author lukasiewycz
	 * 
	 */
	static class NeighborHolder extends OperatorHolder<Neighbor<?>> {

		/**
		 * Constructs a {@code NeighborHolder}.
		 * 
		 * @param neighborBoolean
		 *            Neighbor for the {@link BooleanGenotype}
		 * @param neighborDouble
		 *            Neighbor for the {@link DoubleGenotype}
		 * @param neighborInteger
		 *            Neighbor for the {@link IntegerGenotype}
		 * @param neighborPermutation
		 *            Neighbor for the {@link PermutationGenotype}
		 * @param neighborComposite
		 *            Neighbor for the {@link CompositeGenotype}
		 */
		@Inject
		protected NeighborHolder(NeighborBoolean neighborBoolean,
				NeighborDouble neighborDouble, NeighborInteger neighborInteger,
				NeighborPermutation neighborPermutation,
				NeighborComposite neighborComposite) {
			add(neighborBoolean);
			add(neighborDouble);
			add(neighborInteger);
			add(neighborPermutation);
			add(neighborComposite);
		}
	}

	/**
	 * Constructs an {@code NeighborGenericImplementation} with a collection of
	 * neighbor operators.
	 * 
	 * @param neighbors
	 *            the neighbor operators
	 */
	@SuppressWarnings("unchecked")
	public NeighborGenericImplementation(Collection<Neighbor<?>> neighbors) {
		for (Neighbor<?> neighbor : neighbors) {
			addOperator((Neighbor<Genotype>)neighbor);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.neighbor.Neighbor#neighbor(org.opt4j.core.Genotype)
	 */
	public void neighbor(Genotype genotype) {
		Neighbor<Genotype> neighbor = getOperator(genotype.getClass());
		neighbor.neighbor(genotype);
	}

}
