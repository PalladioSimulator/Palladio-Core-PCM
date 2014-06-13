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
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentImpl;
import edu.kit.ipd.sdq.simcomp.config.ISimulationComponentConfiguration;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.PCMModel;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.config.SimulationConfiguration;
import edu.kit.ipd.sdq.simcomp.ui.listener.IModificationListener;
import edu.kit.ipd.sdq.simcomp.ui.widgets.SimulationComponentConfigurator;

/**
 * A launch configuration tab which configures the simulator composition rules
 * for a simulation component based simulation run.
 * 
 * @author Christoph Föhrdes
 * 
 */
public class SimulationComponentConfigTab extends AbstractLaunchConfigurationTab {

	private static final Logger logger = Logger.getLogger(SimulationComponentConfigTab.class);

	private ISimulationMiddleware middleware;
	private List<SimulationComponentImpl> simCompImplementations;
	private Map<SimulationComponentImpl, SimulationComponentConfigurator> simCompConfigurators;

	private URI loadedUsageUri = null;
	private URI loadedAllocationUri = null;
	private IPCMModel pcmModel = null;


	public SimulationComponentConfigTab() {
		middleware = Activator.getDefault().getSimCompUiComponent().getSimulationMiddleware();
		simCompImplementations = middleware.getSimulationComponentMetadata();

		simCompConfigurators = new HashMap<SimulationComponentImpl, SimulationComponentConfigurator>();
	}

	@Override
	public void createControl(Composite parent) {
		IModificationListener modificationListener = new IModificationListener() {

			@Override
			public void modified() {
				updateLaunchConfigurationDialog();
			}
		};

		Composite simCompConfig = new Composite(parent, SWT.NONE);
		simCompConfig.setLayout(new GridLayout(1, false));

		Label label = new Label(simCompConfig, SWT.NONE);
		label.setText("Simulator Composition Configuration\n(Only simulation components with required interfaces are configurable):\n");

		// create a configuration editor for each simulation component
		for (SimulationComponentImpl simCompImpl : this.simCompImplementations) {
			if (!simCompImpl.getRequiredTypes().isEmpty()) {
				SimulationComponentConfigurator configurator = new SimulationComponentConfigurator(simCompConfig, simCompImpl, middleware, modificationListener);
				simCompConfigurators.put(simCompImpl, configurator);
			}
		}

		setControl(simCompConfig);
	}

	@SuppressWarnings("unchecked")
	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		// try to load PCM model from user configuration
		loadPcmModel(configuration);

		// read from persisted configuration
		HashMap<SimulationComponentImpl, ISimulationComponentConfiguration> componentsConfig = new HashMap<SimulationComponentImpl, ISimulationComponentConfiguration>();
		String serializedConfig = "";
		try {
			serializedConfig = configuration.getAttribute(SimulationConfiguration.CONFIG_KEY_SIMULATION_COMPONENTS_CONFIG, "");
		} catch (CoreException e) {
			e.printStackTrace();
		}
		if (!serializedConfig.isEmpty()) {
			componentsConfig = (HashMap<SimulationComponentImpl, ISimulationComponentConfiguration>) ConfigHelper.deserializeObject(serializedConfig);
		}

		// update component configurators
		for (SimulationComponentImpl componentImpl : simCompConfigurators.keySet()) {
			SimulationComponentConfigurator configurator = simCompConfigurators.get(componentImpl);
			
			configurator.updatePCMModel(pcmModel);
			configurator.updateComponentConfiguration(componentsConfig.get(componentImpl));
		}

		this.validate(configuration);
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		HashMap<SimulationComponentImpl, ISimulationComponentConfiguration> componentsConfig = new HashMap<SimulationComponentImpl, ISimulationComponentConfiguration>();

		for (SimulationComponentImpl componentImpl : simCompConfigurators.keySet()) {
			SimulationComponentConfigurator configurator = simCompConfigurators.get(componentImpl);

			ISimulationComponentConfiguration config = configurator.getComponentConfiguration();
			componentsConfig.put(componentImpl, config);
		}

		configuration.setAttribute(SimulationConfiguration.CONFIG_KEY_SIMULATION_COMPONENTS_CONFIG, ConfigHelper.serializeObject(componentsConfig));
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {

		// story empty map as default value
		HashMap<SimulationComponentImpl, ISimulationComponentConfiguration> componentsConfig = new HashMap<SimulationComponentImpl, ISimulationComponentConfiguration>();
		configuration.setAttribute(SimulationConfiguration.CONFIG_KEY_SIMULATION_COMPONENTS_CONFIG, ConfigHelper.serializeObject(componentsConfig));
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

	@Override
	public Image getImage() {
		ImageDescriptor imageDesc = Activator.imageDescriptorFromPlugin(Activator.PLUGIN_ID, "icons/app_simcomp.gif");

		return imageDesc.createImage();
	}

}
