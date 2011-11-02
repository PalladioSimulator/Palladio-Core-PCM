package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.workflow.IJobWithResult;

/**
 * Main job for the SDQ workflow engine which will run a SimuComSimulation
 * @author Steffen
 */
public class SimuComJob extends AbstractSimulationJob<SimuComWorkflowConfiguration> {

    public SimuComJob(SimuComWorkflowConfiguration configuration, IDebugListener listener, boolean loadModels)
            throws CoreException {
        super(configuration, listener, loadModels);
    }

    public SimuComJob(SimuComWorkflowConfiguration configuration, IDebugListener listener) throws CoreException {
        super(configuration, listener);
    }

    public SimuComJob(SimuComWorkflowConfiguration configuration) throws CoreException {
        super(configuration);
    }

    @Override
    protected void addSimulatorSpecificJobs(SimuComWorkflowConfiguration configuration) {
        // 1. Initialize Failure Type Information
        this.add(new DetermineFailureTypesJob(configuration));
        
        // 2. Generate the plugin's code using oAW
        this.addJob(new TransformPCMToCodeJob(configuration));
        this.addJob(new CreateSimuComMetaDataFilesJob(configuration));

        // 3. Compile the plugin
        this.addJob(new CompilePluginCodeJob(configuration));

        // 4. Jar the compiled code into a JAR bundle
        IJobWithResult<byte[]> buildBundleJob = new BuildPluginJarJob(configuration);
        this.addJob(buildBundleJob);
        
        handleJobExtensions(WorkflowHooks.WORKFLOW_ID_BEFORE_DOCK,configuration);

        // 5. Transfer the JAR to a free simulation dock and simulate it
        this.addJob(new TransferSimulationBundleToDock(configuration, debugListener, buildBundleJob));
    }
    
    public String getWorkflowId() {
        return "workflow.extension.simucom"; 
    }
    
}