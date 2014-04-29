package edu.kit.ipd.sdq.simcomp.component;

import java.util.Map;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;

/**
 * Represents a configuration for a simulation component based simulation.
 * 
 * @author Christoph Föhrdes
 */
public interface ISimulationConfiguration extends ISimulationConfig {

	/**
	 * Gives access to the path of the usage PCM model.
	 * 
	 * @return Path to the usage model file
	 */
	public String getUsageModelFile();

	/**
	 * Gives access to the path of the allocation model.
	 * 
	 * @return Path to the allocation model file
	 */
	public String getAllocationModelFile();

	/**
	 * Gives access to the raw configuration map as created at simulation launch.
	 * 
	 * @return A map of configuration keys and values
	 */
	public Map<String, Object> getConfigurationMap();

	/**
	 * Indicates if the simulation is in debug mode or not.
	 * 
	 * @return true if in debug or false if not.
	 */
	public boolean isDebug();

}
