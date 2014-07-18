package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.fzi.se.accuracy.jobs.TransformPCMForAccuracyInfluenceAnalysisJob;
import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.AbstractSimulationWorkflowConfiguration;
import de.uka.ipd.sdq.pcm.transformations.ApplyConnectorCompletionsJob;
import de.uka.ipd.sdq.workflow.extension.AbstractExtendableJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.CreatePluginProjectJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.CreateWorkingCopyOfModelsJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.EventsTransformationJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadMiddlewareConfigurationIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.StoreAllPCMModelsJob;
import de.uka.ipd.sdq.workflow.pcm.jobs.ValidatePCMModelsJob;

/**
 * Abstract job for launching a Palladio simulation. Each concrete simulator provides an
 * implementation of this class.
 * 
 * @author Steffen
 * @author Philipp Merkle
 * 
 */
public abstract class AbstractSimulationJob<C extends AbstractSimulationWorkflowConfiguration> extends
        AbstractExtendableJob<MDSDBlackboard> {

    protected IDebugListener debugListener = null;

    public AbstractSimulationJob(C configuration, IDebugListener listener) throws CoreException {
        this(configuration, listener, true);

    }

    public AbstractSimulationJob(C configuration) throws CoreException {
        this(configuration, null);
    }

    public AbstractSimulationJob(C configuration, IDebugListener listener, boolean loadModels) throws CoreException {
        super(false);

        if (listener == null && configuration.isDebug()) {
            throw new IllegalArgumentException("Debug listener has to be non-null for debug runs");
        }
        this.debugListener = listener;

        // Stage Preparation
        // 0. Create plug-in project for simulation
        this.add(new CreatePluginProjectJob(configuration));
        
        // 1. Load PCM Models into memory        
        if (loadModels == true) {
            this.addJob(new LoadPCMModelsIntoBlackboardJob(configuration));            
            this.addJob(new LoadMiddlewareConfigurationIntoBlackboardJob(configuration));            
        }
        // store models in temporary eclipse plug-in
        this.add(new CreateWorkingCopyOfModelsJob(configuration));
        
        // 2. Validate PCM Models
        this.addJob(new ValidatePCMModelsJob(configuration));

        // All Workflow extension jobs with the extension hook id
        // WORKFLOW_ID_AFTER_LOAD_VALIDATE
        handleJobExtensions(WorkflowHooks.WORKFLOW_ID_AFTER_LOAD_VALIDATE, configuration);

        // -- Stage Model modification
        // 3.1 Modification for AccuracyInfluenceAnalysis
        if (configuration.isAccuracyInfluenceAnalysisEnabled()) {
            this.add(new TransformPCMForAccuracyInfluenceAnalysisJob(configuration));
        }

        // 3.2 Modifications for SensitivityAnalysis
        if (configuration.isSensitivityAnalysisEnabled()) {
            this.add(new TransformPCMForSensitivityAnalysisJob(configuration));
        }

        // 4. Apply Completions
        // this.add(new CompletionJob(configuration));

        // 5. Transform Event Model Elements
        this.add(new EventsTransformationJob(configuration));

        // 6. Apply connector completion transformation
        if (configuration.getSimulateLinkingResources()) {
            this.addJob(new ApplyConnectorCompletionsJob(configuration));
        }

        // -- Stage analysis
        // 7. Store resulting model(s)
        this.add(new StoreAllPCMModelsJob(configuration));

        this.addSimulatorSpecificJobs(configuration);
    }

    protected abstract void addSimulatorSpecificJobs(C configuration);

}
