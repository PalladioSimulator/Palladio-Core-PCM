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
 * You should have received a diversity of the GNU Lesser General Public
 * License along with Opt4J. If not, see http://www.gnu.org/licenses/. 
 */

package org.opt4j.operator.diversity;

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.OperatorModule;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

/**
 * The {@code DiversityModule} is used for modules for the {@code Diversity}
 * operator.
 * 
 * @author glass, lukasiewycz
 * @see Diversity
 * 
 */
@Icon(Icons.OPERATOR)
public abstract class DiversityModule extends OperatorModule {

	/**
	 * Adds a {@code Diversity} operator to the {@link DiversityGeneric}.
	 * 
	 * @param diversity
	 *            the diversity operator class
	 */
	public void addDiversity(Class<? extends Diversity<?>> diversity) {
		addDiversity(binder(), diversity);
	}

	/**
	 * Adds a {@code Diversity} operator to the {@link DiversityGeneric}.
	 * 
	 * @param binder
	 *            the binder (use {@code binder()} in a module to get the binder)
	 * @param diversity
	 *            the diversity operator class
	 */
	public static void addDiversity(Binder binder, Class<? extends Diversity<?>> diversity) {
		Multibinder<Diversity<?>> multi = Multibinder.newSetBinder(binder,
				new TypeLiteral<Diversity<?>>() {
				});
		multi.addBinding().to(diversity);
	}

	/**
	 * Bind the {@code Diversity} operator. Using this method replaces the
	 * {@link DiversityGeneric} with the given class. If you just want to add a new
	 * {@code Diversity} operator, use the {@code #addDiversity(Class)} method.
	 * 
	 * @param diversity
	 *            the diversity operator class
	 */
	@SuppressWarnings("unchecked")
	public void bindDiversity(Class<? extends Diversity<?>> diversity) {
		bind(new TypeLiteral<Diversity<Genotype>>() {
		}).to((Class<? extends Diversity<Genotype>>) diversity);
	}
	
}