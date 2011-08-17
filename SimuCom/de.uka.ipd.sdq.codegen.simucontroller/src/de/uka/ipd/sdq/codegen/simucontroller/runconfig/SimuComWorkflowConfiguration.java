package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.List;

import de.uka.ipd.sdq.simucomframework.SimuComConfig;
import de.uka.ipd.sdq.workflow.pcm.runconfig.ExperimentRunDescriptor;
import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;


/**
 */
public class SimuComWorkflowConfiguration 
extends AbstractPCMCompletionWorkflowRunConfiguration {

	private SimuComConfig simuComConfig = null;
	private boolean simulateLinkingResources;
	private boolean simulateFailures;
	
	private String featureConfigFile;

	public SimuComConfig getSimuComConfiguration() {
		return simuComConfig ;
	}

	public void setSimuComConfiguration(SimuComConfig simuComConfig) {
		checkFixed();
		this.simuComConfig = simuComConfig;
	}

	public boolean getSimulateLinkingResources() {
		return simulateLinkingResources;
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
	
	public SimuComWorkflowConfiguration copy(List<SensitivityAnalysisConfiguration> sconfList)  {
		SimuComWorkflowConfiguration result = new SimuComWorkflowConfiguration();
		
		String name = this.simuComConfig.getNameBase();
		ExperimentRunDescriptor descriptor = new ExperimentRunDescriptor(name, sconfList);
		
		result.simuComConfig = this.simuComConfig.copy(descriptor);
		result.sensitivityAnalysisConfigurationList = sconfList;
		
		result.allocationFiles = this.allocationFiles;
		result.cleanupCode = this.cleanupCode;
		result.codeGenerationAdvice = this.codeGenerationAdvice;
		result.completionConfiguration = this.completionConfiguration;
		result.featureConfigFile = this.featureConfigFile;
		result.isDebug = this.isDebug;
		result.isFixed = this.isFixed;
		result.isInteractive = this.isInteractive;
		result.loadMiddlewareAndCompletionFiles = this.loadMiddlewareAndCompletionFiles;
		result.middlewareFile = this.middlewareFile;
		result.overwriteWithoutAsking = this.overwriteWithoutAsking;
		result.pluginID = this.pluginID;
		result.sensitivityAnalysisEnabled = this.sensitivityAnalysisEnabled;
		result.simulateFailures = this.simulateFailures;
		result.simulateLinkingResources = this.simulateLinkingResources;
		result.usageModelFile = this.usageModelFile;
		return result;
	}

}
