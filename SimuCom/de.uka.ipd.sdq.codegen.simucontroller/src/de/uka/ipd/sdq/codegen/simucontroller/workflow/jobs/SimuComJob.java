package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.fzi.se.accuracy.jobs.TransformPCMForAccuracyInfluenceAnalysisJob;
import de.uka.ipd.sdq.cip.workflow.jobs.CompletionJob;
import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.pcm.transformations.ApplyConnectorCompletionsJob;
import de.uka.ipd.sdq.workflow.IJobWithResult;
import de.uka.ipd.sdq.workflow.launchconfig.extension.AbstractExtendableJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.EventsTransformationJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadMiddlewareConfigurationIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.StoreAllPCMModelsJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.ValidatePCMModelsJob;

/**
 * Main job for the SDQ workflow engine which will run a SimuComSimulation
 * @author Steffen
 */
public class SimuComJob extends AbstractExtendableJob<MDSDBlackboard> {
    

	private IDebugListener debugListener = null;

	public SimuComJob(SimuComWorkflowConfiguration configuration, IDebugListener listener) throws CoreException {
		this(configuration, listener, true);

	}

	public SimuComJob(SimuComWorkflowConfiguration configuration) throws CoreException {
		this(configuration,null);
	}

	public SimuComJob(SimuComWorkflowConfiguration configuration, IDebugListener listener, boolean loadModels) throws CoreException {
		super();

		if (listener == null && configuration.isDebug())
			throw new IllegalArgumentException("Debug listener has to be non-null for debug runs");
		this.debugListener = listener;

		// Stage Preparation
		// 1. Load PCM Models into memory
		if (loadModels == true) {
			this.addJob(new LoadPCMModelsIntoBlackboardJob(configuration));
		}
		this.addJob(new LoadMiddlewareConfigurationIntoBlackboardJob(configuration));

		// 2. Validate PCM Models
		this.addJob(new ValidatePCMModelsJob(configuration));
		
		handleJobExtensions(WorkflowHooks.WORKFLOW_ID_AFTER_LOAD_VALIDATE,configuration);

		// -- Stage Model modification
		// 3.1 Modification for AccuracyInfluenceAnalysis
		if (configuration.isAccuracyInfluenceAnalysisEnabled()) {
			this.add(new TransformPCMForAccuracyInfluenceAnalysisJob(configuration));
		}
		
		// 3.2 Modifications for SensitivityAnalysis
		if(configuration.isSensitivityAnalysisEnabled()){
			this.add(new TransformPCMForSensitivityAnalysisJob(configuration));
		}

		// 4. Apply Completions
		this.add(new CompletionJob(configuration));

		// 5. Transform Event Model Elements
		this.add(new EventsTransformationJob(configuration));

		// 6. Initialize Failure Type Information
		this.add(new DetermineFailureTypesJob(configuration));

		// 7. Apply connector completion transformation
		if (configuration.getSimulateLinkingResources()) {
			this.addJob(new ApplyConnectorCompletionsJob(configuration));
		}

		// -- Stage analysis
		// 8. Store resulting model(s)
		this.add(new StoreAllPCMModelsJob(configuration));

		// 9. Generate the plugin's code using oAW
		this.addJob(new TransformPCMToCodeJob(configuration));
		this.addJob(new CreateSimuComMetaDataFilesJob(configuration));

		// 10. Compile the plugin
		this.addJob(new CompilePluginCodeJob(configuration));

		// 11. Jar the compiled code into a JAR bundle
		IJobWithResult<byte[]> buildBundleJob = new BuildPluginJarJob(configuration);
		this.addJob(buildBundleJob);
		
		handleJobExtensions(WorkflowHooks.WORKFLOW_ID_BEFORE_DOCK,configuration);

		// 12. Transfer the JAR to a free simulation dock and simulate it
		this.addJob(new TransferSimulationBundleToDock(configuration, debugListener, buildBundleJob));
	}
	
	public String getWorkflowId() {
		return "workflow.extension.simucom"; 
	}
}