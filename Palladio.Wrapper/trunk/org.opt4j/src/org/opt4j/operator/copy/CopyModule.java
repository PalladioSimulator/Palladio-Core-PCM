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

package org.opt4j.operator.copy;

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Icon;
import org.opt4j.core.problem.Genotype;
import org.opt4j.operator.OperatorModule;

import com.google.inject.Binder;
import com.google.inject.TypeLiteral;
import com.google.inject.multibindings.Multibinder;

/**
 * The {@code CopyModule} is used for modules for the {@code Copy} operator.
 * 
 * @author lukasiewycz
 * @see Copy
 * 
 */
@Icon(Icons.OPERATOR)
public abstract class CopyModule extends OperatorModule {

	/**
	 * Adds a {@code Copy} operator to the {@link CopyGeneric}.
	 * 
	 * @param copy
	 *            the copy operator class
	 */
	public void addCopy(Class<? extends Copy<?>> copy) {
		addCopy(binder(), copy);
	}

	/**
	 * Adds a {@code Copy} operator to the {@link CopyGeneric}.
	 * 
	 * @param binder
	 *            the binder (use {@code binder()} in a module to get the binder)
	 * @param copy
	 *            the copy operator class
	 */
	public static void addCopy(Binder binder, Class<? extends Copy<?>> copy) {
		Multibinder<Copy<?>> multi = Multibinder.newSetBinder(binder,
				new TypeLiteral<Copy<?>>() {
				});
		multi.addBinding().to(copy);
	}

	/**
	 * Bind the {@code Copy} operator. Using this method replaces the
	 * {@link CopyGeneric} with the given class. If you just want to add a new
	 * {@code Copy} operator, use the {@code #addCopy(Class)} method.
	 * 
	 * @param copy
	 *            the copy operator class
	 */
	@SuppressWarnings("unchecked")
	public void bindCopy(Class<? extends Copy<?>> copy) {
		bind(new TypeLiteral<Copy<Genotype>>() {
		}).to((Class<? extends Copy<Genotype>>) copy);
	}
	
}
