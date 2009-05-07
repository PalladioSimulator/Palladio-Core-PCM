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
package org.opt4j.sat;

/**
 * The {@code Term} is an elements of the linear {@link Constraint}. The {@code
 * Term} is an integer coefficient times a {@link Literal}.
 * 
 * @author lukasiewycz
 * 
 */
public class Term {

	protected final int coeff;
	protected final Literal lit;

	/**
	 * Constructs a {@code Term}.
	 * 
	 * @param coeff
	 *            the integer coefficient
	 * @param lit
	 *            the literal
	 */
	public Term(int coeff, Literal lit) {
		this.coeff = coeff;
		this.lit = lit;
	}

	/**
	 * Returns the coefficient.
	 * 
	 * @return the coefficient
	 */
	public int getCoefficient() {
		return coeff;
	}

	/**
	 * Returns the literal.
	 * 
	 * @return the literal
	 */
	public Literal getLiteral() {
		return lit;
	}

	/**
	 * Constructs a copy to this term.
	 * 
	 * @return a copy of this term
	 */
	public Term copy() {
		return new Term(coeff, lit);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return coeff + " " + lit;
	}

}
