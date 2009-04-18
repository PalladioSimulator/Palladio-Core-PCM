package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import de.uka.ipd.sdq.codegen.runconfig.ConstantsContainer;

public abstract class AbstractCodeGenerationWorkflowRunConfiguration 
extends	AbstractPCMWorkflowRunConfiguration {

	private boolean cleanupCode = false;
	private String pluginID = ConstantsContainer.PLUGIN_ID;
	
	public boolean shouldDeleteGeneratedCodeOnCleanup() {
		return cleanupCode;
	}

	public void setCleanupCode(boolean cleanupCode) {
		checkFixed();
		this.cleanupCode = cleanupCode;
	}

	public String getPluginID() {
		return pluginID;
	}

	public void setPluginID(String pluginID) {
		checkFixed();
		this.pluginID = pluginID;
	}
	
	
}
