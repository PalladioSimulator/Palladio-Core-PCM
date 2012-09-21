package de.uka.ipd.sdq.cip.runtime.workflow.jobs;

import java.util.Map;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComExtensionConfigurationBuilder;
import de.uka.ipd.sdq.simucomframework.SimuComConfigExtension;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtensionJobConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

public class CompletionExtensionConfigurationBuilder extends SimuComExtensionConfigurationBuilder {

	@Override
	public AbstractExtensionJobConfiguration buildConfiguration(Map<String, Object> attributes) {
		CompletionExtensionConfiguration completionSimuComConfigExtension = new CompletionExtensionConfiguration();
		CompletionConfiguration completionConfiguration = new CompletionConfiguration(attributes); 
		completionConfiguration.setInputPartitionName(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		//completionConfiguration.setProjectID(pcmconfig.getStoragePluginID());
		completionSimuComConfigExtension.setCompletionConfiguration(completionConfiguration);
		return completionSimuComConfigExtension;
	}

	@Override
	public SimuComConfigExtension deriveSimuComConfigExtension(Map<String,Object> attributes) {
		return null;
	}
	

}
