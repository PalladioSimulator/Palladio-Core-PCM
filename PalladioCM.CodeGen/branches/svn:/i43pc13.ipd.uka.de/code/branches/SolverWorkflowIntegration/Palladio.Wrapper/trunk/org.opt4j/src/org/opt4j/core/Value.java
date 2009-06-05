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

/**
 * The {@code Value} is assigned to an {@code Objective}.
 * 
 * @author lukasiewycz
 * 
 * @param <V>
 *            the type of the value
 */
public interface Value<V> extends Comparable<Value<V>> {

	/**
	 * Returns the value.
	 * 
	 * @return the value
	 */
	public V getValue();

	/**
	 * Sets the value.
	 * 
	 * @param value
	 *            the value to set
	 */
	public void setValue(V value);

	/**
	 * Returns a double value.
	 * 
	 * @return double value
	 */
	public Double getDouble();

}
