package de.uka.ipd.sdq.simucom.rerunsimulation.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimuComExtensionJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.BuildPluginJarJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CompilePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.DetermineFailureTypesJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.TransferSimulationBundleToDock;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.WorkflowHooks;
import de.uka.ipd.sdq.simucom.rerunsimulation.runconfig.RerunSimuComWorkflowConfiguration;
import de.uka.ipd.sdq.workflow.extension.AbstractExtendableJob;
import de.uka.ipd.sdq.workflow.jobs.IJob;
import de.uka.ipd.sdq.workflow.mdsd.blackboard.MDSDBlackboard;
import de.uka.ipd.sdq.workflow.pcm.jobs.LoadPCMModelsIntoBlackboardJob;

/**
 * Every job that is needed for rerunning a simulation is added in this class
 * 
 * @author Michael Junker
 *
 */
public class RerunSimulationJob extends AbstractExtendableJob<MDSDBlackboard> {

    public RerunSimulationJob(SimuComWorkflowConfiguration configuration, IDebugListener listener) throws CoreException {
        super(false);

        if (listener == null && configuration.isDebug()) {
            throw new IllegalArgumentException("Debug listener has to be non-null for debug runs");
        }
        addJobs(listener, configuration);
    }

    private void addJobs(IDebugListener listener, SimuComWorkflowConfiguration configuration) {
        this.addJob(new LoadPCMModelsIntoBlackboardJob(configuration));

        // 1. Initialize Failure Type Information
        this.add(new DetermineFailureTypesJob(configuration));

        // All Workflow extension de.uka.ipd.sdq.simucom.rerunsimulation.jobs with the extension
        // hook id
        // WORKFLOW_ID_BEFORE_CODEGENERATION
        handleJobExtensions(WorkflowHooks.WORKFLOW_ID_BEFORE_CODEGENERATION, configuration);

        // 2. Regenerate code if necessary
        if (configuration instanceof RerunSimuComWorkflowConfiguration) {
            RerunSimuComWorkflowConfiguration config = (RerunSimuComWorkflowConfiguration) configuration;
            this.addJob(new XtendTransformPCMToCodeJobRerun(config));
        }

        // 3. Compile the plugin
        this.addJob(new CompilePluginCodeJob(configuration));

        // 4. Jar the compiled code into a JAR bundle
        BuildPluginJarJob buildBundleJob = new BuildPluginJarJob(configuration);
        this.addJob(buildBundleJob);

        // All Workflow extension de.uka.ipd.sdq.simucom.rerunsimulation.jobs with the extension
        // hook id
        // WORKFLOW_ID_BEFORE_DOCK
        handleJobExtensions(WorkflowHooks.WORKFLOW_ID_BEFORE_DOCK, configuration);

        // 5. Transfer the JAR to a free simulation dock and simulate it
        this.addJob(new TransferSimulationBundleToDock(configuration, listener, buildBundleJob));
 //       this.addJob(new CallGeneratedMainDirectlyJob(configuration));

        // All Workflow extension de.uka.ipd.sdq.simucom.rerunsimulation.jobs with the extension
        // hook id
        // WORKFLOW_ID_AFTER_SIMULATION
        handleJobExtensions(WorkflowHooks.WORKFLOW_ID_AFTER_SIMULATION, configuration);

        // Initialize all Workflow extension de.uka.ipd.sdq.simucom.rerunsimulation.jobs
        for (IJob extensionJob : myJobs) {
            if (extensionJob instanceof AbstractSimuComExtensionJob) {
                ((AbstractSimuComExtensionJob) extensionJob).initialize(configuration);
                ((AbstractSimuComExtensionJob) extensionJob).setConfiguration(configuration);
            }
        }
    }
}
