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

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.OperatorModule;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

/**
 * The {@code CrossoverModule} is used for modules for the {@code Crossover}
 * operator.
 * 
 * @author lukasiewycz
 * @see Crossover
 * 
 */
@Icon(Icons.OPERATOR)
public abstract class CrossoverModule extends OperatorModule {

	/**
	 * Adds a {@code Crossover} operator to the {@link CrossoverGeneric}.
	 * 
	 * @param crossover
	 *            the crossover operator class
	 */
	public void addCrossover(Class<? extends Crossover<?>> crossover) {
		addCrossover(binder(), crossover);
	}

	/**
	 * Adds a {@code Crossover} operator to the {@link CrossoverGeneric}.
	 * 
	 * @param binder
	 *            the binder (use {@code binder()} in a module to get the binder)
	 * @param crossover
	 *            the crossover operator class
	 */
	public static void addCrossover(Binder binder, Class<? extends Crossover<?>> crossover) {
		Multibinder<Crossover<?>> multi = Multibinder.newSetBinder(binder,
				new TypeLiteral<Crossover<?>>() {
				});
		multi.addBinding().to(crossover);
	}

	/**
	 * Bind the {@code Crossover} operator. Using this method replaces the
	 * {@link CrossoverGeneric} with the given class. If you just want to add a new
	 * {@code Crossover} operator, use the {@code #addCrossover(Class)} method.
	 * 
	 * @param crossover
	 *            the crossover operator class
	 */
	@SuppressWarnings("unchecked")
	public void bindCrossover(Class<? extends Crossover<?>> crossover) {
		bind(new TypeLiteral<Crossover<Genotype>>() {
		}).to((Class<? extends Crossover<Genotype>>) crossover);
	}
	

}
