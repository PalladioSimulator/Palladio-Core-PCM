/**
 * 
 */
package org.opt4j.core;

/**
 * Superclass for criteria handled in a {@code CriterionSet}. It is specified by a name.
 * 
 * @see Objective
 * @see Constraint
 * @see CriterionSet
 * @author noorshams
 *
 */
public abstract class Criterion {
	protected final String name;
	
	protected Criterion(String name){
		this.name = name;
	}
	
	/**Returns the name
	 * 
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	
}
