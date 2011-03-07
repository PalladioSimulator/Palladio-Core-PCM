/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.tcmanager;

import java.util.List;

import org.opt4j.core.optimizer.OptimizerIterationListener;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;

/**
 * @author Atanas Dimitrov
 *
 */
public interface ITerminationCriteriaManager extends OptimizerIterationListener{
	
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
	 * Evaluates the termination criteria.
	 */
	public void evaluateTerminationCriteria();
	
	/**
	 * Returns the criteria output information.
	 * @return String with output information.
	 */
	public String getOutputInformation();	
	
}