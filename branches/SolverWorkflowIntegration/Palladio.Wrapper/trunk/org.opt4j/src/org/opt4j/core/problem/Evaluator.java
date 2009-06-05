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

import java.util.Collection;

import org.opt4j.core.Objective;
import org.opt4j.core.Objectives;
import org.opt4j.core.Phenotype;

/**
 * The {@code Evaluator} evaluates {@code Phenotypes} to {@code Objectives}.
 * 
 * @author glass, lukasiewycz
 * 
 * @see Phenotype
 * @see Objectives
 * 
 * @param
 * <P>
 * the type of {@code Phenotype} that is evaluated
 */
public interface Evaluator<P extends Phenotype> {

	/**
	 * Evaluates a {@code Phenotype} and returns the results in the
	 * {@code Objectives}.
	 * 
	 * @param phenotype
	 *            the phenotype to be evaluated
	 * 
	 * @return the results in the objectives
	 */
	public Objectives evaluate(P phenotype);

	/**
	 * Returns all {@code Objective}s that are set by this evaluator.
	 * 
	 * @return all objectives
	 */
	public Collection<Objective> getObjectives();

}
