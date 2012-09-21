package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationWorkflowConfiguration;
import de.uka.ipd.sdq.simucomframework.model.SimuComModel;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractWorkflowExtensionJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractPCMWorkflowRunConfiguration;

public abstract class AbstractSimuComExtensionJob extends AbstractWorkflowExtensionJob<MDSDBlackboard> {
	
	/**
	 * The configuration of the workflow. Maybe we don't want this configuration
	 * to be accessible.
	 */
	protected AbstractPCMWorkflowRunConfiguration configuration = null;

	private SimuComModel simuComModel = null;

	/**
	 * The original simulation workflow configuration object. Is not directly readable or writable
	 * for subclasses.
	 */
	private AbstractSimulationWorkflowConfiguration abstractSimulationWorkflowConfiguration = null;
	
	public void setConfiguration(AbstractPCMWorkflowRunConfiguration configuration) {
		this.configuration = configuration;
	}
	
	public SimuComModel getSimuComModel() {
		return simuComModel;
	}

	public void setSimuComModel(SimuComModel simuComModel) {
		this.simuComModel = simuComModel;
	}
	
	public void initialize(AbstractSimulationWorkflowConfiguration abstractSimulationWorkflowConfiguration) {
		this.abstractSimulationWorkflowConfiguration = abstractSimulationWorkflowConfiguration;
	}

	protected void addCodeGenerationAdvice(String advice) {
		abstractSimulationWorkflowConfiguration.addCodeGenerationAdvice(advice);
	}
	
	protected void addCodeGenerationRequiredBundle(String bundleid) {
		abstractSimulationWorkflowConfiguration.addRequiredBundle(bundleid);
	}

}
