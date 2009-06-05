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

package org.opt4j.core.problem;

import java.util.HashSet;
import java.util.Set;

import org.opt4j.config.Icons;
import org.opt4j.config.annotations.Category;
import org.opt4j.config.annotations.Icon;
import org.opt4j.start.Opt4JModule;

/**
 * Abstract module class for the Problem modules.
 * 
 * @author lukasiewycz
 * @see org.opt4j.core.problem
 * 
 */
@Icon(Icons.PROBLEM)
@Category
public abstract class ProblemModule extends Opt4JModule {

	/**
	 * Binds a problem.
	 * 
	 * @param creator
	 *            the creator
	 * @param decoder
	 *            the decoder
	 * @param evaluator
	 *            the evaluator
	 */
	@SuppressWarnings( { "unchecked", "serial" })
	public void bindProblem(final Class<? extends Creator> creator,
			final Class<? extends Decoder> decoder,
			final Class<? extends Evaluator> evaluator) {

		Set<Class<?>> classes = new HashSet<Class<?>>() {
			{
				add(creator);
				add(decoder);
				add(evaluator);
			}
		};

		for (Class<?> clazz : classes) {
			bind(clazz).in(SINGLETON);
		}

		bind(Creator.class).to(creator);
		bind(Decoder.class).to(decoder);
		bind(Evaluator.class).to(evaluator);
		
	}

}
