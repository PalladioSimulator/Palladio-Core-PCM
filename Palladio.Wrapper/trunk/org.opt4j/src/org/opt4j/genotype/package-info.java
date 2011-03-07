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
 * Provides the classes for basic {@code Genotypes}.
 * </p>
 * <p>
 * The basic {@link org.opt4j.core.problem.Genotype} classes are the following:
 * <ul>
 * <li>{@link org.opt4j.genotype.BooleanGenotype} - a list of boolean (binary)
 * values</li>
 * <li>{@link org.opt4j.genotype.DoubleGenotype} - a list of double (real)
 * values</li>
 * <li>{@link org.opt4j.genotype.IntegerGenotype} - a list of integer values</li>
 * <li>{@link org.opt4j.genotype.PermutationGenotype} - a permutation of
 * arbitrary objects</li>
 * <li>{@link org.opt4j.genotype.CompositeGenotype} - a container for arbitrary
 * genotype objects</li>
 * </ul>
 * </p>
 * <p>
 * Try to stick to the predefined genotype objects. Use the {@code
 * CompositeGenotype} to assemble complex genotypes. If you define your own
 * genotype, keep in mind that you also have to define the corresponding
 * operators.
 * </p>
 * <p>
 * The {@code DoubleGenotype} and {@code IntegerGenotype} both can be bounded by
 * an upper and lower bound for each value. The corresponding bounds classes are
 * the {@link org.opt4j.genotype.DoubleBounds} and
 * {@link org.opt4j.genotype.IntegerBounds}. These bounds are passed in the
 * constructor of the {@code DoubleGenotype} or {@code IntegerGenotype},
 * respectively.
 * </p>
 * <p>
 * By default, the {@code BooleanGenotype},{@code DoubleGenotype}, and {@code
 * IntegerGenotype} are pure lists. This means, one has to identify elements by
 * their index. The classes {@link org.opt4j.genotype.BooleanMapGenotype},
 * {@link org.opt4j.genotype.DoubleMapGenotype}, and
 * {@link org.opt4j.genotype.IntegerMapGenotype} extend the basic genotype
 * classes by a map functionality. Therefore, a list of the key elements has to
 * be passed in the constructors. Internally, this list is used for a mapping of
 * key to indices. Therefore, this list must be in the same order with the same
 * elements for corresponding genotype instances.
 * </p>
 * <p>
 * A further extension of the {@code IntegerGenotype} is the
 * {@link org.opt4j.genotype.SelectGenotype} and
 * {@link org.opt4j.genotype.SelectMapGenotype}. Here, a specific set of
 * elements is defined such that for each index or key one element is chosen.
 * Internally, this is implemented as an {@code IntegerGenotype} such that the
 * elements are encoded as integer values.
 * </p>
 * <p>
 * The classes {@code BooleanMapGenotype}, {@code DoubleMapGenotype}, {@code
 * IntegerMapGenotype}, {@code SelectGenotype}, and {@code SelectMapGenotype}
 * are extended from {@code BooleanGenotype},{@code DoubleGenotype}, and {@code
 * IntegerGenotype}, respectively. Therefore, the default operators (
 * {@link org.opt4j.operator}) for the simple {@code Genotype} classes are
 * applied on their {@code Map} and {@code Select} {@code Genotype} classes.
 * </p>
 * <p>
 * Custom genotypes have to implement the
 * {@link org.opt4j.core.problem.Genotype} interface. If these classes are not
 * extended from existing {@code Genotype} classes, appropriate operators have
 * to be implemented (see {@link org.opt4j.operator}).
 * </p>
 * <p>
 * The initialization of the genotypes is done in the
 * {@link org.opt4j.core.problem.Creator}. Each genotype class has an appropriate
 * {@code init} method to simplify the initialization.
 * </p>
 * 
 * @see org.opt4j.operator
 * 
 */
package org.opt4j.genotype;