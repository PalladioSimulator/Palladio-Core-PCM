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

import org.opt4j.core.Genotype;
import org.opt4j.genotype.CompositeGenotype;
import org.opt4j.operator.common.Apply;
import org.opt4j.optimizer.ea.Pair;

import com.google.inject.Inject;
import com.google.inject.Singleton;

/**
 * Crossover for the {@link CompositeGenotype}.
 * 
 * @author lukasiewycz
 * 
 */
@Singleton
@Apply(CompositeGenotype.class)
public class CrossoverComposite implements Crossover {

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
	@SuppressWarnings("unchecked")
	public Pair<Genotype> crossover(Genotype parent1, Genotype parent2) {
		CompositeGenotype p1 = (CompositeGenotype) parent1;
		CompositeGenotype p2 = (CompositeGenotype) parent2;

		CompositeGenotype o1 = parent1.newInstance();
		CompositeGenotype o2 = parent2.newInstance();

		for (Object key : p1.keySet()) {
			Pair<Genotype> genotype = crossoverGeneric.crossover(p1.get(key),
					p2.get(key));
			o1.put(key, genotype.getFirst());
			o2.put(key, genotype.getSecond());
		}

		Pair<Genotype> offspring = new Pair<Genotype>(o1, o2);
		return offspring;
	}

}
