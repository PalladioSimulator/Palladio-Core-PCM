package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractWorkflowExtensionJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public abstract class AbstractSimuComExtensionJob extends AbstractWorkflowExtensionJob<MDSDBlackboard> {
	
	/**
	 * The configuration of the workflow.
	 */
	protected AbstractPCMWorkflowRunConfiguration configuration = null;
	
	public void setConfiguration(AbstractPCMWorkflowRunConfiguration configuration) {
		this.configuration = configuration;
	}
	
	private SimuComModel simuComModel = null;

	public SimuComModel getSimuComModel() {
		return simuComModel;
	}

	public void setSimuComModel(SimuComModel simuComModel) {
		this.simuComModel = simuComModel;
	}

}
