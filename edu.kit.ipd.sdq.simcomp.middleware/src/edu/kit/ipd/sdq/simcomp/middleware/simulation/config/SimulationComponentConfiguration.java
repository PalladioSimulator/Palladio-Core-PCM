package edu.kit.ipd.sdq.simcomp.middleware.simulation.config;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;
import edu.kit.ipd.sdq.simcomp.config.ISimulationComponentConfiguration;
import edu.kit.ipd.sdq.simcomp.config.ISimulatorCompositonRule;

public class SimulationComponentConfiguration implements ISimulationComponentConfiguration, Serializable {

	private static final long serialVersionUID = -4194071854778497865L;

	private SimulationComponentImpl component;

	private Map<SimulationComponentRequiredType, SimulationComponentImpl> defaultComponentMap;
	private Map<SimulationComponentRequiredType, List<ISimulatorCompositonRule>> compositionRuleMap;

	public SimulationComponentConfiguration(SimulationComponentImpl component) {
		this.component = component;

		defaultComponentMap = new HashMap<SimulationComponentRequiredType, SimulationComponentImpl>();
		compositionRuleMap = new HashMap<SimulationComponentRequiredType, List<ISimulatorCompositonRule>>();
	}

	@Override
	public SimulationComponentImpl getDefaultComponentForRequiredType(SimulationComponentRequiredType requiredType) {
		return defaultComponentMap.get(requiredType);
	}

	public void setDefaultComponentForRequiredType(SimulationComponentRequiredType requiredType, SimulationComponentImpl component) {
		defaultComponentMap.put(requiredType, component);
	}
	
	public void setCompositionRuleForRequiredType(SimulationComponentRequiredType requiredType, List<ISimulatorCompositonRule> rules) {
		compositionRuleMap.put(requiredType, rules);
	}

	public void addCompositionRuleForRequiredType(SimulationComponentRequiredType requiredType, ISimulatorCompositonRule rule) {
		List<ISimulatorCompositonRule> ruleList = compositionRuleMap.get(requiredType);
		if (ruleList == null) {
			ruleList = new ArrayList<ISimulatorCompositonRule>();
		}
		ruleList.add(rule);
	}

	@Override
	public List<ISimulatorCompositonRule> getCompositionRulesForRequiredType(SimulationComponentRequiredType requiredType) {
		return compositionRuleMap.get(requiredType);
	}

	public SimulationComponentImpl getComponent() {
		return component;
	}

}
