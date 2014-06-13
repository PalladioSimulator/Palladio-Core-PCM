package edu.kit.ipd.sdq.simcomp.config;

import java.util.Map;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationContextField;

/**
 * Represents a rules for the dynamic simulation component composition
 * 
 * @author Christoph Föhrdes
 *
 */
public interface ISimulatorCompositonRule {
	
	public static String ANY_VALUE = "*";

	public SimulationComponentRequiredType getRequiredType();

	public Map<SimulationContextField, String> getFieldValues();
	
	public SimulationComponentImpl getComponent();
}
