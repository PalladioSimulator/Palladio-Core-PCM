package de.uka.ipd.sdq.pcmsolver.runconfig;

import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public class PCMSolverWorkflowRunConfiguration extends
		AbstractPCMWorkflowRunConfiguration {

	public PCMSolverWorkflowRunConfiguration() {
		super();
	}
	
	private ILaunchConfiguration rawConfiguration;

	public void setRawConfig(ILaunchConfiguration configuration) {
		this.rawConfiguration = configuration;		
	}

	public ILaunchConfiguration getRawConfiguration(){
		return rawConfiguration;
	}

	public boolean isReliabilityAnalysis() {
		return false;
	}
}
