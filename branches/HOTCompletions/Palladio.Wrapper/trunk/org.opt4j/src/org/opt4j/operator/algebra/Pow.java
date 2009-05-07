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
 * The {@code Pow} performs an exponention for two terms.
 * 
 * @author lukasiewycz
 * 
 */
public class Pow implements Term {

	protected final Term a;

	protected final Term n;

	/**
	 * Constructs a {@code Pow} term.
	 * 
	 * @param a
	 *            the base
	 * @param n
	 *            the exponent
	 */
	public Pow(final Term a, final Term n) {
		super();
		this.a = a;
		this.n = n;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.operator.algebra.Term#calculate(double[])
	 */
	public double calculate(double... values) {
		return Math.pow(a.calculate(values), n.calculate(values));
	}

}
