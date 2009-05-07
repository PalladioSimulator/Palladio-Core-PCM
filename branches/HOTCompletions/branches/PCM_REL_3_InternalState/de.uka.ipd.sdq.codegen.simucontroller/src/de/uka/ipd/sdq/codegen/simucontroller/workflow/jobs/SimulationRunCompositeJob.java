package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.Map;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunch;
import org.eclipse.debug.core.model.IDebugTarget;

import de.uka.ipd.sdq.codegen.simucontroller.debug.SimulationDebugTarget;
import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuAttributesGetMethods;
import de.uka.ipd.sdq.codegen.workflow.IJobWithResult;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.jobs.GenerateOAWCodeJob;
import de.uka.ipd.sdq.simucomframework.SimuComConfig;

/**
 * Composite of all jobs belonging to the simulation run.
 * The jobs depend on each other, thus an order preserving implementation
 * of the composite job is chosen for the implementation.
 * 
 * @author Philipp Meier
 */
public class SimulationRunCompositeJob extends OrderPreservingCompositeJob {

	public SimulationRunCompositeJob(SimuAttributesGetMethods attributes,
			boolean isDebug, ILaunch launch)
	throws JobFailedException, CoreException {
		this(attributes,1,isDebug,launch);
	}
	
	/**
	 * @param attributes -
	 *            defines the methods, the return SimuCom special variable from the
	 *            LaunchConfiguration-Object.
	 * @param i The run number in case of multiple simulation runs
	 * 
	 * @throws CoreException
	 * @throws JobFailedException
	 */
	public SimulationRunCompositeJob(SimuAttributesGetMethods attributes, int runNo,
			boolean isDebug, ILaunch launch)
			throws JobFailedException, CoreException {

		// 2. Create new Eclipse plugin project
		CreatePluginProjectJob createPluginProjectJob = new CreatePluginProjectJob(
				runNo > 1 ? attributes.getPluginId() + "." + runNo : attributes.getPluginId(),
				attributes.isDeleteProject());
		this.addJob(createPluginProjectJob);

		// 3. Generate the plugin's code using oAW
		Map<String, String> p = attributes.getOAWWorkflowProperties(runNo);
		GenerateOAWCodeJob generatePluginCodeJob = new GenerateOAWCodeJob(p);
		this.addJob(generatePluginCodeJob);

		// 4. Compile the plugin
		this.addJob(new CompilePluginCodeJob(createPluginProjectJob));

		// 5. Jar the compiled code into a JAR bundle
		IJobWithResult<byte[]> buildBundleJob = new BuildPluginJar(createPluginProjectJob);
		this.addJob(buildBundleJob);
		
		// 6. Transfer the JAR to a free simulation dock and simulate it
		SimuComConfig simuConfig = new SimuComConfig(attributes.getSimuComProperties(),runNo,isDebug);
		this.addJob(new TransferSimulationBundleToDock(buildBundleJob,simuConfig,launch));
	}

	public String getName() {
		return "Simulation Run";
	}
}
