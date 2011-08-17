/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import de.uka.ipd.sdq.tcfmoop.config.TerminationCriteriaNames;
import de.uka.ipd.sdq.tcfmoop.outputtree.Tree;

public interface ITerminationCriterion {
	
	/**
	 * Returns the name of the termination criteria.
	 * @return the name of the termination criteria.
	 */
	public TerminationCriteriaNames getName();
	
	/**
	 * Evaluates this termination criteria.
	 * @param iteration - The number of the current iteration
	 * @param currentTime - The current time
	 */
	public void evaluate(int iteration, long currentTime);
	
	/**
	 * Returns the result of the last evaluation.
	 * @return true - Optimization should be terminated.
	 * 		   else - Optimization should continue.
	 */
	public boolean getEvaluationResult();
	
	/**
	 * Returns the criteria output information.
	 * @return String with output information.
	 */
	public Tree getOutputInformation();	
	
}
