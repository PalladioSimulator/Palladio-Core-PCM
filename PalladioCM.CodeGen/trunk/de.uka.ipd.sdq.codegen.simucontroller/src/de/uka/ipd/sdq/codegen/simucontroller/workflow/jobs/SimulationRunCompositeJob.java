package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;

import de.uka.ipd.sdq.codegen.simucontroller.runconfig.SimuAttributesGetMethods;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.jobs.CheckOAWConstraintsJob;
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

	/**
	 * @param attributes -
	 *            defines the methods, the return SimuCom special variable from the
	 *            LaunchConfiguration-Object.
	 * 
	 * @throws CoreException
	 * @throws JobFailedException
	 */
	public SimulationRunCompositeJob(SimuAttributesGetMethods attributes)
			throws JobFailedException, CoreException {

		CheckOAWConstraintsJob checkOAWConstraintsJob = new CheckOAWConstraintsJob(
				attributes.getFiles(), attributes.isShouldThrowException());
		this.addJob(checkOAWConstraintsJob);

		CreatePluginProjectJob createPluginProjectJob = new CreatePluginProjectJob(
				attributes.isDeleteProject());
		this.addJob(createPluginProjectJob);

		GenerateOAWCodeJob generatePluginCodeJob = new GenerateOAWCodeJob(
				attributes.getOAWWorkflowProperties());
		this.addJob(generatePluginCodeJob);

		this.addJob(new CompilePluginCodeJob(createPluginProjectJob));
		this.addJob(new LoadPluginJob(createPluginProjectJob));

		SimuComConfig simuConfig = new SimuComConfig(attributes
				.getSimuComProperties());
		this.addJob(new SimulateJob(simuConfig));
	}

	public String getName() {
		return "Simulation Run";
	}
}
