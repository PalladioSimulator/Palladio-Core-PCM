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

package org.opt4j.optimizer.ea;

import java.util.Collection;

import org.opt4j.core.Individual;

import com.google.inject.ImplementedBy;

/**
 * The interface {@code Selector} is used to select a certain subset of
 * {@code Individuals} from a {@code Population} by respecting certain metrices
 * like their fitness. The core methods are
 * {@link #getParents(Collection<Individual> population)}, that returns a set
 * of {@code Individuals} that can be used as parents for the next generation
 * and {@link #getLames(Collection<Individual> population)}, that returns a
 * list of {@code Individuals} that can be removed from the given individual
 * list in order to form the next generation.
 * 
 * @author glass, lukasiewycz
 * 
 */
/**
 * The {@code Selector}
 * 
 * @author lukasiewycz
 * 
 */
@ImplementedBy(SelectorDefault.class)
public interface Selector {

	/**
	 * Selects a subset of {@code Individuals} and returns it as a new
	 * {@code List}. These so called parents can be used to form the next
	 * generation.
	 * 
	 * @param mu
	 *            the number of parents to select
	 * @param population
	 *            the list of individuals
	 * @return the parents
	 */
	public Collection<Individual> getParents(int mu,
			Collection<Individual> population);

	/**
	 * Selects a subset of {@code Individuals} and returns it as a new
	 * {@code List}. These individuals can be erased in the next generation.
	 * 
	 * @param lambda
	 *            the number of lames to select
	 * @param population
	 *            the list of individuals
	 * @return the worst {@code lambda} individuals
	 */
	public Collection<Individual> getLames(int lambda, Collection<Individual> population);

	/**
	 * Sets the maximal number of individuals.
	 * 
	 * @param maxsize
	 *            the number of individuals
	 */
	public void init(int maxsize);

}
