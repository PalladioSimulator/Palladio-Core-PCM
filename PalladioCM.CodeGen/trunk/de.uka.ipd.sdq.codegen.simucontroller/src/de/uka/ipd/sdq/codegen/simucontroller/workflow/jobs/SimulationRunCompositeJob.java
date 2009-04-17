package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuComWorkflowConfiguration;
import de.uka.ipd.sdq.codegen.simucontroller.workflow.MDSDBlackboard;
import de.uka.ipd.sdq.codegen.workflow.IJobWithResult;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingBlackboardCompositeJob;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * Composite of all jobs belonging to the simulation run.
 * The jobs depend on each other, thus an order preserving implementation
 * of the composite job is chosen for the implementation.
 * 
 * @author Philipp Meier
 * 		   Steffen Becker
 */
public class SimulationRunCompositeJob 
extends OrderPreservingBlackboardCompositeJob<MDSDBlackboard> {

	public SimulationRunCompositeJob(SimuComWorkflowConfiguration configuration) throws CoreException {
		this(configuration,1);
	}
	
	public SimulationRunCompositeJob(SimuComWorkflowConfiguration configuration, int runNo)
			throws CoreException {

		// 2. Create new Eclipse plugin project
		CreatePluginProjectJob createPluginProjectJob = new CreatePluginProjectJob(
				runNo > 1 ? configuration.getGeneratedPluginId() + "." + runNo : configuration.getGeneratedPluginId(),
				configuration.shouldDeleteGeneratedCodeOnCleanup());
		this.addJob(createPluginProjectJob);

		// 3. Generate the plugin's code using oAW
		GenerateOAWCodeJob generatePluginCodeJob = new GenerateOAWCodeJob(configuration);
		this.addJob(generatePluginCodeJob);

		// 4. Compile the plugin
		this.addJob(new CompilePluginCodeJob(createPluginProjectJob));

		// 5. Jar the compiled code into a JAR bundle
		IJobWithResult<byte[]> buildBundleJob = new BuildPluginJar(createPluginProjectJob);
		this.addJob(buildBundleJob);
		
		// 6. Transfer the JAR to a free simulation dock and simulate it
		SimuComConfig simuConfig = configuration.getSimuComConfiguration();
		this.addJob(new TransferSimulationBundleToDock(buildBundleJob,simuConfig,null /*TODO: launch!!*/ ));
	}

	public String getName() {
		return "Single Simulation Run";
	}
}
