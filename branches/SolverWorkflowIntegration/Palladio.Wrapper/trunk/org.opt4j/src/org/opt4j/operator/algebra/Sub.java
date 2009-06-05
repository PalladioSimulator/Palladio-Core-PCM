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

package org.opt4j.operator.algebra;

/**
 * The {@code Sub} term subtracts two terms.
 * 
 * @author lukasiewycz
 * 
 */
public class Sub implements Term {

	protected final Term a;

	protected final Term b;

	/**
	 * Constructs a {@code Sub} term.
	 * 
	 * @param a
	 *            the minuend
	 * @param b
	 *            the subtrahend
	 */
	public Sub(final Term a, final Term b) {
		super();
		this.a = a;
		this.b = b;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.algebra.Term#calculate(double[])
	 */
	public double calculate(double... values) {
		return a.calculate(values) - b.calculate(values);
	}

}
