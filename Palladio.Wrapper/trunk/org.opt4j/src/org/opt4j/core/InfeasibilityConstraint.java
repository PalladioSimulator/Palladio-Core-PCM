/**
 * 
 */
package org.opt4j.core;

/**
 * A concrete constraint with the same attributes as the base class {@code Constraint}.
 * Semantically, a individual violating this constraint is considered infeasible.
 *
 * @see Constraint
 * @see Constraints
 * @see SatisfactionConstraint
 * @author noorshams
 *
 */
public class InfeasibilityConstraint extends Constraint {
	public InfeasibilityConstraint(String name, Direction direction, double limit) {
		super(name, direction, limit);
	}
}
