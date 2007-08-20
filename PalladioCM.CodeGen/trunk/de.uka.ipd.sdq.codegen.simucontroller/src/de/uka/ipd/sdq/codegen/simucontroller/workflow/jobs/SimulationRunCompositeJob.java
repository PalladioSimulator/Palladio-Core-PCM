package de.uka.ipd.sdq.codegen.simucontroller.workflow.jobs;

import org.eclipse.core.runtime.CoreException;
import org.eclipse.debug.core.ILaunchConfiguration;

import de.uka.ipd.sdq.codegen.workflow.IJob;
import de.uka.ipd.sdq.codegen.workflow.JobFailedException;
import de.uka.ipd.sdq.codegen.workflow.OrderPreservingCompositeJob;
import de.uka.ipd.sdq.codegen.workflow.RollbackFailedException;
import de.uka.ipd.sdq.codegen.workflow.UserCanceledException;
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
	 * @param configuration the launch configuration
	 * @throws CoreException
	 */
	public SimulationRunCompositeJob(ILaunchConfiguration configuration) throws CoreException {
		assert (configuration != null);
		
		this.addJob(new CheckOAWConstraintsJob(configuration));
		
		CreatePluginProjectJob createPluginProjectJob =
			new CreatePluginProjectJob(configuration);		
		this.addJob(createPluginProjectJob);		
		
		this.addJob(new GeneratePluginCodeJob(configuration));
		this.addJob(new CompilePluginCodeJob(createPluginProjectJob));
		this.addJob(new LoadPluginJob(createPluginProjectJob));

		SimuComConfig simuConfig = new SimuComConfig(configuration.getAttributes());
		this.addJob(new SimulateJob(simuConfig));
	}

	public String getName() {
		return "Simulation Run";
	}
}
