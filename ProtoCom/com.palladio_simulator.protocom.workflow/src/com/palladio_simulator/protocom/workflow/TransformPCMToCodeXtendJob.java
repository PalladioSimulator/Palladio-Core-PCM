package com.palladio_simulator.protocom.workflow;

import java.util.HashMap;

import org.eclipse.core.runtime.IProgressMonitor;

import de.uka.ipd.sdq.pcm.repository.Repository;
import de.uka.ipd.sdq.pcm.usagemodel.UsageScenario;
import de.uka.ipd.sdq.workflow.jobs.CleanupFailedException;
import de.uka.ipd.sdq.workflow.jobs.IBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.jobs.JobFailedException;
import de.uka.ipd.sdq.workflow.jobs.SequentialBlackboardInteractingJob;
import de.uka.ipd.sdq.workflow.jobs.UserCanceledException;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.blackboard.PCMResourceSetPartition;
import de.uka.ipd.sdq.workflow.pcm.configurations.AbstractCodeGenerationWorkflowRunConfiguration;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

import com.google.inject.Guice;
import com.google.inject.Injector;
import com.palladio_simulator.protocom.traverse.framework.CommonConfigurationModule;
import com.palladio_simulator.protocom.traverse.framework.allocation.XAllocation;
import com.palladio_simulator.protocom.traverse.framework.repository.XRepository;
import com.palladio_simulator.protocom.traverse.framework.resourceenvironment.XResourceEnvironment;
import com.palladio_simulator.protocom.traverse.framework.system.XSystem;
import com.palladio_simulator.protocom.traverse.framework.usage.XUsageScenario;
import com.palladio_simulator.protocom.traverse.jee.JeeConfigurationModule;
import com.palladio_simulator.protocom.traverse.jse.JseConfigurationModule;


public class TransformPCMToCodeXtendJob extends
		SequentialBlackboardInteractingJob<MDSDBlackboard> implements IJob,
		IBlackboardInteractingJob<MDSDBlackboard> {

	protected ProtoComGenerationConfiguration configuration;

	public TransformPCMToCodeXtendJob(
			ProtoComGenerationConfiguration configuration) {
		this.configuration = configuration;
	}

	@Override
	public void execute(IProgressMonitor monitor) throws JobFailedException,
			UserCanceledException {
		
		CommonConfigurationModule guiceConfiguration = null;
		
		if (configuration.getCodeGenerationAdvice() == AbstractCodeGenerationWorkflowRunConfiguration.CodeGenerationAdvice.PROTO) {
			guiceConfiguration = new JseConfigurationModule();
		} 
		
		else if (configuration.getCodeGenerationAdvice() == AbstractCodeGenerationWorkflowRunConfiguration.CodeGenerationAdvice.EJB3) {
			guiceConfiguration = new JeeConfigurationModule();
		} 

		guiceConfiguration.setProjectURI(configuration.getStoragePluginID());
		Injector injector = Guice.createInjector(guiceConfiguration);
		
		// Repository
		for (int repositoryIndex = 0; repositoryIndex < getRepositoryCount(); repositoryIndex++) {
			getRepositoryTransformationSlots(repositoryIndex);
		}
		
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		
		for (Repository content : pcmPartition.getRepositories()) {
			injector.getInstance(XRepository.class).setEntity(content).transform();
		}
		
		// System
		injector.getInstance(XSystem.class).setEntity(pcmPartition.getSystem()).transform();
		
		// Allocation
		injector.getInstance(XAllocation.class).setEntity(pcmPartition.getAllocation()).transform();

		// Resource Environment
		injector.getInstance(XResourceEnvironment.class).setEntity(pcmPartition.getResourceEnvironment()).transform();
		
		// Usage
		for (UsageScenario scenario : pcmPartition.getUsageModel().getUsageScenario_UsageModel()) {
			injector.getInstance(XUsageScenario.class).setEntity(scenario).transform();
		}

		
	}

	@Override
	public void cleanup(IProgressMonitor monitor) throws CleanupFailedException {

	}

	@Override
	public String getName() {
		return "Generate ProtoCom Plugin Code";
	}

	private int getRepositoryCount() {
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard
				.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		return pcmPartition.getRepositories().size();
	}

	/**
	 * @return Creates a HashMap with all slots required for the transformation
	 *         of {@link Repository}.
	 */
	private HashMap<String, Object> getRepositoryTransformationSlots(
			int repositoryIndex) {
		HashMap<String, Object> sC2 = new HashMap<String, Object>();
		PCMResourceSetPartition pcmPartition = (PCMResourceSetPartition) this.myBlackboard
				.getPartition(LoadPCMModelsIntoBlackboardJob.PCM_MODELS_PARTITION_ID);
		sC2.put("pcmmodel", pcmPartition.getRepositories().get(repositoryIndex));
		return sC2;
	}

	
}
