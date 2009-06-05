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

/**
 * <p>
 * The {@code Objective} is an identifier for {@code Objectives}. You can
 * specify the following properties:
 * </p>
 * <ul>
 * <li>Name</li>
 * <li>Minimization or Maximization</li>
 * <li>Rank (use for ordering)</li>
 * </ul>
 * 
 * @author lukasiewycz
 * 
 */
public class Objective implements Comparable<Objective> {

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

	protected final String name;

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
		super();
		this.name = name;
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
	 * Returns the name.
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Returns the ranke.
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
