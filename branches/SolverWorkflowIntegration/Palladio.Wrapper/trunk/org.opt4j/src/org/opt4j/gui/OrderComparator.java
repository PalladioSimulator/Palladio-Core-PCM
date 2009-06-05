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
package org.opt4j.gui;

import java.util.Comparator;

/**
 * The {@code OrderComparator} is a comparator that orders objects increasing by the
 * value given in the {@link Order} annotation.
 * 
 * @author lukasiewycz
 * 
 * @param <T>
 *            the type of ordered elements
 */
class OrderComparator<T> implements Comparator<T> {

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.Comparator#compare(java.lang.Object, java.lang.Object)
	 */
	@Override
	public int compare(T s0, T s1) {
		Order p0 = s0.getClass().getAnnotation(Order.class);
		Order p1 = s1.getClass().getAnnotation(Order.class);

		if (p0 != null && p1 != null) {
			return p0.value() - p1.value();
		} else if (p0 != null) {
			return -1;
		} else if (p1 != null) {
			return 1;
		} else {
			return s0.getClass().getName().compareTo(s1.getClass().getName());
		}
	}
}
