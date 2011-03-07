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

import org.opt4j.core.problem.Genotype;
import org.opt4j.genotype.CompositeGenotype;
import org.opt4j.optimizer.ea.Pair;

import com.google.inject.Inject;

/**
 * Crossover for the {@link CompositeGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
public class CrossoverComposite implements Crossover<CompositeGenotype<?, ?>> {

	private final CrossoverGeneric crossoverGeneric;

	/**
	 * Constructs a new {@link CrossoverComposite}.
	 * 
	 * @param crossoverGeneric
	 *            the {@code CrossoverGeneric}
	 */
	@Inject
	public CrossoverComposite(final CrossoverGeneric crossoverGeneric) {
		this.crossoverGeneric = crossoverGeneric;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * org.opt4j.operator.crossover.Crossover#crossover(org.opt4j.core.Genotype,
	 * org.opt4j.core.Genotype)
	 */
	public Pair<CompositeGenotype<?, ?>> crossover(CompositeGenotype<?, ?> p1,
			CompositeGenotype<?, ?> p2) {
		CompositeGenotype<Object, Genotype> o1 = p1.newInstance();
		CompositeGenotype<Object, Genotype> o2 = p2.newInstance();

		for (Object key : p1.keySet()) {
			final Genotype g1 = p1.get(key);
			final Genotype g2 = p2.get(key);
			Pair<Genotype> genotype = crossoverGeneric.crossover(g1, g2);
			o1.put(key, genotype.getFirst());
			o2.put(key, genotype.getSecond());
		}

		Pair<CompositeGenotype<?, ?>> offspring = new Pair<CompositeGenotype<?, ?>>(
				o1, o2);
		return offspring;
	}

}
