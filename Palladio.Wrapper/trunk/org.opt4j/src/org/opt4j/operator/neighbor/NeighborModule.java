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

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.OperatorModule;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

/**
 * The {@code NeighborModule} is used for modules for the {@code Neighbor}
 * operator.
 * 
 * @author lukasiewycz
 * @see Neighbor
 * 
 */
@Icon(Icons.OPERATOR)
public abstract class NeighborModule extends OperatorModule {

	/**
	 * Adds a {@code Neighbor} operator to the {@link NeighborGeneric}.
	 * 
	 * @param neighbor
	 *            the neighbor operator class
	 */
	public void addNeighbor(Class<? extends Neighbor<?>> neighbor) {
		addNeighbor(binder(), neighbor);
	}

	/**
	 * Adds a {@code Neighbor} operator to the {@link NeighborGeneric}.
	 * 
	 * @param binder
	 *            the binder (use {@code binder()} in a module to get the binder)
	 * @param neighbor
	 *            the neighbor operator class
	 */
	public static void addNeighbor(Binder binder, Class<? extends Neighbor<?>> neighbor) {
		Multibinder<Neighbor<?>> multi = Multibinder.newSetBinder(binder,
				new TypeLiteral<Neighbor<?>>() {
				});
		multi.addBinding().to(neighbor);
	}

	/**
	 * Bind the {@code Neighbor} operator. Using this method replaces the
	 * {@link NeighborGeneric} with the given class. If you just want to add a new
	 * {@code Neighbor} operator, use the {@code #addNeighbor(Class)} method.
	 * 
	 * @param neighbor
	 *            the neighbor operator class
	 */
	@SuppressWarnings("unchecked")
	public void bindNeighbor(Class<? extends Neighbor<?>> neighbor) {
		bind(new TypeLiteral<Neighbor<Genotype>>() {
		}).to((Class<? extends Neighbor<Genotype>>) neighbor);
	}

}
