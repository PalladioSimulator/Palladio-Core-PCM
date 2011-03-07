/**
 * 
 */
package org.opt4j.core.domination;


import org.opt4j.core.Objectives;

import com.google.inject.ImplementedBy;



/**
 * This is the interface for a domination strategy. It is used to compare {@code Individual}s. 
 * 
 * @see Objectives#dominates(Objectives)
 * @author noorshams
 *
 */
@ImplementedBy(ParetoDomination.class)
public interface DominationStrategy {
	/**
	 * Checks two {@code Objectives} for domination. 
	 * 
	 * @param o1 the objectives to check
	 * @param o2 the objectives to compare with
	 * @return {@code true}, if {@code o1} dominates {@code o2}<br>
	 * {@code false}, otherwise
	 */
	boolean dominates(final Objectives o1, final Objectives o2);	
	/**
	 * Checks two {@code Objectives} for weak domination.
	 * 
	 * @param o1 the objectives to check
	 * @param o2 the objectives to compare with
	 * @return {@code true}, if {@code o1} weakly dominates {@code o2}<br> 
	 * {@code false}, otherwise
	 */
	boolean weaklyDominates(final Objectives o1, final Objectives o2);
}
