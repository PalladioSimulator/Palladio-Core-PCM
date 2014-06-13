package edu.kit.ipd.sdq.simcomp.config;

import java.util.List;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;

/**
 * Represents the configuration for a simulation component implementation
 * 
 * @author Christoph Föhrdes
 *
 */
public interface ISimulationComponentConfiguration {

	public SimulationComponentImpl getDefaultComponentForRequiredType(SimulationComponentRequiredType requiredType);

	public List<ISimulatorCompositonRule> getCompositionRulesForRequiredType(SimulationComponentRequiredType requiredType);

}
