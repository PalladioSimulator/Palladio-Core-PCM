package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import java.util.Map;

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

	public SimulationRunCompositeJob(SimuAttributesGetMethods attributes)
	throws JobFailedException, CoreException {
		this(attributes,1);
	}
	
	/**
	 * @param attributes -
	 *            defines the methods, the return SimuCom special variable from the
	 *            LaunchConfiguration-Object.
	 * @param i 
	 * 
	 * @throws CoreException
	 * @throws JobFailedException
	 */
	public SimulationRunCompositeJob(SimuAttributesGetMethods attributes, int runNo)
			throws JobFailedException, CoreException {

		Map<String, Object> properties = attributes.getSimuComProperties();
		if (properties.get(SimuComConfig.RUN_NUMBER) == null)
			properties.put(SimuComConfig.RUN_NUMBER, runNo);

		CheckOAWConstraintsJob checkOAWConstraintsJob = new CheckOAWConstraintsJob(
				attributes.getFiles(), attributes.isShouldThrowException());
		this.addJob(checkOAWConstraintsJob);

		CreatePluginProjectJob createPluginProjectJob = new CreatePluginProjectJob(
				attributes.isDeleteProject());
		this.addJob(createPluginProjectJob);

		Map<String, String> p = attributes.getOAWWorkflowProperties();
		p.put(SimuComConfig.RUN_NUMBER, runNo+"");
		GenerateOAWCodeJob generatePluginCodeJob = new GenerateOAWCodeJob(p);
		this.addJob(generatePluginCodeJob);

		SimuComConfig simuConfig = new SimuComConfig(properties);
		this.addJob(new CompilePluginCodeJob(createPluginProjectJob));
		//this.addJob(new LoadPluginJob(createPluginProjectJob));
		//this.addJob(new SimulateJob(simuConfig));
		this.addJob(new TransferSimulationBundleToDock(createPluginProjectJob,simuConfig));
	}

	public String getName() {
		return "Simulation Run";
	}
}
