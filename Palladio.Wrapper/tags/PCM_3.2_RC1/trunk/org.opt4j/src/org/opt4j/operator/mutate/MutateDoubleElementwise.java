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

package org.opt4j.operator.mutate;

import java.util.List;

import org.opt4j.common.random.Rand;
import org.opt4j.operator.normalize.NormalizeDouble;

/**
 * The {@code MutateDoubleElementwise}.
 * 
 * @author lukasiewycz
 * 
 */
public abstract class MutateDoubleElementwise extends MutateDouble {

	/**
	 * Constructs a {@code MutateDoubleElementwise}
	 * 
	 * @param mutationRate
	 *            the mutation rate
	 * @param random
	 *            the random number generator
	 * @param normalize
	 *            the normalizer
	 */
	public MutateDoubleElementwise(MutationRate mutationRate,
			Rand random, NormalizeDouble normalize) {
		super(mutationRate, random, normalize);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.mutate.MutateDouble#mutateList(java.util.List)
	 */
	@Override
	protected void mutateList(List<Double> vector) {
		for(int i=0; i<vector.size(); i++){
			double x = vector.get(i);
			double y = mutateElement(x);
			
			if(x != y){
				vector.set(i, y);
			}
		}
	}

	/**
	 * Mutate one element of the list.
	 * 
	 * @param element
	 *            the element
	 * @return the mutated element
	 */
	protected abstract double mutateElement(double element);

}
