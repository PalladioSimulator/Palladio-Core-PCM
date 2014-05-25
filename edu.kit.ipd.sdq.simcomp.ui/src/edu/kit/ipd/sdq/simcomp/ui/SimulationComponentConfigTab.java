package edu.kit.ipd.sdq.simcomp.ui;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.ModifyEvent;
import org.eclipse.swt.events.ModifyListener;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentMetaData;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.PCMModel;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationConfiguration;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulatiorCompositonRule;

/**
 * This launch configuration tab configures the advanced composition rules for a
 * simulation component based simulation run.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulationComponentConfigTab extends AbstractLaunchConfigurationTab {

	private static final Logger logger = Logger.getLogger(SimulationComponentConfigTab.class);

	private List<SimulationComponentType> simCompTypes;
	private ISimulationMiddleware middleware;
	private Map<SimulationComponentType, SimulationComponentRuleEditor> ruleEditors;

	private URI loadedUsageUri = null;
	private URI loadedAllocationUri = null;
	private IPCMModel pcmModel = null;

	public SimulationComponentConfigTab() {
		middleware = Activator.getDefault().getSimCompUiComponent().getSimulationMiddleware();
		simCompTypes = middleware.getSimulationComponentMetaData();

		ruleEditors = new HashMap<SimulationComponentType, SimulationComponentRuleEditor>();
	}

	@Override
	public void createControl(Composite parent) {
		ModifyListener modificationListener = new ModifyListener() {

			@Override
			public void modifyText(ModifyEvent e) {
				updateLaunchConfigurationDialog();
			}

		};

		Composite simCompConfig = new Composite(parent, SWT.NONE);
		simCompConfig.setLayout(new GridLayout(1, false));

		Label label = new Label(simCompConfig, SWT.NONE);
		label.setText("Advanced Simulation Component Configuration:");

		// create rule editor for each type
		for (SimulationComponentType simCompType : this.simCompTypes) {
			ruleEditors.put(simCompType, new SimulationComponentRuleEditor(simCompConfig, simCompType, modificationListener));
		}

		setControl(simCompConfig);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// try to load PCM model from user configuration
		loadPcmModel(configuration);

		// read current configuration
		Map<SimulationComponentType, SimulationComponentMetaData> defaultComponentsConfig = null;
		Map<SimulationComponentType, List<SimulatiorCompositonRule>> compositionRulesConfig = null;
		try {
			// grab the default component configuration (Map Component Type ->
			// Default Component)
			String serializedMap = configuration.getAttribute(SimulationConfiguration.CONFIG_KEY_DEFAULT_COMPONENTS, "");
			if (!serializedMap.isEmpty()) {
				defaultComponentsConfig = (Map<SimulationComponentType, SimulationComponentMetaData>) ConfigHelper.deserializeObject(serializedMap);
			}
			// grab composition rules configuration (Map Component Type -> List
			// of composition rules)
			serializedMap = configuration.getAttribute(SimulationConfiguration.CONFIG_KEY_COMPOSITION_RULES, "");
			if (!serializedMap.isEmpty()) {
				compositionRulesConfig = (Map<SimulationComponentType, List<SimulatiorCompositonRule>>) ConfigHelper.deserializeObject(serializedMap);
			}

		} catch (CoreException e) {
			e.printStackTrace();
		}

		// add default empty map if empty
		if (defaultComponentsConfig == null) {
			defaultComponentsConfig = new HashMap<SimulationComponentType, SimulationComponentMetaData>();
		}
		if (compositionRulesConfig == null) {
			compositionRulesConfig = new HashMap<SimulationComponentType, List<SimulatiorCompositonRule>>();
		}

		// update the rule editors
		for (SimulationComponentType componentType : this.ruleEditors.keySet()) {
			SimulationComponentRuleEditor ruleEditor = this.ruleEditors.get(componentType);

			ruleEditor.updatePCMModel(this.pcmModel);
			ruleEditor.updateDefaultComponent(defaultComponentsConfig.get(componentType));
			ruleEditor.updateCompositionRules(compositionRulesConfig.get(componentType));
		}

		this.validate(configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		HashMap<SimulationComponentType, SimulationComponentMetaData> defaultComponentsConfig = new HashMap<SimulationComponentType, SimulationComponentMetaData>();
		HashMap<SimulationComponentType, List<SimulatiorCompositonRule>> compositionRulesConfig = new HashMap<SimulationComponentType, List<SimulatiorCompositonRule>>();

		for (SimulationComponentType componentType : this.ruleEditors.keySet()) {
			SimulationComponentRuleEditor ruleEditor = this.ruleEditors.get(componentType);

			SimulationComponentMetaData defaultcomponent = ruleEditor.getDefaultComponent();
			defaultComponentsConfig.put(componentType, defaultcomponent);
			List<SimulatiorCompositonRule> compositionRules = ruleEditor.getCompositionRules();
			compositionRulesConfig.put(componentType, compositionRules);
		}

		configuration.setAttribute(SimulationConfiguration.CONFIG_KEY_DEFAULT_COMPONENTS, ConfigHelper.serializeObject(defaultComponentsConfig));
		configuration.setAttribute(SimulationConfiguration.CONFIG_KEY_COMPOSITION_RULES, ConfigHelper.serializeObject(compositionRulesConfig));

	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		// specify some empty config maps as default values
		HashMap<SimulationComponentType, SimulationComponentMetaData> defaultComponentsConfig = new HashMap<SimulationComponentType, SimulationComponentMetaData>();
		HashMap<SimulationComponentType, List<SimulatiorCompositonRule>> compositionRulesConfig = new HashMap<SimulationComponentType, List<SimulatiorCompositonRule>>();

		configuration.setAttribute(SimulationConfiguration.CONFIG_KEY_DEFAULT_COMPONENTS, ConfigHelper.serializeObject(defaultComponentsConfig));
		configuration.setAttribute(SimulationConfiguration.CONFIG_KEY_COMPOSITION_RULES, ConfigHelper.serializeObject(compositionRulesConfig));
	}

	/**
	 * Validates the state of the current launch configuration and displays some
	 * some errors or warnings if necessary.
	 */
	private void validate(ILaunchConfiguration configuration) {
		// check if we have a loaded PCM model
		if (pcmModel == null) {
			this.setErrorMessage("No valid PCM model selected! Provide a usage and allocation model to enable advanced simulation configuration.");
		} else {
			this.setErrorMessage(null);
		}

		// check if the simulation component simulator is selected
		String selectedSimulatorId = "";
		try {
			selectedSimulatorId = configuration.getAttribute(AbstractSimulationConfig.SIMULATOR_ID, "");
		} catch (CoreException e) {
			e.printStackTrace();
		}
		if (!selectedSimulatorId.equals(SimulationConfiguration.SIMULATION_COMPONENT_SIMULATOR_ID)) {
			this.setWarningMessage("You have to select the \"Simulation Components\" simulator implementation or the advanced configuration will be ignored in your simulation run.");
		} else {
			this.setWarningMessage(null);
		}

	}

	/**
	 * Tries to load the PCM model based on the launch configuration. If the
	 * user has not selected any model information yet or the model could not be
	 * loaded the method will return null instead of the PCM model.
	 * 
	 * @param configuration
	 * @return The PCM model selected by the user or null if it could not be
	 *         found/loaded
	 */
	private void loadPcmModel(ILaunchConfiguration configuration) {

		if (logger.isDebugEnabled()) {
			logger.debug("Loading PCM model for advanced simulator configuration");
		}

		String usageModelFile = null;
		String allocationModelFile = null;
		try {
			usageModelFile = configuration.getAttribute(ConstantsContainer.USAGE_FILE, "");
			allocationModelFile = configuration.getAttribute(ConstantsContainer.ALLOCATION_FILE, "");
		} catch (CoreException e) {
			logger.error("Error while reading usage and allocation file from launch configuration");
			this.pcmModel = null;
		}

		// skip if one or both files are missing
		if (usageModelFile == null || usageModelFile.isEmpty() || allocationModelFile == null || allocationModelFile.isEmpty()) {
			this.loadedUsageUri = null;
			this.loadedAllocationUri = null;
			this.pcmModel = null;

			return;
		}

		// use specified some files
		URI usageUri = URI.createURI(usageModelFile);
		URI allocationUri = URI.createURI(allocationModelFile);

		// skip if nothing has changed
		if (this.pcmModel != null && usageUri.equals(this.loadedUsageUri) && allocationUri.equals(this.loadedAllocationUri)) {
			return;
		}

		// something changed, load model from specified files
		this.pcmModel = PCMModel.loadFromUri(usageUri, allocationUri);
		this.loadedUsageUri = usageUri;
		this.loadedAllocationUri = allocationUri;
	}

	@Override
	public String getName() {
		return "Simulation Components";
	}

}
