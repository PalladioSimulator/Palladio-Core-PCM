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

import java.util.Map.Entry;

import org.opt4j.core.domination.DominationStrategy;
import org.opt4j.core.domination.ParetoDomination;

import com.google.inject.Inject;



/**
 * The {@code Objectives} contains the {@code Objective}-{@code Values} pairs of
 * an {@code Individual}. Additionally, the feasibility of the {@code
 * Objectives} can be set. The feasibility {@code #isFeasible()} is {@code true} by
 * by default. Set this value to {@code false} to indicate that the
 * corresponding {@code Individual} is infeasible (e.g., it violates
 * constraints).
 * 
 * @see Value
 * @see Objective
 * @author lukasiewycz, noorshams
 * 
 */
public class Objectives extends CriterionSet<Objective> {

	protected boolean feasible = true;

	protected Constraints constraints = new Constraints();
		
	protected DominationStrategy dominationStrategy;
		
	
	/**
	 * Inject a {@code Provider<Objectives>} object instead 
	 * and create {@code Objectives} objects with
	 * {@code provider.get()}.
	 */
	@Deprecated
	public Objectives(){
		this.dominationStrategy = new ParetoDomination(); 
	}
	
	@Inject
	public Objectives(DominationStrategy strategy){
		this.dominationStrategy = strategy;
	}
	
	/**
	 * Returns the constraints.
	 * 
	 * @return the constraints
	 */
	public Constraints getConstraints() {
		return constraints;
	}

	/**
	 * Sets the constraints.
	 * 
	 * @param constraints the constraints to set
	 */
	public void setConstraints(Constraints constraints) {
		this.constraints = constraints;
	}
	
	/**
	 * Returns the domination strategy of the Objective.
	 * 
	 * @return the domination strategy of the Objective
	 */
	public DominationStrategy getDominationStrategy(){
		return this.dominationStrategy;
	}

	/**
	 * Returns the feasibility.
	 * 
	 * @return the feasibility
	 */
	public boolean isFeasible() {
		return feasible;
	}

	/**
	 * Sets the feasibility.
	 * 
	 * @param feasible
	 *            the feasibility to set
	 */
	public void setFeasible(boolean feasible) {
		this.feasible = feasible;
	}

	/**
	 * Returns an array of all values which all have to be minimized. Do not
	 * call this method before all objectives were added!
	 * 
	 * @see Value#getDouble()
	 * @return an array containing values which have to be minimized
	 */
	@Override
	public double[] array() {
		if (array == null) {
			submit();
		}

		return array;
	}

	/**
	 * Calculates the array.
	 */
	protected synchronized void submit() {
		if (array == null) {
			array = new double[size()];
			int i = 0;
			for (Entry<Objective, Value<?>> entry : this) {
				Objective objective = entry.getKey();
				Value<?> value = entry.getValue();

				Double v = value.getDouble();

				if (v == null) {
					array[i] = Double.MAX_VALUE;
				} else if (objective.getSign() == Objective.Sign.MAX) {
					array[i] = -v;
				} else {
					array[i] = v;
				}

				i++;
			}
		}
	}

	/**
	 * Returns {@code true} if this objectives weakly dominates the specified
	 * objectives. This comparison depends on the chosen {@code DominationStrategy}.
	 * 
	 * @param opponent
	 *            other objectives
	 * @return {@code true} if this objectives weakly dominate the {@code
	 *         opponent}
	 */
	public boolean weaklyDominates(Objectives opponent) {
		return this.dominationStrategy.weaklyDominates(this, opponent);
	}

	/**
	 * Returns {@code true} if this objectives dominate the specified
	 * objectives. This comparison depends on the chosen {@code DominationStrategy}.
	 * 
	 * @param opponent
	 *            other objectives
	 * @return {@code true} if these objectives dominate the {@code opponent}
	 */
	public boolean dominates(Objectives opponent) {
		return this.dominationStrategy.dominates(this, opponent);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		for (Entry<Objective, Value<?>> entry : map.entrySet()) {
			Objective o = entry.getKey();
			Value<?> v = entry.getValue();
			s += o + "=" + v + " ";
		}
		return s;
	}

}
