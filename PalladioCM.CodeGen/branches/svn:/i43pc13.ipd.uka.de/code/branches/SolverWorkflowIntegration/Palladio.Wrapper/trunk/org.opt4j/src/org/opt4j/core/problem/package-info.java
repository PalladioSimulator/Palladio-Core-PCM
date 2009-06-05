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

/**
 * <p>
 * Provides the classes for the optimization problem. 
 * A problem consists is defined by the following classes: 
 * </p>
 * <dl>
 * <dt>{@link org.opt4j.core.Genotype}</dt>
 * <dd>
 * The {@code Genotype} is the genetic representation of an {@code Individual}.
 * The package {@link org.opt4j.genotype} contains predefined {@code Genotype}s that allow a modular assembly.
 * Thus, usually you dont have to write your custom {@code Genotype}.
 * </dd>
 * <dd>
 * <dt>{@link org.opt4j.core.Phenotype}</dt>
 * <dd>The {@code Phenotype} represents a solution of the optimization problem.</dd>
 * <dt>{@link org.opt4j.core.problem.Creator}</dt>
 * <dd>The task of the {@code Creator} is the creation of random {@code Genotype}s.</dd>
 * <dt>{@link org.opt4j.core.problem.Decoder}</dt>
 * <dd>The task of the {@code Decoder} is the decoding from a given {@code Genotype} to a corresponding {@code Phenotype}.</dd>
 * <dt>{@link org.opt4j.core.problem.Evaluator}</dt>
 * <dd>The task of the {@code Evaluator} is the evaluation of {@code Phenotype}s to the {@code Objectives}.</dd>
 * </dl>
 * <p>
 * Additional information about the problem should be contained in an user defined class that is injected as needed.
 * </p>
 * 
 */
package org.opt4j.core.problem;