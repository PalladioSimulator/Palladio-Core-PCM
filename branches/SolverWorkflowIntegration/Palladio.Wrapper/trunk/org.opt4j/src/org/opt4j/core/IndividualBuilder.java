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

import com.google.inject.ImplementedBy;

/**
 * The {@code IndividualBuilder} is a builder for {@code Individuals}.
 * 
 * @author lukasiewycz, glass
 * 
 */
@ImplementedBy(DefaultIndividualBuilder.class)
public interface IndividualBuilder {

	/**
	 * Builds a new {@code Individual}.
	 * 
	 * @return the built individual
	 */
	public Individual build();

	/**
	 * Builds a new {@code Individual} with a specified {@code Genotype}.
	 * 
	 * @param genotype
	 *            the genotype of the individual
	 * @return the built individual
	 */
	public Individual build(Genotype genotype);
	/**
	 * Adds an {@code IndividualStateListener} to each {@code Individual} that
	 * was created by this class. This listener is invoked if the state of the
	 * {@code Individual} changes.
	 * 
	 * @param listener
	 *            the listener that is invoked if the state of any individual
	 *            changes
	 */
	public void addIndividualStateListener(IndividualStateListener listener);

	/**
	 * Removes an {@code IndividualStateListener} that is invoked if the state
	 * of any {@code Individual} changes.
	 * 
	 * @param listener
	 *            the listener that is invoked if the state of any individual
	 *            changes
	 */
	public void removeIndividualStateListener(IndividualStateListener listener);

}
