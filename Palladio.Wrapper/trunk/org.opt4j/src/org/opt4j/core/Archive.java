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

package org.opt4j.core;

import java.util.Collection;

import org.opt4j.common.archive.DefaultArchive;

import com.google.inject.ImplementedBy;

/**
 * An {@code Archive} is used to store a set of high-quality {@code Individuals}
 * . Commonly, these {@code Individuals} are non-dominated.
 * 
 * @author helwig, lukasiewycz
 */
@ImplementedBy(DefaultArchive.class)
public interface Archive extends Collection<Individual> {

	/**
	 * Updates this {@code Archive} with the specified individuals.
	 * 
	 * @param individual
	 *            an individual
	 */
	public void update(Individual... individual);

	/**
	 * Updates this {@code Archive} with the specified individuals.
	 * 
	 * @param individuals
	 *            some individuals
	 */
	public void update(Collection<Individual> individuals);

	/**
	 * Adds a listener.
	 * 
	 * @param listener
	 *            the added listener
	 */
	public void addListener(IndividualCollectionListener listener);

	/**
	 * Removes a listener.
	 * 
	 * @param listener
	 *            the removed listener
	 */
	public void removeListener(IndividualCollectionListener listener);

}
