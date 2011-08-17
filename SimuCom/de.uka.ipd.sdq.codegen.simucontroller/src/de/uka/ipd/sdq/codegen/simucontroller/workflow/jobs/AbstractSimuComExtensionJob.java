package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import de.uka.ipd.sdq.workflow.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public abstract class AbstractSimuComExtensionJob implements IBlackboardInteractingJob<MDSDBlackboard> {
	
	/**
	 * The configuration of the workflow.
	 */
	protected AbstractPCMWorkflowRunConfiguration configuration = null;
	
	public void setConfiguration(AbstractPCMWorkflowRunConfiguration configuration) {
		this.configuration = configuration;
	}

}
