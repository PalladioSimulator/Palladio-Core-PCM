package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.List;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;


/**
 */
public class SimuComWorkflowConfiguration 
extends AbstractPCMCompletionWorkflowRunConfiguration{

	private SimuComConfig simuComConfig = null;
	private SensitivityAnalysisConfiguration sensitivityAnalysisConfiguration = null;
	private boolean sensitivityAnalysisEnabled;
	private boolean simulateLinkingResources;
	private boolean simulateFailures;
	
	private String featureConfigFile;

	public boolean isSensitivityAnalysisEnabled() {
		return sensitivityAnalysisEnabled;
	}

	public SimuComConfig getSimuComConfiguration() {
		return simuComConfig ;
	}

	public SensitivityAnalysisConfiguration getSensitivityAnalysisConfiguration() {
		if (!isSensitivityAnalysisEnabled())
			throw new UnsupportedOperationException("GetSensitivityAnalysisConfiguration is only supported if isSensitivityAnaysisEnabled is true!");

		return sensitivityAnalysisConfiguration ;
	}

	public void setSimuComConfiguration(SimuComConfig simuComConfig) {
		checkFixed();
		this.simuComConfig = simuComConfig;
	}

	public void setSensitivityAnalysisEnabled(boolean sensitivityAnalysisEnabled) {
		checkFixed();
		this.sensitivityAnalysisEnabled = sensitivityAnalysisEnabled;
	}

	public boolean getSimulateLinkingResources() {
		return simulateLinkingResources;
	}

	public void setSimulateLinkingResources(boolean simulateLinkingResources) {
		checkFixed();
		this.simulateLinkingResources = simulateLinkingResources;
	}

	public boolean getSimulateFailures() {
		return simulateFailures;
	}

	public void setSimulateFailures(boolean simulateFailures) {
		checkFixed();
		this.simulateFailures = simulateFailures;
	}
	
	public void setSensitivityAnalysisConfiguration(
			SensitivityAnalysisConfiguration sensitivityConfig) {
		checkFixed();
		this.sensitivityAnalysisConfiguration = sensitivityConfig;
		
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
	 * @return Returns the filename of the mark model instance containing the PCM connector completion configuration
	 */
	public String getFeatureConfigFile() {
		return featureConfigFile;
	}

	/** Sets the filename of the mark model for connector completions
	 * @param featureConfigFile File name of the connector completion file
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
	


}
