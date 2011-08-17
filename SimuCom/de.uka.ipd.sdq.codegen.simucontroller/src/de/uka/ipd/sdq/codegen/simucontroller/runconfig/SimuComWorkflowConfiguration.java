package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.List;

import org.apache.log4j.Logger;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.pcm.runconfig.AccuracyInfluenceAnalysisState;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ExperimentRunDescriptor;
import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;

/**
 */
public class SimuComWorkflowConfiguration extends
		AbstractPCMCompletionWorkflowRunConfiguration implements Cloneable {
	/** Logger for this class. */
	private static final Logger logger = Logger.getLogger(SimuComWorkflowConfiguration.class);

	private SimuComConfig simuComConfig = null;
	private boolean simulateLinkingResources;
	private boolean simulateFailures;

	private String featureConfigFile;

	public SimuComConfig getSimuComConfiguration() {
		return simuComConfig;
	}

	public void setSimuComConfiguration(SimuComConfig simuComConfig) {
		checkFixed();
		this.simuComConfig = simuComConfig;
		this.simulateFailures = simuComConfig.getSimulateFailures();
		this.simulateLinkingResources = simuComConfig
				.getSimulateLinkingResources();
	}

	public boolean getSimulateLinkingResources() {
		return simulateLinkingResources;
	}

	@Override
	public void setAccuracyInfluenceAnalysisState(
			AccuracyInfluenceAnalysisState accuracyInfluenceAnalysisState) {
		super.setAccuracyInfluenceAnalysisState(accuracyInfluenceAnalysisState);
		if (isAccuracyInfluenceAnalysisEnabled()) {
			simuComConfig.setAdditionalExperimentRunDescription(" (" + getAccuracyInfluenceAnalysisState() + ")");
		}
	}

	public void setSimulateLinkingResources(boolean simulateLinkingResources) {
		checkFixed();
		this.simulateLinkingResources = simulateLinkingResources;
		this.setLoadMiddlewareAndCompletionFiles(simulateLinkingResources);
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

	/**
	 * @return Returns the filename of the mark model instance containing the
	 *         PCM connector completion configuration
	 */
	public String getFeatureConfigFile() {
		return featureConfigFile;
	}

	/**
	 * Sets the filename of the mark model for connector completions
	 *
	 * @param featureConfigFile
	 *            File name of the connector completion file
	 */
	public void setFeatureConfigFile(String featureConfigFile) {
		checkFixed();
		this.featureConfigFile = featureConfigFile;
	}

	/**
	 * Call super.getPCMModelFiles and then add my own featureconfig file.
	 */
	@Override
	public List<String> getPCMModelFiles() {
		List<String> pcmModelFiles = super.getPCMModelFiles();

		if (featureConfigFile != null)
			pcmModelFiles.add(featureConfigFile);

		return pcmModelFiles;
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
		config.featureConfigFile = new String(this.featureConfigFile);
		config.simuComConfig = this.simuComConfig.getClone();
		config.simulateFailures = this.simulateFailures;
		config.simulateLinkingResources = this.simulateLinkingResources;
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
