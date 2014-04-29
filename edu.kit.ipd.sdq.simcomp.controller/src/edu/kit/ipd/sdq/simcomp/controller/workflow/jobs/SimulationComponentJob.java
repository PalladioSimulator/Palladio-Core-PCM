package edu.kit.ipd.sdq.simcomp.controller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.debug.IDebugListener;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.AbstractSimulationJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.BuildPluginJarJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.CompilePluginCodeJob;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs.TransferSimulationBundleToDock;
import edu.kit.ipd.sdq.simcomp.controller.runconfig.SimulationComponentWorkflowConfiguration;

/**
 * The simulation component workflow job. This job generates a nearly empty simulation code project 
 * which only delegates the simulation control to the simulation middleware.
 * 
 * This class is based on {@link EventSimJob}. Some code has been reused.
 * 
 * @author Christoph Föhrdes
 */
public class SimulationComponentJob extends AbstractSimulationJob<SimulationComponentWorkflowConfiguration> {

    public SimulationComponentJob(SimulationComponentWorkflowConfiguration configuration, IDebugListener listener, boolean loadModels)
            throws CoreException {
        super(configuration, listener, loadModels);
    }

    public SimulationComponentJob(SimulationComponentWorkflowConfiguration configuration, IDebugListener listener) throws CoreException {
        super(configuration, listener);
    }

    public SimulationComponentJob(SimulationComponentWorkflowConfiguration configuration) throws CoreException {
        super(configuration);
    }

    @Override
    protected void addSimulatorSpecificJobs(SimulationComponentWorkflowConfiguration configuration) {
        // 1. Generate the plugin's code
        this.addJob(new CreateSimulationComponentMetaDataFilesJob(configuration));
        this.addJob(new CreateSimulationComponentMainFile(configuration));

        // 2. Compile the plugin
        this.addJob(new CompilePluginCodeJob(configuration));

        // 3. Jar the compiled code into a JAR bundle
        BuildPluginJarJob buildBundleJob = new BuildPluginJarJob(configuration);
        this.addJob(buildBundleJob);

        // 4. Transfer the JAR to a free simulation dock and simulate it
        this.addJob(new TransferSimulationBundleToDock(configuration, debugListener, buildBundleJob));
    }

    public String getWorkflowId() {
        return "workflow.extension.simcomp";
    }

}
