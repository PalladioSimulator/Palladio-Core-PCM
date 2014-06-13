package edu.kit.ipd.sdq.simcomp.config;

import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;

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
	 * Returns the default simulation component to use for a given required
	 * interface.
	 * 
	 * @param requiredType
	 *            The required interface to fetch the default component for
	 * @return Metadata object of the simulation component to use
	 */
	public SimulationComponentImpl getDefaultComponentForRequiredType(SimulationComponentRequiredType requiredType);

	/**
	 * Returns a list of composition rules to determine the simulation component
	 * to use for a given required interface.
	 * 
	 * @param requiredType
	 *            The type to search the rules for
	 * @return A list of composition rules
	 */
	public List<ISimulatorCompositonRule> getCompositionRulesForRequiredType(SimulationComponentRequiredType requiredType);

	/**
	 * Gives access to the raw configuration map as created at simulation
	 * launch.
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

	public long[] getRandomSeed();

}
