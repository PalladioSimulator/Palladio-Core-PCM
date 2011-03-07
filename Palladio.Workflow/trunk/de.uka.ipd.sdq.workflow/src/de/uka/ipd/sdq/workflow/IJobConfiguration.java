package de.uka.ipd.sdq.workflow;

/**
 * Interface for Configuration Objects used to configure work flow jobs. Each Job should get an IJobConfiguration
 * instance to configure its behaviour. 
 *
 * @author Steffen Becker, Johannes Stammel
 */
public interface IJobConfiguration {

	/**
	 * @return true if the configuration is valid and can be executed, false otherwise
	 */
	public boolean isValid();
	
	/**
	 * @return An error message for the user if the configuration is not valid or null if it is valid
	 */
	public String getErrorMessage();
	
	/**
	 * Sets usefull default values for the configuration object  
	 */
	public void setDefaults();
}
