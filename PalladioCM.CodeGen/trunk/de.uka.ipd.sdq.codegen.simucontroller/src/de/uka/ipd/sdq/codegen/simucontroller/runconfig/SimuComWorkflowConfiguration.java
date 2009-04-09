package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;


/**
 */
public class SimuComWorkflowConfiguration 
extends AbstractCodeGenerationWorkflowRunConfiguration {

	private SimuComConfig simuComConfig = null;
	private SensitivityAnalysisConfiguration sensitivityAnalysisConfiguration = null;
	private boolean sensitivityAnalysisEnabled;
	private boolean simulateLinkingResources;

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

	public void setSensitivityAnalysisConfiguration(
			SensitivityAnalysisConfiguration sensitivityConfig) {
		checkFixed();
		this.sensitivityAnalysisConfiguration = sensitivityConfig;
		
	}
}
