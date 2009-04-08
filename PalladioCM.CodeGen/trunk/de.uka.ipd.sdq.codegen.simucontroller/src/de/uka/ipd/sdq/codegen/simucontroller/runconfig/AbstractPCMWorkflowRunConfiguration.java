package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;
import java.util.List;

import de.uka.ipd.sdq.codegen.runconfig.AbstractWorkflowBasedRunConfiguration;

public abstract class AbstractPCMWorkflowRunConfiguration 
extends	AbstractWorkflowBasedRunConfiguration {
	
	private String resourceTypeFile;
	private String repositoryFile;
	private String middlewareFile;
	private String systemFile;
	private String allocationFile;
	private String usageModelFile;
	private String featureConfigFile;

	public List<String> getPCMModelFiles() {
		ArrayList<String> files = new ArrayList<String>();
		files.add(this.resourceTypeFile);
		files.add(this.repositoryFile);
		files.add(middlewareFile);
		files.add(systemFile);
		files.add(allocationFile);
		files.add(usageModelFile);
		return files;
	}

	public String getResourceTypeFile() {
		return resourceTypeFile;
	}

	public void setResourceTypeFile(String resourceTypeFile) {
		checkFixed();
		this.resourceTypeFile = resourceTypeFile;
	}

	public String getRepositoryFile() {
		return repositoryFile;
	}

	public void setRepositoryFile(String repositoryFile) {
		checkFixed();
		this.repositoryFile = repositoryFile;
	}

	public String getMiddlewareFile() {
		return middlewareFile;
	}

	public void setMiddlewareFile(String middlewareFile) {
		checkFixed();
		this.middlewareFile = middlewareFile;
	}

	public String getSystemFile() {
		return systemFile;
	}

	public void setSystemFile(String systemFile) {
		checkFixed();
		this.systemFile = systemFile;
	}

	public String getAllocationFile() {
		return allocationFile;
	}

	public void setAllocationFile(String allocationFile) {
		checkFixed();
		this.allocationFile = allocationFile;
	}

	public String getUsageModelFile() {
		return usageModelFile;
	}

	public void setUsageModelFile(String usageModelFile) {
		checkFixed();
		this.usageModelFile = usageModelFile;
	}

	public String getFeatureConfigFile() {
		return featureConfigFile;
	}

	public void setFeatureConfigFile(String featureConfigFile) {
		checkFixed();
		this.featureConfigFile = featureConfigFile;
	}
	
}
