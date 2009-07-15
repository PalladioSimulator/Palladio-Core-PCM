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

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * The interface for objects that represent a constraint in an ILP.
 * 
 * @author lukasiewycz
 * 
 */
public class Constraint extends ArrayList<Term> {

	protected List<Term> terms = new ArrayList<Term>();

	protected Operator operator = Operator.GE;
	protected int rhs = 1;

	/**
	 * The {@code Operator}s correspond to the Boolean operators <=,=,>=.
	 */
	public enum Operator {
		/**
		 * Boolean operation <=
		 */
		LE,
		/**
		 * Boolean operation =
		 */
		EQ,
		/**
		 * Boolean operation >=
		 */
		GE;

		/**
		 * Returns a {@code String} representation of this {@code Operator}.
		 * 
		 * @return a string representation of this operator
		 */
		@Override
		public String toString() {
			switch (this) {
			case LE:
				return "<=";
			case EQ:
				return "=";
			default: // GE
				return ">=";
			}
		}

		/**
		 * Returns {@code true} if the {@code Operation} is true.
		 * 
		 * @param lhs
		 *            the left hand side value
		 * @param rhs
		 *            the right hand side value
		 * @return {@code true} if the operation is true for the two values
		 */
		public boolean isTrue(int lhs, int rhs) {
			switch (this) {
			case LE:
				return (lhs <= rhs);
			case EQ:
				return (lhs == rhs);
			default: // GE
				return (lhs >= rhs);
			}
		}

		/**
		 * Converts a {@code String} to an operator.
		 * 
		 * @param string
		 *            the string (<=,=,>=).
		 * @return the operator
		 */
		public static Operator getOperator(String string) {
			if ("<=".equals(string)) {
				return LE;
			} else if ("=".equals(string)) {
				return EQ;
			} else if (">=".equals(string)) {
				return GE;
			} else {
				throw new IllegalArgumentException("Unknown operator " + string
						+ ". Allowed operators are: <=,=,>=");
			}
		}
	}

	/**
	 * Constructs a linear {@code Constraint} with {@code >=1}.
	 */
	public Constraint() {
		this(Operator.GE, 1);
	}

	/**
	 * Constructs a linear {@code Constraint}.
	 * 
	 * @param operator
	 *            the operator (<=,=,>=) as a String
	 * @param rhs
	 *            the right-hand-side value
	 */
	public Constraint(String operator, int rhs) {
		this(Operator.getOperator(operator), rhs);
	}

	/**
	 * Constructs a linear {@code Constraint}.
	 * 
	 * @param operator
	 *            the operator
	 * @param rhs
	 *            the right-hand-side value
	 */
	public Constraint(Operator operator, int rhs) {
		this.operator = operator;
		this.rhs = rhs;
	}

	/**
	 * Returns an iterable of the coefficients.
	 * 
	 * @return the coefficients
	 */
	public Iterable<Integer> getCoefficients() {
		return new Iterable<Integer>() {
			@Override
			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {

					int i = 0;

					@Override
					public boolean hasNext() {
						return (i < size());
					}

					@Override
					public Integer next() {
						return get(i++).getCoefficient();
					}

					@Override
					public void remove() {
						throw new RuntimeException("Operation not supported");
					}
				};
			}
		};
	}

	/**
	 * Returns an iterable of the {@code Literals}.
	 * 
	 * @return the literals.
	 */
	public Iterable<Literal> getLiterals() {
		return new Iterable<Literal>() {
			@Override
			public Iterator<Literal> iterator() {
				return new Iterator<Literal>() {

					int i = 0;

					@Override
					public boolean hasNext() {
						return (i < size());
					}

					@Override
					public Literal next() {
						return get(i++).getLiteral();
					}

					@Override
					public void remove() {
						throw new RuntimeException("Operation not supported");
					}
				};
			}
		};
	}

	/**
	 * Returns the {@code Operator}.
	 * 
	 * @return the operator
	 */
	public Operator getOperator() {
		return operator;
	}

	/**
	 * Sets the {@code Operator}.
	 * 
	 * @param operator
	 *            the operator to be set
	 */
	public void setOperator(Operator operator) {
		this.operator = operator;
	}

	/**
	 * Return the right hand side value.
	 * 
	 * @return the right hand side value
	 */
	public int getRhs() {
		return rhs;
	}

	/**
	 * Sets the right hand side value.
	 * 
	 * @param rhs
	 *            the right hand side value to set
	 */
	public void setRhs(int rhs) {
		this.rhs = rhs;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.util.AbstractCollection#toString()
	 */
	@Override
	public String toString() {
		String s = "";

		for (int i = 0; i < size(); i++) {
			s += get(i);
			if (i < size() - 1) {
				s += " + ";
			}
		}

		s += " " + operator + " ";
		s += rhs;

		return s;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see org.opt4j.sat.Constraint#isSatisfied(org.opt4j.sat.Model)
	 */
	public boolean isSatisfied(Model model) {
		int count = getCount(model);
		return operator.isTrue(count, rhs);

	}

	/**
	 * Specifies if the {@code Constraint} is satisfied for a given {@code
	 * Model}.
	 * 
	 * @param model
	 *            the model
	 * @return {@code true} if this constraint is satisfied for the model
	 */
	public int getViolationCount(Model model) {
		int count = getCount(model);

		switch (operator) {
		case LE:
			return (count <= rhs) ? 0 : (count - rhs);
		case EQ:
			return Math.abs(count - rhs);
		default: // GE
			return (count >= rhs) ? 0 : (rhs - count);
		}
	}

	/**
	 * Add a {@code Literal} with the coefficient {@code 1}.
	 * 
	 * @param lit
	 *            the literal
	 */
	public void add(Literal lit) {
		add(1, lit);
	}

	/**
	 * Add a {@code Literal} with specified coefficient.
	 * 
	 * @param coeff
	 *            the coefficient
	 * @param lit
	 *            the literal
	 */
	public void add(int coeff, Literal lit) {
		Term term = new Term(coeff, lit);
		add(term);
	}

	/**
	 * Returns the sum of the left hand side of the constraint for a given
	 * model.
	 * 
	 * @param model
	 *            the model
	 * @return the sum
	 */
	private int getCount(Model model) {
		int count = 0;
		for (Term term : this) {
			Literal literal = term.getLiteral();
			int coefficient = term.getCoefficient();

			Object var = literal.variable();
			Boolean phase = literal.phase();

			if (phase.equals(model.get(var))) {
				count += coefficient;
			}
		}
		return count;
	}

	/**
	 * Copies the {@code Constraint}
	 * 
	 * @return a copy of the constraint
	 */
	public Constraint copy() {
		Constraint pb = new Constraint(operator, rhs);
		for (Term term : this) {
			pb.add(term.copy());
		}
		return pb;
	}

	/**
	 * Returns {@code true} if the {@code Constraint} contains the {@code
	 * Literal}.
	 * 
	 * @param literal
	 *            the literal
	 * 
	 * @return {@code true} if the constrain} contains the literal
	 */
	public boolean contains(Literal literal) {
		for (Term term : this) {
			if (literal.equals(term.getLiteral())) {
				return true;
			}
		}
		return false;
	}

	private static final long serialVersionUID = 1L;

}
