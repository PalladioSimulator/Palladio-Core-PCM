/**
 * 
 */
package org.opt4j.core.domination;

import org.opt4j.core.Constraint;
import org.opt4j.core.Objectives;


/**
 * Interface for constraint checks of {@code Objectives}.
 * 
 * @see Constraint
 * @see ConstraintDomination
 * @author noorshams
 *
 */
public interface ConstraintChecker {
	/**
	 * Checks, if {@code Objectives} is feasible.
	 * 
	 * @param o the objectives to check
	 * @return the feasibility
	 */
	boolean isFeasible(final Objectives o);
	/**
	 * Calculates the constraint violation of {@code Objectives}.
	 * 
	 * @param o the objectives to check
	 * @return the amount of constraint violation
	 */
	double getConstraintViolation(final Objectives o);
}
