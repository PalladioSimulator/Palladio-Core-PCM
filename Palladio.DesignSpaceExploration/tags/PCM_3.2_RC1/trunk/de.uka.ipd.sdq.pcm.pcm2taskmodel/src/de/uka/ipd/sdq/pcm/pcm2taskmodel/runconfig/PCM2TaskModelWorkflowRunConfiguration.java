package de.uka.ipd.sdq.pcm.pcm2taskmodel.runconfig;

import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public class PCM2TaskModelWorkflowRunConfiguration extends AbstractPCMWorkflowRunConfiguration {
	
	String designDecisionFileName = "";
	String taskmodelResulTFile = "";

	public String getDesignDecisionFileName() {
		return designDecisionFileName;
	}

	public void setDesignDecisionFileName(String designDecisionFileName) {
		this.designDecisionFileName = designDecisionFileName;
	}

	public String getTaskmodelResultFile() {
		return taskmodelResulTFile;
	}

	public void setTaskmodelResultFile(String taskmodelResulTFile) {
		this.taskmodelResulTFile = taskmodelResulTFile;
	}

	public PCM2TaskModelWorkflowRunConfiguration() {
		super();
	}

	@Override
	public String getErrorMessage() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setDefaults() {
		// TODO Auto-generated method stub
		
	}

}
