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

package org.opt4j.start;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;

import com.google.inject.BindingAnnotation;

/**
 * The {@code Constant} is an annotation for injected constant values. It is
 * defined by a {@code String} value and a {@code Class} namespace. The default
 * namespace is {@code Object.class}.
 * 
 * @author lukasiewycz
 * 
 */
@Retention(RUNTIME)
@BindingAnnotation
public @interface Constant {

	/**
	 * Returns the value.
	 * 
	 * @return the value
	 */
	String value();

	/**
	 * Returns the namespace. The default namespace is {@code Object.class}.
	 * 
	 * @return the namespace
	 */
	Class<?> namespace() default Object.class;

}
