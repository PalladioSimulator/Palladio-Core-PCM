package de.uka.ipd.sdq.cip.launchconfig;

import java.util.List;

import de.uka.ipd.sdq.cip.runconfig.CompletionConfiguration;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;

public abstract class AbstractPCMCompletionWorkflowRunConfiguration extends
		AbstractCodeGenerationWorkflowRunConfiguration {

	private CompletionConfiguration completionConfig = null;
	private String featureConfigFile;
	
	public void setCompletionConfig(CompletionConfiguration completionConfig) {
		this.completionConfig = completionConfig;
	}

	public CompletionConfiguration getCompletionConfig() {
		return completionConfig;
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
