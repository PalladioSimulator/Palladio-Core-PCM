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
 * Provides the classes for general (generic) operators.
 * </p>
 * <p>
 * The {@link org.opt4j.core.problem.Genotype} objects are changed within the
 * optimization process in order to find better solutions. The variation is
 * performed by the {@link org.opt4j.core.optimizer.Operator} classes. The
 * framework already contains several operators:
 * <ul>
 * <li>{@link org.opt4j.operator.algebra.Algebra} - Vector-based operator with
 * terms (restricted to {@link org.opt4j.genotype.DoubleGenotype})</li>
 * <li>{@link org.opt4j.operator.copy.Copy} - Copy operator</li>
 * <li>{@link org.opt4j.operator.crossover.Crossover} - Crossover operator that
 * always creates two offspring from two parents</li>
 * <li>{@link org.opt4j.operator.diversity.Diversity} - Diversity operator that
 * determines the differences between two genotypes</li>
 * <li>{@link org.opt4j.operator.mutate.Mutate} - Mutate operator that changes
 * one genotype</li>
 * <li>{@link org.opt4j.operator.neighbor.Neighbor} - Neighbor operator that
 * changes one genotype</li>
 * </ul>
 * Each {@code Operator} is parameterized with the corresponding target {@code
 * Genotype}. Adding custom operators, e.g., a new {@code Crossover} operator
 * for the {@code DoubleGenotype}, is quite simple. The new operator has to be
 * extended from {@link org.opt4j.operator.crossover.Crossover} with the
 * parameter {@code DoubleGenotype} or alternatively directly from the
 * {@link org.opt4j.operator.crossover.CrossoverDouble}. The corresponding
 * crossover method has to be implemented. Finally, the operator has to be added
 * with the
 * {@link org.opt4j.operator.crossover.CrossoverModule#addCrossover(Class)}
 * method. Therefore, you can either extend a custom module from
 * {@link org.opt4j.operator.crossover.CrossoverModule} or, instead, directly
 * use the static method
 * {@link org.opt4j.operator.crossover.CrossoverModule#addCrossover(Binder,Class)}
 * .
 * </p>
 * <p>
 * The appropriate operator is determined at runtime by the framework by
 * checking the parameter of the operator. Alternatively, the
 * {@link org.opt4j.operator.Apply} annotation can be used to specify a
 * different target {@code Genotype} class.
 * </p>
 * <p>
 * Creating completely new operators is done by extending the {@code Operator}
 * interface to the new operator with the specific method. The new operator
 * implementation can be bound directly within a module in the {@code config}
 * method by {@code
 * bind(CustomOperator.class).to(CustomOperatorImplmenentation.class)}. Note
 * that this operator will only handle exactly its target {@code Genotype}
 * classes.
 * </p>
 * <p>
 * A new generic operator should be instantiated from the
 * {@link org.opt4j.operator.AbstractGenericOperator}. See the existing generic
 * operators.
 * </p>
 * 
 */
package org.opt4j.operator;

