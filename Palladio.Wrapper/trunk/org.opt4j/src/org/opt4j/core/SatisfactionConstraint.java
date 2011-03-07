/**
 * 
 */
package org.opt4j.core;


/**
 * A concrete constraint with the same attributes as the base class {@code Constraint} 
 * and an additional attribute specifying the objective it refers to.
 * Semantically, a individual violating this constraint is considered unsatisfactory. 
 * The constraint can be seen as a goal for an objective that is wanted to be reached.
 * 
 * @see Constraint
 * @see Constraints
 * @see InfeasibilityConstraint
 * @author noorshams
 *
 */
public class SatisfactionConstraint extends Constraint {
	
	protected final Objective objective;
	
	/**
	 * @return the objective
	 */
	public Objective getObjective() {
		return objective;
	}

	public SatisfactionConstraint(String name, Direction direction, double limit, Objective objective) {
		super(name, direction, limit);
		this.objective = objective;
	}
}
