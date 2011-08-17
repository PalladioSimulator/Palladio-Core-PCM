/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.terminationcriteria;

import org.opt4j.core.Archive;
import org.opt4j.core.Population;

import de.uka.ipd.sdq.tcfmoop.config.IConfiguration;

/**
 * @author Atanas Dimitrov
 *
 */
public interface ITerminationCriterion {
	
	/**
	 * Initializes the termination criteria by supplying it with the configuration object and other needed resources.
	 * @param conf - The configuration object.
	 * @param population - The current Population
	 * @param archive - A reference to the archive
	 * @throws RuntimeException if the configuration object is not fully initialized.
	 */
	public void initialize(IConfiguration conf,
						   Population population,
						   Archive archive);
	
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
	public StringBuilder getOutputInformation();	
	
}
