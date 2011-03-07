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

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.OperatorModule;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

/**
 * The {@code MutateModule} is used for modules for the {@code Mutate} operator.
 * 
 * @author lukasiewycz
 * @see Mutate
 * 
 */
@Icon(Icons.OPERATOR)
public abstract class MutateModule extends OperatorModule {

	/**
	 * Adds a {@code Mutate} operator to the {@link MutateGeneric}.
	 * 
	 * @param mutate
	 *            the mutate operator class
	 */
	public void addMutate(Class<? extends Mutate<?>> mutate) {
		addMutate(binder(), mutate);
	}

	/**
	 * Adds a {@code Mutate} operator to the {@link MutateGeneric}.
	 * 
	 * @param binder
	 *            the binder (use {@code binder()} in a module to get the binder)
	 * @param mutate
	 *            the mutate operator class
	 */
	public static void addMutate(Binder binder, Class<? extends Mutate<?>> mutate) {
		Multibinder<Mutate<?>> multi = Multibinder.newSetBinder(binder,
				new TypeLiteral<Mutate<?>>() {
				});
		multi.addBinding().to(mutate);
	}

	/**
	 * Bind the {@code Mutate} operator. Using this method replaces the
	 * {@link MutateGeneric} with the given class. If you just want to add a new
	 * {@code Mutate} operator, use the {@code #addMutate(Class)} method.
	 * 
	 * @param mutate
	 *            the mutate operator class
	 */
	@SuppressWarnings("unchecked")
	public void bindMutate(Class<? extends Mutate<?>> mutate) {
		bind(new TypeLiteral<Mutate<Genotype>>() {
		}).to((Class<? extends Mutate<Genotype>>) mutate);
	}
	
}
