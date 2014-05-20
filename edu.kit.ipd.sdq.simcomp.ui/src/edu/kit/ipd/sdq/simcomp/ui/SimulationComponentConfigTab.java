package edu.kit.ipd.sdq.simcomp.ui;

import java.util.List;

import org.apache.log4j.Logger;
import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;
import org.eclipse.debug.core.ILaunchConfigurationWorkingCopy;
import org.eclipse.debug.ui.AbstractLaunchConfigurationTab;
import org.eclipse.emf.common.util.URI;
import org.eclipse.swt.SWT;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;

import de.uka.ipd.sdq.workflow.pcm.ConstantsContainer;
import edu.kit.ipd.sdq.simcomp.component.IPCMModel;
import edu.kit.ipd.sdq.simcomp.component.ISimulationMiddleware;
import edu.kit.ipd.sdq.simcomp.component.meta.SimulationComponentType;
import edu.kit.ipd.sdq.simcomp.middleware.simulation.PCMModel;

public class SimulationComponentConfigTab extends AbstractLaunchConfigurationTab {

	private static final Logger logger = Logger.getLogger(SimulationComponentConfigTab.class);

	private List<SimulationComponentType> simCompTypes;
	private ISimulationMiddleware middleware;
	private URI loadedUsageUri = null;
	private URI loadedAllocationUri = null;
	private IPCMModel pcmModel = null;

	public SimulationComponentConfigTab() {
		middleware = Activator.getDefault().getSimCompUiComponent().getSimulationMiddleware();
		simCompTypes = middleware.getSimulationComponentMetaData();
	}

	@Override
	public void createControl(Composite parent) {
		System.out.println("createControl");

		Composite simCompConfig = new Composite(parent, SWT.NONE);
		simCompConfig.setLayout(new GridLayout(1, false));

		Label label = new Label(simCompConfig, SWT.NONE);
		label.setText("Advanced Simulation Component Configuration:");

		// create rule editor for each type
		for (SimulationComponentType simCompType : this.simCompTypes) {
			new SimulationComponentRuleEditor(simCompConfig, simCompType);
		}

		setControl(simCompConfig);
	}

	@Override
	public void initializeFrom(ILaunchConfiguration configuration) {
		loadPcmModel(configuration);

		if (pcmModel == null) {
			this.setErrorMessage("No valid model files selected! Provide PCM model for advanced simulation config.");
		}

		System.out.println("initializeFrom");
		// TODO (SimComp): Init GUI from the current config. Check if we can
		// check here on ever tab change if the PCM files where selected
	}

	@Override
	public void performApply(ILaunchConfigurationWorkingCopy configuration) {
		System.out.println("performApply");
		// TODO (SimComp): Store GUI data to config data structure
	}

	@Override
	public void setDefaults(ILaunchConfigurationWorkingCopy configuration) {
		System.out.println("setDefaults");
		// TODO (SimComp): Store default values to config data structure
	}

	@Override
	public String getName() {
		return "Simulation Components";
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
	}

}
