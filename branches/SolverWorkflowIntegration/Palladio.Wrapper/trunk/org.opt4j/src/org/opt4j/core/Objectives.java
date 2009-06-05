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

import java.util.Collection;
import java.util.Iterator;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.Map.Entry;

import static org.opt4j.core.Objective.Sign.MAX;

/**
 * The {@code Objectives} contain the {@code Objective} {@code Values} of an
 * {@code Individual}. Additionally, the feasibility of the {@code Objectives}
 * can be set. The feasibility {@code #isFeasible()} is {@code true} by default,
 * set this value to {@code false} to indicate that the corresponding
 * {@code Individual} is infeasible (e.g. it violates constraints).
 * 
 * @author lukasiewycz
 * 
 */
public class Objectives implements Iterable<Entry<Objective, Value<?>>> {

	protected SortedMap<Objective, Value<?>> map = new TreeMap<Objective, Value<?>>();

	protected double[] array = null;

	protected boolean feasible = true;

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

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Iterable#iterator()
	 */
	public Iterator<Entry<Objective, Value<?>>> iterator() {
		return map.entrySet().iterator();
	}

	/**
	 * Returns an array of all values which all have to be minimized. Do not
	 * call this method before all objectives were added!
	 * 
	 * @see Value#getDouble()
	 * @return an array containing values which have to be minimized
	 */
	public double[] array() {
		return array;
	}

	/**
	 * Calculates the array.
	 */
	public void submit() {
		if (array == null) {
			array = new double[size()];
			int i = 0;
			for (Entry<Objective, Value<?>> entry : this) {
				Objective objective = entry.getKey();
				Value<?> value = entry.getValue();

				Double v = value.getDouble();

				if (v == null) {
					array[i] = Double.MAX_VALUE;
				} else if (objective.getSign() == MAX) {
					array[i] = -v;
				} else {
					array[i] = v;
				}

				i++;
			}
		}

	}

	/**
	 * Returns the number of set {@code Objective}s.
	 * 
	 * @return the number of set {@code Objective}s
	 */
	public int size() {
		return map.size();
	}

	/**
	 * Returns all objectives.
	 * 
	 * @return all objectives
	 */
	public Collection<Objective> getKeys() {
		return map.keySet();
	}

	/**
	 * Returns all values.
	 * 
	 * @return all values
	 */
	public Collection<Value<?>> getValues() {
		return map.values();
	}

	/**
	 * Returns the value that is assigned to the given objective. Returns
	 * {@code null} if the objective does not exist.
	 * 
	 * @param objective
	 *            the given objective
	 * @return the value
	 */
	public Value<?> get(Objective objective) {
		return map.get(objective);
	}

	/**
	 * Returns the objective that is assigned to the given value. Returns
	 * {@code null} if the value does not exist.
	 * 
	 * @param value
	 *            the given value
	 * @return the objective
	 */
	public Objective get(Value<?> value) {
		Objective objective = null;
		for (Entry<Objective, Value<?>> entry : this) {
			Value<?> v = entry.getValue();
			if (value.equals(v)) {
				Objective o = entry.getKey();
				objective = o;
				break;
			}
		}
		return objective;
	}

	/**
	 * Adds the objective with the specified value.
	 * 
	 * @param objective
	 *            the objective
	 * @param value
	 *            the value
	 */
	public void add(Objective objective, Value<?> value) {
		if (value == null) {
			map.put(objective, new DoubleValue(null));
		} else {
			map.put(objective, value);
		}
	}

	/**
	 * Adds the objective with the specified double value.
	 * 
	 * @param objective
	 *            the objective
	 * @param value
	 *            the value
	 */
	public void add(Objective objective, double value) {
		add(objective, new DoubleValue(value));
	}

	/**
	 * Adds the objective with the specified integer value.
	 * 
	 * @param objective
	 *            the objective
	 * @param value
	 *            the value
	 */
	public void add(Objective objective, int value) {
		add(objective, new IntegerValue(value));
	}

	/**
	 * Adds all objective with the specified value specified in
	 * {@code objectives}.
	 * 
	 * @param objectives
	 *            the objectives
	 */
	public void add(Objectives objectives) {
		map.putAll(objectives.map);
	}

	/**
	 * Returns {@code true} if this objectives weakly dominates the specified
	 * objectives. This comparison is based on the {@code #array()} values.
	 * 
	 * @param opponent
	 *            other objectives
	 * @return {@code true} if this objectives weakly dominate the
	 *         {@code opponent}
	 */
	public boolean weaklyDominates(Objectives opponent) {
		double[] va = this.array();
		double[] vb = opponent.array();
		for (int i = 0; i < va.length; i++) {
			if (vb[i] < va[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Returns {@code true} if this objectives dominate the specified
	 * objectives. This comparison is based on the {@code #array()} values.
	 * 
	 * @param opponent
	 *            other objectives
	 * @return {@code true} if these objectives dominate the {@code opponent}
	 */
	public boolean dominates(Objectives opponent) {
		double[] va = this.array();
		double[] vb = opponent.array();

		boolean equal = true;
		for (int i = 0; i < va.length; i++) {
			if (va[i] > vb[i]) {
				return false;
			} else if (va[i] < vb[i]) {
				equal = false;
			}
		}
		return !equal;
	}

	/**
	 * Returns {@code true} if this objectives are equal to the specified
	 * objectives. This comparison is based on the {@code #array()} values.
	 * 
	 * @param opponent
	 *            other objectives
	 * @return {@code true} if these objectives dominate the {@code opponent}
	 */
	public boolean isEqual(Objectives opponent) {
		double[] va = this.array();
		double[] vb = opponent.array();

		for (int i = 0; i < va.length; i++) {
			if (va[i] != vb[i]) {
				return false;
			}
		}
		return true;
	}

	/**
	 * Calculates the euclidean distance of two {@code Objectives}. This
	 * calculation is based on the {@code #array()} values.
	 * 
	 * @param other
	 *            the second objectives
	 * @return the euclidean distance
	 */
	public double distance(Objectives other) {
		double[] va = this.array();
		double[] vb = other.array();

		double s = 0;
		for (int i = 0; i < va.length; i++) {
			s += (va[i] - vb[i]) * (va[i] - vb[i]);
		}

		return Math.sqrt(s);
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		for(Entry<Objective, Value<?>> entry: map.entrySet()){
			Objective o = entry.getKey();
			Value<?> v = entry.getValue();
			s += o+"="+v+" ";
		}
		return s;
	}
	
	

}
