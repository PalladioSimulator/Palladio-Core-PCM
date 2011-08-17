package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.List;

import de.uka.ipd.sdq.workflow.pcm.runconfig.SensitivityAnalysisConfiguration;

public class SimuComWorkflowConfiguration extends AbstractSimulationWorkflowConfiguration {
	
	public String getErrorMessage() {
		// must be null; otherwise a non-empty error message will result in
		// a workflow config being considered invalid
		return null; 
	}

	public void setDefaults() {
		throw new RuntimeException("Not implemented. No defaults defined.");
	}
	
	public SimuComWorkflowConfiguration copy(List<SensitivityAnalysisConfiguration> sconfList)  {
		SimuComWorkflowConfiguration result = new SimuComWorkflowConfiguration();
		
		// TODO
//		String name = getSimulationConfiguration().getNameBase();
//		ExperimentRunDescriptor descriptor = new ExperimentRunDescriptor(name, sconfList);
//		
//		result.simuComConfig = this.simuComConfig.copy(descriptor);
//		result.sensitivityAnalysisConfigurationList = sconfList;
//		
//		result.allocationFiles = this.allocationFiles;
//		result.cleanupCode = this.cleanupCode;
//		result.codeGenerationAdvice = this.codeGenerationAdvice;
//		result.completionConfiguration = this.completionConfiguration;
//		result.featureConfigFile = this.featureConfigFile;
//		result.isDebug = this.isDebug;
//		result.isFixed = this.isFixed;
//		result.isInteractive = this.isInteractive;
//		result.loadMiddlewareAndCompletionFiles = this.loadMiddlewareAndCompletionFiles;
//		result.middlewareFile = this.middlewareFile;
//		result.overwriteWithoutAsking = this.overwriteWithoutAsking;
//		result.pluginID = this.pluginID;
//		result.sensitivityAnalysisEnabled = this.sensitivityAnalysisEnabled;
//		result.simulateFailures = this.simulateFailures;
//		result.simulateLinkingResources = this.simulateLinkingResources;
//		result.usageModelFile = this.usageModelFile;
		return result;
	}

}
