package de.uka.ipd.sdq.codegen.simucontroller.runconfig;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EPackage;

import de.uka.ipd.sdq.codegen.runconfig.AbstractWorkflowBasedRunConfiguration;
import de.uka.ipd.sdq.completions.CompletionsPackage;
import de.uka.ipd.sdq.pcm.allocation.AllocationPackage;
import de.uka.ipd.sdq.pcm.core.CorePackage;
import de.uka.ipd.sdq.pcm.parameter.ParameterPackage;
import de.uka.ipd.sdq.pcm.repository.RepositoryPackage;
import de.uka.ipd.sdq.pcm.resourceenvironment.ResourceenvironmentPackage;
import de.uka.ipd.sdq.pcm.resourcetype.ResourcetypePackage;
import de.uka.ipd.sdq.pcm.seff.SeffPackage;
import de.uka.ipd.sdq.pcm.system.SystemPackage;
import de.uka.ipd.sdq.pcm.usagemodel.UsagemodelPackage;
import de.uka.ipd.sdq.stoex.StoexPackage;

public abstract class AbstractPCMWorkflowRunConfiguration 
extends	AbstractWorkflowBasedRunConfiguration {
	
	public static final EPackage[] PCM_EPACKAGES = new EPackage[]{
			SeffPackage.eINSTANCE,
			RepositoryPackage.eINSTANCE,
			ParameterPackage.eINSTANCE,
			UsagemodelPackage.eINSTANCE,
			SystemPackage.eINSTANCE,
			ResourcetypePackage.eINSTANCE,
			ResourceenvironmentPackage.eINSTANCE,
			AllocationPackage.eINSTANCE,
			StoexPackage.eINSTANCE,
			CorePackage.eINSTANCE,
			CompletionsPackage.eINSTANCE,
		};
	
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
		files.add(featureConfigFile);
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

	@Override
	public void validateAndFreeze() {
		super.validateAndFreeze();
	}
}
