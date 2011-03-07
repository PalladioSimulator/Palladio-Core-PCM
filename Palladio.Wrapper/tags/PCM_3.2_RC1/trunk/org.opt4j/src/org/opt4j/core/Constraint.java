/**
 * 
 */
package org.opt4j.core;

/**
 * <p>
 * The {@code Constraint} is the identifier for a single constraint in the {@code
 * Constraints}. It is the superclass for concrete constraints. It is specified by 
 * the following properties:
 * </p>
 * <ul>
 * <li>Name</li>
 * <li>Direction</li>
 * <li>Limit</li>
 * </ul>
 * <p>
 * Each {@code Evaluator} sets a specific amount of {@code Constraint}-{@code
 * Value} pairs.
 * </p>
 * 
 * @see InfeasibilityConstraint
 * @see SatisfactionConstraint
 * @see Constraints
 * @see Objectives#getConstraints()
 * @author noorshams
 *
 */
public abstract class Constraint extends Criterion implements Comparable<Constraint> {
	
	/**
	 * Defines the possible directions a constraint can be defined.
	 */
	public enum Direction {
		less, greater, equal, lessOrEqual, greaterOrEqual;
	}

	protected final Direction direction;
	protected final double limit;

	public Constraint(String name, Direction direction, double limit){
		super(name);
		this.direction = direction;
		this.limit = limit;
	}
	
	/**
	 * @return the direction
	 */
	public Direction getDirection() {
		return direction;
	}

	/**
	 * @return the limit
	 */
	public double getLimit() {
		return limit;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return getName() + "(" + getDirection() + " " + getLimit() + ")["+ this.getClass() +"]";
	}

	/* (non-Javadoc)
	 * @see java.lang.Comparable#compareTo(java.lang.Object)
	 */
	@Override
	public int compareTo(Constraint other) {
		// Compares mainly keys
		if (this.equals(other)) {
			return 0;
		} else if (other == null) {
			return 1;
		} else {
			return this.getName().compareTo(other.getName());
		}
	}

}
