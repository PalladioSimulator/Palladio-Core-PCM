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



/**
 * The {@code Constraints} contains the {@code Constraint}-{@code Values} pairs of
 * an {@code Individual}. It is contained in {@code Objectives}.
 * 
 * @see Value
 * @see Constraint
 * @see Objectives
 * @author noorshams
 * 
 */
public class Constraints extends CriterionSet<Constraint> {

	/**
	 * Returns an array of all constraint values. Do not
	 * call this method before all constraints were added!
	 * 
	 * @see Value#getDouble()
	 * @return an array containing constraint values
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
			for (Entry<Constraint, Value<?>> entry : this) {
				
				Value<?> value = entry.getValue();
				Double v = value.getDouble();

				if (v == null) {
					array[i] = Double.MAX_VALUE;
				} else {
					array[i] = v;
				}

				i++;
			}
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String s = "";
		for (Entry<Constraint, Value<?>> entry : map.entrySet()) {
			Constraint c = entry.getKey();
			Value<?> v = entry.getValue();
			s += c + "=" + v + " ";
		}
		return s;
	}

}
