/**
 * 
 */
package de.uka.ipd.sdq.tcfmoop.config;

/**
 * @author Atanas Dimitrov
 * Configuration class for a specific termination criterion
 */
public interface IConfiguration {
	
	/**
	 * Gives every criterion a specific name, so that this can be identified.
	 * @return
	 */
	public TerminationCriteriaNames getTerminationCriterionName();
	
	/**
	 * Checks the configuration object for correctness. Should be called before accessing any of the data of the configuration object
	 * @return true - The configuration is correct
	 * 		   false - The configuration is incomplete or wrong
	 */
	public boolean validateConfiguration();
	
}
