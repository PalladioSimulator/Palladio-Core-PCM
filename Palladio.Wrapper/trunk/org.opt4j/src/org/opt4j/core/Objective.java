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

package org.opt4j.core;

import static org.opt4j.core.Objective.Sign.MIN;

import org.opt4j.core.problem.Evaluator;

/**
 * <p>
 * The {@code Objective} is the identifier for a single objective in the {@code
 * Objectives}. It is specified by the following properties:
 * </p>
 * <ul>
 * <li>Name</li>
 * <li>Minimization or Maximization</li>
 * <li>Rank (use for ordering)</li>
 * </ul>
 * <p>
 * Each {@code Evaluator} sets a specific amount of {@code Objective}-{@code
 * Value} pairs.
 * </p>
 * 
 * @see Objectives
 * @see Evaluator#getObjectives()
 * @author lukasiewycz, noorshams
 * 
 */
public class Objective extends Criterion implements Comparable<Objective> {

	/**
	 * The sign of the objective.
	 */
	public enum Sign {
		/**
		 * Minimize the objective.
		 */
		MIN,
		/**
		 * Maximize the objective.
		 */
		MAX;
	}

	/**
	 * Standard rank of an objective (0).
	 */
	public static final int RANK_OBJECTIVE = 0;

	/**
	 * High priority rank (-100).
	 */
	public static final int RANK_ERROR = -100;

	/**
	 * Identifier for infeasible results ({@code null}).
	 */
	public static final Value<?> INFEASIBLE = null;

	protected final Sign sign;

	protected final int rank;

	/**
	 * Constructs an {@code Objective} with a given name, sign=MIN, and
	 * rank=RANK_OBJECTIVE(0).
	 * 
	 * @param name
	 *            the name
	 */
	public Objective(String name) {
		this(name, MIN, RANK_OBJECTIVE);
	}

	/**
	 * Constructs an {@code Objective} with a given name, sign, and
	 * rank=RANK_OBJECTIVE(0).
	 * 
	 * @param name
	 *            the name
	 * @param sign
	 *            the sign of the objective
	 */
	public Objective(String name, Sign sign) {
		this(name, sign, RANK_OBJECTIVE);
	}

	/**
	 * Constructs an {@code Objective} with a given name, sign, and rank.
	 * 
	 * @param name
	 *            the name
	 * @param sign
	 *            the sign of the objective
	 * @param rank
	 *            the rank
	 */
	public Objective(String name, Sign sign, int rank) {
		super(name);
		this.sign = sign;
		this.rank = rank;
	}

	/**
	 * Returns the sign.
	 * 
	 * @return the sign
	 */
	public Sign getSign() {
		return sign;
	}

	/**
	 * Returns the rank.
	 * 
	 * @return the rank
	 */
	public int getRank() {
		return rank;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	public int compareTo(Objective other) {
		if (this.equals(other)) {
			return 0;
		} else if (other == null) {
			return 1;
		} else {
			int diff = this.getRank() - other.getRank();
			if (diff != 0) {
				return diff;
			}
			return this.getName().compareTo(other.getName());
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + "(" + getSign() + ")";
	}

}
