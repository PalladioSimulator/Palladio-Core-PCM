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
 * Provides the classes for the completers.
 * </p>
 * <p>
 * The task of a {@code Completer} is to {@code decode} and {@code evaluate} an
 * {@code Individual}. Finally, the {@code Individual} is in the state {@code
 * evaluated}. In real-world and industrial problems the decoding and evaluation
 * is the most time consuming task. Internally, the {@code Completer} uses the
 * {@code Decoder} and {@code Evaluator}. In fact, an {@code Optimizer} shall
 * use the {@code Completer} instead of the {@code Decoder} and
 * {@code Evaluator}.
 * </p>
 * <p>
 * There are two predefined completers: The {@code SequentialCompleter}
 * completes each individual sequentially. The {@code ParallelCompleter} {@code
 * n} individuals in parallel exploiting multicore architectures efficiently.
 * </p>
 */
package org.opt4j.common.completer;
