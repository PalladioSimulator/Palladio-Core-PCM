package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.simulation.AbstractSimulationConfig;
import de.uka.ipd.sdq.workflow.pcm.runconfig.AccuracyInfluenceAnalysisState;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ExperimentRunDescriptor;
import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;

/**
 */
public class SimuComWorkflowConfiguration extends AbstractSimulationWorkflowConfiguration {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(SimuComWorkflowConfiguration.class);

	private SimuComConfig simuComConfig = null;
	
	private boolean simulateFailures;
	
	
	/**
	 * Constructor requiring to set the ILaunchConfiguration and mode this configuration is running in.
	 * This is necessary to realize the extendability of the simucom workflow with additional jobs
	 * using the extension points provided by the palladio workflow engine.
	 * 
	 * @param launchConfiguration The launch configuration object to be provided to the extending jobs.
	 * @param mode The mode of the workflow currently runs in (run/debug)
	 */
	public SimuComWorkflowConfiguration(Map<String, Object> attributes) {
	    super(attributes);
	}
	
	

	public AbstractSimulationConfig getSimulationConfiguration() {
		return simuComConfig;
	}

	public void setSimuComConfiguration(SimuComConfig simuComConfig) {
		checkFixed();
		this.simuComConfig = simuComConfig;
		this.simulateFailures = simuComConfig.getSimulateFailures();
        this.setSimulateLinkingResources(simuComConfig.getSimulateLinkingResources());
	}

	@Override
	public void setAccuracyInfluenceAnalysisState(
			AccuracyInfluenceAnalysisState accuracyInfluenceAnalysisState) {
		super.setAccuracyInfluenceAnalysisState(accuracyInfluenceAnalysisState);
		if (isAccuracyInfluenceAnalysisEnabled()) {
			simuComConfig.setAdditionalExperimentRunDescription(" (" + getAccuracyInfluenceAnalysisState() + ")");
		}
	}

	public boolean getSimulateFailures() {
		return simulateFailures;
	}

	public void setSimulateFailures(boolean simulateFailures) {
		checkFixed();
		this.simulateFailures = simulateFailures;
	}

	public String getErrorMessage() {
		// must be null; otherwise a non-empty error message will result in
		// a workflow config being considered invalid
		return null;
	}

	public void setDefaults() {
		throw new RuntimeException("Not implemented. No defaults defined.");
	}

	public SimuComWorkflowConfiguration copy(
			List<SensitivityAnalysisConfiguration> sconfList) {
		SimuComWorkflowConfiguration result;
		try {
			result = (SimuComWorkflowConfiguration) clone();
		} catch (CloneNotSupportedException e) {
			logger.fatal("Could not clone configuration.", e);
			result = null;
		}

		String name = this.simuComConfig.getNameBase();
		ExperimentRunDescriptor descriptor = new ExperimentRunDescriptor(name,
				sconfList);
		result.simuComConfig = this.simuComConfig.copy(descriptor);
		result.sensitivityAnalysisConfigurationList = sconfList;
		return result;
	}

	@Override
	protected Object clone() throws CloneNotSupportedException {
		SimuComWorkflowConfiguration config = (SimuComWorkflowConfiguration) super.clone();
		config.simuComConfig = this.simuComConfig.getClone();
		config.simulateFailures = this.simulateFailures;
		return config;
	}

	/**
	 * @return A clone of this instance.
	 */
	public SimuComWorkflowConfiguration getClone() {
		SimuComWorkflowConfiguration config;
		try {
			config = (SimuComWorkflowConfiguration) this.clone();
		} catch (CloneNotSupportedException e) {
			logger.fatal("Could not clone configuration.", e);
			config = null;
		}
		return config;
	}

}
