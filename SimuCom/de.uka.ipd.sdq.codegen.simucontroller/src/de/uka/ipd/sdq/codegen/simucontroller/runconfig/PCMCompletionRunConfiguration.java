package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.Map;

import de.uka.ipd.sdq.cip.configuration.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * A CompletionConfiguration for PCM workflows.
 * 
 * @author Thomas Schuischel
 *
 */
public class PCMCompletionRunConfiguration extends CompletionConfiguration {
	
	/**
	 * Creates a new PCMCompletionRunConfiguration
	 * @param pcmconfig the AbstractCodeGenerationWorkflowRunConfiguration derived configuration
	 * @param configuration the configuration map
	 */
	public PCMCompletionRunConfiguration(AbstractCodeGenerationWorkflowRunConfiguration pcmconfig, Map<String, Object> configuration) {
			super(configuration);
			setInputPartitionName(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
			setProjectID(pcmconfig.getPluginID());
	}
}
