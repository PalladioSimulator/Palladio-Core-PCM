package edu.kit.ipd.sdq.simcomp.config;

import java.util.List;
import java.util.Map;

import de.uka.ipd.sdq.simulation.abstractsimengine.ISimulationConfig;
import edu.kit.ipd.sdq.simcomp.component.ISimulationComponent;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentMeta;

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
	 * Returns information about the default simulation component for a given
	 * simulation component type.
	 * 
	 * @param type
	 *            The type to fetch the default component for
	 * @return Meta data about the default simulation component
	 */
	public SimulationComponentMeta getDefaultComponentForComponentType(Class<? extends ISimulationComponent> type);

	/**
	 * Returns the simulator composition rules for a given simulation component
	 * type
	 * 
	 * @param type
	 *            The type to search the rules for
	 * @return A List of simulator composition rules
	 */
	public List<ISimulatorCompositonRule> getCompositionRulesForComponentType(Class<? extends ISimulationComponent> type);

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

}
