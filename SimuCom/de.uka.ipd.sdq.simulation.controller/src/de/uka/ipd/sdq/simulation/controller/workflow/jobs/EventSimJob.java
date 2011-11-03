package de.uka.ipd.sdq.simulation.controller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimulationJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.BuildPluginJarJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CompilePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.SimuComJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.TransferSimulationBundleToDock;
import de.uka.ipd.sdq.simulation.controller.runconfig.EventSimWorkflowConfiguration;
import de.uka.ipd.sdq.workflow.IJobWithResult;

/**
 * This class is based on {@link SimuComJob}. Some code has been reused.
 * 
 * @author Philipp Merkle
 * 
 */
public class EventSimJob extends AbstractSimulationJob<EventSimWorkflowConfiguration> {

    public EventSimJob(EventSimWorkflowConfiguration configuration, IDebugListener listener, boolean loadModels)
            throws CoreException {
        super(configuration, listener, loadModels);
    }

    public EventSimJob(EventSimWorkflowConfiguration configuration, IDebugListener listener) throws CoreException {
        super(configuration, listener);
    }

    public EventSimJob(EventSimWorkflowConfiguration configuration) throws CoreException {
        super(configuration);
    }

    @Override
    protected void addSimulatorSpecificJobs(EventSimWorkflowConfiguration configuration) {
        // 1. Generate the plugin's code
        this.addJob(new CreateEventSimMetaDataFilesJob(configuration));
        this.addJob(new CreateSimulationMainFile(configuration));

        // 2. Compile the plugin
        this.addJob(new CompilePluginCodeJob(configuration));

        // 3. Jar the compiled code into a JAR bundle
        IJobWithResult<byte[]> buildBundleJob = new BuildPluginJarJob(configuration);
        this.addJob(buildBundleJob);

        // 4. Transfer the JAR to a free simulation dock and simulate it
        this.addJob(new TransferSimulationBundleToDock(configuration, debugListener, buildBundleJob));
    }

    public String getWorkflowId() {
        return "workflow.extension.eventsim";
    }

}
