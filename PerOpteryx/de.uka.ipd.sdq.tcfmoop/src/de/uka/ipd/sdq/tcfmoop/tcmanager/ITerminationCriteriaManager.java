package de.uka.ipd.sdq.tcfmoop.tcmanager;

import java.util.List;

import org.opt4j.core.optimizer.OptimizerIterationListener;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;

/**
 * @author Atanas Dimitrov
 *
 */
public interface ITerminationCriteriaManager extends OptimizerIterationListener,
													 IRequestManualTerminationListener{
	
	/**
	 * Initializes the termination criteria manager by supplying it with a list of 
	 * termination criteria configurations.
	 * @param tcConfigurations
	 */
	public void initialize(List<IConfiguration> tcConfigurations);
	
	/**
	 * Activates Termination Criteria Comparison Mode in which termination criteria decisions
	 * do not influence the optimization but are shown on the output.
	 */
	public void activateTCComparisionMode();
	
	/**
	 * Deactivates Termination Criteria Comparison Mode in which termination criteria decisions are
	 * do not influence the optimization but are shown on the output.
	 */
	public void deactivateTCComparisionMode();
	
	/**
	 * Activates Composed Criterion Mode in which multiple termination criteria
	 * can be stringed together to form a more powerful termination criterion
	 */
	public void activateComposedCriterion();
	
	/**
	 * If Composed Criterion is deactivated then a simple || condition is used to
	 * evaluate results from the different criteria.
	 */
	public void deactivateComposedCriterion();
	
	/**
	 * Sets the expression used to define the relationship between the 
	 * termination criterion. If not set a standard Expression is used 
	 * (Crit1 || Crit2 || Crit3 || Crit4 || ...)
	 * @param composedCriterionExpression
	 */
	public void setComposedCriterionExpression(String composedCriterionExpression);
	
	/**
	 * Evaluates the termination criteria and then stops the optimization if the specified conditions
	 * are met.
	 */
	public void evaluateTerminationCriteria();
	
	/**
	 * Adds a new listener for the OutputChanged event.
	 * @param listener IOutputChangedListener listener
	 */
	public void addOutputChangedListener(IOutputChangedListener listener);
	
	/**
	 * Removes a new listener for the OutputChanged event.
	 * @param listener IOutputChangedListener listener
	 */
	public void removeOutputChangedListener(IOutputChangedListener listener);
	
	/**
	 * Removes a new listener for the OptimizationTerminated event.
	 * @param listener IOptimizationTerminatedListener listener
	 */
	public void addOptimizationTerminatedListener(IOptimizationTerminatedListener listener);
	
	/**
	 * Removes a new listener for the OptimizationTerminated event.
	 * @param listener IOptimizationTerminatedListener listener
	 */
	public void removeOptimizationTerminatedListener(IOptimizationTerminatedListener listener);
	
}