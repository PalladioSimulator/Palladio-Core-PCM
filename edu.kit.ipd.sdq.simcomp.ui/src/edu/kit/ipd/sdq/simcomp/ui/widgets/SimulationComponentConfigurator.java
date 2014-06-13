package edu.kit.ipd.sdq.simcomp.ui.widgets;

import java.util.HashMap;
import java.util.Map;

import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Group;

import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentRequiredType;
import edu.kit.ipd.sdq.simcomp.config.ISimulationComponentConfiguration;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationComponentConfiguration;
import edu.kit.ipd.sdq.simcomp.ui.listener.IModificationListener;

public class SimulationComponentConfigurator {

	private SimulationComponentImpl simCompImpl;
	private ISimulationMiddleware middleware;

	private Map<SimulationComponentRequiredType, SimulationCompositionRuleEditor> ruleEditors;
	private IModificationListener modificationListener;

	public SimulationComponentConfigurator(Composite parent, SimulationComponentImpl simCompImpl, ISimulationMiddleware middleware, IModificationListener modificationListener) {
		this.simCompImpl = simCompImpl;
		this.middleware = middleware;
		this.modificationListener = modificationListener;

		ruleEditors = new HashMap<SimulationComponentRequiredType, SimulationCompositionRuleEditor>();

		createControl(parent);
	}

	private void createControl(Composite parent) {
		Group configuratorContainer = new Group(parent, SWT.NONE);
		configuratorContainer.setLayoutData(new GridData(GridData.FILL_HORIZONTAL));
		configuratorContainer.setLayout(new GridLayout(1, false));
		configuratorContainer.setText("Simulation Component Implementation: " + simCompImpl.getName());

		// create a rule editor for each required interface
		for (SimulationComponentRequiredType requiredType : simCompImpl.getRequiredTypes()) {
			SimulationCompositionRuleEditor ruleEditor = new SimulationCompositionRuleEditor(configuratorContainer, requiredType, middleware, modificationListener);

			ruleEditors.put(requiredType, ruleEditor);
		}
	}

	public void updatePCMModel(IPCMModel model) {
		for (SimulationComponentRequiredType requiredType : ruleEditors.keySet()) {
			SimulationCompositionRuleEditor ruleEditor = ruleEditors.get(requiredType);

			ruleEditor.updatePCMModel(model);
		}
	}

	public void updateComponentConfiguration(ISimulationComponentConfiguration componentConfig) {
		if (componentConfig == null) {
			return;
		}
			
		for (SimulationComponentRequiredType requiredType : ruleEditors.keySet()) {
			SimulationCompositionRuleEditor ruleEditor = ruleEditors.get(requiredType);

			ruleEditor.updateDefaultComponent(componentConfig.getDefaultComponentForRequiredType(requiredType));
			ruleEditor.updateCompositionRules(componentConfig.getCompositionRulesForRequiredType(requiredType));
		}
	}

	public ISimulationComponentConfiguration getComponentConfiguration() {
		SimulationComponentConfiguration config = new SimulationComponentConfiguration(simCompImpl);

		for (SimulationComponentRequiredType requiredType : ruleEditors.keySet()) {
			SimulationCompositionRuleEditor ruleEditor = ruleEditors.get(requiredType);

			config.setDefaultComponentForRequiredType(requiredType, ruleEditor.getDefaultComponent());
			config.setCompositionRuleForRequiredType(requiredType, ruleEditor.getCompositionRules());
		}

		return config;
	}

}
